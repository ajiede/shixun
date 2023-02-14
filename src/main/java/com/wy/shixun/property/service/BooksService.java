package com.wy.shixun.property.service;

import com.wy.shixun.common.vo.Result;
import com.wy.shixun.property.entity.Books;

public interface BooksService {
    Result<Books> insertBooks(Books books);

    Result<Books> updateBooks(Books books);

    Result<Object> deleteBooksById(int id);

    Books getBooksById(int id);
}
