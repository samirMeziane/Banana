package com.example.test.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "receiver",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"last_name", "first_name", "address", "postal_code",
        "town", "country"})})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Receiver extends BaseEntity<UUID> {

    @Column(name = "last_name", nullable = false)
    @ToString.Include
    String lastName;

    @Column(name = "first_name", nullable = false)
    @ToString.Include
    String firstName;

    @Column(name = "address", nullable = false)
    @ToString.Include
    String address;

    @Column(name = "postal_code", nullable = false)
    @ToString.Include
    String postalCode;

    @Column(name = "town", nullable = false)
    @ToString.Include
    String town;

    @Column(name = "country", nullable = false)
    @ToString.Include
    String county;

}
