package com.example.test.domain;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order_table")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Order extends BaseEntity<UUID> {

    @Column(name = "date")
    @ToString.Include
    LocalDate date;

    @Column(name = "price")
    @ToString.Include
    double price;

    @Column(name = "quantity")
    @ToString.Include
    int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiver_id")
    Receiver receiver;

    @PrePersist
    private void createCalculatePrice() {
        price = 2.5 * quantity;
    }

    @PreUpdate
    private void updateCalculatePrice() { price = 2.5 * quantity;}


}
