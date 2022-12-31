package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.tasks.zzb;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
public final class i {
    public static final Executor a = new a();
    static final Executor b = new b0();

    /* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    /* loaded from: classes2.dex */
    private static final class a implements Executor {
        private final Handler a = new zzb(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(@NonNull Runnable runnable) {
            this.a.post(runnable);
        }
    }
}
