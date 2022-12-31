package us.pinguo.ui.widget.snack;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;
/* compiled from: SnackbarManager.java */
/* loaded from: classes6.dex */
class a {

    /* renamed from: e  reason: collision with root package name */
    private static a f12322e;
    private final Object a = new Object();
    private final Handler b = new Handler(Looper.getMainLooper(), new C0456a());
    private c c;

    /* renamed from: d  reason: collision with root package name */
    private c f12323d;

    /* compiled from: SnackbarManager.java */
    /* renamed from: us.pinguo.ui.widget.snack.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0456a implements Handler.Callback {
        C0456a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SnackbarManager.java */
    /* loaded from: classes6.dex */
    public interface b {
        void a(int i2);

        void show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnackbarManager.java */
    /* loaded from: classes6.dex */
    public static class c {
        final WeakReference<b> a;
        int b;
        boolean c;

        c(int i2, b bVar) {
            this.a = new WeakReference<>(bVar);
            this.b = i2;
        }

        boolean a(b bVar) {
            return bVar != null && this.a.get() == bVar;
        }
    }

    private a() {
    }

    private boolean a(c cVar, int i2) {
        b bVar = cVar.a.get();
        if (bVar != null) {
            this.b.removeCallbacksAndMessages(cVar);
            bVar.a(i2);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c() {
        if (f12322e == null) {
            f12322e = new a();
        }
        return f12322e;
    }

    private boolean g(b bVar) {
        c cVar = this.c;
        return cVar != null && cVar.a(bVar);
    }

    private boolean h(b bVar) {
        c cVar = this.f12323d;
        return cVar != null && cVar.a(bVar);
    }

    private void m(c cVar) {
        int i2 = cVar.b;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : 2750;
        }
        this.b.removeCallbacksAndMessages(cVar);
        Handler handler = this.b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i2);
    }

    private void o() {
        c cVar = this.f12323d;
        if (cVar != null) {
            this.c = cVar;
            this.f12323d = null;
            b bVar = cVar.a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.c = null;
            }
        }
    }

    public void b(b bVar, int i2) {
        synchronized (this.a) {
            if (g(bVar)) {
                a(this.c, i2);
            } else if (h(bVar)) {
                a(this.f12323d, i2);
            }
        }
    }

    void d(c cVar) {
        synchronized (this.a) {
            if (this.c == cVar || this.f12323d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(b bVar) {
        boolean g2;
        synchronized (this.a) {
            g2 = g(bVar);
        }
        return g2;
    }

    public boolean f(b bVar) {
        boolean z;
        synchronized (this.a) {
            z = g(bVar) || h(bVar);
        }
        return z;
    }

    public void i(b bVar) {
        synchronized (this.a) {
            if (g(bVar)) {
                this.c = null;
                if (this.f12323d != null) {
                    o();
                }
            }
        }
    }

    public void j(b bVar) {
        synchronized (this.a) {
            if (g(bVar)) {
                m(this.c);
            }
        }
    }

    public void k(b bVar) {
        synchronized (this.a) {
            if (g(bVar)) {
                c cVar = this.c;
                if (!cVar.c) {
                    cVar.c = true;
                    this.b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void l(b bVar) {
        synchronized (this.a) {
            if (g(bVar)) {
                c cVar = this.c;
                if (cVar.c) {
                    cVar.c = false;
                    m(cVar);
                }
            }
        }
    }

    public void n(int i2, b bVar) {
        synchronized (this.a) {
            if (g(bVar)) {
                c cVar = this.c;
                cVar.b = i2;
                this.b.removeCallbacksAndMessages(cVar);
                m(this.c);
                return;
            }
            if (h(bVar)) {
                this.f12323d.b = i2;
            } else {
                this.f12323d = new c(i2, bVar);
            }
            c cVar2 = this.c;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.c = null;
                o();
            }
        }
    }
}
