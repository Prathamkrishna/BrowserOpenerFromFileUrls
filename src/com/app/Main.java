package com.app;

import java.io.IOException;
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
