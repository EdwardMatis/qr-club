package org.util.qrclub.mapper;

import org.springframework.stereotype.Component;
import org.util.qrclub.dto.QRCodeResponseDto;
import org.util.qrclub.model.QRCodeEntity;

@Component
public class QRCodeMapper {

    public QRCodeResponseDto toResponse(QRCodeEntity entity) {
        QRCodeResponseDto dto = new QRCodeResponseDto();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        return dto;
    }
}
