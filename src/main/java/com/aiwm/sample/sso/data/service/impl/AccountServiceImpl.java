package com.aiwm.sample.sso.data.service.impl;


import com.aiwm.sample.sso.common.BaseCodeRes;
import com.aiwm.sample.sso.common.LogMessage;
import com.aiwm.sample.sso.common.Result;
import com.aiwm.sample.sso.common.ResultHandler;
import com.aiwm.sample.sso.data.mapper.NfCustomerAccountMapper;
import com.aiwm.sample.sso.data.model.NfCustomerAccount;
import com.aiwm.sample.sso.data.service.AccountService;
import com.aiwm.sample.sso.utils.MD5Utils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by fengmc on 2019/3/26
 */
@Service
@Log4j2
public class AccountServiceImpl implements AccountService {

    @Resource
    private NfCustomerAccountMapper nfCustomerAccountMapper;

    @Override
    public Result regist(NfCustomerAccount nfCustomerAccount) {
        LogMessage logMessage = new LogMessage(this.getClass().getSimpleName(), "regist").success();
        logMessage.append("nfCustomerAccount",nfCustomerAccount);
        Result result = null;
        try {
            result = new Result<>();
            //用户名
            String accountname = nfCustomerAccount.getAccountname();
            //邮箱
            String email = nfCustomerAccount.getEmail();
            //登陆名称
            String loginname = nfCustomerAccount.getLoginname();
            //登陆密码
            String loginpwd = MD5Utils.getStrMD5(nfCustomerAccount.getLoginpwd());
            nfCustomerAccount.setLoginpwd(loginpwd);
            if(StringUtils.isBlank(accountname)||StringUtils.isBlank(email)||StringUtils.isBlank(loginname)||StringUtils.isBlank(loginpwd)){
                result=  ResultHandler.result(null, BaseCodeRes.MISSING_PARAM.getCode(),BaseCodeRes.MISSING_PARAM.getDesc());
                logMessage.append("regist parameter are missing: ",result);
            }
            int regist = nfCustomerAccountMapper.regist(nfCustomerAccount);
            if(regist>0){
                result=ResultHandler.result(null,BaseCodeRes.SUCCESS.getCode(),BaseCodeRes.SUCCESS.getDesc());
                logMessage.append("regist success: ",result);
            }
        } catch (Exception e) {
            log.error("regist exception: ",e);
        }
        log.info(logMessage);
        return result ;
    }

    @Override
    public Result login(String loginname, String loginpwd) {
        LogMessage logMessage = new LogMessage(this.getClass().getSimpleName(), "login").success();
        logMessage.append("loginname",loginname).append("loginpwd",loginpwd);
        Result result = null;
        try {
            result = new Result<>();

            if(StringUtils.isBlank(loginname)||StringUtils.isBlank(loginpwd)){
                result=  ResultHandler.result(null, BaseCodeRes.MISSING_PARAM.getCode(),BaseCodeRes.MISSING_PARAM.getDesc());
                logMessage.append("login parameter are missing: ",result);
            }
             loginpwd = MD5Utils.getStrMD5(loginpwd);
            NfCustomerAccount login = nfCustomerAccountMapper.login(loginname, loginpwd);
            if(login!=null){
                result=ResultHandler.result(login,BaseCodeRes.SUCCESS.getCode(),BaseCodeRes.SUCCESS.getDesc());
                logMessage.append("login success: ",result);
            }
        } catch (Exception e) {
            log.error("login exception: ",e);
        }
        log.info(logMessage);
        return result;
    }

    @Override
    public Result checkAccount(String loginname) {
        LogMessage logMessage = new LogMessage(this.getClass().getSimpleName(), "checkAccount").success();
        logMessage.append("loginname",loginname);
        Result result = null;
        try {
            result = new Result<>();
            if(StringUtils.isBlank(loginname)){
                result=  ResultHandler.result(null, BaseCodeRes.MISSING_PARAM.getCode(),BaseCodeRes.MISSING_PARAM.getDesc());
                logMessage.append("checkAccount parameter are missing: ",result);
            }

            NfCustomerAccount nfCustomerAccount = nfCustomerAccountMapper.checkAccount(loginname);
            if(nfCustomerAccount!=null){
                result=ResultHandler.result(null,BaseCodeRes.CHECK_USER.getCode(),BaseCodeRes.CHECK_USER.getDesc());
                logMessage.append("checkAccount user Aiready exist: ",result);
            }else {
                result=ResultHandler.result(nfCustomerAccount,BaseCodeRes.SUCCESS.getCode(),BaseCodeRes.SUCCESS.getDesc());
                logMessage.append("checkAccount user does not exist{}",result);
            }
        } catch (Exception e) {
            log.error("checkAccount exception: ",e);
        }
        log.info(logMessage);
        return result;
    }

    @Override
    public Result updateToken(String loginname, String accountToken) {
        LogMessage logMessage = new LogMessage(this.getClass().getSimpleName(), "updateToken").success();
        logMessage.append("loginname",loginname).append("accountToken",accountToken);
        Result result = null;
        try {
            result = new Result<>();
            if(StringUtils.isBlank(loginname)||StringUtils.isBlank(accountToken)){
                result=  ResultHandler.result(null, BaseCodeRes.MISSING_PARAM.getCode(),BaseCodeRes.MISSING_PARAM.getDesc());
                logMessage.append("updateToken parameter are missing: ",result);
            }
            int token = nfCustomerAccountMapper.updateToken(loginname, accountToken);
            if(token>0){
                result=ResultHandler.result(null,BaseCodeRes.SUCCESS.getCode(),BaseCodeRes.SUCCESS.getDesc());
                logMessage.append("updateToken success: ",result);
            }
        } catch (Exception e) {
            log.error("updateToken exception: ",e);
        }
        log.info(logMessage);
        return result;
    }

    @Override
    public Result checkToken(String accountToken) {
        LogMessage logMessage = new LogMessage(this.getClass().getSimpleName(), "checkToken").success();
        logMessage.append("accountToken",accountToken);
        Result result = null;
        try {
            result = new Result<>();
            if(StringUtils.isBlank(accountToken)){
                result=  ResultHandler.result(null, BaseCodeRes.MISSING_PARAM.getCode(),BaseCodeRes.MISSING_PARAM.getDesc());
                logMessage.append("checkToken parameter are missing: ",result);
            }
            NfCustomerAccount nfCustomerAccount = nfCustomerAccountMapper.checkToken(accountToken);
            if(nfCustomerAccount!=null){
                result=ResultHandler.result(null,BaseCodeRes.CHECK_USER.getCode(),BaseCodeRes.CHECK_USER.getDesc());
                logMessage.append("checkToken user Aiready exist: ",result);
            }else {
                result=ResultHandler.result(nfCustomerAccount,BaseCodeRes.SUCCESS.getCode(),BaseCodeRes.SUCCESS.getDesc());
                logMessage.append("checkToken success: ",result);
            }
        } catch (Exception e) {
            log.error("checkToken exception: ",e);
        }
        log.info(logMessage);
        return result;
    }
}
