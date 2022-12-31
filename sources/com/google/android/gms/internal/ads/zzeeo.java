package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeeo extends zzelb<zzeeo, zza> implements zzemq {
    private static volatile zzemx<zzeeo> zzek;
    private static final zzeeo zzieu;
    private int zzied;
    private zzeer zzies;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeeo, zza> implements zzemq {
        private zza() {
            super(zzeeo.zzieu);
        }

        /* synthetic */ zza(zzeep zzeepVar) {
            this();
        }
    }

    static {
        zzeeo zzeeoVar = new zzeeo();
        zzieu = zzeeoVar;
        zzelb.zza(zzeeo.class, zzeeoVar);
    }

    private zzeeo() {
    }

    public static zzeeo zzj(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzeeo) zzelb.zza(zzieu, zzejrVar, zzekoVar);
    }

    public final int getKeySize() {
        return this.zzied;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeep.zzel[i2 - 1]) {
            case 1:
                return new zzeeo();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzieu, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzies", "zzied"});
            case 4:
                return zzieu;
            case 5:
                zzemx<zzeeo> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeeo.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzieu);
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

    public final zzeer zzbcc() {
        zzeer zzeerVar = this.zzies;
        return zzeerVar == null ? zzeer.zzbcg() : zzeerVar;
    }
}
