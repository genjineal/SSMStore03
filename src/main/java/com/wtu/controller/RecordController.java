package com.wtu.controller;

import com.github.pagehelper.PageInfo;
import com.wtu.entity.Record;
import com.wtu.service.ProductService;
import com.wtu.service.RecordService;
import com.wtu.service.UserService;
import com.wtu.util.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/4 20:59
 */
@Controller
public class RecordController {
    @Autowired
    private UserService userService;
    @Autowired
    private RecordService recordService;
    @Autowired //调用这处 是为了减去相应的库存
    private ProductService productService;
    //用户添加新订单
    @RequestMapping("/insertRecord")
    public String insertRecord(String uid,String pid,String amount,String pname,
                               String uname,String uphone,String address){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("uid",uid);
        map.put("pid",pid);
        map.put("amount",amount);
        map.put("pname",pname);
        map.put("uname",uname);
        map.put("uphone",uphone);
        map.put("address",address);
        recordService.insertRecord(map);
        //这里对应着商品表中 减去相应的库存
        productService.changeProAmount(map);
        return "redirect:/pro/list";
    }
    //用户返回商城
    @RequestMapping("/backstore")
    public String backStore(){
        return "redirect:/pro/list";
    }

    //管理员查询所有订单 带分页和条件查询
    @RequestMapping("/selectAllRecord")
    public String selectAllRecords(Params params, Model model){
        //管理员查询所有订单 带分页和条件查询
        List<Record> recordList = recordService.selectAllRecords(params);
        //将获取的数据，交给分页实现类处理
        PageInfo<Record> pageInfo = new PageInfo<Record>(recordList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("params",params);
        return "adminConRecord";
    }

    //管理员发货
    @RequestMapping("/sendRecord")
    public String sendRecord(Integer rid){
        int i = recordService.sendRecords(rid);
        System.out.println(i>0?"发货成功":"发货失败");
        return "redirect:/selectAllRecord";
    }
    @RequestMapping("/selectUserRecord")
    //用户查询个人订单 带分页和条件查询
    public String selectUserRecord(Params params, Model model){
        //用户查询个人订单 带分页和条件查询
        List<Record> records = recordService.selectUserRecord(params);
        //将获取的数据，交给分页实现类处理
        PageInfo<Record> pageInfo = new PageInfo<Record>(records);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("params",params);
        return "userRecord";
    }

    //用户确认收货(删除订单)
    @RequestMapping("/userDeleteRecord")
    public String userDeleteRecord(Params params,Integer rid,Model model){
        int i = recordService.userDeleteRecord(rid);
        System.out.println(i>0?"收货成功":"收货失败");
        return "redirect:/selectUserRecord?uid="+params.getUid();
    }


}
