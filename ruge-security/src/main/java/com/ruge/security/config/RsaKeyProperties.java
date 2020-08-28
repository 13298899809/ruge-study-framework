package com.ruge.security.config;

import com.ruge.security.util.RsaUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName RsaKeyConfig
 * @date 2020.07.21 11:18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SpringBootConfiguration
@ConfigurationProperties(prefix = "rsa.key")
public class RsaKeyProperties {
    private String pubKeyFile;
    private String priKeyFile;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    @PostConstruct
    public void cresteRsaKey() throws Exception {
        publicKey = RsaUtils.getPublicKey(pubKeyFile);
        privateKey = RsaUtils.getPrivateKey(priKeyFile);
    }
}
