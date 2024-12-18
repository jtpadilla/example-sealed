package org.example.sealed.service.impl.catalog.logistico;

import org.example.sealed.domain.Document;
import org.example.sealed.domain.FacturaComercial;
import org.example.sealed.domain.FacturaProduccion;
import org.example.sealed.domain.FacturaVenta;
import org.example.sealed.service.impl.util.Decoder;
import org.example.sealed.service.impl.util.DecoderData;
import org.example.sealed.service.impl.util.DecoderException;
import org.example.sealed.service.spi.DocumentDecoderAppender;

import java.util.Optional;

public class LogisticoDecoder {

    static public void install(DocumentDecoderAppender appender) {
        appender.append(LogisticoDecoder::decodeFacturaProduccion);
        appender.append(LogisticoDecoder::decodeFacturaVenta);
        appender.append(LogisticoDecoder::decodeFacturaComercial);
    }

    static public Optional<Document> decodeFacturaComercial(String rawDocument) throws DecoderException {
        final DecoderData decode = Decoder.decode(rawDocument);
        if (decode.type().equals(FacturaComercial.TYPE)) {
            return Optional.of(new FacturaComercial(
                    decode.getParameter1(0)
            ));
        } else {
            return Optional.empty();
        }
    }

    static public Optional<Document> decodeFacturaProduccion(String rawDocument) throws DecoderException {
        final DecoderData decode = Decoder.decode(rawDocument);
        if (decode.type().equals(FacturaProduccion.TYPE)) {
            return Optional.of(new FacturaProduccion(
                    decode.getParameter1(0),
                    decode.getParameter1(1)
            ));
        } else {
            return Optional.empty();
        }
    }

    static public Optional<Document> decodeFacturaVenta(String rawDocument) throws DecoderException {
        final DecoderData decode = Decoder.decode(rawDocument);
        if (decode.type().equals(FacturaVenta.TYPE)) {
            return Optional.of(new FacturaVenta(
                    decode.getParameter1(0),
                    decode.getParameter1(1),
                    decode.getParameter1(2)
            ));
        } else {
            return Optional.empty();
        }
    }

}
