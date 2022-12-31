package us.pinguo.user.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import us.pinguo.user.R;
/* compiled from: LoadingCell.java */
/* loaded from: classes6.dex */
public class m extends us.pinguo.widget.common.cell.recycler.b {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f12368d;

    /* renamed from: e  reason: collision with root package name */
    private int f12369e;

    public m(Object obj) {
        super(obj);
        this.f12368d = 0;
        this.f12369e = -1;
    }

    private void a(us.pinguo.widget.common.cell.recycler.c cVar, int i2) {
        cVar.getView(R.id.rl_load_cell).setBackgroundColor(i2);
    }

    public void b(int i2) {
        this.f12369e = i2;
        us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
        if (cVar != null) {
            a(cVar, i2);
        }
    }

    public void c(int i2) {
        this.f12368d = i2;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.base_loding_cell_layout, (ViewGroup) null);
        this.b = us.pinguo.foundation.t.b.a.j(viewGroup.getContext());
        this.c = viewGroup.getHeight();
        return new us.pinguo.widget.common.cell.recycler.c(inflate);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return us.pinguo.user.recycler.c.TYPE_LODING;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        us.pinguo.widget.common.cell.recycler.b item;
        VH vh;
        View view;
        int i2 = this.f12368d;
        if (i2 > 0 && (vh = (item = this.mAdapter.getItem(i2 - 1)).mViewHolder) != 0 && (view = vh.itemView) != null) {
            this.a = us.pinguo.foundation.t.b.a.h(item.mViewHolder.itemView.getContext()) - view.getBottom();
        }
        int i3 = this.a;
        if (i3 <= 0) {
            i3 = this.c;
        }
        cVar.itemView.setLayoutParams(new RelativeLayout.LayoutParams(this.b, i3));
        a(cVar, this.f12369e);
        us.pinguo.common.log.a.m("FKK", "height:" + i3, new Object[0]);
    }
}
