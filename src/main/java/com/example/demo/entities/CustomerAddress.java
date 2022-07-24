package com.example.demo.entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CustomerAddress")
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    int Id;
    @Column(name = "addressLineOne")
    String addressLineOne;
    @Column(name = "addressLineTwo")
     String addressLineTwo;
    @Column(name = "city")
    String city;
    @Column(name = "state")
    String state;
    @Column(name = "country")
    String country;
    @Column(name = "postalCode")
     String postalCode;
    @Column(name = "shipping")
    boolean shipping;
    @Column(name = "billing")
    boolean billing;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "customerAddress")
//    CustomerAddress customeraddress;

    public CustomerAddress() {
    }
    
    public CustomerAddress(int Id, String addressLineOne, String addressLineTwo, String city, String state, String country, String postalCode, boolean shipping, boolean billing) {
        super();
        this.Id = Id;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.shipping = shipping;
        this.billing = billing;

    }
    
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public boolean isBilling() {
        return billing;
    }

    public void setBilling(boolean billing) {
        this.billing = billing;
    }

//    public CustomerAddress getCustomeraddress() {
//        return customeraddress;
//    }
//
//    public void setCustomeraddress(CustomerAddress customeraddress) {
//        this.customeraddress = customeraddress;
//    }


    @Override
    public String toString() {
        return "\nCustomerAddress{" +
                " \n       Id=" + Id +
                ",\n       addressLineOne='" + addressLineOne + '\'' +
                ",\n       addressLineTwo='" + addressLineTwo + '\'' +
                ",\n       city='" + city + '\'' +
                ",\n       state='" + state + '\'' +
                ",\n       country='" + country + '\'' +
                ",\n       postalCode='" + postalCode + '\'' +
                ",\n       shipping=" + shipping +
                ",\n       billing=" + billing +
                '}';
    }


}