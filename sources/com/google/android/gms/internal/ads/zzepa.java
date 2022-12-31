package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzepa {

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb<zza, C0149zza> implements zzemq {
        private static volatile zzemx<zza> zzek;
        private static final zza zzixr;
        private int zzdv;
        private int zzixk;
        private zzb zzixl;
        private zzejr zzixm;
        private zzejr zzixn;
        private boolean zzixo;
        private boolean zzixp;
        private byte zzixq = 2;

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzepa$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0149zza extends zzelb.zzb<zza, C0149zza> implements zzemq {
            private C0149zza() {
                super(zza.zzixr);
            }

            /* synthetic */ C0149zza(zzeoz zzeozVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zzb extends zzelb<zzb, C0150zza> implements zzemq {
            private static volatile zzemx<zzb> zzek;
            private static final zzb zzixw;
            private int zzdv;
            private String zzixs = "";
            private String zzixt = "";
            private String zzixu = "";
            private int zzixv;

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzepa$zza$zzb$zza  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0150zza extends zzelb.zzb<zzb, C0150zza> implements zzemq {
                private C0150zza() {
                    super(zzb.zzixw);
                }

                /* synthetic */ C0150zza(zzeoz zzeozVar) {
                    this();
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzixw = zzbVar;
                zzelb.zza(zzb.class, zzbVar);
            }

            private zzb() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzeoz.zzel[i2 - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0150zza(null);
                    case 3:
                        return zzelb.zza(zzixw, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zzdv", "zzixs", "zzixt", "zzixu", "zzixv"});
                    case 4:
                        return zzixw;
                    case 5:
                        zzemx<zzb> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (zzb.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zzixw);
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

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public enum zzc implements zzelg {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            
            private static final zzelf<zzc> zzes = new zzepb();
            private final int value;

            zzc(int i2) {
                this.value = i2;
            }

            public static zzc zzhy(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    return null;
                                }
                                return DANGEROUS_HOST;
                            }
                            return POTENTIALLY_UNWANTED;
                        }
                        return UNKNOWN;
                    }
                    return DANGEROUS;
                }
                return SAFE;
            }

            public static zzeli zzw() {
                return zzepc.zzeu;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.ads.zzelg
            public final int zzv() {
                return this.value;
            }
        }

        static {
            zza zzaVar = new zza();
            zzixr = zzaVar;
            zzelb.zza(zza.class, zzaVar);
        }

        private zza() {
            zzejr zzejrVar = zzejr.zzilz;
            this.zzixm = zzejrVar;
            this.zzixn = zzejrVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzeoz.zzel[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0149zza(null);
                case 3:
                    return zzelb.zza(zzixr, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001\u0003ည\u0002\u0004ည\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzdv", "zzixk", zzc.zzw(), "zzixl", "zzixm", "zzixn", "zzixo", "zzixp"});
                case 4:
                    return zzixr;
                case 5:
                    zzemx<zza> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zza.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzixr);
                                zzek = zzemxVar;
                            }
                        }
                    }
                    return zzemxVar;
                case 6:
                    return Byte.valueOf(this.zzixq);
                case 7:
                    this.zzixq = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzb extends zzelb<zzb, C0152zzb> implements zzemq {
        private static volatile zzemx<zzb> zzek;
        private static final zzb zziys;
        private int zzcan;
        private int zzdv;
        private int zziyd;
        private zza zziyg;
        private zzf zziyj;
        private boolean zziyk;
        private boolean zziyn;
        private boolean zziyo;
        private zzi zziyp;
        private byte zzixq = 2;
        private String zzixt = "";
        private String zziye = "";
        private String zziyf = "";
        private zzell<zzh> zziyh = zzelb.zzbin();
        private String zziyi = "";
        private zzell<String> zziyl = zzelb.zzbin();
        private String zziym = "";
        private zzejr zzixm = zzejr.zzilz;
        private zzell<String> zziyq = zzelb.zzbin();
        private zzell<String> zziyr = zzelb.zzbin();

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzepa$zzb$zzb  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0152zzb extends zzelb.zzb<zzb, C0152zzb> implements zzemq {
            private C0152zzb() {
                super(zzb.zziys);
            }

            public final String getUrl() {
                return ((zzb) this.zziqp).getUrl();
            }

            public final C0152zzb zzb(zzg zzgVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).zza(zzgVar);
                return this;
            }

            public final List<zzh> zzblm() {
                return Collections.unmodifiableList(((zzb) this.zziqp).zzblm());
            }

            public final String zzbln() {
                return ((zzb) this.zziqp).zzbln();
            }

            public final C0152zzb zzblt() {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).zzblo();
                return this;
            }

            public final C0152zzb zzie(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).setUrl(str);
                return this;
            }

            public final C0152zzb zzif(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).zzic(str);
                return this;
            }

            public final C0152zzb zzig(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).zzdv(str);
                return this;
            }

            public final C0152zzb zzo(Iterable<String> iterable) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).zzm(iterable);
                return this;
            }

            public final C0152zzb zzp(Iterable<String> iterable) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).zzn(iterable);
                return this;
            }

            /* synthetic */ C0152zzb(zzeoz zzeozVar) {
                this();
            }

            public final C0152zzb zzb(zza zzaVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).zza(zzaVar);
                return this;
            }

            public final C0152zzb zzb(zzh zzhVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).zza(zzhVar);
                return this;
            }

            public final C0152zzb zzb(zzf zzfVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).zza(zzfVar);
                return this;
            }

            public final C0152zzb zzb(zzi zziVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzb) this.zziqp).zza(zziVar);
                return this;
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zze extends zzelb<zze, C0156zzb> implements zzemq {
            private static volatile zzemx<zze> zzek;
            private static final zze zzizj;
            private int zzdv;
            private byte zzixq = 2;
            private zzell<zzc> zziyy = zzelb.zzbin();
            private zzejr zziyz;
            private zzejr zziza;
            private int zzizb;
            private zza zzizh;
            private zzejr zzizi;

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* loaded from: classes2.dex */
            public static final class zza extends zzelb<zza, C0155zza> implements zzemq {
                private static volatile zzemx<zza> zzek;
                private static final zza zzizm;
                private int zzdv;
                private zzejr zzizf;
                private int zzizk;
                private zzejr zzizl;

                /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
                /* renamed from: com.google.android.gms.internal.ads.zzepa$zzb$zze$zza$zza  reason: collision with other inner class name */
                /* loaded from: classes2.dex */
                public static final class C0155zza extends zzelb.zzb<zza, C0155zza> implements zzemq {
                    private C0155zza() {
                        super(zza.zzizm);
                    }

                    /* synthetic */ C0155zza(zzeoz zzeozVar) {
                        this();
                    }
                }

                static {
                    zza zzaVar = new zza();
                    zzizm = zzaVar;
                    zzelb.zza(zza.class, zzaVar);
                }

                private zza() {
                    zzejr zzejrVar = zzejr.zzilz;
                    this.zzizl = zzejrVar;
                    this.zzizf = zzejrVar;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzelb
                public final Object zza(int i2, Object obj, Object obj2) {
                    switch (zzeoz.zzel[i2 - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C0155zza(null);
                        case 3:
                            return zzelb.zza(zzizm, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzizk", "zzizl", "zzizf"});
                        case 4:
                            return zzizm;
                        case 5:
                            zzemx<zza> zzemxVar = zzek;
                            if (zzemxVar == null) {
                                synchronized (zza.class) {
                                    zzemxVar = zzek;
                                    if (zzemxVar == null) {
                                        zzemxVar = new zzelb.zza<>(zzizm);
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

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzepa$zzb$zze$zzb  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0156zzb extends zzelb.zzb<zze, C0156zzb> implements zzemq {
                private C0156zzb() {
                    super(zze.zzizj);
                }

                /* synthetic */ C0156zzb(zzeoz zzeozVar) {
                    this();
                }
            }

            static {
                zze zzeVar = new zze();
                zzizj = zzeVar;
                zzelb.zza(zze.class, zzeVar);
            }

            private zze() {
                zzejr zzejrVar = zzejr.zzilz;
                this.zziyz = zzejrVar;
                this.zziza = zzejrVar;
                this.zzizi = zzejrVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzeoz.zzel[i2 - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0156zzb(null);
                    case 3:
                        return zzelb.zza(zzizj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzdv", "zzizh", "zziyy", zzc.class, "zziyz", "zziza", "zzizb", "zzizi"});
                    case 4:
                        return zzizj;
                    case 5:
                        zzemx<zze> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (zze.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zzizj);
                                    zzek = zzemxVar;
                                }
                            }
                        }
                        return zzemxVar;
                    case 6:
                        return Byte.valueOf(this.zzixq);
                    case 7:
                        this.zzixq = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public enum zzg implements zzelg {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            
            private static final zzelf<zzg> zzes = new zzepf();
            private final int value;

            zzg(int i2) {
                this.value = i2;
            }

            public static zzg zzia(int i2) {
                switch (i2) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzeli zzw() {
                return zzepg.zzeu;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzg.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.ads.zzelg
            public final int zzv() {
                return this.value;
            }
        }

        static {
            zzb zzbVar = new zzb();
            zziys = zzbVar;
            zzelb.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setUrl(String str) {
            str.getClass();
            this.zzdv |= 4;
            this.zzixt = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            this.zzcan = zzgVar.zzv();
            this.zzdv |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzblo() {
            this.zzdv &= -65;
            this.zziyi = zziys.zziyi;
        }

        public static C0152zzb zzblp() {
            return zziys.zzbii();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzdv(String str) {
            str.getClass();
            this.zzdv |= 64;
            this.zziyi = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzic(String str) {
            str.getClass();
            this.zzdv |= 8;
            this.zziye = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(Iterable<String> iterable) {
            zzell<String> zzellVar = this.zziyq;
            if (!zzellVar.zzbge()) {
                this.zziyq = zzelb.zza(zzellVar);
            }
            zzejh.zza(iterable, this.zziyq);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(Iterable<String> iterable) {
            zzell<String> zzellVar = this.zziyr;
            if (!zzellVar.zzbge()) {
                this.zziyr = zzelb.zza(zzellVar);
            }
            zzejh.zza(iterable, this.zziyr);
        }

        public final String getUrl() {
            return this.zzixt;
        }

        public final List<zzh> zzblm() {
            return this.zziyh;
        }

        public final String zzbln() {
            return this.zziyi;
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zzf extends zzelb<zzf, C0157zzb> implements zzemq {
            private static volatile zzemx<zzf> zzek;
            private static final zzf zzizp;
            private int zzcan;
            private int zzdv;
            private String zzizn = "";
            private zzejr zzizo = zzejr.zzilz;

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* loaded from: classes2.dex */
            public enum zza implements zzelg {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                
                private static final zzelf<zza> zzes = new zzepe();
                private final int value;

                zza(int i2) {
                    this.value = i2;
                }

                public static zza zzhz(int i2) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            return null;
                        }
                        return TYPE_CREATIVE;
                    }
                    return TYPE_UNKNOWN;
                }

                public static zzeli zzw() {
                    return zzepd.zzeu;
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

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzepa$zzb$zzf$zzb  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0157zzb extends zzelb.zzb<zzf, C0157zzb> implements zzemq {
                private C0157zzb() {
                    super(zzf.zzizp);
                }

                public final C0157zzb zzas(zzejr zzejrVar) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzf) this.zziqp).zzar(zzejrVar);
                    return this;
                }

                public final C0157zzb zzb(zza zzaVar) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzf) this.zziqp).zza(zzaVar);
                    return this;
                }

                public final C0157zzb zzii(String str) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzf) this.zziqp).setMimeType(str);
                    return this;
                }

                /* synthetic */ C0157zzb(zzeoz zzeozVar) {
                    this();
                }
            }

            static {
                zzf zzfVar = new zzf();
                zzizp = zzfVar;
                zzelb.zza(zzf.class, zzfVar);
            }

            private zzf() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void setMimeType(String str) {
                str.getClass();
                this.zzdv |= 2;
                this.zzizn = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zza zzaVar) {
                this.zzcan = zzaVar.zzv();
                this.zzdv |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzar(zzejr zzejrVar) {
                zzejrVar.getClass();
                this.zzdv |= 4;
                this.zzizo = zzejrVar;
            }

            public static C0157zzb zzbmb() {
                return zzizp.zzbii();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzeoz.zzel[i2 - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0157zzb(null);
                    case 3:
                        return zzelb.zza(zzizp, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzcan", zza.zzw(), "zzizn", "zzizo"});
                    case 4:
                        return zzizp;
                    case 5:
                        zzemx<zzf> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (zzf.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zzizp);
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

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zzh extends zzelb<zzh, C0158zzb> implements zzemq {
            private static volatile zzemx<zzh> zzek;
            private static final zzh zzjam;
            private int zzdv;
            private int zzjae;
            private zzd zzjaf;
            private zze zzjag;
            private int zzjah;
            private int zzjak;
            private byte zzixq = 2;
            private String zzixt = "";
            private zzelh zzjai = zzelb.zzbil();
            private String zzjaj = "";
            private zzell<String> zzjal = zzelb.zzbin();

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* loaded from: classes2.dex */
            public enum zza implements zzelg {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                
                private static final zzelf<zza> zzes = new zzeph();
                private final int value;

                zza(int i2) {
                    this.value = i2;
                }

                public static zza zzib(int i2) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    return null;
                                }
                                return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                            }
                            return AD_RESOURCE_POST_CLICK;
                        }
                        return AD_RESOURCE_CREATIVE;
                    }
                    return AD_RESOURCE_UNKNOWN;
                }

                public static zzeli zzw() {
                    return zzepi.zzeu;
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

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzepa$zzb$zzh$zzb  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0158zzb extends zzelb.zzb<zzh, C0158zzb> implements zzemq {
                private C0158zzb() {
                    super(zzh.zzjam);
                }

                public final C0158zzb zzb(zzd zzdVar) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzh) this.zziqp).zza(zzdVar);
                    return this;
                }

                public final C0158zzb zzic(int i2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzh) this.zziqp).setId(i2);
                    return this;
                }

                public final C0158zzb zzik(String str) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzh) this.zziqp).setUrl(str);
                    return this;
                }

                public final C0158zzb zzil(String str) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzh) this.zziqp).zzij(str);
                    return this;
                }

                /* synthetic */ C0158zzb(zzeoz zzeozVar) {
                    this();
                }

                public final C0158zzb zzb(zza zzaVar) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzh) this.zziqp).zza(zzaVar);
                    return this;
                }
            }

            static {
                zzh zzhVar = new zzh();
                zzjam = zzhVar;
                zzelb.zza(zzh.class, zzhVar);
            }

            private zzh() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void setId(int i2) {
                this.zzdv |= 1;
                this.zzjae = i2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void setUrl(String str) {
                str.getClass();
                this.zzdv |= 2;
                this.zzixt = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzd zzdVar) {
                zzdVar.getClass();
                this.zzjaf = zzdVar;
                this.zzdv |= 4;
            }

            public static C0158zzb zzbme() {
                return zzjam.zzbii();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzij(String str) {
                str.getClass();
                zzell<String> zzellVar = this.zzjal;
                if (!zzellVar.zzbge()) {
                    this.zzjal = zzelb.zza(zzellVar);
                }
                this.zzjal.add(str);
            }

            public final String getUrl() {
                return this.zzixt;
            }

            public final int zzbmd() {
                return this.zzjal.size();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zza zzaVar) {
                this.zzjak = zzaVar.zzv();
                this.zzdv |= 64;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzeoz.zzel[i2 - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0158zzb(null);
                    case 3:
                        return zzelb.zza(zzjam, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzdv", "zzjae", "zzixt", "zzjaf", "zzjag", "zzjah", "zzjai", "zzjaj", "zzjak", zza.zzw(), "zzjal"});
                    case 4:
                        return zzjam;
                    case 5:
                        zzemx<zzh> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (zzh.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zzjam);
                                    zzek = zzemxVar;
                                }
                            }
                        }
                        return zzemxVar;
                    case 6:
                        return Byte.valueOf(this.zzixq);
                    case 7:
                        this.zzixq = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            zzaVar.getClass();
            this.zziyg = zzaVar;
            this.zzdv |= 32;
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zzd extends zzelb<zzd, C0154zzb> implements zzemq {
            private static volatile zzemx<zzd> zzek;
            private static final zzd zzizc;
            private int zzdv;
            private zza zziyx;
            private zzejr zziyz;
            private zzejr zziza;
            private int zzizb;
            private byte zzixq = 2;
            private zzell<zzc> zziyy = zzelb.zzbin();

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* loaded from: classes2.dex */
            public static final class zza extends zzelb<zza, C0153zza> implements zzemq {
                private static volatile zzemx<zza> zzek;
                private static final zza zzizg;
                private int zzdv;
                private zzejr zzizd;
                private zzejr zzize;
                private zzejr zzizf;

                /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
                /* renamed from: com.google.android.gms.internal.ads.zzepa$zzb$zzd$zza$zza  reason: collision with other inner class name */
                /* loaded from: classes2.dex */
                public static final class C0153zza extends zzelb.zzb<zza, C0153zza> implements zzemq {
                    private C0153zza() {
                        super(zza.zzizg);
                    }

                    /* synthetic */ C0153zza(zzeoz zzeozVar) {
                        this();
                    }
                }

                static {
                    zza zzaVar = new zza();
                    zzizg = zzaVar;
                    zzelb.zza(zza.class, zzaVar);
                }

                private zza() {
                    zzejr zzejrVar = zzejr.zzilz;
                    this.zzizd = zzejrVar;
                    this.zzize = zzejrVar;
                    this.zzizf = zzejrVar;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzelb
                public final Object zza(int i2, Object obj, Object obj2) {
                    switch (zzeoz.zzel[i2 - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C0153zza(null);
                        case 3:
                            return zzelb.zza(zzizg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzizd", "zzize", "zzizf"});
                        case 4:
                            return zzizg;
                        case 5:
                            zzemx<zza> zzemxVar = zzek;
                            if (zzemxVar == null) {
                                synchronized (zza.class) {
                                    zzemxVar = zzek;
                                    if (zzemxVar == null) {
                                        zzemxVar = new zzelb.zza<>(zzizg);
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

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzepa$zzb$zzd$zzb  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0154zzb extends zzelb.zzb<zzd, C0154zzb> implements zzemq {
                private C0154zzb() {
                    super(zzd.zzizc);
                }

                public final C0154zzb zzb(zzc zzcVar) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzd) this.zziqp).zza(zzcVar);
                    return this;
                }

                /* synthetic */ C0154zzb(zzeoz zzeozVar) {
                    this();
                }
            }

            static {
                zzd zzdVar = new zzd();
                zzizc = zzdVar;
                zzelb.zza(zzd.class, zzdVar);
            }

            private zzd() {
                zzejr zzejrVar = zzejr.zzilz;
                this.zziyz = zzejrVar;
                this.zziza = zzejrVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzc zzcVar) {
                zzcVar.getClass();
                zzell<zzc> zzellVar = this.zziyy;
                if (!zzellVar.zzbge()) {
                    this.zziyy = zzelb.zza(zzellVar);
                }
                this.zziyy.add(zzcVar);
            }

            public static C0154zzb zzblw() {
                return zzizc.zzbii();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzeoz.zzel[i2 - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new C0154zzb(null);
                    case 3:
                        return zzelb.zza(zzizc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzdv", "zziyx", "zziyy", zzc.class, "zziyz", "zziza", "zzizb"});
                    case 4:
                        return zzizc;
                    case 5:
                        zzemx<zzd> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (zzd.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zzizc);
                                    zzek = zzemxVar;
                                }
                            }
                        }
                        return zzemxVar;
                    case 6:
                        return Byte.valueOf(this.zzixq);
                    case 7:
                        this.zzixq = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzh zzhVar) {
            zzhVar.getClass();
            zzell<zzh> zzellVar = this.zziyh;
            if (!zzellVar.zzbge()) {
                this.zziyh = zzelb.zza(zzellVar);
            }
            this.zziyh.add(zzhVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzf zzfVar) {
            zzfVar.getClass();
            this.zziyj = zzfVar;
            this.zzdv |= 128;
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zza extends zzelb<zza, C0151zza> implements zzemq {
            private static volatile zzemx<zza> zzek;
            private static final zza zziyu;
            private int zzdv;
            private String zziyt = "";

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzepa$zzb$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0151zza extends zzelb.zzb<zza, C0151zza> implements zzemq {
                private C0151zza() {
                    super(zza.zziyu);
                }

                public final C0151zza zzih(String str) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zza) this.zziqp).zzid(str);
                    return this;
                }

                /* synthetic */ C0151zza(zzeoz zzeozVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zziyu = zzaVar;
                zzelb.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            public static C0151zza zzblr() {
                return zziyu.zzbii();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzid(String str) {
                str.getClass();
                this.zzdv |= 1;
                this.zziyt = str;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzeoz.zzel[i2 - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0151zza(null);
                    case 3:
                        return zzelb.zza(zziyu, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdv", "zziyt"});
                    case 4:
                        return zziyu;
                    case 5:
                        zzemx<zza> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (zza.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zziyu);
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

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zzi extends zzelb<zzi, zza> implements zzemq {
            private static volatile zzemx<zzi> zzek;
            private static final zzi zzjav;
            private int zzdv;
            private String zzjas = "";
            private long zzjat;
            private boolean zzjau;

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* loaded from: classes2.dex */
            public static final class zza extends zzelb.zzb<zzi, zza> implements zzemq {
                private zza() {
                    super(zzi.zzjav);
                }

                public final zza zzbv(boolean z) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzi) this.zziqp).zzbw(z);
                    return this;
                }

                public final zza zzfs(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzi) this.zziqp).zzft(j2);
                    return this;
                }

                public final zza zzim(String str) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzi) this.zziqp).zzin(str);
                    return this;
                }

                /* synthetic */ zza(zzeoz zzeozVar) {
                    this();
                }
            }

            static {
                zzi zziVar = new zzi();
                zzjav = zziVar;
                zzelb.zza(zzi.class, zziVar);
            }

            private zzi() {
            }

            public static zza zzbmg() {
                return zzjav.zzbii();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbw(boolean z) {
                this.zzdv |= 4;
                this.zzjau = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzft(long j2) {
                this.zzdv |= 2;
                this.zzjat = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzin(String str) {
                str.getClass();
                this.zzdv |= 1;
                this.zzjas = str;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzeoz.zzel[i2 - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzelb.zza(zzjav, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzdv", "zzjas", "zzjat", "zzjau"});
                    case 4:
                        return zzjav;
                    case 5:
                        zzemx<zzi> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (zzi.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zzjav);
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

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zzc extends zzelb<zzc, zza> implements zzemq {
            private static volatile zzemx<zzc> zzek;
            private static final zzc zziyw;
            private int zzdv;
            private zzejr zzigt;
            private byte zzixq = 2;
            private zzejr zziyv;

            /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
            /* loaded from: classes2.dex */
            public static final class zza extends zzelb.zzb<zzc, zza> implements zzemq {
                private zza() {
                    super(zzc.zziyw);
                }

                public final zza zzap(zzejr zzejrVar) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzc) this.zziqp).zzao(zzejrVar);
                    return this;
                }

                public final zza zzaq(zzejr zzejrVar) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzc) this.zziqp).zzaf(zzejrVar);
                    return this;
                }

                /* synthetic */ zza(zzeoz zzeozVar) {
                    this();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zziyw = zzcVar;
                zzelb.zza(zzc.class, zzcVar);
            }

            private zzc() {
                zzejr zzejrVar = zzejr.zzilz;
                this.zziyv = zzejrVar;
                this.zzigt = zzejrVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzaf(zzejr zzejrVar) {
                zzejrVar.getClass();
                this.zzdv |= 2;
                this.zzigt = zzejrVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzao(zzejr zzejrVar) {
                zzejrVar.getClass();
                this.zzdv |= 1;
                this.zziyv = zzejrVar;
            }

            public static zza zzblu() {
                return zziyw.zzbii();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzeoz.zzel[i2 - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzelb.zza(zziyw, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzdv", "zziyv", "zzigt"});
                    case 4:
                        return zziyw;
                    case 5:
                        zzemx<zzc> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (zzc.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zziyw);
                                    zzek = zzemxVar;
                                }
                            }
                        }
                        return zzemxVar;
                    case 6:
                        return Byte.valueOf(this.zzixq);
                    case 7:
                        this.zzixq = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzi zziVar) {
            zziVar.getClass();
            this.zziyp = zziVar;
            this.zzdv |= 8192;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzeoz.zzel[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0152zzb(null);
                case 3:
                    return zzelb.zza(zziys, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzdv", "zzixt", "zziye", "zziyf", "zziyh", zzh.class, "zziyk", "zziyl", "zziym", "zziyn", "zziyo", "zzcan", zzg.zzw(), "zziyd", zza.zzc.zzw(), "zziyg", "zziyi", "zziyj", "zzixm", "zziyp", "zziyq", "zziyr"});
                case 4:
                    return zziys;
                case 5:
                    zzemx<zzb> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zzb.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zziys);
                                zzek = zzemxVar;
                            }
                        }
                    }
                    return zzemxVar;
                case 6:
                    return Byte.valueOf(this.zzixq);
                case 7:
                    this.zzixq = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
