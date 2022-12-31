package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: UnityFilterItemTempleIndex.kt */
/* loaded from: classes6.dex */
public final class ContentAlignment {
    private final String center;
    private final Integer fillMode;
    private final String scale;

    public ContentAlignment(String str, Integer num, String str2) {
        this.center = str;
        this.fillMode = num;
        this.scale = str2;
    }

    public static /* synthetic */ ContentAlignment copy$default(ContentAlignment contentAlignment, String str, Integer num, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = contentAlignment.center;
        }
        if ((i2 & 2) != 0) {
            num = contentAlignment.fillMode;
        }
        if ((i2 & 4) != 0) {
            str2 = contentAlignment.scale;
        }
        return contentAlignment.copy(str, num, str2);
    }

    public final String component1() {
        return this.center;
    }

    public final Integer component2() {
        return this.fillMode;
    }

    public final String component3() {
        return this.scale;
    }

    public final ContentAlignment copy(String str, Integer num, String str2) {
        return new ContentAlignment(str, num, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContentAlignment) {
            ContentAlignment contentAlignment = (ContentAlignment) obj;
            return s.c(this.center, contentAlignment.center) && s.c(this.fillMode, contentAlignment.fillMode) && s.c(this.scale, contentAlignment.scale);
        }
        return false;
    }

    public final String getCenter() {
        return this.center;
    }

    public final Integer getFillMode() {
        return this.fillMode;
    }

    public final String getScale() {
        return this.scale;
    }

    public int hashCode() {
        String str = this.center;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.fillMode;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.scale;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ContentAlignment(center=" + ((Object) this.center) + ", fillMode=" + this.fillMode + ", scale=" + ((Object) this.scale) + ')';
    }
}
