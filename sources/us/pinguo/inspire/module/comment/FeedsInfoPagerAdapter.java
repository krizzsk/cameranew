package us.pinguo.inspire.module.comment;

import java.util.ArrayList;
import java.util.List;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.comment.cell.BaseInfoCell;
import us.pinguo.inspire.module.comment.cell.VideoAdInfoCell;
/* compiled from: FeedsInfoPagerAdapter.kt */
/* loaded from: classes9.dex */
public final class FeedsInfoPagerAdapter extends us.pinguo.inspire.y.a.a<InspireWork, BaseInfoCell> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsInfoPagerAdapter(List<BaseInfoCell> dataList) {
        super(dataList);
        kotlin.jvm.internal.s.h(dataList, "dataList");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object object) {
        kotlin.jvm.internal.s.h(object, "object");
        if (object instanceof VideoAdInfoCell) {
            return -2;
        }
        ArrayList<BaseInfoCell> mDataList = getMDataList();
        int F = mDataList == null ? -2 : kotlin.collections.c0.F(mDataList, object);
        if (F == -1) {
            return -2;
        }
        return F;
    }
}
