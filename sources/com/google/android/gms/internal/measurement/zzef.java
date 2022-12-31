package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public enum zzef implements zzhu {
    UNKNOWN(0),
    STRING(1),
    NUMBER(2),
    BOOLEAN(3),
    STATEMENT(4);
    
    private static final zzhv<zzef> zzf = new zzhv<zzef>() { // from class: com.google.android.gms.internal.measurement.zzed
    };
    private final int zzg;

    zzef(int i2) {
        this.zzg = i2;
    }

    public static zzef zza(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        return STATEMENT;
                    }
                    return BOOLEAN;
                }
                return NUMBER;
            }
            return STRING;
        }
        return UNKNOWN;
    }

    public static zzhw zzb() {
        return zzee.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzef.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
    }
}
