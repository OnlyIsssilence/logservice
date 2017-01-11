package com.onlyisssilence.muya.controller;

import com.alibaba.fastjson.JSON;
import com.onlyisssilence.muya.dto.Result;
import com.onlyisssilence.muya.entity.Book;
import com.onlyisssilence.muya.entity.SeedLog;
import com.onlyisssilence.muya.service.BookService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author: MuYa
 * Date  : 2017/1/10
 * Description:
 */
@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/细分 /seckill/list
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;


    /**
     * 查询书单
     *
     * @param bookId  书单ID
     * @param request
     * @return 书单详细信息 返回的是book的json数据
     */
    @ResponseBody
    @RequestMapping(
            value = "getBookById", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "按照ID查询书单")
    public String getBookById(@ApiParam(required = true, name = "bookId", value = "book id") @RequestParam(
            value = "bookId") String bookId, HttpServletRequest request) {
        Book book = bookService.getById(Integer.valueOf(bookId));

        return JSON.toJSONString(book);
    }

    /**
     * 查询书单
     * @param bookId 书单ID
     * @param request
     * @return 返回的是被包装之后的Result对象
     */
    @ResponseBody
    @RequestMapping(
            value = "getBookByIdBook", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "按照ID查询书单")
    public Result<Book> getBookByIdBook(@ApiParam(required = true, name = "bookId", value = "book id") @RequestParam(
            value = "bookId") String bookId, HttpServletRequest request) {
        Book book = bookService.getById(Integer.valueOf(bookId));

        return new Result<Book>(0, "success",book);
    }

    /**
     * 查询所有书单
     *
     * @param request
     * @return 返回booklist对象
     */
    @ResponseBody
    @RequestMapping(
            value = "getAllBooks", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "查询所有的书单")
    public List<Book> getAllBooks(HttpServletRequest request) {
        List<Book> bookList = bookService.getList();
        return bookList;
    }

    /**
     * 查询所有书单
     * @param request
     * @return 返回Result对象
     */
    @ResponseBody
    @RequestMapping(
            value = "getAllBooksResult", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "查询所有的书单")
    public Result<List<Book>> getAllBooksResult(HttpServletRequest request) {
        List<Book> bookList = bookService.getList();

        return new Result<List<Book>>(0, "success", bookList);
    }


    /**
     * 对对象的形式接收数据(seedLog对象)
     *
     * @param seedLog
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addSingleLog", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "修改学生信息", httpMethod = "POST", notes = "学生信息以json格式传递", response = Result.class)
    public Result<SeedLog> addSingleLog(@ApiParam(required = true) @RequestBody SeedLog seedLog,
                                        @ApiParam(required = true) @RequestParam String seedId) {
        System.out.println(seedId);
        return new Result<SeedLog>(0, "success",seedLog);
    }
}
