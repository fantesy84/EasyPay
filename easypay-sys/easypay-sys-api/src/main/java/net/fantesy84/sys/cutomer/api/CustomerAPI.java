package net.fantesy84.sys.cutomer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.biz.CustomerBiz;
import net.fantesy84.sys.customer.domain.EpSysCust;

@RestController
@RequestMapping("/customer")
public class CustomerAPI {
	@Autowired
	private CustomerBiz customerBiz;
	
	@RequestMapping("/find/{name}")
	@ResponseBody
	public List<EpSysCust> getCustomerList(@PathVariable("name")String name){
		EpSysCust cust = new EpSysCust();
		cust.setCustName(name);
		List<EpSysCust> result = null;
		try {
			result = customerBiz.retrieveByName(cust);
		} catch (EasypayException e) {
			e.printStackTrace();
		}
		return result;
	}
}
