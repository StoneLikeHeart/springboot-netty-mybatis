package com.future.desk.mapper;

import com.future.desk.model.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UsersMapper {

    @Select("SELECT * FROM sys_user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "sex",  column = "sex"/*, javaType = UserSexEnum.class*/),
            @Result(property = "token", column = "token")
    })
    List<Users> getAll();

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "sex",  column = "sex"/*, javaType = UserSexEnum.class*/),
            @Result(property = "token", column = "token")
    })
    Users getOne(Long id);

    @Select("SELECT * FROM sys_user WHERE phone = #{phone}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "sex",  column = "sex"/*, javaType = UserSexEnum.class*/),
            @Result(property = "token", column = "token")
    })
    Users getUserByPhone(String phone);

//    @Insert("insert into table(XXX,XXX,XXX) values(#{demo.XXX},#{demo.XXX},#{demo.XXX}) ")
//    @SelectKey(keyProperty = "demo.id", keyColumn = "id", statement = "select @@identity as id",resultType = Integer.class, before = false)
//    public int insertdemo(@Param("demo") DemoBean demo);

    @Insert("INSERT INTO sys_user(phone,nickname,sex,token) VALUES(#{phone}, #{nickname}, #{sex}, #{token})")
    int insert(Users user);

    @Update("UPDATE sys_user SET nickname=#{nickname},sex=#{sex},token=#{token} WHERE id =#{id}")
    void update(Users user);

    @Delete("DELETE FROM sys_user WHERE id =#{id}")
    void delete(Long id);


}
