package org.example.sealed.domain;

abstract public sealed class ReciboCompuesto extends Recibo permits ReciboCompuestoConMetadatos, ReciboCompuestoSinMetadatos {
}
