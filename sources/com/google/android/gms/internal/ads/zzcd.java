package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public enum zzcd implements zzelg {
    ENUM_SIGNAL_SOURCE_UNKNOWN(0),
    ENUM_SIGNAL_SOURCE_DISABLE(1),
    ENUM_SIGNAL_SOURCE_ADSHIELD(2),
    ENUM_SIGNAL_SOURCE_GASS(3),
    ENUM_SIGNAL_SOURCE_CALLER_PROVIDED(4);
    
    private static final zzelf<zzcd> zzes = new zzelf<zzcd>() { // from class: com.google.android.gms.internal.ads.zzcc
    };
    private final int value;

    zzcd(int i2) {
        this.value = i2;
    }

    public static zzcd zzj(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        return ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
                    }
                    return ENUM_SIGNAL_SOURCE_GASS;
                }
                return ENUM_SIGNAL_SOURCE_ADSHIELD;
            }
            return ENUM_SIGNAL_SOURCE_DISABLE;
        }
        return ENUM_SIGNAL_SOURCE_UNKNOWN;
    }

    public static zzeli zzw() {
        return zzce.zzeu;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final int zzv() {
        return this.value;
    }
}
