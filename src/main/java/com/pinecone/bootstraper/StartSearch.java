package com.pinecone.bootstraper;

import com.pinecone.config.SearchConfig;
import com.pinecone.engine.FindByInnerTags;
import com.pinecone.util.FileConverter;

import java.io.File;
import java.io.IOException;

public class StartSearch {

    private SearchConfig searchConfig;

    private StartSearch(String elementId, File baseFile, File targetFile) throws IOException {
        searchConfig = new SearchConfig(elementId, FileConverter.convertFileToDocument(baseFile));
        new FindByInnerTags(searchConfig, targetFile);
    }

    public static void main(String[] args) throws IOException {
        int numberOfCases = args.length - 1;
        while (numberOfCases > 0) {
            new StartSearch(
                    args[0],
                    FileConverter.convertToFile(args[1]),
                    FileConverter.convertToFile(args[numberOfCases])
            );
            numberOfCases--;
        }
    }


    public SearchConfig getSearchConfig() {
        return searchConfig;
    }
}
