/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.domain;

import java.io.Serializable;
import java.util.Date;

public class Proceeds implements Serializable {
    private Integer id;
    private float value;
    private Date date;
    private String description;

    public Proceeds() {
    }

    public Proceeds(Integer id) {
        this.id = id;
    }

    public Proceeds(Integer id, float value, Date date) {
        this.id = id;
        this.value = value;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceeds)) {
            return false;
        }
        Proceeds other = (Proceeds) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.minifinance.domain.Proceeds[ id=" + id + " ]";
    }

}
