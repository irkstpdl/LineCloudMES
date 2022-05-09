package com.lc.mes.basic.logging.aspects;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lc.mes.basic.BasicException;
import com.lc.mes.basic.ErrorResponse;
import com.lc.mes.basic.constants.BasicConstants;
import com.lc.plugin.api.RunIfEnabled;


public class ExceptionHandlingAspect {
}
