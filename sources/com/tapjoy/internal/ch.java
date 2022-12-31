package com.tapjoy.internal;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class ch {
    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(Constants.SHA1).digest(bArr);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
