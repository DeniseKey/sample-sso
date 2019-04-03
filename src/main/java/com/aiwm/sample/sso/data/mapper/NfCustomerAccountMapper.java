package com.aiwm.sample.sso.data.mapper;


import com.aiwm.sample.sso.data.model.NfCustomerAccount;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface NfCustomerAccountMapper extends Mapper<NfCustomerAccount> {
    /**
     * 用户注册
     * @param nfCustomerAccount
     */
    int regist(NfCustomerAccount nfCustomerAccount);

    /**
     * 用户登陆
     * @param loginname
     * @param loginpwd
     * @return
     */
    NfCustomerAccount login(@Param("loginname") String loginname, @Param("loginpwd") String loginpwd);

    /**
     * 查询用户是否存在
     * @param accountname
     * @return
     */
    NfCustomerAccount checkAccount(@Param("accountname") String accountname);

    /**
     * 更新token
     * @param loginname
     * @param accountToken
     * @return
     */
    int updateToken(@Param("loginname") String loginname, @Param("accountToken") String accountToken);
    /**
     * 查询token
     * @param accountToken
     * @return
     */
    NfCustomerAccount checkToken(@Param("accountToken") String accountToken);
}