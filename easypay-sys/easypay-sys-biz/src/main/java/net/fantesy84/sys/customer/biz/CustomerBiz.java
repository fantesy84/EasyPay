package net.fantesy84.sys.customer.biz;

import java.util.List;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.domain.EpSysCust;

public interface CustomerBiz {
	List<EpSysCust> retrieveByName(EpSysCust cust) throws EasypayException;
}
