package net.fantesy84.test;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import net.fantesy84.sys.customer.domain.EpSysUser;
import net.fantesy84.util.jackson.FilterMixIn;

@JsonFilter("epSysUser")
public interface EpSysCustLazyPropertiesFilterMixIn extends FilterMixIn {
	@JsonIgnore Set<EpSysUser> getEpSysUsers();
}
