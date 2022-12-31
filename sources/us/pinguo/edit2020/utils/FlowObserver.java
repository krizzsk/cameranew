package us.pinguo.edit2020.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.v1;
/* compiled from: StaticStickerExtension.kt */
/* loaded from: classes4.dex */
public final class FlowObserver<T> {
    private final kotlinx.coroutines.flow.c<T> a;
    private final p<T, Continuation<? super u>, Object> b;
    private v1 c;

    /* compiled from: StaticStickerExtension.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowObserver(LifecycleOwner lifecycleOwner, kotlinx.coroutines.flow.c<? extends T> flow, p<? super T, ? super Continuation<? super u>, ? extends Object> collector) {
        s.h(lifecycleOwner, "lifecycleOwner");
        s.h(flow, "flow");
        s.h(collector, "collector");
        this.a = flow;
        this.b = collector;
        lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: us.pinguo.edit2020.utils.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                FlowObserver.a(FlowObserver.this, lifecycleOwner2, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FlowObserver this$0, LifecycleOwner source, Lifecycle.Event event) {
        v1 d2;
        s.h(this$0, "this$0");
        s.h(source, "source");
        s.h(event, "event");
        int i2 = a.a[event.ordinal()];
        if (i2 == 1) {
            d2 = l.d(LifecycleOwnerKt.getLifecycleScope(source), null, null, new FlowObserver$1$1(this$0, null), 3, null);
            this$0.c = d2;
        } else if (i2 != 2) {
        } else {
            v1 v1Var = this$0.c;
            if (v1Var != null) {
                v1.a.a(v1Var, null, 1, null);
            }
            this$0.c = null;
        }
    }
}
