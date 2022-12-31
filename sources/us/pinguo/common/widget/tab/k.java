package us.pinguo.common.widget.tab;
/* compiled from: ClickSpanUtil.kt */
/* loaded from: classes4.dex */
public final class k {
    public static final k a = new k();
    private static long b;

    private k() {
    }

    public static /* synthetic */ boolean b(k kVar, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 500;
        }
        return kVar.a(i2);
    }

    public final boolean a(int i2) {
        if (System.currentTimeMillis() - b <= i2) {
            return true;
        }
        b = System.currentTimeMillis();
        return false;
    }
}
