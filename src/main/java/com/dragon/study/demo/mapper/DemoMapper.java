package com.dragon.study.demo.mapper;

import com.dragon.study.demo.model.DemoModel;

import java.util.List;

/**
 * Created by dragon on 16/2/23.
 */
public interface DemoMapper {
    List<DemoModel> getAllDemos();
    void insertDemo(DemoModel model);
    void deleteDemo(String name);
}
