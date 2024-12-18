package org.example.sealed.service.impl.catalog.comercial;

import org.example.sealed.domain.Albaran;
import org.example.sealed.domain.Document;
import org.example.sealed.service.impl.util.Decoder;
import org.example.sealed.service.impl.util.DecoderData;
import org.example.sealed.service.impl.util.DecoderException;
import org.example.sealed.service.spi.DocumentDecoderAppender;

import java.util.Optional;

public class ComerialDecoder {

    static public void install(DocumentDecoderAppender appender) {
        appender.append(ComerialDecoder::decodeAlbaranProduccion);
        appender.append(ComerialDecoder::decodeAlbaranVenta);
        appender.append(ComerialDecoder::decodeAlbaranComercial);
    }

    static public Optional<Document> decodeAlbaranProduccion(String rawDocument) throws DecoderException {
        final DecoderData decode = Decoder.decode(rawDocument);
        if (decode.type().equals(Albaran.AlbaranProduccion.TYPE)) {
            return Optional.of(new Albaran.AlbaranProduccion(
                    decode.getParameter1(0)
            ));
        } else {
            return Optional.empty();
        }
    }

    static public Optional<Document> decodeAlbaranVenta(String rawDocument) throws DecoderException {
        final DecoderData decode = Decoder.decode(rawDocument);
        if (decode.type().equals(Albaran.AlbaranVenta.TYPE)) {
            return Optional.of(new Albaran.AlbaranVenta(
                    decode.getParameter1(0),
                    decode.getParameter1(1)
            ));
        } else {
            return Optional.empty();
        }
    }

    static public Optional<Document> decodeAlbaranComercial(String rawDocument) throws DecoderException {
        final DecoderData decode = Decoder.decode(rawDocument);
        if (decode.type().equals(Albaran.AlbaranComercial.TYPE)) {
            return Optional.of(new Albaran.AlbaranComercial(
                    decode.getParameter1(0),
                    decode.getParameter1(1),
                    decode.getParameter1(2)
            ));
        } else {
            return Optional.empty();
        }
    }

}
