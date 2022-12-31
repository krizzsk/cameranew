package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeoh {
    private static final Logger logger = Logger.getLogger(zzeoh.class.getName());
    private static final Unsafe zzhzj;
    private static final Class<?> zzilq;
    private static final boolean zzinc;
    private static final boolean zzivf;
    private static final boolean zzivg;
    private static final zzd zzivh;
    private static final boolean zzivi;
    private static final long zzivj;
    private static final long zzivk;
    private static final long zzivl;
    private static final long zzivm;
    private static final long zzivn;
    private static final long zzivo;
    private static final long zzivp;
    private static final long zzivq;
    private static final long zzivr;
    private static final long zzivs;
    private static final long zzivt;
    private static final long zzivu;
    private static final long zzivv;
    private static final long zzivw;
    private static final int zzivx;
    static final boolean zzivy;

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    private static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zza(Object obj, long j2, boolean z) {
            this.zziwb.putBoolean(obj, j2, z);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zze(Object obj, long j2, byte b) {
            this.zziwb.putByte(obj, j2, b);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final boolean zzm(Object obj, long j2) {
            return this.zziwb.getBoolean(obj, j2);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final float zzn(Object obj, long j2) {
            return this.zziwb.getFloat(obj, j2);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final double zzo(Object obj, long j2) {
            return this.zziwb.getDouble(obj, j2);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final byte zzy(Object obj, long j2) {
            return this.zziwb.getByte(obj, j2);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zza(Object obj, long j2, float f2) {
            this.zziwb.putFloat(obj, j2, f2);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zza(Object obj, long j2, double d2) {
            this.zziwb.putDouble(obj, j2, d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static abstract class zzd {
        Unsafe zziwb;

        zzd(Unsafe unsafe) {
            this.zziwb = unsafe;
        }

        public abstract void zza(Object obj, long j2, double d2);

        public abstract void zza(Object obj, long j2, float f2);

        public final void zza(Object obj, long j2, long j3) {
            this.zziwb.putLong(obj, j2, j3);
        }

        public abstract void zza(Object obj, long j2, boolean z);

        public final void zzb(Object obj, long j2, int i2) {
            this.zziwb.putInt(obj, j2, i2);
        }

        public abstract void zze(Object obj, long j2, byte b);

        public final int zzk(Object obj, long j2) {
            return this.zziwb.getInt(obj, j2);
        }

        public final long zzl(Object obj, long j2) {
            return this.zziwb.getLong(obj, j2);
        }

        public abstract boolean zzm(Object obj, long j2);

        public abstract float zzn(Object obj, long j2);

        public abstract double zzo(Object obj, long j2);

        public abstract byte zzy(Object obj, long j2);
    }

    static {
        Unsafe zzble = zzble();
        zzhzj = zzble;
        zzilq = zzejk.zzbgd();
        boolean zzm = zzm(Long.TYPE);
        zzivf = zzm;
        boolean zzm2 = zzm(Integer.TYPE);
        zzivg = zzm2;
        zzd zzdVar = null;
        if (zzble != null) {
            if (!zzejk.zzbgc()) {
                zzdVar = new zzb(zzble);
            } else if (zzm) {
                zzdVar = new zzc(zzble);
            } else if (zzm2) {
                zzdVar = new zza(zzble);
            }
        }
        zzivh = zzdVar;
        zzivi = zzblg();
        zzinc = zzblf();
        long zzk = zzk(byte[].class);
        zzivj = zzk;
        zzivk = zzk(boolean[].class);
        zzivl = zzl(boolean[].class);
        zzivm = zzk(int[].class);
        zzivn = zzl(int[].class);
        zzivo = zzk(long[].class);
        zzivp = zzl(long[].class);
        zzivq = zzk(float[].class);
        zzivr = zzl(float[].class);
        zzivs = zzk(double[].class);
        zzivt = zzl(double[].class);
        zzivu = zzk(Object[].class);
        zzivv = zzl(Object[].class);
        Field zzblh = zzblh();
        zzivw = (zzblh == null || zzdVar == null) ? -1L : zzdVar.zziwb.objectFieldOffset(zzblh);
        zzivx = (int) (7 & zzk);
        zzivy = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzeoh() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j2, long j3) {
        zzivh.zza(obj, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(Object obj, long j2, int i2) {
        zzivh.zzb(obj, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzblc() {
        return zzinc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzbld() {
        return zzivi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzble() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzeoj());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzblf() {
        Unsafe unsafe = zzhzj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (zzejk.zzbgc()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzblg() {
        Unsafe unsafe = zzhzj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzblh() == null) {
                return false;
            }
            if (zzejk.zzbgc()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field zzblh() {
        Field zzb2;
        if (!zzejk.zzbgc() || (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) == null) {
            Field zzb3 = zzb(Buffer.class, "address");
            if (zzb3 == null || zzb3.getType() != Long.TYPE) {
                return null;
            }
            return zzb3;
        }
        return zzb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j2, boolean z) {
        zzb(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zzj(Class<T> cls) {
        try {
            return (T) zzhzj.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int zzk(Class<?> cls) {
        if (zzinc) {
            return zzivh.zziwb.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzl(Class<?> cls) {
        if (zzinc) {
            return zzivh.zziwb.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzm(Object obj, long j2) {
        return zzivh.zzm(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzn(Object obj, long j2) {
        return zzivh.zzn(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzo(Object obj, long j2) {
        return zzivh.zzo(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzp(Object obj, long j2) {
        return zzivh.zziwb.getObject(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzq(Object obj, long j2) {
        return (byte) (zzk(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzr(Object obj, long j2) {
        return (byte) (zzk(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzs(Object obj, long j2) {
        return zzq(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(Object obj, long j2) {
        return zzr(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j2, boolean z) {
        zzivh.zza(obj, j2, z);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzm(Class<?> cls) {
        if (zzejk.zzbgc()) {
            try {
                Class<?> cls2 = zzilq;
                Class<?> cls3 = Boolean.TYPE;
                cls2.getMethod("peekLong", cls, cls3);
                cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
                Class<?> cls4 = Integer.TYPE;
                cls2.getMethod("pokeInt", cls, cls4, cls3);
                cls2.getMethod("peekInt", cls, cls3);
                cls2.getMethod("pokeByte", cls, Byte.TYPE);
                cls2.getMethod("peekByte", cls);
                cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
                cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    private static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zza(Object obj, long j2, boolean z) {
            if (!zzeoh.zzivy) {
                zzeoh.zzc(obj, j2, z);
            } else {
                zzeoh.zzb(obj, j2, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zze(Object obj, long j2, byte b) {
            if (!zzeoh.zzivy) {
                zzeoh.zzb(obj, j2, b);
            } else {
                zzeoh.zza(obj, j2, b);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final boolean zzm(Object obj, long j2) {
            return zzeoh.zzivy ? zzeoh.zzs(obj, j2) : zzeoh.zzt(obj, j2);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final float zzn(Object obj, long j2) {
            return Float.intBitsToFloat(zzk(obj, j2));
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final double zzo(Object obj, long j2) {
            return Double.longBitsToDouble(zzl(obj, j2));
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final byte zzy(Object obj, long j2) {
            return zzeoh.zzivy ? zzeoh.zzq(obj, j2) : zzeoh.zzr(obj, j2);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zza(Object obj, long j2, float f2) {
            zzb(obj, j2, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zza(Object obj, long j2, double d2) {
            zza(obj, j2, Double.doubleToLongBits(d2));
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    private static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zza(Object obj, long j2, boolean z) {
            if (!zzeoh.zzivy) {
                zzeoh.zzc(obj, j2, z);
            } else {
                zzeoh.zzb(obj, j2, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zze(Object obj, long j2, byte b) {
            if (!zzeoh.zzivy) {
                zzeoh.zzb(obj, j2, b);
            } else {
                zzeoh.zza(obj, j2, b);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final boolean zzm(Object obj, long j2) {
            return zzeoh.zzivy ? zzeoh.zzs(obj, j2) : zzeoh.zzt(obj, j2);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final float zzn(Object obj, long j2) {
            return Float.intBitsToFloat(zzk(obj, j2));
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final double zzo(Object obj, long j2) {
            return Double.longBitsToDouble(zzl(obj, j2));
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final byte zzy(Object obj, long j2) {
            return zzeoh.zzivy ? zzeoh.zzq(obj, j2) : zzeoh.zzr(obj, j2);
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zza(Object obj, long j2, float f2) {
            zzb(obj, j2, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.ads.zzeoh.zzd
        public final void zza(Object obj, long j2, double d2) {
            zza(obj, j2, Double.doubleToLongBits(d2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j2, float f2) {
        zzivh.zza(obj, j2, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j2, byte b) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        zzb(obj, j3, ((255 & b) << i2) | (zzk(obj, j3) & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(Object obj, long j2) {
        return zzivh.zzk(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzl(Object obj, long j2) {
        return zzivh.zzl(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j2, double d2) {
        zzivh.zza(obj, j2, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j2, Object obj2) {
        zzivh.zziwb.putObject(obj, j2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j2, boolean z) {
        zza(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte zza(byte[] bArr, long j2) {
        return zzivh.zzy(bArr, zzivj + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(byte[] bArr, long j2, byte b) {
        zzivh.zze(bArr, zzivj + j2, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j2, byte b) {
        long j3 = (-4) & j2;
        int zzk = zzk(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        zzb(obj, j3, ((255 & b) << i2) | (zzk & (~(255 << i2))));
    }
}
