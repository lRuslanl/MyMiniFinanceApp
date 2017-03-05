/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.service;

import java.util.List;
import com.minifinance.domain.Finance;
import com.minifinance.mapper.FinanceMapper;
import org.springframework.transaction.annotation.Transactional;

public class FinanceService {
    private FinanceMapper consuptionMapper;

    @Transactional
    public void save(Finance object) {
        consuptionMapper.insert(object);
    }

    @Transactional
    public void update(Finance object) {
        consuptionMapper.update(object);
    }

    @Transactional
    public void delete(Integer id) {
        consuptionMapper.delete(id);
    }

    public Finance get(Integer id) {
        return consuptionMapper.selectOne(id);
    }

    public List<Finance> getAll() {
        return consuptionMapper.selectAll();
    }

    public FinanceMapper getFinanceMapper() {
        return consuptionMapper;
    }

    public void setFinanceMapper(FinanceMapper proceedsMapper) {
        this.consuptionMapper = proceedsMapper;
    }
}
