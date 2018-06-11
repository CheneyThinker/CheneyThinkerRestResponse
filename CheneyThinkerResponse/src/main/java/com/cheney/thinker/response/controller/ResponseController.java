package com.cheney.thinker.response.controller;

import com.cheney.thinker.response.core.Response;
import com.cheney.thinker.response.core.ResponseGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * description demo of response
 * author CheneyThinker
 * date 2018-06-11
 */
@RestController
@RequestMapping("/response")
@CrossOrigin(maxAge = 3600, origins = "*")
public class ResponseController {

    @RequestMapping("/simple")
    public Response simple() {
        try {
            return ResponseGenerator.genOk();
        } catch (Exception e) {
            return ResponseGenerator.genNo(e, "Call simple fail!");
        }
    }

    @RequestMapping("/simple_exception")
    public Response simpleException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            return ResponseGenerator.genNo(e, "Call complex fail!");
        }
    }

    @RequestMapping("/complex")
    public Response complex() {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("projectName", "Response");
            map.put("version", 1.0);
            return ResponseGenerator.genOk(map);
        } catch (Exception e) {
            return ResponseGenerator.genNo(e, "Call complex fail!");
        }
    }

    @RequestMapping("/complex_exception")
    public Response complexException() {
        try {
            throw new Exception("Get Data Fail!");
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<>();
            map.put("projectName", "Response");
            map.put("version", 1.0);
            return ResponseGenerator.genNo(map, e, "Call complex fail!");
        }
    }

}
