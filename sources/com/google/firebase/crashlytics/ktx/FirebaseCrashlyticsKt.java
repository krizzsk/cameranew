package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: FirebaseCrashlytics.kt */
/* loaded from: classes2.dex */
public final class FirebaseCrashlyticsKt {
    public static final String LIBRARY_NAME = "fire-cls-ktx";

    public static final FirebaseCrashlytics getCrashlytics(Firebase receiver$0) {
        s.i(receiver$0, "receiver$0");
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        s.d(firebaseCrashlytics, "FirebaseCrashlytics.getInstance()");
        return firebaseCrashlytics;
    }

    public static final void setCustomKeys(FirebaseCrashlytics receiver$0, l<? super KeyValueBuilder, u> init) {
        s.i(receiver$0, "receiver$0");
        s.i(init, "init");
        init.invoke(new KeyValueBuilder(receiver$0));
    }
}
