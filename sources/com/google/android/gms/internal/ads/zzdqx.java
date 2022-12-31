package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
/* JADX WARN: Field signature parse error: zzhpu
jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: TE at position 1 ('E'), unexpected: T
	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
	at jadx.core.dex.visitors.SignatureProcessor.parseFieldSignature(SignatureProcessor.java:83)
	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:33)
 */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdqx {
    private final Object zzhpu;
    private final List<zzdzw<?>> zzhpx;
    private final /* synthetic */ zzdqv zzhpy;

    private zzdqx(zzdqv zzdqvVar, E e2, List<zzdzw<?>> list) {
        this.zzhpy = zzdqvVar;
        this.zzhpu = e2;
        this.zzhpx = list;
    }

    public final <O> zzdrb<O> zzb(Callable<O> callable) {
        zzdzv zzdzvVar;
        zzdzp zzk = zzdzk.zzk(this.zzhpx);
        zzdzw zzb = zzk.zzb(zzdra.zzhca, zzazp.zzeih);
        zzdqv zzdqvVar = this.zzhpy;
        Object obj = this.zzhpu;
        List<zzdzw<?>> list = this.zzhpx;
        zzdzvVar = zzdqvVar.zzghl;
        return new zzdrb<>(zzdqvVar, obj, zzb, list, zzk.zzb(callable, zzdzvVar));
    }
}
