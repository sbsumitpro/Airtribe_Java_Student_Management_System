package com.airtribe.studentmanagement.entity;

import com.airtribe.studentmanagement.Interface.Searchable;

public class Course implements Searchable {
    private final String id;
    private final String name;
    private final String description;

    public Course(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean matches(String keyword){
        keyword = keyword.toLowerCase();
        return this.name.toLowerCase().contains(keyword)
                || this.description.toLowerCase().contains(keyword)
                || this.id.toLowerCase().contains(keyword);
    }
}

