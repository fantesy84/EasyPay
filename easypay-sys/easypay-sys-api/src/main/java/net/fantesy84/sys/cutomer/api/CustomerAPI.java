package net.fantesy84.sys.cutomer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.fantesy84.commons.bean.BaseRequestDTO;
import net.fantesy84.commons.bean.BaseResponseDTO;
import net.fantesy84.commons.bean.Pagination;
import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.biz.CustomerBiz;
import net.fantesy84.sys.customer.domain.EpSysCust;
import net.fantesy84.sys.customer.domain.dto.ResCustomerDTO;

@RestController
@RequestMapping("/customer")
public class CustomerAPI {
	@Autowired
	private CustomerBiz customerBiz;
	
	@RequestMapping(value="/add",method={RequestMethod.POST},produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public BaseResponseDTO newCustomer(@RequestBody EpSysCust cust){
		ResCustomerDTO dto = new ResCustomerDTO();
		dto.setAction(BaseResponseDTO.Action.SAVE);
		try {
			Integer id = customerBiz.save(cust);
			if (id != null) {
				dto.setStatus(BaseResponseDTO.ResponseStatus.SUCCESS);
				dto.setResponseBody(id);
			}
		} catch (EasypayException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	@RequestMapping(value="/update",method={RequestMethod.POST},produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public BaseResponseDTO updateCustomer(@RequestBody EpSysCust cust){
		ResCustomerDTO dto = new ResCustomerDTO();
		dto.setAction(BaseResponseDTO.Action.MERGE);
		try {
			EpSysCust result = customerBiz.modify(cust);
			if (result != null) {
				dto.setStatus(BaseResponseDTO.ResponseStatus.SUCCESS);
				dto.setResponseBody(result);
			}
		} catch (EasypayException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	@RequestMapping("/get/{id}")
	@ResponseBody
	public BaseResponseDTO getCustomer(@PathVariable("id")Integer id){
		ResCustomerDTO dto = new ResCustomerDTO();
		dto.setAction(BaseResponseDTO.Action.SELECT_PK);
		EpSysCust result = null;
		try {
			result = customerBiz.retrieveById(id);
			if (result != null) {
				dto.setStatus(BaseResponseDTO.ResponseStatus.SUCCESS);
				dto.setResponseBody(result);
			}
		} catch (EasypayException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	@RequestMapping("/find/{name}")
	@ResponseBody
	public BaseResponseDTO getCustomerList(@PathVariable("name")String name){
		ResCustomerDTO dto = new ResCustomerDTO();
		dto.setAction(BaseResponseDTO.Action.SELECT);
		EpSysCust cust = new EpSysCust();
		cust.setCustName(name);
		List<EpSysCust> result = null;
		try {
			result = customerBiz.retrieveByName(cust);
			if (result != null) {
				dto.setStatus(BaseResponseDTO.ResponseStatus.SUCCESS);
				dto.setResponseBody(result);
			}
		} catch (EasypayException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	@RequestMapping(value="/pagination",method={RequestMethod.POST},produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public BaseResponseDTO pageCustomer(@RequestBody BaseRequestDTO<EpSysCust> req){
		ResCustomerDTO dto = new ResCustomerDTO();
		dto.setAction(BaseResponseDTO.Action.SELECT_PAGINATION);
		EpSysCust cust = req.getParamBean();
		Pagination<EpSysCust> result = null;
		try {
			result = customerBiz.paginationCust(cust, req.calculateQueryFirstRowNum(), req.getSize());
			if (result != null) {
				dto.setStatus(BaseResponseDTO.ResponseStatus.SUCCESS);
				dto.setResponseBody(result);
			}
		} catch (EasypayException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
