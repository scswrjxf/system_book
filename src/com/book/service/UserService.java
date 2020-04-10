package com.book.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession; 
import com.book.dao.UserMapper; 
import com.book.pojo.User;
import com.book.tools.MyBatisUtil;

public class UserService {
	/**
	 * 根据账户和密码查询用户
	 * @param userId
	 * @param userPsw
	 * @return 成功返回用户对象，失败返回null
	 */
	public User findUserByIdAndPsw(String userId,String userPsw) {
		// 去除两端空格
		userId = userId.trim();
		userPsw = userPsw.trim();
		// 加密账户和密码
		userId =  DigestUtils.md5Hex(userId);
		userPsw = DigestUtils.md5Hex(userPsw);
		// 调用数据查询
		SqlSession sqlSession = MyBatisUtil.open();
		User result = sqlSession.getMapper(UserMapper.class)
				.findUserByIdAndPsw(userId, userPsw);
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	} 
	/**
	 * 将新的账户添加到数据库
	 * @param user
	 * @return
	 */
	public int addNewUser(User user) {
		// 保存返回结果
		int result = 0;  
		SqlSession sqlSession = MyBatisUtil.open(); 
		// 查询此账户是否存在
		User res = sqlSession.getMapper(UserMapper.class).
				findUserById(user.getUserId()); 
		// 不存在此账户
		if(res == null) {
		// 添加账户到数据库
		result = sqlSession.getMapper(UserMapper.class).
				addNewUser(user); 
		}
		//提交事务（增删改）,在关闭之前
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
		
	}
}
