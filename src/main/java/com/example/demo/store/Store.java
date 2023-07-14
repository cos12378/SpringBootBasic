package com.example.demo.store;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.memberHobby.entity.MemberHobby;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static List<Member> members = new ArrayList<>();
    public static Integer memberIndex = 0;
    public static List<Hobby> hobbies = new ArrayList<>();
    public static Integer hobbyIndex = 0;

    public static List<MemberHobby> memberHobbies = new ArrayList<>();
}
