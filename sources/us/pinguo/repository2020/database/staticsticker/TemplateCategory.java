package us.pinguo.repository2020.database.staticsticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.repository2020.entity.Material;
/* compiled from: StaticSticker.kt */
/* loaded from: classes6.dex */
public final class TemplateCategory extends Material implements NoProguard {
    private final String cid;
    private final String[] tids;

    public TemplateCategory(String str, String str2, String str3, String[] strArr, Long l2, Long l3) {
        super(str, str3, str2, null, l2, l3, 0);
        this.cid = str;
        this.tids = strArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(TemplateCategory.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.staticsticker.TemplateCategory");
            TemplateCategory templateCategory = (TemplateCategory) obj;
            if (s.c(this.cid, templateCategory.cid) && s.c(getName(), templateCategory.getName()) && s.c(getIcon(), templateCategory.getIcon())) {
                String[] strArr = this.tids;
                if (strArr != null) {
                    String[] strArr2 = templateCategory.tids;
                    if (strArr2 == null || !Arrays.equals(strArr, strArr2)) {
                        return false;
                    }
                } else if (templateCategory.tids != null) {
                    return false;
                }
                return s.c(getOnsale_time(), templateCategory.getOnsale_time()) && s.c(getOff_time(), templateCategory.getOff_time());
            }
            return false;
        }
        return false;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String[] getTids() {
        return this.tids;
    }

    public int hashCode() {
        String str = this.cid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String name = getName();
        int hashCode2 = (hashCode + (name == null ? 0 : name.hashCode())) * 31;
        String icon = getIcon();
        int hashCode3 = (hashCode2 + (icon == null ? 0 : icon.hashCode())) * 31;
        String[] strArr = this.tids;
        int hashCode4 = (hashCode3 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        Long onsale_time = getOnsale_time();
        int hashCode5 = (hashCode4 + (onsale_time == null ? 0 : onsale_time.hashCode())) * 31;
        Long off_time = getOff_time();
        return hashCode5 + (off_time != null ? off_time.hashCode() : 0);
    }

    public final boolean isValid(long j2) {
        Long onsale_time = getOnsale_time();
        if (onsale_time == null) {
            return false;
        }
        long longValue = onsale_time.longValue();
        Long off_time = getOff_time();
        if (off_time == null) {
            return false;
        }
        long longValue2 = off_time.longValue();
        if (j2 != 0 && longValue > 0 && longValue2 > 0) {
            long j3 = 1000;
            if (j2 < longValue * j3 || j2 > longValue2 * j3) {
                return false;
            }
        }
        return true;
    }
}
