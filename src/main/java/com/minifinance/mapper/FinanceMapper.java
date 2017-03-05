/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.mapper;

import com.minifinance.domain.Finance;
import java.util.List;

/**
 *
 * @author Бабаджанов
 */
public interface FinanceMapper {
    Finance selectOne(int id);

    List<Finance> selectAll();

    void insert(Finance finance);

    void update(Finance finance);

    void delete(int id);
}
