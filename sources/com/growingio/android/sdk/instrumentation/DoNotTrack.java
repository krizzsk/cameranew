package com.growingio.android.sdk.instrumentation;
/* loaded from: classes2.dex */
public @interface DoNotTrack {
    boolean isStatic() default false;

    String scope() default "";
}
