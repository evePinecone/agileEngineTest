package com.pinecone.util;

import org.jsoup.nodes.Element;

import java.util.Objects;

public class ElementEntity implements Comparable {

    private Element element;
    private Integer counter;

    public Element getElement() {
        return element;
    }

    private Integer getCounter() {
        return counter;
    }

    public void anotherOneAttributeEquals() {
        this.counter++;
    }

    public ElementEntity(Element element) {
        this.element = element;
        this.counter = 1;
    }

    @Override
    public int compareTo(Object o) {
        ElementEntity elementEntity = (ElementEntity) o;
        return counter.compareTo(elementEntity.getCounter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementEntity that = (ElementEntity) o;
        return Objects.equals(element, that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }
}
