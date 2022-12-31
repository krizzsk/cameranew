package com.google.android.gms.internal.ads;

import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzasu implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdty;
    private final /* synthetic */ zzass zzdtz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasu(zzass zzassVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdtz = zzassVar;
        this.zzdty = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                this.zzdtz.zza(thread, th);
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdty;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            }
        } catch (Throwable unused) {
            zzazk.zzev("AdMob exception reporter failed reporting the exception.");
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdty;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
        }
    }
}
