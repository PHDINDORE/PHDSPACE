package com.app.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CalendarDao;
import com.app.dto.Event;

@Service
@Transactional
public class calendarDemoServiceImpl implements calendarDemoService {
@Autowired
private CalendarDao calendarDao;
	@Override
	public Event addEvent(long startTime, long endTime) {
		// TODO Auto-generated method stub
		List<Event> eventList = calendarDao.getEvent();
		Event event = new Event(startTime, endTime);
		
		for(Event tempEvent : eventList)
		{
			if((tempEvent.getStartTime()>=event.getStartTime()) && (tempEvent.getEndTime()<=event.getEndTime()))
					return new Event(0,0);
		}
		return  calendarDao.addEvent(startTime, endTime);
	}
	
	public List<Event> getEvent()
	{
		return calendarDao.getEvent();
	}
}
