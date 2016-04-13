package net.fantesy84.sys.customer.dao;

import java.util.List;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.domain.EpSysCust;

public interface CustomerDAO {
	int insert(EpSysCust cust) throws EasypayException;
	List<EpSysCust> selectByName(EpSysCust cust) throws EasypayException;
}
