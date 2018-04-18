package com.bishetyl.service;

import com.bishetyl.dao.CityDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 汤玉龙 on 2018/4/18.
 */
public class CityService {
    public CityService(){

    }

    public List<String> getCityList(String pyCode){
        List<String> cityList = new ArrayList<String>();
        CityDao cityDao = new CityDao();
        cityList = cityDao.getCityByPyCode(pyCode);
        return cityList;
    }
}
