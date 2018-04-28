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

    /** definitions is use **/
    private static String definitions;

    /** module service **/
    @Autowired
    private ModuleServiceImpl moduleService;

    /**
     * get module from database
     */
    @Override
    public void setFilterChainDefinitions(String definitions) {
        ShiroPermissionFactory.definitions = definitions;
        List<Module> sysPermissionInitList = moduleService.findAllModules();
        StringBuilder definitionsBuilder = new StringBuilder(definitions);
        for (Module m : sysPermissionInitList) {
            definitionsBuilder.append(m.getUrl()).append(" = ").append(m.getPermissionInit()).append("\r");
        }
        definitionsBuilder.append("/**").append(" = ").append("authc");
        definitions = definitionsBuilder.toString();

        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if(CollectionUtils.isEmpty(section)) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }

        setFilterChainDefinitionMap(section);
    }
}
