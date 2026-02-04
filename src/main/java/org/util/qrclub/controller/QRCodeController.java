package org.util.qrclub.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.util.qrclub.dto.ParticipantResponseDto;
import org.util.qrclub.dto.QRCodeRequestDto;
import org.util.qrclub.dto.QRCodeResponseDto;
import org.util.qrclub.service.QRCodeService;

@RestController
@RequestMapping("/api/qr")
public class QRCodeController {

    private final QRCodeService qrCodeService;

    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @PostMapping("/scan")
    public ParticipantResponseDto scan(
            @RequestBody @Valid QRCodeRequestDto dto
    ) {
        return qrCodeService.scanAndRefresh(dto.getUuid());
    }

    @PutMapping("/regenerate/{participantId}")
    public QRCodeResponseDto regenerate(
            @PathVariable Long participantId
    ) {
        return qrCodeService.regenerate(participantId);
    }

    @GetMapping("/participant/{participantId}")
    public QRCodeResponseDto getByParticipant(
            @PathVariable Long participantId
    ) {
        return qrCodeService.getByParticipant(participantId);
    }
}

