package com.clouway;

import com.clouway.CustomExceptions.NoNextPageException;
import com.clouway.CustomExceptions.NoPreviousPageException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PageBean<T> {
    private List<T> origin;
    List<T> page = new LinkedList<>();
    private int pageSize;
    private int currentIndex = 0;
    private int currentPageNumber = 0;
    private int stepsMade = 0;

    /**
     * Constructor
     * @param origin list being cut into pages
     * @param pageSize lenght of pages
     */
    public PageBean(List<T> origin, int pageSize) {
        this.origin = origin;
        if(pageSize>0)
            this.pageSize = pageSize;
        else {
            this.pageSize = 1;
        }
    }

    /**
     * Puts elements from next page according to currentIndex into list
     * @return list of next page elements
     * @throws NoNextPageException if there is no next page
     */
    public List<T> next() throws NoNextPageException {
        if(!hasNext()){
            throw new NoNextPageException("There is no next page");
        }
        page.clear();
        stepsMade = 0;
        for(int i = 0 ; i < pageSize ; i++){
            if(currentIndex<origin.size()) {
                page.add(origin.get(currentIndex));
                currentIndex++;
                stepsMade++;
            }
        }
        currentPageNumber++;
        return page;
    }


    /**
     * Puts elements from previous page into list and reverses them
     * @return list with elements of previous page
     * @throws NoPreviousPageException if there is no previous page
     */
    public List<T> previous() throws NoPreviousPageException {
        if(!hasPrevious()){
            throw new NoPreviousPageException("There is no previous page");
        }
        page.clear();
        if(currentIndex>=origin.size()) {
            currentIndex -= stepsMade;
        }
        else {
            currentIndex -=pageSize;
        }

        for(int i = 1 ; i <= pageSize ; i++){
            page.add(origin.get(currentIndex-i));
        }
        Collections.reverse(page);
        currentPageNumber--;
        return page;
    }

    /**
     * Checks if there is next page
     * @return true if there is next page, false if not
     */
    public boolean hasNext() {
        return (currentIndex< origin.size());
    }

    /**
     * Checks if there is previous page
     * @return true if there is previous page
     */
    public boolean hasPrevious() {
        return (currentIndex-pageSize>0);
    }

    /**
     * Moves currentIndex and currentPageNumber to initial positions and calls next()
     * @return initial next() call
     */
    public List<T> firstPage() {
        currentIndex = 0;
        currentPageNumber = 0;
        try {
            return next();
        } catch (NoNextPageException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Moves currentIndex and currentPageNumber to last page position
     * If last page is not a full page, currentIndex is set to match that
     * else last page is full page, currentIndex is moved pageSize times away the end of origin
     * @return first page
     */
    public List<T> lastPage() {
        if(origin.size()==0){
            currentIndex = 0;
            currentPageNumber = 0;
        } else if(origin.size()%pageSize!=0) {
            currentIndex = (origin.size() / pageSize) * pageSize;
            currentPageNumber = origin.size() / pageSize;
        }else {
            currentIndex = (origin.size() -pageSize);
            currentPageNumber = (origin.size()/pageSize) -1;
        }
        try {
            return next();
        } catch (NoNextPageException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getCurrentPageNumber(){
        return currentPageNumber;
    }

    public List<T> getCurrentPage() {

        return page;
    }
}