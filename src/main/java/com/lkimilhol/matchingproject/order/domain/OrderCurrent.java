package com.lkimilhol.matchingproject.order.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
public class OrderCurrent {

    private String name;
    private String job;

    @Override
    public String toString() {
        return "name is " + name + " job is " + job;
    }
}
