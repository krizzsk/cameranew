package us.pinguo.inspire.module.feeds.cell;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.user.s0;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsFollowTitleCell extends us.pinguo.widget.common.cell.recycler.b implements us.pinguo.user.recycler.a {
    public FeedsFollowTitleCell(Object obj) {
        super(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public boolean areItemsTheSame(us.pinguo.widget.common.cell.recycler.b bVar) {
        return bVar instanceof FeedsFollowTitleCell;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feeds_follow_title_layout, viewGroup, false));
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        return false;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 17;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        String d2 = s0.getInstance().d();
        String g2 = s0.getInstance().g();
        String userId = s0.getInstance().getUserId();
        PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.feeds_follow_title_avatar);
        portraitImageView.setUserId(userId);
        portraitImageView.setImageUri(g2, us.pinguo.ui.R.drawable.default_avatar);
        String string = portraitImageView.getResources().getString(R.string.feeds_follow_title_content);
        int indexOf = string.indexOf("%1$s");
        int length = d2.length() + indexOf;
        String format = String.format(string, d2);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(16, true);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(portraitImageView.getResources().getColor(us.pinguo.ui.R.color.color_highlight));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(foregroundColorSpan, indexOf, length, 33);
        spannableString.setSpan(absoluteSizeSpan, indexOf, length, 33);
        cVar.setText(R.id.feeds_follow_title_txt, spannableString);
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        rect.set(0, 0, 0, 0);
        return true;
    }
}
