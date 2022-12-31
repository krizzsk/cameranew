package us.pinguo.camerasdk.exception;

import android.util.AndroidException;
/* loaded from: classes4.dex */
public class PGCameraAccessException extends AndroidException {
    private final int mReason;

    public PGCameraAccessException(int i2) {
        super(getDefaultMessage(i2));
        this.mReason = i2;
    }

    public static String getDefaultMessage(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 8) {
                                return null;
                            }
                            return "Camera permission deny, make sure you have the authority of the camera permission";
                        }
                        return "The system-wide limit for number of open cameras has been reached, and more camera devices cannot be opened until previous instances are closed.";
                    }
                    return "The camera device is in use already";
                }
                return "The camera device is currently in the error state; no further calls to it will succeed.";
            }
            return "The camera device is removable and has been disconnected from the Android device, or the camera service has shut down the connection due to a higher-priority access request for the camera device.";
        }
        return "The camera is disabled due to a device policy, and cannot be opened.";
    }

    public final int getReason() {
        return this.mReason;
    }

    public PGCameraAccessException(int i2, String str) {
        super(str);
        this.mReason = i2;
    }

    public PGCameraAccessException(int i2, String str, Throwable th) {
        super(str, th);
        this.mReason = i2;
    }

    public PGCameraAccessException(int i2, Throwable th) {
        super(getDefaultMessage(i2), th);
        this.mReason = i2;
    }
}
