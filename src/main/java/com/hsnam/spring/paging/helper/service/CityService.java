package com.hsnam.spring.paging.helper.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hsnam.spring.paging.helper.dao.CityDao;
import com.hsnam.spring.paging.helper.model.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityDao cityDao;

    /**
     * 페이지 조회
     * @param pageNo 페이지 번호
     * @param pageSize 한페이지에 보여줄 크기
     * @return
     */
    public PageInfo<CityModel> selectCityList(int pageNo, int pageSize){
        return cityDao.selectCityList(pageNo, pageSize);
    }

}
