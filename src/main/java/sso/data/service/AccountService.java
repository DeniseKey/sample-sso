package sso.data.service;

import com.aiwm.sample.sso.common.Result;
import com.aiwm.sample.sso.data.model.NfCustomerAccount;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fengmc on 2019/3/26
 */
public interface AccountService {
    /**
     * 用户注册
     * @param nfCustomerAccount
     */
    Result regist(NfCustomerAccount nfCustomerAccount);

    /**
     * 用户登陆
     * @param loginname
     * @param loginpwd
     * @return
     */
    Result login(@Param("loginname") String loginname, @Param("loginpwd") String loginpwd);
    /**
     * 查询用户是否存在
     * @param loginname
     * @return
     */
    Result checkAccount(@Param("loginname") String loginname);

    /**
     * 更新token
     * @param loginname
     * @param accountToken
     * @return
     */
    Result updateToken(@Param("loginname") String loginname, @Param("accountToken") String accountToken);
    /**
     * 查询token
     * @param accountToken
     * @return
     */
    Result checkToken(@Param("accountToken") String accountToken);
}
