package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzegw extends zzelb<zzegw, zza> implements zzemq {
    private static volatile zzemx<zzegw> zzek;
    private static final zzegw zziii;
    private String zziig = "";
    private zzegg zziih;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzegw, zza> implements zzemq {
        private zza() {
            super(zzegw.zziii);
        }

        /* synthetic */ zza(zzegv zzegvVar) {
            this();
        }
    }

    static {
        zzegw zzegwVar = new zzegw();
        zziii = zzegwVar;
        zzelb.zza(zzegw.class, zzegwVar);
    }

    private zzegw() {
    }

    public static zzegw zzbfh() {
        return zziii;
    }

    public static zzegw zzy(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzegw) zzelb.zza(zziii, zzejrVar, zzekoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzegv.zzel[i2 - 1]) {
            case 1:
                return new zzegw();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziii, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zziig", "zziih"});
            case 4:
                return zziii;
            case 5:
                zzemx<zzegw> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzegw.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziii);
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

    public final String zzbff() {
        return this.zziig;
    }

    public final zzegg zzbfg() {
        zzegg zzeggVar = this.zziih;
        return zzeggVar == null ? zzegg.zzbed() : zzeggVar;
    }
}
