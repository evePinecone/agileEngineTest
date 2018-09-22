package com.pinecone.engine;

import com.pinecone.config.SearchConfig;
import com.pinecone.util.ElementEntity;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindByInnerAttributes {

    private SearchConfig searchConfig;


    public FindByInnerAttributes(SearchConfig searchConfig) {
        this.searchConfig = searchConfig;
    }


    public Element findElement(Document targetDocument) {
        Element baseElement = searchConfig.getDocument().getElementById(searchConfig.getElementId());
        List<ElementEntity> listOfTargetElements = new ArrayList<>();

        Attributes baseAttributes = baseElement.attributes();
        for (Attribute baseAttribute : baseAttributes) {
            Elements elements = targetDocument.getElementsByAttributeValue(
                    baseAttribute.getKey(),
                    baseAttribute.getValue()
            );
            for (Element element : elements) {
                ElementEntity elementEntity = new ElementEntity(element);
                if (listOfTargetElements.contains(elementEntity)) {
                    Integer i = listOfTargetElements.indexOf(elementEntity);
                    listOfTargetElements.get(i).anotherOneAttributeEquals();
                } else {
                    listOfTargetElements.add(elementEntity);
                }
            }
        }

        Collections.sort(listOfTargetElements);
        return listOfTargetElements.get(listOfTargetElements.size() - 1).getElement();
    }
}
