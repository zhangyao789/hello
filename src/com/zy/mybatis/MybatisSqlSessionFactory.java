package com.zy.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis,����ģʽ���ӳأ�2
 * @author admin
 * mybatis�������̣�
 * 1.��������ģʽ�����ӳ� MybatisSqlsessionFactory
 * 2.������г�����ϵ������ļ� sqlmap-config
 * 3.�����ӿڣ�ʵ����
 * 4.ʵ�������Users
 * 5.����ʵ�������ĵ���ʵ�������������ļ�UserSql.xml
 * Mybatis:
 * �ֹ���ر��������ļ����������xml����չ�Ա�����Ե����ʡ�
 * sql�����ƣ�һЩ���ӡ����ӡ�����sql��䣬��hibernate�зǳ��ܵ����ޣ�mybatis����Щ���ӵ�sql���õ���ֵ�Ӧ�á�
 * mybatis���ibatIS�����hibernate�����ƹ���ģʽ�����ӳأ������ݿ����Ӹ��Ӹ�Ч����ֵ����ö���������ơ�
 * ��ȫ����sql������xml�����ļ��в�����sql��䲻������롣�������û�֮��Ҳ���Ը����û�ʵ�ʵķ����������Ĳ�ͬ���ĸ��Ĳ�ѯ��䡣
 * ֻ��ibatIS��mybatis��sql������xml�����ļ������еġ� 
 * jar�ļ����hibernate�ٺܶ࣬������Ӧ�÷������ĸ��ɡ�
 */
public class MybatisSqlSessionFactory {
    //sql session factory ��̬����
	private static SqlSessionFactory sqlSessionFactory=null;
	//����һ������������
	private static MybatisSqlSessionFactory mybatisSqlSessionFactory=null;
	//�����չ��캯����ʵ�������������ļ�sqlmap-config
	private MybatisSqlSessionFactory(){
		//��������mybatis�ĺ��������ļ��ַ���
		String rs="com/zy/mybatis/sqlmap-config.xml";
		Reader reader=null;
		try {
			//����ibatis io��ȡ�����ļ����������غ��ĵ������ļ�
			reader=Resources.getResourceAsReader(rs);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������Ӷ�����ض�ȡ�������ļ�
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//�������������ļ����ض�ȡ�������ݿ��ʵ����Ľӿ�
//		sqlSessionFactory.getConfiguration().addMapper(IUsersDao.class);
	}
	//��ȡ�ù������ӳص����Ӷ���
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
