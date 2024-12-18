package org.example.sealed.app;

import org.example.sealed.app.data.ExampleDocuments;
import org.example.sealed.domain.*;
import org.example.sealed.service.DocumentDecoderService;
import org.example.sealed.service.impl.util.DecoderException;

public class EjemploSwitchAgrupados {

    public static void main(String[] args) {
        new EjemploSwitchAgrupados().run();
    }

    public void run() {

        final DocumentDecoderService decoderService = DocumentDecoderService.getInstance();

        for (String rawDocument : ExampleDocuments.RAW_DOCUMENTS) {
            try {
                switch (decoderService.decode(rawDocument)) {
                    case Albaran albaran -> System.out.println("Albaran OK -> " + albaran);
                    case Factura factura -> System.out.println("Factura OK -> " + factura);
                    case Recibo recibo -> System.out.println("Recibo OK -> " + recibo);
                    case InvalidDocument invalidDocument -> System.out.println("Invalid OK -> " + invalidDocument);
                }
            } catch (DecoderException e) {
                System.out.println("Error -> " + e.getMessage());
            }
        }

    }

}