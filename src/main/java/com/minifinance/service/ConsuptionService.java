/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.service;

import com.minifinance.domain.Consuption;
import com.minifinance.mapper.ConsuptionMapper;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Бабаджанов
 */
public class ConsuptionService {
    private ConsuptionMapper consuptionMapper;

    @Transactional
    public void save(Consuption object) {
        consuptionMapper.insert(object);
    }

    @Transactional
    public void update(Consuption object) {
        consuptionMapper.update(object);
    }

    @Transactional
    public void delete(Integer id) {
        consuptionMapper.delete(id);
    }

    public Consuption get(Integer id) {
        return consuptionMapper.selectOne(id);
    }

    public List<Consuption> getAll() {
        return consuptionMapper.selectAll();
    }

    public ConsuptionMapper getFinanceMapper() {
        return consuptionMapper;
    }

    public void setFinanceMapper(ConsuptionMapper proceedsMapper) {
        this.consuptionMapper = proceedsMapper;
    }
}
