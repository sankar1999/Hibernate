package com.game.allgames.enterprise.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MyWebController {

    private BusinessService businessService;

    @Autowired
    public MyWebController(BusinessService businessService) {
        this.businessService = businessService;
    }

    public long returnValueFromBusinessService() {
        return businessService.calculateSum();
    }
}
@Component
class BusinessService {

    private DataService dataService;

    @Autowired
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }

    public long calculateSum() {
        List<Integer> data = dataService.getData();
        return data.stream().reduce(Integer::sum).get();
    }
}

@Component
class DataService {
    public List<Integer> getData() {
        return Arrays.asList(10, 20, 30);
    }
}
