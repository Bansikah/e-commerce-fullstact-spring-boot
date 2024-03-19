package com.bansikah.ecommerce.repository;

import com.bansikah.ecommerce.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    public static Customer findByCustomerId(String customerId) {
        return null;
    }
}
