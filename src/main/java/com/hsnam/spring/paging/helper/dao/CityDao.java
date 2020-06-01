package com.hsnam.spring.paging.helper.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hsnam.spring.paging.helper.model.CityModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {

    private String namespace="com.hsnam.spring.paging";

    @Autowired
    private SqlSession sqlSession;

    /**
     * 페이지 조회
     * @param pageNo 페이지 번호
     * @param pageSize 화면에 보여줄 게시글 갯수
     * @return
     */
    public PageInfo<CityModel> selectCityList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        return PageInfo.of(sqlSession.selectList(namespace+".selectCityList"));
    }


}
