package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeen extends zzelb<zzeen, zza> implements zzemq {
    private static volatile zzemx<zzeen> zzek;
    private static final zzeen zziet;
    private int zzidz;
    private zzejr zziea = zzejr.zzilz;
    private zzeer zzies;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeen, zza> implements zzemq {
        private zza() {
            super(zzeen.zziet);
        }

        public final zza zzb(zzeer zzeerVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeen) this.zziqp).zza(zzeerVar);
            return this;
        }

        public final zza zzez(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeen) this.zziqp).setVersion(0);
            return this;
        }

        public final zza zzv(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeen) this.zziqp).zzs(zzejrVar);
            return this;
        }

        /* synthetic */ zza(zzeem zzeemVar) {
            this();
        }
    }

    static {
        zzeen zzeenVar = new zzeen();
        zziet = zzeenVar;
        zzelb.zza(zzeen.class, zzeenVar);
    }

    private zzeen() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzeer zzeerVar) {
        zzeerVar.getClass();
        this.zzies = zzeerVar;
    }

    public static zza zzbcd() {
        return zziet.zzbii();
    }

    public static zzeen zzi(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzeen) zzelb.zza(zziet, zzejrVar, zzekoVar);
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

    public final zzeer zzbcc() {
        zzeer zzeerVar = this.zzies;
        return zzeerVar == null ? zzeer.zzbcg() : zzeerVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzeem.zzel[i2 - 1]) {
            case 1:
                return new zzeen();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziet, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzidz", "zzies", "zziea"});
            case 4:
                return zziet;
            case 5:
                zzemx<zzeen> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeen.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziet);
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
