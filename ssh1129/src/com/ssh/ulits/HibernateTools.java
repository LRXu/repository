package com.ssh.ulits;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTools {

	Session session = null;
	private SessionFactory sFactory;

	/**
	 * hibernate工具类 获取session
	 * 
	 * @author LRX
	 */
	public Session getSession() {

		/* 创建session对象 */
		session = sFactory.openSession();
		return session;
	}

	/* 释放资源 */
	public void getClose() {
		session.close();
		sFactory.close();
	}

	public SessionFactory getsFactory() {
		return sFactory;
	}

	public void setsFactory(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}

}
