package com.portlet.model;

import lombok.Data;


@Data
public class BestEmployee implements Comparable<BestEmployee> {
    Long id;
    int count;
    Long sum;

    @Override
    public int compareTo(BestEmployee o) {
        return Integer.compare(this.getCount(), o.getCount());
    }
}
