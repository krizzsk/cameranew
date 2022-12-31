package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzegs extends zzelb<zzegs, zza> implements zzemq {
    private static volatile zzemx<zzegs> zzek;
    private static final zzegs zziid;
    private String zziic = "";

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzegs, zza> implements zzemq {
        private zza() {
            super(zzegs.zziid);
        }

        /* synthetic */ zza(zzegr zzegrVar) {
            this();
        }
    }

    static {
        zzegs zzegsVar = new zzegs();
        zziid = zzegsVar;
        zzelb.zza(zzegs.class, zzegsVar);
    }

    private zzegs() {
    }

    public static zzegs zzbfa() {
        return zziid;
    }

    public static zzegs zzw(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzegs) zzelb.zza(zziid, zzejrVar, zzekoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzegr.zzel[i2 - 1]) {
            case 1:
                return new zzegs();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziid, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zziic"});
            case 4:
                return zziid;
            case 5:
                zzemx<zzegs> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzegs.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziid);
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

    public final String zzbez() {
        return this.zziic;
    }
}
