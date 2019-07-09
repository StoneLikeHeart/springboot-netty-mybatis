package com.future.desk.controller;

import com.future.desk.enums.ResMsgEnum;
import com.future.desk.model.Users;
import com.future.desk.params.UsersParam;
import com.future.desk.services.UsersService;
import com.future.desk.utils.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public Map<String,Object> loginUser(HttpServletRequest request,UsersParam usersParam){
        Map<String,Object> regMsg = new HashMap<>();
        if (verifiData(usersParam, regMsg,request.getHeader("deviceId"))) return regMsg;
        UsersParam resUser = null;
        if(null != (resUser = usersService.loginUser(usersParam))){
            regMsg.put("result",true);
            regMsg.put("status",100);
            regMsg.put("message","成功");
        }else{
            regMsg.put("result",false);
            regMsg.put("status",101);
            regMsg.put("message","登陆失败");
        }
        regMsg.put("data",resUser);

        return regMsg;
    }

    @RequestMapping(value = "/regUser",method = RequestMethod.POST)
    public Map<String,Object> registerUser(UsersParam usersParam, HttpServletRequest request){
        Map<String,Object> regMsg = new HashMap<>();
        if (verifiData(usersParam, regMsg,request.getHeader("deviceId"))) return regMsg;
        if (usersService.registerUser(usersParam)){
            regMsg.put("result",true);
            regMsg.put("status",100);
            regMsg.put("message","成功");
        }else{
            regMsg.put("result",false);
            regMsg.put("status",101);
            regMsg.put("message","插入数据库失败");
        }

        return regMsg;
    }

    /**
     * 常规认证
     * @param usersParam
     * @param regMsg
     * @return
     */
    private boolean verifiData(UsersParam usersParam, Map<String, Object> regMsg,String deviceId) {
        if (null==usersParam){
            regMsg.put("result",false);
            regMsg.put("status",101);
            regMsg.put("message","参数为空");
            return true;
        }
        if (StringTools.isNull(usersParam.getPhone())){
            regMsg.put("result",false);
            regMsg.put("status",101);
            regMsg.put("message","phone 为空");
            return true;
        }
        if (StringTools.isNull(usersParam.getVerifiCode())){
            regMsg.put("result",false);
            regMsg.put("status",101);
            regMsg.put("message","verifiCode 为空");
            return true;
        }
        if (StringTools.isNull(deviceId)){
            regMsg.put("result",false);
            regMsg.put("status",101);
            regMsg.put("message","deviceId 为空");
            return true;
        }
        usersParam.setDeviceId(deviceId);
        //验证验证码  begin
        if (!"1111".equals(usersParam.getVerifiCode())){
            regMsg.put("result",false);
            regMsg.put("status",102);
            regMsg.put("message","验证码不正确");
            return true;
        }
        //验证验证码  end
        return false;
    }


}
