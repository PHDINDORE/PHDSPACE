package com.app.dto;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="event")
public class Event  implements Serializable{
private Integer eventId;

private long startTime;

private long endTime;

public Event()
{
	
}
public Event(long startTime, long endTime)
{
	super();
	this.startTime = startTime;
	this.endTime = endTime;
}
@Id
@GeneratedValue
public Integer getEventId() {
	return eventId;
}
public void setEventId(Integer eventId) {
	this.eventId = eventId;
}


public long getStartTime() {
	return startTime;
}
public void setStartTime(long startTime) {
	this.startTime = startTime;
}

public long getEndTime() {
	return endTime;
}
public void setEndTime(long endTime) {
	this.endTime = endTime;
}
}
