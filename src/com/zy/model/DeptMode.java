package com.zy.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zy.entity.Detps;
import com.zy.entity.User;
import com.zy.mapper.IUserMapper;
import com.zy.mybatis.MybatisSqlSessionFactory;

public class DeptMode {
	SqlSession session = null;
	IUserMapper um = null;
	public DeptMode() {
		if(this.session==null) {
			session= MybatisSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
			um = session.getMapper(IUserMapper.class);
		}
	}
	public List<User> SelectUserAll(){
		return um.SelectUserAndDepts(null);
	}
	public List<User> SelectUsersByObject(User user){
		return um.SelectUsersByObject(user);
	}
	public int CountUsers(User user) {
		return um.getUserCount(user);
	}
	public User SelectUserByid(int id) {
		return um.getUserByid(id);
	}
    public List<Detps> GetDeptList(){
    	return um.SearchDeptsList();
    }
    public void Updatesub(User user) {
    	try {
        	um.UpdateSubtable(user);
        	session.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}

    }
    public void InsertUser1(User user) {
    	try {
        	um.InsertUser(user);
        	session.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
    }
	public static void main(String[] args) {
//		List<User> l = new DeptMode().SelectUserByid(0);
//		for (User use : l) {
//			System.out.println(use.getUid()+"---"+use.getUname()+"---"+use.getDepts().getDname());
//		}
//		
		System.out.println(new DeptMode().GetDeptList());
	}

}
