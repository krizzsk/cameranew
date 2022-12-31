package com.google.firebase.analytics.ktx;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.ktx.FirebaseKt;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: com.google.firebase:firebase-analytics-ktx@@18.0.2 */
/* loaded from: classes2.dex */
public final class AnalyticsKt {
    public static final String LIBRARY_NAME = "fire-analytics-ktx";
    private static volatile FirebaseAnalytics zza;
    private static final Object zzb = new Object();

    public static final FirebaseAnalytics getANALYTICS() {
        return zza;
    }

    public static final FirebaseAnalytics getAnalytics(Firebase analytics) {
        s.h(analytics, "$this$analytics");
        if (zza == null) {
            synchronized (zzb) {
                if (zza == null) {
                    zza = FirebaseAnalytics.getInstance(FirebaseKt.getApp(Firebase.INSTANCE).getApplicationContext());
                }
            }
        }
        FirebaseAnalytics firebaseAnalytics = zza;
        s.e(firebaseAnalytics);
        return firebaseAnalytics;
    }

    public static final Object getLOCK() {
        return zzb;
    }

    public static final void logEvent(FirebaseAnalytics logEvent, String name, l<? super ParametersBuilder, u> block) {
        s.h(logEvent, "$this$logEvent");
        s.h(name, "name");
        s.h(block, "block");
        ParametersBuilder parametersBuilder = new ParametersBuilder();
        block.invoke(parametersBuilder);
        logEvent.logEvent(name, parametersBuilder.getBundle());
    }

    public static final void setANALYTICS(FirebaseAnalytics firebaseAnalytics) {
        zza = firebaseAnalytics;
    }

    public static final void setConsent(FirebaseAnalytics setConsent, l<? super ConsentBuilder, u> block) {
        s.h(setConsent, "$this$setConsent");
        s.h(block, "block");
        ConsentBuilder consentBuilder = new ConsentBuilder();
        block.invoke(consentBuilder);
        setConsent.setConsent(consentBuilder.asMap());
    }
}
