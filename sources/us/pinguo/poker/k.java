package us.pinguo.poker;

import android.util.Base64;
import com.adjust.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: EncryptUtil.java */
/* loaded from: classes5.dex */
public class k {
    private static byte[] a(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
                byte[] bArr = new byte[65536];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        return messageDigest.digest();
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                throw e2;
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
                fileInputStream.close();
                return null;
            }
        } finally {
            fileInputStream.close();
        }
    }

    public static String b(String str) {
        try {
            byte[] a = a(str);
            if (a != null) {
                if (a.length == 20) {
                    byte[] bArr = new byte[21];
                    bArr[0] = 22;
                    System.arraycopy(a, 0, bArr, 1, 20);
                    return Base64.encodeToString(bArr, 10);
                }
                throw new IllegalArgumentException("SHA1 length must be 20! Current length:" + a.length);
            }
            throw new IllegalArgumentException("SHA1 must not be empty!");
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
