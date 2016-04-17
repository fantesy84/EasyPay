package net.fantesy84.sys.customer.dao;

import java.util.List;

import net.fantesy84.commons.bean.Pagination;
import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.domain.EpSysCust;

public interface CustomerDAO {
	Integer insert(EpSysCust cust) throws EasypayException;
	EpSysCust merge(EpSysCust cust) throws EasypayException;
	EpSysCust getById(Integer id) throws EasypayException;
	List<EpSysCust> selectByName(EpSysCust cust) throws EasypayException;
	Pagination<EpSysCust> pageByName(EpSysCust cust, int firstResult, int maxResults) throws EasypayException;
}
