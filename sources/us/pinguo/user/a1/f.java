package us.pinguo.user.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.user.R;
/* compiled from: EditAreaGroupItemCell.java */
/* loaded from: classes6.dex */
public class f extends us.pinguo.widget.common.cell.recycler.b {

    /* compiled from: EditAreaGroupItemCell.java */
    /* loaded from: classes6.dex */
    public static class a extends us.pinguo.widget.common.cell.recycler.c {
        public TextView a;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.edit_area_group_text);
        }
    }

    public f(String str) {
        super(str);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.edit_area_group_cell, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 2;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        ((a) cVar).a.setText((String) this.mData);
    }
}
