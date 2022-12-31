package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbw {

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb<zza, zzb> implements zzemq {
        private static final zza zzej;
        private static volatile zzemx<zza> zzek;
        private int zzdv;
        private long zzdx;
        private long zzeb;
        private long zzec;
        private long zzee;
        private int zzei;
        private String zzdw = "";
        private String zzdy = "";
        private String zzdz = "";
        private String zzea = "";
        private String zzed = "";
        private String zzef = "";
        private String zzeg = "";
        private zzell<C0142zza> zzeh = zzelb.zzbin();

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0142zza extends zzelb<C0142zza, C0143zza> implements zzemq {
            private static volatile zzemx<C0142zza> zzek;
            private static final C0142zza zzeo;
            private int zzdv;
            private String zzem = "";
            private String zzen = "";

            /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0143zza extends zzelb.zzb<C0142zza, C0143zza> implements zzemq {
                private C0143zza() {
                    super(C0142zza.zzeo);
                }

                /* synthetic */ C0143zza(zzbx zzbxVar) {
                    this();
                }
            }

            static {
                C0142zza c0142zza = new C0142zza();
                zzeo = c0142zza;
                zzelb.zza(C0142zza.class, c0142zza);
            }

            private C0142zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzelb
            public final Object zza(int i2, Object obj, Object obj2) {
                switch (zzbx.zzel[i2 - 1]) {
                    case 1:
                        return new C0142zza();
                    case 2:
                        return new C0143zza(null);
                    case 3:
                        return zzelb.zza(zzeo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzdv", "zzem", "zzen"});
                    case 4:
                        return zzeo;
                    case 5:
                        zzemx<C0142zza> zzemxVar = zzek;
                        if (zzemxVar == null) {
                            synchronized (C0142zza.class) {
                                zzemxVar = zzek;
                                if (zzemxVar == null) {
                                    zzemxVar = new zzelb.zza<>(zzeo);
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
        public static final class zzb extends zzelb.zzb<zza, zzb> implements zzemq {
            private zzb() {
                super(zza.zzej);
            }

            public final zzb zzb(zzc zzcVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zza(zzcVar);
                return this;
            }

            public final zzb zzd(long j2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzc(j2);
                return this;
            }

            public final zzb zzo(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzj(str);
                return this;
            }

            public final zzb zzp(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzk(str);
                return this;
            }

            public final zzb zzq(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzl(str);
                return this;
            }

            public final zzb zzr(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzm(str);
                return this;
            }

            public final zzb zzs(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzn(str);
                return this;
            }

            /* synthetic */ zzb(zzbx zzbxVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
        /* loaded from: classes2.dex */
        public enum zzc implements zzelg {
            UNKNOWN(0),
            ENABLED(1),
            DISABLED(2);
            
            private static final zzelf<zzc> zzes = new zzbz();
            private final int value;

            zzc(int i2) {
                this.value = i2;
            }

            public static zzc zzh(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return DISABLED;
                    }
                    return ENABLED;
                }
                return UNKNOWN;
            }

            public static zzeli zzw() {
                return zzby.zzeu;
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
            zzej = zzaVar;
            zzelb.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            this.zzei = zzcVar.zzv();
            this.zzdv |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(long j2) {
            this.zzdv |= 2;
            this.zzdx = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zzdv |= 1;
            this.zzdw = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(String str) {
            str.getClass();
            this.zzdv |= 4;
            this.zzdy = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(String str) {
            str.getClass();
            this.zzdv |= 8;
            this.zzdz = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(String str) {
            str.getClass();
            this.zzdv |= 16;
            this.zzea = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzdv |= 1024;
            this.zzeg = str;
        }

        public static zzb zzs() {
            return zzej.zzbii();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzbx.zzel[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzelb.zza(zzej, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zzdv", "zzdw", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", "zzeg", "zzeh", C0142zza.class, "zzei", zzc.zzw()});
                case 4:
                    return zzej;
                case 5:
                    zzemx<zza> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zza.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzej);
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
}
