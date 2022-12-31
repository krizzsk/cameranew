package kotlinx.coroutines;

import com.growingio.android.sdk.collection.Constants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public final class h0 {
    private static final boolean a;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r0.equals(com.tapjoy.TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
        if (r0.equals("") != false) goto L21;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.d0.d(r0)
            if (r0 == 0) goto L53
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2a
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L21
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L33
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            r0 = 0
            goto L54
        L21:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            goto L53
        L2a:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            goto L53
        L33:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L53:
            r0 = 1
        L54:
            kotlinx.coroutines.h0.a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.h0.<clinit>():void");
    }

    public static final CoroutineDispatcher a() {
        return a ? kotlinx.coroutines.scheduling.a.f8803f : y.a;
    }

    public static final String b(CoroutineContext coroutineContext) {
        k0 k0Var;
        String name;
        if (o0.c() && (k0Var = (k0) coroutineContext.get(k0.b)) != null) {
            l0 l0Var = (l0) coroutineContext.get(l0.b);
            String str = "coroutine";
            if (l0Var != null && (name = l0Var.getName()) != null) {
                str = name;
            }
            return str + Constants.ID_PREFIX + k0Var.z();
        }
        return null;
    }

    public static final CoroutineContext c(m0 m0Var, CoroutineContext coroutineContext) {
        CoroutineContext plus = m0Var.getCoroutineContext().plus(coroutineContext);
        CoroutineContext plus2 = o0.c() ? plus.plus(new k0(o0.b().incrementAndGet())) : plus;
        return (plus == z0.a() || plus.get(ContinuationInterceptor.Key) != null) ? plus2 : plus2.plus(z0.a());
    }

    public static final z2<?> d(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof v0) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof z2) {
                return (z2) coroutineStackFrame;
            }
        }
        return null;
    }

    public static final z2<?> e(Continuation<?> continuation, CoroutineContext coroutineContext, Object obj) {
        if (continuation instanceof CoroutineStackFrame) {
            if (coroutineContext.get(a3.a) != null) {
                z2<?> d2 = d((CoroutineStackFrame) continuation);
                if (d2 != null) {
                    d2.U0(coroutineContext, obj);
                }
                return d2;
            }
            return null;
        }
        return null;
    }
}
