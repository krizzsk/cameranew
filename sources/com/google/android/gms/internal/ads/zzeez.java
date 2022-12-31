package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeez extends zzelb<zzeez, zza> implements zzemq {
    private static volatile zzemx<zzeez> zzek;
    private static final zzeez zziez;
    private int zzidz;
    private int zzied;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeez, zza> implements zzemq {
        private zza() {
            super(zzeez.zziez);
        }

        /* synthetic */ zza(zzeey zzeeyVar) {
            this();
        }
    }

    static {
        zzeez zzeezVar = new zzeez();
        zziez = zzeezVar;
        zzelb.zza(zzeez.class, zzeezVar);
    }

    private zzeez() {
    }

    public static zzeez zzn(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzeez) zzelb.zza(zziez, zzejrVar, zzekoVar);
    }

    public final int getKeySize() {
        return this.zzied;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeey.zzel[i2 - 1]) {
            case 1:
                return new zzeez();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziez, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzidz", "zzied"});
            case 4:
                return zziez;
            case 5:
                zzemx<zzeez> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeez.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziez);
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
