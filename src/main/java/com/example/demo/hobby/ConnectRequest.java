package com.example.demo.hobby;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConnectRequest {
    private Integer memberId;
    private Integer hobbyId;
}
