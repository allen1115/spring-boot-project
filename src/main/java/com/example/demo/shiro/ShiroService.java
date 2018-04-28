package com.example.demo.shiro;

import com.example.demo.entity.Module;
import com.example.demo.service.impl.ModuleServiceImpl;
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
    ModuleServiceImpl moduleService;

    /**
     * initialize privilege
     */
    private Map<String, String> loadFilterChainDefinitions() {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        List<Module> list = moduleService.findAllModules();

        for (Module m: list) {
            filterChainDefinitionMap.put(m.getUrl(), m.getPermissionInit());
        }
        filterChainDefinitionMap.put("/**", "authc");
        return filterChainDefinitionMap;
    }

    /**
     * reload privilege
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

            // clear old privilege
            manager.getFilterChains().clear();
            shiroPermissionFactory.setFilterChainDefinitionMap(loadFilterChainDefinitions());

            // reload
            Map<String, String> chains = shiroPermissionFactory.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim().replace(" ", "");
                manager.createChain(url, chainDefinition);
            }

            System.out.println("Reload privilege successfully!");
        }
    }
}
