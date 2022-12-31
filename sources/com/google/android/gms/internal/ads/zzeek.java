package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeek extends zzelb<zzeek, zza> implements zzemq {
    private static volatile zzemx<zzeek> zzek;
    private static final zzeek zzier;
    private int zzieq;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeek, zza> implements zzemq {
        private zza() {
            super(zzeek.zzier);
        }

        /* synthetic */ zza(zzeel zzeelVar) {
            this();
        }
    }

    static {
        zzeek zzeekVar = new zzeek();
        zzier = zzeekVar;
        zzelb.zza(zzeek.class, zzeekVar);
    }

    private zzeek() {
    }

    public static zzeek zzbca() {
        return zzier;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeel.zzel[i2 - 1]) {
            case 1:
                return new zzeek();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzier, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzieq"});
            case 4:
                return zzier;
            case 5:
                zzemx<zzeek> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeek.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzier);
                            zzek = zzemxVar;
                        }
                    }
                }
                return zzemxVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final int zzbbz() {
        return this.zzieq;
    }
}
