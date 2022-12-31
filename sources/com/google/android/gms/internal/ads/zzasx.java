package com.google.android.gms.internal.ads;

import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzasx implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzass zzdtz;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasx(zzass zzassVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdtz = zzassVar;
        this.zzdub = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                this.zzdtz.zza(thread, th);
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdub;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            }
        } catch (Throwable unused) {
            zzazk.zzev("AdMob exception reporter failed reporting the exception.");
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdub;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
        }
    }
}
