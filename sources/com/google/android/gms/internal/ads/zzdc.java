package com.google.android.gms.internal.ads;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdc implements Runnable {
    private zzdc() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzda.zza(MessageDigest.getInstance(Constants.MD5));
        } catch (NoSuchAlgorithmException unused) {
        } finally {
            zzda.zznw.countDown();
        }
    }
}
