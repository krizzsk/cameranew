package us.pinguo.inspire.module.contact.cell;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.inspire.module.attention.AttentionItemCell;
import us.pinguo.inspire.module.contact.RecommendPhotoView;
import us.pinguo.inspire.module.contact.entry.Recommend;
import us.pinguo.inspire.module.feeds.cell.FeedsFollowTitleCell;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FindFriendItemCell extends us.pinguo.inspire.cell.recycler.e<Recommend, FindFriendItemHolder> implements us.pinguo.user.recycler.a {
    private FindFriendItemHolder mFindFriendItemHolder;

    /* loaded from: classes9.dex */
    public static class FindFriendItemHolder extends us.pinguo.widget.common.cell.recycler.c {
        private PortraitImageView avatar;
        private TextView from;
        private AttentionButton mAttentionButton;
        private RecommendPhotoView mRecommendPhotoView;
        private View recView;
        private TextView userName;

        public FindFriendItemHolder(View view) {
            super(view);
            this.avatar = (PortraitImageView) view.findViewById(R.id.piv_portrait_include_user);
            this.userName = (TextView) view.findViewById(R.id.tv_nickname_include_user);
            this.from = (TextView) view.findViewById(R.id.tv_second_line_include_user);
            this.mRecommendPhotoView = (RecommendPhotoView) view.findViewById(R.id.rec_photo);
            this.recView = view.findViewById(R.id.rec_parent_view);
            this.mAttentionButton = (AttentionButton) view.findViewById(R.id.ab_attention_include_user);
        }
    }

    public FindFriendItemCell(Recommend recommend) {
        super(recommend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(View view) {
        AttentionItemCell.intentToGuestProfile(view, ((Recommend) this.mData).user.userId);
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        return false;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 18;
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        if (bVar instanceof FeedsFollowTitleCell) {
            rect.set(rect2.left, 0, rect2.right, rect2.bottom);
            return true;
        }
        return false;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public FindFriendItemHolder createViewHolder(ViewGroup viewGroup) {
        return new FindFriendItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_recommend_cell_layout, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onBindViewHolder(FindFriendItemHolder findFriendItemHolder) {
        String str;
        this.mFindFriendItemHolder = findFriendItemHolder;
        StringBuilder sb = new StringBuilder();
        sb.append(((Recommend) this.mData).from);
        if (TextUtils.isEmpty(((Recommend) this.mData).nickName)) {
            str = "";
        } else {
            str = PGTransHeader.CONNECTOR + ((Recommend) this.mData).nickName;
        }
        sb.append(str);
        findFriendItemHolder.from.setText(sb.toString());
        findFriendItemHolder.mRecommendPhotoView.setImageUris(((Recommend) this.mData).works);
        if (((Recommend) this.mData).user != null) {
            findFriendItemHolder.avatar.setImageUri(((Recommend) this.mData).user.avatar);
            findFriendItemHolder.userName.setText(((Recommend) this.mData).user.nickname);
            AttentionButton attentionButton = findFriendItemHolder.mAttentionButton;
            T t = this.mData;
            attentionButton.k(((Recommend) t).user, false, ((Recommend) t).user.userId, this);
            PortraitImageView portraitImageView = findFriendItemHolder.avatar;
            portraitImageView.setImageUri(((Recommend) this.mData).user.avatar, us.pinguo.ui.R.drawable.default_avatar);
            portraitImageView.setUserId(((Recommend) this.mData).user.userId);
            portraitImageView.setUserType(((Recommend) this.mData).user.type);
            portraitImageView.setMark(((Recommend) this.mData).user.mark);
        }
        findFriendItemHolder.hide(R.id.tv_third_line_include_user);
        findFriendItemHolder.recView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.contact.cell.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindFriendItemCell.this.b(view);
            }
        });
    }
}
