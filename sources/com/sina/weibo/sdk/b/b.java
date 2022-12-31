package com.sina.weibo.sdk.b;

import com.sina.weibo.sdk.b.c;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
public final class b {
    private com.sina.weibo.sdk.b.a O;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private static b P = new b((byte) 0);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public final void a(c cVar) {
        ThreadPoolExecutor threadPoolExecutor = this.O.M;
        if (cVar.Q != c.b.Z) {
            int i2 = c.AnonymousClass4.W[cVar.Q - 1];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        cVar.Q = c.b.aa;
        c.d<Params, Result> dVar = cVar.R;
        dVar.ad = cVar.U;
        dVar.priority = cVar.T;
        threadPoolExecutor.execute(cVar.S);
    }

    private b() {
        this.O = null;
        if (0 == 0) {
            this.O = new com.sina.weibo.sdk.b.a();
        }
    }
}
