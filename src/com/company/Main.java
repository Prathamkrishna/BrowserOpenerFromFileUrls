package com.company;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileUris fileUris = new FileUrisImpl();
        BrowserOpener browserOpener = new BrowserOpenerImpl();
        String filePath = scanner.nextLine();
        browserOpener.openBrowser(fileUris.fileUris(filePath));
    }
}
