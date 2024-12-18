package org.example.sealed.service.impl.util;

import java.util.List;

public record DecoderData(String type, List<String> parameters) {

    public String getParameter1(int index) throws DecoderException {
        if (index < 0 || index >= parameters.size()) {
            throw new DecoderException("No hay ningun parametro en la posicion " + index);
        }
        return parameters.get(index);
    }

}
