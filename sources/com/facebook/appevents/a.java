package com.facebook.appevents;

import android.preference.PreferenceManager;
import android.util.Log;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnalyticsUserIDStore.java */
/* loaded from: classes.dex */
public class a {
    private static final String a = "a";
    private static String c;
    private static ReentrantReadWriteLock b = new ReentrantReadWriteLock();

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f2260d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnalyticsUserIDStore.java */
    /* renamed from: com.facebook.appevents.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0069a implements Runnable {
        RunnableC0069a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                a.c();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    public static String b() {
        if (!f2260d) {
            Log.w(a, "initStore should have been called before calling setUserID");
            c();
        }
        b.readLock().lock();
        try {
            return c;
        } finally {
            b.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        if (f2260d) {
            return;
        }
        b.writeLock().lock();
        try {
            if (f2260d) {
                return;
            }
            c = PreferenceManager.getDefaultSharedPreferences(com.facebook.f.f()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
            f2260d = true;
        } finally {
            b.writeLock().unlock();
        }
    }

    public static void d() {
        if (f2260d) {
            return;
        }
        InternalAppEventsLogger.b().execute(new RunnableC0069a());
    }
}
