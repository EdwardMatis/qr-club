package org.util.qrclub.exception;

import java.util.UUID;

public class QRCodeNotFoundException extends RuntimeException {
    public QRCodeNotFoundException(UUID uuid) {
        super("QR code with uuid=" + uuid + " not found");
    }
}

