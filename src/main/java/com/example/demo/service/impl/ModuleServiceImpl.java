package com.example.demo.service.impl;

import com.example.demo.dao.ModuleMapper;
import com.example.demo.entity.Module;
import com.example.demo.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public int addModule(Module module) {
        return moduleMapper.insert(module);
    }

    @Override
    public List<Module> findAllModules() {
        return moduleMapper.selectAll();
    }

    @Override
    public List<Module> findAllModulesForConfig() {
        return moduleMapper.findAllModulesForConfig();
    }

    @Override
    public Integer getCurrentSort() {
        return moduleMapper.getCurrentSort();
    }

    @Override
    public int deleteModuleById(Integer id) {
        return moduleMapper.deleteByPrimaryKey(id);
    }
}
