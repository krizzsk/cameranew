package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzegt extends zzelb<zzegt, zza> implements zzemq {
    private static volatile zzemx<zzegt> zzek;
    private static final zzegt zziif;
    private int zzidz;
    private zzegw zziie;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzegt, zza> implements zzemq {
        private zza() {
            super(zzegt.zziif);
        }

        public final zza zzb(zzegw zzegwVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzegt) this.zziqp).zza(zzegwVar);
            return this;
        }

        public final zza zzfq(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzegt) this.zziqp).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzegu zzeguVar) {
            this();
        }
    }

    static {
        zzegt zzegtVar = new zzegt();
        zziif = zzegtVar;
        zzelb.zza(zzegt.class, zzegtVar);
    }

    private zzegt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i2) {
        this.zzidz = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzegw zzegwVar) {
        zzegwVar.getClass();
        this.zziie = zzegwVar;
    }

    public static zza zzbfd() {
        return zziif.zzbii();
    }

    public static zzegt zzx(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzegt) zzelb.zza(zziif, zzejrVar, zzekoVar);
    }

    public final int getVersion() {
        return this.zzidz;
    }

    public final zzegw zzbfc() {
        zzegw zzegwVar = this.zziie;
        return zzegwVar == null ? zzegw.zzbfh() : zzegwVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzegu.zzel[i2 - 1]) {
            case 1:
                return new zzegt();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zziif, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzidz", "zziie"});
            case 4:
                return zziif;
            case 5:
                zzemx<zzegt> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzegt.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zziif);
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
