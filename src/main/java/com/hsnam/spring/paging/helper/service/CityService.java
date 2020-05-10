package com.hsnam.spring.paging.helper.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnam.spring.paging.helper.dao.CityDao;
import com.hsnam.spring.paging.helper.model.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityDao cityDao;


    public List<CityModel> selectCityList(){
        return cityDao.selectCityList();
    }

}
