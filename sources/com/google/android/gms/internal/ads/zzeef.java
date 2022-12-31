package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeef extends zzelb<zzeef, zza> implements zzemq {
    private static volatile zzemx<zzeef> zzek;
    private static final zzeef zziem;
    private zzeej zziek;
    private zzefz zziel;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeef, zza> implements zzemq {
        private zza() {
            super(zzeef.zziem);
        }

        /* synthetic */ zza(zzeee zzeeeVar) {
            this();
        }
    }

    static {
        zzeef zzeefVar = new zzeef();
        zziem = zzeefVar;
        zzelb.zza(zzeef.class, zzeefVar);
    }

    private zzeef() {
    }

    public static zzeef zzf(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzeef) zzelb.zza(zziem, zzejrVar, zzekoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeee.zzel[i2 - 1]) {
            case 1:
                return new zzeef();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziem, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zziek", "zziel"});
            case 4:
                return zziem;
            case 5:
                zzemx<zzeef> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeef.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziem);
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

    public final zzeej zzbbq() {
        zzeej zzeejVar = this.zziek;
        return zzeejVar == null ? zzeej.zzbbx() : zzeejVar;
    }

    public final zzefz zzbbr() {
        zzefz zzefzVar = this.zziel;
        return zzefzVar == null ? zzefz.zzbds() : zzefzVar;
    }
}
