package com.ericsson.session.service;

import com.ericsson.session.dto.JsonDto;
import com.ericsson.session.dto.RequestDto;
import com.ericsson.session.util.PredefinedConst;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Description
 * @auther hewang
 * @create 2020-04-25 17:29
 * @idea:
 */
@Service
public class SessionService {

    public JsonDto sessionService(long id, RequestDto req, HttpSession session){
        if (req.getActionType().equalsIgnoreCase(PredefinedConst.START)){
            return new JsonDto().builder().code("200 OK").data("SessionID: " + session.getId()).build();
        }else {
            session.invalidate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new JsonDto().builder().code("200 OK").data("Session stops successfully").build();
        }
    }
}
