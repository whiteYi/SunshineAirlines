package com.wtbu.springbootsunshineairlines.Service;

import com.wtbu.springbootsunshineairlines.pojo.Result;

import java.util.HashMap;

public interface FlightService {
    Result getFlightStatus(HashMap<String, Object> map);

    Result getSchedule(HashMap<String, Object> map);

    Result updateSchedule(HashMap<String, Object> map);

    Result getScheduleDetail(int scheduleId);
}
