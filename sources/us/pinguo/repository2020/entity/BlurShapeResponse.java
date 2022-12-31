package us.pinguo.repository2020.entity;

import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BlurResponse.kt */
/* loaded from: classes6.dex */
public final class BlurShapeResponse implements NoProguard {
    private final Integer interval;
    private final String locale;
    private List<BackgroundBlurShape> packages;

    public BlurShapeResponse(String str, Integer num, List<BackgroundBlurShape> list) {
        this.locale = str;
        this.interval = num;
        this.packages = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlurShapeResponse copy$default(BlurShapeResponse blurShapeResponse, String str, Integer num, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = blurShapeResponse.locale;
        }
        if ((i2 & 2) != 0) {
            num = blurShapeResponse.interval;
        }
        if ((i2 & 4) != 0) {
            list = blurShapeResponse.packages;
        }
        return blurShapeResponse.copy(str, num, list);
    }

    public final String component1() {
        return this.locale;
    }

    public final Integer component2() {
        return this.interval;
    }

    public final List<BackgroundBlurShape> component3() {
        return this.packages;
    }

    public final BlurShapeResponse copy(String str, Integer num, List<BackgroundBlurShape> list) {
        return new BlurShapeResponse(str, num, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlurShapeResponse) {
            BlurShapeResponse blurShapeResponse = (BlurShapeResponse) obj;
            return s.c(this.locale, blurShapeResponse.locale) && s.c(this.interval, blurShapeResponse.interval) && s.c(this.packages, blurShapeResponse.packages);
        }
        return false;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final List<BackgroundBlurShape> getPackages() {
        return this.packages;
    }

    public int hashCode() {
        String str = this.locale;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.interval;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<BackgroundBlurShape> list = this.packages;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setPackages(List<BackgroundBlurShape> list) {
        this.packages = list;
    }

    public String toString() {
        return "BlurShapeResponse(locale=" + ((Object) this.locale) + ", interval=" + this.interval + ", packages=" + this.packages + ')';
    }
}
