package com.pinguo.camera360.adv;

import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.f;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.e;
import us.pinguo.foundation.utils.i;
/* compiled from: FacebookAnalyzeManager.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final d a = new d();
    private static AppEventsLogger b;

    private d() {
    }

    private final void b() {
        AppEventsLogger i2 = AppEventsLogger.i(e.b());
        s.g(i2, "newLogger(Foundation.getAppContext())");
        b = i2;
    }

    public final void a() {
        if (i.c()) {
            f.I(true);
            f.J(true);
            f.H(true);
            if (us.pinguo.foundation.d.f10985d) {
                f.K(true);
                f.c(LoggingBehavior.APP_EVENTS);
            }
        }
    }

    public final void c() {
        if (f.z()) {
            if (b == null) {
                b();
            }
            AppEventsLogger appEventsLogger = b;
            if (appEventsLogger != null) {
                appEventsLogger.g("all_subscribe");
            } else {
                s.z("logger");
                throw null;
            }
        }
    }
}
