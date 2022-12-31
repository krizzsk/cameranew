package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgv extends zzelb<zzgv, zza> implements zzemq {
    private static final zzgv zzaci;
    private static volatile zzemx<zzgv> zzek;
    private String zzacd = "";
    private String zzace = "";
    private long zzacf;
    private long zzacg;
    private long zzach;
    private int zzdv;

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzgv, zza> implements zzemq {
        private zza() {
            super(zzgv.zzaci);
        }

        public final zza zzav(String str) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzgv) this.zziqp).zzat(str);
            return this;
        }

        public final zza zzaw(String str) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzgv) this.zziqp).zzau(str);
            return this;
        }

        public final zza zzdj(long j2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzgv) this.zziqp).zzdg(j2);
            return this;
        }

        public final zza zzdk(long j2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzgv) this.zziqp).zzdh(j2);
            return this;
        }

        public final zza zzdl(long j2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzgv) this.zziqp).zzdi(j2);
            return this;
        }

        /* synthetic */ zza(zzgu zzguVar) {
            this();
        }
    }

    static {
        zzgv zzgvVar = new zzgv();
        zzaci = zzgvVar;
        zzelb.zza(zzgv.class, zzgvVar);
    }

    private zzgv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzat(String str) {
        str.getClass();
        this.zzdv |= 1;
        this.zzacd = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzau(String str) {
        str.getClass();
        this.zzdv |= 2;
        this.zzace = str;
    }

    public static zzgv zzb(zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (zzgv) zzelb.zza(zzaci, zzejrVar, zzekoVar);
    }

    public static zza zzdl() {
        return zzaci.zzbii();
    }

    public static zzgv zzdm() {
        return zzaci;
    }

    public static zzgv zzl(zzejr zzejrVar) throws zzelo {
        return (zzgv) zzelb.zza(zzaci, zzejrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzgu.zzel[i2 - 1]) {
            case 1:
                return new zzgv();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzaci, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzdv", "zzacd", "zzace", "zzacf", "zzacg", "zzach"});
            case 4:
                return zzaci;
            case 5:
                zzemx<zzgv> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzgv.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzaci);
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

    public final String zzdg() {
        return this.zzacd;
    }

    public final String zzdh() {
        return this.zzace;
    }

    public final long zzdi() {
        return this.zzacf;
    }

    public final long zzdj() {
        return this.zzacg;
    }

    public final long zzdk() {
        return this.zzach;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdg(long j2) {
        this.zzdv |= 4;
        this.zzacf = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdh(long j2) {
        this.zzdv |= 8;
        this.zzacg = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdi(long j2) {
        this.zzdv |= 16;
        this.zzach = j2;
    }
}
