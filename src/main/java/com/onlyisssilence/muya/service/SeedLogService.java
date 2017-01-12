package com.onlyisssilence.muya.service;

import com.onlyisssilence.muya.entity.SeedLog;

import java.util.List;

/**
 * Author: MuYa
 * Date  : 2017/1/12
 * Description:
 */
public interface SeedLogService {

    int insert(SeedLog seedLog);

    SeedLog queryLogById(String logId);

    List<SeedLog> queryAllLog();

}
