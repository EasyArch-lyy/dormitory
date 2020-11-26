package com.data.dormitory.mbg.mapper;

import com.data.dormitory.mbg.model.TestLogin;
import com.data.dormitory.mbg.model.TestLoginExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("testLoginMapper")
public interface TestLoginMapper {
    int countByExample(TestLoginExample example);

    int deleteByExample(TestLoginExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(TestLogin record);

    int insertSelective(TestLogin record);

    List<TestLogin> selectByExample(TestLoginExample example);

    TestLogin selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") TestLogin record, @Param("example") TestLoginExample example);

    int updateByExample(@Param("record") TestLogin record, @Param("example") TestLoginExample example);

    int updateByPrimaryKeySelective(TestLogin record);

    int updateByPrimaryKey(TestLogin record);
}
