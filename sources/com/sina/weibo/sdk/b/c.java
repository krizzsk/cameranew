package com.sina.weibo.sdk.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/* loaded from: classes3.dex */
public abstract class c<Params, Progress, Result> {
    final d<Params, Result> R;
    public final FutureTask<Result> S;
    Params[] U;
    volatile int Q = b.Z;
    int T = 5;
    Handler x = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.b.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (message.what != 1) {
                return;
            }
            c.a(aVar.X, aVar.Y[0]);
            message.obj = null;
        }
    };

    /* renamed from: com.sina.weibo.sdk.b.c$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] W;

        static {
            int[] iArr = new int[b.p().length];
            W = iArr;
            try {
                iArr[b.aa - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                W[b.ab - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a<Data> {
        final c X;
        final Data[] Y;

        a(c cVar, Data... dataArr) {
            this.X = cVar;
            this.Y = dataArr;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class b {
        public static final int Z = 1;
        public static final int aa = 2;
        public static final int ab = 3;
        private static final /* synthetic */ int[] ac = {1, 2, 3};

        public static int[] p() {
            return (int[]) ac.clone();
        }
    }

    /* renamed from: com.sina.weibo.sdk.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private abstract class AbstractC0255c extends FutureTask<Result> implements Comparable<Object> {
        int priority;

        public AbstractC0255c(d dVar) {
            super(dVar);
            this.priority = dVar.priority;
        }
    }

    public c() {
        d<Params, Result> dVar = new d<Params, Result>() { // from class: com.sina.weibo.sdk.b.c.2
            @Override // java.util.concurrent.Callable
            public final Result call() {
                Process.setThreadPriority(c.this.T);
                return (Result) c.this.o();
            }
        };
        this.R = dVar;
        this.S = new c<Params, Progress, Result>.AbstractC0255c(dVar) { // from class: com.sina.weibo.sdk.b.c.3
            @Override // java.lang.Comparable
            public final int compareTo(Object obj) {
                return 0;
            }

            @Override // java.util.concurrent.FutureTask
            protected final void done() {
                try {
                    Result result = get();
                    c cVar = c.this;
                    cVar.x.obtainMessage(1, new a(cVar, result)).sendToTarget();
                } catch (InterruptedException unused) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                } catch (CancellationException unused2) {
                    c.this.x.obtainMessage(3, new a(c.this, null)).sendToTarget();
                } catch (ExecutionException unused3) {
                    throw new RuntimeException("An error occur while execute doInBackground().");
                }
            }
        };
    }

    static /* synthetic */ void a(c cVar, Object obj) {
        cVar.onPostExecute(obj);
        cVar.Q = b.ab;
    }

    protected abstract Result o();

    protected void onPostExecute(Result result) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class d<Params, Result> implements Callable<Result> {
        Params[] ad;
        int priority;

        private d() {
            this.priority = 10;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }
}
