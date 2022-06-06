package com.example.test.service;

import com.example.test.domain.Order;
import com.example.test.domain.Receiver;
import com.example.test.repository.ReceiverRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ReceiverService {
    ReceiverRepository receiverRepository;

    public Receiver saveReceiver(Receiver receiver) {
        return receiverRepository.save(receiver);
    }

    public Optional<Receiver> findOneReceiver(UUID id) {
        return receiverRepository.findById(id);
    }

    public void deleteReceiver(UUID id) {
        receiverRepository.deleteById(id);
    }

    public List<Receiver>findAll() {
        return receiverRepository.findAll();
    }

}
