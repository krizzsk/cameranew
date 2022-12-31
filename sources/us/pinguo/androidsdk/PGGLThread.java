package us.pinguo.androidsdk;
/* loaded from: classes3.dex */
public class PGGLThread {
    private PGImageSDK imageSDK = null;
    private Runnable mAction = new Runnable() { // from class: us.pinguo.androidsdk.PGGLThread.1
        @Override // java.lang.Runnable
        public void run() {
            if (PGGLThread.this.imageSDK == null || !PGGLThread.this.imageSDK.createEGLDisplay()) {
                if (PGGLThread.this.imageSDK != null) {
                    synchronized (PGGLThread.this.imageSDK.getRenderActionLock()) {
                        PGGLThread.this.imageSDK.getRenderActionLock().notify();
                    }
                    return;
                }
                return;
            }
            synchronized (PGGLThread.this.imageSDK.getRenderActionLock()) {
                if (PGGLThread.this.imageSDK.getSDKStatus() == 268435459) {
                    PGGLThread.this.imageSDK.create();
                    PGGLThread.this.imageSDK.setSDKStatus(PGImageSDK.SDK_STATUS_RELOAD);
                } else {
                    PGGLThread.this.imageSDK.create();
                }
                while (true) {
                    try {
                        PGGLThread.this.imageSDK.getRenderActionLock().notify();
                        PGGLThread.this.imageSDK.getRenderActionLock().wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    PGGLThread.this.mRunningFlag = true;
                    if (PGGLThread.this.imageSDK.getSDKStatus() == 268435458) {
                        PGGLThread.this.imageSDK.destroy();
                    } else {
                        if (PGGLThread.this.imageSDK.getSDKStatus() != 268435459) {
                            if (PGGLThread.this.imageSDK.getRenderMethod() != null) {
                                PGGLThread.this.imageSDK.getRenderMethod().rendererAction();
                            }
                        } else {
                            PGGLThread.this.imageSDK.setResourceStatus(PGNativeMethod.loadResource(PGGLThread.this.imageSDK.getRenderPointer(), PGGLThread.this.imageSDK.getResource()));
                        }
                        PGGLThread.this.mRunningFlag = false;
                        PGGLThread.this.imageSDK.getRenderActionLock().notify();
                    }
                }
            }
            PGGLThread.this.imageSDK.releaseEGLDisplay();
            System.gc();
        }
    };
    private volatile boolean mRunningFlag;

    public boolean isBusyRunning() {
        return this.mRunningFlag;
    }

    public void run() {
        PGThreadPool.getInstance().execute(this.mAction);
    }

    public void setImageSDK(PGImageSDK pGImageSDK) {
        this.imageSDK = pGImageSDK;
    }
}
