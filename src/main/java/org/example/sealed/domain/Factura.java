package org.example.sealed.domain;

public abstract sealed class Factura extends Document permits FacturaComercial, FacturaProduccion, FacturaVenta {

}
