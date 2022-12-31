package us.pinguo.repository2020.database.staticsticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StaticStickerDetail.kt */
/* loaded from: classes6.dex */
public final class StaticStickerDetail implements NoProguard {
    private final Float alpha;
    private final StaticStickerDetail[] children;
    private final Integer gesturePenetrate;
    private final String img;
    private final Location location;
    private final String name;
    private final String overlayMode;
    private final String[] pids;
    private final String sid;
    private final String[] tags;

    public StaticStickerDetail(String str, String str2, String[] strArr, String str3, Integer num, Location location, String str4, Float f2, String[] strArr2, StaticStickerDetail[] staticStickerDetailArr) {
        this.sid = str;
        this.name = str2;
        this.pids = strArr;
        this.overlayMode = str3;
        this.gesturePenetrate = num;
        this.location = location;
        this.img = str4;
        this.alpha = f2;
        this.tags = strArr2;
        this.children = staticStickerDetailArr;
    }

    public final String component1() {
        return this.sid;
    }

    public final StaticStickerDetail[] component10() {
        return this.children;
    }

    public final String component2() {
        return this.name;
    }

    public final String[] component3() {
        return this.pids;
    }

    public final String component4() {
        return this.overlayMode;
    }

    public final Integer component5() {
        return this.gesturePenetrate;
    }

    public final Location component6() {
        return this.location;
    }

    public final String component7() {
        return this.img;
    }

    public final Float component8() {
        return this.alpha;
    }

    public final String[] component9() {
        return this.tags;
    }

    public final StaticStickerDetail copy(String str, String str2, String[] strArr, String str3, Integer num, Location location, String str4, Float f2, String[] strArr2, StaticStickerDetail[] staticStickerDetailArr) {
        return new StaticStickerDetail(str, str2, strArr, str3, num, location, str4, f2, strArr2, staticStickerDetailArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StaticStickerDetail.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.staticsticker.StaticStickerDetail");
            StaticStickerDetail staticStickerDetail = (StaticStickerDetail) obj;
            if (s.c(this.sid, staticStickerDetail.sid) && s.c(this.name, staticStickerDetail.name)) {
                String[] strArr = this.pids;
                if (strArr != null) {
                    String[] strArr2 = staticStickerDetail.pids;
                    if (strArr2 == null || !Arrays.equals(strArr, strArr2)) {
                        return false;
                    }
                } else if (staticStickerDetail.pids != null) {
                    return false;
                }
                if (s.c(this.overlayMode, staticStickerDetail.overlayMode) && s.c(this.gesturePenetrate, staticStickerDetail.gesturePenetrate) && s.c(this.location, staticStickerDetail.location) && s.c(this.img, staticStickerDetail.img) && s.b(this.alpha, staticStickerDetail.alpha)) {
                    String[] strArr3 = this.tags;
                    if (strArr3 != null) {
                        String[] strArr4 = staticStickerDetail.tags;
                        if (strArr4 == null || !Arrays.equals(strArr3, strArr4)) {
                            return false;
                        }
                    } else if (staticStickerDetail.tags != null) {
                        return false;
                    }
                    StaticStickerDetail[] staticStickerDetailArr = this.children;
                    if (staticStickerDetailArr != null) {
                        StaticStickerDetail[] staticStickerDetailArr2 = staticStickerDetail.children;
                        if (staticStickerDetailArr2 == null || !Arrays.equals(staticStickerDetailArr, staticStickerDetailArr2)) {
                            return false;
                        }
                    } else if (staticStickerDetail.children != null) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final Float getAlpha() {
        return this.alpha;
    }

    public final StaticStickerDetail[] getChildren() {
        return this.children;
    }

    public final Integer getGesturePenetrate() {
        return this.gesturePenetrate;
    }

    public final String getImg() {
        return this.img;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOverlayMode() {
        return this.overlayMode;
    }

    public final String[] getPids() {
        return this.pids;
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
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String[] strArr = this.pids;
        int hashCode3 = (hashCode2 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String str3 = this.overlayMode;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.gesturePenetrate;
        int intValue = (hashCode4 + (num == null ? 0 : num.intValue())) * 31;
        Location location = this.location;
        int hashCode5 = (intValue + (location == null ? 0 : location.hashCode())) * 31;
        String str4 = this.img;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Float f2 = this.alpha;
        int hashCode7 = (hashCode6 + (f2 == null ? 0 : f2.hashCode())) * 31;
        String[] strArr2 = this.tags;
        int hashCode8 = (hashCode7 + (strArr2 == null ? 0 : Arrays.hashCode(strArr2))) * 31;
        StaticStickerDetail[] staticStickerDetailArr = this.children;
        return hashCode8 + (staticStickerDetailArr != null ? Arrays.hashCode(staticStickerDetailArr) : 0);
    }

    public String toString() {
        return "StaticStickerDetail(sid=" + ((Object) this.sid) + ", name=" + ((Object) this.name) + ", pids=" + Arrays.toString(this.pids) + ", overlayMode=" + ((Object) this.overlayMode) + ", gesturePenetrate=" + this.gesturePenetrate + ", location=" + this.location + ", img=" + ((Object) this.img) + ", alpha=" + this.alpha + ", tags=" + Arrays.toString(this.tags) + ", children=" + Arrays.toString(this.children) + ')';
    }
}
