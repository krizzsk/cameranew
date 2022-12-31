package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public enum zzcr implements zzelg {
    UNKNOWN_PROTO(0),
    AFMA_SIGNALS(1),
    UNITY_SIGNALS(2),
    PARTNER_SIGNALS(3);
    
    private static final zzelf<zzcr> zzes = new zzelf<zzcr>() { // from class: com.google.android.gms.internal.ads.zzcu
    };
    private final int value;

    zzcr(int i2) {
        this.value = i2;
    }

    public static zzcr zzo(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return PARTNER_SIGNALS;
                }
                return UNITY_SIGNALS;
            }
            return AFMA_SIGNALS;
        }
        return UNKNOWN_PROTO;
    }

    public static zzeli zzw() {
        return zzct.zzeu;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcr.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final int zzv() {
        return this.value;
    }
}
