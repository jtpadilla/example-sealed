package org.example.sealed.domain;

final public class FacturaProduccion extends Factura {

    final static public String TYPE = "facturaproduccion";

    final private String p1;
    final private String p2;

    public FacturaProduccion(String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String getP1() {
        return p1;
    }

    public String getP2() {
        return p2;
    }

    @Override
    public String toString() {
        return "FacturaProduccion{" +
                "p1='" + p1 + '\'' +
                ", p2='" + p2 + '\'' +
                "} " + super.toString();
    }

}
