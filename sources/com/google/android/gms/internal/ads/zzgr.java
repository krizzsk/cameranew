package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgr extends zzelb<zzgr, zza> implements zzemq {
    private static final zzgr zzacc;
    private static volatile zzemx<zzgr> zzek;
    private zzgv zzabz;
    private zzejr zzaca;
    private zzejr zzacb;
    private int zzdv;

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzgr, zza> implements zzemq {
        private zza() {
            super(zzgr.zzacc);
        }

        /* synthetic */ zza(zzgt zzgtVar) {
            this();
        }
    }

    static {
        zzgr zzgrVar = new zzgr();
        zzacc = zzgrVar;
        zzelb.zza(zzgr.class, zzgrVar);
    }

    private zzgr() {
        zzejr zzejrVar = zzejr.zzilz;
        this.zzaca = zzejrVar;
        this.zzacb = zzejrVar;
    }

    public static zzgr zza(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzgr) zzelb.zza(zzacc, zzejrVar, zzekoVar);
    }

    public final zzgv zzdc() {
        zzgv zzgvVar = this.zzabz;
        return zzgvVar == null ? zzgv.zzdm() : zzgvVar;
    }

    public final zzejr zzdd() {
        return this.zzaca;
    }

    public final zzejr zzde() {
        return this.zzacb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzgt.zzel[i2 - 1]) {
            case 1:
                return new zzgr();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzacc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzabz", "zzaca", "zzacb"});
            case 4:
                return zzacc;
            case 5:
                zzemx<zzgr> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzgr.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzacc);
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
}
