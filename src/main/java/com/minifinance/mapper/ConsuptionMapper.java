/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.mapper;

import com.minifinance.domain.Consuption;
import java.util.List;

/**
 *
 * @author Бабаджанов
 */
public interface ConsuptionMapper {
    Consuption selectOne(int id);

    List<Consuption> selectAll();

    void insert(Consuption finance);

    void update(Consuption finance);

    void delete(int id);
}
