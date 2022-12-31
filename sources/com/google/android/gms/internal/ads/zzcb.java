package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcb {

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb<zza, C0144zza> implements zzemq {
        private static volatile zzemx<zza> zzek;
        private static final zza zzex;
        private int zzdv;
        private zzb zzev;
        private zzc zzew;

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzcb$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0144zza extends zzelb.zzb<zza, C0144zza> implements zzemq {
            private C0144zza() {
                super(zza.zzex);
            }

            /* synthetic */ C0144zza(zzca zzcaVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzex = zzaVar;
            zzelb.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzca.zzel[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0144zza(null);
                case 3:
                    return zzelb.zza(zzex, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzdv", "zzev", "zzew"});
                case 4:
                    return zzex;
                case 5:
                    zzemx<zza> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zza.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzex);
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

        public final zzc zzaa() {
            zzc zzcVar = this.zzew;
            return zzcVar == null ? zzc.zzag() : zzcVar;
        }

        public final boolean zzx() {
            return (this.zzdv & 1) != 0;
        }

        public final zzb zzy() {
            zzb zzbVar = this.zzev;
            return zzbVar == null ? zzb.zzad() : zzbVar;
        }

        public final boolean zzz() {
            return (this.zzdv & 2) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzb extends zzelb<zzb, zza> implements zzemq {
        private static volatile zzemx<zzb> zzek;
        private static final zzb zzez;
        private int zzdv;
        private int zzey = 2;

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zza extends zzelb.zzb<zzb, zza> implements zzemq {
            private zza() {
                super(zzb.zzez);
            }

            /* synthetic */ zza(zzca zzcaVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzez = zzbVar;
            zzelb.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        public static zzb zzad() {
            return zzez;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzca.zzel[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzelb.zza(zzez, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001bဌ\u0000", new Object[]{"zzdv", "zzey", zzcd.zzw()});
                case 4:
                    return zzez;
                case 5:
                    zzemx<zzb> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zzb.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzez);
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

        public final zzcd zzac() {
            zzcd zzj = zzcd.zzj(this.zzey);
            return zzj == null ? zzcd.ENUM_SIGNAL_SOURCE_ADSHIELD : zzj;
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzc extends zzelb<zzc, zza> implements zzemq {
        private static volatile zzemx<zzc> zzek;
        private static final zzc zzfm;
        private int zzdv;
        private String zzfg = "";
        private String zzfh = "";
        private String zzfi = "";
        private String zzfj = "";
        private String zzfk = "";
        private String zzfl = "";

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zza extends zzelb.zzb<zzc, zza> implements zzemq {
            private zza() {
                super(zzc.zzfm);
            }

            /* synthetic */ zza(zzca zzcaVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzfm = zzcVar;
            zzelb.zza(zzc.class, zzcVar);
        }

        private zzc() {
        }

        public static zzc zzag() {
            return zzfm;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzca.zzel[i2 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zzelb.zza(zzfm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zzdv", "zzfg", "zzfh", "zzfi", "zzfj", "zzfk", "zzfl"});
                case 4:
                    return zzfm;
                case 5:
                    zzemx<zzc> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zzc.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzfm);
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

        public final String zzaf() {
            return this.zzfg;
        }
    }
}
