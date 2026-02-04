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
import org.util.qrclub.model.ParticipantEntity;
import org.util.qrclub.model.QRCodeEntity;
import org.util.qrclub.repository.ParticipantRepository;
import org.util.qrclub.repository.QRCodeRepository;
import org.util.qrclub.service.QRCodeService;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class QRServiceImpl implements QRCodeService {

    private final QRCodeRepository qrCodeRepository;
    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;
    private final QRCodeMapper qrCodeMapper;
    private final QRCodeService qrCodeService;

    @Override
    public ParticipantResponseDto scanAndRefresh(UUID uuid) {
        QRCodeEntity qrCode = qrCodeRepository.findByUuid(uuid)
                .orElseThrow(() -> new QRCodeNotFoundException(uuid));
        return participantMapper.toResponse(qrCode.getParticipant());

    }

    @Override
    public void refreshUuid(QRCodeEntity qrCode) {qrCode.setUuid(UUID.randomUUID());}

    @Override
    public QRCodeResponseDto regenerate(Long participantId) {
        ParticipantEntity participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new ParticipantNotFoundException(participantId));
        QRCodeEntity qrCode = participant.getQrCode();
        qrCodeService.refreshUuid(qrCode);
        qrCodeRepository.save(qrCode);
        return qrCodeMapper.toResponse(qrCode);
    }


    @Override
    @Transactional(readOnly = true)
    public QRCodeResponseDto getByParticipant(Long participantId) {
        ParticipantEntity participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new ParticipantNotFoundException(participantId));
        return qrCodeMapper.toResponse(participant.getQrCode());
    }

}
