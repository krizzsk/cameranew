package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdyn<I, O, F, T> extends zzdze<O> implements Runnable {
    @NullableDecl
    private zzdzw<? extends I> zzhyu;
    @NullableDecl
    private F zzhzq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyn(zzdzw<? extends I> zzdzwVar, F f2) {
        this.zzhyu = (zzdzw) zzdwl.checkNotNull(zzdzwVar);
        this.zzhzq = (F) zzdwl.checkNotNull(f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> zzdzw<O> zza(zzdzw<I> zzdzwVar, zzdyu<? super I, ? extends O> zzdyuVar, Executor executor) {
        zzdwl.checkNotNull(executor);
        zzdym zzdymVar = new zzdym(zzdzwVar, zzdyuVar);
        zzdzwVar.addListener(zzdymVar, zzdzy.zza(executor, zzdymVar));
        return zzdymVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdyk
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhyu);
        this.zzhyu = null;
        this.zzhzq = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdyk
    public final String pendingToString() {
        String str;
        zzdzw<? extends I> zzdzwVar = this.zzhyu;
        F f2 = this.zzhzq;
        String pendingToString = super.pendingToString();
        if (zzdzwVar != null) {
            String valueOf = String.valueOf(zzdzwVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        } else {
            str = "";
        }
        if (f2 == null) {
            if (pendingToString != null) {
                String valueOf2 = String.valueOf(str);
                String valueOf3 = String.valueOf(pendingToString);
                return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
            }
            return null;
        }
        String valueOf4 = String.valueOf(f2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf4).length());
        sb2.append(str);
        sb2.append("function=[");
        sb2.append(valueOf4);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        zzdzw<? extends I> zzdzwVar = this.zzhyu;
        F f2 = this.zzhzq;
        if ((isCancelled() | (zzdzwVar == null)) || (f2 == null)) {
            return;
        }
        this.zzhyu = null;
        if (zzdzwVar.isCancelled()) {
            setFuture(zzdzwVar);
            return;
        }
        try {
            try {
                Object zzd = zzd(f2, zzdzk.zza(zzdzwVar));
                this.zzhzq = null;
                setResult(zzd);
            } catch (Throwable th) {
                try {
                    setException(th);
                } finally {
                    this.zzhzq = null;
                }
            }
        } catch (Error e2) {
            setException(e2);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e3) {
            setException(e3);
        } catch (ExecutionException e4) {
            setException(e4.getCause());
        }
    }

    abstract void setResult(@NullableDecl T t);

    @NullableDecl
    abstract T zzd(F f2, @NullableDecl I i2) throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> zzdzw<O> zza(zzdzw<I> zzdzwVar, zzdvz<? super I, ? extends O> zzdvzVar, Executor executor) {
        zzdwl.checkNotNull(zzdvzVar);
        zzdyp zzdypVar = new zzdyp(zzdzwVar, zzdvzVar);
        zzdzwVar.addListener(zzdypVar, zzdzy.zza(executor, zzdypVar));
        return zzdypVar;
    }
}
