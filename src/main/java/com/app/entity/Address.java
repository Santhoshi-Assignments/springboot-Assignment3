package com.app.entity;


import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String address;

    @ManyToOne
    @JoinColumn(name = "employee_Id")
    private Employee employee;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Address()
    {
        super();
    }

    public Address(Long addressId, String address, Employee employee) {
        this.addressId = addressId;
        this.address = address;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", employee=" + employee +
                '}';
    }
}
