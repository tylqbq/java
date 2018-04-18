package com.bishetyl.controller;

import com.bishetyl.service.CityService;
import com.bishetyl.util.Log;
import com.bishetyl.util.Result;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by 汤玉龙 on 2018/4/18.
 */
@Controller
@ResponseBody
@Log(title = "城市")
public class CityController {
    Result result = null;

    @RequestMapping("/city/getCityList")
    @ResponseBody
    @Log(title = "用户登录")
    public Result getCityList(@RequestBody String pyCode){
//        System.out.println(pyCode);
        CityService cityService = new CityService();
        List<String> cityList = new ArrayList<String>();
        cityList = cityService.getCityList(pyCode);
        result.setData(cityList);
        return  result;
    }
}
