package org.example.sealed.domain;

final public class ReciboCompuestoConMetadatos extends ReciboCompuesto {

    final static public String TYPE = "recibocompuestoconmetadatos";

    final private String p1;

    public ReciboCompuestoConMetadatos(String p1) {
        this.p1 = p1;
    }

    public String getP1() {
        return p1;
    }

    @Override
    public String toString() {
        return "ReciboCompuestoConMetadatos{" +
                "p1='" + p1 + '\'' +
                "} " + super.toString();
    }

}
