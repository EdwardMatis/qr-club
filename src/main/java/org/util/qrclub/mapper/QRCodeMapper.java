package org.util.qrclub.mapper;

import org.springframework.stereotype.Component;
import org.util.qrclub.dto.QRCodeResponseDto;
import org.util.qrclub.model.QRCode;

@Component
public class QRCodeMapper {

    public QRCodeResponseDto toResponse(QRCode entity) {
        QRCodeResponseDto dto = new QRCodeResponseDto();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        return dto;
    }
}
