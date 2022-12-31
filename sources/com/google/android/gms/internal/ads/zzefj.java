package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzefj extends zzelb<zzefj, zza> implements zzemq {
    private static volatile zzemx<zzefj> zzek;
    private static final zzefj zzifl;
    private zzefk zzifk;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzefj, zza> implements zzemq {
        private zza() {
            super(zzefj.zzifl);
        }

        /* synthetic */ zza(zzefi zzefiVar) {
            this();
        }
    }

    static {
        zzefj zzefjVar = new zzefj();
        zzifl = zzefjVar;
        zzelb.zza(zzefj.class, zzefjVar);
    }

    private zzefj() {
    }

    public static zzefj zzq(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzefj) zzelb.zza(zzifl, zzejrVar, zzekoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzefi.zzel[i2 - 1]) {
            case 1:
                return new zzefj();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzifl, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzifk"});
            case 4:
                return zzifl;
            case 5:
                zzemx<zzefj> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzefj.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzifl);
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

    public final zzefk zzbcu() {
        zzefk zzefkVar = this.zzifk;
        return zzefkVar == null ? zzefk.zzbcz() : zzefkVar;
    }
}
