package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public enum zzuq implements zzelg {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);
    
    private static final zzelf<zzuq> zzes = new zzelf<zzuq>() { // from class: com.google.android.gms.internal.ads.zzup
    };
    private final int value;

    zzuq(int i2) {
        this.value = i2;
    }

    public static zzuq zzcd(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 1000) {
                    return null;
                }
                return ENUM_UNKNOWN;
            }
            return ENUM_TRUE;
        }
        return ENUM_FALSE;
    }

    public static zzeli zzw() {
        return zzur.zzeu;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzuq.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final int zzv() {
        return this.value;
    }
}
