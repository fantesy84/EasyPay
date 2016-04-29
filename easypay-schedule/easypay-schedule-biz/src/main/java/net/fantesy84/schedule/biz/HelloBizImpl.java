/**
 * Project easypay-schedule-biz
 * CreateTime: 2016年4月28日
 * Creator: junjie.ge
 * Copyright ©2016 葛俊杰
 */
package net.fantesy84.schedule.biz;

import org.springframework.stereotype.Service;

/**
 * TypeName: HelloJobImpl
 * 
 * <P>CreateTime: 2016年4月28日
 * <P>UpdateTime: 
 * @author junjie.ge
 *
 */
@Service
public class HelloBizImpl implements HelloBiz {

	/* (non-Javadoc)
	 * @see net.fantesy84.schedule.hello.HelloJob#sayHello(java.lang.String)
	 */
	@Override
	public void sayHello(String name) throws Exception {
		System.out.println("Hello! " + name);
	}

}
