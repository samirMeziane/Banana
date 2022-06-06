package com.example.test.repository;

import com.example.test.domain.Order;
import com.example.test.domain.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Transactional
    void deleteByReceiver(Receiver receiver);
}
