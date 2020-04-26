package com.ericsson.session_client.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @auther hewang
 * @create 2020-04-26 17:33
 * @idea:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RequestDto {

    @NotNull
    private Long deliverySessionId;
    @NotNull
    private String actionType;
    private String TMGIPool;
    private String TMGI;
    @NotNull
    private Long startTime;
    @NotNull
    private Long stopTime;
    @NotNull
    private String version;
}
