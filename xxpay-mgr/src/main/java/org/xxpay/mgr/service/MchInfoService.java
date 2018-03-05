package org.xxpay.mgr.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xxpay.dal.dao.mapper.*;
import org.xxpay.dal.dao.model.*;
import org.xxpay.mgr.constant.MchInfoConstants;
import org.xxpay.mgr.utils.UuidUtil;

import java.util.List;

/**
 * Created by dingzhiwei on 17/5/4.
 */
@Service
public class MchInfoService {

    @Autowired
    private MchInfoMapper mchInfoMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private MchAccountMapper mchAccountMapper;

    public MchInfo getByUsername(String username){
    	MchInfo mchInfo=mchInfoMapper.selectByUsername(username);
    	List<SysRole> roles=sysRoleMapper.selectByMchid(mchInfo.getMchId());
    	for(SysRole role:roles){
    		List<SysPermission> permissions=sysPermissionMapper.selectByRoleId(role.getId());
    		role.setPermissionList(permissions);
    	}
    	mchInfo.setRoleList(roles);
    	return mchInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    public int saveOrUpdate(MchInfo mchInfo) {
        int result;
        if(org.springframework.util.StringUtils.isEmpty(mchInfo.getMchId())) {
            mchInfo.setMchId(UuidUtil.idGennerator());
            result=mchInfoMapper.insert(mchInfo);
            mchAccountMapper.insert(MchAccountSimple.instance(UuidUtil.idGennerator(),mchInfo.getMchId()));
            sysUserRoleMapper.insert(mchInfo.getMchId(),mchInfo.getType().equals("1")?1:2);
        }else{
            result=mchInfoMapper.updateByPrimaryKeySelective(mchInfo);
        }
        return result;
    }

    public MchInfo selectMchInfo(String mchId) {
        return mchInfoMapper.selectByPrimaryKey(mchId);
    }

    public List<MchInfo> list(int offset, int limit, MchInfo mchInfo) {
        MchInfoExample example = new MchInfoExample();
        example.createCriteria().andTypeEqualTo(MchInfoConstants.Type.USER.getValue());
        example.setOrderByClause("createTime DESC");
        example.setOffset(offset);
        example.setLimit(limit);
        MchInfoExample.Criteria criteria = example.createCriteria();
        setCriteria(criteria, mchInfo);
        return mchInfoMapper.selectByExample(example);
    }

    public long count(MchInfo mchInfo) {
        MchInfoExample example = new MchInfoExample();
        MchInfoExample.Criteria criteria = example.createCriteria();
        setCriteria(criteria, mchInfo);
        return mchInfoMapper.countByExample(example);
    }

    void setCriteria(MchInfoExample.Criteria criteria, MchInfo mchInfo) {
        if(mchInfo != null) {
            if(StringUtils.isNotBlank(mchInfo.getMchId())) criteria.andMchIdEqualTo(mchInfo.getMchId());
            if(mchInfo.getType() != null && !"-99".equals(mchInfo.getType())) criteria.andTypeEqualTo(mchInfo.getType());
        }
    }
}
