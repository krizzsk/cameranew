package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;
/* JADX WARN: Field signature parse error: zzhpu
jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: TE at position 1 ('E'), unexpected: T
	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
	at jadx.core.dex.visitors.SignatureProcessor.parseFieldSignature(SignatureProcessor.java:83)
	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:33)
 */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdqz {
    private final Object zzhpu;
    private final /* synthetic */ zzdqv zzhpy;

    /* JADX WARN: Failed to parse method signature: (TE)V
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: (TE)V at position 2 ('E'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeMethodArgs(SignatureParser.java:318)
    	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:109)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
     */
    private zzdqz(zzdqv zzdqvVar, Object obj) {
        this.zzhpy = zzdqvVar;
        this.zzhpu = obj;
    }

    private final <O> zzdrb<O> zza(Callable<O> callable, zzdzv zzdzvVar) {
        zzdzw zzdzwVar;
        zzdqv zzdqvVar = this.zzhpy;
        Object obj = this.zzhpu;
        zzdzwVar = zzdqv.zzhps;
        return new zzdrb<>(zzdqvVar, obj, zzdzwVar, Collections.emptyList(), zzdzvVar.zze(callable));
    }

    public final <O> zzdrb<O> zzc(Callable<O> callable) {
        zzdzv zzdzvVar;
        zzdzvVar = this.zzhpy.zzghl;
        return zza(callable, zzdzvVar);
    }

    public final <O> zzdrb<O> zze(zzdzw<O> zzdzwVar) {
        zzdzw zzdzwVar2;
        zzdqv zzdqvVar = this.zzhpy;
        Object obj = this.zzhpu;
        zzdzwVar2 = zzdqv.zzhps;
        return new zzdrb<>(zzdqvVar, obj, zzdzwVar2, Collections.emptyList(), zzdzwVar);
    }

    public final zzdrb<?> zza(final zzdqt zzdqtVar, zzdzv zzdzvVar) {
        return zza(new Callable(zzdqtVar) { // from class: com.google.android.gms.internal.ads.zzdrc
            private final zzdqt zzhqb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhqb = zzdqtVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.zzhqb.run();
                return null;
            }
        }, zzdzvVar);
    }
}
