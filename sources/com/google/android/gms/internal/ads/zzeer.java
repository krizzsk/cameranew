package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeer extends zzelb<zzeer, zza> implements zzemq {
    private static volatile zzemx<zzeer> zzek;
    private static final zzeer zziev;
    private int zzieq;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeer, zza> implements zzemq {
        private zza() {
            super(zzeer.zziev);
        }

        /* synthetic */ zza(zzeeq zzeeqVar) {
            this();
        }
    }

    static {
        zzeer zzeerVar = new zzeer();
        zziev = zzeerVar;
        zzelb.zza(zzeer.class, zzeerVar);
    }

    private zzeer() {
    }

    public static zzeer zzbcg() {
        return zziev;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeeq.zzel[i2 - 1]) {
            case 1:
                return new zzeer();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziev, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzieq"});
            case 4:
                return zziev;
            case 5:
                zzemx<zzeer> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeer.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziev);
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

    public final int zzbbz() {
        return this.zzieq;
    }
}
