package com.app.Controller;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.Service.calendarDemoService;
import com.app.dto.Event;

@Controller
public class CalendarController {
	
@Autowired
private calendarDemoService cds;

@RequestMapping("/add/{startTimeString}/{endTimeString}")
public @ResponseBody String addEvent(@PathVariable String startTimeString, @PathVariable String endTimeString) throws Exception{
	DateFormat formatter = new SimpleDateFormat("HH:mm");
	Date startTime = formatter.parse(startTimeString);
	Date endTime = formatter.parse(endTimeString);
	Event event = cds.addEvent(startTime.getTime(), endTime.getTime());
	if(event.getStartTime()==0 && event.getEndTime()==0)
		return "failure";
	else
		return "success";
}

@RequestMapping(value="/get", method=RequestMethod.GET)

public @ResponseBody List<Event> getEvents()
{
	return cds.getEvent();
}
}
