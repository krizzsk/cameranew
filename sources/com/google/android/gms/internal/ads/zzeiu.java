package com.google.android.gms.internal.ads;

import java.security.SecureRandom;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeiu {
    private static final ThreadLocal<SecureRandom> zzikz = new zzeit();

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom zzbfu() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzft(int i2) {
        byte[] bArr = new byte[i2];
        zzikz.get().nextBytes(bArr);
        return bArr;
    }
}
