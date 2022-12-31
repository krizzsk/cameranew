package us.pinguo.repository2020.database.sticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerRenderData.kt */
/* loaded from: classes6.dex */
public final class StickerFilterInner implements NoProguard {
    private final String[] filters;
    private final String folder;

    public StickerFilterInner(String folder, String[] filters) {
        s.h(folder, "folder");
        s.h(filters, "filters");
        this.folder = folder;
        this.filters = filters;
    }

    public static /* synthetic */ StickerFilterInner copy$default(StickerFilterInner stickerFilterInner, String str, String[] strArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stickerFilterInner.folder;
        }
        if ((i2 & 2) != 0) {
            strArr = stickerFilterInner.filters;
        }
        return stickerFilterInner.copy(str, strArr);
    }

    public final String component1() {
        return this.folder;
    }

    public final String[] component2() {
        return this.filters;
    }

    public final StickerFilterInner copy(String folder, String[] filters) {
        s.h(folder, "folder");
        s.h(filters, "filters");
        return new StickerFilterInner(folder, filters);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StickerFilterInner.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.sticker.StickerFilterInner");
            StickerFilterInner stickerFilterInner = (StickerFilterInner) obj;
            return s.c(this.folder, stickerFilterInner.folder) && Arrays.equals(this.filters, stickerFilterInner.filters);
        }
        return false;
    }

    public final String[] getFilters() {
        return this.filters;
    }

    public final String getFolder() {
        return this.folder;
    }

    public int hashCode() {
        return (this.folder.hashCode() * 31) + Arrays.hashCode(this.filters);
    }

    public String toString() {
        return "StickerFilterInner(folder=" + this.folder + ", filters=" + Arrays.toString(this.filters) + ')';
    }
}
