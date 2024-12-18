package org.example.sealed.domain;

final public class FacturaComercial extends Factura {

    final static public String TYPE = "facturacomercial";

    final private String p1;

    public FacturaComercial(String p1) {
        this.p1 = p1;
    }

    public String getP1() {
        return p1;
    }

    @Override
    public String toString() {
        return "FacturaComercial{" +
                "p1='" + p1 + '\'' +
                "} " + super.toString();
    }

}
