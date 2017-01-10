package com.onlyisssilence.muya.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.onlyisssilence.muya.dto.AppointExecution;
import com.onlyisssilence.muya.dto.Result;
import com.onlyisssilence.muya.entity.Book;
import com.onlyisssilence.muya.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<Book> list = bookService.getList();
        model.addAttribute("list", list);
        // list.jsp + model = ModelAndView
        return "list";// WEB-INF/jsp/"list".jsp
    }

    // ajax json
    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    @ResponseBody
    private String detail(@PathVariable("bookId") Long bookId, Model model) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.getById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8"})
    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @Param("studentId") Long studentId) {
        if (studentId == null || studentId.equals("")) {
            return new Result<AppointExecution>(false, "学号不能为空");
        }
        AppointExecution execution = bookService.appoint(bookId, studentId);
        return new Result<AppointExecution>(true, execution);
    }


    /**
     * 返回城市列表，当cityId未空值，返回一级列表，当cityId有值，返回二级列表
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/getAllCity", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCitys(@RequestParam(required = false) String userId, HttpServletResponse response) {


        /* 设置回应头 */
        setResponseHeader(response);

        String result = null;

        result = userId;

        return JSON.toJSONString(result, SerializerFeature.WriteMapNullValue);
    }

    /**
     * * 设置回应头信息
     *
     * @param response
     */
    private void setResponseHeader(HttpServletResponse response) {

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return;
    }

}
