package org.example.sealed.app;

import org.example.sealed.app.data.ExampleDocuments;
import org.example.sealed.domain.*;
import org.example.sealed.service.DocumentDecoderService;
import org.example.sealed.service.impl.util.DecoderException;

public class EjemploSwitchDetallado {

    public static void main(String[] args) {
        new EjemploSwitchDetallado().run();
    }

    public void run() {

        final DocumentDecoderService decoderService = DocumentDecoderService.getInstance();

        for (String rawDocument : ExampleDocuments.RAW_DOCUMENTS) {
            try {
                switch (decoderService.decode(rawDocument)) {
                    case Albaran.AlbaranComercial albaranComercial -> System.out.println("Albaran Comercial OK -> " + albaranComercial);
                    case Albaran.AlbaranProduccion albaranProduccion -> System.out.println("Albaran Produccion OK -> " + albaranProduccion);
                    case Albaran.AlbaranVenta albaranVenta -> System.out.println("Albaran Venta OK -> " + albaranVenta);
                    case FacturaComercial facturaComercial -> System.out.println("Factura Comercial OK -> " + facturaComercial);
                    case FacturaProduccion facturaProduccion -> System.out.println("Factura Produccion OK -> " + facturaProduccion);
                    case FacturaVenta facturaVenta -> System.out.println("Factura Venta OK -> " + facturaVenta);
                    case ReciboCompuestoConMetadatos reciboCompuestoConMetadatos -> System.out.println("Recibo Compuesto Con Metadatos OK -> " + reciboCompuestoConMetadatos);
                    case ReciboCompuestoSinMetadatos reciboCompuestoSinMetadatos -> System.out.println("Recibo Compuesto Sin Metadatos OK -> " + reciboCompuestoSinMetadatos);
                    case ReciboSimple reciboSimple -> System.out.println("Recibo Simple OK -> " + reciboSimple);
                    case InvalidDocument invalidDocument -> System.out.println("Invalid OK -> " + invalidDocument);
                }
            } catch (DecoderException e) {
                System.out.println("Error -> " + e.getMessage());
            }
        }

    }

}