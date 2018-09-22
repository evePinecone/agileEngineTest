package com.pinecone.engine;

import com.pinecone.config.SearchConfig;
import org.jsoup.nodes.Document;

import java.io.File;

public class FindByInnerTags {

    public FindByInnerTags(SearchConfig searchConfig, File targetFile) {
        Document document = searchConfig.getDocument();
        document.getElementById(searchConfig.getElementId());
    }

}
