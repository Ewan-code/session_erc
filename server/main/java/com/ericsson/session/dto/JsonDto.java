package com.ericsson.session.dto;

import lombok.*;

/**
 * @Description
 * @auther hewang
 * @create 2020-04-25 23:49
 * @idea:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JsonDto {

    private String code;
    private String data;
}