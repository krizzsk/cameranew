package us.pinguo.androidsdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import us.pinguo.androidsdk.RenderPointerManager;
import us.pinguo.edit.sdk.core.utils.SdkLog;
/* loaded from: classes3.dex */
public class PGGLSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer, SDKReloadResourceListener {
    private static final int STATE_DESTROY = 4;
    private static final int STATE_DRAW = 3;
    private static final int STATE_INIT = 1;
    private static final int STATE_RELOAD = 2;
    private static final String TAG = PGGLSurfaceView.class.getSimpleName();
    private int fps;
    private int fpsCount;
    private Rect frameRect;
    private int height;
    private PGGLListener listener;
    private AtomicBoolean mIsInRenderAction;
    private String mKey;
    private transient long mRendererPointer;
    private AtomicBoolean mSetReleaseTexture;
    private PGRendererMethod method;
    private boolean needRefreshMethod;
    private boolean needReload;
    private final byte[] sdkLock;
    private long startTime;
    private transient int state;
    private SurfaceTexture surfaceTexture;
    private int surfaceTextureName;
    private final byte[] textureLock;
    private int width;

    public PGGLSurfaceView(Context context) {
        super(context);
        this.mRendererPointer = 0L;
        this.method = null;
        this.state = 0;
        this.needReload = false;
        this.sdkLock = new byte[0];
        this.fps = 0;
        this.fpsCount = 0;
        this.startTime = 0L;
        this.needRefreshMethod = false;
        this.listener = null;
        this.surfaceTextureName = -1;
        this.mIsInRenderAction = new AtomicBoolean(false);
        this.mSetReleaseTexture = new AtomicBoolean(false);
        this.textureLock = new byte[0];
        init();
    }

    private void init() {
        getHolder().setFormat(-3);
        setEGLContextClientVersion(2);
        if (Build.VERSION.SDK_INT > 8) {
            setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        } else {
            setEGLConfigChooser(5, 6, 5, 0, 0, 0);
        }
        setRenderer(this);
        setRenderMode(0);
    }

    public void destroy() {
        this.listener = null;
    }

    public int getFps() {
        return this.fps;
    }

    public SurfaceTexture getSurfaceTexture() {
        if (this.surfaceTexture == null) {
            this.surfaceTexture = new SurfaceTexture(this.surfaceTextureName);
        }
        return this.surfaceTexture;
    }

    public int getSurfaceTextureName() {
        return this.surfaceTextureName;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        int i2 = this.state;
        if (i2 == 1) {
            synchronized (this.sdkLock) {
                this.mSetReleaseTexture.set(false);
                if (this.mRendererPointer == 0) {
                    RenderPointerManager.PGImageSDKPointer currentThreadPointer = RenderPointerManager.getCurrentThreadPointer();
                    currentThreadPointer.initRenderPointer(GPUEditor.EFFECT_KEY, getContext(), PGShaderHolder.getShaderFile(getContext()));
                    this.mRendererPointer = currentThreadPointer.getRendererPointer();
                    if (this.needReload) {
                        this.state = 2;
                        SdkLog.c(TAG, "onDrawFrame requestRender");
                        requestRender();
                    } else {
                        this.state = 3;
                    }
                    PGGLListener pGGLListener = this.listener;
                    if (pGGLListener != null) {
                        pGGLListener.glCreated(gl10);
                    }
                }
            }
        } else if (i2 == 2) {
            synchronized (this.sdkLock) {
                long j2 = this.mRendererPointer;
                if (j2 != 0) {
                    PGNativeMethod.loadResource(j2, PGShaderHolder.getShaderFile(getContext()));
                    this.state = 3;
                    this.needReload = false;
                }
            }
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            if (this.mRendererPointer != 0) {
                RenderPointerManager.getCurrentThreadPointer().destroyPointer();
                synchronized (this.sdkLock) {
                    this.mRendererPointer = 0L;
                    this.method = null;
                    this.sdkLock.notifyAll();
                }
            }
            this.mRendererPointer = 0L;
            PGGLListener pGGLListener2 = this.listener;
            if (pGGLListener2 != null) {
                pGGLListener2.glDestroyed();
            }
        } else if (this.method != null) {
            if (this.surfaceTexture != null) {
                synchronized (this.textureLock) {
                    if (this.surfaceTexture == null) {
                        return;
                    }
                    SdkLog.c(TAG, "setInputImage: updateTexImage");
                    this.surfaceTexture.updateTexImage();
                }
            }
            this.method.rendererAction();
            if (this.fpsCount == 0) {
                this.startTime = System.currentTimeMillis();
                this.fpsCount++;
            } else if (System.currentTimeMillis() - this.startTime < 1000) {
                this.fpsCount++;
            } else {
                this.fps = this.fpsCount;
                this.fpsCount = 0;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        synchronized (this.sdkLock) {
            if (this.mRendererPointer != 0) {
                synchronized (this.sdkLock) {
                    this.state = 4;
                    SdkLog.c(TAG, "onPause requestRender");
                    requestRender();
                    try {
                        this.sdkLock.wait(1000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        super.onPause();
        this.needRefreshMethod = true;
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        this.needRefreshMethod = true;
        super.onResume();
        synchronized (this.sdkLock) {
            if (this.mRendererPointer == 0) {
                this.state = 1;
                SdkLog.c(TAG, "onResume requestRender");
                requestRender();
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        this.width = i2;
        this.height = i3;
        PGRendererMethod pGRendererMethod = this.method;
        if (pGRendererMethod != null) {
            pGRendererMethod.setScreenSize(true, i2, i3);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int[] iArr = new int[1];
        gl10.glGenTextures(1, iArr, 0);
        this.surfaceTextureName = iArr[0];
        synchronized (this.sdkLock) {
            if (this.mRendererPointer == 0) {
                RenderPointerManager.PGImageSDKPointer currentThreadPointer = RenderPointerManager.getCurrentThreadPointer();
                currentThreadPointer.initRenderPointer(GPUEditor.EFFECT_KEY, getContext(), PGShaderHolder.getShaderFile(getContext()));
                this.mRendererPointer = currentThreadPointer.getRendererPointer();
                this.state = 3;
                PGGLListener pGGLListener = this.listener;
                if (pGGLListener != null) {
                    pGGLListener.glCreated(gl10);
                }
            }
        }
    }

    public void releaseTexture() {
        synchronized (this.textureLock) {
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.surfaceTexture = null;
            }
        }
    }

    @Override // us.pinguo.androidsdk.SDKReloadResourceListener
    public void reloadResources() {
        this.needReload = true;
        SdkLog.c(TAG, "reloadResources requestRender");
        requestRender();
    }

    public void renderAction(PGRendererMethod pGRendererMethod) {
        if (pGRendererMethod != null && this.mRendererPointer != 0) {
            if (this.method != pGRendererMethod) {
                this.method = pGRendererMethod;
                pGRendererMethod.setScreenSize(true, this.width, this.height);
                this.method.setFrameRect(this.frameRect);
            }
            if (this.needRefreshMethod) {
                this.method.resetRenderMethod();
                this.needRefreshMethod = false;
            }
            pGRendererMethod.setRendererPointer(this.mRendererPointer);
            SdkLog.c(TAG, "renderAction requestRender");
            requestRender();
            return;
        }
        this.method = null;
    }

    public void setFrameRect(Rect rect) {
        this.frameRect = rect;
        PGRendererMethod pGRendererMethod = this.method;
        if (pGRendererMethod != null) {
            pGRendererMethod.setFrameRect(rect);
        }
    }

    public void setListener(PGGLListener pGGLListener) {
        this.listener = pGGLListener;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.method = null;
        this.needRefreshMethod = true;
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    @TargetApi(14)
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.method = null;
        this.needRefreshMethod = true;
        super.surfaceDestroyed(surfaceHolder);
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public PGGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRendererPointer = 0L;
        this.method = null;
        this.state = 0;
        this.needReload = false;
        this.sdkLock = new byte[0];
        this.fps = 0;
        this.fpsCount = 0;
        this.startTime = 0L;
        this.needRefreshMethod = false;
        this.listener = null;
        this.surfaceTextureName = -1;
        this.mIsInRenderAction = new AtomicBoolean(false);
        this.mSetReleaseTexture = new AtomicBoolean(false);
        this.textureLock = new byte[0];
        init();
    }
}
