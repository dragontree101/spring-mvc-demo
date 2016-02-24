package com.dragon.study.demo.controller;

import com.alibaba.fastjson.JSON;
import com.dragon.study.demo.constant.Constant;
import com.dragon.study.demo.service.IDemoService;
import com.dragon.study.demo.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dragon on 16/2/23.
 */

@Controller
@RequestMapping("/")
public class DemoController {
    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private IDemoService demoService;

    @RequestMapping(value = "visitDemo", produces = Constant.CONTENT_TYPE)
    @ResponseBody
    public String visitDemo(HttpServletRequest request) {
        logger.info("start visit demo");
        demoService.visitService();
        Message msg = new Message(Constant.STATUS_OK, "ok");
        return JSON.toJSONString(msg);
    }

    @RequestMapping(value = "visitExceptionDemo", produces = Constant.CONTENT_TYPE)
    @ResponseBody
    public String visitExceptionDemo(HttpServletRequest request) {
        logger.info("start visit exception demo");
        demoService.visitServiceException();
        Message msg = new Message(Constant.STATUS_OK, "ok");
        return JSON.toJSONString(msg);
    }
}