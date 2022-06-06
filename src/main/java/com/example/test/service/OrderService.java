package com.example.test.service;


import com.example.test.domain.Order;
import com.example.test.domain.Receiver;
import com.example.test.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {

    OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findOneOrder(UUID id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }
    public void deleteOrderByReceiver(Receiver receiver) {
        orderRepository.deleteByReceiver(receiver);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

}
