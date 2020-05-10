package com.hsnam.spring.paging.helper.dao;

import com.github.pagehelper.Page;
import com.hsnam.spring.paging.helper.model.CityModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CityDao {

    private String namespace="com.hsnam.spring.paging";

    @Autowired
    private SqlSession sqlSession;

    public List<CityModel> selectCityList(){
        return sqlSession.selectList(namespace+".selectCityList");
    }


}
