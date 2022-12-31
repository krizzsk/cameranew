package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcf {

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb<zza, zzb> implements zzemq {
        private static volatile zzemx<zza> zzek;
        private static final zza zzik;
        private int zzdv;
        private int zzfn;
        private int zzfo;
        private long zzfq;
        private long zzfr;
        private long zzfs;
        private long zzft;
        private long zzfu;
        private long zzfv;
        private long zzfw;
        private long zzfx;
        private long zzfy;
        private long zzfz;
        private long zzgb;
        private long zzgc;
        private long zzgd;
        private long zzge;
        private long zzgf;
        private long zzgg;
        private long zzgh;
        private long zzgi;
        private long zzgj;
        private long zzgm;
        private long zzgn;
        private long zzgo;
        private long zzgp;
        private zzb zzgs;
        private zze zzhi;
        private zzf zzhk;
        private int zzhv;
        private int zzhw;
        private int zzhx;
        private zze zzhy;
        private long zzid;
        private boolean zzig;
        private long zzii;
        private zzd zzij;
        private String zzfp = "";
        private String zzef = "";
        private String zzga = "";
        private String zzfg = "";
        private String zzgk = "D";
        private String zzgl = "";
        private String zzfi = "";
        private long zzgq = -1;
        private long zzgr = -1;
        private long zzgt = -1;
        private long zzgu = -1;
        private long zzgv = -1;
        private long zzgw = -1;
        private long zzgx = -1;
        private long zzgy = -1;
        private String zzfj = "D";
        private String zzfk = "D";
        private long zzgz = -1;
        private int zzha = 1000;
        private int zzhb = 1000;
        private long zzhc = -1;
        private long zzhd = -1;
        private long zzhe = -1;
        private long zzhf = -1;
        private long zzhg = -1;
        private int zzhh = 1000;
        private zzell<zze> zzhj = zzelb.zzbin();
        private long zzhl = -1;
        private long zzhm = -1;
        private long zzhn = -1;
        private long zzho = -1;
        private long zzhp = -1;
        private long zzhq = -1;
        private long zzhr = -1;
        private long zzhs = -1;
        private String zzht = "D";
        private long zzhu = -1;
        private long zzhz = -1;
        private int zzia = 1000;
        private int zzib = 1000;
        private String zzic = "D";
        private String zzie = "";
        private int zzif = 2;
        private String zzih = "";

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public enum EnumC0145zza implements zzelg {
            DEBUGGER_STATE_UNSPECIFIED(0),
            DEBUGGER_STATE_NOT_INSTALLED(1),
            DEBUGGER_STATE_INSTALLED(2),
            DEBUGGER_STATE_ACTIVE(3),
            DEBUGGER_STATE_ENVVAR(4),
            DEBUGGER_STATE_MACHPORT(5),
            DEBUGGER_STATE_ENVVAR_MACHPORT(6);
            
            private static final zzelf<EnumC0145zza> zzes = new zzci();
            private final int value;

            EnumC0145zza(int i2) {
                this.value = i2;
            }

            public static EnumC0145zza zzk(int i2) {
                switch (i2) {
                    case 0:
                        return DEBUGGER_STATE_UNSPECIFIED;
                    case 1:
                        return DEBUGGER_STATE_NOT_INSTALLED;
                    case 2:
                        return DEBUGGER_STATE_INSTALLED;
                    case 3:
                        return DEBUGGER_STATE_ACTIVE;
                    case 4:
                        return DEBUGGER_STATE_ENVVAR;
                    case 5:
                        return DEBUGGER_STATE_MACHPORT;
                    case 6:
                        return DEBUGGER_STATE_ENVVAR_MACHPORT;
                    default:
                        return null;
                }
            }

            public static zzeli zzw() {
                return zzch.zzeu;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + EnumC0145zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.ads.zzelg
            public final int zzv() {
                return this.value;
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zzb extends zzelb.zzb<zza, zzb> implements zzemq {
            private zzb() {
                super(zza.zzik);
            }

            public final zzb zzac(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzt(str);
                return this;
            }

            public final zzb zzad(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzu(str);
                return this;
            }

            public final zzb zzae(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzv(str);
                return this;
            }

            public final zzb zzaf(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzw(str);
                return this;
            }

            public final zzb zzag(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzx(str);
                return this;
            }

            public final zzb zzah(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzy(str);
                return this;
            }

            public final zzb zzai(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzz(str);
                return this;
            }

            public final zzb zzaj(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzaa(str);
                return this;
            }

            public final zzb zzak(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzab(str);
                return this;
            }

            public final zzb zzal(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zze(j2);
                return this;
            }

            public final zzb zzam(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzf(j2);
                return this;
            }

            public final zzb zzan(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzg(j2);
                return this;
            }

            public final zzb zzao(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzh(j2);
                return this;
            }

            public final zzb zzap(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzi(j2);
                return this;
            }

            public final zzb zzaq(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzj(j2);
                return this;
            }

            public final zzb zzar(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzk(j2);
                return this;
            }

            public final zzb zzas(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzl(j2);
                return this;
            }

            public final zzb zzat(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzm(j2);
                return this;
            }

            public final zzb zzau(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzn(j2);
                return this;
            }

            public final zzb zzav(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzo(j2);
                return this;
            }

            public final zzb zzaw(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzp(j2);
                return this;
            }

            public final zzb zzax(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzq(j2);
                return this;
            }

            public final zzb zzay(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzr(j2);
                return this;
            }

            public final zzb zzaz(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzs(j2);
                return this;
            }

            public final zzb zzb(zzf zzfVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zza(zzfVar);
                return this;
            }

            public final zzb zzba(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzt(j2);
                return this;
            }

            @Deprecated
            public final zzb zzbb(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzu(j2);
                return this;
            }

            public final zzb zzbc(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzv(j2);
                return this;
            }

            public final zzb zzbd(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzw(j2);
                return this;
            }

            public final zzb zzbe(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzx(j2);
                return this;
            }

            public final zzb zzbf(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzy(j2);
                return this;
            }

            public final zzb zzbg(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzz(j2);
                return this;
            }

            public final zzb zzbh(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzaa(j2);
                return this;
            }

            public final zzb zzbi(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzab(j2);
                return this;
            }

            public final zzb zzbj(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzac(j2);
                return this;
            }

            public final zzb zzbk(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzad(j2);
                return this;
            }

            public final zzb zzbl(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzae(j2);
                return this;
            }

            public final zzb zzbm(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzaf(j2);
                return this;
            }

            public final zzb zzbn(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzag(j2);
                return this;
            }

            public final zzb zzbo(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzah(j2);
                return this;
            }

            public final zzb zzbp(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzai(j2);
                return this;
            }

            public final zzb zzbq(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzaj(j2);
                return this;
            }

            public final zzb zzbr(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzak(j2);
                return this;
            }

            public final zzb zzc(zze zzeVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zza(zzeVar);
                return this;
            }

            public final zzb zzd(zze zzeVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzb(zzeVar);
                return this;
            }

            public final zzb zzf(zzcq zzcqVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zza(zzcqVar);
                return this;
            }

            public final zzb zzg(zzcq zzcqVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzb(zzcqVar);
                return this;
            }

            public final zzb zzh(zzcq zzcqVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzc(zzcqVar);
                return this;
            }

            public final zzb zzi(zzcq zzcqVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzd(zzcqVar);
                return this;
            }

            public final zzb zzj(zzcq zzcqVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zze(zzcqVar);
                return this;
            }

            /* synthetic */ zzb(zzcg zzcgVar) {
                this();
            }

            public final zzb zzas() {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzaj();
                return this;
            }

            public final zzb zzb(zzc zzcVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zza(zzcVar);
                return this;
            }

            public final zzb zzb(boolean z) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zza(z);
                return this;
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public enum zzc implements zzelg {
            DEVICE_IDENTIFIER_NO_ID(0),
            DEVICE_IDENTIFIER_APP_SPECIFIC_ID(1),
            DEVICE_IDENTIFIER_GLOBAL_ID(2),
            DEVICE_IDENTIFIER_ADVERTISER_ID(3),
            DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED(4),
            DEVICE_IDENTIFIER_ANDROID_AD_ID(5),
            DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID(6);
            
            private static final zzelf<zzc> zzes = new zzcj();
            private final int value;

            zzc(int i2) {
                this.value = i2;
            }

            public static zzc zzl(int i2) {
                switch (i2) {
                    case 0:
                        return DEVICE_IDENTIFIER_NO_ID;
                    case 1:
                        return DEVICE_IDENTIFIER_APP_SPECIFIC_ID;
                    case 2:
                        return DEVICE_IDENTIFIER_GLOBAL_ID;
                    case 3:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID;
                    case 4:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED;
                    case 5:
                        return DEVICE_IDENTIFIER_ANDROID_AD_ID;
                    case 6:
                        return DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID;
                    default:
                        return null;
                }
            }

            public static zzeli zzw() {
                return zzck.zzeu;
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

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public enum zzd implements zzelg {
            ERROR_ENCODE_SIZE_FAIL(1),
            ERROR_UNKNOWN(3),
            ERROR_NO_SIGNALS(5),
            ERROR_ENCRYPTION(7),
            ERROR_MEMORY(9),
            ERROR_SIMULATOR(11),
            ERROR_SERVICE(13),
            ERROR_THREAD(15),
            PSN_WEB64_FAIL(2),
            PSN_DECRYPT_SIZE_FAIL(4),
            PSN_MD5_CHECK_FAIL(8),
            PSN_MD5_SIZE_FAIL(16),
            PSN_MD5_FAIL(32),
            PSN_DECODE_FAIL(64),
            PSN_SALT_FAIL(128),
            PSN_BITSLICER_FAIL(256),
            PSN_REQUEST_TYPE_FAIL(512),
            PSN_INVALID_ERROR_CODE(1024),
            PSN_TIMESTAMP_EXPIRED(2048),
            PSN_ENCODE_SIZE_FAIL(4096),
            PSN_BLANK_VALUE(8192),
            PSN_INITIALIZATION_FAIL(16384),
            PSN_GASS_CLIENT_FAIL(32768),
            PSN_SIGNALS_TIMEOUT(65536),
            PSN_TINK_FAIL(131072);
            
            private static final zzelf<zzd> zzes = new zzcl();
            private final int value;

            zzd(int i2) {
                this.value = i2;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.ads.zzelg
            public final int zzv() {
                return this.value;
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zze extends zzelb<zze, C0146zza> implements zzemq {
            private static volatile zzemx<zze> zzek;
            private static final zze zzku;
            private int zzdv;
            private long zzko;
            private long zzkp;
            private long zzgb = -1;
            private long zzgc = -1;
            private long zzkb = -1;
            private long zzkc = -1;
            private long zzkd = -1;
            private long zzke = -1;
            private int zzkf = 1000;
            private long zzkg = -1;
            private long zzkh = -1;
            private long zzki = -1;
            private int zzkj = 1000;
            private long zzkk = -1;
            private long zzkl = -1;
            private long zzkm = -1;
            private long zzkn = -1;
            private long zzkq = -1;
            private long zzkr = -1;
            private long zzks = -1;
            private long zzkt = -1;

            /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zze$zza  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0146zza extends zzelb.zzb<zze, C0146zza> implements zzemq {
                private C0146zza() {
                    super(zze.zzku);
                }

                public final C0146zza zzay() {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzat();
                    return this;
                }

                public final C0146zza zzcl(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzj(j2);
                    return this;
                }

                public final C0146zza zzcm(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzk(j2);
                    return this;
                }

                public final C0146zza zzcn(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzbs(j2);
                    return this;
                }

                public final C0146zza zzco(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzbt(j2);
                    return this;
                }

                public final C0146zza zzcp(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzbu(j2);
                    return this;
                }

                public final C0146zza zzcq(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzbv(j2);
                    return this;
                }

                public final C0146zza zzcr(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzbw(j2);
                    return this;
                }

                public final C0146zza zzcs(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzbx(j2);
                    return this;
                }

                public final C0146zza zzct(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzby(j2);
                    return this;
                }

                public final C0146zza zzcu(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzbz(j2);
                    return this;
                }

                public final C0146zza zzcv(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzca(j2);
                    return this;
                }

                public final C0146zza zzcw(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzcb(j2);
                    return this;
                }

                public final C0146zza zzcx(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzcc(j2);
                    return this;
                }

                public final C0146zza zzcy(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzcd(j2);
                    return this;
                }

                public final C0146zza zzcz(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzce(j2);
                    return this;
                }

                public final C0146zza zzda(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzcf(j2);
                    return this;
                }

                public final C0146zza zzdb(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzcg(j2);
                    return this;
                }

                public final C0146zza zzm(zzcq zzcqVar) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzk(zzcqVar);
                    return this;
                }

                public final C0146zza zzn(zzcq zzcqVar) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zze) this.zziqp).zzl(zzcqVar);
                    return this;
                }

                /* synthetic */ C0146zza(zzcg zzcgVar) {
                    this();
                }
            }

            static {
                zze zzeVar = new zze();
                zzku = zzeVar;
                zzelb.zza(zze.class, zzeVar);
            }

            private zze() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzat() {
                this.zzdv &= -9;
                this.zzkc = -1L;
            }

            public static C0146zza zzau() {
                return zzku.zzbii();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbs(long j2) {
                this.zzdv |= 4;
                this.zzkb = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbt(long j2) {
                this.zzdv |= 8;
                this.zzkc = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbu(long j2) {
                this.zzdv |= 16;
                this.zzkd = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbv(long j2) {
                this.zzdv |= 32;
                this.zzke = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbw(long j2) {
                this.zzdv |= 128;
                this.zzkg = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbx(long j2) {
                this.zzdv |= 256;
                this.zzkh = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzby(long j2) {
                this.zzdv |= 512;
                this.zzki = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbz(long j2) {
                this.zzdv |= 2048;
                this.zzkk = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzca(long j2) {
                this.zzdv |= 4096;
                this.zzkl = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcb(long j2) {
                this.zzdv |= 8192;
                this.zzkm = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcc(long j2) {
                this.zzdv |= 16384;
                this.zzkn = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcd(long j2) {
                this.zzdv |= 32768;
                this.zzko = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzce(long j2) {
                this.zzdv |= 65536;
                this.zzkp = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcf(long j2) {
                this.zzdv |= 131072;
                this.zzkq = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcg(long j2) {
                this.zzdv |= 262144;
                this.zzkr = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzj(long j2) {
                this.zzdv |= 1;
                this.zzgb = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzk(long j2) {
                this.zzdv |= 2;
                this.zzgc = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzl(zzcq zzcqVar) {
                this.zzkj = zzcqVar.zzv();
                this.zzdv |= 1024;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzcg.zzel[i2 - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0146zza(null);
                    case 3:
                        return zzelb.zza(zzku, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzdv", "zzgb", "zzgc", "zzkb", "zzkc", "zzkd", "zzke", "zzkf", zzcq.zzw(), "zzkg", "zzkh", "zzki", "zzkj", zzcq.zzw(), "zzkk", "zzkl", "zzkm", "zzkn", "zzko", "zzkp", "zzkq", "zzkr", "zzks", "zzkt"});
                    case 4:
                        return zzku;
                    case 5:
                        zzemx<zze> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (zze.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zzku);
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

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzk(zzcq zzcqVar) {
                this.zzkf = zzcqVar.zzv();
                this.zzdv |= 64;
            }
        }

        static {
            zza zzaVar = new zza();
            zzik = zzaVar;
            zzelb.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzcq zzcqVar) {
            this.zzha = zzcqVar.zzv();
            this.zzfn |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaa(long j2) {
            this.zzfn |= 32;
            this.zzgx = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzab(long j2) {
            this.zzfn |= 64;
            this.zzgy = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzac(long j2) {
            this.zzfn |= 4096;
            this.zzhc = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzad(long j2) {
            this.zzfn |= 8192;
            this.zzhd = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzae(long j2) {
            this.zzfn |= 16384;
            this.zzhe = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzag(long j2) {
            this.zzfn |= 4194304;
            this.zzhn = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzah(long j2) {
            this.zzfn |= 8388608;
            this.zzho = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaj() {
            this.zzhj = zzelb.zzbin();
        }

        public static zzb zzap() {
            return zzik.zzbii();
        }

        public static zza zzaq() {
            return zzik;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzcq zzcqVar) {
            this.zzhb = zzcqVar.zzv();
            this.zzfn |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzcq zzcqVar) {
            this.zzhh = zzcqVar.zzv();
            this.zzfn |= 131072;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(zzcq zzcqVar) {
            this.zzia = zzcqVar.zzv();
            this.zzfo |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(long j2) {
            this.zzdv |= 4;
            this.zzfq = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(long j2) {
            this.zzdv |= 16;
            this.zzfs = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(long j2) {
            this.zzdv |= 32;
            this.zzft = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(long j2) {
            this.zzdv |= 1024;
            this.zzfy = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(long j2) {
            this.zzdv |= 2048;
            this.zzfz = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(long j2) {
            this.zzdv |= 8192;
            this.zzgb = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(long j2) {
            this.zzdv |= 16384;
            this.zzgc = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(long j2) {
            this.zzdv |= 32768;
            this.zzgd = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(long j2) {
            this.zzdv |= 65536;
            this.zzge = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(long j2) {
            this.zzdv |= 524288;
            this.zzgh = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(long j2) {
            this.zzdv |= 1048576;
            this.zzgi = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(long j2) {
            this.zzdv |= 2097152;
            this.zzgj = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq(long j2) {
            this.zzdv |= 33554432;
            this.zzgm = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr(long j2) {
            this.zzdv |= 67108864;
            this.zzgn = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzs(long j2) {
            this.zzdv |= 134217728;
            this.zzgo = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzt(String str) {
            str.getClass();
            this.zzdv |= 1;
            this.zzfp = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzu(String str) {
            str.getClass();
            this.zzdv |= 2;
            this.zzef = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzv(String str) {
            str.getClass();
            this.zzdv |= 4194304;
            this.zzfg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzw(String str) {
            str.getClass();
            this.zzdv |= 16777216;
            this.zzgl = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzx(String str) {
            str.getClass();
            this.zzdv |= PGImageSDK.SDK_STATUS_CREATE;
            this.zzfi = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzy(long j2) {
            this.zzfn |= 8;
            this.zzgv = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzz(long j2) {
            this.zzfn |= 16;
            this.zzgw = j2;
        }

        public final String zzaf() {
            return this.zzfg;
        }

        public final boolean zzai() {
            return (this.zzdv & 4194304) != 0;
        }

        public final String zzak() {
            return this.zzie;
        }

        public final zzc zzal() {
            zzc zzl = zzc.zzl(this.zzif);
            return zzl == null ? zzc.DEVICE_IDENTIFIER_GLOBAL_ID : zzl;
        }

        public final boolean zzam() {
            return this.zzig;
        }

        public final boolean zzan() {
            return (this.zzfo & 4096) != 0;
        }

        public final zzd zzao() {
            zzd zzdVar = this.zzij;
            return zzdVar == null ? zzd.zzbi() : zzdVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaf(long j2) {
            this.zzfn |= 2097152;
            this.zzhm = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzai(long j2) {
            this.zzfn |= 67108864;
            this.zzhr = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaj(long j2) {
            this.zzfn |= 134217728;
            this.zzhs = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzak(long j2) {
            this.zzfo |= 2048;
            this.zzii = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zze zzeVar) {
            zzeVar.getClass();
            this.zzhi = zzeVar;
            this.zzfn |= 262144;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaa(String str) {
            str.getClass();
            this.zzfn |= PGImageSDK.SDK_STATUS_CREATE;
            this.zzht = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzab(String str) {
            str.getClass();
            this.zzfo |= 128;
            this.zzie = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zze zzeVar) {
            zzeVar.getClass();
            zzell<zze> zzellVar = this.zzhj;
            if (!zzellVar.zzbge()) {
                this.zzhj = zzelb.zza(zzellVar);
            }
            this.zzhj.add(zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(zzcq zzcqVar) {
            this.zzib = zzcqVar.zzv();
            this.zzfo |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzy(String str) {
            str.getClass();
            this.zzfn |= 128;
            this.zzfj = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzz(String str) {
            str.getClass();
            this.zzfn |= 256;
            this.zzfk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzt(long j2) {
            this.zzdv |= 536870912;
            this.zzgp = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzu(long j2) {
            this.zzdv |= 1073741824;
            this.zzgq = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzv(long j2) {
            this.zzdv |= Integer.MIN_VALUE;
            this.zzgr = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzw(long j2) {
            this.zzfn |= 2;
            this.zzgt = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzx(long j2) {
            this.zzfn |= 4;
            this.zzgu = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzf zzfVar) {
            zzfVar.getClass();
            this.zzhk = zzfVar;
            this.zzfn |= 524288;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            this.zzif = zzcVar.zzv();
            this.zzfo |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzfo |= 512;
            this.zzig = z;
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zzf extends zzelb<zzf, C0147zza> implements zzemq {
            private static volatile zzemx<zzf> zzek;
            private static final zzf zzkz;
            private int zzdv;
            private long zzhf = -1;
            private long zzhg = -1;
            private long zzkv = -1;
            private long zzkw = -1;
            private long zzkx = -1;
            private long zzky = -1;

            /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zzf$zza  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0147zza extends zzelb.zzb<zzf, C0147zza> implements zzemq {
                private C0147zza() {
                    super(zzf.zzkz);
                }

                public final C0147zza zzdc(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzf) this.zziqp).zzch(j2);
                    return this;
                }

                public final C0147zza zzdd(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzf) this.zziqp).zzci(j2);
                    return this;
                }

                public final C0147zza zzde(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzf) this.zziqp).zzcj(j2);
                    return this;
                }

                public final C0147zza zzdf(long j2) {
                    if (this.zziqq) {
                        zzbis();
                        this.zziqq = false;
                    }
                    ((zzf) this.zziqp).zzck(j2);
                    return this;
                }

                /* synthetic */ C0147zza(zzcg zzcgVar) {
                    this();
                }
            }

            static {
                zzf zzfVar = new zzf();
                zzkz = zzfVar;
                zzelb.zza(zzf.class, zzfVar);
            }

            private zzf() {
            }

            public static C0147zza zzaw() {
                return zzkz.zzbii();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzch(long j2) {
                this.zzdv |= 4;
                this.zzkv = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzci(long j2) {
                this.zzdv |= 8;
                this.zzkw = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcj(long j2) {
                this.zzdv |= 16;
                this.zzkx = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzck(long j2) {
                this.zzdv |= 32;
                this.zzky = j2;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzcg.zzel[i2 - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0147zza(null);
                    case 3:
                        return zzelb.zza(zzkz, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzdv", "zzhf", "zzhg", "zzkv", "zzkw", "zzkx", "zzky"});
                    case 4:
                        return zzkz;
                    case 5:
                        zzemx<zzf> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (zzf.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zzkz);
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

        public static zza zza(byte[] bArr, zzeko zzekoVar) throws zzelo {
            return (zza) zzelb.zza(zzik, bArr, zzekoVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzcg.zzel[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzelb.zza(zzik, "\u0001N\u0000\u0003\u0001ÉN\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂF\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈG\u0019ဂK\u001aဌH\u001bဈ\u0016\u001cဇI\u001dဈ\u0018\u001eဈJ\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0ဌ*1ဌ+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08ဌ19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=Aဌ>Bဌ?Cဈ<Dဌ@EဉAFဂBGဂ8Hဂ9IဌCJဂ)Kဈ\u0017LဌDMဈEÉဉL", new Object[]{"zzdv", "zzfn", "zzfo", "zzfp", "zzef", "zzfq", "zzfr", "zzfs", "zzft", "zzfu", "zzfv", "zzfw", "zzfx", "zzfy", "zzfz", "zzga", "zzgb", "zzgc", "zzgd", "zzge", "zzgf", "zzgg", "zzgh", "zzid", "zzgi", "zzgj", "zzie", "zzii", "zzif", zzc.zzw(), "zzfg", "zzig", "zzgl", "zzih", "zzgm", "zzgn", "zzgo", "zzfi", "zzgp", "zzgq", "zzgr", "zzgs", "zzgt", "zzgu", "zzgv", "zzgw", "zzhj", zze.class, "zzgx", "zzgy", "zzfj", "zzfk", "zzha", zzcq.zzw(), "zzhb", zzcq.zzw(), "zzhi", "zzhc", "zzhd", "zzhe", "zzhf", "zzhg", "zzhh", zzcq.zzw(), "zzhk", "zzhl", "zzhm", "zzhn", "zzho", "zzhr", "zzhs", "zzhu", "zzhv", zzcm.zzw(), "zzhw", zzcr.zzw(), "zzht", "zzhx", EnumC0145zza.zzw(), "zzhy", "zzhz", "zzhp", "zzhq", "zzia", zzcq.zzw(), "zzgz", "zzgk", "zzib", zzcq.zzw(), "zzic", "zzij"});
                case 4:
                    return zzik;
                case 5:
                    zzemx<zza> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zza.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzik);
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

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzb extends zzelb<zzb, zza> implements zzemq {
        private static volatile zzemx<zzb> zzek;
        private static final zzb zzlf;
        private int zzdv;
        private long zzla;
        private int zzlb;
        private boolean zzlc;
        private zzelh zzld = zzelb.zzbil();
        private long zzle;

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zza extends zzelb.zzb<zzb, zza> implements zzemq {
            private zza() {
                super(zzb.zzlf);
            }

            /* synthetic */ zza(zzcg zzcgVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzlf = zzbVar;
            zzelb.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzcg.zzel[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzelb.zza(zzlf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003", new Object[]{"zzdv", "zzla", "zzlb", "zzlc", "zzld", "zzle"});
                case 4:
                    return zzlf;
                case 5:
                    zzemx<zzb> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zzb.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzlf);
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

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzd extends zzelb<zzd, zza> implements zzemq {
        private static volatile zzemx<zzd> zzek;
        private static final zzd zzme;
        private int zzdv;
        private long zzla;
        private String zzmc = "";
        private zzejr zzmd = zzejr.zzilz;

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zza extends zzelb.zzb<zzd, zza> implements zzemq {
            private zza() {
                super(zzd.zzme);
            }

            /* synthetic */ zza(zzcg zzcgVar) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzme = zzdVar;
            zzelb.zza(zzd.class, zzdVar);
        }

        private zzd() {
        }

        public static zzd zzbi() {
            return zzme;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzcg.zzel[i2 - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zzelb.zza(zzme, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzdv", "zzla", "zzmc", "zzmd"});
                case 4:
                    return zzme;
                case 5:
                    zzemx<zzd> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zzd.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzme);
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

        public final boolean zzbg() {
            return (this.zzdv & 1) != 0;
        }

        public final long zzbh() {
            return this.zzla;
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zze extends zzelb<zze, zza> implements zzemq {
        private static volatile zzemx<zze> zzek;
        private static final zze zzmf;
        private int zzdv;
        private String zzfl = "";

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zza extends zzelb.zzb<zze, zza> implements zzemq {
            private zza() {
                super(zze.zzmf);
            }

            /* synthetic */ zza(zzcg zzcgVar) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzmf = zzeVar;
            zzelb.zza(zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzcg.zzel[i2 - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zzelb.zza(zzmf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdv", "zzfl"});
                case 4:
                    return zzmf;
                case 5:
                    zzemx<zze> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zze.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzmf);
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

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzc extends zzelb<zzc, zza> implements zzemq {
        private static volatile zzemx<zzc> zzek;
        private static final zzc zzlk;
        private int zzdv;
        private zzejr zzlg;
        private zzejr zzlh;
        private zzejr zzli;
        private zzejr zzlj;

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zza extends zzelb.zzb<zzc, zza> implements zzemq {
            private zza() {
                super(zzc.zzlk);
            }

            public final zza zze(zzejr zzejrVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzc) this.zziqp).zza(zzejrVar);
                return this;
            }

            public final zza zzf(zzejr zzejrVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzc) this.zziqp).zzb(zzejrVar);
                return this;
            }

            public final zza zzg(zzejr zzejrVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzc) this.zziqp).zzc(zzejrVar);
                return this;
            }

            public final zza zzh(zzejr zzejrVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzc) this.zziqp).zzd(zzejrVar);
                return this;
            }

            /* synthetic */ zza(zzcg zzcgVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzlk = zzcVar;
            zzelb.zza(zzc.class, zzcVar);
        }

        private zzc() {
            zzejr zzejrVar = zzejr.zzilz;
            this.zzlg = zzejrVar;
            this.zzlh = zzejrVar;
            this.zzli = zzejrVar;
            this.zzlj = zzejrVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzejr zzejrVar) {
            zzejrVar.getClass();
            this.zzdv |= 1;
            this.zzlg = zzejrVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzejr zzejrVar) {
            zzejrVar.getClass();
            this.zzdv |= 2;
            this.zzlh = zzejrVar;
        }

        public static zza zzbe() {
            return zzlk.zzbii();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzejr zzejrVar) {
            zzejrVar.getClass();
            this.zzdv |= 4;
            this.zzli = zzejrVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(zzejr zzejrVar) {
            zzejrVar.getClass();
            this.zzdv |= 8;
            this.zzlj = zzejrVar;
        }

        public final zzejr zzba() {
            return this.zzlg;
        }

        public final zzejr zzbb() {
            return this.zzlh;
        }

        public final zzejr zzbc() {
            return this.zzli;
        }

        public final zzejr zzbd() {
            return this.zzlj;
        }

        public static zzc zzb(byte[] bArr, zzeko zzekoVar) throws zzelo {
            return (zzc) zzelb.zza(zzlk, bArr, zzekoVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzcg.zzel[i2 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zzelb.zza(zzlk, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzdv", "zzlg", "zzlh", "zzli", "zzlj"});
                case 4:
                    return zzlk;
                case 5:
                    zzemx<zzc> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zzc.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzlk);
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

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzf extends zzelb<zzf, zza> implements zzemq {
        private static volatile zzemx<zzf> zzek;
        private static final zzf zzmh;
        private int zzdv;
        private zzell<zzejr> zzmg = zzelb.zzbin();
        private zzejr zzlh = zzejr.zzilz;
        private int zzhw = 1;
        private int zzhv = 1;

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public static final class zza extends zzelb.zzb<zzf, zza> implements zzemq {
            private zza() {
                super(zzf.zzmh);
            }

            public final zza zza(zzcm zzcmVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzf) this.zziqp).zzb(zzcmVar);
                return this;
            }

            public final zza zzi(zzejr zzejrVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzf) this.zziqp).zzk(zzejrVar);
                return this;
            }

            public final zza zzj(zzejr zzejrVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zzf) this.zziqp).zzb(zzejrVar);
                return this;
            }

            /* synthetic */ zza(zzcg zzcgVar) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzmh = zzfVar;
            zzelb.zza(zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzejr zzejrVar) {
            zzejrVar.getClass();
            this.zzdv |= 1;
            this.zzlh = zzejrVar;
        }

        public static zza zzbl() {
            return zzmh.zzbii();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(zzejr zzejrVar) {
            zzejrVar.getClass();
            zzell<zzejr> zzellVar = this.zzmg;
            if (!zzellVar.zzbge()) {
                this.zzmg = zzelb.zza(zzellVar);
            }
            this.zzmg.add(zzejrVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzcg.zzel[i2 - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zzelb.zza(zzmh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zzdv", "zzmg", "zzlh", "zzhw", zzcr.zzw(), "zzhv", zzcm.zzw()});
                case 4:
                    return zzmh;
                case 5:
                    zzemx<zzf> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zzf.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzmh);
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzcm zzcmVar) {
            this.zzhv = zzcmVar.zzv();
            this.zzdv |= 4;
        }
    }
}
