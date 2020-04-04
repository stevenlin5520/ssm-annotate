package com.steven.ssm.service.impl;

import com.steven.ssm.dao.UserMapper;
import com.steven.ssm.entity.User;
import com.steven.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	public int updateUserName(String id,String name) throws InterruptedException {
		System.out.println("测试事务id:"+id+",name:"+name);
		int res = userMapper.updateUsername(id,name);
		Thread.sleep(3000);
		System.out.println("更新结果："+res);
		System.out.println("异常发生");
		int a = 10/0;
		return 1;
	}
}
