package com.tencent.open.log;

import android.util.Log;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public final class e extends Tracer {
    public static final e a = new e();

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        if (i2 == 1) {
            Log.v(str, str2, th);
        } else if (i2 == 2) {
            Log.d(str, str2, th);
        } else if (i2 == 4) {
            Log.i(str, str2, th);
        } else if (i2 == 8) {
            Log.w(str, str2, th);
        } else if (i2 == 16) {
            Log.e(str, str2, th);
        } else if (i2 != 32) {
        } else {
            Log.e(str, str2, th);
        }
    }
}
