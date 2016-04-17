package net.fantesy84.test;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.fantesy84.commons.bean.BaseRequestDTO;
import net.fantesy84.sys.customer.domain.EpSysCust;

public class BaseRequestDTOTest {
	
	@Test
	public void test1() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		String reqJson = "{\"size\":2,\"index\":1,\"paramBean\":{\"custName\":\"admin\"}}";
		@SuppressWarnings("unchecked")
		BaseRequestDTO<EpSysCust> dto = mapper.readValue(reqJson, BaseRequestDTO.class);
		System.out.println(dto.getParamBean());
//		BaseRequestDTO<EpSysCust> dto = new BaseRequestDTO<>();
//		String json = mapper.writeValueAsString(dto);
//		System.out.println(json);
	}
}
