package com.zy.mapper;

import java.util.List;

import com.zy.entity.Detps;
import com.zy.entity.User;

public interface IUserMapper {
	
	
	
	public List<User> SelectUserAndDepts(User user);
	public List<User> SelectUsersByObject(User user);
	public int getUserCount(User user);
	public User getUserByid(int id);
	public List<Detps> SearchDeptsList();
	public void UpdateSubtable(User user);
	public void InsertUser(User user);
	public void UpdateTea(User user);
	public int MuchDelUsers(int[] ids);
	public List<Detps> SelectDeptsNumbersAndUsers();
	public User Veruser(String password);
	
	
}
