package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdtt extends zzelb<zzdtt, zzb> implements zzemq {
    private static volatile zzemx<zzdtt> zzek;
    private static final zzelj<Integer, zza> zzhth = new zzdtw();
    private static final zzdtt zzhtl;
    private int zzdv;
    private zzelh zzhtg = zzelb.zzbil();
    private String zzhti = "";
    private String zzhtj = "";
    private String zzhtk = "";

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public enum zza implements zzelg {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        
        private static final zzelf<zza> zzes = new zzdtx();
        private final int value;

        zza(int i2) {
            this.value = i2;
        }

        public static zza zzeh(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return BLOCKED_REASON_BACKGROUND;
            }
            return BLOCKED_REASON_UNKNOWN;
        }

        public static zzeli zzw() {
            return zzdty.zzeu;
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
    public static final class zzb extends zzelb.zzb<zzdtt, zzb> implements zzemq {
        private zzb() {
            super(zzdtt.zzhtl);
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzdtt) this.zziqp).zza(zzaVar);
            return this;
        }

        public final zzb zzhh(String str) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzdtt) this.zziqp).zzhg(str);
            return this;
        }

        /* synthetic */ zzb(zzdtw zzdtwVar) {
            this();
        }
    }

    static {
        zzdtt zzdttVar = new zzdtt();
        zzhtl = zzdttVar;
        zzelb.zza(zzdtt.class, zzdttVar);
    }

    private zzdtt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        zzaVar.getClass();
        zzelh zzelhVar = this.zzhtg;
        if (!zzelhVar.zzbge()) {
            this.zzhtg = zzelb.zza(zzelhVar);
        }
        this.zzhtg.zzhh(zzaVar.zzv());
    }

    public static zzb zzaya() {
        return zzhtl.zzbii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzhg(String str) {
        str.getClass();
        this.zzdv |= 1;
        this.zzhti = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzdtv.zzel[i2 - 1]) {
            case 1:
                return new zzdtt();
            case 2:
                return new zzb(null);
            case 3:
                return zzelb.zza(zzhtl, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzdv", "zzhtg", zza.zzw(), "zzhti", "zzhtj", "zzhtk"});
            case 4:
                return zzhtl;
            case 5:
                zzemx<zzdtt> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzdtt.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzhtl);
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
