package org.example.sealed.service.spi;

import java.util.ArrayList;
import java.util.List;

public class DocumentDecoderAppender {

    final ArrayList<DocumentDecoderInstance> instances = new ArrayList<>();

    public void append(DocumentDecoderInstance instance) {
        instances.add(instance);
    }

    public List<DocumentDecoderInstance> getInstances() {
        return instances;
    }

}
