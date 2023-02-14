package com.wy.shixun.account.dao;


import com.wy.shixun.account.entity.User;
import com.wy.shixun.common.vo.Search;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDao
 */
@Repository
@Mapper
public interface UserDao {

    @Insert("insert into account_user(user_name, password, create_date, update_time) " +
            "values(#{userName}, #{password}, #{createDate}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertUser(User user);

    @Select("select * from account_user where user_name = #{userName} limit 1")
    User getUserByUserName(String userName);

    @Update("update account_user set user_name = #{userName}, password=#{password}, " +
            "update_time = #{updateTime} where id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM acconut_user WHERE id = #{id}")
    void deleteUserById(int id);

    @Select("select * from account_user where id = #{id}")
    User getUserById(int id);

    @Select("<script"
            + "select * from account_user where"
    +"<if test ='keyword !=\"\" and keyword !=null'>"
    +"and (userName like '%${keyword}')"
    +"</if>"
    +"</where>"
    +"<choose>"
    +"<when test='sort !=\"\" and sort !=null'>"
    +"order by $<sort> $<direction>"
    +"</when>"
    +"<otherwise>"
    +"order by id desc"
    +"</otherwise>"
    +"</choose>"
    +"</script>")
    List<User> getUserBySearch(Search search);

    @Select("select * from account_user au left join economy_books_user ebu " +
            "on au.id = ebu.user_id where ebu.books_id = #{booksId}")
    List<User> getUsersByBooksId(int booksId);
}
