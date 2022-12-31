package kotlin;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public class b {
    public static void a(Throwable th, Throwable exception) {
        kotlin.jvm.internal.s.h(th, "<this>");
        kotlin.jvm.internal.s.h(exception, "exception");
        if (th != exception) {
            kotlin.internal.b.a.a(th, exception);
        }
    }
}
