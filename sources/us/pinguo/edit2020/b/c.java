package us.pinguo.edit2020.b;

import kotlin.jvm.internal.s;
import us.pinguo.edit2020.controller.z2;
/* compiled from: WorkFlowNotifier.kt */
/* loaded from: classes4.dex */
public interface c extends z2 {

    /* compiled from: WorkFlowNotifier.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public static boolean a(c cVar) {
            s.h(cVar, "this");
            return z2.a.a(cVar);
        }

        public static boolean b(c cVar) {
            s.h(cVar, "this");
            return z2.a.b(cVar);
        }

        public static boolean c(c cVar) {
            s.h(cVar, "this");
            return z2.a.c(cVar);
        }

        public static boolean d(c cVar) {
            s.h(cVar, "this");
            return z2.a.d(cVar);
        }

        public static /* synthetic */ void e(c cVar, String str, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onWorkflowStarted");
            }
            if ((i2 & 1) != 0) {
                str = null;
            }
            cVar.z(str);
        }
    }

    @Override // us.pinguo.edit2020.controller.z2
    void d();

    @Override // us.pinguo.edit2020.controller.z2
    void g();

    void z(String str);
}
