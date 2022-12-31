package com.growingio.android.sdk.instrumentation;
/* loaded from: classes2.dex */
public @interface Instrumented {
    boolean isStatic() default false;

    String scope() default "";
}
