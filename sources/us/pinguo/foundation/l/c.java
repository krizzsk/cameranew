package us.pinguo.foundation.l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: ContextExtensions.kt */
/* loaded from: classes4.dex */
public final class c {
    public static final void b(Context context, final kotlin.jvm.b.a<u> r, long j2) {
        s.h(context, "<this>");
        s.h(r, "r");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: us.pinguo.foundation.l.a
            @Override // java.lang.Runnable
            public final void run() {
                c.c(kotlin.jvm.b.a.this);
            }
        }, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(kotlin.jvm.b.a tmp0) {
        s.h(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
