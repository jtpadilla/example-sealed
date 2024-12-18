package org.example.sealed.domain;

final public class ReciboCompuestoSinMetadatos extends ReciboCompuesto {

    final static public String TYPE = "recibocompuestosinmetadatos";

    final private String p1;
    final private String p2;

    public ReciboCompuestoSinMetadatos(String p1, String p2) {
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
        return "ReciboCompuestoSinMetadatos{" +
                "p1='" + p1 + '\'' +
                ", p2='" + p2 + '\'' +
                "} " + super.toString();
    }

}
