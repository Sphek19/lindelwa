package com.weather.lindelwa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Current {
    private long last_updated_epoch;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime last_updated;
    private double temp_c;
    private double temp_f;
    private int is_day;
    private Condition condition;
    
    private double wind_mph;
    private double wind_kph;
    private double wind_degree;
    private String wind_dir;
    private double pressure_mb;
    private double pressure_in;
    private double precip_mm;
    private double precip_in;
    private double humidity;
    private double cloud;
    private double feelslike_c;
    private double feelslike_f;
    private double vis_km;
    private double vis_miles;
    private double uv;
    private double gust_mph;
    private double gust_kph;
}
