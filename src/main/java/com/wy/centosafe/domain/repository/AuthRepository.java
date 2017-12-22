package com.wy.centosafe.domain.repository;

import com.wy.centosafe.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author wy
 * date 17-12-22
 * time 下午3:45
 */
public interface AuthRepository extends JpaRepository<Auth,Integer> {
}
