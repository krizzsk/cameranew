package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.u;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
/* compiled from: DebugCoroutineInfoImpl.kt */
/* loaded from: classes3.dex */
public final class DebugCoroutineInfoImpl {
    public final long a;
    private final WeakReference<CoroutineContext> b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    public Thread f8742d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<CoroutineStackFrame> f8743e;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004a -> B:26:0x0062). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005c -> B:25:0x005f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(kotlin.sequences.g<? super java.lang.StackTraceElement> r6, kotlin.coroutines.jvm.internal.CoroutineStackFrame r7, kotlin.coroutines.Continuation<? super kotlin.u> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$2
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r6 = (kotlin.coroutines.jvm.internal.CoroutineStackFrame) r6
            java.lang.Object r7 = r0.L$1
            kotlin.sequences.g r7 = (kotlin.sequences.g) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r2 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl) r2
            kotlin.j.b(r8)
            goto L5f
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.j.b(r8)
            r2 = r5
        L41:
            if (r7 != 0) goto L46
            kotlin.u r6 = kotlin.u.a
            return r6
        L46:
            java.lang.StackTraceElement r8 = r7.getStackTraceElement()
            if (r8 != 0) goto L4d
            goto L62
        L4d:
            r0.L$0 = r2
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r6.a(r8, r0)
            if (r8 != r1) goto L5c
            return r1
        L5c:
            r4 = r7
            r7 = r6
            r6 = r4
        L5f:
            r4 = r7
            r7 = r6
            r6 = r4
        L62:
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r7 = r7.getCallerFrame()
            if (r7 == 0) goto L69
            goto L41
        L69:
            kotlin.u r6 = kotlin.u.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.f(kotlin.sequences.g, kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CoroutineContext b() {
        return this.b.get();
    }

    public final CoroutineStackFrame c() {
        WeakReference<CoroutineStackFrame> weakReference = this.f8743e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final String d() {
        return this.c;
    }

    public final List<StackTraceElement> e() {
        List<StackTraceElement> h2;
        CoroutineStackFrame c = c();
        if (c == null) {
            h2 = u.h();
            return h2;
        }
        ArrayList arrayList = new ArrayList();
        while (c != null) {
            StackTraceElement stackTraceElement = c.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            c = c.getCallerFrame();
        }
        return arrayList;
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + d() + ",context=" + b() + ')';
    }
}
