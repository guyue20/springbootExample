package com.baizhi.controller;


import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.Timer;

@Log4j
public class Goeasytest {
    @Test
    public void testgo() {
        Timer timer = new Timer();
        timer.schedule(new Mytimer(),1000,3000);
    }
}
