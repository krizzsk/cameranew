package us.pinguo.inspire.module.publish;

import android.view.ViewGroup;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class SelectTagCell extends us.pinguo.widget.common.cell.recycler.b<PublishTag, us.pinguo.widget.common.cell.recycler.c> {
    private boolean mIsNewTag;

    public SelectTagCell(PublishTag publishTag, boolean z) {
        super(publishTag);
        this.mIsNewTag = z;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.select_tag_cell, viewGroup);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        cVar.setText(R.id.tv_tag_name_select_tag_cell, ((PublishTag) this.mData).name);
        if (this.mIsNewTag) {
            cVar.show(R.id.tv_create_select_tag_cell);
        } else {
            cVar.hide(R.id.tv_create_select_tag_cell);
        }
    }
}
