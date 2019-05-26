package com.zy.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis,工厂模式链接池，2
 * @author admin
 * mybatis操作流程：
 * 1.创建工厂模式的连接池 MybatisSqlsessionFactory
 * 2.创建和谐的整合的配置文件 sqlmap-config
 * 3.创建接口，实现类
 * 4.实体类对象Users
 * 5.根据实体类对象的单个实体类对象的配置文件UserSql.xml
 * Mybatis:
 * 手工搭建特别是配置文件，充分利用xml可扩展性标记语言的性质。
 * sql语句机制，一些复杂、叠加、复合sql语句，在hibernate中非常受到局限，mybatis中这些复杂的sql语句得到充分的应用。
 * mybatis相比ibatIS添加了hibernate的优势工厂模式的连接池，和数据库连接更加高效，充分的利用二级缓存机制。
 * 把全部的sql语句放入xml配置文件中操作，sql语句不参与编译。发布给用户之后也可以根据用户实际的服务器环境的不同灵活的更改查询语句。
 * 只有ibatIS和mybatis是sql语句放入xml配置文件中运行的。 
 * jar文件相比hibernate少很多，减轻了应用服务器的负荷。
 */
public class MybatisSqlSessionFactory {
    //sql session factory 静态变量
	private static SqlSessionFactory sqlSessionFactory=null;
	//创建一个本类的类对象
	private static MybatisSqlSessionFactory mybatisSqlSessionFactory=null;
	//创建空构造函数，实例化加载配置文件sqlmap-config
	private MybatisSqlSessionFactory(){
		//创建链接mybatis的核心配置文件字符串
		String rs="com/zy/mybatis/sqlmap-config.xml";
		Reader reader=null;
		try {
			//创建ibatis io读取配置文件的类对象加载核心的配置文件
			reader=Resources.getResourceAsReader(rs);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//工厂链接对象加载读取的配置文件
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//工厂链接配置文件加载读取操作数据库的实现类的接口
//		sqlSessionFactory.getConfiguration().addMapper(IUsersDao.class);
	}
	//获取该工厂连接池的链接对象
	public static MybatisSqlSessionFactory getInstance(){
		if(mybatisSqlSessionFactory==null){
			mybatisSqlSessionFactory=new MybatisSqlSessionFactory();
		}
		return mybatisSqlSessionFactory;
	}
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
}
