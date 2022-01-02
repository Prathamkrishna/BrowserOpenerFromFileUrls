package com.app;

import com.app.Browser.BrowserOpener;
import com.app.Browser.BrowserOpenerImpl;
import com.app.File.FileUris;
import com.app.File.FileUrisImpl;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.*;

import static com.app.Utils.AsyncTasks.finishTasks;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        FileUris fileUri = new FileUrisImpl();
        BrowserOpener browserOpener = new BrowserOpenerImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file path");
        String filePath = scanner.nextLine();
        System.out.println("Are you looking for a specific link with chars?(0 for no and 1 for yes)");
        int charChoice = scanner.nextInt();
        if (charChoice == 0){
            browserOpener.openBrowser(fileUri.fileUris(filePath));
        } if (charChoice == 1){
            System.out.println("Enter the term");
            finishTasks(filePath);
        } else;
    }


}
