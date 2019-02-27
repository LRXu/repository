package com.ssh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh.domain.User;

public class UserDao extends HibernateDaoSupport {

	/**
	 * 获取一个用户
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(final int id) {
		
		User user = getHibernateTemplate().execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session) throws HibernateException {

				/** Criteria无语句查询 */
				Criteria criteria = session.createCriteria(User.class);
				criteria.add(Restrictions.eqOrIsNull("id", id));
				User user = (User) criteria.uniqueResult();

				/** hql语句查询 */
				String hql = "from com.ssh.domain.User where id=?";
				Query query = session.createQuery(hql);
				Query result = query.setParameter(0, id);
				User user1 = (User) result.uniqueResult();

				return user1;
			}
		});
		return user;
	}

	/**
	 * 获取list对象 可以返回一个对象
	 */
	public User getUser2() {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		getHibernateTemplate().save(user);
	}

	/**
	 * 修改用户
	 */
	public void updateUser(Integer id, User user) {

	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void delete(Integer id) {

	}

}
