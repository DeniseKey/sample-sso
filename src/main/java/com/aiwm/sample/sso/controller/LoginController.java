package com.aiwm.sample.sso.controller;


import com.aiwm.sample.sso.common.*;
import com.aiwm.sample.sso.data.model.NfCustomerAccount;
import com.aiwm.sample.sso.utils.HttpClientUtils;
import com.aiwm.sample.sso.data.service.AccountService;
import com.aiwm.sample.sso.utils.JedisUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by fengmc on 2019/3/26
 */
@Controller
@Log4j2
public class LoginController {

    @Resource
    private AccountService accountService;

    /**
     * 登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request) {
        String redirectUrl = request.getParameter(Conf.REDIRECT_URL);
        request.getSession().setAttribute("redirectUrl", redirectUrl);
        return "welcome";
    }

    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping(value = "/toRegist", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    /**
     * 用户注册
     *
     * @param nfCustomerAccount
     * @return
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(NfCustomerAccount nfCustomerAccount) {
        LogMessage logMessage = new LogMessage(this.getClass().getSimpleName(), "regist").success();
        logMessage.append("nfCustomerAccount", nfCustomerAccount);
        Result regist = accountService.regist(nfCustomerAccount);
        logMessage.append("regist", regist);
        if (regist.getCode().equals(BaseCodeRes.SUCCESS.getCode())) {
            log.info(logMessage);
            return "redirect:/";
        } else {
            log.info(logMessage);
            return "errorPage";
        }

    }

    /**
     * 登陆
     *
     * @param loginname
     * @param loginpwd
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Param("loginname") String loginname, @Param("loginpwd") String loginpwd, HttpServletRequest request,HttpServletResponse response) {
        LogMessage logMessage = new LogMessage(this.getClass().getSimpleName(), "login").success();
        logMessage.append("loginname", loginname).append("loginpwd", loginpwd);

        try {
            //获取sessionID
            String sessionIdByCookie = LoginHelper.getSessionIdByCookie(request);
            if(StringUtils.isBlank(sessionIdByCookie)){
                //创建cookie
                String sessionId = UUID.randomUUID().toString();
                LoginHelper.setSessionIdInCookie(response,sessionId);
                //创建校验token
                String token = UUID.randomUUID().toString();
                //以cookie的value为key，保存到redis中
                JedisUtils.setEx(sessionId,token,Conf.REDISSECOND);

                //跳转到首次访问的项目页面
                String redirectUrl1 = (String) request.getSession().getAttribute("redirectUrl");
                return "redirect:" + redirectUrl1;
            }else {




                //根据sessionID库里查询是否存在
                NfCustomerAccount ssoLoginStore = getSsoLoginStore(sessionIdByCookie);
                if (ssoLoginStore != null) {
                    //存在时跳转失败页面，说明已经登陆过了。无需再访问sso进行登陆
                    return "errorPage";
                } else {
                    //进行登陆
                    Result result = accountService.login(loginname, loginpwd);

                    logMessage.append("login success{}", result);
                    if (result.getCode().equals(BaseCodeRes.SUCCESS.getCode())) {
                        //不存在更新库中的sessionID
                        Result result1 = accountService.updateToken(loginname, sessionIdByCookie);
                        if (result1.getCode().equals(BaseCodeRes.SUCCESS.getCode())) {
                            log.info("更新库中的sessionID成功！");
                        } else {
                            log.info("更新库中的sessionID失败！");
                        }
                    } else {
                        return "errorPage";
                    }

                }
            }

        } catch (Exception e) {
            log.error("login{}" + e);
        }

        //跳转到首次访问的项目页面
        String redirectUrl1 = (String) request.getSession().getAttribute("redirectUrl");
        logMessage.append("跳转到进行sso登陆的项目首页地址：",redirectUrl1);
       // String sessionIdByCookie = LoginHelper.getSessionIdByCookie(request);
       // String redirectUrlFinal = redirectUrl1 + "?" + Conf.SSO_SESSIONID + "=" + sessionIdByCookie;
        log.info(logMessage);
        return "redirect:" + redirectUrl1;

    }

    /**
     * 校验用户是否存在
     *
     * @param accountname
     * @param response
     */
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    @ResponseBody
    public void checkUser(@Param("accountname") String accountname, HttpServletResponse response) {

        try {
            Result result = accountService.checkAccount(accountname);
            if (result.getCode().equals(BaseCodeRes.SUCCESS.getCode())) {
                response.getWriter().print(true);
            } else if (result.getCode().equals(BaseCodeRes.CHECK_USER.getCode())) {
                response.getWriter().print(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * login check
     *
     * @param sessionId
     * @return
     */
    public NfCustomerAccount getSsoLoginStore(String sessionId) {

        if (sessionId != null && sessionId.trim().length() > 0) {
            Result result = accountService.checkToken(sessionId);
            Integer code = result.getCode();
            if (code.equals(BaseCodeRes.SUCCESS.getCode())) {
                NfCustomerAccount nfCustomerAccount = (NfCustomerAccount) result.getData();
                if (nfCustomerAccount != null) {

                    return nfCustomerAccount;
                }
            }
        }

        return null;
    }

    @PostMapping("/postWithParam")
    public String postWithParam(@RequestParam String code, @RequestParam String message) {
        return "post带参请求成功,参数code: " + code + ",参数message: " + message;
    }

    @Test
    public void testPostWithParam() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("code", "0");
        params.put("message", "helloworld");
        String post = HttpClientUtils.doPost("http://localhost:8082/sso-service/postWithParam", params);
        System.out.println(post);
    }


}
