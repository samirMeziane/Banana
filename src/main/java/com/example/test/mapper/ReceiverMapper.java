package com.example.test.mapper;

import com.example.test.domain.Receiver;
import com.example.test.dto.request.ReceiverRequestDTO;
import com.example.test.dto.response.ReceiverResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReceiverMapper {

    Receiver fromRequestDtoToEntity(ReceiverRequestDTO receiverRequestDTO);

    ReceiverResponseDTO fromEntityToResponseDto(Receiver receiver);


    void updateEntity(@MappingTarget Receiver receiver, ReceiverRequestDTO receiverRequestDTO );
}
