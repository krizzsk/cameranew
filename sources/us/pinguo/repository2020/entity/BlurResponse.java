package us.pinguo.repository2020.entity;

import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BlurResponse.kt */
/* loaded from: classes6.dex */
public final class BlurResponse implements NoProguard {
    private final Integer interval;
    private final String locale;
    private List<BackgroundBlur> packages;

    public BlurResponse(String str, Integer num, List<BackgroundBlur> list) {
        this.locale = str;
        this.interval = num;
        this.packages = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlurResponse copy$default(BlurResponse blurResponse, String str, Integer num, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = blurResponse.locale;
        }
        if ((i2 & 2) != 0) {
            num = blurResponse.interval;
        }
        if ((i2 & 4) != 0) {
            list = blurResponse.packages;
        }
        return blurResponse.copy(str, num, list);
    }

    public final String component1() {
        return this.locale;
    }

    public final Integer component2() {
        return this.interval;
    }

    public final List<BackgroundBlur> component3() {
        return this.packages;
    }

    public final BlurResponse copy(String str, Integer num, List<BackgroundBlur> list) {
        return new BlurResponse(str, num, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlurResponse) {
            BlurResponse blurResponse = (BlurResponse) obj;
            return s.c(this.locale, blurResponse.locale) && s.c(this.interval, blurResponse.interval) && s.c(this.packages, blurResponse.packages);
        }
        return false;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final List<BackgroundBlur> getPackages() {
        return this.packages;
    }

    public int hashCode() {
        String str = this.locale;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.interval;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<BackgroundBlur> list = this.packages;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setPackages(List<BackgroundBlur> list) {
        this.packages = list;
    }

    public String toString() {
        return "BlurResponse(locale=" + ((Object) this.locale) + ", interval=" + this.interval + ", packages=" + this.packages + ')';
    }
}
