package net.fantesy84.test.sys.customer.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.domain.EpSysCust;
import net.fantesy84.sys.hibernate5.support.HibernateReadDaoSupport;
import net.fantesy84.test.BaseTestCase;
import net.fantesy84.test.EpSysCustLazyPropertiesFilterMixIn;
import net.fantesy84.util.jackson.JsonUtils;

public class CustomerDAOTest extends BaseTestCase {
	@Autowired
	private HibernateReadDaoSupport hibernateReadDaoSupport;
	
	@Test
	public void test1() throws Throwable{
		EpSysCust cust = new EpSysCust();
		cust.setCustName("admin");
		DetachedCriteria dc = DetachedCriteria.forClass(EpSysCust.class, "cust");
		dc.add(Restrictions.like("cust.custName", cust.getCustName(), MatchMode.ANYWHERE));
		List<EpSysCust> list = hibernateReadDaoSupport.selectByDetachedCriteria(dc, EpSysCust.class);
		String json = JsonUtils.getInstance().toJsonExcludeProperty(list, EpSysCustLazyPropertiesFilterMixIn.class, "epSysUsers");
		System.out.println(json);
	}
	
	@Test
	public void test2() throws EasypayException{
		EpSysCust cust = new EpSysCust();
		cust.setCustName("admin1");
		List<EpSysCust> list = hibernateReadDaoSupport.selectByExample(cust);
		System.out.println(list.size());
	}
}
