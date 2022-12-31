package us.pinguo.cameramanger;

import android.graphics.PointF;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import kotlin.jvm.b.l;
import kotlin.u;
import us.pinguo.cameramanger.info.CameraFrame;
import us.pinguo.cameramanger.info.Flash;
import us.pinguo.cameramanger.info.LensFacing;
import us.pinguo.cameramanger.info.WhiteBalance;
/* compiled from: ICameraManager.kt */
/* loaded from: classes4.dex */
public interface e {

    /* compiled from: ICameraManager.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    /* compiled from: ICameraManager.kt */
    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ void a(e eVar, PointF pointF, float f2, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: focusArea");
            }
            if ((i3 & 2) != 0) {
                f2 = 0.1f;
            }
            if ((i3 & 4) != 0) {
                i2 = 800;
            }
            eVar.z(pointF, f2, i2);
        }

        public static /* synthetic */ void b(e eVar, PointF pointF, float f2, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: meteringArea");
            }
            if ((i3 & 2) != 0) {
                f2 = 0.1f;
            }
            if ((i3 & 4) != 0) {
                i2 = 800;
            }
            eVar.t(pointF, f2, i2);
        }
    }

    static {
        a aVar = a.a;
    }

    void A();

    List<WhiteBalance> B();

    void C(float f2);

    boolean D(CameraFrame cameraFrame);

    boolean a(Flash flash);

    void b(g gVar);

    boolean c();

    LensFacing d();

    Flash e();

    boolean f(boolean z);

    void g(int i2, int i3);

    void h(l<? super byte[], u> lVar);

    void i(f fVar);

    boolean j(CameraFrame cameraFrame);

    void k(float f2);

    us.pinguo.cameramanger.info.a l();

    boolean m();

    boolean n(LensFacing lensFacing);

    CameraFrame o();

    void p(boolean z);

    us.pinguo.cameramanger.info.a q(LensFacing lensFacing);

    void r(LifecycleOwner lifecycleOwner);

    void s();

    void t(PointF pointF, float f2, int i2);

    boolean u();

    boolean v();

    void w(us.pinguo.cameramanger.viewfinder.a aVar);

    void x(WhiteBalance whiteBalance);

    boolean y();

    void z(PointF pointF, float f2, int i2);
}
