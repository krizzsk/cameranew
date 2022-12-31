package us.pinguo.common.network.common;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.common.network.encrypt.Aes;
import us.pinguo.common.network.encrypt.Des3;
import us.pinguo.common.network.encrypt.HmacSHA256;
import us.pinguo.common.network.encrypt.Xor;
/* loaded from: classes4.dex */
public class PGSecureUtils {
    public static byte[] decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return null;
        }
        if (PGTransHeader.E1.equals(str)) {
            return Xor.decrypt(bArr, bArr2);
        }
        if (PGTransHeader.E2.equals(str)) {
            return Des3.decrypt(bArr, bArr2);
        }
        if (PGTransHeader.E3.equals(str)) {
            return Aes.decrypt(bArr, bArr2);
        }
        return bArr;
    }

    public static byte[] encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return bArr;
        }
        try {
            if (PGTransHeader.E1.equals(str)) {
                return Xor.encrypt(bArr, bArr2);
            }
            if (PGTransHeader.E2.equals(str)) {
                return Des3.encrypt(bArr, bArr2);
            }
            if (PGTransHeader.E3.equals(str)) {
                return Aes.encrypt(bArr, bArr2);
            }
            throw new IllegalArgumentException("Illegal alg exception!alg can not be " + str);
        } catch (Exception unused) {
            return bArr;
        }
    }

    static String genKeyContent(int i2, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if ((i2 & 1) != 0) {
            sb.append(str);
        }
        if ((i2 & 2) != 0) {
            sb.append(str2);
        }
        if ((i2 & 4) != 0) {
            sb.append(str3);
        }
        if ((i2 & 8) != 0) {
            sb.append(str4);
        }
        return sb.toString();
    }

    public static byte[] genRawDataKey(String str, int i2, String str2, String str3, String str4, String str5) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {
        String genKeyContent = genKeyContent(i2, str2, str3, str4, str5);
        if (PGTransHeader.S1.equals(str)) {
            return HmacSHA256.hash(genKeyContent.getBytes("UTF-8"), PGNetworkConstants.DEFAULT_SOKEY.getBytes());
        }
        throw new IllegalArgumentException("Illegal alg exception!alg can not be" + str);
    }
}
