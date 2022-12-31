package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharJVM.kt */
/* loaded from: classes3.dex */
public class b {
    public static int a(int i2) {
        if (new kotlin.z.d(2, 36).f(i2)) {
            return i2;
        }
        throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new kotlin.z.d(2, 36));
    }

    public static final int b(char c, int i2) {
        return Character.digit((int) c, i2);
    }

    public static final boolean c(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
