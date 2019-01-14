package com.johnxb.bbs.dao.mapper;

import com.johnxb.bbs.entity.BbsAdminLog;
import java.util.List;

public interface BbsAdminLogMapper {
    List<BbsAdminLog> selectAll();
}