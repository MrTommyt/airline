package com.example.airline.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    // GETTERS AND SETTERS

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
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getIdCustomer(), customer.getIdCustomer()) && Objects.equals(getName(),
            customer.getName()) && Objects.equals(getLastName(),
            customer.getLastName()) && Objects.equals(getAddress(),
            customer.getAddress()) && Objects.equals(getPhone(), customer.getPhone()) && Objects.equals(
            getEmail(), customer.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCustomer(), getName(), getLastName(), getAddress(), getPhone(), getEmail());
    }
}
