package us.pinguo.androidsdk;

import android.content.Context;
/* loaded from: classes3.dex */
public class RenderPointerManager {
    static ThreadLocal<PGImageSDKPointer> pointer = new ThreadLocal<>();
    private static boolean debug = false;

    /* loaded from: classes3.dex */
    public static final class PGImageSDKPointer {
        private long mRendererPointer = 0;
        private long makeupPointer = 0;
        private String threadGroupName;
        private String threadName;

        public void destroyPointer() {
            long j2 = this.makeupPointer;
            if (j2 != 0) {
                PGNativeMethod.makeupSdkDestroy(j2);
                this.makeupPointer = 0L;
            }
            long j3 = this.mRendererPointer;
            if (j3 != 0) {
                PGNativeMethod.destroyAndroidSDK(j3);
                this.mRendererPointer = 0L;
            }
            RenderPointerManager.pointer.set(null);
        }

        protected void finalize() throws Throwable {
            if (RenderPointerManager.debug) {
                if (this.makeupPointer == 0) {
                    if (this.mRendererPointer != 0) {
                        throw new IllegalStateException("mRendererPointer not destroy before thread exit, point is make by Thread:" + this.threadName + "  and Thread Group Name:" + this.threadGroupName);
                    }
                } else {
                    throw new IllegalStateException("makeupPointer not destroy before thread exit, point is make by Thread:" + this.threadName + "  and Thread Group Name:" + this.threadGroupName);
                }
            }
            super.finalize();
        }

        public long getMakeupPointer() {
            long j2 = this.makeupPointer;
            if (j2 != 0) {
                return j2;
            }
            throw new IllegalStateException("must init first");
        }

        public long getRendererPointer() {
            long j2 = this.mRendererPointer;
            if (j2 != 0) {
                return j2;
            }
            throw new IllegalStateException("must init first");
        }

        public long initMakeupPointer() {
            if (this.mRendererPointer != 0) {
                if (this.makeupPointer == 0) {
                    this.makeupPointer = PGNativeMethod.makeupSdkInit();
                }
                return this.mRendererPointer;
            }
            throw new IllegalStateException("mRendererPointer must init first");
        }

        public boolean initRenderPointer(String str, Context context, byte[] bArr) {
            if ((str != null && context != null) || this.mRendererPointer != 0) {
                long j2 = this.mRendererPointer;
                if (j2 == 0) {
                    this.mRendererPointer = PGNativeMethod.createAndroidSDK(str, context, bArr);
                    if (RenderPointerManager.debug) {
                        this.threadName = Thread.currentThread().getName();
                        this.threadGroupName = Thread.currentThread().getThreadGroup().getName();
                        return true;
                    }
                    return true;
                }
                return PGNativeMethod.loadResource(j2, bArr);
            }
            throw new IllegalStateException("only shader is input ， but point not initialize");
        }

        public boolean isInitedRendererPointer() {
            return this.mRendererPointer != 0;
        }
    }

    private RenderPointerManager() {
    }

    public static PGImageSDKPointer getCurrentThreadPointer() {
        if (pointer.get() == null) {
            pointer.set(new PGImageSDKPointer());
        }
        return pointer.get();
    }

    public static void setDebugModel(boolean z) {
        debug = z;
    }
}
