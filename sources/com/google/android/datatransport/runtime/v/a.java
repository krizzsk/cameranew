package com.google.android.datatransport.runtime.v;

import java.lang.Throwable;
/* compiled from: Function.java */
/* loaded from: classes2.dex */
public interface a<TInput, TResult, TException extends Throwable> {
    TResult apply(TInput tinput) throws Throwable;
}
