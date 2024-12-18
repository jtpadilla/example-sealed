package org.example.sealed.domain;

final public class InvalidDocument extends Document {

    final static public String TYPE = "recibosimple";

    final private String rawDocument;

    public InvalidDocument(String rawDocument) {
        this.rawDocument = rawDocument;
    }

    public String getRawDocument() {
        return rawDocument;
    }

    @Override
    public String toString() {
        return "InvalidDocument{" +
                "rawDocument='" + rawDocument + '\'' +
                "} " + super.toString();
    }

}
