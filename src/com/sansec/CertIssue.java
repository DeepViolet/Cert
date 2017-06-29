package com.sansec;

/**
 * Created by liuhuiyi on 2017/6/29.
 */
public class CertIssue {
    //签发者常用名称
    private String issueCN ;
    //签发者组织
    private String issueOU;
    //签发者单位名称
    private String issueO ;
    //签发者城市
    private String issueL ;
    //签发者省/自治区
    private String issueST ;
    //签发者国家/地区
    private String issueC ;
    //版本
    private String version ;
    // 在此之前无效
    private String from;
    //在此之后无效
    private String end;
    //签名算法
    private String alg;

    public final String getIssueCN() {
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



    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }


    public String toString(){
        return  "************签发者信息************\n"+
                "签发者常用名称: " +issueCN + "\n"
                +"签发者组织: " + issueOU + "\n"
                +"签发者单位名称: " + issueO+ "\n"
                +"签发者城市: "+issueL+ "\n"
                +"签发者省/自治区: "+issueST+"\n"
                +"签发者国家/地区: "+issueC+"\n"
                +"版本: "+version+"\n"
                +"签名算法: "+ alg +"\n"
                +"在此之前无效: "+ from +"\n"
                +"在此之后无效: "+ end;
    }
}
