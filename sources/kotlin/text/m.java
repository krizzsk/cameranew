package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Appendable.kt */
/* loaded from: classes3.dex */
public class m {
    public static <T> void a(Appendable appendable, T t, kotlin.jvm.b.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.s.h(appendable, "<this>");
        if (lVar != null) {
            appendable.append(lVar.invoke(t));
            return;
        }
        if (t == null ? true : t instanceof CharSequence) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
