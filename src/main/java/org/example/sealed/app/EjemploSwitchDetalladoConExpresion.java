package org.example.sealed.app;

import org.example.sealed.app.data.ExampleDocuments;
import org.example.sealed.domain.*;
import org.example.sealed.service.DocumentDecoderService;
import org.example.sealed.service.impl.util.DecoderException;

// Solo para demostrar como utilizar el switch como una expresion.
public class EjemploSwitchDetalladoConExpresion {

    public static void main(String[] args) {
        new EjemploSwitchDetalladoConExpresion().run();
    }

    public void run() {

        final DocumentDecoderService decoderService = DocumentDecoderService.getInstance();

        final StringBuilder stringBuilder = new StringBuilder();

        for (String rawDocument : ExampleDocuments.RAW_DOCUMENTS) {
            try {
                final String toString = switch (decoderService.decode(rawDocument)) {
                    case Albaran.AlbaranComercial albaranComercial -> albaranComercial.toString();
                    case Albaran.AlbaranProduccion albaranProduccion -> albaranProduccion.toString();
                    case Albaran.AlbaranVenta albaranVenta -> albaranVenta.toString();
                    case FacturaComercial facturaComercial -> facturaComercial.toString();
                    case FacturaProduccion facturaProduccion -> facturaProduccion.toString();
                    case FacturaVenta facturaVenta -> facturaVenta.toString();
                    case ReciboCompuestoConMetadatos reciboCompuestoConMetadatos -> reciboCompuestoConMetadatos.toString();
                    case ReciboCompuestoSinMetadatos reciboCompuestoSinMetadatos -> reciboCompuestoSinMetadatos.toString();
                    case ReciboSimple reciboSimple -> reciboSimple.toString();
                    case InvalidDocument invalidDocument -> invalidDocument.toString();
                }; // ahora con ; al final
                stringBuilder.append(toString).append("\n");
            } catch (DecoderException e) {
                System.out.println("Error -> " + e.getMessage());
            }
        }
        System.out.println("---------------------------");
        System.out.println(stringBuilder);

    }

}