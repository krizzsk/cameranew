package com.growingio.android.sdk.utils;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.util.Base64;
import com.growingio.android.sdk.collection.CoreInitialize;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class EncryptionUtil {
    public static String encodeRules;

    public static String AESDecode(String str) {
        try {
            return ecbDecrypt(str, getDecodeKey());
        } catch (Exception unused) {
            return null;
        }
    }

    @TargetApi(19)
    private static String ecbDecrypt(String str, String str2) throws Exception {
        try {
            byte[] decode = Base64.decode(str, 8);
            if (str2 == null) {
                System.out.print("Key为空null");
                return null;
            } else if (str2.length() % 16 != 0) {
                System.out.print("Key长度不是16倍数");
                return null;
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(2, secretKeySpec);
                try {
                    return new String(cipher.doFinal(decode), "UTF-8");
                } catch (Exception e2) {
                    System.out.println(e2.toString());
                    return null;
                }
            }
        } catch (Exception unused) {
        }
    }

    private static String getDecodeKey() {
        if (TextUtils.isEmpty(encodeRules)) {
            String appVersion = CoreInitialize.config().getAppVersion();
            if (TextUtils.isEmpty(appVersion)) {
                return null;
            }
            int length = (16 / appVersion.length()) + 1;
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(appVersion);
            }
            encodeRules = sb.toString().substring(0, 16);
        }
        return encodeRules;
    }
}
