package com.example.test.dto.request;

import com.example.test.validator.DateFutureConstraint;
import com.example.test.validator.QuantityConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequestDTO {

    @DateFutureConstraint(message = "invalid date")
    @NotNull
    LocalDate date;

    @QuantityConstraint(message = "Quantity must be multiple of 25")
    @NotNull
    int quantity;


}
