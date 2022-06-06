package com.example.test.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReceiverRequestDTO {


    @NotNull
    String lastName;

    @NotNull
    String firstName;

    @NotNull
    String address;

    @NotNull
    String postalCode;

    @NotNull
    String town;

    @NotNull
    String county;

}
