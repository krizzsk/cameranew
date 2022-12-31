package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzehc extends zzelb<zzehc, zza> implements zzemq {
    private static volatile zzemx<zzehc> zzek;
    private static final zzehc zziit;
    private int zzidz;
    private zzejr zziea = zzejr.zzilz;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzehc, zza> implements zzemq {
        private zza() {
            super(zzehc.zziit);
        }

        public final zza zzah(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzehc) this.zziqp).zzs(zzejrVar);
            return this;
        }

        public final zza zzfs(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzehc) this.zziqp).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzehb zzehbVar) {
            this();
        }
    }

    static {
        zzehc zzehcVar = new zzehc();
        zziit = zzehcVar;
        zzelb.zza(zzehc.class, zzehcVar);
    }

    private zzehc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    public static zza zzbfm() {
        return zziit.zzbii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzejr zzejrVar) {
        zzejrVar.getClass();
        this.zziea = zzejrVar;
    }

    public static zzehc zzz(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzehc) zzelb.zza(zziit, zzejrVar, zzekoVar);
    }

    public final int getVersion() {
        return this.zzidz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzehb.zzel[i2 - 1]) {
            case 1:
                return new zzehc();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziit, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzidz", "zziea"});
            case 4:
                return zziit;
            case 5:
                zzemx<zzehc> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzehc.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziit);
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
}
