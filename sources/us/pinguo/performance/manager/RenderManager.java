package us.pinguo.performance.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.view.ViewGroup;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import us.pinguo.util.s;
import us.pinguo.util.v;
/* loaded from: classes5.dex */
class RenderManager {

    /* loaded from: classes5.dex */
    private static class GPUCheckGLSurfaceView extends GLSurfaceView {
        public GPUCheckGLSurfaceView(Context context) {
            super(context);
            setRenderer(new b());
        }
    }

    /* loaded from: classes5.dex */
    private static class b implements GLSurfaceView.Renderer {
        private b() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            String glGetString = gl10.glGetString(7936);
            String glGetString2 = gl10.glGetString(7937);
            us.pinguo.common.log.a.k(String.format("获取到GPU型号,vendor:%s,render:%s", glGetString, glGetString2), new Object[0]);
            RenderManager.d(glGetString2);
        }
    }

    public static String b() {
        SharedPreferences sharedPreferences = v.a().getSharedPreferences("inspire_share_pref", 0);
        String string = sharedPreferences.getString("CPU", "");
        if (TextUtils.isEmpty(string)) {
            string = s.b();
        }
        sharedPreferences.edit().putString("CPU", string).apply();
        return string;
    }

    public static String c() {
        return v.a().getSharedPreferences("inspire_share_pref", 0).getString("GPU", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        SharedPreferences.Editor edit = v.a().getSharedPreferences("inspire_share_pref", 0).edit();
        edit.putString("GPU", str);
        edit.apply();
    }

    public static void e(ViewGroup viewGroup) {
        GPUCheckGLSurfaceView gPUCheckGLSurfaceView = new GPUCheckGLSurfaceView(viewGroup.getContext());
        gPUCheckGLSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        viewGroup.addView(gPUCheckGLSurfaceView);
    }
}
