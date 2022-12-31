package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.f;
import java.lang.ref.WeakReference;
/* compiled from: RCTCodelessLoggingEventListener.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: RCTCodelessLoggingEventListener.java */
    /* loaded from: classes.dex */
    public static class a implements View.OnTouchListener {
        private EventBinding a;
        private WeakReference<View> b;
        private WeakReference<View> c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private View.OnTouchListener f2280d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2281e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RCTCodelessLoggingEventListener.java */
        /* renamed from: com.facebook.appevents.codeless.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0073a implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ Bundle b;

            RunnableC0073a(a aVar, String str, Bundle bundle) {
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

        public a(EventBinding eventBinding, View view, View view2) {
            this.f2281e = false;
            if (eventBinding == null || view == null || view2 == null) {
                return;
            }
            this.f2280d = com.facebook.appevents.codeless.internal.d.h(view2);
            this.a = eventBinding;
            this.b = new WeakReference<>(view2);
            this.c = new WeakReference<>(view);
            this.f2281e = true;
        }

        private void b() {
            EventBinding eventBinding = this.a;
            if (eventBinding == null) {
                return;
            }
            String b = eventBinding.b();
            Bundle e2 = CodelessMatcher.e(this.a, this.c.get(), this.b.get());
            if (e2.containsKey("_valueToSum")) {
                e2.putDouble("_valueToSum", com.facebook.appevents.internal.b.g(e2.getString("_valueToSum")));
            }
            e2.putString("_is_fb_codeless", "1");
            f.p().execute(new RunnableC0073a(this, b, e2));
        }

        public boolean a() {
            return this.f2281e;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                b();
            }
            View.OnTouchListener onTouchListener = this.f2280d;
            return onTouchListener != null && onTouchListener.onTouch(view, motionEvent);
        }
    }

    public static a a(EventBinding eventBinding, View view, View view2) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            return new a(eventBinding, view, view2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }
}
