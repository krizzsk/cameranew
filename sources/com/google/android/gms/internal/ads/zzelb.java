package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
import com.google.android.gms.internal.ads.zzelb.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzelb<MessageType extends zzelb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzejh<MessageType, BuilderType> {
    private static Map<Object, zzelb<?, ?>> zziqm = new ConcurrentHashMap();
    protected zzeoe zziqk = zzeoe.zzbkz();
    private int zziql = -1;

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    protected static class zza<T extends zzelb<T, ?>> extends zzeji<T> {
        private final T zziqo;

        public zza(T t) {
            this.zziqo = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    static final class zzc implements zzekw<zzc> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzekw
        public final zzemn zza(zzemn zzemnVar, zzemo zzemoVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzekw
        public final zzeos zzbid() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzekw
        public final zzeov zzbie() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzekw
        public final boolean zzbif() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzekw
        public final boolean zzbig() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzekw
        public final int zzv() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzekw
        public final zzemt zza(zzemt zzemtVar, zzemt zzemtVar2) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzelb<MessageType, BuilderType> implements zzemq {
        protected zzeku<zzc> zziqr = zzeku.zzbib();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zzeku<zzc> zzbix() {
            if (this.zziqr.isImmutable()) {
                this.zziqr = (zzeku) this.zziqr.clone();
            }
            return this.zziqr;
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public enum zze {
        public static final int zziqs = 1;
        public static final int zziqt = 2;
        public static final int zziqu = 3;
        public static final int zziqv = 4;
        public static final int zziqw = 5;
        public static final int zziqx = 6;
        public static final int zziqy = 7;
        private static final /* synthetic */ int[] zziqz = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zzbiy() {
            return (int[]) zziqz.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static class zzf<ContainingType extends zzemo, Type> extends zzekp<ContainingType, Type> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzelb<?, ?>> void zza(Class<T> cls, T t) {
        zziqm.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzelh zzbil() {
        return zzele.zzbiz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzelm zzbim() {
        return zzemc.zzbjr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzell<E> zzbin() {
        return zzenb.zzbke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzelb<?, ?>> T zzd(Class<T> cls) {
        zzelb<?, ?> zzelbVar = zziqm.get(cls);
        if (zzelbVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzelbVar = zziqm.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzelbVar == null) {
            zzelbVar = (T) ((zzelb) zzeoh.zzj(cls)).zza(zze.zziqx, (Object) null, (Object) null);
            if (zzelbVar != null) {
                zziqm.put(cls, zzelbVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzelbVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzenc.zzbkf().zzax(this).equals(this, (zzelb) obj);
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.zzilm;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = zzenc.zzbkf().zzax(this).hashCode(this);
        this.zzilm = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzemq
    public final boolean isInitialized() {
        return zza(this, true);
    }

    public String toString() {
        return zzemp.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i2, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.ads.zzemo
    public final void zzb(zzekl zzeklVar) throws IOException {
        zzenc.zzbkf().zzax(this).zza(this, zzekn.zza(zzeklVar));
    }

    @Override // com.google.android.gms.internal.ads.zzejh
    final int zzbga() {
        return this.zziql;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzelb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbii() {
        return (BuilderType) zza(zze.zziqw, (Object) null, (Object) null);
    }

    public final BuilderType zzbij() {
        BuilderType buildertype = (BuilderType) zza(zze.zziqw, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzemo
    public final int zzbik() {
        if (this.zziql == -1) {
            this.zziql = zzenc.zzbkf().zzax(this).zzau(this);
        }
        return this.zziql;
    }

    @Override // com.google.android.gms.internal.ads.zzemo
    public final /* synthetic */ zzemn zzbio() {
        zzb zzbVar = (zzb) zza(zze.zziqw, (Object) null, (Object) null);
        zzbVar.zza(this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemo
    public final /* synthetic */ zzemn zzbip() {
        return (zzb) zza(zze.zziqw, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzemq
    public final /* synthetic */ zzemo zzbiq() {
        return (zzelb) zza(zze.zziqx, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzejh
    final void zzfv(int i2) {
        this.zziql = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzemo zzemoVar, String str, Object[] objArr) {
        return new zzene(zzemoVar, str, objArr);
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    public static abstract class zzb<MessageType extends zzelb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzejg<MessageType, BuilderType> {
        private final MessageType zziqo;
        protected MessageType zziqp;
        protected boolean zziqq = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zzb(MessageType messagetype) {
            this.zziqo = messagetype;
            this.zziqp = (MessageType) messagetype.zza(zze.zziqv, null, null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzenc.zzbkf().zzax(messagetype).zzg(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.ads.zzejg
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zziqo.zza(zze.zziqw, null, null);
            zzbVar.zza((zzelb) zzbiv());
            return zzbVar;
        }

        @Override // com.google.android.gms.internal.ads.zzemq
        public final boolean isInitialized() {
            return zzelb.zza(this.zziqp, false);
        }

        @Override // com.google.android.gms.internal.ads.zzejg
        /* renamed from: zzb */
        public final BuilderType zza(MessageType messagetype) {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            zza(this.zziqp, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.ads.zzejg
        public final /* synthetic */ zzejg zzbfy() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzemq
        public final /* synthetic */ zzemo zzbiq() {
            return this.zziqo;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void zzbis() {
            MessageType messagetype = (MessageType) this.zziqp.zza(zze.zziqv, null, null);
            zza(messagetype, this.zziqp);
            this.zziqp = messagetype;
        }

        @Override // com.google.android.gms.internal.ads.zzemn
        /* renamed from: zzbit */
        public MessageType zzbiv() {
            if (this.zziqq) {
                return this.zziqp;
            }
            MessageType messagetype = this.zziqp;
            zzenc.zzbkf().zzax(messagetype).zzak(messagetype);
            this.zziqq = true;
            return this.zziqp;
        }

        @Override // com.google.android.gms.internal.ads.zzemn
        /* renamed from: zzbiu */
        public final MessageType zzbiw() {
            MessageType messagetype = (MessageType) zzbiv();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzeoc(messagetype);
        }

        @Override // com.google.android.gms.internal.ads.zzejg
        public final /* synthetic */ zzejg zza(byte[] bArr, int i2, int i3, zzeko zzekoVar) throws zzelo {
            return zzb(bArr, 0, i3, zzekoVar);
        }

        private final BuilderType zzb(byte[] bArr, int i2, int i3, zzeko zzekoVar) throws zzelo {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            try {
                zzenc.zzbkf().zzax(this.zziqp).zza(this.zziqp, bArr, 0, i3, new zzejm(zzekoVar));
                return this;
            } catch (zzelo e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            } catch (IndexOutOfBoundsException unused) {
                throw zzelo.zzbja();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.ads.zzejg
        /* renamed from: zzb */
        public final BuilderType zza(zzekc zzekcVar, zzeko zzekoVar) throws IOException {
            if (this.zziqq) {
                zzbis();
                this.zziqq = false;
            }
            try {
                zzenc.zzbkf().zzax(this.zziqp).zza(this.zziqp, zzekj.zza(zzekcVar), zzekoVar);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Method method, Object obj, Object... objArr) {
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

    private static <T extends zzelb<T, ?>> T zzb(T t, zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        try {
            zzekc zzbgk = zzejrVar.zzbgk();
            T t2 = (T) zza(t, zzbgk, zzekoVar);
            try {
                zzbgk.zzgd(0);
                return t2;
            } catch (zzelo e2) {
                throw e2.zzl(t2);
            }
        } catch (zzelo e3) {
            throw e3;
        }
    }

    protected static final <T extends zzelb<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zziqs, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzaw = zzenc.zzbkf().zzax(t).zzaw(t);
        if (z) {
            t.zza(zze.zziqt, zzaw ? t : null, null);
        }
        return zzaw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzelh zza(zzelh zzelhVar) {
        int size = zzelhVar.size();
        return zzelhVar.zzhg(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzell<E> zza(zzell<E> zzellVar) {
        int size = zzellVar.size();
        return zzellVar.zzfy(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzelb<T, ?>> T zza(T t, zzekc zzekcVar, zzeko zzekoVar) throws zzelo {
        T t2 = (T) t.zza(zze.zziqv, null, null);
        try {
            zzenj zzax = zzenc.zzbkf().zzax(t2);
            zzax.zza(t2, zzekj.zza(zzekcVar), zzekoVar);
            zzax.zzak(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzelo) {
                throw ((zzelo) e2.getCause());
            }
            throw new zzelo(e2.getMessage()).zzl(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzelo) {
                throw ((zzelo) e3.getCause());
            }
            throw e3;
        }
    }

    private static <T extends zzelb<T, ?>> T zza(T t, byte[] bArr, int i2, int i3, zzeko zzekoVar) throws zzelo {
        T t2 = (T) t.zza(zze.zziqv, null, null);
        try {
            zzenj zzax = zzenc.zzbkf().zzax(t2);
            zzax.zza(t2, bArr, 0, i3, new zzejm(zzekoVar));
            zzax.zzak(t2);
            if (t2.zzilm == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzelo) {
                throw ((zzelo) e2.getCause());
            }
            throw new zzelo(e2.getMessage()).zzl(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzelo.zzbja().zzl(t2);
        }
    }

    private static <T extends zzelb<T, ?>> T zza(T t) throws zzelo {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzelo(new zzeoc(t).getMessage()).zzl(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzelb<T, ?>> T zza(T t, zzejr zzejrVar) throws zzelo {
        return (T) zza(zza(zzb(t, zzejrVar, zzeko.zzbhw())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzelb<T, ?>> T zza(T t, zzejr zzejrVar, zzeko zzekoVar) throws zzelo {
        return (T) zza(zzb(t, zzejrVar, zzekoVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzelb<T, ?>> T zza(T t, byte[] bArr) throws zzelo {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzeko.zzbhw()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzelb<T, ?>> T zza(T t, byte[] bArr, zzeko zzekoVar) throws zzelo {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzekoVar));
    }
}
