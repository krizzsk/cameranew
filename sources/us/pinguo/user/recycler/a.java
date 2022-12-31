package us.pinguo.user.recycler;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: ILinearDecoration.java */
/* loaded from: classes6.dex */
public interface a {
    boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state);

    boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2);
}
