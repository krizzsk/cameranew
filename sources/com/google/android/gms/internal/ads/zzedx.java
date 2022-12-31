package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzedx extends zzelb<zzedx, zza> implements zzemq {
    private static volatile zzemx<zzedx> zzek;
    private static final zzedx zziec;
    private int zzidz;
    private zzejr zziea = zzejr.zzilz;
    private zzeeb zzieb;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzedx, zza> implements zzemq {
        private zza() {
            super(zzedx.zziec);
        }

        public final zza zzd(zzeeb zzeebVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzedx) this.zziqp).zzc(zzeebVar);
            return this;
        }

        public final zza zzew(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzedx) this.zziqp).setVersion(0);
            return this;
        }

        public final zza zzt(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzedx) this.zziqp).zzs(zzejrVar);
            return this;
        }

        /* synthetic */ zza(zzedw zzedwVar) {
            this();
        }
    }

    static {
        zzedx zzedxVar = new zzedx();
        zziec = zzedxVar;
        zzelb.zza(zzedx.class, zzedxVar);
    }

    private zzedx() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = 0;
    }

    public static zza zzbbg() {
        return zziec.zzbii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzeeb zzeebVar) {
        zzeebVar.getClass();
        this.zzieb = zzeebVar;
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
        switch (zzedw.zzel[i2 - 1]) {
            case 1:
                return new zzedx();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziec, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzidz", "zziea", "zzieb"});
            case 4:
                return zziec;
            case 5:
                zzemx<zzedx> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzedx.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziec);
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

    public final zzeeb zzbbf() {
        zzeeb zzeebVar = this.zzieb;
        return zzeebVar == null ? zzeeb.zzbbk() : zzeebVar;
    }

    public static zzedx zzc(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzedx) zzelb.zza(zziec, zzejrVar, zzekoVar);
    }
}
