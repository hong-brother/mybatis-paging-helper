package com.hsnam.spring.paging.helper.web;

import com.github.pagehelper.PageInfo;
import com.hsnam.spring.paging.helper.model.CityModel;
import com.hsnam.spring.paging.helper.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 페이지 조회
     * @param pageNum 페이지 번호
     * @param pageSize 한페이지에 보여줄 게시글 수
     * @return
     */
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public ResponseEntity<PageInfo> selectCityList(@RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "3") Integer pageSize){
        try{

            log.info("pageNum = {}, pageSize={}", pageNum, pageSize);
            PageInfo<CityModel> list =cityService.selectCityList(pageNum, pageSize);
            log.info("City List size = {}", list);
            return ResponseEntity.ok(list);
        }catch (Exception e){
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
