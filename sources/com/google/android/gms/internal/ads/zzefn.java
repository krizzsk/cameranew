package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzefn extends zzelb<zzefn, zza> implements zzemq {
    private static volatile zzemx<zzefn> zzek;
    private static final zzefn zzifr;
    private int zzidz;
    private zzejr zziea = zzejr.zzilz;
    private zzefo zzifq;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzefn, zza> implements zzemq {
        private zza() {
            super(zzefn.zzifr);
        }

        public final zza zzab(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefn) this.zziqp).zzs(zzejrVar);
            return this;
        }

        public final zza zzb(zzefo zzefoVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefn) this.zziqp).zza(zzefoVar);
            return this;
        }

        public final zza zzfe(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefn) this.zziqp).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzefm zzefmVar) {
            this();
        }
    }

    static {
        zzefn zzefnVar = new zzefn();
        zzifr = zzefnVar;
        zzelb.zza(zzefn.class, zzefnVar);
    }

    private zzefn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzefo zzefoVar) {
        zzefoVar.getClass();
        this.zzifq = zzefoVar;
    }

    public static zza zzbdc() {
        return zzifr.zzbii();
    }

    public static zzefn zzr(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzefn) zzelb.zza(zzifr, zzejrVar, zzekoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzejr zzejrVar) {
        zzejrVar.getClass();
        this.zziea = zzejrVar;
    }

    public final int getVersion() {
        return this.zzidz;
    }

    public final zzejr zzbbe() {
        return this.zziea;
    }

    public final zzefo zzbdb() {
        zzefo zzefoVar = this.zzifq;
        return zzefoVar == null ? zzefo.zzbdh() : zzefoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzefm.zzel[i2 - 1]) {
            case 1:
                return new zzefn();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzifr, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzidz", "zzifq", "zziea"});
            case 4:
                return zzifr;
            case 5:
                zzemx<zzefn> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzefn.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzifr);
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
