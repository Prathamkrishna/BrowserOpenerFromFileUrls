package com.app.File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileUrisImpl implements FileUris{
    private final Pattern patternStart = Pattern.compile("www.");
    private final Pattern patternEnd = Pattern.compile(".com");

    @Override
    public List<String> fileUris(String filePath) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String st;
        while ((st = bufferedReader.readLine()) != null){
            Matcher matcherStart = patternStart.matcher(st);
            Matcher matcherEnd = patternEnd.matcher(st);
            if (matcherStart.find() && matcherEnd.find()){
                if (st.indexOf(" ", matcherEnd.end()) == -1){
                    list.add(st.substring(matcherStart.start()));
                }
                else
                    list.add(st.substring(matcherStart.start(), st.indexOf(" ", matcherEnd.end())));
            }
        }
        return list;
    }

    @Override
    public List<String> fileUrisWithSpecificTerm(List<String> fileUrls, String term) {
        return fileUrls.stream().filter(term1 -> term1.contains(term)).collect(Collectors.toList());
    }
}
