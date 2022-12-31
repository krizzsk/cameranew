package us.pinguo.common.network.encrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public class HmacSHA256 {
    public static byte[] hash(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(bArr2, "HmacSHA256"));
        return mac.doFinal(bArr);
    }
}
