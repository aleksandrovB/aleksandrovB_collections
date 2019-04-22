package com.clouway;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencyAnalyser {
    public FrequencyAnalyser() {
    }

    public Map<String, Integer> frequencyAnalysis(String word, StringToTextSplitterDataSource dataSource){
        Map<String, Integer> dataMap = new LinkedHashMap<>();
        for (String fragment: dataSource.cut(word)) {
            if (!dataMap.containsKey(fragment)) {
                dataMap.put(fragment, 1);
            } else {
                dataMap.replace(fragment, dataMap.get(fragment) + 1);
            }
        }
        return dataMap;
    }

    public String getMostFrequent(String word, StringToTextSplitterDataSource dataSource){
        Map<String,Integer> data = frequencyAnalysis(word,dataSource);
        int maxValue = Collections.max(data.values());
        StringBuilder output = new StringBuilder();

        for(Map.Entry<String,Integer> entry : data.entrySet()) {
            if(entry.getValue()==maxValue){
                output.append(entry.getKey()).append(" ");
            }
        }
        return output.toString();
    }

    public String getFrequencyAnalysisFormatted(String word, StringToTextSplitterDataSource dataSource){
        StringBuilder out = new StringBuilder();

        for(Map.Entry<String, Integer> entry : frequencyAnalysis(word,dataSource).entrySet()){
            out.append(entry.getKey());
            out.append(":");
            out.append(entry.getValue());
            out.append(", ");
        }

        return out.toString();
    }
}
