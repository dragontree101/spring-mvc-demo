package com.dragon.study.demo.service.impl;

import com.dragon.study.demo.mapper.DemoMapper;
import com.dragon.study.demo.model.DemoModel;
import com.dragon.study.demo.service.IDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dragon on 16/2/23.
 */
@Service
public class DemoServiceImpl implements IDemoService {

    private final static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public void visitService() {
        DemoModel demoModel1 = new DemoModel("龙哲", 30, 100);
        demoMapper.insertDemo(demoModel1);

        DemoModel demoModel2 = new DemoModel("孙晓萍", 29, 94);
        demoMapper.insertDemo(demoModel2);

        DemoModel demoModel3 = new DemoModel("龙若妍", 2, 7);
        demoMapper.insertDemo(demoModel3);


        List<DemoModel> demoModelList = demoMapper.getAllDemos();
        for (DemoModel demoModel : demoModelList) {
            logger.info("demo model is {}", demoModel.toString());
        }

        demoMapper.deleteDemo("龙哲");
        demoMapper.deleteDemo("龙若妍");
        demoMapper.deleteDemo("孙晓萍");
    }
}
