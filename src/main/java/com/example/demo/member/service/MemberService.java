package com.example.demo.member.service;

import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.request.MemberRequest;
import com.example.demo.member.domain.response.MemberResponse;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final EntityManager em;

    public void delete(Long id){
        Member member = em.find(Member.class, id);
        em.remove(member);
    }

    public MemberResponse findById(Long id){
        Member member = em.find(Member.class, id);
        return new MemberResponse(member);
    }

    public List<MemberResponse> findByName(String name) {
        return em.createQuery("select m from Member m " +
                        "join fetch m.memberHobbies h " +
                        " join fetch h.hobby " +
                        "where m.name like :name", Member.class)
                .setParameter("name", "%" + name + "%")
                .getResultList()
                .stream()
                .map(MemberResponse::new)
                .toList();


    }

    public List<MemberResponse> findAll() {
        return em.createQuery("select m from Member as m "
                                + " join fetch m.memberHobbies as mh join fetch mh.hobby",
                        Member.class)
                .getResultList()
                .stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }

    public void insert(MemberRequest request){
        em.persist(request.toEntity());
    }



}
