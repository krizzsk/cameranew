package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: FilterShowData.kt */
/* loaded from: classes6.dex */
public final class CategoryItem {
    private final String categoryId;
    private final boolean isVip;
    private final String name;

    public CategoryItem(String categoryId, String name, boolean z) {
        s.h(categoryId, "categoryId");
        s.h(name, "name");
        this.categoryId = categoryId;
        this.name = name;
        this.isVip = z;
    }

    public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = categoryItem.categoryId;
        }
        if ((i2 & 2) != 0) {
            str2 = categoryItem.name;
        }
        if ((i2 & 4) != 0) {
            z = categoryItem.isVip;
        }
        return categoryItem.copy(str, str2, z);
    }

    public final String component1() {
        return this.categoryId;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.isVip;
    }

    public final CategoryItem copy(String categoryId, String name, boolean z) {
        s.h(categoryId, "categoryId");
        s.h(name, "name");
        return new CategoryItem(categoryId, name, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CategoryItem) {
            CategoryItem categoryItem = (CategoryItem) obj;
            return s.c(this.categoryId, categoryItem.categoryId) && s.c(this.name, categoryItem.name) && this.isVip == categoryItem.isVip;
        }
        return false;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.categoryId.hashCode() * 31) + this.name.hashCode()) * 31;
        boolean z = this.isVip;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public String toString() {
        return "CategoryItem(categoryId=" + this.categoryId + ", name=" + this.name + ", isVip=" + this.isVip + ')';
    }
}
