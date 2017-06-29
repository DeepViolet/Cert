package com.sansec;

/**
 * Created by liuhuiyi on 2017/6/29.
 */
public class CertSubject {
    //使用者常用名称
    private String subjectCN;
    //使用者组织
    private String subjectOU;
    //使用者单位名称
    private String subjectO;
    //使用者城市
    private  String subjectL;
    //使用者省/自治区
    private String subjectST;
    //使用者国家/地区
    private String subjectC;

    public String getSubjectCN() {
        return subjectCN;
    }

    public void setSubjectCN(String subjectCN) {
        this.subjectCN = subjectCN;
    }

    public String getSubjectOU() {
        return subjectOU;
    }

    public void setSubjectOU(String subjectOU) {
        this.subjectOU = subjectOU;
    }

    public String getSubjectO() {
        return subjectO;
    }

    public void setSubjectO(String subjectO) {
        this.subjectO = subjectO;
    }

    public String getSubjectL() {
        return subjectL;
    }

    public void setSubjectL(String subjectL) {
        this.subjectL = subjectL;
    }

    public String getSubjectST() {
        return subjectST;
    }

    public void setSubjectST(String subjectST) {
        this.subjectST = subjectST;
    }

    public String getSubjectC() {
        return subjectC;
    }

    public void setSubjectC(String subjectC) {
        this.subjectC = subjectC;
    }

    public String toString(){
        return  "************主题信息************\n"+
                "使用者常用名称: " + subjectCN + "\n"
                +"使用者组织: " + subjectOU + "\n"
                +"使用者单位名称: " + subjectO + "\n"
                +"使用者城市: "+ subjectL + "\n"
                +"使用者省/自治区: "+ subjectST +"\n"
                +"使用者国家/地区: "+ subjectC;
    }
}
