package com.example.test.repository;

import com.example.test.domain.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReceiverRepository extends JpaRepository<Receiver, UUID> {

}
