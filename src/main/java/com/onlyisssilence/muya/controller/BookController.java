package com.onlyisssilence.muya.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.onlyisssilence.muya.dto.Result;
import com.onlyisssilence.muya.entity.SeedLog;
import com.onlyisssilence.muya.service.SeedLogService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * Author: MuYa
 * Date  : 2017/1/10
 * Description:
 */
@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/细分 /seckill/list
public class BookController {

    @Autowired
    private SeedLogService logService;

    /**
     * 存储单个log
     *
     * @param singleLogJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addSingleLog", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "添加日志", httpMethod = "POST", notes = "添加单条日志数据", response = Result.class)
    public Result<String> addSingleLog(@ApiParam(required = true) @RequestParam String singleLogJson) {

        SeedLog seedLog = JSON.parseObject(singleLogJson, SeedLog.class);

        String id = UUID.randomUUID().toString();

        seedLog.setId(id);
        int ret = logService.insert(seedLog);

        return new Result<String>(0, "success", ret + "");
    }

    /**
     * 存储log list
     *
     * @param seedListJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addLogList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "添加日志", httpMethod = "POST", notes = "添加多条日志数据", response = Result.class)
    public Result<String> addLogList(@ApiParam(required = true) @RequestParam String seedListJson) {

        List<SeedLog> seedLogList;

        try {
            seedLogList = JSON.parseArray(seedListJson, SeedLog.class);
        } catch (JSONException e) {
            return new Result<String>(-1, "fail", "格式解析异常");
        }

        if (seedLogList == null || seedLogList.size() == 0) {
            return new Result<String>(0, "success", "日志数据为空");
        }

        try {
            String id;
            for (SeedLog seedlog : seedLogList) {
                id = UUID.randomUUID().toString();
                seedlog.setId(id);
                logService.insert(seedlog);
            }
        } catch (Exception e) {
            return new Result<String>(-1, "fail", "日志添加数据库异常");
        }

        return new Result<String>(0, "success", seedLogList.size() + "");
    }

    /**
     * 根据id查询单条日志信息
     *
     * @param logId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "querySingleLog", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "查询日志", httpMethod = "GET", notes = "获取单条日志信息", response = Result.class)
    public Result<SeedLog> querySingleLog(@ApiParam(required = true) @RequestParam String logId) {

        SeedLog seedLog = logService.queryLogById(logId);

        return new Result<SeedLog>(0, "success", seedLog);
    }

    /**
     * 根据id查询单条日志信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryAll", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "查询日志", httpMethod = "GET", notes = "获取所有日志信息", response = Result.class)
    public Result<List<SeedLog>> querySingleLog() {

        List<SeedLog> seedLogList = logService.queryAllLog();

        return new Result<List<SeedLog>>(0, "success", seedLogList);
    }


}




























