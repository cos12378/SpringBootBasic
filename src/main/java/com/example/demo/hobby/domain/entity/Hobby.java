package com.example.demo.hobby.domain.entity;


import com.example.demo.member.domain.entity.Member;
import com.example.demo.memberHobby.entity.MemberHobby;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

// jakarta.persistence api
// jpa
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hobbies")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "hobby", cascade = CascadeType.ALL)
    private List<MemberHobby> memberHobbies;

    public void addMemberHobby(MemberHobby memberHobby) {
        this.memberHobbies.add(memberHobby);
    }

    public Hobby(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
