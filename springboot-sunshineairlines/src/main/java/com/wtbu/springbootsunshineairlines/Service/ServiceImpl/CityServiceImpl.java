package com.wtbu.springbootsunshineairlines.Service.ServiceImpl;

import com.wtbu.springbootsunshineairlines.Dao.CityDao;
import com.wtbu.springbootsunshineairlines.Service.CityService;
import com.wtbu.springbootsunshineairlines.pojo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityDao cityDao;

    @Override
    public Result getCityNames() {
        Result result = new Result("fail", null);

        List<HashMap<String, Object>> list = cityDao.getCityNames();
        if (list != null && list.size() > 0) {
            result.setFlag("success");
            result.setData(list);
        }

        return result;
    }

}
