package com.clouway;

import com.clouway.CustomExceptions.NoNextPageException;
import com.clouway.CustomExceptions.NoPreviousPageException;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void callPageBean(List list, int size){
        PageBean pageBean = new PageBean(list,size);

        Scanner scan = new Scanner(System.in);
        boolean whileSpins = true;
        while(whileSpins)
        {
            String nextLine = scan.nextLine().trim();
            switch (nextLine)
            {
                case "next":
                    System.out.print("Next page: ");
                    try {
                        System.out.println(pageBean.next());
                    } catch (NoNextPageException noNextPage) {
                        System.err.println(noNextPage.getMessage());
                    }
                    System.out.println(pageBean.getCurrentPageNumber());
                    break;
                case "previous":
                    System.out.print("Previous page: ");
                    try {
                        System.out.println(pageBean.previous());
                    } catch (NoPreviousPageException noPreviousPage) {
                        System.err.println(noPreviousPage.getMessage());
                    }
                    System.out.println(pageBean.getCurrentPageNumber());
                    break;
                case "hasNext":
                    System.out.print("Has next page: ");
                    System.out.println(pageBean.hasNext());
                    break;
                case "hasPrevious":
                    System.out.print("Has previous page: ");
                    System.out.println(pageBean.hasPrevious());
                    break;
                case "firstPage":
                    System.out.print("First page: ");
                    System.out.println(pageBean.firstPage());
                    System.out.println(pageBean.getCurrentPageNumber());
                    break;
                case "lastPage":
                    System.out.print("Last page: ");
                    System.out.println(pageBean.lastPage());
                    System.out.println(pageBean.getCurrentPageNumber());
                    break;
                case "stop":
                    if(scan!=null)
                        scan.close();
                    whileSpins = false;
                    break;
            }
        }
    }
    public static void main(String[] args) {
        List<Integer> integerList = new LinkedList<>();
        for(int i = 0 ; i < 30 ; i++){
            integerList.add(i);
        }

        //callPageBean(integerList,5);

        System.out.println(new FrequencyAnalyser().getMostFrequent("Niki IlievNN",new TextSplitterToSymbols()));
    }
}
