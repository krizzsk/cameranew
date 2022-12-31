package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzefk extends zzelb<zzefk, zza> implements zzemq {
    private static volatile zzemx<zzefk> zzek;
    private static final zzefk zzifp;
    private zzefr zzifm;
    private zzeff zzifn;
    private int zzifo;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzefk, zza> implements zzemq {
        private zza() {
            super(zzefk.zzifp);
        }

        /* synthetic */ zza(zzefl zzeflVar) {
            this();
        }
    }

    static {
        zzefk zzefkVar = new zzefk();
        zzifp = zzefkVar;
        zzelb.zza(zzefk.class, zzefkVar);
    }

    private zzefk() {
    }

    public static zzefk zzbcz() {
        return zzifp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzefl.zzel[i2 - 1]) {
            case 1:
                return new zzefk();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzifp, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzifm", "zzifn", "zzifo"});
            case 4:
                return zzifp;
            case 5:
                zzemx<zzefk> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzefk.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzifp);
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

    public final zzefr zzbcw() {
        zzefr zzefrVar = this.zzifm;
        return zzefrVar == null ? zzefr.zzbdm() : zzefrVar;
    }

    public final zzeff zzbcx() {
        zzeff zzeffVar = this.zzifn;
        return zzeffVar == null ? zzeff.zzbcs() : zzeffVar;
    }

    public final zzefe zzbcy() {
        zzefe zzfd = zzefe.zzfd(this.zzifo);
        return zzfd == null ? zzefe.UNRECOGNIZED : zzfd;
    }
}
