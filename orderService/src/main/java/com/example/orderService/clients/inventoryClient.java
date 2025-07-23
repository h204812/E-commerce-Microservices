package com.example.orderService.clients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="inventory",url="http://inventory:8082")
public interface inventoryClient {

    Logger log = LoggerFactory.getLogger(inventoryClient.class);

    @RequestMapping(method= RequestMethod.GET,value="/api/inventory")
    @CircuitBreaker(name="inventory",fallbackMethod = "fallbackMethod")
    @Retry(name="inventory")
    boolean isInStock(@RequestParam String skuCode,@RequestParam Integer quantity);

    default  boolean fallbackMethod(String code,Integer quantity , Throwable throwable){
        log.info("Cannot get inventory for skucode {},failure reason : {}",code,throwable.getMessage());
        return  false;
    }

}
