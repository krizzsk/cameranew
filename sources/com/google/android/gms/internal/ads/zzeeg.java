package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeeg extends zzelb<zzeeg, zza> implements zzemq {
    private static volatile zzemx<zzeeg> zzek;
    private static final zzeeg zzieo;
    private int zzidz;
    private zzejr zziea = zzejr.zzilz;
    private zzeek zzien;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeeg, zza> implements zzemq {
        private zza() {
            super(zzeeg.zzieo);
        }

        public final zza zzc(zzeek zzeekVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeeg) this.zziqp).zzb(zzeekVar);
            return this;
        }

        public final zza zzey(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeeg) this.zziqp).setVersion(0);
            return this;
        }

        public final zza zzu(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeeg) this.zziqp).zzs(zzejrVar);
            return this;
        }

        /* synthetic */ zza(zzeeh zzeehVar) {
            this();
        }
    }

    static {
        zzeeg zzeegVar = new zzeeg();
        zzieo = zzeegVar;
        zzelb.zza(zzeeg.class, zzeegVar);
    }

    private zzeeg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzeek zzeekVar) {
        zzeekVar.getClass();
        this.zzien = zzeekVar;
    }

    public static zza zzbbu() {
        return zzieo.zzbii();
    }

    public static zzeeg zzbbv() {
        return zzieo;
    }

    public static zzeeg zzg(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzeeg) zzelb.zza(zzieo, zzejrVar, zzekoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzejr zzejrVar) {
        zzejrVar.getClass();
        this.zziea = zzejrVar;
    }

    public final int getVersion() {
        return this.zzidz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeeh.zzel[i2 - 1]) {
            case 1:
                return new zzeeg();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzieo, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzidz", "zzien", "zziea"});
            case 4:
                return zzieo;
            case 5:
                zzemx<zzeeg> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeeg.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzieo);
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

    public final zzeek zzbbt() {
        zzeek zzeekVar = this.zzien;
        return zzeekVar == null ? zzeek.zzbca() : zzeekVar;
    }
}
