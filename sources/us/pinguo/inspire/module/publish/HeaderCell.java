package us.pinguo.inspire.module.publish;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class HeaderCell extends us.pinguo.widget.common.cell.recycler.b<String, us.pinguo.widget.common.cell.recycler.c> {
    public HeaderCell(String str) {
        super(str);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_cell_layout, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        ((TextView) cVar.itemView.findViewById(R.id.header_text)).setText((CharSequence) this.mData);
    }
}
