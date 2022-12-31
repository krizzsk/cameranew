package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public enum zzcv implements zzhu {
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN(0),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED(1),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED(2),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED(3),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED(4),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED(5);
    
    private static final zzhv<zzcv> zzg = new zzhv<zzcv>() { // from class: com.google.android.gms.internal.measurement.zzct
    };
    private final int zzh;

    zzcv(int i2) {
        this.zzh = i2;
    }

    public static zzcv zza(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return null;
                            }
                            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED;
                        }
                        return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED;
                    }
                    return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED;
                }
                return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED;
            }
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED;
        }
        return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN;
    }

    public static zzhw zzb() {
        return zzcu.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcv.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
    }
}
