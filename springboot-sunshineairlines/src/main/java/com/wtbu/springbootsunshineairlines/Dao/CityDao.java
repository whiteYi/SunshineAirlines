package com.wtbu.springbootsunshineairlines.Dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CityDao {

    List<HashMap<String, Object>> getCityNames();

}
