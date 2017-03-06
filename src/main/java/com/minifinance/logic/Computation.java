/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.logic;

import java.util.List;
import org.springframework.stereotype.Component;
import com.minifinance.domain.Consuption;


@Component
public class Computation {
    
    public float saldo(List<Consuption> finances) {
        float res = 0;
        for (Consuption finance : finances) {
            res += finance.getValue();
        }
        return res;
    }

    public float avgIncome(List<Consuption> finances) {
        float res = 0;
        float count = 0;
        for (Consuption finance : finances) {
            if (finance.getValue() > 0) {
                count++;
                res += finance.getValue();
            }
        }
        return res/count;
    }
    public float avgOutgo(List<Consuption> finances) {
        float res = 0;
        float count = 0;
        for (Consuption finance : finances) {
            if (finance.getValue() < 0) {
                count++;
                res += finance.getValue();
            }
        }
        return res/count;
    }
}
