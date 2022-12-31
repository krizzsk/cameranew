package com.google.android.play.core.tasks;

import java.util.ArrayDeque;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o<ResultT> {
    private final Object a = new Object();
    private Queue<n<ResultT>> b;
    private boolean c;

    public final void a(d<ResultT> dVar) {
        n<ResultT> poll;
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
                    poll.a(dVar);
                }
            }
        }
    }

    public final void b(n<ResultT> nVar) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(nVar);
        }
    }
}
