package com.ericsson.session_client;

import com.ericsson.session_client.dto.RequestDto;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @Description
 * @auther hewang
 * @create 2020-04-27 00:58
 * @idea:
 */
public class SessionCreator {
    private Map<Long, RequestDto> sessionMap;
    private ThreadPoolExecutor threadPool;


    public SessionCreator() {
        sessionMap = new ConcurrentHashMap<>();
        threadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                3L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }

    public void creator() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("id: ");
            Long id = -1L, sec = -1L;
            if (scanner.hasNext()) {
                id = scanner.nextLong();
            }
            System.out.print("life span: ");
            if (scanner.hasNext()) {
                sec = scanner.nextLong();
            }
            if (!sessionMap.containsKey(id)) {
                RequestDto reqStart = new RequestDto().builder()
                        .actionType("start")
                        .deliverySessionId(id)
                        .startTime(System.currentTimeMillis())
                        .stopTime(System.currentTimeMillis() + sec * 1000)
                        .TMGI("tmgi")
                        .TMGIPool("tmgipool")
                        .version("0.1")
                        .build();
                RequestDto reqStop = new RequestDto().builder()
                        .actionType("stop")
                        .deliverySessionId(id)
                        .startTime(System.currentTimeMillis())
                        .stopTime(System.currentTimeMillis() + sec * 1000)
                        .TMGI("tmgi")
                        .TMGIPool("tmgipool")
                        .version("0.1")
                        .build();
                sessionMap.put(id, reqStop);
                threadPool.execute(new ReqSender(reqStart, sessionMap));
                threadPool.execute(new ReqSender(reqStop, sessionMap));
            } else {
                System.out.println("session " + id + "is in process");
            }
        }
    }
}
