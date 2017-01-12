package com.onlyisssilence.muya.dao;

import com.onlyisssilence.muya.entity.SeedLog;

import java.util.List;

/**
 * Author: MuYa
 * Date  : 2017/1/12
 * Description:
 */
public interface SeedLogMapper {

    /**
     * 通过ID日志
     *
     * @param logId
     * @return
     */
    SeedLog queryByLogId(String logId);


    /**
     * 查询所有的日志
     *
     * @return
     */
    List<SeedLog> queryAll();


    /**
     * 添加日志
     *
     * @param seedLog
     * @return
     */
    int insert(SeedLog seedLog);
}
