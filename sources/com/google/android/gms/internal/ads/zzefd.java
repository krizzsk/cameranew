package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzefd extends zzelb<zzefd, zza> implements zzemq {
    private static volatile zzemx<zzefd> zzek;
    private static final zzefd zzifb;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzefd, zza> implements zzemq {
        private zza() {
            super(zzefd.zzifb);
        }

        /* synthetic */ zza(zzefc zzefcVar) {
            this();
        }
    }

    static {
        zzefd zzefdVar = new zzefd();
        zzifb = zzefdVar;
        zzelb.zza(zzefd.class, zzefdVar);
    }

    private zzefd() {
    }

    public static zzefd zzp(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzefd) zzelb.zza(zzifb, zzejrVar, zzekoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzefc.zzel[i2 - 1]) {
            case 1:
                return new zzefd();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzifb, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzifb;
            case 5:
                zzemx<zzefd> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzefd.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzifb);
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
