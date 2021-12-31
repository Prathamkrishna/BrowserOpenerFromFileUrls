package com.app;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class BrowserOpenerImpl implements BrowserOpener{
    @Override
    public void openBrowser(List<String> browserUris) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        for (int i = 0; i < browserUris.size(); i++) {
            desktop.browse(URI.create("https://" + browserUris.get(i)));
        }
    }
}
