package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeeb extends zzelb<zzeeb, zza> implements zzemq {
    private static volatile zzemx<zzeeb> zzek;
    private static final zzeeb zzieg;
    private int zzief;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeeb, zza> implements zzemq {
        private zza() {
            super(zzeeb.zzieg);
        }

        /* synthetic */ zza(zzeea zzeeaVar) {
            this();
        }
    }

    static {
        zzeeb zzeebVar = new zzeeb();
        zzieg = zzeebVar;
        zzelb.zza(zzeeb.class, zzeebVar);
    }

    private zzeeb() {
    }

    public static zzeeb zzbbk() {
        return zzieg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeea.zzel[i2 - 1]) {
            case 1:
                return new zzeeb();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzieg, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzief"});
            case 4:
                return zzieg;
            case 5:
                zzemx<zzeeb> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeeb.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzieg);
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
}
