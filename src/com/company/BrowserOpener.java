package com.company;

import java.io.IOException;
import java.util.List;

public interface BrowserOpener {
    void openBrowser(List<String> browserUri) throws IOException;
}
