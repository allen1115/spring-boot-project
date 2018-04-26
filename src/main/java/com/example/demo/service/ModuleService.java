package com.example.demo.service;

import com.example.demo.entity.Module;

import java.util.List;

public interface ModuleService {

    int addModule(Module module);

    List<Module> findAllModules();

    int deleteModuleById(Integer id);

    List<Module> findAllModulesForConfig();
}
