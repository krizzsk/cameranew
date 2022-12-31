package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzegp extends zzelb<zzegp, zza> implements zzemq {
    private static volatile zzemx<zzegp> zzek;
    private static final zzegp zziib;
    private int zzidz;
    private zzegs zziia;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzegp, zza> implements zzemq {
        private zza() {
            super(zzegp.zziib);
        }

        public final zza zzb(zzegs zzegsVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzegp) this.zziqp).zza(zzegsVar);
            return this;
        }

        public final zza zzfp(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzegp) this.zziqp).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzegq zzegqVar) {
            this();
        }
    }

    static {
        zzegp zzegpVar = new zzegp();
        zziib = zzegpVar;
        zzelb.zza(zzegp.class, zzegpVar);
    }

    private zzegp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzegs zzegsVar) {
        zzegsVar.getClass();
        this.zziia = zzegsVar;
    }

    public static zza zzbex() {
        return zziib.zzbii();
    }

    public static zzegp zzv(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzegp) zzelb.zza(zziib, zzejrVar, zzekoVar);
    }

    public final int getVersion() {
        return this.zzidz;
    }

    public final zzegs zzbew() {
        zzegs zzegsVar = this.zziia;
        return zzegsVar == null ? zzegs.zzbfa() : zzegsVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzegq.zzel[i2 - 1]) {
            case 1:
                return new zzegp();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziib, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzidz", "zziia"});
            case 4:
                return zziib;
            case 5:
                zzemx<zzegp> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzegp.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziib);
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
