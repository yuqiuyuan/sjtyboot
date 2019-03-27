package com.dre.sjty.com.dre.sjty.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Component
@Controller()
public class SjtyJDBCTestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("getUsers")
    public List<Map<String, Object>> getUsers() {
        String sql = "select * from user ";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}
