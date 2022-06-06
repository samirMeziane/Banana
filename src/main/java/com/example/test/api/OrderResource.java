package com.example.test.api;


import com.example.test.dto.request.OrderRequestDTO;
import com.example.test.dto.response.OrderResponseDTO;
import com.example.test.exceptions.NotFoundEntityException;
import com.example.test.mapper.OrderMapper;
import com.example.test.service.OrderService;
import com.example.test.service.ReceiverService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("${test.api.base-path}/order")
public class OrderResource {

    OrderService orderService;
    ReceiverService receiverService;

    OrderMapper orderMapper;

    @PostMapping("/{receiverId}/receiver")
    public ResponseEntity<OrderResponseDTO> createOrder(@PathVariable("receiverId") UUID id, @Valid @RequestBody OrderRequestDTO orderRequestDTO) {
        var receiver = receiverService.findOneReceiver(id).orElseThrow(
            () -> new NotFoundEntityException("id not found")
        );
        var order = orderMapper.fromRequestDtoToEntity(orderRequestDTO);
        order.setReceiver(receiver);
        OrderResponseDTO orderResponseDTO = orderMapper.fromEntityToResponseDTO(
            orderService.saveOrder(order)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDTO);
    }

    @GetMapping("/{receiverId}/receiver")
    public ResponseEntity<List<OrderResponseDTO>> getOrders(@PathVariable("receiverId") UUID id) {

        receiverService.findOneReceiver(id).orElseThrow(
            () -> new NotFoundEntityException("Receiver not found")
        );

        List<OrderResponseDTO> responseDTOS = orderService.findAll().stream().filter(
            order -> order.getReceiver().getId().equals(id)).map(orderMapper::fromEntityToResponseDTO).toList();

        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);

    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Void> updateOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO,
                                            @PathVariable("orderId") UUID id) {

        var order = orderService.findOneOrder(id).orElseThrow(
            () -> new NotFoundEntityException("Order not found")
        );

        orderMapper.updateEntity(order, orderRequestDTO);
        orderService.saveOrder(order);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable("orderId") UUID id) {

        var order = orderService.findOneOrder(id).orElseThrow(
            () -> new NotFoundEntityException("Order not found")
        );

        return ResponseEntity.status(HttpStatus.OK).body(orderMapper.fromEntityToResponseDTO(order));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") UUID id) {

        orderService.findOneOrder(id).orElseThrow(
            () -> new NotFoundEntityException("Order not found")
        );

        orderService.deleteOrder(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getOrders() {
        return ResponseEntity.ok(orderService.findAll().stream().map(orderMapper::fromEntityToResponseDTO).toList());
    }


}
