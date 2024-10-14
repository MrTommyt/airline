package com.example.airline.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class CustomerDTO implements Serializable {

    private Long idCustomer;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;

    public CustomerDTO(Long idCustomer, String name, String lastName, String address, String phone, String email) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDTO that)) return false;
        return Objects.equals(getIdCustomer(), that.getIdCustomer()) && Objects.equals(getName(),
            that.getName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(
            getAddress(), that.getAddress()) && Objects.equals(getPhone(),
            that.getPhone()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCustomer(), getName(), getLastName(), getAddress(), getPhone(), getEmail());
    }
}
