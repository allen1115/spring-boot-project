package com.example.demo.shiro;

import com.example.demo.entity.Module;
import com.example.demo.service.impl.ModuleServiceImpl;
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
    private ModuleServiceImpl moduleService;

    /**
     * 从数据库动态读取权限
     */
    @Override
    public void setFilterChainDefinitions(String definitions) {
        ShiroPermissionFactory.definitions = definitions;
        // 数据库动态权限
        List<Module> sysPermissionInitList = moduleService.findAllModules();
        StringBuilder definitionsBuilder = new StringBuilder(definitions);
        for (Module m : sysPermissionInitList) {
            // 字符串拼接权限
            definitionsBuilder.append(m.getUrl()).append(" = ").append(m.getPermissionInit()).append("\r");
        }
        definitionsBuilder.append("/**").append(" = ").append("authc");
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