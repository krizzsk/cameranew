package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class zzkg {
    final Unsafe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkg(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract byte zza(Object obj, long j2);

    public abstract void zzb(Object obj, long j2, byte b);

    public abstract boolean zzc(Object obj, long j2);

    public abstract void zzd(Object obj, long j2, boolean z);

    public abstract float zze(Object obj, long j2);

    public abstract void zzf(Object obj, long j2, float f2);

    public abstract double zzg(Object obj, long j2);

    public abstract void zzh(Object obj, long j2, double d2);

    public boolean zzi() {
        Unsafe unsafe = this.zza;
        if (unsafe != null) {
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
                return true;
            } catch (Throwable th) {
                zzkh.zzs(th);
            }
        }
        return false;
    }

    public boolean zzj() {
        Field zzF;
        Unsafe unsafe = this.zza;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                zzF = zzkh.zzF();
                return zzF != null;
            } catch (Throwable th) {
                zzkh.zzs(th);
            }
        }
        return false;
    }

    public final long zzk(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final int zzl(Class<?> cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzm(Class<?> cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzn(Object obj, long j2) {
        return this.zza.getInt(obj, j2);
    }

    public final void zzo(Object obj, long j2, int i2) {
        this.zza.putInt(obj, j2, i2);
    }

    public final long zzp(Object obj, long j2) {
        return this.zza.getLong(obj, j2);
    }

    public final void zzq(Object obj, long j2, long j3) {
        this.zza.putLong(obj, j2, j3);
    }

    public final Object zzr(Object obj, long j2) {
        return this.zza.getObject(obj, j2);
    }

    public final void zzs(Object obj, long j2, Object obj2) {
        this.zza.putObject(obj, j2, obj2);
    }
}
