package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Strings.kt */
/* loaded from: classes3.dex */
public class v extends u {
    public static final String L0(String str, int i2) {
        int c;
        kotlin.jvm.internal.s.h(str, "<this>");
        if (i2 >= 0) {
            c = kotlin.z.j.c(i2, str.length());
            String substring = str.substring(c);
            kotlin.jvm.internal.s.g(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static Character M0(CharSequence charSequence) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }
}
