package com.example.demo.memberHobby.entity;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity @AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) //누군가가 대신 생성해줘
@Getter
@Table(name = "member_hobby")
public class MemberHobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hobby hobby;

    public MemberHobby(Member member, Hobby hobby) {
        this.member = member;
        this.hobby = hobby;
        addToMemberAndHobby();
    }

    private void addToMemberAndHobby() {
        this.member.getMemberHobbies().add(this);
        this.hobby.getMemberHobbies().add(this);
    }
}

