package us.pinguo.inspire.module.contact.cell;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class RecommendHeaderCell extends us.pinguo.widget.common.cell.recycler.b {
    public RecommendHeaderCell(Object obj) {
        super(obj);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rec_header_cell, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 2;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
    }
}
