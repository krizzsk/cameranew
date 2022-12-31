package us.pinguo.androidsdk;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class PGGLRenderer implements GLSurfaceView.Renderer {
    private PGGLRendererListener mListener;
    private boolean bRendering = false;
    private PGImageSDK imageSDK = null;
    private boolean bRenderThreadVaild = false;
    private long lCurrentTime = 0;
    private long lFrameTime = 0;
    private int nFrameTimeCount = 0;
    private int nFrameTime = 0;
    private long lRenderThread = -1;

    /* loaded from: classes3.dex */
    public interface PGGLRendererListener {
        void onGLCreated(GL10 gl10, EGLConfig eGLConfig);

        void onGLDestroyed();
    }

    public int getFrameCount() {
        return this.nFrameTimeCount;
    }

    public boolean getRenderStatus() {
        return this.bRendering;
    }

    public boolean getRenderThread() {
        return this.bRenderThreadVaild;
    }

    public long getRenderThreadId() {
        return this.lRenderThread;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        PGImageSDK pGImageSDK = this.imageSDK;
        if (pGImageSDK != null) {
            switch (pGImageSDK.getSDKStatus()) {
                case PGImageSDK.SDK_STATUS_CREATE /* 268435456 */:
                    synchronized (this.imageSDK.getRenderActionLock()) {
                        this.imageSDK.create();
                        this.imageSDK.getRenderActionLock().notify();
                    }
                    return;
                case PGImageSDK.SDK_STATUS_DRAW /* 268435457 */:
                    synchronized (this.imageSDK.getRenderActionLock()) {
                        this.bRendering = true;
                        long currentTimeMillis = System.currentTimeMillis();
                        this.lCurrentTime = currentTimeMillis;
                        if (currentTimeMillis >= this.lFrameTime) {
                            this.nFrameTimeCount = this.nFrameTime;
                            this.nFrameTime = 0;
                            this.lFrameTime = currentTimeMillis + 1000;
                        }
                        if (this.imageSDK.getRenderMethod() != null) {
                            this.imageSDK.getRenderMethod().rendererAction();
                        }
                        this.nFrameTime++;
                        this.bRendering = false;
                        this.imageSDK.getRenderActionLock().notify();
                    }
                    return;
                case PGImageSDK.SDK_STATUS_DESTROY /* 268435458 */:
                    synchronized (this.imageSDK.getRenderActionLock()) {
                        this.imageSDK.destroy();
                        this.imageSDK.getRenderActionLock().notify();
                    }
                    PGGLRendererListener pGGLRendererListener = this.mListener;
                    if (pGGLRendererListener != null) {
                        pGGLRendererListener.onGLDestroyed();
                    }
                    System.gc();
                    return;
                case PGImageSDK.SDK_STATUS_RELOAD /* 268435459 */:
                    synchronized (this.imageSDK.getRenderActionLock()) {
                        this.bRendering = true;
                        PGImageSDK pGImageSDK2 = this.imageSDK;
                        pGImageSDK2.setResourceStatus(PGNativeMethod.loadResource(pGImageSDK2.getRenderPointer(), this.imageSDK.getResource()));
                        this.bRendering = false;
                        this.imageSDK.getRenderActionLock().notify();
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.lRenderThread = Thread.currentThread().getId();
        this.bRenderThreadVaild = true;
        PGGLRendererListener pGGLRendererListener = this.mListener;
        if (pGGLRendererListener != null) {
            pGGLRendererListener.onGLCreated(gl10, eGLConfig);
        }
    }

    public void setImageSDK(PGImageSDK pGImageSDK) {
        this.imageSDK = pGImageSDK;
    }

    public void setPGGLRendererListener(PGGLRendererListener pGGLRendererListener) {
        this.mListener = pGGLRendererListener;
    }
}
