package com.leobrambilla.medicalshop.repositories;

import com.leobrambilla.medicalshop.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
