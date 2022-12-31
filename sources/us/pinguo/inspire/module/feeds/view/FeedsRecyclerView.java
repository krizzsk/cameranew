package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import us.pinguo.inspire.module.feeds.cell.FeedsBannerCell;
import us.pinguo.user.recycler.FlingFilterRecyclerView;
import us.pinguo.widget.common.cell.recycler.a;
/* loaded from: classes9.dex */
public class FeedsRecyclerView extends FlingFilterRecyclerView {
    public FeedsRecyclerView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public View getFocusedChild() {
        if (!(getAdapter() instanceof a)) {
            return super.getFocusedChild();
        }
        if ((((a) getAdapter()).getItem(0) instanceof FeedsBannerCell) && ((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) {
            us.pinguo.common.log.a.k("hack getFocusedChild , return first", new Object[0]);
            return getChildAt(0);
        }
        return super.getFocusedChild();
    }

    public FeedsRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeedsRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
