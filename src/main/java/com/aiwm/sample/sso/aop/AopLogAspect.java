package com.aiwm.sample.sso.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by fengmc on 2019/3/25
 */
@Component
@Aspect
@Log4j2
public class AopLogAspect {

    @Pointcut("execution(* com.aiwm.sample.sso.data.service..*.*(..))")
    public void aspect() {
    }

    @Before("aspect()")
    public void before(JoinPoint joinPoint) throws Throwable {
    }

    @Around("aspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object[] reqObjects = joinPoint.getArgs();
        Object resObject = null;
        long endTime = 0;
        try {
            resObject = joinPoint.proceed();
            endTime = System.currentTimeMillis();
        } catch (Throwable e) {
            endTime = System.currentTimeMillis();
            log.error("sub-portal 报错了" + "请求参数为:" + JSON.toJSONString(reqObjects, SerializerFeature.DisableCircularReferenceDetect) + "方法名为:" + joinPoint.getSignature().toString(), e);
            throw e;
        } finally {
            try {
                AopLog aopLog = new AopLog();
                aopLog.setApplication("sso-service");
                aopLog.setMethod(joinPoint.getSignature().toString());
                aopLog.setRequest(JSON.toJSONString(reqObjects, new JsonFilter(),SerializerFeature.DisableCircularReferenceDetect));
                aopLog.setResponse(JSON.toJSONString(resObject, new JsonFilter(), SerializerFeature.DisableCircularReferenceDetect));

                aopLog.setTime_wait((endTime - startTime) + "ms");
                log.info(aopLog);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resObject;
    }

    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint) {
    }
}
