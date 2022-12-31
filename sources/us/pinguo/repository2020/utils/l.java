package us.pinguo.repository2020.utils;

import com.tencent.bugly.crashreport.CrashReport;
import java.io.Reader;
import java.lang.reflect.Type;
import kotlin.Result;
import kotlin.jvm.internal.s;
/* compiled from: GsonExtension.kt */
/* loaded from: classes6.dex */
public final class l {
    public static final <T> T a(com.google.gson.e eVar, Reader reader, Type typeOfT, Object obj) {
        T t;
        s.h(eVar, "<this>");
        s.h(reader, "reader");
        s.h(typeOfT, "typeOfT");
        try {
            Result.a aVar = Result.Companion;
            t = (T) Result.m41constructorimpl(eVar.i(reader, typeOfT));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            t = (T) Result.m41constructorimpl(kotlin.j.a(th));
        }
        if (!Result.m48isSuccessimpl(t)) {
            CrashReport.postCatchedException(new RuntimeException("Gson failed to deserialize, pram=" + obj + ", ", Result.m44exceptionOrNullimpl(t)));
        } else if (!Result.m47isFailureimpl(t)) {
            return t;
        }
        return null;
    }
}
