package com.example.demo.hobby;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConnectRequest {
    private Long memberId;
    private Long hobbyId;
}