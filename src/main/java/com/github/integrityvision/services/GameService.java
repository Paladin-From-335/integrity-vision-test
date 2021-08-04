package com.github.integrityvision.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    public List<String> compareWords(String [] words) {
        List<String> responseList = new ArrayList<>();
        if (words.length == 1) {
            responseList.add(words[0]);
            return responseList;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].isEmpty() || words[i].isBlank() || words[i] == null) {
                return responseList;
            }
            if (words[i + 1].isEmpty() || words[i + 1].isBlank() || words[i + 1] == null) {
                responseList.add(words[i]);
                return responseList;
            }
            if (words[i].endsWith(String.valueOf(words[i + 1].charAt(0)).toLowerCase())) {
                responseList.add(words[i]);
                if (words[i + 1] == (words[words.length - 1])) {
                    responseList.add(words[words.length - 1]);
                }
            } else {
                responseList.add(words[i]);
                return responseList;
            }
        }
        return responseList;
    }
}
