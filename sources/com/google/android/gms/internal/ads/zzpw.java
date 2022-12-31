package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzpw implements ThreadFactory {
    private final /* synthetic */ String zzbks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpw(String str) {
        this.zzbks = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.zzbks);
    }
}
