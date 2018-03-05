package org.xxpay.dal.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 14:33 2018/3/1
 */
public interface SysUserRoleMapper {

    @Insert("insert into sys_user_role(user_id,role_id) values(#{userId},#{roleId})")
    int insert(@Param("userId") String userId,@Param("roleId") int roleId);
}
