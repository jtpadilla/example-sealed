package org.example.sealed.domain;

final public class FacturaVenta extends Factura {

    final static public String TYPE = "facturaventa";

    final private String p1;
    final private String p2;
    final private String p3;

    public FacturaVenta(String p1, String p2, String p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public String getP1() {
        return p1;
    }

    public String getP2() {
        return p2;
    }

    public String getP3() {
        return p3;
    }

    @Override
    public String toString() {
        return "FacturaVenta{" +
                "p1='" + p1 + '\'' +
                ", p2='" + p2 + '\'' +
                ", p3='" + p3 + '\'' +
                "} " + super.toString();
    }

}
