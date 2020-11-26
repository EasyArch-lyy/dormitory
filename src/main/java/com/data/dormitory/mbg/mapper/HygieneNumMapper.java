package com.data.dormitory.mbg.mapper;

import com.data.dormitory.mbg.model.HygieneNum;
import com.data.dormitory.mbg.model.HygieneNumExample;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;

public interface HygieneNumMapper {
    int countByExample(HygieneNumExample example);

    int deleteByExample(HygieneNumExample example);

    int deleteByPrimaryKey(Date date);

    int insert(HygieneNum record);

    int insertSelective(HygieneNum record);

    List<HygieneNum> selectByExample(HygieneNumExample example);

    HygieneNum selectByPrimaryKey(Date date);

    int updateByExampleSelective(@Param("record") HygieneNum record, @Param("example") HygieneNumExample example);

    int updateByExample(@Param("record") HygieneNum record, @Param("example") HygieneNumExample example);

    int updateByPrimaryKeySelective(HygieneNum record);

    int updateByPrimaryKey(HygieneNum record);
}
