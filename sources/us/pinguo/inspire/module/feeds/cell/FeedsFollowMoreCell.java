package us.pinguo.inspire.module.feeds.cell;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.inspire.module.contact.ContactActivity;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsFollowMoreCell extends us.pinguo.widget.common.cell.recycler.b implements View.OnClickListener, us.pinguo.user.recycler.a {
    public FeedsFollowMoreCell(Object obj) {
        super(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public boolean areItemsTheSame(us.pinguo.widget.common.cell.recycler.b bVar) {
        return bVar instanceof FeedsFollowMoreCell;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feeds_follow_more_friends_layout, viewGroup, false));
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        return false;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 19;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        cVar.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), ContactActivity.class));
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        rect.set(rect2);
        rect.bottom *= 2;
        return true;
    }
}
