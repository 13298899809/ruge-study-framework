package com.ruge.security.tool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName PasswordTool
 * @date 2020.07.03 15:27
 */
@Slf4j
public class PasswordTool {
    /**
     * Encode the raw password. Generally, a good encoding algorithm applies a SHA-1 or
     * greater hash combined with an 8-byte or greater randomly generated salt.
     *
     * @param rawPassword
     */
    /**
     * @param passwordEncoder {@link PasswordEncoderFactories#createDelegatingPasswordEncoder()}
     * @param rawPassword     待加密的密码
     * @return 加密后的密码
     */
    public static String encode(PasswordEncoder passwordEncoder, CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Verify the encoded password obtained from storage matches the submitted raw
     * password after it too is encoded. Returns true if the passwords match, false if
     * they do not. The stored password itself is never decoded.
     *
     * @param rawPassword     the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @return true if the raw password, after encoding, matches the encoded password from
     * storage
     */
    public static boolean matches(PasswordEncoder passwordEncoder, CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null || encodedPassword.length() == 0) {
            log.warn("Empty encoded password");
            return false;
        }
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
