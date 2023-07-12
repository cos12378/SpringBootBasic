package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.MemberHobby;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
public class HobbyResponse {
    private Integer hobbyId;
    private String hobbyName;

    private List<MemberResponse2> memberResponse2List = new ArrayList<>();

    public HobbyResponse(Hobby hobby) {
        this.hobbyId = hobby.getId();
        this.hobbyName = hobby.getName();
        this.memberResponse2List = hobby.getMemberHobbies().stream()
                .map(MemberHobby::getMember)
                .map(MemberResponse2::new)
                .toList();
    }

    class MemberResponse2 {
        private Integer memberId;
        private String memberName;

        public MemberResponse2(Member member) {
            this.memberId = member.getId();
            this.memberName = member.getName();
        }

        public Integer getMemberId() {
            return memberId;
        }

        public String getMemberName() {
            return memberName;
        }
    }

}

