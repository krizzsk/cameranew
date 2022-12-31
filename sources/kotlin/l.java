package kotlin;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* compiled from: UByte.kt */
/* loaded from: classes3.dex */
public final class l implements Comparable<l> {
    private final byte a;

    private /* synthetic */ l(byte b) {
        this.a = b;
    }

    public static final /* synthetic */ l a(byte b) {
        return new l(b);
    }

    public static byte b(byte b) {
        return b;
    }

    public static boolean c(byte b, Object obj) {
        return (obj instanceof l) && b == ((l) obj).f();
    }

    public static int d(byte b) {
        return b;
    }

    public static String e(byte b) {
        return String.valueOf(b & Draft_75.END_OF_FRAME);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(l lVar) {
        return kotlin.jvm.internal.s.j(f() & Draft_75.END_OF_FRAME, lVar.f() & Draft_75.END_OF_FRAME);
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ byte f() {
        return this.a;
    }

    public int hashCode() {
        byte b = this.a;
        d(b);
        return b;
    }

    public String toString() {
        return e(this.a);
    }
}
