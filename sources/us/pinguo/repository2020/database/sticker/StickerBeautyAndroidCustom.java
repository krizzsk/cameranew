package us.pinguo.repository2020.database.sticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerRenderData.kt */
/* loaded from: classes6.dex */
public final class StickerBeautyAndroidCustom implements NoProguard {
    private final String folder;
    private final String[] makeup;

    public StickerBeautyAndroidCustom(String folder, String[] makeup) {
        s.h(folder, "folder");
        s.h(makeup, "makeup");
        this.folder = folder;
        this.makeup = makeup;
    }

    public static /* synthetic */ StickerBeautyAndroidCustom copy$default(StickerBeautyAndroidCustom stickerBeautyAndroidCustom, String str, String[] strArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stickerBeautyAndroidCustom.folder;
        }
        if ((i2 & 2) != 0) {
            strArr = stickerBeautyAndroidCustom.makeup;
        }
        return stickerBeautyAndroidCustom.copy(str, strArr);
    }

    public final String component1() {
        return this.folder;
    }

    public final String[] component2() {
        return this.makeup;
    }

    public final StickerBeautyAndroidCustom copy(String folder, String[] makeup) {
        s.h(folder, "folder");
        s.h(makeup, "makeup");
        return new StickerBeautyAndroidCustom(folder, makeup);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StickerBeautyAndroidCustom.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.sticker.StickerBeautyAndroidCustom");
            StickerBeautyAndroidCustom stickerBeautyAndroidCustom = (StickerBeautyAndroidCustom) obj;
            return s.c(this.folder, stickerBeautyAndroidCustom.folder) && Arrays.equals(this.makeup, stickerBeautyAndroidCustom.makeup);
        }
        return false;
    }

    public final String getFolder() {
        return this.folder;
    }

    public final String[] getMakeup() {
        return this.makeup;
    }

    public int hashCode() {
        return (this.folder.hashCode() * 31) + Arrays.hashCode(this.makeup);
    }

    public String toString() {
        return "StickerBeautyAndroidCustom(folder=" + this.folder + ", makeup=" + Arrays.toString(this.makeup) + ')';
    }
}
