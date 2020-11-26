package com.data.dormitory.mbg.mapper;

import com.data.dormitory.mbg.model.Stu;
import com.data.dormitory.mbg.model.StuExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("stuMapper")
public interface StuMapper {
    int countByExample(StuExample example);

    int deleteByExample(StuExample example);

    int deleteByPrimaryKey(String sid);

    int insert(Stu record);

    int insertSelective(Stu record);

    List<Stu> selectByExample(StuExample example);

    Stu selectByPrimaryKey(String sid);

    /**根据床号楼号获取学生信息*/
    Stu getStuByNum(@Param("bid") Integer bid, @Param("did") Integer did, @Param("bbid") Integer bbid);

    int updateByExampleSelective(@Param("record") Stu record, @Param("example") StuExample example);

    int updateByExample(@Param("record") Stu record, @Param("example") StuExample example);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);
}
