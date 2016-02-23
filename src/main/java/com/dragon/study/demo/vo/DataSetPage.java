package com.dragon.study.demo.vo;

import java.util.List;

/**
 * Created by wuweichu on 15/12/22.
 */
public class DataSetPage<T> extends DataSet{
    private Integer totalSize;

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public DataSetPage(List content, Integer totalSize) {
        super(content);
        this.totalSize = totalSize;
    }
}
