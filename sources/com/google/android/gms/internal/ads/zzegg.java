package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzegg extends zzelb<zzegg, zza> implements zzemq {
    private static volatile zzemx<zzegg> zzek;
    private static final zzegg zzihk;
    private String zzigs = "";
    private zzejr zzigt = zzejr.zzilz;
    private int zzihj;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzegg, zza> implements zzemq {
        private zza() {
            super(zzegg.zzihk);
        }

        /* synthetic */ zza(zzegi zzegiVar) {
            this();
        }
    }

    static {
        zzegg zzeggVar = new zzegg();
        zzihk = zzeggVar;
        zzelb.zza(zzegg.class, zzeggVar);
    }

    private zzegg() {
    }

    public static zzegg zzbed() {
        return zzihk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzegi.zzel[i2 - 1]) {
            case 1:
                return new zzegg();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzihk, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzigs", "zzigt", "zzihj"});
            case 4:
                return zzihk;
            case 5:
                zzemx<zzegg> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzegg.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzihk);
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

    public final String zzbdx() {
        return this.zzigs;
    }

    public final zzejr zzbdy() {
        return this.zzigt;
    }
}
