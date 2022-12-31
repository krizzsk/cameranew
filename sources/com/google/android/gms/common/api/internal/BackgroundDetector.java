package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e  reason: collision with root package name */
    private static final BackgroundDetector f3604e = new BackgroundDetector();
    private final AtomicBoolean a = new AtomicBoolean();
    private final AtomicBoolean b = new AtomicBoolean();
    @GuardedBy("sInstance")
    private final ArrayList<a> c = new ArrayList<>();
    @GuardedBy("sInstance")

    /* renamed from: d  reason: collision with root package name */
    private boolean f3605d = false;

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public interface a {
        void onBackgroundStateChanged(boolean z);
    }

    private BackgroundDetector() {
    }

    public static void b(Application application) {
        BackgroundDetector backgroundDetector = f3604e;
        synchronized (backgroundDetector) {
            if (!backgroundDetector.f3605d) {
                application.registerActivityLifecycleCallbacks(backgroundDetector);
                application.registerComponentCallbacks(backgroundDetector);
                backgroundDetector.f3605d = true;
            }
        }
    }

    private final void e(boolean z) {
        synchronized (f3604e) {
            ArrayList<a> arrayList = this.c;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                a aVar = arrayList.get(i2);
                i2++;
                aVar.onBackgroundStateChanged(z);
            }
        }
    }

    public static BackgroundDetector getInstance() {
        return f3604e;
    }

    public final void a(a aVar) {
        synchronized (f3604e) {
            this.c.add(aVar);
        }
    }

    public final boolean c() {
        return this.a.get();
    }

    @TargetApi(16)
    public final boolean d(boolean z) {
        if (!this.b.get()) {
            if (!com.google.android.gms.common.util.o.c()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.a.set(true);
            }
        }
        return c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
        boolean compareAndSet = this.a.compareAndSet(true, false);
        this.b.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.a.compareAndSet(true, false);
        this.b.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.a.compareAndSet(false, true)) {
            this.b.set(true);
            e(true);
        }
    }
}
