package com.onlyisssilence.muya.service.impl;

import com.onlyisssilence.muya.dao.SeedLogMapper;
import com.onlyisssilence.muya.entity.SeedLog;
import com.onlyisssilence.muya.service.SeedLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: MuYa
 * Date  : 2017/1/12
 * Description:
 */

@Service
public class SeedLogServiceImpl implements SeedLogService {

    @Autowired
    private SeedLogMapper seedLogMapper;

    @Override
    public boolean insertList(List<SeedLog> seedLogs) {
        if (seedLogs == null || seedLogs.size() == 0) {
            return false;
        } else {
            for (SeedLog seedlog : seedLogs) {
                try {
                    insert(seedlog);
                } catch (Exception e) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int insert(SeedLog seedLog) {
        return seedLogMapper.insert(seedLog);
    }

    @Override
    public SeedLog queryLogById(String logId) {
        return seedLogMapper.queryByLogId(logId);
    }

    @Override
    public List<SeedLog> queryAllLog() {
        return seedLogMapper.queryAll();
    }


}
