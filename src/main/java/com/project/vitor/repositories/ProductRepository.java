package com.project.vitor.repositories;

import com.project.vitor.entities.Product;
import com.project.vitor.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
