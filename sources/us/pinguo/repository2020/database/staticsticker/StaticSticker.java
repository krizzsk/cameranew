package us.pinguo.repository2020.database.staticsticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.repository2020.entity.Material;
/* compiled from: StaticSticker.kt */
/* loaded from: classes6.dex */
public final class StaticSticker extends Material implements NoProguard {
    private final String display_md5;
    private final String sid;
    private final String[] tags;

    public /* synthetic */ StaticSticker(String str, String str2, String str3, String str4, String[] strArr, String str5, String str6, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : str, str2, str3, str4, strArr, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StaticSticker.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.staticsticker.StaticSticker");
            StaticSticker staticSticker = (StaticSticker) obj;
            if (s.c(this.sid, staticSticker.sid) && s.c(getName(), staticSticker.getName()) && s.c(getIcon(), staticSticker.getIcon())) {
                String[] strArr = this.tags;
                if (strArr != null) {
                    String[] strArr2 = staticSticker.tags;
                    if (strArr2 == null || !Arrays.equals(strArr, strArr2)) {
                        return false;
                    }
                } else if (staticSticker.tags != null) {
                    return false;
                }
                return s.c(this.display_md5, staticSticker.display_md5) && s.c(getDown_url(), staticSticker.getDown_url());
            }
            return false;
        }
        return false;
    }

    public final String getDisplay_md5() {
        return this.display_md5;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String[] getTags() {
        return this.tags;
    }

    public int hashCode() {
        String str = this.sid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String name = getName();
        int hashCode2 = (hashCode + (name == null ? 0 : name.hashCode())) * 31;
        String icon = getIcon();
        int hashCode3 = (hashCode2 + (icon == null ? 0 : icon.hashCode())) * 31;
        String[] strArr = this.tags;
        int hashCode4 = (hashCode3 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String str2 = this.display_md5;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String down_url = getDown_url();
        return hashCode5 + (down_url != null ? down_url.hashCode() : 0);
    }

    public StaticSticker(String str, String str2, String str3, String str4, String[] strArr, String str5, String str6) {
        super(str, str4, str3, str6, 0L, 0L, 0);
        this.sid = str2;
        this.tags = strArr;
        this.display_md5 = str5;
    }
}
