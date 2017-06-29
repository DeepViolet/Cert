package com.sansec;

/**
 * Created by liuhuiyi on 2017/6/29.
 */
public class CertKey {
    String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlgthm() {
        return Algthm;
    }

    public void setAlgthm(String algthm) {
        Algthm = algthm;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getSingature() {
        return singature;
    }

    public void setSingature(String singature) {
        this.singature = singature;
    }

    public int getSigLen() {
        return sigLen;
    }

    public void setSigLen(int sigLen) {
        this.sigLen = sigLen;
    }

    //算法
    String Algthm ;
    //指数e
    String e ;
    //公共密钥位数
    int bits ;
    //公共密钥
    String n;
    //签名值
    String singature ;
    int sigLen;

    public String toString(){
        if(Algthm=="RSA"){
            return  "************公钥信息************\n"+
                "证书类型: " +type + "\n"
                +"算法: " + Algthm + "\n"
                +"公共密钥位数: "+bits+ "\n"
                +"指数e: " + e+ "\n"
                +"公共密钥n: "+n+"\n"
                +"签名值: "+singature+"\n"
                +"签名值长度: "+sigLen;
        }else{
            return  "************公钥信息************\n"+
                    "证书类型: " +type + "\n"
                    +"算法: " + Algthm + "\n"
                    +"公共密钥: "+n+"\n";
        }
    }
}
