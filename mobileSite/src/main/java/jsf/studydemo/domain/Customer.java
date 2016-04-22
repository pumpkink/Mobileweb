package jsf.studydemo.domain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/*
 * customer profile
 */
public class Customer {
    @NotNull @Min(value = 1000) @Max(value = 99999)
    private Integer zipCode;

    private String firstName;
    private String lastName;
    private String email;
    
    @NotNull
    private String city;
    @NotNull
    private String street;
    
    private Date birthday;
    private Boolean useCreditCard = Boolean.TRUE;
    private CreditCardType creditCardType;
    @NotNull
    private String creditCardNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getUseCreditCard() {
		return useCreditCard;
	}

	public void setUseCreditCard(Boolean useCreditCard) {
		this.useCreditCard = useCreditCard;
	}

	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
       
        public String export(){
        FacesContext fc = FacesContext.getCurrentInstance();
        try{
            HttpServletResponse resp = (HttpServletResponse) fc.getExternalContext().getResponse();
            resp.setContentType("text/plain");
            PrintWriter writer = resp.getWriter();
            writer.print("First Name: ");
            writer.println(firstName);
            writer.print("Last Name: ");
            writer.println(lastName);
            if(useCreditCard){
                writer.print("Credit Card Type: ");
                writer.println(creditCardType);
                writer.print("Credit Card Number: ");
                writer.println(creditCardNumber);
            }
            fc.responseComplete();
                    
        } catch(IOException e){e.printStackTrace();}
        
        return null;
    }

}
