package com.wy.shixun.property.dao;

import com.wy.shixun.property.entity.BooksUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BooksUserDao {
    @Insert("insert into economy_books_user(user_id,books_id)"+
    "values user_id = #{use}")
    void insertBooksUser(BooksUser booksUser);

    @Delete("delete from economy_books_user where books_id = #{booksId}")
    void deleteBooksUserByBooksId(int booksId);
}
