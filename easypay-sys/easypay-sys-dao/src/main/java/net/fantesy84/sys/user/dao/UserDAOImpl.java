/**
 * Project: easypay-sys-dao
 * Created: 2016年5月10日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.user.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.user.domain.UserDTO;

/**
 * @author 葛俊杰
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private @Qualifier("write01_HibernateTemplate")HibernateTemplate template;
	/* (non-Javadoc)
	 * @see net.fantesy84.sys.user.dao.UserDAO#findByUsernameAndPasswd(java.lang.String, java.lang.String)
	 */
	@Override
	public List<UserDTO> findByUsernameAndPasswd(final String username, final String passwd) throws EasypayException {
		final String sql = "SELECT u.AUTO_ID as id,u.USERNAME as account,u.PASSWD as password,u.CREATE_TIME as created FROM EP_SYS_USER u WHERE u.USERNAME = :username AND u.PASSWD = :passwd";
		List<UserDTO> list = template.execute(new HibernateCallback<List<UserDTO>>(){
			
			@SuppressWarnings("unchecked")
			@Override
			public List<UserDTO> doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				query.setParameter("username", username).setParameter("passwd", passwd);
				query.setResultTransformer(Transformers.aliasToBean(UserDTO.class));
				return query.list();
			}
			
		});
		return list;
	}
	
}
