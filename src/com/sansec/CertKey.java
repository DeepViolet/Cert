package com.sansec;

/**
 * Created by liuhuiyi on 2017/6/29.
 */
public class CertKey {
    private String type;

    //算法
    private String algthm;
    //指数e
    private String e ;
    //公共密钥位数
    private int bits ;
    //公共密钥
    private String n;
    //签名值
    private String singature ;

    private int sigLen;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlgthm() {
        return algthm;
    }

    public void setAlgthm(String algthm) {
        this.algthm = algthm;
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



    public String toString(){
        if(algthm.equals("RSA")){
            return  "************公钥信息************\n"+
                "证书类型: " +type + "\n"
                +"算法: " + algthm + "\n"
                +"公共密钥位数: "+bits+ "\n"
                +"指数e: " + e+ "\n"
                +"公共密钥n: "+n+"\n"
                +"签名值: "+singature+"\n"
                +"签名值长度: "+sigLen;
        }else{
            return  "************公钥信息************\n"+
                    "证书类型: " +type + "\n"
                    +"算法: " + algthm + "\n"
                    +"公共密钥: "+n+"\n";
        }
    }
}
