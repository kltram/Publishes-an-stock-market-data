package com.stackextend.websocketbackendexample.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.stackextend.websocketbackendexample.model.Notifications;
import com.stackextend.websocketbackendexample.model.Stocks;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate template;

    private Notifications notifications = new Notifications(0);

    @GetMapping("/notify")
    public String getNotification() {
    	try{
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<String>   cardDetails = restTemplate.getForEntity(
    	        "https://nseindia.com/live_market/dynaContent/live_watch/stock_watch/niftyStockWatch.json", String.class);
        
    	ObjectMapper mapper = new ObjectMapper();
    	JsonNode root = mapper.readTree(cardDetails.getBody());
    	JsonNode arrayNode  = root.path("data");
    	System.out.println("name "+arrayNode .size());
    	
    	/*ObjectReader reader = mapper.readerFor(new TypeReference<List<String>>() {
    	});*/
    	// use it
    //	List<String> list = reader.readValue(arrayNode);
    //	assertThat(name.asText(), notNullValue());
    		Stocks stocks;
    		for(JsonNode item : arrayNode){
    			stocks = new Stocks();
    			stocks.setSymbol(item.path("symbol").toString());
    			stocks.setHigh(item.path("high").toString());
    			stocks.setLow(item.path("low").toString());
    			stocks.setLtP(item.path("ltP").toString());
    			stocks.setTrdVol(item.path("trdVol").toString());
    			stocks.setTrdVolM(item.path("trdVolM").toString());
    			stocks.setmVal(item.path("mVal").toString());
    			stocks.setxDt(item.path("xDt").toString());
    			stocks.setDayEndClose(item.path("dayEndClose").toString());
    			stocks.setIislPtsChange(item.path("iislPtsChange").toString());
    			stocks.setListofStocks(stocks);
    			
    			notifications.setSymbol(item.path("symbol").toString());
    			notifications.setListofStocks(stocks);
    			break;
    			//System.out.println("name stocks "+stocks.getListofStocks());
    		}
    		
    		//System.out.println("name getListofStocks "+stocks.getListofStocks().size());
    	notifications.increment();
    	//notifications.setListofStocks(stocks);
    	
    	System.out.println("notifications getListofStocks "+notifications.getListofStocks().size());
        //template.convertAndSend("/topic/notification", notifications);
        template.convertAndSend("/topic/notification", arrayNode);
    	}catch (Exception exp){
    		
    	}

        return "Notifications successfully sent to Angular !";
    }
}
