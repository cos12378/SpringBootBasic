package com.example.demo.member.domain.entity;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.memberHobby.entity.MemberHobby;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Builder
@Table(name = "members")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MemberHobby> memberHobbies;

    public void addMemberHobby(MemberHobby memberHobby) {
        this.memberHobbies.add(memberHobby);
    }

    public Member(Long id, String name, Integer age) {
        this.id = getId();
        this.name = name;
        this.age = age;
    }
}
