package com.racic.homeshop.web;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BillServletTest {

    @Test
    public void Given_twoParams_When_splitParams_Then_fillMapCorrectly(){
        BillServlet billServlet = new BillServlet();
        Map<String,String> params = billServlet.splitParameters("p1=v1&p2=v2");
        assertEquals(2, params.size());
        assertEquals("v1",params.get("p1"));
        assertEquals("v2",params.get("p2"));
    }

    @Test
    public void Given_oneEmptyParamsAndOneGoodParams_When_splitParams_Then_fillMapCorrectly(){
        BillServlet billServlet = new BillServlet();
        Map<String,String> params = billServlet.splitParameters("p1=&p2=v2");
        assertEquals(1, params.size());
        assertEquals("v2",params.get("p2"));
    }

    @Test
    public void Given_NoParams_When_splitParams_Then_fillMapCorrectly(){
        BillServlet billServlet = new BillServlet();
        Map<String,String> params = billServlet.splitParameters("test");
        assertEquals(0, params.size());
    }
}