package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.o0;
/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes3.dex */
public final class b0 {
    private static final String a;
    private static final String b;

    static {
        Object m41constructorimpl;
        Object m41constructorimpl2;
        try {
            Result.a aVar = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(kotlin.j.a(th));
        }
        if (Result.m44exceptionOrNullimpl(m41constructorimpl) != null) {
            m41constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) m41constructorimpl;
        try {
            Result.a aVar3 = Result.Companion;
            m41constructorimpl2 = Result.m41constructorimpl(Class.forName("kotlinx.coroutines.internal.b0").getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar4 = Result.Companion;
            m41constructorimpl2 = Result.m41constructorimpl(kotlin.j.a(th2));
        }
        if (Result.m44exceptionOrNullimpl(m41constructorimpl2) != null) {
            m41constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        b = (String) m41constructorimpl2;
    }

    public static final /* synthetic */ Throwable a(Throwable th, CoroutineStackFrame coroutineStackFrame) {
        return j(th, coroutineStackFrame);
    }

    public static final StackTraceElement b(String str) {
        return new StackTraceElement(kotlin.jvm.internal.s.q("\b\b\b(", str), "\b", "\b", -1);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> c(E e2) {
        boolean z;
        Throwable cause = e2.getCause();
        if (cause != null && kotlin.jvm.internal.s.c(cause.getClass(), e2.getClass())) {
            StackTraceElement[] stackTrace = e2.getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (h(stackTrace[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return kotlin.k.a(cause, stackTrace);
            }
            return kotlin.k.a(e2, new StackTraceElement[0]);
        }
        return kotlin.k.a(e2, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E d(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(b("Coroutine boundary"));
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int g2 = g(stackTrace, a);
        int i2 = 0;
        if (g2 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            e3.setStackTrace((StackTraceElement[]) array);
            return e3;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + g2];
        if (g2 > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                stackTraceElementArr[i3] = stackTrace[i3];
                if (i4 >= g2) {
                    break;
                }
                i3 = i4;
            }
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            int i5 = i2 + 1;
            stackTraceElementArr[i2 + g2] = it.next();
            i2 = i5;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    private static final ArrayDeque<StackTraceElement> e(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(coroutineStackFrame instanceof CoroutineStackFrame)) {
                coroutineStackFrame = null;
            }
            coroutineStackFrame = coroutineStackFrame == null ? null : coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    private static final boolean f(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kotlin.jvm.internal.s.c(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && kotlin.jvm.internal.s.c(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && kotlin.jvm.internal.s.c(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int g(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (kotlin.jvm.internal.s.c(str, stackTraceElementArr[i2].getClassName())) {
                return i2;
            }
        }
        return -1;
    }

    public static final boolean h(StackTraceElement stackTraceElement) {
        boolean x;
        x = kotlin.text.t.x(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
        return x;
    }

    private static final void i(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (h(stackTraceElementArr[i2])) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i3 > length2) {
            return;
        }
        while (true) {
            int i4 = length2 - 1;
            if (f(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i3) {
                return;
            }
            length2 = i4;
        }
    }

    public static final <E extends Throwable> E j(E e2, CoroutineStackFrame coroutineStackFrame) {
        Pair c = c(e2);
        Throwable th = (Throwable) c.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) c.component2();
        E e3 = (E) m(th);
        if (e3 == null) {
            return e2;
        }
        ArrayDeque<StackTraceElement> e4 = e(coroutineStackFrame);
        if (e4.isEmpty()) {
            return e2;
        }
        if (th != e2) {
            i(stackTraceElementArr, e4);
        }
        d(th, e3, e4);
        return e3;
    }

    public static final <E extends Throwable> E k(E e2) {
        E e3;
        if (o0.d() && (e3 = (E) m(e2)) != null) {
            l(e3);
            return e3;
        }
        return e2;
    }

    private static final <E extends Throwable> E l(E e2) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int length = stackTrace.length;
        int g2 = g(stackTrace, b);
        int i2 = g2 + 1;
        int g3 = g(stackTrace, a);
        int i3 = (length - g2) - (g3 == -1 ? 0 : length - g3);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 == 0) {
                stackTraceElement = b("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i2 + i4) - 1];
            }
            stackTraceElementArr[i4] = stackTraceElement;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    private static final <E extends Throwable> E m(E e2) {
        E e3 = (E) ExceptionsConstuctorKt.e(e2);
        if (e3 == null) {
            return null;
        }
        if ((e2 instanceof kotlinx.coroutines.g0) || kotlin.jvm.internal.s.c(e3.getMessage(), e2.getMessage())) {
            return e3;
        }
        return null;
    }

    public static final <E extends Throwable> E n(E e2) {
        E e3 = (E) e2.getCause();
        if (e3 != null && kotlin.jvm.internal.s.c(e3.getClass(), e2.getClass())) {
            StackTraceElement[] stackTrace = e2.getStackTrace();
            int length = stackTrace.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (h(stackTrace[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return e3;
            }
        }
        return e2;
    }
}
