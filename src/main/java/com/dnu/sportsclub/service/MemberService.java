package com.dnu.sportsclub.service;

import com.dnu.sportsclub.exception.MemberNotFoundException;
import com.dnu.sportsclub.model.Member;
import java.util.List;
import java.util.stream.Collectors;

public class MemberService {
    private final List<Member> members;

    public MemberService(List<Member> members) {
        this.members = members;
    }

    // Test case 1: Thêm thành viên mới thành công
    public void add(Member member) {
        if (member != null) {
            members.add(member);
            System.out.println("Thêm thành viên thành công: " + member.getName());  // Optional log
        }
    }


    public void delete(String id) {
        boolean removed = members.removeIf(m -> m.getId().equals(id));
        if (!removed) {
            throw new MemberNotFoundException("Không tìm thấy thành viên ID: " + id);
        }
    }


    public List<Member> searchByName(String name) {
        return members.stream()
                .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }


    public List<Member> getAll() {
        return members;
    }
}