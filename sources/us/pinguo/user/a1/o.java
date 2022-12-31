package us.pinguo.user.a1;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.user.R;
import us.pinguo.user.recycler.FeedsNewDecoration;
/* compiled from: NoMoreCell.java */
/* loaded from: classes6.dex */
public class o extends us.pinguo.widget.common.cell.recycler.b implements us.pinguo.user.recycler.a {
    private Integer mBgColor;

    public o(Object obj) {
        super(obj);
        this.mBgColor = null;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.no_more_cell_layout, (ViewGroup) null);
        if (this.mBgColor != null) {
            inflate.findViewById(R.id.recycler_no_more_txt).setBackgroundColor(this.mBgColor.intValue());
        }
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new us.pinguo.widget.common.cell.recycler.c(inflate);
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        FeedsNewDecoration.k(rect, canvas, view, recyclerView, state);
        return true;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return us.pinguo.user.recycler.c.TYPE_NO_MORE;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        cVar.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public o setBackgroundColor(int i2) {
        this.mBgColor = Integer.valueOf(i2);
        return this;
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        rect.set(0, 0, 0, 0);
        return true;
    }
}
