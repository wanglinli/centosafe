package com.wy.centosafe.domain.repository;

import com.wy.centosafe.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author wy
 * date 17-12-22
 * time 下午3:44
 */
public interface MemberRepository extends JpaRepository<Member,Integer> {
    Member findByName(String name);
    Member findByNameAndPassword(String name,String password);
}
