package com.wtbu.springbootsunshineairlines.Dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface FlightDao {
    List<HashMap<String, Object>> getFlightStatus(HashMap<String, Object> map);

    List<HashMap<String, Object>> getSchedule(HashMap<String, Object> map);

    List<HashMap<String, Object>> getScheduleByScheduleId(HashMap<String, Object> map);

    void updateSchedule(HashMap<String, Object> map);

    List<HashMap<String, Object>> findScheduleByScheduleId(int scheduleId);

    List<HashMap<String, Object>> findTicketsByScheduleId(int scheduleId);

    List<HashMap<String, Object>> findSeatByScheduleId(int scheduleId);

    List<HashMap<String, Object>> findSeatByAircraftId(int aircraftId);
}
