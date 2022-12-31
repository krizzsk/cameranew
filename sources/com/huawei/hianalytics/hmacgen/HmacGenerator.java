package com.huawei.hianalytics.hmacgen;

import android.util.Log;
import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public abstract class HmacGenerator {

    /* loaded from: classes2.dex */
    public interface HmacCallback {
        void onGenerate(long j2, byte[] bArr);
    }

    public static void a(String str, String str2, HmacCallback hmacCallback) {
        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            byte[] digest = messageDigest.digest((str + str2 + currentTimeMillis).getBytes("UTF-8"));
            if (hmacCallback != null) {
                hmacCallback.onGenerate(currentTimeMillis, digest);
            }
        } catch (UnsupportedEncodingException unused) {
            Log.w("Generator", "getHmac(): UnsupportedEncodingException: Exception when writing the log file.");
        }
    }
}
