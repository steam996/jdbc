package ru.netology.jdbc_homework.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CustomerRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public List<String> getProductName(String name) {
        return entityManager.createNativeQuery("SELECT  orders.product_name " +
                "from orders join customers on customers.id = orders.customer_id " +
                "where name ilike :name ").setParameter("name", name).getResultList();
    }
}
