package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzefo extends zzelb<zzefo, zza> implements zzemq {
    private static volatile zzemx<zzefo> zzek;
    private static final zzefo zzifu;
    private int zzidz;
    private zzefk zzifk;
    private zzejr zzifs;
    private zzejr zzift;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzefo, zza> implements zzemq {
        private zza() {
            super(zzefo.zzifu);
        }

        public final zza zzac(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefo) this.zziqp).zzz(zzejrVar);
            return this;
        }

        public final zza zzad(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefo) this.zziqp).zzaa(zzejrVar);
            return this;
        }

        public final zza zzc(zzefk zzefkVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefo) this.zziqp).zzb(zzefkVar);
            return this;
        }

        public final zza zzff(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefo) this.zziqp).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzefp zzefpVar) {
            this();
        }
    }

    static {
        zzefo zzefoVar = new zzefo();
        zzifu = zzefoVar;
        zzelb.zza(zzefo.class, zzefoVar);
    }

    private zzefo() {
        zzejr zzejrVar = zzejr.zzilz;
        this.zzifs = zzejrVar;
        this.zzift = zzejrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(zzejr zzejrVar) {
        zzejrVar.getClass();
        this.zzift = zzejrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzefk zzefkVar) {
        zzefkVar.getClass();
        this.zzifk = zzefkVar;
    }

    public static zza zzbdg() {
        return zzifu.zzbii();
    }

    public static zzefo zzbdh() {
        return zzifu;
    }

    public static zzefo zzs(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzefo) zzelb.zza(zzifu, zzejrVar, zzekoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzz(zzejr zzejrVar) {
        zzejrVar.getClass();
        this.zzifs = zzejrVar;
    }

    public final int getVersion() {
        return this.zzidz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzefp.zzel[i2 - 1]) {
            case 1:
                return new zzefo();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzifu, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzidz", "zzifk", "zzifs", "zzift"});
            case 4:
                return zzifu;
            case 5:
                zzemx<zzefo> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzefo.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzifu);
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

    public final zzefk zzbcu() {
        zzefk zzefkVar = this.zzifk;
        return zzefkVar == null ? zzefk.zzbcz() : zzefkVar;
    }

    public final zzejr zzbde() {
        return this.zzifs;
    }

    public final zzejr zzbdf() {
        return this.zzift;
    }
}
