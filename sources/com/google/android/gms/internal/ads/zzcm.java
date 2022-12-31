package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public enum zzcm implements zzelg {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3),
    DG(4),
    DG_XTEA(5);
    
    private static final zzelf<zzcm> zzes = new zzelf<zzcm>() { // from class: com.google.android.gms.internal.ads.zzco
    };
    private final int value;

    zzcm(int i2) {
        this.value = i2;
    }

    public static zzcm zzm(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return null;
                            }
                            return DG_XTEA;
                        }
                        return DG;
                    }
                    return UNENCRYPTED;
                }
                return TINK_HYBRID;
            }
            return BITSLICER;
        }
        return UNKNOWN_ENCRYPTION_METHOD;
    }

    public static zzeli zzw() {
        return zzcn.zzeu;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcm.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final int zzv() {
        return this.value;
    }
}
