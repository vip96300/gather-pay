package org.xxpay.dal.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.xxpay.dal.dao.model.SysPermission;
import org.xxpay.dal.dao.model.SysPermissionExample;

public interface SysPermissionMapper {

	long countByExample(SysPermissionExample example);

	int deleteByExample(SysPermissionExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SysPermission record);

	int insertSelective(SysPermission record);

	List<SysPermission> selectByExample(SysPermissionExample example);

	SysPermission selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") SysPermission record,@Param("example") SysPermissionExample example);

	int updateByExample(@Param("record") SysPermission record,@Param("example") SysPermissionExample example);

	int updateByPrimaryKeySelective(SysPermission record);

	int updateByPrimaryKey(SysPermission record);
	
	@Select(value="select * from sys_permission o where o.id in (select permission_id from sys_role_permission where role_id =#{roleId,jdbcType=INTEGER})")
	List<SysPermission> selectByRoleId(@Param("roleId")int roleId);

}
