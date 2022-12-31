package androidx.core.os;

import android.os.Handler;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Handler.kt */
/* loaded from: classes.dex */
public final class HandlerKt {
    public static final Runnable postAtTime(Handler handler, long j2, Object obj, a<u> action) {
        s.h(handler, "<this>");
        s.h(action, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(action);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j2);
        return handlerKt$postAtTime$runnable$1;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler handler, long j2, Object obj, a action, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        s.h(handler, "<this>");
        s.h(action, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(action);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j2);
        return handlerKt$postAtTime$runnable$1;
    }

    public static final Runnable postDelayed(Handler handler, long j2, Object obj, a<u> action) {
        s.h(handler, "<this>");
        s.h(action, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(action);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j2);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j2);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler handler, long j2, Object obj, a action, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        s.h(handler, "<this>");
        s.h(action, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(action);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j2);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j2);
        }
        return handlerKt$postDelayed$runnable$1;
    }
}
