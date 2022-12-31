package us.pinguo.repository2020.database.sticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerRenderData.kt */
/* loaded from: classes6.dex */
public final class StickerBeauty implements NoProguard {
    private final StickerBeautyAndroid Android;

    public StickerBeauty(StickerBeautyAndroid Android) {
        s.h(Android, "Android");
        this.Android = Android;
    }

    public static /* synthetic */ StickerBeauty copy$default(StickerBeauty stickerBeauty, StickerBeautyAndroid stickerBeautyAndroid, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            stickerBeautyAndroid = stickerBeauty.Android;
        }
        return stickerBeauty.copy(stickerBeautyAndroid);
    }

    public final StickerBeautyAndroid component1() {
        return this.Android;
    }

    public final StickerBeauty copy(StickerBeautyAndroid Android) {
        s.h(Android, "Android");
        return new StickerBeauty(Android);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StickerBeauty) && s.c(this.Android, ((StickerBeauty) obj).Android);
    }

    public final StickerBeautyAndroid getAndroid() {
        return this.Android;
    }

    public int hashCode() {
        return this.Android.hashCode();
    }

    public String toString() {
        return "StickerBeauty(Android=" + this.Android + ')';
    }
}
