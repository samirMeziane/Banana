package com.example.test.mapper;

import com.example.test.domain.Order;
import com.example.test.dto.request.OrderRequestDTO;
import com.example.test.dto.response.OrderResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OrderMapper {

    @Mapping(target = "receiver", ignore = true)
    @Mapping(target = "price", ignore = true)
    Order fromRequestDtoToEntity(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO fromEntityToResponseDTO(Order order);

    @Mapping(target = "receiver", ignore = true)
    @Mapping(target = "price", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Order order, OrderRequestDTO orderRequestDTO);
}
