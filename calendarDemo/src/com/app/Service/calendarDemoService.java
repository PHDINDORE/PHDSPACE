package com.app.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.app.dto.Event;

public interface calendarDemoService {
public Event addEvent(long startTime, long endTime);
public List<Event> getEvent();
}
