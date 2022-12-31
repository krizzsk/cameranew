package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeew extends zzelb<zzeew, zza> implements zzemq {
    private static volatile zzemx<zzeew> zzek;
    private static final zzeew zziey;
    private int zzidz;
    private zzejr zziea = zzejr.zzilz;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzeew, zza> implements zzemq {
        private zza() {
            super(zzeew.zziey);
        }

        public final zza zzfb(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeew) this.zziqp).setVersion(0);
            return this;
        }

        public final zza zzx(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzeew) this.zziqp).zzs(zzejrVar);
            return this;
        }

        /* synthetic */ zza(zzeex zzeexVar) {
            this();
        }
    }

    static {
        zzeew zzeewVar = new zzeew();
        zziey = zzeewVar;
        zzelb.zza(zzeew.class, zzeewVar);
    }

    private zzeew() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    public static zza zzbcl() {
        return zziey.zzbii();
    }

    public static zzeew zzm(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzeew) zzelb.zza(zziey, zzejrVar, zzekoVar);
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
        switch (zzeex.zzel[i2 - 1]) {
            case 1:
                return new zzeew();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziey, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzidz", "zziea"});
            case 4:
                return zziey;
            case 5:
                zzemx<zzeew> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzeew.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziey);
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
