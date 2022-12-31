package us.pinguo.repository2020.database.sticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerRenderData.kt */
/* loaded from: classes6.dex */
public final class StickerBeautyAndroid implements NoProguard {
    @com.google.gson.s.c("beatyMakeup2")
    private final String beautyMakeup2;
    private final StickerBeautyAndroidControl control;
    private final StickerBeautyAndroidCustom custom;
    private final boolean enable;
    private final String pid;
    private final String skinShapes;

    public StickerBeautyAndroid(String pid, boolean z, StickerBeautyAndroidCustom custom, StickerBeautyAndroidControl control, String str, String str2) {
        s.h(pid, "pid");
        s.h(custom, "custom");
        s.h(control, "control");
        this.pid = pid;
        this.enable = z;
        this.custom = custom;
        this.control = control;
        this.beautyMakeup2 = str;
        this.skinShapes = str2;
    }

    public static /* synthetic */ StickerBeautyAndroid copy$default(StickerBeautyAndroid stickerBeautyAndroid, String str, boolean z, StickerBeautyAndroidCustom stickerBeautyAndroidCustom, StickerBeautyAndroidControl stickerBeautyAndroidControl, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stickerBeautyAndroid.pid;
        }
        if ((i2 & 2) != 0) {
            z = stickerBeautyAndroid.enable;
        }
        boolean z2 = z;
        if ((i2 & 4) != 0) {
            stickerBeautyAndroidCustom = stickerBeautyAndroid.custom;
        }
        StickerBeautyAndroidCustom stickerBeautyAndroidCustom2 = stickerBeautyAndroidCustom;
        if ((i2 & 8) != 0) {
            stickerBeautyAndroidControl = stickerBeautyAndroid.control;
        }
        StickerBeautyAndroidControl stickerBeautyAndroidControl2 = stickerBeautyAndroidControl;
        if ((i2 & 16) != 0) {
            str2 = stickerBeautyAndroid.beautyMakeup2;
        }
        String str4 = str2;
        if ((i2 & 32) != 0) {
            str3 = stickerBeautyAndroid.skinShapes;
        }
        return stickerBeautyAndroid.copy(str, z2, stickerBeautyAndroidCustom2, stickerBeautyAndroidControl2, str4, str3);
    }

    public final String component1() {
        return this.pid;
    }

    public final boolean component2() {
        return this.enable;
    }

    public final StickerBeautyAndroidCustom component3() {
        return this.custom;
    }

    public final StickerBeautyAndroidControl component4() {
        return this.control;
    }

    public final String component5() {
        return this.beautyMakeup2;
    }

    public final String component6() {
        return this.skinShapes;
    }

    public final StickerBeautyAndroid copy(String pid, boolean z, StickerBeautyAndroidCustom custom, StickerBeautyAndroidControl control, String str, String str2) {
        s.h(pid, "pid");
        s.h(custom, "custom");
        s.h(control, "control");
        return new StickerBeautyAndroid(pid, z, custom, control, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerBeautyAndroid) {
            StickerBeautyAndroid stickerBeautyAndroid = (StickerBeautyAndroid) obj;
            return s.c(this.pid, stickerBeautyAndroid.pid) && this.enable == stickerBeautyAndroid.enable && s.c(this.custom, stickerBeautyAndroid.custom) && s.c(this.control, stickerBeautyAndroid.control) && s.c(this.beautyMakeup2, stickerBeautyAndroid.beautyMakeup2) && s.c(this.skinShapes, stickerBeautyAndroid.skinShapes);
        }
        return false;
    }

    public final String getBeautyMakeup2() {
        return this.beautyMakeup2;
    }

    public final StickerBeautyAndroidControl getControl() {
        return this.control;
    }

    public final StickerBeautyAndroidCustom getCustom() {
        return this.custom;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getPid() {
        return this.pid;
    }

    public final String getSkinShapes() {
        return this.skinShapes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.pid.hashCode() * 31;
        boolean z = this.enable;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int hashCode2 = (((((hashCode + i2) * 31) + this.custom.hashCode()) * 31) + this.control.hashCode()) * 31;
        String str = this.beautyMakeup2;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.skinShapes;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "StickerBeautyAndroid(pid=" + this.pid + ", enable=" + this.enable + ", custom=" + this.custom + ", control=" + this.control + ", beautyMakeup2=" + ((Object) this.beautyMakeup2) + ", skinShapes=" + ((Object) this.skinShapes) + ')';
    }
}
