package com.app.Utils;

import com.app.Browser.BrowserOpener;
import com.app.Browser.BrowserOpenerImpl;
import com.app.File.FileUris;
import com.app.File.FileUrisImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncTasks {
    public static void finishTasks(String filePath) throws ExecutionException, InterruptedException {
        BrowserOpener browserOpener = new BrowserOpenerImpl();
        Scanner scanner = new Scanner(System.in);

        CompletableFuture.supplyAsync(scanner::nextLine).thenApply(term-> getFileUrisOfSpecificTerm(filePath, term))
                .thenAccept(urlList->{
                    try {
                            browserOpener.openBrowser(urlList.get());
                    } catch (IOException | InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }).get();
    }

    public static CompletableFuture<List<String>> getFileUrisOfSpecificTerm(String filePath, String term){
        FileUris fileUri = new FileUrisImpl();
        System.out.println(term + "getFileMEthod");
        return CompletableFuture.supplyAsync(() -> {
            try {
                return fileUri.fileUrisWithSpecificTerm(fileUri.fileUris(filePath), term);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
}
