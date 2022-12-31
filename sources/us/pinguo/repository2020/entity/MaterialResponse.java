package us.pinguo.repository2020.entity;

import com.pinguo.camera360.abtest.Plan;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.repository2020.entity.Material;
/* compiled from: Material.kt */
/* loaded from: classes6.dex */
public final class MaterialResponse<T extends Material> implements NoProguard {
    private final Plan icon_ab;
    private final Integer interval;
    private final List<String> layouts;
    private final String locale;
    private List<T> packages;
    private List<T> suites;
    private final Plan suites_ab_sort;
    private final Integer version;

    public MaterialResponse(String str, Integer num, List<T> list, List<T> list2, List<String> list3, Plan plan, Plan plan2, Integer num2) {
        this.locale = str;
        this.interval = num;
        this.packages = list;
        this.suites = list2;
        this.layouts = list3;
        this.suites_ab_sort = plan;
        this.icon_ab = plan2;
        this.version = num2;
    }

    public final String component1() {
        return this.locale;
    }

    public final Integer component2() {
        return this.interval;
    }

    public final List<T> component3() {
        return this.packages;
    }

    public final List<T> component4() {
        return this.suites;
    }

    public final List<String> component5() {
        return this.layouts;
    }

    public final Plan component6() {
        return this.suites_ab_sort;
    }

    public final Plan component7() {
        return this.icon_ab;
    }

    public final Integer component8() {
        return this.version;
    }

    public final MaterialResponse<T> copy(String str, Integer num, List<T> list, List<T> list2, List<String> list3, Plan plan, Plan plan2, Integer num2) {
        return new MaterialResponse<>(str, num, list, list2, list3, plan, plan2, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MaterialResponse) {
            MaterialResponse materialResponse = (MaterialResponse) obj;
            return s.c(this.locale, materialResponse.locale) && s.c(this.interval, materialResponse.interval) && s.c(this.packages, materialResponse.packages) && s.c(this.suites, materialResponse.suites) && s.c(this.layouts, materialResponse.layouts) && s.c(this.suites_ab_sort, materialResponse.suites_ab_sort) && s.c(this.icon_ab, materialResponse.icon_ab) && s.c(this.version, materialResponse.version);
        }
        return false;
    }

    public final Plan getIcon_ab() {
        return this.icon_ab;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    public final List<String> getLayouts() {
        return this.layouts;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final List<T> getPackages() {
        return this.packages;
    }

    public final List<T> getSuites() {
        return this.suites;
    }

    public final Plan getSuites_ab_sort() {
        return this.suites_ab_sort;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.locale;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.interval;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<T> list = this.packages;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<T> list2 = this.suites;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.layouts;
        int hashCode5 = (hashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Plan plan = this.suites_ab_sort;
        int hashCode6 = (hashCode5 + (plan == null ? 0 : plan.hashCode())) * 31;
        Plan plan2 = this.icon_ab;
        int hashCode7 = (hashCode6 + (plan2 == null ? 0 : plan2.hashCode())) * 31;
        Integer num2 = this.version;
        return hashCode7 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setPackages(List<T> list) {
        this.packages = list;
    }

    public final void setSuites(List<T> list) {
        this.suites = list;
    }

    public String toString() {
        return "MaterialResponse(locale=" + ((Object) this.locale) + ", interval=" + this.interval + ", packages=" + this.packages + ", suites=" + this.suites + ", layouts=" + this.layouts + ", suites_ab_sort=" + this.suites_ab_sort + ", icon_ab=" + this.icon_ab + ", version=" + this.version + ')';
    }
}
