package com.example.test.api;

import com.example.test.dto.request.ReceiverRequestDTO;
import com.example.test.dto.response.ReceiverResponseDTO;
import com.example.test.exceptions.NotFoundEntityException;
import com.example.test.mapper.ReceiverMapper;
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
@RequestMapping("${test.api.base-path}/receiver")
public class ReceiverResource {
    ReceiverService receiverService;
    OrderService orderService;

    ReceiverMapper receiverMapper;


    @PostMapping
    public ResponseEntity<ReceiverResponseDTO> createReceiver(@Valid @RequestBody ReceiverRequestDTO receiverRequestDTO) {
        ReceiverResponseDTO receiverResponseDTO = receiverMapper.fromEntityToResponseDto(
            receiverService.saveReceiver(receiverMapper.fromRequestDtoToEntity(receiverRequestDTO))
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(receiverResponseDTO);
    }

    @PutMapping("/{receiverId}")
    public ResponseEntity<Void> updateReceiver(@Valid @RequestBody ReceiverRequestDTO receiverRequestDTO,
                                               @PathVariable("receiverId") UUID id){

        var receiver = receiverService.findOneReceiver(id).orElseThrow(
            () -> new NotFoundEntityException("Receiver not found")
        );

        receiverMapper.updateEntity(receiver,receiverRequestDTO );
        receiverService.saveReceiver(receiver);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{receiverId}")
    public ResponseEntity<ReceiverResponseDTO> getReceiver(@PathVariable("receiverId") UUID id) {

        var receiver = receiverService.findOneReceiver(id).orElseThrow(
            () -> new NotFoundEntityException("Receiver not found")
        );

        return ResponseEntity.status(HttpStatus.OK).body(receiverMapper.fromEntityToResponseDto(receiver));

    }

    @DeleteMapping("/{receiverId}")
    public ResponseEntity<Void> deleteReceiver(@PathVariable("receiverId") UUID id) {

        var receiver = receiverService.findOneReceiver(id).orElseThrow(
            () -> new NotFoundEntityException("Receiver not found")
        );

        orderService.deleteOrderByReceiver(receiver);
        receiverService.deleteReceiver(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<ReceiverResponseDTO>> getAllReceivers() {
        return ResponseEntity.status(HttpStatus.OK).body(
            receiverService.findAll().stream().map(receiverMapper::fromEntityToResponseDto).toList()
        );
    }


}
