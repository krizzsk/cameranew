package us.pinguo.user.a1;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import us.pinguo.user.R;
/* compiled from: ErrorCell.java */
/* loaded from: classes6.dex */
public class k extends us.pinguo.widget.common.cell.recycler.b<Object, us.pinguo.widget.common.cell.recycler.c> {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f12367d;

    public k(Object obj) {
        super(obj);
        this.f12367d = 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        this.b = us.pinguo.foundation.t.b.a.j(viewGroup.getContext());
        this.c = viewGroup.getHeight();
        return createHolderByLayout(R.layout.inspire_common_error_cell, viewGroup);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return us.pinguo.user.recycler.c.TYPE_ERROR;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        int i2 = this.f12367d;
        if (i2 > 0) {
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(i2 - 1);
            this.a = us.pinguo.foundation.t.b.a.h(item.mViewHolder.itemView.getContext()) - item.mViewHolder.itemView.getBottom();
        }
        int i3 = this.a;
        if (i3 <= 0) {
            i3 = this.c;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b, i3);
        layoutParams.gravity = 17;
        cVar.itemView.setLayoutParams(layoutParams);
    }
}
