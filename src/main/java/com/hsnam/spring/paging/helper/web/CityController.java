package com.hsnam.spring.paging.helper.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hsnam.spring.paging.helper.model.CityModel;
import com.hsnam.spring.paging.helper.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public PageInfo<CityModel> selectCityList(@RequestParam(defaultValue = "1") Integer pageNum,
                                          @RequestParam(defaultValue = "3") Integer pageSize){
        try{
            //https://developpaper.com/string-boot-mybatis-pagehelper-uses-paging/
            PageHelper.startPage(pageNum, pageSize);
            List<CityModel> cityList = cityService.selectCityList();
            log.info("pageNum = {}, pageSize={}", pageNum, pageSize);

            PageInfo<CityModel> cityModelPageInfo = new PageInfo<CityModel>(cityList);
            log.info("City List size = {}", cityModelPageInfo.getList().size());
            return cityModelPageInfo;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }
}
