package com.onlyisssilence.muya.service;

import com.onlyisssilence.muya.BaseTest;
import com.onlyisssilence.muya.dto.AppointExecution;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: MuYa
 * Date  : 2017/1/10
 * Description:
 */
public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception {
        long bookId = 1001;
        long studentId = 12345678910L;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }
}
