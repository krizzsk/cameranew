package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.s;
import kotlin.random.Random;
/* compiled from: PlatformImplementations.kt */
/* loaded from: classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlatformImplementations.kt */
    /* renamed from: kotlin.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0316a {
        public static final Method a;

        /* JADX WARN: Removed duplicated region for block: B:12:0x0037 A[LOOP:0: B:3:0x000e->B:12:0x0037, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x003b A[EDGE_INSN: B:21:0x003b->B:14:0x003b ?: BREAK  , SYNTHETIC] */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.s.g(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            Le:
                if (r4 >= r2) goto L3a
                r5 = r1[r4]
                java.lang.String r6 = r5.getName()
                java.lang.String r7 = "addSuppressed"
                boolean r6 = kotlin.jvm.internal.s.c(r6, r7)
                if (r6 == 0) goto L33
                java.lang.Class[] r6 = r5.getParameterTypes()
                java.lang.String r7 = "it.parameterTypes"
                kotlin.jvm.internal.s.g(r6, r7)
                java.lang.Object r6 = kotlin.collections.j.B(r6)
                boolean r6 = kotlin.jvm.internal.s.c(r6, r0)
                if (r6 == 0) goto L33
                r6 = 1
                goto L34
            L33:
                r6 = 0
            L34:
                if (r6 == 0) goto L37
                goto L3b
            L37:
                int r4 = r4 + 1
                goto Le
            L3a:
                r5 = 0
            L3b:
                kotlin.internal.a.C0316a.a = r5
                int r0 = r1.length
            L3e:
                if (r3 >= r0) goto L52
                r2 = r1[r3]
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = kotlin.jvm.internal.s.c(r2, r4)
                if (r2 == 0) goto L4f
                goto L52
            L4f:
                int r3 = r3 + 1
                goto L3e
            L52:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.a.C0316a.<clinit>():void");
        }
    }

    public void a(Throwable cause, Throwable exception) {
        s.h(cause, "cause");
        s.h(exception, "exception");
        Method method = C0316a.a;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public Random b() {
        return new kotlin.random.b();
    }
}
