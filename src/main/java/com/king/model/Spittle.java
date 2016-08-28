package com.king.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by jin82 on 2016/06/10.
 */
public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitudel;

    public Spittle(String message, Date time, Double latitude, Double longitudel) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitudel = longitudel;
    }

    public Spittle(Date time, String message) {
        this(message,time,null,null);
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitudel() {
        return longitudel;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this,obj,"id","time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,"id","time");
    }
}
