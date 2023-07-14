package com.example.demo.hobby.domain.request;

import com.example.demo.hobby.domain.entity.Hobby;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HobbyRequest {
    private Long id;
    private String name;

    public Hobby toEntity() {
        Hobby hobby = new Hobby();
        return hobby;
    }
}
