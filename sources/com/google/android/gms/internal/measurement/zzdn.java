package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public enum zzdn implements zzhu {
    RADS(1),
    PROVISIONING(2);
    
    private static final zzhv<zzdn> zzc = new zzhv<zzdn>() { // from class: com.google.android.gms.internal.measurement.zzdl
    };
    private final int zzd;

    zzdn(int i2) {
        this.zzd = i2;
    }

    public static zzdn zza(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            return PROVISIONING;
        }
        return RADS;
    }

    public static zzhw zzb() {
        return zzdm.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzdn.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }
}
