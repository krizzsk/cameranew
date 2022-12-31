package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import com.facebook.appevents.AppEvent;
import com.facebook.f;
import com.facebook.internal.x;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* compiled from: OnDeviceProcessingManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a {
    private static final Set<String> a = new HashSet(Arrays.asList("fb_mobile_purchase", "StartTrial", "Subscribe"));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnDeviceProcessingManager.java */
    /* renamed from: com.facebook.appevents.ondeviceprocessing.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0083a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        RunnableC0083a(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                SharedPreferences sharedPreferences = this.a.getSharedPreferences(this.b, 0);
                String str = this.c + "pingForOnDevice";
                if (sharedPreferences.getLong(str, 0L) == 0) {
                    RemoteServiceWrapper.e(this.c);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong(str, System.currentTimeMillis());
                    edit.apply();
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnDeviceProcessingManager.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ AppEvent b;

        b(String str, AppEvent appEvent) {
            this.a = str;
            this.b = appEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                RemoteServiceWrapper.c(this.a, Arrays.asList(this.b));
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    private static boolean a(AppEvent appEvent) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            return (appEvent.getIsImplicit() ^ true) || (appEvent.getIsImplicit() && a.contains(appEvent.getName()));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    public static boolean b() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            if ((f.t(f.f()) || x.Q()) ? false : true) {
                return RemoteServiceWrapper.b();
            }
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    public static void c(String str, AppEvent appEvent) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            if (a(appEvent)) {
                f.p().execute(new b(str, appEvent));
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    public static void d(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            Context f2 = f.f();
            if (f2 == null || str == null || str2 == null) {
                return;
            }
            f.p().execute(new RunnableC0083a(f2, str2, str));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }
}
