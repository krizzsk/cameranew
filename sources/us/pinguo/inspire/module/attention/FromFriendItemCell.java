package us.pinguo.inspire.module.attention;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.module.profile.InspireLocationManager;
import us.pinguo.inspire.module.profile.activity.GuestProfileActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.profile.activity.ProfileActivity;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FromFriendItemCell extends us.pinguo.inspire.cell.recycler.e<InspireAttention, FromFriendHolder> {
    protected FromFriendHolder mAttentionHolder;
    private OnSelectListener mOnSelectListener;

    /* loaded from: classes9.dex */
    public static class FromFriendHolder extends us.pinguo.widget.common.cell.recycler.c {
        public TextView desc;
        public TextView geo;
        public PortraitImageView userAvatar;
        public TextView userName;

        public FromFriendHolder(View view) {
            super(view);
            this.userAvatar = (PortraitImageView) view.findViewById(R.id.piv_portrait_include_user);
            this.userName = (TextView) view.findViewById(R.id.tv_nickname_include_user);
            this.geo = (TextView) view.findViewById(R.id.tv_third_line_include_user);
            this.desc = (TextView) view.findViewById(R.id.tv_second_line_include_user);
        }
    }

    /* loaded from: classes9.dex */
    public interface OnSelectListener {
        void onSelect(FromFriendItemCell fromFriendItemCell);
    }

    public FromFriendItemCell(InspireAttention inspireAttention) {
        super(inspireAttention);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(View view) {
        OnSelectListener onSelectListener = this.mOnSelectListener;
        if (onSelectListener != null) {
            onSelectListener.onSelect(this);
        }
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

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.mOnSelectListener = onSelectListener;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public FromFriendHolder createViewHolder(ViewGroup viewGroup) {
        return new FromFriendHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.attention_from_friend_layout, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onBindViewHolder(FromFriendHolder fromFriendHolder) {
        this.mAttentionHolder = fromFriendHolder;
        if (((InspireAttention) this.mData).geo != null) {
            InspireLocationManager inspireLocationManager = InspireLocationManager.getInstance();
            T t = this.mData;
            inspireLocationManager.getGeo(((InspireAttention) t).geo.country, ((InspireAttention) t).geo.province, ((InspireAttention) t).geo.city, new InspireLocationManager.LocationResultListener() { // from class: us.pinguo.inspire.module.attention.FromFriendItemCell.1
                @Override // us.pinguo.inspire.module.profile.InspireLocationManager.LocationResultListener
                public void onResult(InspireGeo inspireGeo) {
                    FromFriendItemCell.this.mAttentionHolder.geo.setText(inspireGeo == null ? "" : inspireGeo.toString());
                }
            });
        } else {
            fromFriendHolder.geo.setText("");
        }
        T t2 = this.mData;
        if (TextUtils.isEmpty(((InspireAttention) t2).geo != null ? ((InspireAttention) t2).geo.toString() : "")) {
            this.mAttentionHolder.geo.setVisibility(8);
        } else {
            this.mAttentionHolder.geo.setVisibility(0);
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
        this.mAttentionHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.attention.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FromFriendItemCell.this.b(view);
            }
        });
        this.mAttentionHolder.userAvatar.setUserType(((InspireAttention) this.mData).type);
        this.mAttentionHolder.userAvatar.setUserId(((InspireAttention) this.mData).userId);
        this.mAttentionHolder.userAvatar.setMark(((InspireAttention) this.mData).mark);
    }
}
