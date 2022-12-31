package us.pinguo.user.a1;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.user.R;
import us.pinguo.user.recycler.FeedsNewDecoration;
/* compiled from: FooterCell.java */
/* loaded from: classes6.dex */
public class l extends us.pinguo.widget.common.cell.recycler.b<Object, us.pinguo.widget.common.cell.recycler.c> implements us.pinguo.user.recycler.a {
    private Integer mBgColor;

    public l(Object obj) {
        super(obj);
        this.mBgColor = null;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recycler_load_more, (ViewGroup) null);
        Integer num = this.mBgColor;
        if (num != null) {
            inflate.setBackgroundColor(num.intValue());
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
        return Integer.MAX_VALUE;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
    }

    public l setBackgroundColor(int i2) {
        this.mBgColor = Integer.valueOf(i2);
        return this;
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        return false;
    }
}
