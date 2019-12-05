package com.zking.oa.vo;

import com.zking.oa.model.Book;

public class BookVo extends Book {

    private float min;

    private float max;

    public BookVo() {
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "BookVo{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }


}
