package us.pinguo.foundation.utils;

import android.os.Handler;
import android.os.Looper;
/* compiled from: Async.java */
/* loaded from: classes4.dex */
public class f {
    private static Handler a = new Handler(Looper.getMainLooper());

    /* compiled from: Async.java */
    /* loaded from: classes4.dex */
    class a extends b<Void> {
        final /* synthetic */ Runnable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Runnable runnable) {
            super(null);
            this.a = runnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.f.b
        /* renamed from: b */
        public Void a() {
            this.a.run();
            return null;
        }
    }

    /* compiled from: Async.java */
    /* loaded from: classes4.dex */
    private static abstract class b<T> extends AsyncTask<Object, Object, T> {
        private b() {
        }

        protected abstract T a();

        @Override // us.pinguo.foundation.utils.AsyncTask
        protected T doInBackground(Object[] objArr) {
            return a();
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static void a(Runnable runnable) {
        a.removeCallbacks(runnable);
    }

    public static void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        new a(runnable).execute(new Object[0]);
    }

    public static void c(Runnable runnable) {
        if (runnable == null || a == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }

    public static void d(Runnable runnable, long j2) {
        if (runnable == null || a == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread() && j2 == 0) {
            runnable.run();
        } else {
            a.postDelayed(runnable, j2);
        }
    }
}
