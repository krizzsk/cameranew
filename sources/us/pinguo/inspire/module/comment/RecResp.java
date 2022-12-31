package us.pinguo.inspire.module.comment;

import java.util.ArrayList;
import us.pinguo.inspire.model.InspireWork;
/* compiled from: RecLoader.kt */
/* loaded from: classes9.dex */
public final class RecResp {
    private final boolean isAdmin;
    private final ArrayList<InspireWork> items;
    private final String listName;
    private final int pageNo;
    private final int pageSize;

    public RecResp(ArrayList<InspireWork> items, String listName, int i2, int i3, boolean z) {
        kotlin.jvm.internal.s.h(items, "items");
        kotlin.jvm.internal.s.h(listName, "listName");
        this.items = items;
        this.listName = listName;
        this.pageNo = i2;
        this.pageSize = i3;
        this.isAdmin = z;
    }

    public static /* synthetic */ RecResp copy$default(RecResp recResp, ArrayList arrayList, String str, int i2, int i3, boolean z, int i4, Object obj) {
        ArrayList<InspireWork> arrayList2 = arrayList;
        if ((i4 & 1) != 0) {
            arrayList2 = recResp.items;
        }
        if ((i4 & 2) != 0) {
            str = recResp.listName;
        }
        String str2 = str;
        if ((i4 & 4) != 0) {
            i2 = recResp.pageNo;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = recResp.pageSize;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            z = recResp.isAdmin;
        }
        return recResp.copy(arrayList2, str2, i5, i6, z);
    }

    public final ArrayList<InspireWork> component1() {
        return this.items;
    }

    public final String component2() {
        return this.listName;
    }

    public final int component3() {
        return this.pageNo;
    }

    public final int component4() {
        return this.pageSize;
    }

    public final boolean component5() {
        return this.isAdmin;
    }

    public final RecResp copy(ArrayList<InspireWork> items, String listName, int i2, int i3, boolean z) {
        kotlin.jvm.internal.s.h(items, "items");
        kotlin.jvm.internal.s.h(listName, "listName");
        return new RecResp(items, listName, i2, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecResp) {
            RecResp recResp = (RecResp) obj;
            return kotlin.jvm.internal.s.c(this.items, recResp.items) && kotlin.jvm.internal.s.c(this.listName, recResp.listName) && this.pageNo == recResp.pageNo && this.pageSize == recResp.pageSize && this.isAdmin == recResp.isAdmin;
        }
        return false;
    }

    public final ArrayList<InspireWork> getItems() {
        return this.items;
    }

    public final String getListName() {
        return this.listName;
    }

    public final int getPageNo() {
        return this.pageNo;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.items.hashCode() * 31) + this.listName.hashCode()) * 31) + this.pageNo) * 31) + this.pageSize) * 31;
        boolean z = this.isAdmin;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public final boolean isAdmin() {
        return this.isAdmin;
    }

    public String toString() {
        return "RecResp(items=" + this.items + ", listName=" + this.listName + ", pageNo=" + this.pageNo + ", pageSize=" + this.pageSize + ", isAdmin=" + this.isAdmin + ')';
    }
}
