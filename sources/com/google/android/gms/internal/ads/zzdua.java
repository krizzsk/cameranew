package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdtt;
import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdua extends zzelb<zzdua, zzb> implements zzemq {
    private static volatile zzemx<zzdua> zzek;
    private static final zzdua zzhts;
    private int zzdv;
    private int zzhtp;
    private zzdtt zzhtr;
    private String zzdw = "";
    private String zzhtq = "";

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public enum zza implements zzelg {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);
        
        private static final zzelf<zza> zzes = new zzduc();
        private final int value;

        zza(int i2) {
            this.value = i2;
        }

        public static zza zzei(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return null;
                }
                return BLOCKED_IMPRESSION;
            }
            return EVENT_TYPE_UNKNOWN;
        }

        public static zzeli zzw() {
            return zzdub.zzeu;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.ads.zzelg
        public final int zzv() {
            return this.value;
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzb extends zzelb.zzb<zzdua, zzb> implements zzemq {
        private zzb() {
            super(zzdua.zzhts);
        }

        public final zzb zza(zzdtt.zzb zzbVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzdua) this.zziqp).zza((zzdtt) ((zzelb) zzbVar.zzbiw()));
            return this;
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzdua) this.zziqp).zza(zzaVar);
            return this;
        }

        public final zzb zzhi(String str) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzdua) this.zziqp).zzj(str);
            return this;
        }

        /* synthetic */ zzb(zzdtz zzdtzVar) {
            this();
        }
    }

    static {
        zzdua zzduaVar = new zzdua();
        zzhts = zzduaVar;
        zzelb.zza(zzdua.class, zzduaVar);
    }

    private zzdua() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        this.zzhtp = zzaVar.zzv();
        this.zzdv |= 1;
    }

    public static zzb zzayc() {
        return zzhts.zzbii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(String str) {
        str.getClass();
        this.zzdv |= 2;
        this.zzdw = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdtt zzdttVar) {
        zzdttVar.getClass();
        this.zzhtr = zzdttVar;
        this.zzdv |= 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzdtz.zzel[i2 - 1]) {
            case 1:
                return new zzdua();
            case 2:
                return new zzb(null);
            case 3:
                return zzelb.zza(zzhts, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzdv", "zzhtp", zza.zzw(), "zzdw", "zzhtq", "zzhtr"});
            case 4:
                return zzhts;
            case 5:
                zzemx<zzdua> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzdua.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzhts);
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
