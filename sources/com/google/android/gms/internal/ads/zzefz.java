package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzefz extends zzelb<zzefz, zza> implements zzemq {
    private static volatile zzemx<zzefz> zzek;
    private static final zzefz zzigp;
    private int zzidz;
    private int zzied;
    private zzega zzign;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzefz, zza> implements zzemq {
        private zza() {
            super(zzefz.zzigp);
        }

        /* synthetic */ zza(zzefy zzefyVar) {
            this();
        }
    }

    static {
        zzefz zzefzVar = new zzefz();
        zzigp = zzefzVar;
        zzelb.zza(zzefz.class, zzefzVar);
    }

    private zzefz() {
    }

    public static zzefz zzbds() {
        return zzigp;
    }

    public static zzefz zzu(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzefz) zzelb.zza(zzigp, zzejrVar, zzekoVar);
    }

    public final int getKeySize() {
        return this.zzied;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzefy.zzel[i2 - 1]) {
            case 1:
                return new zzefz();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzigp, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzign", "zzied", "zzidz"});
            case 4:
                return zzigp;
            case 5:
                zzemx<zzefz> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzefz.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzigp);
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

    public final zzega zzbdo() {
        zzega zzegaVar = this.zzign;
        return zzegaVar == null ? zzega.zzbdv() : zzegaVar;
    }
}
