package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.f;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.ref.WeakReference;
/* compiled from: CodelessLoggingEventListener.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CodelessLoggingEventListener.java */
    /* renamed from: com.facebook.appevents.codeless.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0071a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Bundle b;

        RunnableC0071a(String str, Bundle bundle) {
            this.a = str;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                AppEventsLogger.i(f.f()).h(this.a, this.b);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* compiled from: CodelessLoggingEventListener.java */
    /* loaded from: classes.dex */
    public static class b implements View.OnClickListener {
        private EventBinding a;
        private WeakReference<View> b;
        private WeakReference<View> c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private View.OnClickListener f2271d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2272e;

        /* synthetic */ b(EventBinding eventBinding, View view, View view2, RunnableC0071a runnableC0071a) {
            this(eventBinding, view, view2);
        }

        public boolean a() {
            return this.f2272e;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                View.OnClickListener onClickListener = this.f2271d;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                if (this.c.get() == null || this.b.get() == null) {
                    return;
                }
                a.a(this.a, this.c.get(), this.b.get());
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }

        private b(EventBinding eventBinding, View view, View view2) {
            this.f2272e = false;
            if (eventBinding == null || view == null || view2 == null) {
                return;
            }
            this.f2271d = com.facebook.appevents.codeless.internal.d.g(view2);
            this.a = eventBinding;
            this.b = new WeakReference<>(view2);
            this.c = new WeakReference<>(view);
            this.f2272e = true;
        }
    }

    /* compiled from: CodelessLoggingEventListener.java */
    /* loaded from: classes.dex */
    public static class c implements AdapterView.OnItemClickListener {
        private EventBinding a;
        private WeakReference<AdapterView> b;
        private WeakReference<View> c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private AdapterView.OnItemClickListener f2273d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2274e;

        /* synthetic */ c(EventBinding eventBinding, View view, AdapterView adapterView, RunnableC0071a runnableC0071a) {
            this(eventBinding, view, adapterView);
        }

        public boolean a() {
            return this.f2274e;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        @Instrumented
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            VdsAgent.onItemClick(this, adapterView, view, i2, j2);
            AdapterView.OnItemClickListener onItemClickListener = this.f2273d;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i2, j2);
            }
            if (this.c.get() == null || this.b.get() == null) {
                return;
            }
            a.a(this.a, this.c.get(), this.b.get());
        }

        private c(EventBinding eventBinding, View view, AdapterView adapterView) {
            this.f2274e = false;
            if (eventBinding == null || view == null || adapterView == null) {
                return;
            }
            this.f2273d = adapterView.getOnItemClickListener();
            this.a = eventBinding;
            this.b = new WeakReference<>(adapterView);
            this.c = new WeakReference<>(view);
            this.f2274e = true;
        }
    }

    static /* synthetic */ void a(EventBinding eventBinding, View view, View view2) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            d(eventBinding, view, view2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    public static b b(EventBinding eventBinding, View view, View view2) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            return new b(eventBinding, view, view2, null);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    public static c c(EventBinding eventBinding, View view, AdapterView adapterView) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            return new c(eventBinding, view, adapterView, null);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    private static void d(EventBinding eventBinding, View view, View view2) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            String b2 = eventBinding.b();
            Bundle e2 = CodelessMatcher.e(eventBinding, view, view2);
            e(e2);
            f.p().execute(new RunnableC0071a(b2, e2));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    protected static void e(Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            String string = bundle.getString("_valueToSum");
            if (string != null) {
                bundle.putDouble("_valueToSum", com.facebook.appevents.internal.b.g(string));
            }
            bundle.putString("_is_fb_codeless", "1");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }
}
