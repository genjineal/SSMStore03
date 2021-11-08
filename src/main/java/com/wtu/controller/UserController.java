package com.wtu.controller;

import com.github.pagehelper.PageInfo;
import com.wtu.entity.User;
import com.wtu.service.UserService;
import com.wtu.util.Params;
import com.wtu.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/1 19:25
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //生成验证码
    @RequestMapping("/vccode")
    public void loginvcCode(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image  =vc.createImage();
        String codeing = vc.getText();
        session = req.getSession();
        session.setAttribute("code",codeing);
        ServletOutputStream stream = resp.getOutputStream();
        vc.output(image,stream);
    }
    //验证验证码对错 以及管理员身份
    @RequestMapping("/coderight")
    public String loginCodeRight(String inputcode,String uname,String password,
                                 HttpSession session,HttpServletRequest req){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("uname",uname);
        map.put("password",password);
        String code = (String)session.getAttribute("code");
        //调用方法 判断用户名和密码
        User user = userService.doLogin(map);
        System.out.println("user = " + user);
        //判断 用户不为空，登陆状态为3 就是管理员登录
        //用户登录
        if(user!=null){
            //如果状态为0，则是账号被封禁，管理员可以在用户管理页面执行修改或删除
            if(user.getStatus()==0){
                req.setAttribute("error","该账号已封禁");
                return "userLogin";
            }
            //判断 用户不为空，登陆状态为3 就是管理员登录
            if (user.getStatus()==3 && code.equalsIgnoreCase(inputcode)){
                session.setAttribute("user",user);
                return "userList";
            }
            //正常用户登录
            if(code.equalsIgnoreCase(inputcode)){
                session.setAttribute("user",user);
                return "redirect:/pro/list";//转发给商品的控制层，跳转到商品页
            }else {
                req.setAttribute("error","验证码错误");
                return "userLogin";
            }
        }else {
            req.setAttribute("error","用户名或密码错误");
            return "userLogin";
        }
    }
    //注册
    @RequestMapping("/reg")
    public String regUser(User user,HttpServletRequest req){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("uname", user.getUname());
        map.put("password", user.getPassword());
        map.put("uphone",user.getUphone());
        map.put("address", user.getAddress());
        map.put("sex", user.getSex());
        map.put("age", user.getAge());
        User is = userService.isUser(map);
        if(is == null){
            int i = userService.regUser(map);
            System.out.println("注册成功");
            return "userLogin";
        }else {
            req.setAttribute("error","用户名以存在");
            return "regUser";
        }
    }

    //修改准备
    @RequestMapping("/updateSelect")
    public String updateSelect(Model model,int uid){
        User user = userService.updateSelect(uid);
        model.addAttribute("user2", user);
        return "personal";
    }

    //修改
    @RequestMapping("/userUpdateSelf")
    public String userUpdateSelf(User user,HttpServletRequest req,Model model){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("uname", user.getUname());
        map.put("password", user.getPassword());
        map.put("uphone",user.getUphone());
        map.put("address", user.getAddress());
        map.put("sex", user.getSex());
        map.put("age", user.getAge());
        map.put("uid", user.getUid());

        int i = userService.userUpdateSelf(map);

        if(i!=0){
            req.setAttribute("error","修改成功");
            User user2 = userService.updateSelect(user.getUid());
            model.addAttribute("user2",user2);
            return "personal";
        }else {
            req.setAttribute("error","修改失败");
            return "personal";
        }
    }


    //查询所有用户，显示到管理员页面
    @RequestMapping("/selectAllUser")
    public String selectAllUser(Params params, Model model){
        //调用所有用户信息 传递到管理员页面
        List<User> userList = userService.selectAllUser(params);
        //将获取的数据，交给分页实现类处理
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("params",params);
        return "adminConUser";
    }
    //管理员修改用户的信息 ① 根据id查到用户
    @RequestMapping("/selectUserById")
    public String selectUserById(Integer uid,Model model){
        User userinfo = userService.selectUserById(uid);
        model.addAttribute("userinfo",userinfo);
        return "adminUpdateUser";
    }
    //执行修改操作
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("uname",user.getUname());
        map.put("sex",user.getSex());
        map.put("age",user.getAge());
        map.put("uphone",user.getUphone());
        map.put("address",user.getAddress());
        map.put("status",user.getStatus());
        map.put("uid",user.getUid());
        userService.updateUserById(map);
        return "redirect:/user/selectAllUser";
    }

    //管理员删除用户，并且删除用户相关的订单记录
    @RequestMapping("/deleteUserById")
    public String deleteUserById(Integer uid){
        userService.deleteUserById(uid);
        return "redirect:/user/selectAllUser";
    }
}
