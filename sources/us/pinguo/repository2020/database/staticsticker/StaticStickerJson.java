package us.pinguo.repository2020.database.staticsticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StaticSticker.kt */
/* loaded from: classes6.dex */
public final class StaticStickerJson implements NoProguard {
    private final Long interval;
    private final String locale;
    private final ShopCategory[] p_categories;
    private final StaticStickerCategory[] packages;
    private final StaticSticker[] stickers;
    private final TemplateCategory[] t_categories;
    private final Template[] templates;
    private final TemplatesAB templates_ab_sort;

    public StaticStickerJson(String str, Long l2, StaticStickerCategory[] staticStickerCategoryArr, ShopCategory[] shopCategoryArr, StaticSticker[] staticStickerArr, TemplateCategory[] templateCategoryArr, Template[] templateArr, TemplatesAB templatesAB) {
        this.locale = str;
        this.interval = l2;
        this.packages = staticStickerCategoryArr;
        this.p_categories = shopCategoryArr;
        this.stickers = staticStickerArr;
        this.t_categories = templateCategoryArr;
        this.templates = templateArr;
        this.templates_ab_sort = templatesAB;
    }

    public final String component1() {
        return this.locale;
    }

    public final Long component2() {
        return this.interval;
    }

    public final StaticStickerCategory[] component3() {
        return this.packages;
    }

    public final ShopCategory[] component4() {
        return this.p_categories;
    }

    public final StaticSticker[] component5() {
        return this.stickers;
    }

    public final TemplateCategory[] component6() {
        return this.t_categories;
    }

    public final Template[] component7() {
        return this.templates;
    }

    public final TemplatesAB component8() {
        return this.templates_ab_sort;
    }

    public final StaticStickerJson copy(String str, Long l2, StaticStickerCategory[] staticStickerCategoryArr, ShopCategory[] shopCategoryArr, StaticSticker[] staticStickerArr, TemplateCategory[] templateCategoryArr, Template[] templateArr, TemplatesAB templatesAB) {
        return new StaticStickerJson(str, l2, staticStickerCategoryArr, shopCategoryArr, staticStickerArr, templateCategoryArr, templateArr, templatesAB);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StaticStickerJson.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.staticsticker.StaticStickerJson");
            StaticStickerJson staticStickerJson = (StaticStickerJson) obj;
            if (s.c(this.locale, staticStickerJson.locale) && s.c(this.interval, staticStickerJson.interval)) {
                StaticStickerCategory[] staticStickerCategoryArr = this.packages;
                if (staticStickerCategoryArr != null) {
                    StaticStickerCategory[] staticStickerCategoryArr2 = staticStickerJson.packages;
                    if (staticStickerCategoryArr2 == null || !Arrays.equals(staticStickerCategoryArr, staticStickerCategoryArr2)) {
                        return false;
                    }
                } else if (staticStickerJson.packages != null) {
                    return false;
                }
                ShopCategory[] shopCategoryArr = this.p_categories;
                if (shopCategoryArr != null) {
                    ShopCategory[] shopCategoryArr2 = staticStickerJson.p_categories;
                    if (shopCategoryArr2 == null || !Arrays.equals(shopCategoryArr, shopCategoryArr2)) {
                        return false;
                    }
                } else if (staticStickerJson.p_categories != null) {
                    return false;
                }
                StaticSticker[] staticStickerArr = this.stickers;
                if (staticStickerArr != null) {
                    StaticSticker[] staticStickerArr2 = staticStickerJson.stickers;
                    if (staticStickerArr2 == null || !Arrays.equals(staticStickerArr, staticStickerArr2)) {
                        return false;
                    }
                } else if (staticStickerJson.stickers != null) {
                    return false;
                }
                TemplateCategory[] templateCategoryArr = this.t_categories;
                if (templateCategoryArr != null) {
                    TemplateCategory[] templateCategoryArr2 = staticStickerJson.t_categories;
                    if (templateCategoryArr2 == null || !Arrays.equals(templateCategoryArr, templateCategoryArr2)) {
                        return false;
                    }
                } else if (staticStickerJson.t_categories != null) {
                    return false;
                }
                Template[] templateArr = this.templates;
                if (templateArr != null) {
                    Template[] templateArr2 = staticStickerJson.templates;
                    if (templateArr2 == null || !Arrays.equals(templateArr, templateArr2)) {
                        return false;
                    }
                } else if (staticStickerJson.templates != null) {
                    return false;
                }
                return s.c(this.templates_ab_sort, staticStickerJson.templates_ab_sort);
            }
            return false;
        }
        return false;
    }

    public final Long getInterval() {
        return this.interval;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final ShopCategory[] getP_categories() {
        return this.p_categories;
    }

    public final StaticStickerCategory[] getPackages() {
        return this.packages;
    }

    public final StaticSticker[] getStickers() {
        return this.stickers;
    }

    public final TemplateCategory[] getT_categories() {
        return this.t_categories;
    }

    public final Template[] getTemplates() {
        return this.templates;
    }

    public final TemplatesAB getTemplates_ab_sort() {
        return this.templates_ab_sort;
    }

    public int hashCode() {
        String str = this.locale;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l2 = this.interval;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        StaticStickerCategory[] staticStickerCategoryArr = this.packages;
        int hashCode3 = (hashCode2 + (staticStickerCategoryArr == null ? 0 : Arrays.hashCode(staticStickerCategoryArr))) * 31;
        ShopCategory[] shopCategoryArr = this.p_categories;
        int hashCode4 = (hashCode3 + (shopCategoryArr == null ? 0 : Arrays.hashCode(shopCategoryArr))) * 31;
        StaticSticker[] staticStickerArr = this.stickers;
        int hashCode5 = (hashCode4 + (staticStickerArr == null ? 0 : Arrays.hashCode(staticStickerArr))) * 31;
        TemplateCategory[] templateCategoryArr = this.t_categories;
        int hashCode6 = (hashCode5 + (templateCategoryArr == null ? 0 : Arrays.hashCode(templateCategoryArr))) * 31;
        Template[] templateArr = this.templates;
        int hashCode7 = (hashCode6 + (templateArr == null ? 0 : Arrays.hashCode(templateArr))) * 31;
        TemplatesAB templatesAB = this.templates_ab_sort;
        return hashCode7 + (templatesAB != null ? templatesAB.hashCode() : 0);
    }

    public String toString() {
        return "StaticStickerJson(locale=" + ((Object) this.locale) + ", interval=" + this.interval + ", packages=" + Arrays.toString(this.packages) + ", p_categories=" + Arrays.toString(this.p_categories) + ", stickers=" + Arrays.toString(this.stickers) + ", t_categories=" + Arrays.toString(this.t_categories) + ", templates=" + Arrays.toString(this.templates) + ", templates_ab_sort=" + this.templates_ab_sort + ')';
    }
}
