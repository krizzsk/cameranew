package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class b {
    private static Application a;
    private static int b;
    private static final by c = new by();

    /* renamed from: d  reason: collision with root package name */
    private static final Set f7318d = Collections.synchronizedSet(new ay());

    /* renamed from: e  reason: collision with root package name */
    private static final by f7319e = new by();

    public static void a(Activity activity) {
        c.a(activity);
    }

    public static boolean b() {
        return b > 0;
    }

    @Nullable
    public static Activity c() {
        Activity activity;
        Activity activity2 = (Activity) c.a();
        if (activity2 != null) {
            return activity2;
        }
        Set set = f7318d;
        synchronized (set) {
            activity = (Activity) jt.a(set.iterator());
        }
        return activity;
    }

    public static synchronized void a(Application application) {
        synchronized (b.class) {
            if (a != application) {
                a = application;
            }
        }
    }

    public static void b(Activity activity) {
        b++;
        c.a(activity);
        f7318d.add(activity);
    }

    @Nullable
    public static Activity a() {
        Activity activity = (Activity) f7319e.a();
        return activity == null ? c() : activity;
    }

    public static void c(Activity activity) {
        b--;
        c.a = null;
        f7318d.remove(activity);
        if (b < 0) {
            b = 0;
        }
    }
}
