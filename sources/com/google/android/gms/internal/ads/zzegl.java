package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzegl extends zzelb<zzegl, zza> implements zzemq {
    private static volatile zzemx<zzegl> zzek;
    private static final zzegl zzihs;
    private int zzihq;
    private zzell<zzb> zzihr = zzelb.zzbin();

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb.zzb<zzegl, zza> implements zzemq {
        private zza() {
            super(zzegl.zzihs);
        }

        /* synthetic */ zza(zzegm zzegmVar) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzb extends zzelb<zzb, zza> implements zzemq {
        private static volatile zzemx<zzb> zzek;
        private static final zzb zzihw;
        private int zzihj;
        private zzegd zziht;
        private int zzihu;
        private int zzihv;

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zza extends zzelb.zzb<zzb, zza> implements zzemq {
            private zza() {
                super(zzb.zzihw);
            }

            /* synthetic */ zza(zzegm zzegmVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzihw = zzbVar;
            zzelb.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzegm.zzel[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzelb.zza(zzihw, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zziht", "zzihu", "zzihv", "zzihj"});
                case 4:
                    return zzihw;
                case 5:
                    zzemx<zzb> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zzb.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzihw);
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

        public final zzege zzbau() {
            zzege zzfk = zzege.zzfk(this.zzihu);
            return zzfk == null ? zzege.UNRECOGNIZED : zzfk;
        }

        public final zzegx zzbav() {
            zzegx zzfr = zzegx.zzfr(this.zzihj);
            return zzfr == null ? zzegx.UNRECOGNIZED : zzfr;
        }

        public final boolean zzbeo() {
            return this.zziht != null;
        }

        public final zzegd zzbep() {
            zzegd zzegdVar = this.zziht;
            return zzegdVar == null ? zzegd.zzbeb() : zzegdVar;
        }

        public final int zzbeq() {
            return this.zzihv;
        }
    }

    static {
        zzegl zzeglVar = new zzegl();
        zzihs = zzeglVar;
        zzelb.zza(zzegl.class, zzeglVar);
    }

    private zzegl() {
    }

    public static zzegl zzc(byte[] bArr, zzeko zzekoVar) throws zzelo {
        return (zzegl) zzelb.zza(zzihs, bArr, zzekoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzegm.zzel[i2 - 1]) {
            case 1:
                return new zzegl();
            case 2:
                return new zza(null);
            case 3:
                return zzelb.zza(zzihs, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzihq", "zzihr", zzb.class});
            case 4:
                return zzihs;
            case 5:
                zzemx<zzegl> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzegl.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzihs);
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

    public final int zzbek() {
        return this.zzihq;
    }

    public final List<zzb> zzbel() {
        return this.zzihr;
    }

    public final int zzbem() {
        return this.zzihr.size();
    }
}
