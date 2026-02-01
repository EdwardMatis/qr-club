package org.util.qrclub.service;

import org.util.qrclub.dto.ParticipantRequestDto;
import org.util.qrclub.dto.ParticipantResponseDto;
import org.util.qrclub.dto.QRCodeResponseDto;

import java.util.UUID;

public interface QRCodeService {

    ParticipantResponseDto scanAndRefresh(UUID uuid);

    QRCodeResponseDto regenerate(Long participantId);

    QRCodeResponseDto getByParticipant(Long participantId);
}

