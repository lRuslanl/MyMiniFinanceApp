/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.mapper;

import java.util.List;
import com.minifinance.domain.Proceeds;

public interface ProceedsMapper {

    Proceeds selectOne(int id);

    List<Proceeds> selectAll();

    void insert(Proceeds finance);

    void update(Proceeds finance);

    void delete(int id);

}
