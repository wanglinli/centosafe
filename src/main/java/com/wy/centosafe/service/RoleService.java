package com.wy.centosafe.service;

import com.wy.centosafe.domain.Result;
import com.wy.centosafe.domain.repository.RoleRepository;
import com.wy.centosafe.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * author wy
 * date 17-12-22
 * time 下午6:11
 */

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


    /**
     * 角色列表
     * @return
     */
    public Result RoleInfo(){
        return ResultUtil.success(roleRepository.findAll(new Sort(Sort.Direction.ASC,"id")));
    }
}
