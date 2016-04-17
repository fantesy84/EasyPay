package net.fantesy84.sys.customer.domain.dto;

import net.fantesy84.sys.customer.domain.EpSysCust;

public class ReqCustomerDTO {
	private EpSysCust customer;
	public EpSysCust getCustomer() {
		return customer;
	}
	public void setCustomer(EpSysCust customer) {
		this.customer = customer;
	}
	
}
