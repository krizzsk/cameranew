package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public enum zzcj implements zzhu {
    UNKNOWN_MATCH_TYPE(0),
    REGEXP(1),
    BEGINS_WITH(2),
    ENDS_WITH(3),
    PARTIAL(4),
    EXACT(5),
    IN_LIST(6);
    
    private static final zzhv<zzcj> zzh = new zzhv<zzcj>() { // from class: com.google.android.gms.internal.measurement.zzch
    };
    private final int zzi;

    zzcj(int i2) {
        this.zzi = i2;
    }

    public static zzcj zza(int i2) {
        switch (i2) {
            case 0:
                return UNKNOWN_MATCH_TYPE;
            case 1:
                return REGEXP;
            case 2:
                return BEGINS_WITH;
            case 3:
                return ENDS_WITH;
            case 4:
                return PARTIAL;
            case 5:
                return EXACT;
            case 6:
                return IN_LIST;
            default:
                return null;
        }
    }

    public static zzhw zzb() {
        return zzci.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcj.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
    }
}
