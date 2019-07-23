package com.baizhi.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.entity.Goeasydata;
import io.goeasy.GoEasy;

import java.util.Random;
import java.util.TimerTask;

public class Mytimer extends TimerTask {

    @Override
    public void run() {
      //  System.out.println("1111");
        Random rand = new Random();
        int [] listdata= new int [7];
        for(int i=0;i<7;i++){
            int data = rand.nextInt(65) + 64;
            listdata[i]=data;
        }
        Goeasydata goeasydata = new Goeasydata();
        goeasydata.setDatakey("data");
        goeasydata.setDatalist(listdata);
        String s = JSON.toJSONString(goeasydata);
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-b8fd397f277f4f1082af3fa510203e2d");
        goEasy.publish("my_channel",s);
    //    System.out.println(s);
    }
}
