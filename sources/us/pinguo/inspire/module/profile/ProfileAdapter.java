package us.pinguo.inspire.module.profile;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.user.model.ProfileAuthorInfo;
/* loaded from: classes9.dex */
public class ProfileAdapter extends us.pinguo.inspire.widget.videocell.e {

    /* loaded from: classes9.dex */
    public interface OnHeaderSwitchListener {
        void onLaunchPersonalCenter(View view, ProfileAuthorInfo profileAuthorInfo);

        void onStyleSwitch(int i2);
    }

    @Override // us.pinguo.user.recycler.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: us.pinguo.inspire.module.profile.ProfileAdapter.1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i2) {
                    int itemViewType = ProfileAdapter.this.getItemViewType(i2);
                    if (itemViewType == 0 || itemViewType == 1 || itemViewType == 2 || itemViewType == Integer.MAX_VALUE || itemViewType == 2147483646 || itemViewType == 2147483645 || itemViewType == 2147483644 || itemViewType == 2147483643) {
                        return gridLayoutManager.getSpanCount();
                    }
                    return 1;
                }
            });
        }
    }

    @Override // us.pinguo.inspire.widget.videocell.e, us.pinguo.widget.common.cell.recycler.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        super.onBindViewHolder(viewHolder, i2);
    }

    @Override // us.pinguo.widget.common.cell.recycler.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
    }
}
