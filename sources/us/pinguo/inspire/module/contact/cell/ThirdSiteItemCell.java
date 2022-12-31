package us.pinguo.inspire.module.contact.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.inspire.module.contact.entry.ThirdSiteFriend;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.ui.uilview.CircleImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ThirdSiteItemCell extends us.pinguo.inspire.cell.recycler.e<ThirdSiteFriend, ThirdItemHolder> {
    public static final String FACEBOOK = "facebook";
    public static final String TITTER = "titter";
    public static final String WEIBO = "sina";
    private String mSiteName;
    private ThirdItemHolder mThirdItemHolder;

    /* loaded from: classes9.dex */
    public static class ThirdItemHolder extends us.pinguo.widget.common.cell.recycler.c {
        public TextView addressName;
        public CircleImageView avatar;
        public AttentionButton mAttentionButton;
        public TextView userName;

        public ThirdItemHolder(View view) {
            super(view);
            this.avatar = (CircleImageView) view.findViewById(R.id.piv_portrait_include_user);
            this.userName = (TextView) view.findViewById(R.id.tv_nickname_include_user);
            this.addressName = (TextView) view.findViewById(R.id.tv_second_line_include_user);
            this.mAttentionButton = (AttentionButton) view.findViewById(R.id.ab_attention_include_user);
        }
    }

    public ThirdSiteItemCell(ThirdSiteFriend thirdSiteFriend) {
        super(thirdSiteFriend);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 2;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        super.releaseResource();
    }

    public void setSiteName(String str) {
        this.mSiteName = str;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public ThirdItemHolder createViewHolder(ViewGroup viewGroup) {
        return new ThirdItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.address_book_item_layout, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onBindViewHolder(ThirdItemHolder thirdItemHolder) {
        this.mThirdItemHolder = thirdItemHolder;
        thirdItemHolder.hide(R.id.tv_third_line_include_user);
        Context context = thirdItemHolder.avatar.getContext();
        CircleImageView circleImageView = thirdItemHolder.avatar;
        T t = this.mData;
        String str = "";
        circleImageView.setImageUri(((ThirdSiteFriend) t).user == null ? "" : ((ThirdSiteFriend) t).user.avatar, us.pinguo.ui.R.drawable.default_avatar);
        if (this.mSiteName.equals("sina")) {
            str = context.getString(R.string.weibo_friend) + PGTransHeader.CONNECTOR + ((ThirdSiteFriend) this.mData).tName;
        } else if (this.mSiteName.equals("facebook")) {
            str = context.getString(R.string.facebook_friend) + PGTransHeader.CONNECTOR + ((ThirdSiteFriend) this.mData).tName;
        } else if (this.mSiteName.equals(TITTER)) {
            str = context.getString(R.string.titter_friend) + PGTransHeader.CONNECTOR + ((ThirdSiteFriend) this.mData).tName;
        }
        thirdItemHolder.addressName.setText(str);
        T t2 = this.mData;
        if (((ThirdSiteFriend) t2).user != null) {
            thirdItemHolder.userName.setText(((ThirdSiteFriend) t2).user.nickname);
            AttentionButton attentionButton = thirdItemHolder.mAttentionButton;
            T t3 = this.mData;
            attentionButton.k(((ThirdSiteFriend) t3).user, false, ((ThirdSiteFriend) t3).user.userId, this);
        }
    }
}
