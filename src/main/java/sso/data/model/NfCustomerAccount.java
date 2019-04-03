package sso.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "nf_customer_account")
public class NfCustomerAccount implements Serializable {
    /**
     * 主键
     */
    @Id
    private Integer caid;

    /**
     * 客户id
     */
    private Integer cbiid;

    /**
     * 登陆名称
     */
    private String loginname;

    private String loginalias;

    @Column(name = "interface_password")
    private String interfacePassword;

    /**
     * 登陆密码
     */
    private String loginpwd;

    /**
     * 用户名
     */
    private String accountname;

    /**
     * 用户类型
     */
    @Column(name = "clv_type")
    private String clvType;

    private String email;

    private String tel;

    /**
     * 是否锁定
     */
    private Integer locked;

    /**
     * 锁定开始时间
     */
    @Column(name = "locked_start_time")
    private String lockedStartTime;

    /**
     * 锁定时长
     */
    @Column(name = "locked_time")
    private Integer lockedTime;

    private String desc;

    /**
     * 是否限制ip
     */
    @Column(name = "restrict_ip")
    private String restrictIp;

    @Column(name = "check_phone")
    private String checkPhone;
    /**
     * 先用于存token
     */
    @Column(name = "customer_from")
    private String customerFrom;

    @Column(name = "domain_code")
    private String domainCode;

    @Column(name = "domain_name")
    private String domainName;

    @Column(name = "demand_desc")
    private String demandDesc;

    @Column(name = "allo_status")
    private Integer alloStatus;

    @Column(name = "cmgr_id")
    private Integer cmgrId;

    private String oppwd;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return caid - 主键
     */
    public Integer getCaid() {
        return caid;
    }

    /**
     * 设置主键
     *
     * @param caid 主键
     */
    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    /**
     * 获取客户id
     *
     * @return cbiid - 客户id
     */
    public Integer getCbiid() {
        return cbiid;
    }

    /**
     * 设置客户id
     *
     * @param cbiid 客户id
     */
    public void setCbiid(Integer cbiid) {
        this.cbiid = cbiid;
    }

    /**
     * 获取登陆名称
     *
     * @return loginname - 登陆名称
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * 设置登陆名称
     *
     * @param loginname 登陆名称
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    /**
     * @return loginalias
     */
    public String getLoginalias() {
        return loginalias;
    }

    /**
     * @param loginalias
     */
    public void setLoginalias(String loginalias) {
        this.loginalias = loginalias;
    }

    /**
     * @return interface_password
     */
    public String getInterfacePassword() {
        return interfacePassword;
    }

    /**
     * @param interfacePassword
     */
    public void setInterfacePassword(String interfacePassword) {
        this.interfacePassword = interfacePassword;
    }

    /**
     * 获取登陆密码
     *
     * @return loginpwd - 登陆密码
     */
    public String getLoginpwd() {
        return loginpwd;
    }

    /**
     * 设置登陆密码
     *
     * @param loginpwd 登陆密码
     */
    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    /**
     * 获取用户名
     *
     * @return accountname - 用户名
     */
    public String getAccountname() {
        return accountname;
    }

    /**
     * 设置用户名
     *
     * @param accountname 用户名
     */
    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    /**
     * 获取用户类型
     *
     * @return clv_type - 用户类型
     */
    public String getClvType() {
        return clvType;
    }

    /**
     * 设置用户类型
     *
     * @param clvType 用户类型
     */
    public void setClvType(String clvType) {
        this.clvType = clvType;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取是否锁定
     *
     * @return locked - 是否锁定
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * 设置是否锁定
     *
     * @param locked 是否锁定
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * 获取锁定开始时间
     *
     * @return locked_start_time - 锁定开始时间
     */
    public String getLockedStartTime() {
        return lockedStartTime;
    }

    /**
     * 设置锁定开始时间
     *
     * @param lockedStartTime 锁定开始时间
     */
    public void setLockedStartTime(String lockedStartTime) {
        this.lockedStartTime = lockedStartTime;
    }

    /**
     * 获取锁定时长
     *
     * @return locked_time - 锁定时长
     */
    public Integer getLockedTime() {
        return lockedTime;
    }

    /**
     * 设置锁定时长
     *
     * @param lockedTime 锁定时长
     */
    public void setLockedTime(Integer lockedTime) {
        this.lockedTime = lockedTime;
    }

    /**
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取是否限制ip
     *
     * @return restrict_ip - 是否限制ip
     */
    public String getRestrictIp() {
        return restrictIp;
    }

    /**
     * 设置是否限制ip
     *
     * @param restrictIp 是否限制ip
     */
    public void setRestrictIp(String restrictIp) {
        this.restrictIp = restrictIp;
    }

    /**
     * @return check_phone
     */
    public String getCheckPhone() {
        return checkPhone;
    }

    /**
     * @param checkPhone
     */
    public void setCheckPhone(String checkPhone) {
        this.checkPhone = checkPhone;
    }

    /**
     * @return customer_from
     */
    public String getCustomerFrom() {
        return customerFrom;
    }

    /**
     * @param customerFrom
     */
    public void setCustomerFrom(String customerFrom) {
        this.customerFrom = customerFrom;
    }

    /**
     * @return domain_code
     */
    public String getDomainCode() {
        return domainCode;
    }

    /**
     * @param domainCode
     */
    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    /**
     * @return domain_name
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * @param domainName
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * @return demand_desc
     */
    public String getDemandDesc() {
        return demandDesc;
    }

    /**
     * @param demandDesc
     */
    public void setDemandDesc(String demandDesc) {
        this.demandDesc = demandDesc;
    }

    /**
     * @return allo_status
     */
    public Integer getAlloStatus() {
        return alloStatus;
    }

    /**
     * @param alloStatus
     */
    public void setAlloStatus(Integer alloStatus) {
        this.alloStatus = alloStatus;
    }

    /**
     * @return cmgr_id
     */
    public Integer getCmgrId() {
        return cmgrId;
    }

    /**
     * @param cmgrId
     */
    public void setCmgrId(Integer cmgrId) {
        this.cmgrId = cmgrId;
    }

    /**
     * @return oppwd
     */
    public String getOppwd() {
        return oppwd;
    }

    /**
     * @param oppwd
     */
    public void setOppwd(String oppwd) {
        this.oppwd = oppwd;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        NfCustomerAccount other = (NfCustomerAccount) that;
        return (this.getCaid() == null ? other.getCaid() == null : this.getCaid().equals(other.getCaid()))
            && (this.getCbiid() == null ? other.getCbiid() == null : this.getCbiid().equals(other.getCbiid()))
            && (this.getLoginname() == null ? other.getLoginname() == null : this.getLoginname().equals(other.getLoginname()))
            && (this.getLoginalias() == null ? other.getLoginalias() == null : this.getLoginalias().equals(other.getLoginalias()))
            && (this.getInterfacePassword() == null ? other.getInterfacePassword() == null : this.getInterfacePassword().equals(other.getInterfacePassword()))
            && (this.getLoginpwd() == null ? other.getLoginpwd() == null : this.getLoginpwd().equals(other.getLoginpwd()))
            && (this.getAccountname() == null ? other.getAccountname() == null : this.getAccountname().equals(other.getAccountname()))
            && (this.getClvType() == null ? other.getClvType() == null : this.getClvType().equals(other.getClvType()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getLocked() == null ? other.getLocked() == null : this.getLocked().equals(other.getLocked()))
            && (this.getLockedStartTime() == null ? other.getLockedStartTime() == null : this.getLockedStartTime().equals(other.getLockedStartTime()))
            && (this.getLockedTime() == null ? other.getLockedTime() == null : this.getLockedTime().equals(other.getLockedTime()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
            && (this.getRestrictIp() == null ? other.getRestrictIp() == null : this.getRestrictIp().equals(other.getRestrictIp()))
            && (this.getCheckPhone() == null ? other.getCheckPhone() == null : this.getCheckPhone().equals(other.getCheckPhone()))
            && (this.getCustomerFrom() == null ? other.getCustomerFrom() == null : this.getCustomerFrom().equals(other.getCustomerFrom()))
            && (this.getDomainCode() == null ? other.getDomainCode() == null : this.getDomainCode().equals(other.getDomainCode()))
            && (this.getDomainName() == null ? other.getDomainName() == null : this.getDomainName().equals(other.getDomainName()))
            && (this.getDemandDesc() == null ? other.getDemandDesc() == null : this.getDemandDesc().equals(other.getDemandDesc()))
            && (this.getAlloStatus() == null ? other.getAlloStatus() == null : this.getAlloStatus().equals(other.getAlloStatus()))
            && (this.getCmgrId() == null ? other.getCmgrId() == null : this.getCmgrId().equals(other.getCmgrId()))
            && (this.getOppwd() == null ? other.getOppwd() == null : this.getOppwd().equals(other.getOppwd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCaid() == null) ? 0 : getCaid().hashCode());
        result = prime * result + ((getCbiid() == null) ? 0 : getCbiid().hashCode());
        result = prime * result + ((getLoginname() == null) ? 0 : getLoginname().hashCode());
        result = prime * result + ((getLoginalias() == null) ? 0 : getLoginalias().hashCode());
        result = prime * result + ((getInterfacePassword() == null) ? 0 : getInterfacePassword().hashCode());
        result = prime * result + ((getLoginpwd() == null) ? 0 : getLoginpwd().hashCode());
        result = prime * result + ((getAccountname() == null) ? 0 : getAccountname().hashCode());
        result = prime * result + ((getClvType() == null) ? 0 : getClvType().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getLocked() == null) ? 0 : getLocked().hashCode());
        result = prime * result + ((getLockedStartTime() == null) ? 0 : getLockedStartTime().hashCode());
        result = prime * result + ((getLockedTime() == null) ? 0 : getLockedTime().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        result = prime * result + ((getRestrictIp() == null) ? 0 : getRestrictIp().hashCode());
        result = prime * result + ((getCheckPhone() == null) ? 0 : getCheckPhone().hashCode());
        result = prime * result + ((getCustomerFrom() == null) ? 0 : getCustomerFrom().hashCode());
        result = prime * result + ((getDomainCode() == null) ? 0 : getDomainCode().hashCode());
        result = prime * result + ((getDomainName() == null) ? 0 : getDomainName().hashCode());
        result = prime * result + ((getDemandDesc() == null) ? 0 : getDemandDesc().hashCode());
        result = prime * result + ((getAlloStatus() == null) ? 0 : getAlloStatus().hashCode());
        result = prime * result + ((getCmgrId() == null) ? 0 : getCmgrId().hashCode());
        result = prime * result + ((getOppwd() == null) ? 0 : getOppwd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", caid=").append(caid);
        sb.append(", cbiid=").append(cbiid);
        sb.append(", loginname=").append(loginname);
        sb.append(", loginalias=").append(loginalias);
        sb.append(", interfacePassword=").append(interfacePassword);
        sb.append(", loginpwd=").append(loginpwd);
        sb.append(", accountname=").append(accountname);
        sb.append(", clvType=").append(clvType);
        sb.append(", email=").append(email);
        sb.append(", tel=").append(tel);
        sb.append(", locked=").append(locked);
        sb.append(", lockedStartTime=").append(lockedStartTime);
        sb.append(", lockedTime=").append(lockedTime);
        sb.append(", desc=").append(desc);
        sb.append(", restrictIp=").append(restrictIp);
        sb.append(", checkPhone=").append(checkPhone);
        sb.append(", customerFrom=").append(customerFrom);
        sb.append(", domainCode=").append(domainCode);
        sb.append(", domainName=").append(domainName);
        sb.append(", demandDesc=").append(demandDesc);
        sb.append(", alloStatus=").append(alloStatus);
        sb.append(", cmgrId=").append(cmgrId);
        sb.append(", oppwd=").append(oppwd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}