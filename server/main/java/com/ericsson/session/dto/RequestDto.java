package com.ericsson.session.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @auther hewang
 * @create 2020-04-25 23:59
 * @idea:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
