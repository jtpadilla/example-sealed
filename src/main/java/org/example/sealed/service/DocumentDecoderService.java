package org.example.sealed.service;

import org.example.sealed.domain.Document;
import org.example.sealed.domain.InvalidDocument;
import org.example.sealed.service.impl.catalog.comercial.ComerialDecoder;
import org.example.sealed.service.impl.catalog.logistico.LogisticoDecoder;
import org.example.sealed.service.impl.catalog.terciario.TerciarioDecoder;
import org.example.sealed.service.impl.util.DecoderException;
import org.example.sealed.service.spi.DocumentDecoderAppender;
import org.example.sealed.service.spi.DocumentDecoderInstance;

import java.util.List;
import java.util.Optional;

public class DocumentDecoderService {

    static public DocumentDecoderService getInstance() {
        return INSTANCE;
    }

    static private DocumentDecoderService INSTANCE;

    static {

        // Decoders
        final DocumentDecoderAppender appender = new DocumentDecoderAppender();
        ComerialDecoder.install(appender);
        LogisticoDecoder.install(appender);
        TerciarioDecoder.install(appender);

        // Servicio SINGLETOM
        INSTANCE = new DocumentDecoderService(appender.getInstances());

    }

    private List<DocumentDecoderInstance> docoders;

    private DocumentDecoderService(List<DocumentDecoderInstance> docoders) {
        this.docoders = docoders;
    }

    public Document decode(String rawDocument) throws DecoderException {
        for (DocumentDecoderInstance instance : docoders) {
            final Optional<Document> document = instance.parse(rawDocument);
            if (document.isPresent()) {
                return document.get();
            }
        }
        return new InvalidDocument(rawDocument);
    }

}
