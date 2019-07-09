package com.future.desk.services.impl;

import com.future.desk.model.Users;
import com.future.desk.mapper.UsersMapper;
import com.future.desk.params.UsersParam;
import com.future.desk.services.UsersService;
import com.future.desk.utils.StringTools;
import com.future.desk.utils.Tools;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import javax.annotation.Resource;

@Service
public class UsersServicesImpl implements UsersService {

    @Resource
    UsersMapper usersMapper;

    @Override
    public UsersParam loginUser(UsersParam usersParam) {
        UsersParam resUser = null;
        Users user = usersMapper.getUserByPhone(usersParam.getPhone());
        if (user!=null && !"".equals(user.getId())){
            resUser = new UsersParam(user.getId(),user.getPhone(),user.getNickname(),user.getSex(),user.getToken());
        }else{
            //没有则创建
            if(registerUser(usersParam)){
                user = usersMapper.getUserByPhone(usersParam.getPhone());
                if (user!=null && !"".equals(user.getId())){
                    resUser = new UsersParam(user.getId(),user.getPhone(),user.getNickname(),user.getSex(),user.getToken());
                }
            }
        }
        return resUser;
    }

    @Override
    public boolean registerUser(UsersParam usersParam) {
        Users user = new Users(usersParam.getPhone());

        //生成token phoneId+desk+时间戳  begin
        user.setToken(Tools.stringMD5(usersParam.getDeviceId()+"desk"+System.currentTimeMillis()));
        //生成token  end

        // 若没有昵称则用手机号码
        if (StringTools.isNull(user.getNickname())){
            user.setNickname(user.getPhone());
        }

        return usersMapper.insert(user)>0;
    }

}
