package com.google.android.play.core.tasks;

import androidx.annotation.NonNull;
import com.google.android.play.core.internal.y;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public final class f {
    public static <ResultT> d<ResultT> a(Exception exc) {
        s sVar = new s();
        sVar.k(exc);
        return sVar;
    }

    public static <ResultT> d<ResultT> b(ResultT resultt) {
        s sVar = new s();
        sVar.l(resultt);
        return sVar;
    }

    private static <ResultT> ResultT c(d<ResultT> dVar) throws ExecutionException {
        if (dVar.i()) {
            return dVar.g();
        }
        throw new ExecutionException(dVar.f());
    }

    private static void d(d<?> dVar, t tVar) {
        Executor executor = e.b;
        dVar.e(executor, tVar);
        dVar.c(executor, tVar);
    }

    public static <ResultT> ResultT e(@NonNull d<ResultT> dVar) throws ExecutionException, InterruptedException {
        y.c(dVar, "Task must not be null");
        if (dVar.h()) {
            return (ResultT) c(dVar);
        }
        t tVar = new t(null);
        d(dVar, tVar);
        tVar.a();
        return (ResultT) c(dVar);
    }
}
