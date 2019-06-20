package com.example.springboottest1.mapper;


import com.example.springboottest1.entity.Statue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface statueMapper {
    //通过发表评论者查找
    Statue findStatuerByStatuename(@Param("statuename") String statuename);

    //更新雕塑（主要更新收藏数）
    Boolean updateStatueLikenumber(Statue statue);
}
