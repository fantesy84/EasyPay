/**
 * Project: easypay-schedule-biz
 * Created: 2016年5月3日
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.generic.biz;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Description:
 * <P>
 * 
 * @author 葛俊杰
 *
 */
public class QuartzDynamicTriggerFactoryBean implements FactoryBean<DynamicTrigger>, BeanNameAware, InitializingBean {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.
	 * String)
	 */
	@Override
	public void setBeanName(String name) {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public DynamicTrigger getObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
