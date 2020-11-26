package com.data.dormitory.mbg.mapper;

import com.data.dormitory.mbg.model.BedSid;
import com.data.dormitory.mbg.model.BedSidExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BedSidMapper {
    int countByExample(BedSidExample example);

    int deleteByExample(BedSidExample example);

    int deleteByPrimaryKey(String sid);

    int insert(BedSid record);

    int insertSelective(BedSid record);

    List<BedSid> selectByExample(BedSidExample example);

    BedSid selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") BedSid record, @Param("example") BedSidExample example);

    int updateByExample(@Param("record") BedSid record, @Param("example") BedSidExample example);

    int updateByPrimaryKeySelective(BedSid record);

    int updateByPrimaryKey(BedSid record);
}
