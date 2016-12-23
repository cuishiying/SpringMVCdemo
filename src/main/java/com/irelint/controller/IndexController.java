package com.irelint.controller;

import com.irelint.entity.Remark;
import com.irelint.entity.User;
import com.irelint.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vincent on 2016-12-23.
 */
@Controller
@RequestMapping(value = "/",method = RequestMethod.GET)
public class IndexController {
    @Autowired
    private IndexService indexService;

    /**
     * 模板页面
     * @param model
     * @return
     */
    @RequestMapping(value="index",method=RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("name","我是来自于controller的数据");
        return "index";
    }

    /**
     * 存入单一对象
     * @return
     */
    @RequestMapping(value="index0",method=RequestMethod.GET)
    @ResponseBody
    public Object test0(){
        User userInfo = new User();
        userInfo.setName("pinghao");
        userInfo.setSex("femail");
        indexService.saveUser(userInfo);
        return userInfo;
    }

    /**
     * 存入复杂对象
     * @return
     */
    @RequestMapping(value="index1",method=RequestMethod.GET)
    @ResponseBody
    public Object test1(){
        User userInfo = new User();
        userInfo.setName("pinghao");
        userInfo.setSex("femail");
        Remark remark = new Remark();
        remark.setInfo("我是嵌套对象");
        userInfo.setRemark(remark);
        indexService.saveUser(userInfo);
        return userInfo;
    }

    /**
     * 取出单一对象
     * @return
     */
    @RequestMapping(value="index2",method = RequestMethod.GET)
    @ResponseBody
    public Object test2(){
        return indexService.getUserById();
    }

    /**
     * 取出所有对象
     * @return
     */
    @RequestMapping(value="index3",method = RequestMethod.GET)
    @ResponseBody
    public Object test3(){
        return indexService.getUsers();
    }

    /**
     * 从客户端提交对象数据,get post均可. ?name=""&sex=""
     */
    @RequestMapping(value = "index4",method = RequestMethod.POST)
    @ResponseBody
    public void test4(User userInfo){
        indexService.saveUser(userInfo);
    }
    /**
     * 从客户端提交对象数据，?name=""&sex=""
     */
    @RequestMapping(value = "index5",method = RequestMethod.GET)
    @ResponseBody
    public void test5(@ModelAttribute("user") User user){
        indexService.saveUser(user);
    }


    /**
     * 从客户端提交json
     */
    @RequestMapping(value = "index6",method = RequestMethod.POST)
    @ResponseBody
    public String test6(@RequestBody User userInfo){
        System.out.print(userInfo.toString());
        indexService.saveUser(userInfo);
        return "success";
    }


    /**
     * 从客户端提交参数,rest风格
     */
    @RequestMapping(value = "index7/{name}",method = RequestMethod.GET)
    @ResponseBody
    public void test7(@PathVariable String name){
        User userInfo = new User();
        userInfo.setName(name);
        userInfo.setSex("femail");
        indexService.saveUser(userInfo);
    }
    /**
     * 从客户端提交参数
     */
    @RequestMapping(value = "index8",method = RequestMethod.GET)
    @ResponseBody
    public void test8(@RequestParam String name,@RequestParam String sex){
        User userInfo = new User();
        userInfo.setName(name);
        userInfo.setSex(sex);
        indexService.saveUser(userInfo);
    }
    /**
     * 从客户端提交参数
     */
    @RequestMapping(value = "index9",method = RequestMethod.GET)
    @ResponseBody
    public void test9(@RequestParam("n") String name,@RequestParam("s") String sex){
        User userInfo = new User();
        userInfo.setName(name);
        userInfo.setSex(sex);
        indexService.saveUser(userInfo);
    }

    /**
     * 根据id删除指定对象
     * @param id
     * @return
     */
    @RequestMapping(value = "delById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String delById(@PathVariable("id") Integer id){
        indexService.delUser(id);
        return "ok!!!";
    }

    /**
     * 根据id修改
     * @param id
     * @return
     */
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String updateById(@PathVariable("id") Integer id){
        indexService.updateUser();
        return "update ok";
    }

    /**
     * 根据id修改
     * @param name
     * @param id
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.GET)
    @ResponseBody
    public String updateById(String name, Integer id){
        indexService.updateInfo(name,id);
        return "update ok!!!";
    }
}
