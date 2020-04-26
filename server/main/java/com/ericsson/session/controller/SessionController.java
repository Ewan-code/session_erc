package com.ericsson.session.controller;

import com.ericsson.session.dto.JsonDto;
import com.ericsson.session.dto.RequestDto;
import com.ericsson.session.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description
 * @auther hewang
 * @create 2020-04-25 17:28
 * @idea:
 */
@RestController
public class SessionController {
    @Autowired
    SessionService sessionService;

    @RequestMapping("/nbi/deliverysession")
    public JsonDto sessionHandler(long id, @RequestBody RequestDto req, HttpSession session){
        return sessionService.sessionService(id, req, session);
    }
}
