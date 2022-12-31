package com.google.androidgamesdk;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
/* loaded from: classes2.dex */
public class SwappyDisplayManager implements DisplayManager.DisplayListener {
    private long a;
    private WindowManager b;
    private Display.Mode c;

    private boolean a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return i2 == 29 && Build.VERSION.PREVIEW_SDK_INT == 0;
        }
        return true;
    }

    @TargetApi(23)
    private boolean b(Display.Mode mode) {
        return mode.getPhysicalHeight() == this.c.getPhysicalHeight() && mode.getPhysicalWidth() == this.c.getPhysicalWidth();
    }

    private void c(Display display) {
        Display.Mode[] supportedModes = display.getSupportedModes();
        int i2 = 0;
        for (Display.Mode mode : supportedModes) {
            if (b(mode)) {
                i2++;
            }
        }
        long[] jArr = new long[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < supportedModes.length; i4++) {
            if (b(supportedModes[i4])) {
                jArr[i3] = 1.0E9f / supportedModes[i4].getRefreshRate();
                iArr[i3] = supportedModes[i4].getModeId();
                i3++;
            }
        }
        nSetSupportedRefreshRates(this.a, jArr, iArr);
    }

    private native void nOnRefreshRateChanged(long j2, long j3, long j4, long j5);

    private native void nSetSupportedRefreshRates(long j2, long[] jArr, int[] iArr);

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i2) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i2) {
        synchronized (this) {
            Display defaultDisplay = this.b.getDefaultDisplay();
            float refreshRate = defaultDisplay.getRefreshRate();
            Display.Mode mode = defaultDisplay.getMode();
            boolean z = true;
            boolean z2 = (mode.getPhysicalWidth() != this.c.getPhysicalWidth()) | (mode.getPhysicalHeight() != this.c.getPhysicalHeight());
            if (refreshRate == this.c.getRefreshRate()) {
                z = false;
            }
            this.c = mode;
            if (z2) {
                c(defaultDisplay);
            }
            if (a() && z) {
                long j2 = 1.0E9f / refreshRate;
                nOnRefreshRateChanged(this.a, j2, defaultDisplay.getAppVsyncOffsetNanos(), j2 - (this.b.getDefaultDisplay().getPresentationDeadlineNanos() - 1000000));
            }
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i2) {
    }
}
