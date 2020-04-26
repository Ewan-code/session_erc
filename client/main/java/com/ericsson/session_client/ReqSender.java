package com.ericsson.session_client;

import com.ericsson.session_client.dto.JsonDto;
import com.ericsson.session_client.dto.RequestDto;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

/**
 * @Description
 * @auther hewang
 * @create 2020-04-26 17:25
 * @idea:
 */
@Slf4j
public class ReqSender implements Runnable {
    private final RestTemplate restTemplate;
    private RequestDto req;
    private Map<Long, RequestDto> sessionMap;

    public ReqSender(RequestDto req, Map<Long, RequestDto> sessionMap) {
        restTemplate = new RestTemplate();
        this.req = req;
        this.sessionMap = sessionMap;
    }

    @Override
    public void run() {
        String url = "http://localhost:8081/nbi/deliverysession?id=" + req.getDeliverySessionId();
        JsonDto result;
        if (req.getActionType().equals("start")){
            result = restTemplate.postForObject(url, req, JsonDto.class);
        }else {
            Long time = req.getStopTime() - req.getStartTime();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = restTemplate.postForObject(url, req, JsonDto.class);
            if (result.getCode().equals("200 OK")) {
                sessionMap.remove(req.getDeliverySessionId());
            }
        }
        log.info(new Date().toString());
        log.info(url);
        log.info(req.toString());
        log.info(result.getCode());
    }
}
