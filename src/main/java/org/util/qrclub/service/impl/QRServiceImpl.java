package org.util.qrclub.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.util.qrclub.dto.ParticipantResponseDto;
import org.util.qrclub.dto.QRCodeResponseDto;
import org.util.qrclub.exception.ParticipantNotFoundException;
import org.util.qrclub.exception.QRCodeNotFoundException;
import org.util.qrclub.mapper.ParticipantMapper;
import org.util.qrclub.mapper.QRCodeMapper;
import org.util.qrclub.model.Participant;
import org.util.qrclub.model.QRCode;
import org.util.qrclub.repository.ParticipantRepository;
import org.util.qrclub.repository.QRCodeRepository;
import org.util.qrclub.service.QRCodeService;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class QRServiceImpl implements QRCodeService {

    private final QRCodeRepository QRCodeRepository;
    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;
    private final QRCodeMapper qrCodeMapper;

    @Override
    public ParticipantResponseDto scanAndRefresh(UUID uuid) {
        QRCode qrCode = QRCodeRepository.findByUuid(uuid)
                .orElseThrow(() -> new QRCodeNotFoundException(uuid));
        return participantMapper.toResponse(qrCode.getParticipant());

    }

    @Override
    public QRCodeResponseDto regenerate(Long participantId) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new ParticipantNotFoundException(participantId));
        QRCode qrCode = participant.getQrCode();
        qrCode.refreshUuid();
        QRCodeRepository.save(qrCode);
        return qrCodeMapper.toResponse(qrCode);
    }

    @Override
    @Transactional(readOnly = true)
    public QRCodeResponseDto getByParticipant(Long participantId) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new RuntimeException("Participant not found"));
        return qrCodeMapper.toResponse(participant.getQrCode());
    }

}
