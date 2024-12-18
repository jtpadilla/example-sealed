package org.example.sealed.service.impl.catalog.terciario;

import org.example.sealed.domain.Document;
import org.example.sealed.domain.ReciboCompuestoConMetadatos;
import org.example.sealed.domain.ReciboCompuestoSinMetadatos;
import org.example.sealed.domain.ReciboSimple;
import org.example.sealed.service.impl.util.Decoder;
import org.example.sealed.service.impl.util.DecoderData;
import org.example.sealed.service.impl.util.DecoderException;
import org.example.sealed.service.spi.DocumentDecoderAppender;

import java.util.Optional;

public class TerciarioDecoder {

    static public void install(DocumentDecoderAppender appender) {
        appender.append(TerciarioDecoder::decodeReciboCompuestoConMetadatos);
        appender.append(TerciarioDecoder::decodeReciboCompuestoSinMetadatos);
        appender.append(TerciarioDecoder::decodeReciboSimple);
    }

    static public Optional<Document> decodeReciboCompuestoConMetadatos(String rawDocument) throws DecoderException {
        final DecoderData decode = Decoder.decode(rawDocument);
        if (decode.type().equals(ReciboCompuestoConMetadatos.TYPE)) {
            return Optional.of(new ReciboCompuestoConMetadatos(
                    decode.getParameter1(0)
            ));
        } else {
            return Optional.empty();
        }
    }

    static public Optional<Document> decodeReciboCompuestoSinMetadatos(String rawDocument) throws DecoderException {
        final DecoderData decode = Decoder.decode(rawDocument);
        if (decode.type().equals(ReciboCompuestoSinMetadatos.TYPE)) {
            return Optional.of(new ReciboCompuestoSinMetadatos(
                    decode.getParameter1(0),
                    decode.getParameter1(1)
            ));
        } else {
            return Optional.empty();
        }
    }

    static public Optional<Document> decodeReciboSimple(String rawDocument) throws DecoderException {
        final DecoderData decode = Decoder.decode(rawDocument);
        if (decode.type().equals(ReciboSimple.TYPE)) {
            return Optional.of(new ReciboSimple(
                    decode.getParameter1(0),
                    decode.getParameter1(1),
                    decode.getParameter1(2)
            ));
        } else {
            return Optional.empty();
        }
    }

}
