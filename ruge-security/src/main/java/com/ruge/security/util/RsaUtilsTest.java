package com.ruge.security.util;

import java.security.PrivateKey;
import java.security.PublicKey;

import static org.junit.Assert.*;

/**
 * @author ruge.wu
 */
public class RsaUtilsTest {
    private String privateFilePath = "D:\\auth_key\\id_key";
    private String publicFilePath = "D:\\auth_key\\id_key.pub";

    @org.junit.Test
    public void getPublicKey() throws Exception {
        PublicKey publicKey = RsaUtils.getPublicKey(publicFilePath);
        System.out.println(publicKey);
    }

    @org.junit.Test
    public void getPrivateKey() throws Exception {
        PrivateKey privateKey = RsaUtils.getPrivateKey(privateFilePath);
        System.out.println(privateKey);
    }

    @org.junit.Test
    public void generateKey() throws Exception {
        RsaUtils.generateKey(publicFilePath, privateFilePath, "ruge", 2048);
    }
}
