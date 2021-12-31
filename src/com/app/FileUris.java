package com.app;

import java.io.IOException;
import java.util.List;

public interface FileUris {
    List<String> fileUris(String filePath) throws IOException;
}
