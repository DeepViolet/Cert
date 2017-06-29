package com.sansec;

import sun.misc.BASE64Decoder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;


public class Main {

    public static void main(String[] args) throws CertificateException, IOException {
	// write your code here

        //FileInputStream fileInputStream = new FileInputStream("C:\\Users\\liuhuiyi\\mycert.crt");
        String filePath = "C:\\Users\\liuhuiyi\\mycert.crt";
        String filePath2 = "D:\\SaaSSVN\\云签名验签系统\\开发目录\\服务端\\workspace\\Netty1-noimpkey\\src\\rootRsa\\c2.cer";
        String filePath3 = "c:\\Users\\liuhuiyi\\Desktop\\df.crt";
        X509Certificate cert = GenCert(filePath3);


        /*******************
        **证书使用主体
         * *****************/
        CertSubject certSubject = GenSubject(cert);
        System.out.println(certSubject.toString());

        /**
         * 签发者信息
         */
        CertIssue certIssue = GenIssue(cert);
        System.out.println(certIssue.toString());

        /**
         * 公共密钥信息
         */
        CertKey certKey = GenKey(cert);
        System.out.println(certKey.toString());

    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02X ", b));
        return sb.toString();
    }

    private static X509Certificate GenCert(String filepath)  {
        CertificateFactory certificateFactory= null;
        try {
            try {
                certificateFactory = CertificateFactory.getInstance("X.509", "SwxaJCE");
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            }
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        X509Certificate cert = null;
        File file = new File(filepath);
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        FileInputStream fileInputStream = null;
        if(suffix.equals("crt")){
            try {
                 fileInputStream = new FileInputStream(filepath);
                try {
                    if(fileInputStream != null)
                    cert= (X509Certificate)certificateFactory.generateCertificate(fileInputStream);
                } catch (CertificateException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (fileInputStream != null)
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        else {
            String filecontent = null;
            try {

                filecontent = new String(Files.readAllBytes(Paths.get(filepath)),Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            BASE64Decoder base64Decoder = new BASE64Decoder();
            try {
                byte[] filebyte = base64Decoder.decodeBuffer(filecontent);
                try {
                    cert = (X509Certificate)certificateFactory.generateCertificate(new ByteArrayInputStream(filebyte));
                } catch (CertificateException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return cert;
    }

    private static CertSubject GenSubject(X509Certificate cert){
        CertSubject subject = new CertSubject();

        String[] sub = cert.getSubjectDN().getName().split(",");

        for(int i=0;i<sub.length;i++){
            String tipName = sub[i].substring(0,sub[i].indexOf('=')).trim();
            String tipValue = sub[i].substring(sub[i].indexOf('=')+1);
            //使用者常用名称
            if(tipName.equals("CN"))
                subject.setSubjectCN(tipValue);
            //使用者组织
            if(tipName.equals("OU"))
                subject.setSubjectOU(tipValue);
            //使用者单位名称
            if(tipName.equals("O"))
                subject.setSubjectO(tipValue);
            //使用者城市
            if(tipName.equals("L"))
                subject.setSubjectL(tipValue);
            //使用者省/自治区
            if(tipName.equals("ST"))
                subject.setSubjectST(tipValue);
            //使用者国家/地区
            if(tipName.equals("C"))
                subject.setSubjectC(tipValue);
        }

        return subject;

    }

    private static CertIssue GenIssue(X509Certificate cert){
        CertIssue issue = new CertIssue();
        String[] iss = cert.getIssuerDN().toString().split(",");

        for(int i=0;i<iss.length;i++){
            String tipName = iss[i].substring(0,iss[i].indexOf('=')).trim();
            String tipValue = iss[i].substring(iss[i].indexOf('=')+1);
            //使用者常用名称
            if(tipName.equals("CN"))
                issue.setIssueCN(tipValue);
            //使用者组织
            if(tipName.equals("OU"))
                issue.setIssueOU(tipValue);
            //使用者单位名称
            if(tipName.equals("O"))
                issue.setIssueO(tipValue);
            //使用者城市
            if(tipName.equals("L"))
                issue.setIssueL(tipValue);
            //使用者省/自治区
            if(tipName.equals("ST"))
                issue.setIssueST(tipValue);
            //使用者国家/地区
            if(tipName.equals("C"))
                issue.setIssueC(tipValue);
        }
         //版本
        issue.setVersion("V" + cert.getVersion());
        //
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        issue.setFrom(format.format(cert.getNotBefore()));
        issue.setEnd(format.format(cert.getNotAfter()));
        issue.setAlg(cert.getSigAlgName() + " ("+cert.getSigAlgOID()+")");
        return issue;

    }

    private static CertKey GenKey(X509Certificate cert){
        CertKey certKey = new CertKey();
        //证书编码格式
        certKey.setType(cert.getType());
        String Alg = cert.getSigAlgName();
        if(Alg.contains("RSA")) {
            //解析公钥
            RSAPublicKey rsaPublicKey = (RSAPublicKey) cert.getPublicKey();
            //算法
            certKey.setAlgthm(rsaPublicKey.getAlgorithm());
            //指数e
            certKey.setE(rsaPublicKey.getPublicExponent().toString());
            //公共密钥位数
            certKey.setBits(rsaPublicKey.getModulus().bitLength());
            //公共密钥
            certKey.setN(byteArrayToHex(rsaPublicKey.getModulus().toByteArray()).substring(2));
            //签名值
            certKey.setSingature(byteArrayToHex(cert.getSignature()));
            certKey.setSigLen(cert.getSignature().length);
        }
        if(Alg.contains("SM2")){
            PublicKey publicKey= cert.getPublicKey();
            certKey.setAlgthm(publicKey.getAlgorithm());
            certKey.setN(publicKey.toString());
            certKey.setBits(publicKey.getEncoded().length*4);
        }

        return  certKey;
    }
}
