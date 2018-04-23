package com.example.demo.shiro;

import com.example.demo.entity.SysPermissionInit;
import com.example.demo.service.impl.SysPermissionInitServiceImpl;
import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroPermissionFactory extends ShiroFilterFactoryBean {

    /** 配置中的过滤链 **/
    private static String definitions;

    /** 权限service **/
    @Autowired
    private SysPermissionInitServiceImpl sysPermissionInitService;

    /**
     * 从数据库动态读取权限
     */
    @Override
    public void setFilterChainDefinitions(String definitions) {
        ShiroPermissionFactory.definitions = definitions;
        // 数据库动态权限
        List<SysPermissionInit> sysPermissionInitList = sysPermissionInitService.selectAll();
        StringBuilder definitionsBuilder = new StringBuilder(definitions);
        for (SysPermissionInit s : sysPermissionInitList) {
            // 字符串拼接权限
            definitionsBuilder.append(s.getUrl()).append(" = ").append(s.getPermissionInit()).append("\r");
        }
        definitions = definitionsBuilder.toString();

        // 从配置文件加载权限配置
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if(CollectionUtils.isEmpty(section)) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }

        // 加入权限集合
        setFilterChainDefinitionMap(section);
    }
}
