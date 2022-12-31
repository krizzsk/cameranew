package us.pinguo.inspire.module.comment.cell;

import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.user.R;
/* compiled from: CommentFooterCell.kt */
/* loaded from: classes9.dex */
public final class CommentFooterCell extends us.pinguo.user.a1.l {
    public CommentFooterCell(Object obj) {
        super(obj);
    }

    @Override // us.pinguo.user.a1.l, us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        us.pinguo.widget.common.cell.recycler.c viewHolder = super.createViewHolder(viewGroup);
        viewHolder.itemView.setBackgroundColor(0);
        ((TextView) viewHolder.getView(R.id.recycler_load_more_txt)).setTextColor(viewHolder.itemView.getResources().getColor(us.pinguo.ui.R.color.text_white));
        kotlin.jvm.internal.s.g(viewHolder, "viewHolder");
        return viewHolder;
    }
}
