package com.data.dormitory.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LeaveExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Byte value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Byte value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Byte value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Byte value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Byte value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Byte value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Byte> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Byte> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Byte value1, Byte value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Byte value1, Byte value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Byte value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Byte value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Byte value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Byte value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Byte value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Byte value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Byte> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Byte> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Byte value1, Byte value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Byte value1, Byte value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andBbidIsNull() {
            addCriterion("bbid is null");
            return (Criteria) this;
        }

        public Criteria andBbidIsNotNull() {
            addCriterion("bbid is not null");
            return (Criteria) this;
        }

        public Criteria andBbidEqualTo(Boolean value) {
            addCriterion("bbid =", value, "bbid");
            return (Criteria) this;
        }

        public Criteria andBbidNotEqualTo(Boolean value) {
            addCriterion("bbid <>", value, "bbid");
            return (Criteria) this;
        }

        public Criteria andBbidGreaterThan(Boolean value) {
            addCriterion("bbid >", value, "bbid");
            return (Criteria) this;
        }

        public Criteria andBbidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bbid >=", value, "bbid");
            return (Criteria) this;
        }

        public Criteria andBbidLessThan(Boolean value) {
            addCriterion("bbid <", value, "bbid");
            return (Criteria) this;
        }

        public Criteria andBbidLessThanOrEqualTo(Boolean value) {
            addCriterion("bbid <=", value, "bbid");
            return (Criteria) this;
        }

        public Criteria andBbidIn(List<Boolean> values) {
            addCriterion("bbid in", values, "bbid");
            return (Criteria) this;
        }

        public Criteria andBbidNotIn(List<Boolean> values) {
            addCriterion("bbid not in", values, "bbid");
            return (Criteria) this;
        }

        public Criteria andBbidBetween(Boolean value1, Boolean value2) {
            addCriterion("bbid between", value1, value2, "bbid");
            return (Criteria) this;
        }

        public Criteria andBbidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bbid not between", value1, value2, "bbid");
            return (Criteria) this;
        }

        public Criteria andKindIsNull() {
            addCriterion("kind is null");
            return (Criteria) this;
        }

        public Criteria andKindIsNotNull() {
            addCriterion("kind is not null");
            return (Criteria) this;
        }

        public Criteria andKindEqualTo(Boolean value) {
            addCriterion("kind =", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotEqualTo(Boolean value) {
            addCriterion("kind <>", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThan(Boolean value) {
            addCriterion("kind >", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThanOrEqualTo(Boolean value) {
            addCriterion("kind >=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThan(Boolean value) {
            addCriterion("kind <", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThanOrEqualTo(Boolean value) {
            addCriterion("kind <=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindIn(List<Boolean> values) {
            addCriterion("kind in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotIn(List<Boolean> values) {
            addCriterion("kind not in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindBetween(Boolean value1, Boolean value2) {
            addCriterion("kind between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotBetween(Boolean value1, Boolean value2) {
            addCriterion("kind not between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNull() {
            addCriterion("begindate is null");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNotNull() {
            addCriterion("begindate is not null");
            return (Criteria) this;
        }

        public Criteria andBegindateEqualTo(Date value) {
            addCriterion("begindate =", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotEqualTo(Date value) {
            addCriterion("begindate <>", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThan(Date value) {
            addCriterion("begindate >", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThanOrEqualTo(Date value) {
            addCriterion("begindate >=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThan(Date value) {
            addCriterion("begindate <", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThanOrEqualTo(Date value) {
            addCriterion("begindate <=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateIn(List<Date> values) {
            addCriterion("begindate in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotIn(List<Date> values) {
            addCriterion("begindate not in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateBetween(Date value1, Date value2) {
            addCriterion("begindate between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotBetween(Date value1, Date value2) {
            addCriterion("begindate not between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andOverdateIsNull() {
            addCriterion("overdate is null");
            return (Criteria) this;
        }

        public Criteria andOverdateIsNotNull() {
            addCriterion("overdate is not null");
            return (Criteria) this;
        }

        public Criteria andOverdateEqualTo(Date value) {
            addCriterion("overdate =", value, "overdate");
            return (Criteria) this;
        }

        public Criteria andOverdateNotEqualTo(Date value) {
            addCriterion("overdate <>", value, "overdate");
            return (Criteria) this;
        }

        public Criteria andOverdateGreaterThan(Date value) {
            addCriterion("overdate >", value, "overdate");
            return (Criteria) this;
        }

        public Criteria andOverdateGreaterThanOrEqualTo(Date value) {
            addCriterion("overdate >=", value, "overdate");
            return (Criteria) this;
        }

        public Criteria andOverdateLessThan(Date value) {
            addCriterion("overdate <", value, "overdate");
            return (Criteria) this;
        }

        public Criteria andOverdateLessThanOrEqualTo(Date value) {
            addCriterion("overdate <=", value, "overdate");
            return (Criteria) this;
        }

        public Criteria andOverdateIn(List<Date> values) {
            addCriterion("overdate in", values, "overdate");
            return (Criteria) this;
        }

        public Criteria andOverdateNotIn(List<Date> values) {
            addCriterion("overdate not in", values, "overdate");
            return (Criteria) this;
        }

        public Criteria andOverdateBetween(Date value1, Date value2) {
            addCriterion("overdate between", value1, value2, "overdate");
            return (Criteria) this;
        }

        public Criteria andOverdateNotBetween(Date value1, Date value2) {
            addCriterion("overdate not between", value1, value2, "overdate");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andReviewstateIsNull() {
            addCriterion("reviewstate is null");
            return (Criteria) this;
        }

        public Criteria andReviewstateIsNotNull() {
            addCriterion("reviewstate is not null");
            return (Criteria) this;
        }

        public Criteria andReviewstateEqualTo(Boolean value) {
            addCriterion("reviewstate =", value, "reviewstate");
            return (Criteria) this;
        }

        public Criteria andReviewstateNotEqualTo(Boolean value) {
            addCriterion("reviewstate <>", value, "reviewstate");
            return (Criteria) this;
        }

        public Criteria andReviewstateGreaterThan(Boolean value) {
            addCriterion("reviewstate >", value, "reviewstate");
            return (Criteria) this;
        }

        public Criteria andReviewstateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("reviewstate >=", value, "reviewstate");
            return (Criteria) this;
        }

        public Criteria andReviewstateLessThan(Boolean value) {
            addCriterion("reviewstate <", value, "reviewstate");
            return (Criteria) this;
        }

        public Criteria andReviewstateLessThanOrEqualTo(Boolean value) {
            addCriterion("reviewstate <=", value, "reviewstate");
            return (Criteria) this;
        }

        public Criteria andReviewstateIn(List<Boolean> values) {
            addCriterion("reviewstate in", values, "reviewstate");
            return (Criteria) this;
        }

        public Criteria andReviewstateNotIn(List<Boolean> values) {
            addCriterion("reviewstate not in", values, "reviewstate");
            return (Criteria) this;
        }

        public Criteria andReviewstateBetween(Boolean value1, Boolean value2) {
            addCriterion("reviewstate between", value1, value2, "reviewstate");
            return (Criteria) this;
        }

        public Criteria andReviewstateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("reviewstate not between", value1, value2, "reviewstate");
            return (Criteria) this;
        }

        public Criteria andDescriptIsNull() {
            addCriterion("descript is null");
            return (Criteria) this;
        }

        public Criteria andDescriptIsNotNull() {
            addCriterion("descript is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptEqualTo(String value) {
            addCriterion("descript =", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotEqualTo(String value) {
            addCriterion("descript <>", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptGreaterThan(String value) {
            addCriterion("descript >", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptGreaterThanOrEqualTo(String value) {
            addCriterion("descript >=", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLessThan(String value) {
            addCriterion("descript <", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLessThanOrEqualTo(String value) {
            addCriterion("descript <=", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLike(String value) {
            addCriterion("descript like", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotLike(String value) {
            addCriterion("descript not like", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptIn(List<String> values) {
            addCriterion("descript in", values, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotIn(List<String> values) {
            addCriterion("descript not in", values, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptBetween(String value1, String value2) {
            addCriterion("descript between", value1, value2, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotBetween(String value1, String value2) {
            addCriterion("descript not between", value1, value2, "descript");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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
