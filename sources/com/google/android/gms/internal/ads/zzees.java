package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzees extends zzelb<zzees, zza> implements zzemq {
    private static volatile zzemx<zzees> zzek;
    private static final zzees zziew;
    private int zzidz;
    private zzejr zziea = zzejr.zzilz;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzees, zza> implements zzemq {
        private zza() {
            super(zzees.zziew);
        }

        public final zza zzfa(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzees) this.zziqp).setVersion(0);
            return this;
        }

        public final zza zzw(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzees) this.zziqp).zzs(zzejrVar);
            return this;
        }

        /* synthetic */ zza(zzeet zzeetVar) {
            this();
        }
    }

    static {
        zzees zzeesVar = new zzees();
        zziew = zzeesVar;
        zzelb.zza(zzees.class, zzeesVar);
    }

    private zzees() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    public static zza zzbci() {
        return zziew.zzbii();
    }

    public static zzees zzk(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzees) zzelb.zza(zziew, zzejrVar, zzekoVar);
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
        switch (zzeet.zzel[i2 - 1]) {
            case 1:
                return new zzees();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziew, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzidz", "zziea"});
            case 4:
                return zziew;
            case 5:
                zzemx<zzees> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzees.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziew);
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
