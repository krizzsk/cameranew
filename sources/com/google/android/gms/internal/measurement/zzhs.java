package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class zzhs<MessageType extends zzhs<MessageType, BuilderType>, BuilderType extends zzho<MessageType, BuilderType>> extends zzgb<MessageType, BuilderType> {
    private static final Map<Object, zzhs<?, ?>> zza = new ConcurrentHashMap();
    protected zzjx zzc = zzjx.zza();
    protected int zzd = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzbA(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzhx zzbB() {
        return zzht.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzhy zzbC() {
        return zzim.zzf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzhy zzbD(zzhy zzhyVar) {
        int size = zzhyVar.size();
        return zzhyVar.zzd(size == 0 ? 10 : size + size);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzhz<E> zzbE() {
        return zzjg.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzhz<E> zzbF(zzhz<E> zzhzVar) {
        int size = zzhzVar.size();
        return zzhzVar.zze(size == 0 ? 10 : size + size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzhs> T zzbx(Class<T> cls) {
        Map<Object, zzhs<?, ?>> map = zza;
        zzhs<?, ?> zzhsVar = map.get(cls);
        if (zzhsVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzhsVar = map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzhsVar == null) {
            zzhsVar = (zzhs) ((zzhs) zzkh.zzc(cls)).zzl(6, null, null);
            if (zzhsVar != null) {
                map.put(cls, zzhsVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzhsVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzhs> void zzby(Class<T> cls, T t) {
        zza.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzbz(zzix zzixVar, String str, Object[] objArr) {
        return new zzjh(zzixVar, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzjf.zza().zzb(getClass()).zzb(this, (zzhs) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzb;
        if (i2 != 0) {
            return i2;
        }
        int zzc = zzjf.zza().zzb(getClass()).zzc(this);
        this.zzb = zzc;
        return zzc;
    }

    public final String toString() {
        return zziz.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    public final /* bridge */ /* synthetic */ zziw zzbG() {
        zzho zzhoVar = (zzho) zzl(5, null, null);
        zzhoVar.zzaB(this);
        return zzhoVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    public final /* bridge */ /* synthetic */ zziw zzbH() {
        return (zzho) zzl(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zziy
    public final /* bridge */ /* synthetic */ zzix zzbK() {
        return (zzhs) zzl(6, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzgb
    public final int zzbq() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzgb
    public final void zzbr(int i2) {
        this.zzd = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzhs<MessageType, BuilderType>, BuilderType extends zzho<MessageType, BuilderType>> BuilderType zzbt() {
        return (BuilderType) zzl(5, null, null);
    }

    public final BuilderType zzbu() {
        BuilderType buildertype = (BuilderType) zzl(5, null, null);
        buildertype.zzaB(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    public final void zzbv(zzgz zzgzVar) throws IOException {
        zzjf.zza().zzb(getClass()).zzm(this, zzha.zza(zzgzVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    public final int zzbw() {
        int i2 = this.zzd;
        if (i2 == -1) {
            int zze = zzjf.zza().zzb(getClass()).zze(this);
            this.zzd = zze;
            return zze;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzl(int i2, Object obj, Object obj2);
}
