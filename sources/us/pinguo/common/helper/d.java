package us.pinguo.common.helper;

import kotlin.jvm.internal.s;
import us.pinguo.common.gesture.Vector;
/* compiled from: VectorHelper.kt */
/* loaded from: classes4.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    public final boolean a(Vector vectorA, Vector vectorB) {
        s.h(vectorA, "vectorA");
        s.h(vectorB, "vectorB");
        return Math.abs(Math.abs(vectorA.b() - vectorB.b()) - vectorA.a(vectorB).b()) < 1.0f;
    }
}
