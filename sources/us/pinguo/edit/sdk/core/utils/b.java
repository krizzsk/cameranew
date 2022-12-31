package us.pinguo.edit.sdk.core.utils;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
/* compiled from: DESEncrypt.java */
/* loaded from: classes4.dex */
public class b {
    public static String a(String str, String str2) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance("des").generateSecret(new DESKeySpec(str2.getBytes()));
        Cipher cipher = Cipher.getInstance("des/CBC/PKCS5Padding");
        cipher.init(2, generateSecret, new IvParameterSpec("d9877ff9".getBytes()));
        return new String(cipher.doFinal(Base64.decode(str, 2)), "utf-8");
    }
}
