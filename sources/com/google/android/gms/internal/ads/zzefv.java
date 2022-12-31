package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzefv extends zzelb<zzefv, zza> implements zzemq {
    private static volatile zzemx<zzefv> zzek;
    private static final zzefv zzigo;
    private int zzidz;
    private zzejr zziea = zzejr.zzilz;
    private zzega zzign;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzefv, zza> implements zzemq {
        private zza() {
            super(zzefv.zzigo);
        }

        public final zza zzae(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefv) this.zziqp).zzs(zzejrVar);
            return this;
        }

        public final zza zzd(zzega zzegaVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefv) this.zziqp).zzc(zzegaVar);
            return this;
        }

        public final zza zzfi(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefv) this.zziqp).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzefx zzefxVar) {
            this();
        }
    }

    static {
        zzefv zzefvVar = new zzefv();
        zzigo = zzefvVar;
        zzelb.zza(zzefv.class, zzefvVar);
    }

    private zzefv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    public static zza zzbdp() {
        return zzigo.zzbii();
    }

    public static zzefv zzbdq() {
        return zzigo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzega zzegaVar) {
        zzegaVar.getClass();
        this.zzign = zzegaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzejr zzejrVar) {
        zzejrVar.getClass();
        this.zziea = zzejrVar;
    }

    public static zzefv zzt(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzefv) zzelb.zza(zzigo, zzejrVar, zzekoVar);
    }

    public final int getVersion() {
        return this.zzidz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzefx.zzel[i2 - 1]) {
            case 1:
                return new zzefv();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzigo, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzidz", "zzign", "zziea"});
            case 4:
                return zzigo;
            case 5:
                zzemx<zzefv> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzefv.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzigo);
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

    public final zzejr zzbbe() {
        return this.zziea;
    }

    public final zzega zzbdo() {
        zzega zzegaVar = this.zzign;
        return zzegaVar == null ? zzega.zzbdv() : zzegaVar;
    }
}
