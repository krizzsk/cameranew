package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzefr extends zzelb<zzefr, zza> implements zzemq {
    private static volatile zzemx<zzefr> zzek;
    private static final zzefr zzify;
    private int zzifv;
    private int zzifw;
    private zzejr zzifx = zzejr.zzilz;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzefr, zza> implements zzemq {
        private zza() {
            super(zzefr.zzify);
        }

        /* synthetic */ zza(zzefq zzefqVar) {
            this();
        }
    }

    static {
        zzefr zzefrVar = new zzefr();
        zzify = zzefrVar;
        zzelb.zza(zzefr.class, zzefrVar);
    }

    private zzefr() {
    }

    public static zzefr zzbdm() {
        return zzify;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzefq.zzel[i2 - 1]) {
            case 1:
                return new zzefr();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzify, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzifv", "zzifw", "zzifx"});
            case 4:
                return zzify;
            case 5:
                zzemx<zzefr> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzefr.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzify);
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

    public final zzefs zzbdj() {
        zzefs zzfg = zzefs.zzfg(this.zzifv);
        return zzfg == null ? zzefs.UNRECOGNIZED : zzfg;
    }

    public final zzeft zzbdk() {
        zzeft zzfh = zzeft.zzfh(this.zzifw);
        return zzfh == null ? zzeft.UNRECOGNIZED : zzfh;
    }

    public final zzejr zzbdl() {
        return this.zzifx;
    }
}
