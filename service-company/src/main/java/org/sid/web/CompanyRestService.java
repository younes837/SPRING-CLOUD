package org.sid.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RefreshScope
@RestController
public class CompanyRestService {
    @Value("${x}")
    private int x;
    @Value("${y}")
    private int y;
    @Value("${me}")
    private String me;
    @GetMapping("/myParams")
    public Map<String,Object> myParams(){
        Map<String,Object> params=new HashMap<>();
        params.put("x",x);
        params.put("y",y);
        params.put("me",me);
        params.put("ThreadName",Thread.currentThread().getName());
        return params;

    }

}
