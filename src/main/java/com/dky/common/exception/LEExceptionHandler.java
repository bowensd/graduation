package com.dky.common.exception;

import com.dky.common.Code;
import com.dky.common.model.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
*describe: 异常处理器
*
*@author unbesito
*@date 2018/5/4
*/
@RestControllerAdvice
public class LEExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	public R handleException(Exception e){
		logger.error(e.getMessage(), e);
		return R.error(Code.code_error,e.getMessage());
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public R handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return R.error(Code.code_db_error,"数据库中已存在该记录");
	}

//	@ExceptionHandler(AuthorizationException.class)
//	public R handleAuthorizationException(AuthorizationException e){
//		logger.error(e.getMessage(), e);
//		return R.error("没有权限，请联系管理员授权");
//	}
}
