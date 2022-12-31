package com.google.android.datatransport.runtime.v;
/* compiled from: Retries.java */
/* loaded from: classes2.dex */
public final class b {
    public static <TInput, TResult, TException extends Throwable> TResult a(int i2, TInput tinput, a<TInput, TResult, TException> aVar, c<TInput, TResult> cVar) throws Throwable {
        TResult apply;
        if (i2 < 1) {
            return aVar.apply(tinput);
        }
        do {
            apply = aVar.apply(tinput);
            tinput = cVar.a(tinput, apply);
            if (tinput == null) {
                break;
            }
            i2--;
        } while (i2 >= 1);
        return apply;
    }
}
