package com.wtu.service;

import com.github.pagehelper.PageHelper;
import com.wtu.entity.Record;
import com.wtu.mapper.RecordMapper;
import com.wtu.util.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/4 13:40
 */
@Service
public class RecordServiceImpl implements RecordService{
    @Autowired
    private RecordMapper recordMapper;

    //用户 添加订单

    public int insertRecord(Map<String, Object> map) {
        return recordMapper.insertRecord(map);
    }

    //管理员 查询所有订单

    public List<Record> selectAllRecords(Params params) {
        //默认初始第一页  动态给，用户第一次进入才给1
        if(params.getPageNum() ==0){
            params.setPageNum(1);
        }
        //需要当前页、每页条数
        PageHelper.startPage(params.getPageNum(),params.getPageSize());
        return recordMapper.selectAllRecords(params);
    }

    //管理员发货

    public int sendRecords(Integer rid) {
        return recordMapper.sendRecords(rid);
    }
    //用户查看自己订单

    public List<Record> selectUserRecord(Params params) {
        //默认初始第一页  动态给，用户第一次进入才给1
        if(params.getPageNum() ==0){
            params.setPageNum(1);
        }
        //需要当前页、每页条数
        PageHelper.startPage(params.getPageNum(),params.getPageSize());
        return recordMapper.selectUserRecord(params);
    }

    //用户确认收货(删除订单)

    public int userDeleteRecord(Integer rid) {
        return recordMapper.userDeleteRecord(rid);
    }
}
