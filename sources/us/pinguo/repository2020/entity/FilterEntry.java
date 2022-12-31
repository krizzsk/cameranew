package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: FilterEntry.kt */
/* loaded from: classes6.dex */
public final class FilterEntry implements NoProguard {
    private final String categoryId;
    private final String itemId;
    private final String pkgId;

    public FilterEntry(String str, String str2, String str3) {
        this.categoryId = str;
        this.pkgId = str2;
        this.itemId = str3;
    }

    public static /* synthetic */ FilterEntry copy$default(FilterEntry filterEntry, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = filterEntry.categoryId;
        }
        if ((i2 & 2) != 0) {
            str2 = filterEntry.pkgId;
        }
        if ((i2 & 4) != 0) {
            str3 = filterEntry.itemId;
        }
        return filterEntry.copy(str, str2, str3);
    }

    public final String component1() {
        return this.categoryId;
    }

    public final String component2() {
        return this.pkgId;
    }

    public final String component3() {
        return this.itemId;
    }

    public final FilterEntry copy(String str, String str2, String str3) {
        return new FilterEntry(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (obj instanceof FilterEntry) {
            FilterEntry filterEntry = (FilterEntry) obj;
            return s.c(this.categoryId, filterEntry.categoryId) && s.c(this.pkgId, filterEntry.pkgId) && s.c(this.itemId, filterEntry.itemId);
        }
        return false;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getPkgId() {
        return this.pkgId;
    }

    public int hashCode() {
        String str = this.categoryId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.pkgId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.itemId;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "FilterEntry(categoryId=" + ((Object) this.categoryId) + ", pkgId=" + ((Object) this.pkgId) + ", itemId=" + ((Object) this.itemId) + ')';
    }

    public /* synthetic */ FilterEntry(String str, String str2, String str3, int i2, o oVar) {
        this(str, str2, (i2 & 4) != 0 ? null : str3);
    }
}
