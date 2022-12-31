package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
public final class z<TResult> {
    private final Object a = new Object();
    @GuardedBy("mLock")
    private Queue<a0<TResult>> b;
    @GuardedBy("mLock")
    private boolean c;

    public final void a(@NonNull g<TResult> gVar) {
        a0<TResult> poll;
        synchronized (this.a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.a) {
                        poll = this.b.poll();
                        if (poll == null) {
                            this.c = false;
                            return;
                        }
                    }
                    poll.a(gVar);
                }
            }
        }
    }

    public final void b(@NonNull a0<TResult> a0Var) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(a0Var);
        }
    }
}
