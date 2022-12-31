package d.f.a.a.a.d;

import com.adjust.sdk.Constants;
import d.f.a.b.d;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: Md5FileNameGenerator.java */
/* loaded from: classes3.dex */
public class c implements a {
    private byte[] b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            d.c(e2);
            return null;
        }
    }

    @Override // d.f.a.a.a.d.a
    public String a(String str) {
        return new BigInteger(b(str.getBytes())).abs().toString(36);
    }
}
