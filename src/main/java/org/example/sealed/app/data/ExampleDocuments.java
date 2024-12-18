package org.example.sealed.app.data;

import java.util.List;

public class ExampleDocuments {

    static final public List<String> RAW_DOCUMENTS = List.of(
            "albaranproduccion,param1",
            "albaranventa,param1,param2",
            "albarancomercial,param1,param2,param3",
            "facturacomercial,param1",
            "facturaproduccion,param1,param2",
            "facturaventa,param1,param2,param3",
            "recibocompuestoconmetadatos,param1",
            "recibocompuestosinmetadatos,param1,param2",
            "recibosimple,param1,param2,param3",
            // Errores
            "desconocido,param1,param2,param3", // tipo desconocido (error de clasificacion)
            "albarancomercial,param1" // le faltan parametros (error de parseo)
    );
}
