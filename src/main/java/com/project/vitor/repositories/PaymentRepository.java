package com.project.vitor.repositories;

import com.project.vitor.entities.Category;
import com.project.vitor.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
