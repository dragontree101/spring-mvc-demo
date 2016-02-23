package com.dragon.study.demo.vo;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class DataSet<T> extends Message{

    // -- 返回结果 --//                                        
    protected List<T> content = Lists.newArrayList();

	public DataSet() {
	}
    
	public DataSet(int falg) {
		super(falg);
	}
	
	public DataSet(List<T> content) {
		this.content=content;
	}
	
	public DataSet(int falg,String msg) {
		super(falg,msg);
	}
	

	public boolean hasContent() {
		return !content.isEmpty();
	}
	
    /**
     * 获得页内的记录列表.
     */
    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    /**
     * 设置页内的记录列表.
     */
    public void setContent(final List<T> content) {
        this.content = content;
    }



}
