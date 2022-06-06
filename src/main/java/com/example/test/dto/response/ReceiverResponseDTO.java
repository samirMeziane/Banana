package com.example.test.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
import java.util.UUID;


@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReceiverResponseDTO {

    UUID id;

    String lastName;

    String firstName;

    String address;

    String postalCode;

    String town;

    String county;


}
