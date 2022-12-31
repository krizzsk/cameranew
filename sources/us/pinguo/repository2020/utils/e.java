package us.pinguo.repository2020.utils;

import com.tencent.bugly.crashreport.CrashReport;
import kotlin.jvm.internal.s;
/* compiled from: ArraysExtension.kt */
/* loaded from: classes6.dex */
public final class e {
    public static final <T> void a(T[] tArr, int i2, T t) {
        int s;
        s.h(tArr, "<this>");
        if (tArr.length > 0 && i2 >= 0) {
            s = kotlin.collections.n.s(tArr);
            if (i2 <= s) {
                tArr[i2] = t;
                return;
            }
        }
        CrashReport.postCatchedException(new RuntimeException(Thread.currentThread().getStackTrace() + "\n size:" + tArr.length + " setOrDoNone(" + i2 + ',' + t + ')'));
    }
}
