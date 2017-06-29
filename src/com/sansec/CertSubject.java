package com.sansec;

/**
 * Created by liuhuiyi on 2017/6/29.
 */
public class CertSubject {
    //使用者常用名称
    String SubjectCN ;
    //使用者组织
    String SubjectOU ;
    //使用者单位名称
    String SubjectO ;
    //使用者城市
    String SubjectL ;
    //使用者省/自治区
    String SubjectST;
    //使用者国家/地区
    String SubjectC;

    public String getSubjectCN() {
        return SubjectCN;
    }

    public void setSubjectCN(String subjectCN) {
        SubjectCN = subjectCN;
    }

    public String getSubjectOU() {
        return SubjectOU;
    }

    public void setSubjectOU(String subjectOU) {
        SubjectOU = subjectOU;
    }

    public String getSubjectO() {
        return SubjectO;
    }

    public void setSubjectO(String subjectO) {
        SubjectO = subjectO;
    }

    public String getSubjectL() {
        return SubjectL;
    }

    public void setSubjectL(String subjectL) {
        SubjectL = subjectL;
    }

    public String getSubjectST() {
        return SubjectST;
    }

    public void setSubjectST(String subjectST) {
        SubjectST = subjectST;
    }

    public String getSubjectC() {
        return SubjectC;
    }

    public void setSubjectC(String subjectC) {
        SubjectC = subjectC;
    }

    public String toString(){
        return  "************主题信息************\n"+
                "使用者常用名称: " +SubjectCN + "\n"
                +"使用者组织: " + SubjectOU + "\n"
                +"使用者单位名称: " + SubjectO+ "\n"
                +"使用者城市: "+SubjectL+ "\n"
                +"使用者省/自治区: "+SubjectST+"\n"
                +"使用者国家/地区: "+SubjectC;
    }
}
