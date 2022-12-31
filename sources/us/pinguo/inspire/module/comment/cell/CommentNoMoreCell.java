package us.pinguo.inspire.module.comment.cell;

import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.user.R;
/* compiled from: CommentNoMoreCell.kt */
/* loaded from: classes9.dex */
public final class CommentNoMoreCell extends us.pinguo.user.a1.o {
    public CommentNoMoreCell(Object obj) {
        super(obj);
    }

    @Override // us.pinguo.user.a1.o, us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        us.pinguo.widget.common.cell.recycler.c viewHolder = super.createViewHolder(viewGroup);
        TextView textView = (TextView) viewHolder.getView(R.id.recycler_no_more_txt);
        textView.setTextColor(viewHolder.itemView.getResources().getColor(us.pinguo.ui.R.color.text_white));
        textView.setBackgroundColor(0);
        kotlin.jvm.internal.s.g(viewHolder, "viewHolder");
        return viewHolder;
    }
}
