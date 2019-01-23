package com.app.dao;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.app.dto.Event;

public interface CalendarDao {
public Event addEvent(long startTime, long endTime);
public List<Event> getEvent();
}
