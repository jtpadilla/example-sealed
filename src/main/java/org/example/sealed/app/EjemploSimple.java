package org.example.sealed.app;

import org.example.sealed.app.data.ExampleDocuments;
import org.example.sealed.domain.Document;
import org.example.sealed.domain.InvalidDocument;
import org.example.sealed.service.DocumentDecoderService;
import org.example.sealed.service.impl.util.DecoderException;

public class EjemploSimple {

    public static void main(String[] args) {
        new EjemploSimple().run();
    }

    public void run() {

        final DocumentDecoderService decoderService = DocumentDecoderService.getInstance();

        for (String rawDocument : ExampleDocuments.RAW_DOCUMENTS) {
            try {
                final Document document = decoderService.decode(rawDocument);
                if (document instanceof InvalidDocument invalidDocument) {
                    // Ejemplo para mostrar el nuevo 'instanceof'
                    System.out.println("OK -> " + invalidDocument);
                } else {
                    System.out.println("OK -> " + document);
                }
            } catch (DecoderException e) {
                System.out.println("Error -> " + e.getMessage());
            }
        }

    }

}