package us.pinguo.PGEquinox;

import android.opengl.GLUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.work.Data;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL11;
/* loaded from: classes3.dex */
public class PGGLContextManager {
    private static String LOG_TAG = "PGGLContextManager";
    private EGLSurface m_CodecSurface;
    private EGLConfig m_EglConfig;
    private EGLContext m_EglContext;
    private EGLDisplay m_EglDisplay;
    private EGL10 m_EglInstance;
    private EGLSurface m_EglPBSurface;
    private GL11 m_Gl;
    private EGLSurface m_ViewSurface;
    private EGLConfig[] m_aEglConfigs = new EGLConfig[1];
    private int[] m_aEglNumConfig = new int[1];
    private int[] m_aEglVersion = new int[2];
    private int[] m_aContextAttribList = {12440, 2, 12344};
    private int[] m_aPbufferAttribList = {12375, 32, 12374, 32, 12344};
    private int[] m_aEglAttrib = {12339, 1, 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344};

    private void checkEglError() {
        int eglGetError = this.m_EglInstance.eglGetError();
        if (eglGetError != 12288) {
            String str = LOG_TAG;
            Log.e(str, "EGL error = 0x" + Integer.toHexString(eglGetError));
        }
    }

    private void checkGlError() {
        int glGetError = this.m_Gl.glGetError();
        if (glGetError != 0) {
            String str = LOG_TAG;
            Log.e(str, "GL error = 0x" + Integer.toHexString(glGetError));
        }
    }

    public void activateCodecGLContext() {
        EGLSurface eGLSurface = this.m_CodecSurface;
        if (eGLSurface == null || this.m_EglInstance.eglMakeCurrent(this.m_EglDisplay, eGLSurface, eGLSurface, this.m_EglContext)) {
            return;
        }
        String str = LOG_TAG;
        Log.e(str, "eglMakeCurrent Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
    }

    public void activateOurGLContext() {
        EGLSurface eGLSurface = this.m_ViewSurface;
        if (eGLSurface == null) {
            EGL10 egl10 = this.m_EglInstance;
            EGLDisplay eGLDisplay = this.m_EglDisplay;
            EGLSurface eGLSurface2 = this.m_EglPBSurface;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.m_EglContext)) {
                return;
            }
            String str = LOG_TAG;
            Log.e(str, "eglMakeCurrent Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
        } else if (this.m_EglInstance.eglMakeCurrent(this.m_EglDisplay, eGLSurface, eGLSurface, this.m_EglContext)) {
        } else {
            String str2 = LOG_TAG;
            Log.e(str2, "eglMakeCurrent Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
        }
    }

    public void addCodecSurface(Surface surface) {
        if (surface != null) {
            this.m_CodecSurface = this.m_EglInstance.eglCreateWindowSurface(this.m_EglDisplay, this.m_EglConfig, surface, new int[]{12344});
            checkEglError();
        }
    }

    public void addSurface(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            EGLSurface eglCreatePbufferSurface = this.m_EglInstance.eglCreatePbufferSurface(this.m_EglDisplay, this.m_EglConfig, this.m_aPbufferAttribList);
            this.m_EglPBSurface = eglCreatePbufferSurface;
            if (eglCreatePbufferSurface == EGL10.EGL_NO_SURFACE) {
                String str = LOG_TAG;
                Log.e(str, "eglCreatePbufferSurface Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
                return;
            }
            return;
        }
        this.m_ViewSurface = this.m_EglInstance.eglCreateWindowSurface(this.m_EglDisplay, this.m_EglConfig, surfaceHolder, new int[]{12344});
        checkEglError();
    }

    public int createGLExtTexture() {
        int[] iArr = new int[1];
        this.m_Gl.glGenTextures(1, iArr, 0);
        checkGlError();
        int i2 = iArr[0];
        if (i2 > 0) {
            this.m_Gl.glBindTexture(36197, i2);
            checkGlError();
            this.m_Gl.glTexParameterf(36197, 10241, 9729.0f);
            this.m_Gl.glTexParameterf(36197, Data.MAX_DATA_BYTES, 9729.0f);
            this.m_Gl.glTexParameteri(36197, 10242, 33071);
            this.m_Gl.glTexParameteri(36197, 10243, 33071);
            checkGlError();
            return i2;
        }
        throw new RuntimeException("invalid GL texture id generated");
    }

    public void deactivateOurGLContext() {
        if (this.m_EglDisplay == null || this.m_EglPBSurface == null) {
            return;
        }
        EGL10 egl10 = this.m_EglInstance;
        EGLDisplay eGLDisplay = EGL10.EGL_NO_DISPLAY;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT)) {
            return;
        }
        String str = LOG_TAG;
        Log.e(str, "eglMakeCurrent Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
    }

    public void deleteGLExtTexture(int i2) {
        this.m_Gl.glActiveTexture(33984);
        this.m_Gl.glDeleteTextures(1, new int[]{i2}, 0);
        checkGlError();
    }

    public void initGLContext(int i2) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.m_EglInstance = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.m_EglDisplay = eglGetDisplay;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            String str = LOG_TAG;
            Log.e(str, "eglGetDisplay Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
        }
        if (!this.m_EglInstance.eglInitialize(this.m_EglDisplay, this.m_aEglVersion)) {
            String str2 = LOG_TAG;
            Log.e(str2, "eglInitialize Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
        }
        if (!this.m_EglInstance.eglChooseConfig(this.m_EglDisplay, this.m_aEglAttrib, this.m_aEglConfigs, 1, this.m_aEglNumConfig)) {
            String str3 = LOG_TAG;
            Log.e(str3, "eglChooseConfig Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
        }
        EGLConfig eGLConfig = this.m_aEglConfigs[0];
        this.m_EglConfig = eGLConfig;
        if (eGLConfig == null) {
            Log.e(LOG_TAG, "eglConfig not initialized");
        }
        int[] iArr = this.m_aContextAttribList;
        iArr[1] = 3;
        EGLContext eglCreateContext = this.m_EglInstance.eglCreateContext(this.m_EglDisplay, this.m_EglConfig, EGL10.EGL_NO_CONTEXT, iArr);
        this.m_EglContext = eglCreateContext;
        EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        if (eglCreateContext == eGLContext) {
            int[] iArr2 = this.m_aContextAttribList;
            iArr2[1] = 2;
            EGLContext eglCreateContext2 = this.m_EglInstance.eglCreateContext(this.m_EglDisplay, this.m_EglConfig, eGLContext, iArr2);
            this.m_EglContext = eglCreateContext2;
            if (eglCreateContext2 == EGL10.EGL_NO_CONTEXT) {
                String str4 = LOG_TAG;
                Log.e(str4, "eglCreateContext Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
            }
        }
        this.m_Gl = (GL11) this.m_EglContext.getGL();
        checkEglError();
    }

    public void presentCodecSurface() {
        EGLSurface eGLSurface = this.m_CodecSurface;
        if (eGLSurface != null) {
            if (!this.m_EglInstance.eglSwapBuffers(this.m_EglDisplay, eGLSurface)) {
                Log.e(LOG_TAG, "cannot swap buffers!");
            }
            checkEglError();
        }
    }

    public void presentSurface() {
        EGLSurface eGLSurface = this.m_ViewSurface;
        if (eGLSurface != null) {
            if (!this.m_EglInstance.eglSwapBuffers(this.m_EglDisplay, eGLSurface)) {
                Log.e(LOG_TAG, "cannot swap buffers!");
            }
            checkEglError();
        }
    }

    public void releaseContext() {
        EGL10 egl10 = this.m_EglInstance;
        EGLDisplay eGLDisplay = this.m_EglDisplay;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT)) {
            String str = LOG_TAG;
            Log.e(str, "eglMakeCurrent Release Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
        }
        if (!this.m_EglInstance.eglDestroyContext(this.m_EglDisplay, this.m_EglContext)) {
            String str2 = LOG_TAG;
            Log.e(str2, "eglDestroyContext Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
        }
        EGLDisplay eGLDisplay2 = this.m_EglDisplay;
        if (eGLDisplay2 != null) {
            this.m_EglInstance.eglTerminate(eGLDisplay2);
            this.m_EglDisplay = null;
        }
        this.m_EglContext = null;
    }

    public void releaseGL() {
        EGLDisplay eGLDisplay = this.m_EglDisplay;
        if (eGLDisplay != null) {
            EGL10 egl10 = this.m_EglInstance;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            checkGlError();
            this.m_EglInstance.eglDestroyContext(this.m_EglDisplay, this.m_EglContext);
            checkGlError();
            EGLSurface eGLSurface2 = this.m_ViewSurface;
            if (eGLSurface2 != null) {
                this.m_EglInstance.eglDestroySurface(this.m_EglDisplay, eGLSurface2);
            } else {
                EGLSurface eGLSurface3 = this.m_EglPBSurface;
                if (eGLSurface3 != null) {
                    this.m_EglInstance.eglDestroySurface(this.m_EglDisplay, eGLSurface3);
                }
            }
            checkGlError();
            this.m_EglInstance.eglTerminate(this.m_EglDisplay);
        }
    }

    public void releaseSurface() {
        EGL10 egl10 = this.m_EglInstance;
        EGLDisplay eGLDisplay = this.m_EglDisplay;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT)) {
            String str = LOG_TAG;
            Log.e(str, "eglMakeCurrent release Error:" + this.m_EglInstance.eglGetError());
        }
        EGLSurface eGLSurface2 = this.m_EglPBSurface;
        if (eGLSurface2 != null) {
            if (!this.m_EglInstance.eglDestroySurface(this.m_EglDisplay, eGLSurface2)) {
                String str2 = LOG_TAG;
                Log.e(str2, "eglDestroySurface Error:" + GLUtils.getEGLErrorString(this.m_EglInstance.eglGetError()));
            }
            this.m_EglPBSurface = null;
        }
        EGLSurface eGLSurface3 = this.m_ViewSurface;
        if (eGLSurface3 != null) {
            if (!this.m_EglInstance.eglDestroySurface(this.m_EglDisplay, eGLSurface3)) {
                String str3 = LOG_TAG;
                Log.e(str3, "eglDestroySurface Error:" + this.m_EglInstance.eglGetError());
            }
            this.m_ViewSurface = null;
        }
    }
}
