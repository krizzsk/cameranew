package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class zzrv {
    @Nullable
    private static MessageDigest zzbug;
    protected Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] zzbq(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final MessageDigest zzms() {
        synchronized (this.mLock) {
            MessageDigest messageDigest = zzbug;
            if (messageDigest != null) {
                return messageDigest;
            }
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    zzbug = MessageDigest.getInstance(Constants.MD5);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return zzbug;
        }
    }
}
