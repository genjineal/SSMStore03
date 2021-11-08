package com.wtu.mapper;

import com.wtu.entity.Record;
import com.wtu.entity.RecordExample;
import com.wtu.util.Params;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

import java.util.List;

public interface RecordMapper {
    //添加订单
    int insertRecord(Map<String,Object> map);

    //查询所有订单
    List<Record> selectAllRecords(Params params);
    //管理员发货
    int sendRecords(Integer rid);

    //用户查看自己订单
    List<Record> selectUserRecord(Params params);

    //用户确认收货(删除订单)
    int userDeleteRecord(Integer rid);

    long countByExample(RecordExample example);

    int deleteByExample(RecordExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(RecordExample example);

    Record selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByExample(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}