package com.app.service;
import com.app.entity.Address;
import java.util.List;
public interface AddressService {
    Address addAddress(Address address);
    Address updateAddress(Long id, Address address);
    void deleteAddress(Long id);
    List<Address> getAddressesByEmployeeId(Long employeeId);
}


