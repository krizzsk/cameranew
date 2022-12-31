package us.pinguo.repository2020.database.sticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerRenderData.kt */
/* loaded from: classes6.dex */
public final class StickerUnity implements NoProguard {
    private final String folder;
    private final String params;

    public StickerUnity(String folder, String params) {
        s.h(folder, "folder");
        s.h(params, "params");
        this.folder = folder;
        this.params = params;
    }

    public static /* synthetic */ StickerUnity copy$default(StickerUnity stickerUnity, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stickerUnity.folder;
        }
        if ((i2 & 2) != 0) {
            str2 = stickerUnity.params;
        }
        return stickerUnity.copy(str, str2);
    }

    public final String component1() {
        return this.folder;
    }

    public final String component2() {
        return this.params;
    }

    public final StickerUnity copy(String folder, String params) {
        s.h(folder, "folder");
        s.h(params, "params");
        return new StickerUnity(folder, params);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerUnity) {
            StickerUnity stickerUnity = (StickerUnity) obj;
            return s.c(this.folder, stickerUnity.folder) && s.c(this.params, stickerUnity.params);
        }
        return false;
    }

    public final String getFolder() {
        return this.folder;
    }

    public final String getParams() {
        return this.params;
    }

    public int hashCode() {
        return (this.folder.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        return "StickerUnity(folder=" + this.folder + ", params=" + this.params + ')';
    }
}
