package us.pinguo.nativeinterface;

import android.opengl.GLES20;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: UnityInterface.kt */
/* loaded from: classes5.dex */
public final class UnityInterface {
    public static final a Companion = new a(null);
    private static final String TAG = "UnityInterface";
    public static final int UNITY_EDIT_BOKEH_GENERATED_ICON = 10007;
    public static final int UNITY_EDIT_BOKEH_SHAPE = 10006;
    public static final int UNITY_EDIT_GL_FINISH = 10009;
    public static final int UNITY_EDIT_INIT = 10001;
    public static final int UNITY_EDIT_MAGNIFIER = 10002;
    public static final int UNITY_EDIT_UPDATE = 10005;
    public static final int UNITY_FILTER = 10004;
    public static final int UNITY_MAKE_ONLINE_FILTER = 10011;
    public static final int UNITY_RENDER_BLING = 10010;
    public static final int UNITY_SPOT_DETECT = 10003;
    public static final int UNIT_EDIT_BOKEH_GENERATED_PREVIEW_MASK = 10008;
    private b editRender;
    private c mRender;

    /* compiled from: UnityInterface.kt */
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    /* compiled from: UnityInterface.kt */
    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void glRenderBlingBlingFilter();

        void glRenderNativeFilter();

        void h();
    }

    /* compiled from: UnityInterface.kt */
    /* loaded from: classes5.dex */
    public interface c {
        void glCleanUp();

        void glRenderBeforeGetCameraSession();

        void glRenderBeforeGetCaptureSession();

        void glRenderNativeFilter();
    }

    static {
        System.loadLibrary("unity-interface");
    }

    private final void glCleanUp() {
        c cVar = this.mRender;
        if (cVar == null) {
            return;
        }
        cVar.glCleanUp();
    }

    private final void glEditNativeRender(int i2) {
        b bVar = this.editRender;
        if (bVar == null) {
            return;
        }
        switch (i2) {
            case 10001:
                bVar.b();
                return;
            case 10002:
                bVar.d();
                return;
            case 10003:
                bVar.f();
                return;
            case 10004:
            default:
                return;
            case 10005:
                bVar.e();
                return;
            case 10006:
                bVar.g();
                return;
            case 10007:
                bVar.h();
                return;
            case 10008:
                bVar.c();
                return;
            case 10009:
                GLES20.glFinish();
                return;
            case 10010:
                bVar.glRenderBlingBlingFilter();
                return;
            case 10011:
                bVar.a();
                return;
        }
    }

    private final void glPostRender() {
        c cVar = this.mRender;
        if (cVar != null) {
            cVar.glRenderNativeFilter();
        }
        b bVar = this.editRender;
        if (bVar == null) {
            return;
        }
        bVar.glRenderNativeFilter();
    }

    private final void glPreCapture() {
        c cVar = this.mRender;
        if (cVar == null) {
            return;
        }
        cVar.glRenderBeforeGetCaptureSession();
    }

    private final void glPreRender() {
        c cVar = this.mRender;
        if (cVar == null) {
            return;
        }
        cVar.glRenderBeforeGetCameraSession();
    }

    public final void clearGLRender(c cVar) {
        if (s.c(this.mRender, cVar)) {
            this.mRender = null;
        }
    }

    public final b getEditRender() {
        return this.editRender;
    }

    public final native void nativeInit();

    public final native void nativeRelease();

    public final void setEditRender(b bVar) {
        this.editRender = bVar;
    }

    public final void setGLRender(c cVar) {
        this.mRender = cVar;
    }
}
