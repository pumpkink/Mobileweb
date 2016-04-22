/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.studydemo.gui.page;

import jsf.studydemo.domain.CreditCardType;
import jsf.studydemo.domain.Customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
/**
 *
 * @author hou
 */
@ManagedBean
@SessionScoped
public class CustomerBean {
    private static final String CARD_A_NAME = "VISA";
    private static final String CARD_B_NAME = "Mastercard";

    private Customer customer = new Customer();
    private List<SelectItem> ccTypes;

    @PostConstruct
    private void init() {
        this.ccTypes = new ArrayList<SelectItem>();
        this.ccTypes.add(new SelectItem(CreditCardType.CARD_A, CARD_A_NAME));
        this.ccTypes.add(new SelectItem(CreditCardType.CARD_B, CARD_B_NAME));
    }
       
    public void useCreditCardChanged(ValueChangeEvent ev) {
        Boolean useCreditCard = (Boolean) ev.getNewValue();
        if (useCreditCard != null) {
            customer.setUseCreditCard(useCreditCard);
        }
        FacesContext.getCurrentInstance().renderResponse();
    }

    public String getSelectedCreditCardType() {
        String selectedCCType = null;
        if (customer.getCreditCardType() != null) {
            switch (customer.getCreditCardType()) {
                case CARD_A:
                    selectedCCType = CARD_A_NAME;
                    break;
                case CARD_B:
                    selectedCCType = CARD_B_NAME;
                    break;
                default:
                    break;
            }
        }
        return selectedCCType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<SelectItem> getCreditCardTypes() {
        return this.ccTypes;
    }
    
}
