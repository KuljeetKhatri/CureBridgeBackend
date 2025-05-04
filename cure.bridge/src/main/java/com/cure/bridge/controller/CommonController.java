package com.cure.bridge.controller;

import com.cure.bridge.request.Request;
import com.cure.bridge.response.Response;
import com.cure.bridge.service.CommonService;
import jdk.jshell.execution.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommonController {
    private final Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private CommonService commonService;

    @PostMapping(value = "/disease/prediction")
    public Response diseasePrediction(@RequestBody Request request){
        Response response = new Response();
        if(!request.getFlag().isEmpty()){
            response = commonService.baseCall(request);
        }

        return response;
    }
}
