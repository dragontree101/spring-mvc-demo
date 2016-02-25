package com.dragon.study.demo.controller;

import com.alibaba.fastjson.JSON;
import com.dragon.study.demo.constant.Constant;
import com.dragon.study.demo.service.IDemoService;
import com.dragon.study.demo.vo.Message;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
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

    @RequestMapping(value = "visitConfigDemo", produces = Constant.CONTENT_TYPE)
    @ResponseBody
    public String visitConfigDemo(HttpServletRequest request) {
        logger.info("start visit config demo");
        Config appConfig1 = ConfigFactory.load("app-config-1.conf");
        logger.info("config1, complex-app.something=" + appConfig1.getString("complex-app.something"));
        logger.info("config1, simple-lib.foo=" + appConfig1.getString("simple-lib.foo"));
        logger.info("config1, simple-lib.whatever=" + appConfig1.getString("simple-lib.whatever"));

        Config appConfig2 = ConfigFactory.load("app-config-2.conf");
        logger.info("config2, complex-app.simple-lib-context.simple-lib.foo=" + appConfig2.getString("complex-app.simple-lib-context.simple-lib.foo"));
        logger.info("config2, complex-app.simple-lib-context.simple-lib.whatever=" + appConfig2.getString("complex-app.simple-lib-context.simple-lib.whatever"));

        Message msg = new Message(Constant.STATUS_OK, "ok");
        return JSON.toJSONString(msg);
    }

}