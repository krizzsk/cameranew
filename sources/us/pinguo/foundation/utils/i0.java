package us.pinguo.foundation.utils;

import androidx.annotation.MainThread;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ThreadJoiner.kt */
/* loaded from: classes4.dex */
public final class i0 {

    /* renamed from: d  reason: collision with root package name */
    public static final a f11106d = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private static int f11107e;
    private final String a;
    private final List<Thread> b;
    private boolean c;

    /* compiled from: ThreadJoiner.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    public i0(String name) {
        kotlin.jvm.internal.s.h(name, "name");
        this.a = name;
        this.b = new ArrayList();
    }

    @MainThread
    public final void a(Runnable runnable) {
        kotlin.jvm.internal.s.h(runnable, "runnable");
        if (this.c) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Joiner-");
        sb.append(this.a);
        sb.append('(');
        int i2 = f11107e;
        f11107e = i2 + 1;
        sb.append(i2);
        sb.append(')');
        Thread thread = new Thread(runnable, sb.toString());
        thread.start();
        this.b.add(thread);
    }

    @MainThread
    public final void b() {
        this.c = true;
        for (Thread thread : this.b) {
            thread.join();
        }
        this.b.clear();
    }
}
