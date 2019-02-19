package com.crud.tasks.scheduler;

import org.junit.Test;

public class SchedulerTestSuite {

    @Test
    public void sendInformationMailStringTest() {
        //Given
        long count = 1;

        String message = "Currently in the database you have: " + count + " tasks";
        if(count == 1) message = message.substring(0, message.length() - 1);

        //When

        //Then
        System.out.println(message);
    }
}
