package us.pinguo.user.a1;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.user.R;
/* compiled from: EmptyCell.java */
/* loaded from: classes6.dex */
public class j extends us.pinguo.widget.common.cell.recycler.b<Object, us.pinguo.widget.common.cell.recycler.c> implements us.pinguo.user.recycler.a {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f12364d;

    /* renamed from: e  reason: collision with root package name */
    private int f12365e;

    /* renamed from: f  reason: collision with root package name */
    private int f12366f;

    public j(Object obj) {
        super(obj);
        this.f12364d = 0;
        this.f12365e = -1;
        this.f12366f = -1;
    }

    public void a(int i2) {
        this.f12364d = i2;
    }

    public void b(int i2) {
        this.f12366f = i2;
    }

    public void c(int i2) {
        this.f12365e = i2;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        this.b = us.pinguo.foundation.t.b.a.j(viewGroup.getContext());
        this.c = viewGroup.getHeight();
        return createHolderByLayout(R.layout.inspire_common_empty_cell, viewGroup);
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        return false;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return us.pinguo.user.recycler.c.TYPE_EMPTY;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        us.pinguo.widget.common.cell.recycler.b item;
        VH vh;
        View view;
        int i2 = this.f12364d;
        if (i2 > 0 && (item = this.mAdapter.getItem(i2 - 1)) != null && (vh = item.mViewHolder) != 0 && (view = vh.itemView) != null) {
            this.a = us.pinguo.foundation.t.b.a.h(item.mViewHolder.itemView.getContext()) - view.getBottom();
        }
        int i3 = this.a;
        if (i3 <= 0) {
            i3 = this.c;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b, i3);
        layoutParams.gravity = 17;
        cVar.itemView.setLayoutParams(layoutParams);
        if (this.f12365e == -1 || this.f12366f == -1) {
            return;
        }
        ((ImageView) cVar.getView(R.id.empty_tip_icon)).setImageResource(this.f12366f);
        ((TextView) cVar.getView(R.id.empty_tip_text)).setText(this.f12365e);
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        rect.set(0, 0, 0, 0);
        return true;
    }
}
