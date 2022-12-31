package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzego extends zzelb<zzego, zzb> implements zzemq {
    private static volatile zzemx<zzego> zzek;
    private static final zzego zzihy;
    private int zzihq;
    private zzell<zza> zzihx = zzelb.zzbin();

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza extends zzelb<zza, C0148zza> implements zzemq {
        private static volatile zzemx<zza> zzek;
        private static final zza zzihz;
        private String zzigs = "";
        private int zzihj;
        private int zzihu;
        private int zzihv;

        /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzego$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0148zza extends zzelb.zzb<zza, C0148zza> implements zzemq {
            private C0148zza() {
                super(zza.zzihz);
            }

            public final C0148zza zzb(zzege zzegeVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zza(zzegeVar);
                return this;
            }

            public final C0148zza zzfo(int i2) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzfm(i2);
                return this;
            }

            public final C0148zza zzhv(String str) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zzht(str);
                return this;
            }

            /* synthetic */ C0148zza(zzegn zzegnVar) {
                this();
            }

            public final C0148zza zzb(zzegx zzegxVar) {
                if (this.zziqq) {
                    zzbis();
                    this.zziqq = false;
                }
                ((zza) this.zziqp).zza(zzegxVar);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzihz = zzaVar;
            zzelb.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzege zzegeVar) {
            this.zzihu = zzegeVar.zzv();
        }

        public static C0148zza zzbeu() {
            return zzihz.zzbii();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzfm(int i2) {
            this.zzihv = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzht(String str) {
            str.getClass();
            this.zzigs = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzegx zzegxVar) {
            this.zzihj = zzegxVar.zzv();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzelb
        public final Object zza(int i2, Object obj, Object obj2) {
            switch (zzegn.zzel[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0148zza(null);
                case 3:
                    return zzelb.zza(zzihz, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzigs", "zzihu", "zzihv", "zzihj"});
                case 4:
                    return zzihz;
                case 5:
                    zzemx<zza> zzemxVar = zzek;
                    if (zzemxVar == null) {
                        synchronized (zza.class) {
                            zzemxVar = zzek;
                            if (zzemxVar == null) {
                                zzemxVar = new zzelb.zza<>(zzihz);
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
    public static final class zzb extends zzelb.zzb<zzego, zzb> implements zzemq {
        private zzb() {
            super(zzego.zzihy);
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzego) this.zziqp).zza(zzaVar);
            return this;
        }

        public final zzb zzfn(int i2) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            ((zzego) this.zziqp).zzfl(i2);
            return this;
        }

        /* synthetic */ zzb(zzegn zzegnVar) {
            this();
        }
    }

    static {
        zzego zzegoVar = new zzego();
        zzihy = zzegoVar;
        zzelb.zza(zzego.class, zzegoVar);
    }

    private zzego() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        zzaVar.getClass();
        zzell<zza> zzellVar = this.zzihx;
        if (!zzellVar.zzbge()) {
            this.zzihx = zzelb.zza(zzellVar);
        }
        this.zzihx.add(zzaVar);
    }

    public static zzb zzbes() {
        return zzihy.zzbii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzfl(int i2) {
        this.zzihq = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelb
    public final Object zza(int i2, Object obj, Object obj2) {
        switch (zzegn.zzel[i2 - 1]) {
            case 1:
                return new zzego();
            case 2:
                return new zzb(null);
            case 3:
                return zzelb.zza(zzihy, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzihq", "zzihx", zza.class});
            case 4:
                return zzihy;
            case 5:
                zzemx<zzego> zzemxVar = zzek;
                if (zzemxVar == null) {
                    synchronized (zzego.class) {
                        zzemxVar = zzek;
                        if (zzemxVar == null) {
                            zzemxVar = new zzelb.zza<>(zzihy);
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
