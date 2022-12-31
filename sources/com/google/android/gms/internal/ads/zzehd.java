package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzehd extends zzelb<zzehd, zza> implements zzemq {
    private static volatile zzemx<zzehd> zzek;
    private static final zzehd zziiu;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzehd, zza> implements zzemq {
        private zza() {
            super(zzehd.zziiu);
        }

        /* synthetic */ zza(zzehe zzeheVar) {
            this();
        }
    }

    static {
        zzehd zzehdVar = new zzehd();
        zziiu = zzehdVar;
        zzelb.zza(zzehd.class, zzehdVar);
    }

    private zzehd() {
    }

    public static zzehd zzaa(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzehd) zzelb.zza(zziiu, zzejrVar, zzekoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzehe.zzel[i2 - 1]) {
            case 1:
                return new zzehd();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziiu, "\u0000\u0000", (Object[]) null);
            case 4:
                return zziiu;
            case 5:
                zzemx<zzehd> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzehd.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziiu);
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
