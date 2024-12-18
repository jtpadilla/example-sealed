package org.example.sealed.service.spi;

import org.example.sealed.domain.Document;
import org.example.sealed.service.impl.util.DecoderException;

import java.util.Optional;

@FunctionalInterface
public interface DocumentDecoderInstance {
    Optional<Document> parse(String rawDocument) throws DecoderException;
}
