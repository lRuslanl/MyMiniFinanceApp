/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.domain;

import java.util.Date;


public interface Finance {
    public Integer getId();

    public void setId(Integer id);

    public float getValue();

    public void setValue(float value);

    public Date getDate();

    public void setDate(Date date);

    public String getDescription();

    public void setDescription(String description);
}
