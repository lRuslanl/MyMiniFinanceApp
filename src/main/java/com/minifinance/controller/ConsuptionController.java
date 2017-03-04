/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.minifinance.domain.Consuption;
import com.minifinance.domain.Proceeds;
import com.minifinance.logic.Computation;
import com.minifinance.service.ConsuptionService;
import com.minifinance.service.ProceedsService;

@Component
@ManagedBean
public class ConsuptionController {

    @Autowired
    Computation calculation;
    @Autowired
    ConsuptionService financeService;

    Consuption selectedFinance;

    public List<Consuption> getConsuption() {
        return financeService.getAll();
    }

    public Consuption getSelectedConsuption() {
        return selectedFinance;
    }

    public void setSelectedConsuption(Consuption selectedFinance) {
        this.selectedFinance = selectedFinance;
    }

    public List<Consuption> getConsuptionIncomes() {
        List<Consuption> temp = financeService.getAll();
        List<Consuption> result = new ArrayList<>();
        for (Consuption finance : temp) {
            if (finance.getValue() > 0) {
                result.add(finance);
            }
        }
        return result;
    }

    public List<Consuption> getFinanceOutcomes() {
        List<Consuption> temp = financeService.getAll();
        List<Consuption> result = new ArrayList<>();
        for (Consuption finance : temp) {
            if (finance.getValue() < 0) {
                result.add(finance);
            }
        }
        return result;
    }

    public String getSaldo() {
        return String.valueOf(calculation.saldo(financeService.getAll()));
    }

    public String getAvgIncome() {
        return String.valueOf(calculation.avgIncome(getConsuption()));
    }

    public String getAvgOutgo() {
        return String.valueOf(calculation.avgOutgo(getConsuption()));
    }

    public String create() {
        try {
            financeService.save(selectedFinance);
            JsfUtil.addSuccessMessage("Finance created");
            return "createFinance";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Error");
            return null;
        }
    }

    public String prepareCreate() {
        selectedFinance = new Consuption();
        return "faces/createFinance";
    }

    public Consuption getFinance(java.lang.Integer id) {
        return financeService.get(id);
    }

    @FacesConverter(forClass = Consuption.class)
    public static class FinanceControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ConsuptionController controller = (ConsuptionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "financeController");
            return controller.getFinance(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Consuption) {
                Consuption o = (Consuption) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Finance.class.getName());
            }
        }

    }
}
