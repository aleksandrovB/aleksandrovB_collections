package com.clouway;

import java.util.LinkedList;
import java.util.List;

public class TextSplitterToSymbols implements StringToTextSplitterDataSource {
        @Override
        public List<String> cut(String word) {
            List<String> out = new LinkedList<>();
            for (int i = 0; i < word.length(); i++) {
                if ((!String.valueOf(word.charAt(i)).equals(" "))) {
                    out.add(String.valueOf(word.charAt(i)));
                }
            }
            return out;
        }
    }

