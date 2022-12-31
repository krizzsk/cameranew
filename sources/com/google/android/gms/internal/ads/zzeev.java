package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeev extends zzelb<zzeev, zza> implements zzemq {
    private static volatile zzemx<zzeev> zzek;
    private static final zzeev zziex;
    private int zzidz;
    private int zzied;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeev, zza> implements zzemq {
        private zza() {
            super(zzeev.zziex);
        }

        /* synthetic */ zza(zzeeu zzeeuVar) {
            this();
        }
    }

    static {
        zzeev zzeevVar = new zzeev();
        zziex = zzeevVar;
        zzelb.zza(zzeev.class, zzeevVar);
    }

    private zzeev() {
    }

    public static zzeev zzl(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzeev) zzelb.zza(zziex, zzejrVar, zzekoVar);
    }

    public final int getKeySize() {
        return this.zzied;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeeu.zzel[i2 - 1]) {
            case 1:
                return new zzeev();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziex, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzied", "zzidz"});
            case 4:
                return zziex;
            case 5:
                zzemx<zzeev> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeev.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziex);
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
