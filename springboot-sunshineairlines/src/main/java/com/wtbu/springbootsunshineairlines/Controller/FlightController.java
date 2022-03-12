package com.wtbu.springbootsunshineairlines.Controller;


import com.wtbu.springbootsunshineairlines.Service.FlightService;
import com.wtbu.springbootsunshineairlines.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class FlightController {

    @Resource
    private FlightService flightService;

    @RequestMapping("/getFlightStatus")
    public Object getFlightStatus(@RequestParam("departureDate") String departureDate, @RequestParam("startPage") int startPage
            , @RequestParam("pageSize") int pageSize ) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("startDepartureDate", departureDate+" 00:00:00");
        map.put("endDepartureDate", departureDate+" 23:59:59");
        map.put("page", startPage);
        map.put("pageSize", pageSize);
        Result result = flightService.getFlightStatus(map);
        return result;
    }



    @RequestMapping("/getSchedule")
    public Object getSchedule(@RequestParam("fromCity") String fromCity,@RequestParam("toCity") String toCity
            ,@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate ) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("fromCity", fromCity);
        map.put("toCity", toCity);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        Result result = flightService.getSchedule(map);
        return result;
    }



    @RequestMapping("/updateSchedule")
    public Object updateSchedule(@RequestParam("scheduleId") int scheduleId,@RequestParam("status") String status ) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("scheduleId", scheduleId);
        map.put("status", status);
        Result result = flightService.updateSchedule(map);
        return result;
    }


    @RequestMapping("/getScheduleDetail")
    public Object getScheduleDetail(@RequestParam("scheduleId") int scheduleId) {
        Result result = flightService.getScheduleDetail(scheduleId);
        return result;
    }

}
