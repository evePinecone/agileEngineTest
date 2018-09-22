package com.pinecone.config;

import org.jsoup.nodes.Document;

public class SearchConfig {
    private String elementId;
    private Document document;

    public SearchConfig(String elementId, Document document) {
        this.elementId = elementId;
        this.document = document;
    }

    public String getElementId() {
        return elementId;
    }

    public Document getDocument() {
        return document;
    }
}
