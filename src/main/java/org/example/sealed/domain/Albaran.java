package org.example.sealed.domain;

public abstract sealed class Albaran extends Document {

    // Si las clases hijas de una clase sellada son Iner class no se
    // necesita la clausula 'sealed' en la clase Albaran.

    static public final class AlbaranProduccion extends Albaran {

        final static public String TYPE = "albaranproduccion";

        final private String p1;

        public AlbaranProduccion(String p1) {
            this.p1 = p1;
        }

        public String getP1() {
            return p1;
        }

        @Override
        public String toString() {
            return "AlbaranProduccion{" +
                    "p1='" + p1 + '\'' +
                    "} " + super.toString();
        }

    }

    static public final class AlbaranVenta extends Albaran {

        final static public String TYPE = "albaranventa";

        final private String p1;
        final private String p2;

        public AlbaranVenta(String p1, String p2) {
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
            return "AlbaranVenta{" +
                    "p1='" + p1 + '\'' +
                    ", p2='" + p2 + '\'' +
                    "} " + super.toString();
        }

    }


    static public final class AlbaranComercial extends Albaran {

        final static public String TYPE = "albarancomercial";

        final private String p1;
        final private String p2;
        final private String p3;

        public AlbaranComercial(String p1, String p2, String p3) {
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
            return "AlbaranComercial{" +
                    "p1='" + p1 + '\'' +
                    ", p2='" + p2 + '\'' +
                    ", p3='" + p3 + '\'' +
                    "} " + super.toString();
        }

    }

}
