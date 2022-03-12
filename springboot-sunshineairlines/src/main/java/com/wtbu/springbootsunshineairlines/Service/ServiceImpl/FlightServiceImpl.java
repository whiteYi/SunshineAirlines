package com.wtbu.springbootsunshineairlines.Service.ServiceImpl;

import com.wtbu.springbootsunshineairlines.Dao.FlightDao;
import com.wtbu.springbootsunshineairlines.Service.FlightService;
import com.wtbu.springbootsunshineairlines.pojo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlightServiceImpl implements FlightService {

    @Resource
    private FlightDao flightDao;

    @Override
    public Result getFlightStatus(HashMap<String, Object> map) {
        Result result = new Result("fail", null);
        List<HashMap<String, Object>> list = flightDao.getFlightStatus(map);
        if (list !=null && list.size()>0) {
            result.setFlag("seccess");
            result.setData(list);
        }

        return result;
    }

    @Override
    public Result getSchedule(HashMap<String, Object> map) {
        Result result = new Result("fail", null);
        List<HashMap<String, Object>> list = flightDao.getSchedule(map);
        if (list !=null && list.size()>0) {
            result.setFlag("seccess");
            result.setData(list);
        }

        return result;
    }

    @Override
    public Result updateSchedule(HashMap<String, Object> map) {
        Result result = new Result("fail", null);

        List<HashMap<String, Object>> list = flightDao.getScheduleByScheduleId(map);
        if (list !=null && list.size()>0) {
            flightDao.updateSchedule(map);
            result.setFlag("seccess");
        }
        else {
            result.setData("航班计划不存在");
        }

        return result;
    }

    @Override
    public Result getScheduleDetail(int scheduleId) {
        Result result = new Result("fail", null);

        List<HashMap<String , Object>> listSchedule = flightDao.findScheduleByScheduleId(scheduleId);
        if (listSchedule !=null && listSchedule.size()>0) {
            int aircraftId = Integer.parseInt(listSchedule.get(0).get("AircraftId").toString());
            List<HashMap<String , Object>> listTickets = flightDao.findTicketsByScheduleId(scheduleId);
            List<HashMap<String , Object>> listSeat = flightDao.findSeatByScheduleId(scheduleId);
            List<HashMap<String , Object>> listSeatLayout = flightDao.findSeatByAircraftId(aircraftId);
            Map<String, Object> allList = new HashMap<String, Object>();
            allList.put("listSchedule", listSchedule);
            allList.put("listTickets", listTickets);
            allList.put("listSeat", listSeat);
            allList.put("listSeatLayout", listSeatLayout);
            result.setFlag("seccess");
            result.setData(allList);
        }
        else {
            result.setData("航班计划不存在");
        }

        return result;
    }

}
