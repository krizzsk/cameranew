package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzegd extends zzelb<zzegd, zzb> implements zzemq {
    private static volatile zzemx<zzegd> zzek;
    private static final zzegd zzigv;
    private String zzigs = "";
    private zzejr zzigt = zzejr.zzilz;
    private int zzigu;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public enum zza implements zzelg {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzelf<zza> zzes = new zzegf();
        private final int value;

        zza(int i2) {
            this.value = i2;
        }

        public static zza zzfj(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                return null;
                            }
                            return REMOTE;
                        }
                        return ASYMMETRIC_PUBLIC;
                    }
                    return ASYMMETRIC_PRIVATE;
                }
                return SYMMETRIC;
            }
            return UNKNOWN_KEYMATERIAL;
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zza.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzv());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        @Override // com.google.android.gms.internal.ads.zzelg
        public final int zzv() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzb extends zzelb.zzb<zzegd, zzb> implements zzemq {
        private zzb() {
            super(zzegd.zzigv);
        }

        public final zzb zzag(zzejr zzejrVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzegd) this.zziqp).zzaf(zzejrVar);
            return this;
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzegd) this.zziqp).zza(zzaVar);
            return this;
        }

        public final zzb zzhu(String str) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzegd) this.zziqp).zzht(str);
            return this;
        }

        /* synthetic */ zzb(zzegc zzegcVar) {
            this();
        }
    }

    static {
        zzegd zzegdVar = new zzegd();
        zzigv = zzegdVar;
        zzelb.zza(zzegd.class, zzegdVar);
    }

    private zzegd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        this.zzigu = zzaVar.zzv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaf(zzejr zzejrVar) {
        zzejrVar.getClass();
        this.zzigt = zzejrVar;
    }

    public static zzb zzbea() {
        return zzigv.zzbii();
    }

    public static zzegd zzbeb() {
        return zzigv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzht(String str) {
        str.getClass();
        this.zzigs = str;
    }

    public final String zzbdx() {
        return this.zzigs;
    }

    public final zzejr zzbdy() {
        return this.zzigt;
    }

    public final zza zzbdz() {
        zza zzfj = zza.zzfj(this.zzigu);
        return zzfj == null ? zza.UNRECOGNIZED : zzfj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzegc.zzel[i2 - 1]) {
            case 1:
                return new zzegd();
            case 2:
                return new zzb(null);
            case 3:
                return zzelb.zza(zzigv, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzigs", "zzigt", "zzigu"});
            case 4:
                return zzigv;
            case 5:
                zzemx<zzegd> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzegd.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzigv);
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
