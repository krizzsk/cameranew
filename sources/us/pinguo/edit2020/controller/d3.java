package us.pinguo.edit2020.controller;

import android.view.MotionEvent;
import us.pinguo.edit2020.controller.z2;
/* compiled from: IEditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
public interface d3 extends z2, c3, a3 {

    /* compiled from: IEditBottomTabBeautyController.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public static boolean a(d3 d3Var) {
            kotlin.jvm.internal.s.h(d3Var, "this");
            return z2.a.a(d3Var);
        }

        public static boolean b(d3 d3Var) {
            kotlin.jvm.internal.s.h(d3Var, "this");
            return z2.a.c(d3Var);
        }
    }

    void B(boolean z);

    void K(us.pinguo.facedetector.c cVar);

    void N(kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar);

    boolean b(MotionEvent motionEvent);

    void e(us.pinguo.edit2020.bean.u0 u0Var);

    void o(int i2);

    void show();
}
