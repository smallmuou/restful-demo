package xyz.smallmuou.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import xyz.smallmuou.entity.User;

import java.util.List;

/**
 * Created by smou on 7/9/2018.
 */
@Repository

//使用xml配置
@Mapper
public interface UserMapper {

    //使用xml配置
    //@Select("SELECT * FROM tb_user WHERE id = #{id}")
    public User getUserById(Integer id);

    //@Select("SELECT * FROM tb_user")
    public List<User> getUserList();

    //@Insert("insert into tb_user(name) values(#{name})")
    public int add(User user);

    //@Update("UPDATE tb_user SET name = #{user.name} WHERE id = #{id}")
    public int update(@Param("id") Integer id, @Param("user") User user);

    //@Delete("DELETE from tb_user where id = #{id} ")
    public int delete(Integer id);
}
