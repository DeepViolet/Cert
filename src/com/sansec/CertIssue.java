package com.sansec;

/**
 * Created by liuhuiyi on 2017/6/29.
 */
public class CertIssue {
    //签发者常用名称
    String issueCN ;
    //签发者组织
    String issueOU;

    public String getIssueCN() {
        return issueCN;
    }

    public void setIssueCN(String issueCN) {
        this.issueCN = issueCN;
    }

    public String getIssueOU() {
        return issueOU;
    }

    public void setIssueOU(String issueOU) {
        this.issueOU = issueOU;
    }

    public String getIssueO() {
        return issueO;
    }

    public void setIssueO(String issueO) {
        this.issueO = issueO;
    }

    public String getIssueL() {
        return issueL;
    }

    public void setIssueL(String issueL) {
        this.issueL = issueL;
    }

    public String getIssueST() {
        return issueST;
    }

    public void setIssueST(String issueST) {
        this.issueST = issueST;
    }

    public String getIssueC() {
        return issueC;
    }

    public void setIssueC(String issueC) {
        this.issueC = issueC;
    }

    //签发者单位名称
    String issueO ;
    //签发者城市
    String issueL ;
    //签发者省/自治区
    String issueST ;
    //签发者国家/地区
    String issueC ;

    //版本
    String version ;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public String getAlg() {
        return Alg;
    }

    public void setAlg(String alg) {
        Alg = alg;
    }

    // 在此之前无效
    String From;
    //在此之后无效
    String End;
    //签名算法
    String Alg;

    public String toString(){
        return  "************签发者信息************\n"+
                "签发者常用名称: " +issueCN + "\n"
                +"签发者组织: " + issueOU + "\n"
                +"签发者单位名称: " + issueO+ "\n"
                +"签发者城市: "+issueL+ "\n"
                +"签发者省/自治区: "+issueST+"\n"
                +"签发者国家/地区: "+issueC+"\n"
                +"版本: "+version+"\n"
                +"签名算法: "+Alg+"\n"
                +"在此之前无效: "+From+"\n"
                +"在此之后无效: "+End;
    }
}
