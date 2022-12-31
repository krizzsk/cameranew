package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeff extends zzelb<zzeff, zza> implements zzemq {
    private static volatile zzemx<zzeff> zzek;
    private static final zzeff zzifj;
    private zzegg zzifi;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeff, zza> implements zzemq {
        private zza() {
            super(zzeff.zzifj);
        }

        /* synthetic */ zza(zzefh zzefhVar) {
            this();
        }
    }

    static {
        zzeff zzeffVar = new zzeff();
        zzifj = zzeffVar;
        zzelb.zza(zzeff.class, zzeffVar);
    }

    private zzeff() {
    }

    public static zzeff zzbcs() {
        return zzifj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzefh.zzel[i2 - 1]) {
            case 1:
                return new zzeff();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzifj, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzifi"});
            case 4:
                return zzifj;
            case 5:
                zzemx<zzeff> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeff.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzifj);
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

    public final zzegg zzbcr() {
        zzegg zzeggVar = this.zzifi;
        return zzeggVar == null ? zzegg.zzbed() : zzeggVar;
    }
}
