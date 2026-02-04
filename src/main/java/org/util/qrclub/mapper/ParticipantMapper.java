package org.util.qrclub.mapper;

import org.springframework.stereotype.Component;
import org.util.qrclub.dto.ParticipantRequestDto;
import org.util.qrclub.dto.ParticipantResponseDto;
import org.util.qrclub.model.ParticipantEntity;

@Component
public class ParticipantMapper {

    public ParticipantResponseDto toResponse(ParticipantEntity entity) {
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

    public ParticipantEntity toEntity(ParticipantRequestDto dto) {
        ParticipantEntity entity = new ParticipantEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPatronymic(dto.getPatronymic());
        return entity;
    }

    public void updateEntity(
            ParticipantRequestDto dto,
            ParticipantEntity entity
    ) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPatronymic(dto.getPatronymic());
    }



}
