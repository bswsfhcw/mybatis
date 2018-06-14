package com.tools.dao;

import com.tools.entity.SdtzRoleResources;

public interface SdtzRoleResourcesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SdtzRoleResources record); 

    int insertSelective(SdtzRoleResources record);

    SdtzRoleResources selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SdtzRoleResources record);

    int updateByPrimaryKey(SdtzRoleResources record);
}