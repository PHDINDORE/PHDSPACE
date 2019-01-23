package com.app.dao;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dto.Event;

@Repository
public class CalendarDemoImpl implements CalendarDao {
@Autowired
private SessionFactory sf;
	@Override
	public Event addEvent(long startTime, long endTime) {
		// TODO Auto-generated method stub
		Event event = new Event(startTime, endTime);
		sf.getCurrentSession().persist(event);
		return event;
	}

	public List<Event> getEvent()
	{
		List<Event> eventList = new ArrayList<Event>();
		eventList = sf.getCurrentSession().createCriteria(Event.class).list();
		return eventList;
	}
}
