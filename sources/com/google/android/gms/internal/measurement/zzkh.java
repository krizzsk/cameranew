package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzkh {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd;
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzkg zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    static {
        Unsafe zzr = zzr();
        zzc = zzr;
        zzd = zzgd.zzb();
        boolean zzE = zzE(Long.TYPE);
        zze = zzE;
        boolean zzE2 = zzE(Integer.TYPE);
        zzf = zzE2;
        zzkg zzkgVar = null;
        if (zzr != null) {
            if (!zzgd.zza()) {
                zzkgVar = new zzkf(zzr);
            } else if (zzE) {
                zzkgVar = new zzke(zzr);
            } else if (zzE2) {
                zzkgVar = new zzkd(zzr);
            }
        }
        zzg = zzkgVar;
        zzh = zzkgVar == null ? false : zzkgVar.zzj();
        zzi = zzkgVar == null ? false : zzkgVar.zzi();
        zza = zzC(byte[].class);
        zzC(boolean[].class);
        zzD(boolean[].class);
        zzC(int[].class);
        zzD(int[].class);
        zzC(long[].class);
        zzD(long[].class);
        zzC(float[].class);
        zzD(float[].class);
        zzC(double[].class);
        zzD(double[].class);
        zzC(Object[].class);
        zzD(Object[].class);
        Field zzF = zzF();
        if (zzF != null && zzkgVar != null) {
            zzkgVar.zzk(zzF);
        }
        zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzkh() {
    }

    private static int zzC(Class<?> cls) {
        if (zzi) {
            return zzg.zzl(cls);
        }
        return -1;
    }

    private static int zzD(Class<?> cls) {
        if (zzi) {
            return zzg.zzm(cls);
        }
        return -1;
    }

    private static boolean zzE(Class<?> cls) {
        if (zzgd.zza()) {
            try {
                Class<?> cls2 = zzd;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static Field zzF() {
        Field zzG;
        if (!zzgd.zza() || (zzG = zzG(Buffer.class, "effectiveDirectAddress")) == null) {
            Field zzG2 = zzG(Buffer.class, "address");
            if (zzG2 == null || zzG2.getType() != Long.TYPE) {
                return null;
            }
            return zzG2;
        }
        return zzG;
    }

    private static Field zzG(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzH(Object obj, long j2) {
        return (byte) ((zzg.zzn(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzI(Object obj, long j2) {
        return (byte) ((zzg.zzn(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzJ(Object obj, long j2, byte b) {
        long j3 = (-4) & j2;
        zzkg zzkgVar = zzg;
        int zzn = zzkgVar.zzn(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        zzkgVar.zzo(obj, j3, ((255 & b) << i2) | (zzn & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzK(Object obj, long j2, byte b) {
        long j3 = (-4) & j2;
        zzkg zzkgVar = zzg;
        int i2 = (((int) j2) & 3) << 3;
        zzkgVar.zzo(obj, j3, ((255 & b) << i2) | (zzkgVar.zzn(obj, j3) & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza() {
        return zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb() {
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zzc(Class<T> cls) {
        try {
            return (T) zzc.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(Object obj, long j2) {
        return zzg.zzn(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zze(Object obj, long j2, int i2) {
        zzg.zzo(obj, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzf(Object obj, long j2) {
        return zzg.zzp(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzg(Object obj, long j2, long j3) {
        zzg.zzq(obj, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(Object obj, long j2) {
        return zzg.zzc(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzi(Object obj, long j2, boolean z) {
        zzg.zzd(obj, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzj(Object obj, long j2) {
        return zzg.zze(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzk(Object obj, long j2, float f2) {
        zzg.zzf(obj, j2, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzl(Object obj, long j2) {
        return zzg.zzg(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzm(Object obj, long j2, double d2) {
        zzg.zzh(obj, j2, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzn(Object obj, long j2) {
        return zzg.zzr(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzo(Object obj, long j2, Object obj2) {
        zzg.zzs(obj, j2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte zzp(byte[] bArr, long j2) {
        return zzg.zza(bArr, zza + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzq(byte[] bArr, long j2, byte b) {
        zzg.zzb(bArr, zza + j2, b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzr() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzkc());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzs(Throwable th) {
        Logger logger = Logger.getLogger(zzkh.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
        sb.append("platform method missing - proto runtime falling back to safer methods: ");
        sb.append(valueOf);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzy(Object obj, long j2) {
        return zzH(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzz(Object obj, long j2) {
        return zzI(obj, j2) != 0;
    }
}
