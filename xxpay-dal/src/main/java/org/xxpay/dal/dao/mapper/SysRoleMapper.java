package org.xxpay.dal.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.xxpay.dal.dao.model.SysRole;
import org.xxpay.dal.dao.model.SysRoleExample;

public interface SysRoleMapper {

	long countByExample(SysRoleExample example);

	int deleteByExample(SysRoleExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SysRole record);

	int insertSelective(SysRole record);

	List<SysRole> selectByExample(SysRoleExample example);

	SysRole selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") SysRole record,@Param("example") SysRoleExample example);

	int updateByExample(@Param("record") SysRole record,@Param("example") SysRoleExample example);

	int updateByPrimaryKeySelective(SysRole record);

	int updateByPrimaryKey(SysRole record);
	
	@Select(value="select * from sys_role o where o.id in(select role_id from sys_user_role where user_id=#{mchId,jdbcType=VARCHAR})")
	List<SysRole> selectByMchid(@Param("mchId")String mchId);
	
}
