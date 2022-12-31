package com.facebook.appevents.j;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.appevents.InternalAppEventsLogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: MetadataViewObserver.java */
/* loaded from: classes.dex */
final class d implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* renamed from: e  reason: collision with root package name */
    private static final Map<Integer, d> f2321e = new HashMap();
    private WeakReference<Activity> c;
    private final Set<String> a = new HashSet();
    private final Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private AtomicBoolean f2322d = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MetadataViewObserver.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                View view = this.a;
                if (view instanceof EditText) {
                    d.a(d.this, view);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    private d(Activity activity) {
        this.c = new WeakReference<>(activity);
    }

    static /* synthetic */ void a(d dVar, View view) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return;
        }
        try {
            dVar.d(view);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
        }
    }

    private static String b(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return null;
        }
        try {
            return "r2".equals(str) ? str2.replaceAll("[^\\d.]", "") : str2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    private void c(View view) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            f(new a(view));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    private void d(View view) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            String lowerCase = ((EditText) view).getText().toString().trim().toLowerCase();
            if (!lowerCase.isEmpty() && !this.a.contains(lowerCase) && lowerCase.length() <= 100) {
                this.a.add(lowerCase);
                HashMap hashMap = new HashMap();
                List<String> b = b.b(view);
                List<String> list = null;
                for (c cVar : c.e()) {
                    String b2 = b(cVar.d(), lowerCase);
                    if (cVar.f().isEmpty() || b.f(b2, cVar.f())) {
                        if (b.e(b, cVar.c())) {
                            e(hashMap, cVar.d(), b2);
                        } else {
                            if (list == null) {
                                list = b.a(view);
                            }
                            if (b.e(list, cVar.c())) {
                                e(hashMap, cVar.d(), b2);
                            }
                        }
                    }
                }
                InternalAppEventsLogger.n(hashMap);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    private static void e(Map<String, String> map, String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return;
        }
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case 3585:
                    if (str.equals("r3")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3586:
                    if (str.equals("r4")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3587:
                    if (str.equals("r5")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3588:
                    if (str.equals("r6")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                if (!str2.startsWith("m") && !str2.startsWith("b") && !str2.startsWith("ge")) {
                    str2 = "f";
                }
                str2 = "m";
            } else if (c != 1 && c != 2) {
                if (c == 3 && str2.contains(PGTransHeader.CONNECTOR)) {
                    str2 = str2.split(PGTransHeader.CONNECTOR)[0];
                }
            } else {
                str2 = str2.replaceAll("[^a-z]+", "");
            }
            map.put(str, str2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
        }
    }

    private void f(Runnable runnable) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                this.b.post(runnable);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    private void g() {
        View e2;
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (this.f2322d.getAndSet(true) || (e2 = com.facebook.appevents.internal.b.e(this.c.get())) == null) {
                return;
            }
            ViewTreeObserver viewTreeObserver = e2.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalFocusChangeListener(this);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public static void h(Activity activity) {
        d dVar;
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return;
        }
        try {
            int hashCode = activity.hashCode();
            Map<Integer, d> map = f2321e;
            if (!map.containsKey(Integer.valueOf(hashCode))) {
                dVar = new d(activity);
                map.put(Integer.valueOf(activity.hashCode()), dVar);
            } else {
                dVar = map.get(Integer.valueOf(hashCode));
            }
            dVar.g();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(@Nullable View view, @Nullable View view2) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        if (view != null) {
            try {
                c(view);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
                return;
            }
        }
        if (view2 != null) {
            c(view2);
        }
    }
}
