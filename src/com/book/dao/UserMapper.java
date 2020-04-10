package com.book.dao;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.User;

public interface UserMapper {
	/**
	 * 根据账户和密码查询账户信息
	 * @param userId
	 * @param userPsw
	 * @return 成功返回账户 失败返回null
	 */
	User findUserByIdAndPsw(
			@Param("userId") String userId,@Param("userPsw") String userPsw);
	/**
	 * 根据账户查找账户信息
	 * @param userId
	 * @return 成功返回账户， 失败返回null
	 */
	User findUserById(@Param("userId") String userId);
	
	/**
	 * 添加新的账户到数据库
	 * @param user
	 * @return
	 */
	int addNewUser(User user);
}
