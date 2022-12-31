package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public enum zzcc implements zzhu {
    UNKNOWN_COMPARISON_TYPE(0),
    LESS_THAN(1),
    GREATER_THAN(2),
    EQUAL(3),
    BETWEEN(4);
    
    private static final zzhv<zzcc> zzf = new zzhv<zzcc>() { // from class: com.google.android.gms.internal.measurement.zzca
    };
    private final int zzg;

    zzcc(int i2) {
        this.zzg = i2;
    }

    public static zzcc zza(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        return BETWEEN;
                    }
                    return EQUAL;
                }
                return GREATER_THAN;
            }
            return LESS_THAN;
        }
        return UNKNOWN_COMPARISON_TYPE;
    }

    public static zzhw zzb() {
        return zzcb.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
    }
}
