package com.boc.test.weather.dto;

public class MetaData {
    private long itemsCount;
    private int pagesCount;

    public MetaData(long itemsCount, int pagesCount) {
        this.itemsCount = itemsCount;
        this.pagesCount = pagesCount;
    }

    public long getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(long itemsCount) {
        this.itemsCount = itemsCount;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }
}
