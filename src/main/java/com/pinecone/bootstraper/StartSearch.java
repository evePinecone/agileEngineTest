package com.pinecone.bootstraper;

import com.pinecone.config.SearchConfig;
import com.pinecone.engine.FindByInnerAttributes;
import com.pinecone.util.FileConverter;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

public class StartSearch {

    private SearchConfig searchConfig;

    private StartSearch(String elementId, File baseFile, File targetFile) throws IOException {
        searchConfig = new SearchConfig(elementId, FileConverter.convertFileToDocument(baseFile));
        Element foundElement = new FindByInnerAttributes(searchConfig)
                .findElement(FileConverter.convertFileToDocument(targetFile));

        System.out.println("File " + targetFile.getName() + "\n\t" + FileConverter.constructPath(foundElement));
    }

    public static void main(String[] args) throws IOException {
        int numberOfCases = args.length - 1;
        while (numberOfCases > 1) {
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
