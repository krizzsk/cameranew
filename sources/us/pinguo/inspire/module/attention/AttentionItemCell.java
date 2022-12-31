package us.pinguo.inspire.module.attention;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.module.profile.InspireLocationManager;
import us.pinguo.inspire.module.profile.activity.GuestProfileActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.profile.activity.ProfileActivity;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.user.model.IRelation;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class AttentionItemCell extends us.pinguo.inspire.cell.recycler.e<InspireAttention, AttentionHolder> implements View.OnClickListener {
    protected AttentionHolder mAttentionHolder;

    /* loaded from: classes9.dex */
    public static class AttentionHolder extends us.pinguo.widget.common.cell.recycler.c {
        public AttentionButton attentionBtn;
        public TextView desc;
        public TextView geo;
        public PortraitImageView userAvatar;
        public TextView userName;

        public AttentionHolder(View view) {
            super(view);
            this.userAvatar = (PortraitImageView) view.findViewById(R.id.piv_portrait_include_user);
            this.userName = (TextView) view.findViewById(R.id.tv_nickname_include_user);
            this.geo = (TextView) view.findViewById(R.id.tv_third_line_include_user);
            this.desc = (TextView) view.findViewById(R.id.tv_second_line_include_user);
            AttentionButton attentionButton = (AttentionButton) view.findViewById(R.id.ab_attention_include_user);
            this.attentionBtn = attentionButton;
            attentionButton.setAttentionStyle(new AttentionButton.h() { // from class: us.pinguo.inspire.module.attention.AttentionItemCell.AttentionHolder.1
                @Override // us.pinguo.inspire.widget.AttentionButton.h
                public void animingStyle(AttentionButton attentionButton2) {
                }

                @Override // us.pinguo.inspire.widget.AttentionButton.h
                public void followedStyle(AttentionButton attentionButton2) {
                    attentionButton2.setBackgroundResource(R.drawable.bg_followed);
                    attentionButton2.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
                }

                @Override // us.pinguo.inspire.widget.AttentionButton.h
                public void friendStyle(AttentionButton attentionButton2) {
                    attentionButton2.setBackgroundResource(R.drawable.bg_friends);
                    attentionButton2.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
                }

                @Override // us.pinguo.inspire.widget.AttentionButton.h
                public void unFollowedStyle(AttentionButton attentionButton2) {
                    attentionButton2.setBackgroundResource(R.drawable.bg_unfollow);
                    attentionButton2.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
                }
            });
        }
    }

    public AttentionItemCell(InspireAttention inspireAttention) {
        super(inspireAttention);
    }

    public static void intentToGuestProfile(View view, String str) {
        Intent intent = new Intent();
        intent.setClass(view.getContext(), GuestProfileActivity.class);
        intent.putExtra(GuestProfileFragment.USER_ID, str);
        view.getContext().startActivity(intent);
    }

    public static void intentToMyProfile(View view) {
        Intent intent = new Intent();
        intent.setClass(view.getContext(), ProfileActivity.class);
        view.getContext().startActivity(intent);
    }

    private void onClickItem(View view) {
        T t = this.mData;
        if (t == 0 || TextUtils.isEmpty(((InspireAttention) t).userId)) {
            return;
        }
        PortraitImageView.f(view.getContext(), ((InspireAttention) this.mData).userId);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AttentionHolder attentionHolder = this.mAttentionHolder;
        if (attentionHolder == null || view != attentionHolder.itemView) {
            return;
        }
        onClickItem(view);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public AttentionHolder createViewHolder(ViewGroup viewGroup) {
        return new AttentionHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.attention_item_layout, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onBindViewHolder(AttentionHolder attentionHolder) {
        this.mAttentionHolder = attentionHolder;
        if (((InspireAttention) this.mData).geo != null) {
            InspireLocationManager inspireLocationManager = InspireLocationManager.getInstance();
            T t = this.mData;
            inspireLocationManager.getGeo(((InspireAttention) t).geo.country, ((InspireAttention) t).geo.province, ((InspireAttention) t).geo.city, new InspireLocationManager.LocationResultListener() { // from class: us.pinguo.inspire.module.attention.AttentionItemCell.1
                @Override // us.pinguo.inspire.module.profile.InspireLocationManager.LocationResultListener
                public void onResult(InspireGeo inspireGeo) {
                    AttentionItemCell.this.mAttentionHolder.geo.setText(inspireGeo == null ? "" : inspireGeo.toString());
                    if (TextUtils.isEmpty(AttentionItemCell.this.mAttentionHolder.geo.getText())) {
                        AttentionItemCell.this.mAttentionHolder.geo.setVisibility(8);
                    } else {
                        AttentionItemCell.this.mAttentionHolder.geo.setVisibility(0);
                    }
                }
            });
        } else {
            attentionHolder.geo.setText("");
            T t2 = this.mData;
            if (TextUtils.isEmpty(((InspireAttention) t2).geo != null ? ((InspireAttention) t2).geo.toString() : "")) {
                this.mAttentionHolder.geo.setVisibility(8);
            } else {
                this.mAttentionHolder.geo.setVisibility(0);
            }
        }
        this.mAttentionHolder.desc.setText(((InspireAttention) this.mData).desc);
        if (TextUtils.isEmpty(((InspireAttention) this.mData).desc)) {
            this.mAttentionHolder.desc.setVisibility(8);
        } else {
            this.mAttentionHolder.desc.setVisibility(0);
        }
        this.mAttentionHolder.userAvatar.setImageUri(((InspireAttention) this.mData).avatar, us.pinguo.ui.R.drawable.default_avatar);
        if (TextUtils.isEmpty(((InspireAttention) this.mData).highlight)) {
            this.mAttentionHolder.userName.setText(((InspireAttention) this.mData).nickname);
        } else {
            this.mAttentionHolder.userName.setText(us.pinguo.inspire.widget.j.b.k(((InspireAttention) this.mData).highlight));
        }
        AttentionButton attentionButton = this.mAttentionHolder.attentionBtn;
        T t3 = this.mData;
        attentionButton.k((IRelation) t3, true, ((InspireAttention) t3).userId, this);
        this.mAttentionHolder.userAvatar.setUserType(((InspireAttention) this.mData).type);
        this.mAttentionHolder.userAvatar.setUserId(((InspireAttention) this.mData).userId);
        this.mAttentionHolder.userAvatar.setMark(((InspireAttention) this.mData).mark);
        attentionHolder.itemView.setOnClickListener(this);
    }
}
