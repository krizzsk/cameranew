package com.pinguo.lib;

import android.content.Context;
import kotlin.jvm.internal.s;
/* compiled from: AppContextProvider.kt */
/* loaded from: classes3.dex */
public final class AppContextProvider {
    public static final AppContextProvider INSTANCE = new AppContextProvider();
    public static Context context;

    private AppContextProvider() {
    }

    public static final void init(Context context2) {
        s.h(context2, "context");
        AppContextProvider appContextProvider = INSTANCE;
        Context applicationContext = context2.getApplicationContext();
        s.g(applicationContext, "context.applicationContext");
        appContextProvider.setContext(applicationContext);
    }

    public final Context getContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        s.z("context");
        throw null;
    }

    public final void setContext(Context context2) {
        s.h(context2, "<set-?>");
        context = context2;
    }
}
