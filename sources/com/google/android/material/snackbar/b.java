package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;
/* compiled from: SnackbarManager.java */
/* loaded from: classes2.dex */
class b {

    /* renamed from: e  reason: collision with root package name */
    private static b f4560e;
    @NonNull
    private final Object a = new Object();
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper(), new a());
    @Nullable
    private c c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private c f4561d;

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SnackbarManager.java */
    /* renamed from: com.google.android.material.snackbar.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0178b {
        void a(int i2);

        void show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    public static class c {
        @NonNull
        final WeakReference<InterfaceC0178b> a;
        int b;
        boolean c;

        c(int i2, InterfaceC0178b interfaceC0178b) {
            this.a = new WeakReference<>(interfaceC0178b);
            this.b = i2;
        }

        boolean a(@Nullable InterfaceC0178b interfaceC0178b) {
            return interfaceC0178b != null && this.a.get() == interfaceC0178b;
        }
    }

    private b() {
    }

    private boolean a(@NonNull c cVar, int i2) {
        InterfaceC0178b interfaceC0178b = cVar.a.get();
        if (interfaceC0178b != null) {
            this.b.removeCallbacksAndMessages(cVar);
            interfaceC0178b.a(i2);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b c() {
        if (f4560e == null) {
            f4560e = new b();
        }
        return f4560e;
    }

    private boolean f(InterfaceC0178b interfaceC0178b) {
        c cVar = this.c;
        return cVar != null && cVar.a(interfaceC0178b);
    }

    private boolean g(InterfaceC0178b interfaceC0178b) {
        c cVar = this.f4561d;
        return cVar != null && cVar.a(interfaceC0178b);
    }

    private void l(@NonNull c cVar) {
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

    private void n() {
        c cVar = this.f4561d;
        if (cVar != null) {
            this.c = cVar;
            this.f4561d = null;
            InterfaceC0178b interfaceC0178b = cVar.a.get();
            if (interfaceC0178b != null) {
                interfaceC0178b.show();
            } else {
                this.c = null;
            }
        }
    }

    public void b(InterfaceC0178b interfaceC0178b, int i2) {
        synchronized (this.a) {
            if (f(interfaceC0178b)) {
                a(this.c, i2);
            } else if (g(interfaceC0178b)) {
                a(this.f4561d, i2);
            }
        }
    }

    void d(@NonNull c cVar) {
        synchronized (this.a) {
            if (this.c == cVar || this.f4561d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(InterfaceC0178b interfaceC0178b) {
        boolean z;
        synchronized (this.a) {
            z = f(interfaceC0178b) || g(interfaceC0178b);
        }
        return z;
    }

    public void h(InterfaceC0178b interfaceC0178b) {
        synchronized (this.a) {
            if (f(interfaceC0178b)) {
                this.c = null;
                if (this.f4561d != null) {
                    n();
                }
            }
        }
    }

    public void i(InterfaceC0178b interfaceC0178b) {
        synchronized (this.a) {
            if (f(interfaceC0178b)) {
                l(this.c);
            }
        }
    }

    public void j(InterfaceC0178b interfaceC0178b) {
        synchronized (this.a) {
            if (f(interfaceC0178b)) {
                c cVar = this.c;
                if (!cVar.c) {
                    cVar.c = true;
                    this.b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void k(InterfaceC0178b interfaceC0178b) {
        synchronized (this.a) {
            if (f(interfaceC0178b)) {
                c cVar = this.c;
                if (cVar.c) {
                    cVar.c = false;
                    l(cVar);
                }
            }
        }
    }

    public void m(int i2, InterfaceC0178b interfaceC0178b) {
        synchronized (this.a) {
            if (f(interfaceC0178b)) {
                c cVar = this.c;
                cVar.b = i2;
                this.b.removeCallbacksAndMessages(cVar);
                l(this.c);
                return;
            }
            if (g(interfaceC0178b)) {
                this.f4561d.b = i2;
            } else {
                this.f4561d = new c(i2, interfaceC0178b);
            }
            c cVar2 = this.c;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.c = null;
                n();
            }
        }
    }
}
