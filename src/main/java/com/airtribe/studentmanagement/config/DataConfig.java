package com.airtribe.studentmanagement.config;

public class DataConfig {
    public static final String[][] STUDENT_DATA = {
            {"Sumit", "sbsumitpro@gmail.com", "9564283860", "ad1"},
            {"Amit", "amitpro@gmail.com", "9564283861", "ad2"},
            {"Rahul", "rahul123@gmail.com", "9564283862", "ad3"},
            {"Abdul", "abdul@gmail.com", "9564283864", "ad4"}
    };

    public static final String[][] COURSE_DATA = {
            {"cr-1", "Java-backend", "Learn Core Java"},
            {"cr-2", "Node-backend Developement", "Learn Node JS basics"},
            {"cr-3", "DSA", "Learn DSA"}
    };

    public static final String[][] ENROLLMENT_DATA = {
            {"ad1", "cr-1"}, {"ad2", "cr-1"}, {"ad3", "cr-2"},
            {"ad4", "cr-3"}, {"ad1", "cr-2"}, {"ad1", "cr-3"}
    };

}
