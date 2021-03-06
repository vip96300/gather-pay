package org.xxpay.dal.dao.model;

import java.io.Serializable;

public class MchAccount implements Serializable {
    private String accountId;

    private String mchId;

    private Long usableBalance;

    private Long lockedBalance;

    private static final long serialVersionUID = 1L;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public Long getUsableBalance() {
        return usableBalance;
    }

    public void setUsableBalance(Long usableBalance) {
        this.usableBalance = usableBalance;
    }

    public Long getLockedBalance() {
        return lockedBalance;
    }

    public void setLockedBalance(Long lockedBalance) {
        this.lockedBalance = lockedBalance;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MchAccount other = (MchAccount) that;
        return (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getMchId() == null ? other.getMchId() == null : this.getMchId().equals(other.getMchId()))
            && (this.getUsableBalance() == null ? other.getUsableBalance() == null : this.getUsableBalance().equals(other.getUsableBalance()))
            && (this.getLockedBalance() == null ? other.getLockedBalance() == null : this.getLockedBalance().equals(other.getLockedBalance()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getMchId() == null) ? 0 : getMchId().hashCode());
        result = prime * result + ((getUsableBalance() == null) ? 0 : getUsableBalance().hashCode());
        result = prime * result + ((getLockedBalance() == null) ? 0 : getLockedBalance().hashCode());
        return result;
    }
}