package com.steven.ssm.service;

import com.steven.ssm.entity.User;
import java.util.List;

public interface UserService {
	List<User> selectAll();
	int updateUserName(String id,String name) throws InterruptedException;
}
