package com.app.service;

import com.app.entity.Address;
import com.app.entity.Employee;
import com.app.repository.AddressRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {
        // Ensure the associated Employee is set for the Address
        Employee employee = address.getEmployee();
        if (employee != null) {
            address.setEmployee(employee);
        }
        return addressRepository.save(address);
    }
    @Override
    public Address updateAddress(Long id, Address address) {
        // Ensure the associated Employee is set for the Address
        Employee employee = address.getEmployee();
        if (employee != null) {
            address.setEmployee(employee);
        }
        address.setAddressId(id);
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> getAddressesByEmployeeId(Long employeeId) {
        return addressRepository.findByEmployeeId(employeeId);
    }
}
