package com.greetingapp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greetingApp")
public class Greeting {
    @Id
    private long incrementAndGet;
    private String format;

    public Greeting(long incrementAndGet, String format) {
        this.incrementAndGet = incrementAndGet;
        this.format = format;
    }

    public long getIncrementAndGet() {
        return incrementAndGet;
    }

    public String getFormat() {
        return format;
    }
}