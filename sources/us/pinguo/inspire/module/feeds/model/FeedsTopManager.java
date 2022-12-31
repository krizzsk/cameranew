package us.pinguo.inspire.module.feeds.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import us.pinguo.inspire.module.feeds.cell.FeedsBannerCell;
import us.pinguo.inspire.module.feeds.cell.FeedsFeatureCell;
import us.pinguo.inspire.module.feeds.cell.FeedsFollowTitleCell;
import us.pinguo.inspire.module.feeds.cell.FeedsInterestCell;
import us.pinguo.inspire.module.feeds.cell.FeedsPublishGuideCell;
import us.pinguo.inspire.module.feeds.cell.FeedsUploadStateCell;
/* loaded from: classes9.dex */
public class FeedsTopManager {
    private static List<Class> SORT_ALL;
    private static List<Class> SORT_TOP = new ArrayList(Arrays.asList(FeedsBannerCell.class, FeedsFeatureCell.class, FeedsUploadStateCell.class, FeedsPublishGuideCell.class));
    private static List<Class> SORT_CONTENT = new ArrayList(Arrays.asList(FeedsFollowTitleCell.class, FeedsInterestCell.class));

    static {
        ArrayList arrayList = new ArrayList(SORT_TOP);
        SORT_ALL = arrayList;
        arrayList.addAll(SORT_CONTENT);
    }

    private static Class forName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            d.f.a.b.d.c(e2);
            return null;
        }
    }

    public static int getInsertIndex(List<us.pinguo.widget.common.cell.recycler.b> list, Class cls) {
        int i2 = -1;
        if (list == null) {
            if (us.pinguo.foundation.d.f10985d) {
                throw new IllegalArgumentException("cellList is null!");
            }
            return -1;
        }
        if (cls == null) {
            cls = Object.class;
        }
        int typeIndex_All = getTypeIndex_All(cls);
        if (typeIndex_All == -1) {
            return getTopCellCount(list);
        }
        boolean z = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int typeIndex_All2 = getTypeIndex_All(list.get(i3).getClass());
            if (typeIndex_All < typeIndex_All2 || typeIndex_All == typeIndex_All2) {
                i2 = i3;
                z = true;
                break;
            } else if (typeIndex_All2 == Integer.MAX_VALUE) {
                return i3;
            }
        }
        return !z ? getSortedCellCount(list) : i2;
    }

    public static int getSortedCellCount(List<us.pinguo.widget.common.cell.recycler.b> list) {
        if (list == null) {
            return 0;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getTypeIndex_All(list.get(i2).getClass()) == Integer.MAX_VALUE) {
                return i2;
            }
        }
        return list.size();
    }

    public static int getTopCellCount(List<us.pinguo.widget.common.cell.recycler.b> list) {
        if (list == null) {
            return 0;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getTypeIndex_Top(list.get(i2).getClass()) == Integer.MAX_VALUE) {
                return i2;
            }
        }
        return list.size();
    }

    private static int getTypeIndex_All(Class cls) {
        int indexOf = SORT_ALL.indexOf(cls);
        if (indexOf == -1) {
            return Integer.MAX_VALUE;
        }
        return indexOf;
    }

    private static int getTypeIndex_Top(Class cls) {
        int indexOf = SORT_TOP.indexOf(cls);
        if (indexOf == -1) {
            return Integer.MAX_VALUE;
        }
        return indexOf;
    }
}
