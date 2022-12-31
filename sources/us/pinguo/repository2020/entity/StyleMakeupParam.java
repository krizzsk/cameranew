package us.pinguo.repository2020.entity;

import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StyleMakeupParam.kt */
/* loaded from: classes6.dex */
public final class StyleMakeupParam implements NoProguard {
    private String filter;
    private Float filterDefaultValue;
    private Integer filterLayer;
    private String icon;
    private Integer isRenderFilter;
    private Map<String, String>[] items;
    private Float makeupDefaultValue;
    private Float skinWhiteDefaultValue;

    public StyleMakeupParam(String str, Map<String, String>[] mapArr, String str2, Float f2, Float f3, Float f4, Integer num, Integer num2) {
        this.icon = str;
        this.items = mapArr;
        this.filter = str2;
        this.makeupDefaultValue = f2;
        this.filterDefaultValue = f3;
        this.skinWhiteDefaultValue = f4;
        this.filterLayer = num;
        this.isRenderFilter = num2;
    }

    public final String component1() {
        return this.icon;
    }

    public final Map<String, String>[] component2() {
        return this.items;
    }

    public final String component3() {
        return this.filter;
    }

    public final Float component4() {
        return this.makeupDefaultValue;
    }

    public final Float component5() {
        return this.filterDefaultValue;
    }

    public final Float component6() {
        return this.skinWhiteDefaultValue;
    }

    public final Integer component7() {
        return this.filterLayer;
    }

    public final Integer component8() {
        return this.isRenderFilter;
    }

    public final StyleMakeupParam copy(String str, Map<String, String>[] mapArr, String str2, Float f2, Float f3, Float f4, Integer num, Integer num2) {
        return new StyleMakeupParam(str, mapArr, str2, f2, f3, f4, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StyleMakeupParam) {
            StyleMakeupParam styleMakeupParam = (StyleMakeupParam) obj;
            return s.c(this.icon, styleMakeupParam.icon) && s.c(this.items, styleMakeupParam.items) && s.c(this.filter, styleMakeupParam.filter) && s.c(this.makeupDefaultValue, styleMakeupParam.makeupDefaultValue) && s.c(this.filterDefaultValue, styleMakeupParam.filterDefaultValue) && s.c(this.skinWhiteDefaultValue, styleMakeupParam.skinWhiteDefaultValue) && s.c(this.filterLayer, styleMakeupParam.filterLayer) && s.c(this.isRenderFilter, styleMakeupParam.isRenderFilter);
        }
        return false;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final Float getFilterDefaultValue() {
        return this.filterDefaultValue;
    }

    public final Integer getFilterLayer() {
        return this.filterLayer;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Map<String, String>[] getItems() {
        return this.items;
    }

    public final Float getMakeupDefaultValue() {
        return this.makeupDefaultValue;
    }

    public final Float getSkinWhiteDefaultValue() {
        return this.skinWhiteDefaultValue;
    }

    public int hashCode() {
        String str = this.icon;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Map<String, String>[] mapArr = this.items;
        int hashCode2 = (hashCode + (mapArr == null ? 0 : Arrays.hashCode(mapArr))) * 31;
        String str2 = this.filter;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f2 = this.makeupDefaultValue;
        int hashCode4 = (hashCode3 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.filterDefaultValue;
        int hashCode5 = (hashCode4 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.skinWhiteDefaultValue;
        int hashCode6 = (hashCode5 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Integer num = this.filterLayer;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.isRenderFilter;
        return hashCode7 + (num2 != null ? num2.hashCode() : 0);
    }

    public final Integer isRenderFilter() {
        return this.isRenderFilter;
    }

    public final void setFilter(String str) {
        this.filter = str;
    }

    public final void setFilterDefaultValue(Float f2) {
        this.filterDefaultValue = f2;
    }

    public final void setFilterLayer(Integer num) {
        this.filterLayer = num;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setItems(Map<String, String>[] mapArr) {
        this.items = mapArr;
    }

    public final void setMakeupDefaultValue(Float f2) {
        this.makeupDefaultValue = f2;
    }

    public final void setRenderFilter(Integer num) {
        this.isRenderFilter = num;
    }

    public final void setSkinWhiteDefaultValue(Float f2) {
        this.skinWhiteDefaultValue = f2;
    }

    public String toString() {
        return "StyleMakeupParam(icon=" + ((Object) this.icon) + ", items=" + Arrays.toString(this.items) + ", filter=" + ((Object) this.filter) + ", makeupDefaultValue=" + this.makeupDefaultValue + ", filterDefaultValue=" + this.filterDefaultValue + ", skinWhiteDefaultValue=" + this.skinWhiteDefaultValue + ", filterLayer=" + this.filterLayer + ", isRenderFilter=" + this.isRenderFilter + ')';
    }

    public /* synthetic */ StyleMakeupParam(String str, Map[] mapArr, String str2, Float f2, Float f3, Float f4, Integer num, Integer num2, int i2, o oVar) {
        this(str, mapArr, str2, f2, f3, f4, num, (i2 & 128) != 0 ? null : num2);
    }
}
