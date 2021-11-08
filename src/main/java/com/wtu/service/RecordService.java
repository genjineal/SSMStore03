package com.wtu.service;

import com.wtu.entity.Record;
import com.wtu.util.Params;

import java.util.List;
import java.util.Map;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/4 13:40
 */
public interface RecordService {
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

}
