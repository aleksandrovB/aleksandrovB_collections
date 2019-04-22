package com.clouway;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

    public class TextSplitterToWords implements StringToTextSplitterDataSource {
        @Override
        public List<String> cut(String word) {
            return new LinkedList<>(Arrays.asList(word.trim().split(" ")));
        }
}
