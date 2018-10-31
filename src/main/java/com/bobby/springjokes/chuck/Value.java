package com.bobby.springjokes.chuck;

import org.springframework.scheduling.annotation.Scheduled;

public class Value {
    private String joke;
    private Long id;

    public Value() {
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Value{" +
                "joke='" + joke + '\'' +
                ", id=" + id +
                '}';
    }

    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime(){

    }
}
