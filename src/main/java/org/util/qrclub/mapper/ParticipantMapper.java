package org.util.qrclub.mapper;

import org.springframework.stereotype.Component;
import org.util.qrclub.dto.ParticipantRequestDto;
import org.util.qrclub.dto.ParticipantResponseDto;
import org.util.qrclub.model.Participant;

@Component
public class ParticipantMapper {

    public ParticipantResponseDto toResponse(Participant entity) {
        ParticipantResponseDto dto = new ParticipantResponseDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPatronymic(entity.getPatronymic());

        if (entity.getQrCode() != null) {
            dto.setUuid(entity.getQrCode().getUuid());
        }

        return dto;
    }

    public Participant toEntity(ParticipantRequestDto dto) {
        Participant entity = new Participant();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPatronymic(dto.getPatronymic());
        return entity;
    }

    public void updateEntity(
            ParticipantRequestDto dto,
            Participant entity
    ) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPatronymic(dto.getPatronymic());
    }



}
