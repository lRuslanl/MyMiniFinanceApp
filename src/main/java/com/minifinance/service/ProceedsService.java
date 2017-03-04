/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.service;

import java.util.List;
import com.minifinance.domain.Proceeds;
import com.minifinance.mapper.ProceedsMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

public class ProceedsService {
    
    private ProceedsMapper proceedsMapper;

    @Transactional
    public void save(Proceeds object) {
        proceedsMapper.insert(object);
    }

    @Transactional
    public void update(Proceeds object) {
        proceedsMapper.update(object);
    }

    @Transactional
    public void delete(Integer id) {
        proceedsMapper.delete(id);
    }

    public Proceeds get(Integer id) {
        return proceedsMapper.selectOne(id);
    }

    public List<Proceeds> getAll() {
        return proceedsMapper.selectAll();
    }

    public ProceedsMapper getFinanceMapper() {
        return proceedsMapper;
    }

    public void setFinanceMapper(ProceedsMapper proceedsMapper) {
        this.proceedsMapper = proceedsMapper;
    }
}
