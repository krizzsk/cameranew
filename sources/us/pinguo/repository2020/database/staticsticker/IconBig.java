package us.pinguo.repository2020.database.staticsticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: ShopDetail.kt */
/* loaded from: classes6.dex */
public final class IconBig implements NoProguard {
    private final Integer height;
    private final String img;
    private final Integer width;

    public IconBig(String str, Integer num, Integer num2) {
        this.img = str;
        this.width = num;
        this.height = num2;
    }

    public static /* synthetic */ IconBig copy$default(IconBig iconBig, String str, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = iconBig.img;
        }
        if ((i2 & 2) != 0) {
            num = iconBig.width;
        }
        if ((i2 & 4) != 0) {
            num2 = iconBig.height;
        }
        return iconBig.copy(str, num, num2);
    }

    public final String component1() {
        return this.img;
    }

    public final Integer component2() {
        return this.width;
    }

    public final Integer component3() {
        return this.height;
    }

    public final IconBig copy(String str, Integer num, Integer num2) {
        return new IconBig(str, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IconBig) {
            IconBig iconBig = (IconBig) obj;
            return s.c(this.img, iconBig.img) && s.c(this.width, iconBig.width) && s.c(this.height, iconBig.height);
        }
        return false;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getImg() {
        return this.img;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.img;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.width;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.height;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "IconBig(img=" + ((Object) this.img) + ", width=" + this.width + ", height=" + this.height + ')';
    }
}
