package com.data.dormitory.mbg.mapper;

import com.data.dormitory.mbg.model.Punish;
import com.data.dormitory.mbg.model.PunishExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository("punishMapper")
public interface PunishMapper {
    int countByExample(PunishExample example);

    int deleteByExample(PunishExample example);

    int deleteByPrimaryKey(Date date);

    int insert(Punish record);

    int insertSelective(Punish record);

    List<Punish> selectByExample(PunishExample example);

    Punish selectByPrimaryKey(Date date);

    int updateByExampleSelective(@Param("record") Punish record, @Param("example") PunishExample example);

    int updateByExample(@Param("record") Punish record, @Param("example") PunishExample example);

    int updateByPrimaryKeySelective(Punish record);

    int updateByPrimaryKey(Punish record);
}
