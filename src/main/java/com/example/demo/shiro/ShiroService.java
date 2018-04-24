package com.example.demo.shiro;

import com.example.demo.entity.SysPermissionInit;
import com.example.demo.service.impl.SysPermissionInitServiceImpl;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShiroService {

    @Autowired
    @Qualifier("shiroFilter")
    private ShiroPermissionFactory shiroPermissionFactory;

    @Autowired
    SysPermissionInitServiceImpl sysPermissionInitService;

    /**
     * 初始化权限
     */
    public Map<String, String> loadFilterChainDefinitions() {
        // 权限控制map 从数据库获取
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        List<SysPermissionInit> list = sysPermissionInitService.selectAll();

        for (SysPermissionInit s : list) {
            filterChainDefinitionMap.put(s.getUrl(), s.getPermissionInit());
        }
        return filterChainDefinitionMap;
    }

    /**
     * 重新加载权限
     */
    public void updatePermission() {
        synchronized (shiroPermissionFactory) {
            AbstractShiroFilter shiroFilter = null;
            try {
                shiroFilter = (AbstractShiroFilter) shiroPermissionFactory.getObject();
            } catch (Exception e) {
                throw new RuntimeException("Get ShiroFilter from shiroFilterFactoryBean error!");
            }

            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

            // 清空老的权限控制
            manager.getFilterChains().clear();
            shiroPermissionFactory.setFilterChainDefinitionMap(loadFilterChainDefinitions());

            // 重新构建生成
            Map<String, String> chains = shiroPermissionFactory.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim().replace(" ", "");
                manager.createChain(url, chainDefinition);
            }

            System.out.println("更新权限成功!");
        }
    }
}
