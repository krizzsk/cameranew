package us.pinguo.edit2020.controller;

import us.pinguo.edit2020.controller.z2;
/* compiled from: EditBottomTab.kt */
/* loaded from: classes4.dex */
public interface i3 extends z2 {

    /* compiled from: EditBottomTab.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ void a(i3 i3Var, us.pinguo.edit2020.model.editgoto.b bVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enter");
            }
            if ((i2 & 1) != 0) {
                bVar = null;
            }
            i3Var.u(bVar);
        }

        public static boolean b(i3 i3Var) {
            kotlin.jvm.internal.s.h(i3Var, "this");
            return z2.a.a(i3Var);
        }

        public static boolean c(i3 i3Var) {
            kotlin.jvm.internal.s.h(i3Var, "this");
            return z2.a.c(i3Var);
        }

        public static boolean d(i3 i3Var) {
            kotlin.jvm.internal.s.h(i3Var, "this");
            return z2.a.d(i3Var);
        }
    }

    @Override // us.pinguo.edit2020.controller.z2
    boolean f();

    void u(us.pinguo.edit2020.model.editgoto.b bVar);
}
