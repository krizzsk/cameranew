package us.pinguo.inspire.module.discovery.cell;

import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import us.pinguo.inspire.module.discovery.type.DiscoverySquareCellType;
import us.pinguo.widget.common.cell.recycler.DiffMode;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryBannerTextCell extends us.pinguo.widget.common.cell.recycler.b<String, c> {
    public DiscoveryBannerTextCell(String str) {
        super(str);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.discovery_banner_text, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public DiffMode getDiffMode() {
        return DiffMode.UNIQUE;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return DiscoverySquareCellType.BANNER_BOTTOM_TEXT.ordinal();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        ViewGroup.LayoutParams layoutParams = cVar.itemView.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
        cVar.setText(R.id.tv_text_banner_text, cVar.itemView.getContext().getString(R.string.let_you_see_world));
    }
}
