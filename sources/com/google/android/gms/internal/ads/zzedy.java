package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzedy extends zzelb<zzedy, zza> implements zzemq {
    private static volatile zzemx<zzedy> zzek;
    private static final zzedy zziee;
    private zzeeb zzieb;
    private int zzied;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzedy, zza> implements zzemq {
        private zza() {
            super(zzedy.zziee);
        }

        /* synthetic */ zza(zzedz zzedzVar) {
            this();
        }
    }

    static {
        zzedy zzedyVar = new zzedy();
        zziee = zzedyVar;
        zzelb.zza(zzedy.class, zzedyVar);
    }

    private zzedy() {
    }

    public static zzedy zzd(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzedy) zzelb.zza(zziee, zzejrVar, zzekoVar);
    }

    public final int getKeySize() {
        return this.zzied;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzedz.zzel[i2 - 1]) {
            case 1:
                return new zzedy();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziee, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzied", "zzieb"});
            case 4:
                return zziee;
            case 5:
                zzemx<zzedy> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzedy.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziee);
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

    public final zzeeb zzbbf() {
        zzeeb zzeebVar = this.zzieb;
        return zzeebVar == null ? zzeeb.zzbbk() : zzeebVar;
    }
}
