package org.xxpay.dal.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayPlatformExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public PayPlatformExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andMerchIdIsNull() {
            addCriterion("merch_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchIdIsNotNull() {
            addCriterion("merch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchIdEqualTo(String value) {
            addCriterion("merch_id =", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotEqualTo(String value) {
            addCriterion("merch_id <>", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdGreaterThan(String value) {
            addCriterion("merch_id >", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdGreaterThanOrEqualTo(String value) {
            addCriterion("merch_id >=", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLessThan(String value) {
            addCriterion("merch_id <", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLessThanOrEqualTo(String value) {
            addCriterion("merch_id <=", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLike(String value) {
            addCriterion("merch_id like", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotLike(String value) {
            addCriterion("merch_id not like", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdIn(List<String> values) {
            addCriterion("merch_id in", values, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotIn(List<String> values) {
            addCriterion("merch_id not in", values, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdBetween(String value1, String value2) {
            addCriterion("merch_id between", value1, value2, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotBetween(String value1, String value2) {
            addCriterion("merch_id not between", value1, value2, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchKeyIsNull() {
            addCriterion("merch_key is null");
            return (Criteria) this;
        }

        public Criteria andMerchKeyIsNotNull() {
            addCriterion("merch_key is not null");
            return (Criteria) this;
        }

        public Criteria andMerchKeyEqualTo(String value) {
            addCriterion("merch_key =", value, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyNotEqualTo(String value) {
            addCriterion("merch_key <>", value, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyGreaterThan(String value) {
            addCriterion("merch_key >", value, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyGreaterThanOrEqualTo(String value) {
            addCriterion("merch_key >=", value, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyLessThan(String value) {
            addCriterion("merch_key <", value, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyLessThanOrEqualTo(String value) {
            addCriterion("merch_key <=", value, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyLike(String value) {
            addCriterion("merch_key like", value, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyNotLike(String value) {
            addCriterion("merch_key not like", value, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyIn(List<String> values) {
            addCriterion("merch_key in", values, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyNotIn(List<String> values) {
            addCriterion("merch_key not in", values, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyBetween(String value1, String value2) {
            addCriterion("merch_key between", value1, value2, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchKeyNotBetween(String value1, String value2) {
            addCriterion("merch_key not between", value1, value2, "merchKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyIsNull() {
            addCriterion("merch_public_key is null");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyIsNotNull() {
            addCriterion("merch_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyEqualTo(String value) {
            addCriterion("merch_public_key =", value, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyNotEqualTo(String value) {
            addCriterion("merch_public_key <>", value, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyGreaterThan(String value) {
            addCriterion("merch_public_key >", value, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("merch_public_key >=", value, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyLessThan(String value) {
            addCriterion("merch_public_key <", value, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("merch_public_key <=", value, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyLike(String value) {
            addCriterion("merch_public_key like", value, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyNotLike(String value) {
            addCriterion("merch_public_key not like", value, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyIn(List<String> values) {
            addCriterion("merch_public_key in", values, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyNotIn(List<String> values) {
            addCriterion("merch_public_key not in", values, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyBetween(String value1, String value2) {
            addCriterion("merch_public_key between", value1, value2, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andMerchPublicKeyNotBetween(String value1, String value2) {
            addCriterion("merch_public_key not between", value1, value2, "merchPublicKey");
            return (Criteria) this;
        }

        public Criteria andExpandParamsIsNull() {
            addCriterion("expand_params is null");
            return (Criteria) this;
        }

        public Criteria andExpandParamsIsNotNull() {
            addCriterion("expand_params is not null");
            return (Criteria) this;
        }

        public Criteria andExpandParamsEqualTo(String value) {
            addCriterion("expand_params =", value, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsNotEqualTo(String value) {
            addCriterion("expand_params <>", value, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsGreaterThan(String value) {
            addCriterion("expand_params >", value, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsGreaterThanOrEqualTo(String value) {
            addCriterion("expand_params >=", value, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsLessThan(String value) {
            addCriterion("expand_params <", value, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsLessThanOrEqualTo(String value) {
            addCriterion("expand_params <=", value, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsLike(String value) {
            addCriterion("expand_params like", value, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsNotLike(String value) {
            addCriterion("expand_params not like", value, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsIn(List<String> values) {
            addCriterion("expand_params in", values, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsNotIn(List<String> values) {
            addCriterion("expand_params not in", values, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsBetween(String value1, String value2) {
            addCriterion("expand_params between", value1, value2, "expandParams");
            return (Criteria) this;
        }

        public Criteria andExpandParamsNotBetween(String value1, String value2) {
            addCriterion("expand_params not between", value1, value2, "expandParams");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andMerchRateIsNull() {
            addCriterion("merch_rate is null");
            return (Criteria) this;
        }

        public Criteria andMerchRateIsNotNull() {
            addCriterion("merch_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMerchRateEqualTo(Double value) {
            addCriterion("merch_rate =", value, "merchRate");
            return (Criteria) this;
        }

        public Criteria andMerchRateNotEqualTo(Double value) {
            addCriterion("merch_rate <>", value, "merchRate");
            return (Criteria) this;
        }

        public Criteria andMerchRateGreaterThan(Double value) {
            addCriterion("merch_rate >", value, "merchRate");
            return (Criteria) this;
        }

        public Criteria andMerchRateGreaterThanOrEqualTo(Double value) {
            addCriterion("merch_rate >=", value, "merchRate");
            return (Criteria) this;
        }

        public Criteria andMerchRateLessThan(Double value) {
            addCriterion("merch_rate <", value, "merchRate");
            return (Criteria) this;
        }

        public Criteria andMerchRateLessThanOrEqualTo(Double value) {
            addCriterion("merch_rate <=", value, "merchRate");
            return (Criteria) this;
        }

        public Criteria andMerchRateIn(List<Double> values) {
            addCriterion("merch_rate in", values, "merchRate");
            return (Criteria) this;
        }

        public Criteria andMerchRateNotIn(List<Double> values) {
            addCriterion("merch_rate not in", values, "merchRate");
            return (Criteria) this;
        }

        public Criteria andMerchRateBetween(Double value1, Double value2) {
            addCriterion("merch_rate between", value1, value2, "merchRate");
            return (Criteria) this;
        }

        public Criteria andMerchRateNotBetween(Double value1, Double value2) {
            addCriterion("merch_rate not between", value1, value2, "merchRate");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(Long value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(Long value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(Long value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(Long value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(Long value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<Long> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<Long> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(Long value1, Long value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(Long value1, Long value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaIsNull() {
            addCriterion("single_quota is null");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaIsNotNull() {
            addCriterion("single_quota is not null");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaEqualTo(Long value) {
            addCriterion("single_quota =", value, "singleQuota");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaNotEqualTo(Long value) {
            addCriterion("single_quota <>", value, "singleQuota");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaGreaterThan(Long value) {
            addCriterion("single_quota >", value, "singleQuota");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaGreaterThanOrEqualTo(Long value) {
            addCriterion("single_quota >=", value, "singleQuota");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaLessThan(Long value) {
            addCriterion("single_quota <", value, "singleQuota");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaLessThanOrEqualTo(Long value) {
            addCriterion("single_quota <=", value, "singleQuota");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaIn(List<Long> values) {
            addCriterion("single_quota in", values, "singleQuota");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaNotIn(List<Long> values) {
            addCriterion("single_quota not in", values, "singleQuota");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaBetween(Long value1, Long value2) {
            addCriterion("single_quota between", value1, value2, "singleQuota");
            return (Criteria) this;
        }

        public Criteria andSingleQuotaNotBetween(Long value1, Long value2) {
            addCriterion("single_quota not between", value1, value2, "singleQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaIsNull() {
            addCriterion("total_quota is null");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaIsNotNull() {
            addCriterion("total_quota is not null");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaEqualTo(Long value) {
            addCriterion("total_quota =", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaNotEqualTo(Long value) {
            addCriterion("total_quota <>", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaGreaterThan(Long value) {
            addCriterion("total_quota >", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaGreaterThanOrEqualTo(Long value) {
            addCriterion("total_quota >=", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaLessThan(Long value) {
            addCriterion("total_quota <", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaLessThanOrEqualTo(Long value) {
            addCriterion("total_quota <=", value, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaIn(List<Long> values) {
            addCriterion("total_quota in", values, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaNotIn(List<Long> values) {
            addCriterion("total_quota not in", values, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaBetween(Long value1, Long value2) {
            addCriterion("total_quota between", value1, value2, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andTotalQuotaNotBetween(Long value1, Long value2) {
            addCriterion("total_quota not between", value1, value2, "totalQuota");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNull() {
            addCriterion("return_url is null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNotNull() {
            addCriterion("return_url is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlEqualTo(String value) {
            addCriterion("return_url =", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotEqualTo(String value) {
            addCriterion("return_url <>", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThan(String value) {
            addCriterion("return_url >", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("return_url >=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThan(String value) {
            addCriterion("return_url <", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThanOrEqualTo(String value) {
            addCriterion("return_url <=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLike(String value) {
            addCriterion("return_url like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotLike(String value) {
            addCriterion("return_url not like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIn(List<String> values) {
            addCriterion("return_url in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotIn(List<String> values) {
            addCriterion("return_url not in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlBetween(String value1, String value2) {
            addCriterion("return_url between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotBetween(String value1, String value2) {
            addCriterion("return_url not between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlIsNull() {
            addCriterion("cancel_url is null");
            return (Criteria) this;
        }

        public Criteria andCancelUrlIsNotNull() {
            addCriterion("cancel_url is not null");
            return (Criteria) this;
        }

        public Criteria andCancelUrlEqualTo(String value) {
            addCriterion("cancel_url =", value, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlNotEqualTo(String value) {
            addCriterion("cancel_url <>", value, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlGreaterThan(String value) {
            addCriterion("cancel_url >", value, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_url >=", value, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlLessThan(String value) {
            addCriterion("cancel_url <", value, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlLessThanOrEqualTo(String value) {
            addCriterion("cancel_url <=", value, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlLike(String value) {
            addCriterion("cancel_url like", value, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlNotLike(String value) {
            addCriterion("cancel_url not like", value, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlIn(List<String> values) {
            addCriterion("cancel_url in", values, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlNotIn(List<String> values) {
            addCriterion("cancel_url not in", values, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlBetween(String value1, String value2) {
            addCriterion("cancel_url between", value1, value2, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andCancelUrlNotBetween(String value1, String value2) {
            addCriterion("cancel_url not between", value1, value2, "cancelUrl");
            return (Criteria) this;
        }

        public Criteria andDepictIsNull() {
            addCriterion("depict is null");
            return (Criteria) this;
        }

        public Criteria andDepictIsNotNull() {
            addCriterion("depict is not null");
            return (Criteria) this;
        }

        public Criteria andDepictEqualTo(String value) {
            addCriterion("depict =", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictNotEqualTo(String value) {
            addCriterion("depict <>", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictGreaterThan(String value) {
            addCriterion("depict >", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictGreaterThanOrEqualTo(String value) {
            addCriterion("depict >=", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictLessThan(String value) {
            addCriterion("depict <", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictLessThanOrEqualTo(String value) {
            addCriterion("depict <=", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictLike(String value) {
            addCriterion("depict like", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictNotLike(String value) {
            addCriterion("depict not like", value, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictIn(List<String> values) {
            addCriterion("depict in", values, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictNotIn(List<String> values) {
            addCriterion("depict not in", values, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictBetween(String value1, String value2) {
            addCriterion("depict between", value1, value2, "depict");
            return (Criteria) this;
        }

        public Criteria andDepictNotBetween(String value1, String value2) {
            addCriterion("depict not between", value1, value2, "depict");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}