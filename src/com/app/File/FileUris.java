package com.app.File;

import java.io.IOException;
import java.util.List;

public interface FileUris {
    List<String> fileUris(String filePath) throws IOException;
    List<String> fileUrisWithSpecificTerm(List<String> filePath, String term);
}
