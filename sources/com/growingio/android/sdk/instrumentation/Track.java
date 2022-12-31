package com.growingio.android.sdk.instrumentation;
/* loaded from: classes2.dex */
public @interface Track {
    boolean isStatic() default false;

    String scope() default "";
}
