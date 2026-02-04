package com.easyLearing.ForeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.easyLearing.entity.User;

@FeignClient(value="exceptionHandle-old-microservice-2020",path="/users")
//@FeignClient(url="${address.service.url}",path="/users")
public interface AddressFeignClient1 {
	@GetMapping("/fetchAll")
	List<User> getAllUsers();
}
