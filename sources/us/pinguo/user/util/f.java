package us.pinguo.user.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
/* compiled from: DoubleClickDetector.java */
/* loaded from: classes6.dex */
public class f {
    private boolean a = true;
    private Handler b = new Handler(Looper.getMainLooper());

    /* compiled from: DoubleClickDetector.java */
    /* loaded from: classes6.dex */
    class a extends Thread {
        final /* synthetic */ b a;
        final /* synthetic */ View b;

        /* compiled from: DoubleClickDetector.java */
        /* renamed from: us.pinguo.user.util.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class RunnableC0461a implements Runnable {
            RunnableC0461a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.a.onSingleClick(aVar.b);
            }
        }

        a(b bVar, View view) {
            this.a = bVar;
            this.b = view;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(300L);
                if (f.this.a) {
                    return;
                }
                f.this.a = true;
                f.this.b.post(new RunnableC0461a());
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: DoubleClickDetector.java */
    /* loaded from: classes6.dex */
    public interface b {
        void onDoubleClick(View view);

        void onSingleClick(View view);
    }

    public void d(View view, b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.a) {
            this.a = false;
            new a(bVar, view).start();
            return;
        }
        this.a = true;
        bVar.onDoubleClick(view);
    }
}
