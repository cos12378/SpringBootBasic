package com.example.demo.hobby;


import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.store.MemberHobby;
import com.example.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HobbyService {
    private final MemberService memberService;
    public void save(HobbyRequest request){
//        Member byId = memberService.findById(request.getMemberId());
        Hobby hobby = new Hobby(null, request.getName(), null);
        Store.hobbies.add(hobby);
    }
//    public List<Hobby> findAll(){
//        return h
//    }

    public void createMemberHobby(Integer memberId, Integer hobbyId){
        Member member = memberService.findById(memberId);
        Hobby hobby = Store.hobbies.stream()
                .filter(h->h.getId().equals(hobbyId))
                .findFirst()
                .orElse(null);

        Store.memberHobbies.add(new MemberHobby(member,hobby));
    }

    public List<HobbyResponse> findMemberContainsHobby(String hobbyName) {
        return Store.hobbies.stream()
//                .map(MemberHobby::getHobby)
                .filter(hobby -> hobby.getName().contains(hobbyName))
                .map(HobbyResponse::new)
                .toList();
    }

    public List<HobbyResponse> findByLikeName(String hobbyName){
        return Store.hobbies.stream()
                .filter(h->h.getName().contains(hobbyName))
                .map(m ->new HobbyResponse())
                .toList();
    }

//    public List<Hobby> findAll(){
//        return h
//    }


}
