package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.ironsource.lifecycle.IronsourceLifecycleFragment;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class IronsourceLifecycleManager implements Application.ActivityLifecycleCallbacks {

    /* renamed from: j  reason: collision with root package name */
    private static IronsourceLifecycleManager f5353j = new IronsourceLifecycleManager();

    /* renamed from: k  reason: collision with root package name */
    private static AtomicBoolean f5354k = new AtomicBoolean(false);
    private Handler a;
    private int b = 0;
    private int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5355d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5356e = true;

    /* renamed from: f  reason: collision with root package name */
    private IronsourceLifecycleState f5357f = IronsourceLifecycleState.NONE;

    /* renamed from: g  reason: collision with root package name */
    private List<com.ironsource.lifecycle.a> f5358g = new CopyOnWriteArrayList();

    /* renamed from: h  reason: collision with root package name */
    private Runnable f5359h = new a();

    /* renamed from: i  reason: collision with root package name */
    private IronsourceLifecycleFragment.a f5360i = new b();

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IronsourceLifecycleManager.this.h();
            IronsourceLifecycleManager.this.i();
        }
    }

    /* loaded from: classes2.dex */
    class b implements IronsourceLifecycleFragment.a {
        b() {
        }

        @Override // com.ironsource.lifecycle.IronsourceLifecycleFragment.a
        public void a(Activity activity) {
            IronsourceLifecycleManager.this.d(activity);
        }

        @Override // com.ironsource.lifecycle.IronsourceLifecycleFragment.a
        public void b(Activity activity) {
        }

        @Override // com.ironsource.lifecycle.IronsourceLifecycleFragment.a
        public void c(Activity activity) {
            IronsourceLifecycleManager.this.e(activity);
        }
    }

    public static IronsourceLifecycleManager getInstance() {
        return f5353j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.c == 0) {
            this.f5355d = true;
            for (com.ironsource.lifecycle.a aVar : this.f5358g) {
                aVar.b();
            }
            this.f5357f = IronsourceLifecycleState.PAUSED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.b == 0 && this.f5355d) {
            for (com.ironsource.lifecycle.a aVar : this.f5358g) {
                aVar.c();
            }
            this.f5356e = true;
            this.f5357f = IronsourceLifecycleState.STOPPED;
        }
    }

    void c(Activity activity) {
        int i2 = this.c - 1;
        this.c = i2;
        if (i2 == 0) {
            this.a.postDelayed(this.f5359h, 700L);
        }
    }

    void d(Activity activity) {
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 == 1) {
            if (this.f5355d) {
                for (com.ironsource.lifecycle.a aVar : this.f5358g) {
                    aVar.a();
                }
                this.f5355d = false;
                this.f5357f = IronsourceLifecycleState.RESUMED;
                return;
            }
            this.a.removeCallbacks(this.f5359h);
        }
    }

    void e(Activity activity) {
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 == 1 && this.f5356e) {
            for (com.ironsource.lifecycle.a aVar : this.f5358g) {
                aVar.d();
            }
            this.f5356e = false;
            this.f5357f = IronsourceLifecycleState.STARTED;
        }
    }

    void f(Activity activity) {
        this.b--;
        i();
    }

    public void g(com.ironsource.lifecycle.a aVar) {
        if (!IronsourceLifecycleProvider.a() || aVar == null || this.f5358g.contains(aVar)) {
            return;
        }
        this.f5358g.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Context context) {
        if (f5354k.compareAndSet(false, true)) {
            this.a = new Handler(Looper.getMainLooper());
            Application application = (Application) context.getApplicationContext();
            if (application != null) {
                application.registerActivityLifecycleCallbacks(this);
            }
        }
    }

    public boolean k() {
        return this.f5357f == IronsourceLifecycleState.STOPPED;
    }

    public void l(com.ironsource.lifecycle.a aVar) {
        if (this.f5358g.contains(aVar)) {
            this.f5358g.remove(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        IronsourceLifecycleFragment.e(activity);
        IronsourceLifecycleFragment d2 = IronsourceLifecycleFragment.d(activity);
        if (d2 != null) {
            d2.f(this.f5360i);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        c(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        f(activity);
    }
}
