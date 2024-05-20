package com.leobrambilla.medicalshop.repositories;

import com.leobrambilla.medicalshop.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
