/**
 * Project: easypay-sys-dao
 * Created: 2016年5月10日
 * Copyright ©2014-2016 葛俊杰
 */
package net.fantesy84.sys.user.dao;

import java.util.List;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.user.domain.UserDTO;

/**
 * @author 葛俊杰
 *
 */
public interface UserDAO {
	public List<UserDTO> findByUsernameAndPasswd(String username, String passwd) throws EasypayException;
}
