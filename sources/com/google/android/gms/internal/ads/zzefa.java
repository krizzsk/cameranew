package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzefa extends zzelb<zzefa, zza> implements zzemq {
    private static volatile zzemx<zzefa> zzek;
    private static final zzefa zzifa;
    private int zzidz;
    private zzejr zziea = zzejr.zzilz;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzefa, zza> implements zzemq {
        private zza() {
            super(zzefa.zzifa);
        }

        public final zza zzfc(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefa) this.zziqp).setVersion(0);
            return this;
        }

        public final zza zzy(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzefa) this.zziqp).zzs(zzejrVar);
            return this;
        }

        /* synthetic */ zza(zzefb zzefbVar) {
            this();
        }
    }

    static {
        zzefa zzefaVar = new zzefa();
        zzifa = zzefaVar;
        zzelb.zza(zzefa.class, zzefaVar);
    }

    private zzefa() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    public static zza zzbco() {
        return zzifa.zzbii();
    }

    public static zzefa zzo(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzefa) zzelb.zza(zzifa, zzejrVar, zzekoVar);
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
        switch (zzefb.zzel[i2 - 1]) {
            case 1:
                return new zzefa();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzifa, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzidz", "zziea"});
            case 4:
                return zzifa;
            case 5:
                zzemx<zzefa> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzefa.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzifa);
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
