package com.lgp.SpringBoot.mapper;

import com.lgp.SpringBoot.bean.AppUser;
public interface AppUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppUser record);

    int insertSelective(AppUser record);

    AppUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppUser record);

    int updateByPrimaryKey(AppUser record);
}