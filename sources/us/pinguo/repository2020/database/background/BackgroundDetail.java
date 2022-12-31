package us.pinguo.repository2020.database.background;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDetail.kt */
/* loaded from: classes6.dex */
public final class BackgroundDetail implements NoProguard {
    private final CanvasSize canvasSize;
    private final Cutout cutout;
    private final DisplayRect displayRect;
    private final String[] layerZipPath;
    private final int supportedHue;

    public BackgroundDetail(int i2, CanvasSize canvasSize, DisplayRect displayRect, Cutout cutout, String[] layerZipPath) {
        s.h(canvasSize, "canvasSize");
        s.h(displayRect, "displayRect");
        s.h(cutout, "cutout");
        s.h(layerZipPath, "layerZipPath");
        this.supportedHue = i2;
        this.canvasSize = canvasSize;
        this.displayRect = displayRect;
        this.cutout = cutout;
        this.layerZipPath = layerZipPath;
    }

    public static /* synthetic */ BackgroundDetail copy$default(BackgroundDetail backgroundDetail, int i2, CanvasSize canvasSize, DisplayRect displayRect, Cutout cutout, String[] strArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = backgroundDetail.supportedHue;
        }
        if ((i3 & 2) != 0) {
            canvasSize = backgroundDetail.canvasSize;
        }
        CanvasSize canvasSize2 = canvasSize;
        if ((i3 & 4) != 0) {
            displayRect = backgroundDetail.displayRect;
        }
        DisplayRect displayRect2 = displayRect;
        if ((i3 & 8) != 0) {
            cutout = backgroundDetail.cutout;
        }
        Cutout cutout2 = cutout;
        if ((i3 & 16) != 0) {
            strArr = backgroundDetail.layerZipPath;
        }
        return backgroundDetail.copy(i2, canvasSize2, displayRect2, cutout2, strArr);
    }

    public final int component1() {
        return this.supportedHue;
    }

    public final CanvasSize component2() {
        return this.canvasSize;
    }

    public final DisplayRect component3() {
        return this.displayRect;
    }

    public final Cutout component4() {
        return this.cutout;
    }

    public final String[] component5() {
        return this.layerZipPath;
    }

    public final BackgroundDetail copy(int i2, CanvasSize canvasSize, DisplayRect displayRect, Cutout cutout, String[] layerZipPath) {
        s.h(canvasSize, "canvasSize");
        s.h(displayRect, "displayRect");
        s.h(cutout, "cutout");
        s.h(layerZipPath, "layerZipPath");
        return new BackgroundDetail(i2, canvasSize, displayRect, cutout, layerZipPath);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(BackgroundDetail.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.background.BackgroundDetail");
            BackgroundDetail backgroundDetail = (BackgroundDetail) obj;
            return this.supportedHue == backgroundDetail.supportedHue && s.c(this.canvasSize, backgroundDetail.canvasSize) && s.c(this.displayRect, backgroundDetail.displayRect) && s.c(this.cutout, backgroundDetail.cutout) && Arrays.equals(this.layerZipPath, backgroundDetail.layerZipPath);
        }
        return false;
    }

    public final CanvasSize getCanvasSize() {
        return this.canvasSize;
    }

    public final Cutout getCutout() {
        return this.cutout;
    }

    public final DisplayRect getDisplayRect() {
        return this.displayRect;
    }

    public final String[] getLayerZipPath() {
        return this.layerZipPath;
    }

    public final int getSupportedHue() {
        return this.supportedHue;
    }

    public int hashCode() {
        return (((((((this.supportedHue * 31) + this.canvasSize.hashCode()) * 31) + this.displayRect.hashCode()) * 31) + this.cutout.hashCode()) * 31) + Arrays.hashCode(this.layerZipPath);
    }

    public String toString() {
        return "BackgroundDetail(supportedHue=" + this.supportedHue + ", canvasSize=" + this.canvasSize + ", displayRect=" + this.displayRect + ", cutout=" + this.cutout + ", layerZipPath=" + Arrays.toString(this.layerZipPath) + ')';
    }
}
