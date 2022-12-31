package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class zzacx<T> {
    private final T zzclv;
    private final String zzcm;
    private final int zzdch;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Ljava/lang/Integer;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public zzacx(String str, Object obj, int i2) {
        this.zzcm = str;
        this.zzclv = obj;
        this.zzdch = i2;
    }

    public static zzacx<Long> zzb(String str, long j2) {
        return new zzacx<>(str, Long.valueOf(j2), zzacz.zzdcj);
    }

    public static zzacx<Boolean> zzg(String str, boolean z) {
        return new zzacx<>(str, Boolean.valueOf(z), zzacz.zzdci);
    }

    public static zzacx<String> zzh(String str, String str2) {
        return new zzacx<>(str, str2, zzacz.zzdcl);
    }

    public T get() {
        zzadx zztc = zzadw.zztc();
        if (zztc != null) {
            int i2 = zzacw.zzdcg[this.zzdch - 1];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return (T) zztc.get(this.zzcm, (String) this.zzclv);
                        }
                        throw new IllegalStateException();
                    }
                    return (T) zztc.zza(this.zzcm, ((Double) this.zzclv).doubleValue());
                }
                return (T) zztc.getLong(this.zzcm, ((Long) this.zzclv).longValue());
            }
            return (T) zztc.zzf(this.zzcm, ((Boolean) this.zzclv).booleanValue());
        }
        throw new IllegalStateException("Flag is not initialized.");
    }

    public static zzacx<Double> zzb(String str, double d2) {
        return new zzacx<>(str, Double.valueOf(d2), zzacz.zzdck);
    }
}
