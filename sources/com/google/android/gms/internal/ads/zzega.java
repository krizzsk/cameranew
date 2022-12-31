package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzega extends zzelb<zzega, zza> implements zzemq {
    private static volatile zzemx<zzega> zzek;
    private static final zzega zzigr;
    private int zzief;
    private int zzigq;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzega, zza> implements zzemq {
        private zza() {
            super(zzega.zzigr);
        }

        /* synthetic */ zza(zzegb zzegbVar) {
            this();
        }
    }

    static {
        zzega zzegaVar = new zzega();
        zzigr = zzegaVar;
        zzelb.zza(zzega.class, zzegaVar);
    }

    private zzega() {
    }

    public static zzega zzbdv() {
        return zzigr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzegb.zzel[i2 - 1]) {
            case 1:
                return new zzega();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzigr, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzigq", "zzief"});
            case 4:
                return zzigr;
            case 5:
                zzemx<zzega> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzega.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzigr);
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

    public final int zzbbj() {
        return this.zzief;
    }

    public final zzeft zzbdu() {
        zzeft zzfh = zzeft.zzfh(this.zzigq);
        return zzfh == null ? zzeft.UNRECOGNIZED : zzfh;
    }
}
