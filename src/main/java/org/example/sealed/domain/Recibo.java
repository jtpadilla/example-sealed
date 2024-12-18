package org.example.sealed.domain;

public abstract sealed class Recibo extends Document permits ReciboCompuesto, ReciboSimple {
}
