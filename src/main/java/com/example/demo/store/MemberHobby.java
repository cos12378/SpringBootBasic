package com.example.demo.store;

import com.example.demo.hobby.Hobby;
import com.example.demo.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberHobby {

    private Member member;
    private Hobby hobby;

    public MemberHobby(Member member, Hobby hobby) {
        this.member = member;
        this.hobby = hobby;
        addToMemberAndHobby();
    }

    private void addToMemberAndHobby() {
        this.member.addMemberHobby(this);
        this.hobby.addMemberHobby(this);
    }
}
