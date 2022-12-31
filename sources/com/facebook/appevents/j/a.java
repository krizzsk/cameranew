package com.facebook.appevents.j;

import android.app.Activity;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import com.facebook.f;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.x;
/* compiled from: MetadataIndexer.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class a {
    private static final String a = "com.facebook.appevents.j.a";
    private static Boolean b = Boolean.FALSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MetadataIndexer.java */
    /* renamed from: com.facebook.appevents.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0079a implements Runnable {
        RunnableC0079a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                if (com.facebook.internal.b.l(f.f())) {
                    return;
                }
                a.a();
                a.b(Boolean.TRUE);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    static /* synthetic */ void a() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            e();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    static /* synthetic */ Boolean b(Boolean bool) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            b = bool;
            return bool;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    public static void c() {
        try {
            if (com.facebook.internal.instrument.e.a.c(a.class)) {
                return;
            }
            try {
                f.p().execute(new RunnableC0079a());
            } catch (Exception e2) {
                x.X(a, e2);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    @UiThread
    public static void d(Activity activity) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            if (b.booleanValue() && !c.e().isEmpty()) {
                d.h(activity);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    private static void e() {
        String i2;
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            l o = FetchedAppSettingsManager.o(f.g(), false);
            if (o == null || (i2 = o.i()) == null) {
                return;
            }
            c.g(i2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }
}
