package com.example.performanceasync.mapper;

import com.example.performanceasync.dto.Notice;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NoticeReadMapper {
    public List<Notice> findAll();
}
