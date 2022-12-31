package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeec extends zzelb<zzeec, zza> implements zzemq {
    private static volatile zzemx<zzeec> zzek;
    private static final zzeec zziej;
    private int zzidz;
    private zzeeg zzieh;
    private zzefv zziei;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeec, zza> implements zzemq {
        private zza() {
            super(zzeec.zziej);
        }

        public final zza zzc(zzeeg zzeegVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeec) this.zziqp).zzb(zzeegVar);
            return this;
        }

        public final zza zzex(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeec) this.zziqp).setVersion(i2);
            return this;
        }

        /* synthetic */ zza(zzeed zzeedVar) {
            this();
        }

        public final zza zzc(zzefv zzefvVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeec) this.zziqp).zzb(zzefvVar);
            return this;
        }
    }

    static {
        zzeec zzeecVar = new zzeec();
        zziej = zzeecVar;
        zzelb.zza(zzeec.class, zzeecVar);
    }

    private zzeec() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzeeg zzeegVar) {
        zzeegVar.getClass();
        this.zzieh = zzeegVar;
    }

    public static zza zzbbo() {
        return zziej.zzbii();
    }

    public static zzeec zze(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzeec) zzelb.zza(zziej, zzejrVar, zzekoVar);
    }

    public final int getVersion() {
        return this.zzidz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeed.zzel[i2 - 1]) {
            case 1:
                return new zzeec();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziej, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzidz", "zzieh", "zziei"});
            case 4:
                return zziej;
            case 5:
                zzemx<zzeec> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeec.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziej);
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

    public final zzeeg zzbbm() {
        zzeeg zzeegVar = this.zzieh;
        return zzeegVar == null ? zzeeg.zzbbv() : zzeegVar;
    }

    public final zzefv zzbbn() {
        zzefv zzefvVar = this.zziei;
        return zzefvVar == null ? zzefv.zzbdq() : zzefvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzefv zzefvVar) {
        zzefvVar.getClass();
        this.zziei = zzefvVar;
    }
}
