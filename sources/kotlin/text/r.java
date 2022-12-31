package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: classes3.dex */
public class r extends q {
    public static Double f(String str) {
        kotlin.jvm.internal.s.h(str, "<this>");
        try {
            if (k.b.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float g(String str) {
        kotlin.jvm.internal.s.h(str, "<this>");
        try {
            if (k.b.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
