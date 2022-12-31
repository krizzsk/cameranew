package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeej extends zzelb<zzeej, zza> implements zzemq {
    private static volatile zzemx<zzeej> zzek;
    private static final zzeej zziep;
    private int zzied;
    private zzeek zzien;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeej, zza> implements zzemq {
        private zza() {
            super(zzeej.zziep);
        }

        /* synthetic */ zza(zzeei zzeeiVar) {
            this();
        }
    }

    static {
        zzeej zzeejVar = new zzeej();
        zziep = zzeejVar;
        zzelb.zza(zzeej.class, zzeejVar);
    }

    private zzeej() {
    }

    public static zzeej zzbbx() {
        return zziep;
    }

    public static zzeej zzh(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzeej) zzelb.zza(zziep, zzejrVar, zzekoVar);
    }

    public final int getKeySize() {
        return this.zzied;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeei.zzel[i2 - 1]) {
            case 1:
                return new zzeej();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziep, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzien", "zzied"});
            case 4:
                return zziep;
            case 5:
                zzemx<zzeej> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeej.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziep);
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

    public final zzeek zzbbt() {
        zzeek zzeekVar = this.zzien;
        return zzeekVar == null ? zzeek.zzbca() : zzeekVar;
    }
}
