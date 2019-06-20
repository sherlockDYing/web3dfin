package com.example.springboottest1.service;

import com.example.springboottest1.entity.Statue;
import com.example.springboottest1.mapper.statueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class StatueService {

    @Autowired
    private statueMapper statueMapper;

    public Statue findStatuerByStatuename(String stauename) {
        return statueMapper.findStatuerByStatuename(stauename);
    }

    public Boolean updateStatueLikenumber(Statue statue) {
        return statueMapper.updateStatueLikenumber(statue);
    }


}
