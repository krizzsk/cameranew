package us.pinguo.repository2020.database.sticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerRenderData.kt */
/* loaded from: classes6.dex */
public final class StickerBeautyAndroidControl implements NoProguard {
    private final String faceType;
    private final boolean resetFaceBeautyValue2;
    private final boolean resetFaceShapeValue2;
    private final boolean showFaceBeautySlider2;
    private final boolean showFaceShapeSlider2;

    public StickerBeautyAndroidControl(String faceType, boolean z, boolean z2, boolean z3, boolean z4) {
        s.h(faceType, "faceType");
        this.faceType = faceType;
        this.showFaceShapeSlider2 = z;
        this.showFaceBeautySlider2 = z2;
        this.resetFaceShapeValue2 = z3;
        this.resetFaceBeautyValue2 = z4;
    }

    public static /* synthetic */ StickerBeautyAndroidControl copy$default(StickerBeautyAndroidControl stickerBeautyAndroidControl, String str, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stickerBeautyAndroidControl.faceType;
        }
        if ((i2 & 2) != 0) {
            z = stickerBeautyAndroidControl.showFaceShapeSlider2;
        }
        boolean z5 = z;
        if ((i2 & 4) != 0) {
            z2 = stickerBeautyAndroidControl.showFaceBeautySlider2;
        }
        boolean z6 = z2;
        if ((i2 & 8) != 0) {
            z3 = stickerBeautyAndroidControl.resetFaceShapeValue2;
        }
        boolean z7 = z3;
        if ((i2 & 16) != 0) {
            z4 = stickerBeautyAndroidControl.resetFaceBeautyValue2;
        }
        return stickerBeautyAndroidControl.copy(str, z5, z6, z7, z4);
    }

    public final String component1() {
        return this.faceType;
    }

    public final boolean component2() {
        return this.showFaceShapeSlider2;
    }

    public final boolean component3() {
        return this.showFaceBeautySlider2;
    }

    public final boolean component4() {
        return this.resetFaceShapeValue2;
    }

    public final boolean component5() {
        return this.resetFaceBeautyValue2;
    }

    public final StickerBeautyAndroidControl copy(String faceType, boolean z, boolean z2, boolean z3, boolean z4) {
        s.h(faceType, "faceType");
        return new StickerBeautyAndroidControl(faceType, z, z2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerBeautyAndroidControl) {
            StickerBeautyAndroidControl stickerBeautyAndroidControl = (StickerBeautyAndroidControl) obj;
            return s.c(this.faceType, stickerBeautyAndroidControl.faceType) && this.showFaceShapeSlider2 == stickerBeautyAndroidControl.showFaceShapeSlider2 && this.showFaceBeautySlider2 == stickerBeautyAndroidControl.showFaceBeautySlider2 && this.resetFaceShapeValue2 == stickerBeautyAndroidControl.resetFaceShapeValue2 && this.resetFaceBeautyValue2 == stickerBeautyAndroidControl.resetFaceBeautyValue2;
        }
        return false;
    }

    public final String getFaceType() {
        return this.faceType;
    }

    public final boolean getResetFaceBeautyValue2() {
        return this.resetFaceBeautyValue2;
    }

    public final boolean getResetFaceShapeValue2() {
        return this.resetFaceShapeValue2;
    }

    public final boolean getShowFaceBeautySlider2() {
        return this.showFaceBeautySlider2;
    }

    public final boolean getShowFaceShapeSlider2() {
        return this.showFaceShapeSlider2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.faceType.hashCode() * 31;
        boolean z = this.showFaceShapeSlider2;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.showFaceBeautySlider2;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.resetFaceShapeValue2;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z4 = this.resetFaceBeautyValue2;
        return i7 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public String toString() {
        return "StickerBeautyAndroidControl(faceType=" + this.faceType + ", showFaceShapeSlider2=" + this.showFaceShapeSlider2 + ", showFaceBeautySlider2=" + this.showFaceBeautySlider2 + ", resetFaceShapeValue2=" + this.resetFaceShapeValue2 + ", resetFaceBeautyValue2=" + this.resetFaceBeautyValue2 + ')';
    }
}
