package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.PeriodicWorkRequest;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ActivityLifecycleListener.java */
/* loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    public static String a = "pangle_event_timer_ten_min";
    private AtomicInteger b = new AtomicInteger(0);
    private AtomicBoolean c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private HashSet<Integer> f2097d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private long f2098e = 0;

    public boolean a() {
        return this.c.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            this.f2097d.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f2097d.add(Integer.valueOf(activity.hashCode()));
        if (this.f2098e == 0) {
            this.f2098e = SystemClock.elapsedRealtime();
        } else if (SystemClock.elapsedRealtime() - this.f2098e > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            this.f2098e = SystemClock.elapsedRealtime();
            LocalBroadcastManager.getInstance(activity.getApplicationContext()).sendBroadcast(new Intent(a));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.b.incrementAndGet() > 0) {
            this.c.set(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.b.decrementAndGet() == 0) {
            this.c.set(true);
        }
    }
}
