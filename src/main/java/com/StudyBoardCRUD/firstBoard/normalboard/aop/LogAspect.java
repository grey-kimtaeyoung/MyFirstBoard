package com.StudyBoardCRUD.firstBoard.normalboard.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
  Logger logger =  LoggerFactory.getLogger(LogAspect.class);

  //BoardServiceImpl의 모든 메서드
  @Around("execution(* com.StudyBoardCRUD.firstBoard.normalboard.service.BoardServiceImpl*(..))")
  /*@Around("execution(* com.StudyBoardCRUD.firstBoard.normalboard.*.*(..))")*/
  /*@Around("execution(* com.StudyBoardCRUD.firstBoard.normalboard..*.*(..))")*/
  public Object logging(ProceedingJoinPoint pjp) throws Throwable {
    logger.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
    Object result = pjp.proceed();
    logger.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
    return result;
  }
}
