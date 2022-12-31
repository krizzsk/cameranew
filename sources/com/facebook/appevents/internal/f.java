package com.facebook.appevents.internal;

import com.adjust.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
/* compiled from: HashUtils.java */
/* loaded from: classes.dex */
final class f {
    public static final String a(String str) throws Exception {
        return b(new File(str));
    }

    private static String b(File file) throws Exception {
        int read;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1024);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            byte[] bArr = new byte[1024];
            do {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            } while (read != -1);
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            bufferedInputStream.close();
            return bigInteger;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
