//package com.easyLearing.foreignClient;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.easyLearing.entity.User;
//@FeignClient(value = "exceptionHandle-new-microservice-8081", path = "/users")
//public interface ForeignClient {
//
//    @GetMapping("/fetchAll")
//    List<User> getAllUsers();
//}