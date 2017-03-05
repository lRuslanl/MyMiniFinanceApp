/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minifinance.controller;

import com.minifinance.domain.Consuption;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.minifinance.domain.Finance;
import com.minifinance.domain.Proceeds;
import com.minifinance.logic.Computation;
import com.minifinance.service.FinanceService;

@Component
@ManagedBean
public class FinanceController {
    @Autowired
    Computation computation;
    @Autowired
    FinanceService financeService;

    Finance selectedFinance;

    public List<Finance> getConsuption() {
        return financeService.getAll();
    }

    public Finance getSelectedConsuption() {
        return selectedFinance;
    }

    public void setSelectedConsuption(Finance selectedFinance) {
        this.selectedFinance = selectedFinance;
    }

    public List<Finance> getConsuptionIncomes() {
        List<Finance> temp = financeService.getAll();
        List<Finance> result = new ArrayList<>();
        for (Finance finance : temp) {
            if (finance.getValue() > 0) {
                result.add(finance);
            }
        }
        return result;
    }

    public List<Finance> getFinanceOutcomes() {
        List<Finance> temp = financeService.getAll();
        List<Finance> result = new ArrayList<>();
        for (Finance finance : temp) {
            if (finance.getValue() < 0) {
                result.add(finance);
            }
        }
        return result;
    }

    public String getSaldo() {
        return String.valueOf(computation.saldo(financeService.getAll()));
    }

    public String getAvgIncome() {
        return String.valueOf(computation.avgIncome(getConsuption()));
    }

    public String getAvgOutgo() {
        return String.valueOf(computation.avgOutgo(getConsuption()));
    }

    public String create() {
        try {
            financeService.save(selectedFinance);
            Utility.addSuccessMessage("Finance created");
            return "createFinance";
        } catch (Exception e) {
            Utility.addErrorMessage(e, "Error");
            return null;
        }
    }

    public String prepareCreateProceeds() {
        selectedFinance = new Proceeds();
        return "faces/createProceeds";
    }
    
    public String prepareCreateConsuption() {
        selectedFinance = new Consuption();
        return "faces/createConsuption";
    }

    public Finance getFinance(java.lang.Integer id) {
        return financeService.get(id);
    }

    @FacesConverter(forClass = Finance.class)
    public static class FinanceControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FinanceController controller = (FinanceController) facesContext.getApplication().getELResolver().
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
            if (object instanceof Finance) {
                Finance o = (Finance) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Finance.class.getName());
            }
        }

    }
}
