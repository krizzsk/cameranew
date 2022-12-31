package kotlin.time;
/* compiled from: DurationJvm.kt */
/* loaded from: classes3.dex */
public final class b {
    private static final boolean a = false;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i2 = 0; i2 < 4; i2++) {
            threadLocalArr[i2] = new ThreadLocal();
        }
    }

    public static final boolean a() {
        return a;
    }
}
