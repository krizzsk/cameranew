package com.danikula.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.adjust.sdk.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: ProxyCacheUtils.java */
/* loaded from: classes.dex */
public class l {
    private static final org.slf4j.b a = org.slf4j.c.i("ProxyCacheUtils");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j2, int i2) {
        j.e(bArr, "Buffer must be not null!");
        boolean z = true;
        j.c(j2 >= 0, "Data offset must be positive!");
        j.c((i2 < 0 || i2 > bArr.length) ? false : false, "Length must be in range [0..buffer.length]");
    }

    private static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                a.error("Error closing resource", e2);
            }
        }
    }

    public static String d(String str) {
        try {
            return b(MessageDigest.getInstance(Constants.MD5).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error decoding url", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error encoding url", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }
}
