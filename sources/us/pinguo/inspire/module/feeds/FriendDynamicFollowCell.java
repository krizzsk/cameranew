package us.pinguo.inspire.module.feeds;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.foundation.utils.f0;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.module.discovery.entity.InspireFeedSender;
import us.pinguo.inspire.module.feeds.model.InspireFollowAndLikeDetail;
import us.pinguo.inspire.module.profile.activity.GuestProfileActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.profile.activity.ProfileActivity;
import us.pinguo.inspire.util.p;
import us.pinguo.user.s0;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FriendDynamicFollowCell extends us.pinguo.widget.common.cell.recycler.b<InspireFollowAndLikeDetail, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener {
    private int[] childId;
    private CharSequence mTitle;

    public FriendDynamicFollowCell(InspireFollowAndLikeDetail inspireFollowAndLikeDetail) {
        super(inspireFollowAndLikeDetail);
        this.childId = new int[]{R.id.friend_dynamic_work_child_1, R.id.friend_dynamic_work_child_2, R.id.friend_dynamic_work_child_3, R.id.friend_dynamic_work_child_4};
    }

    private void setFollow(View view, InspireFeedSender inspireFeedSender) {
        if (inspireFeedSender == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        String str = inspireFeedSender.avatar;
        PortraitImageView portraitImageView = (PortraitImageView) view.findViewById(R.id.friend_dynamic_follow_child_avatar);
        portraitImageView.setImageUri(str, us.pinguo.ui.R.drawable.default_avatar);
        portraitImageView.setUserId(inspireFeedSender.userId);
        portraitImageView.setUserType(inspireFeedSender.type);
        portraitImageView.setMark(inspireFeedSender.mark);
        TextView textView = (TextView) view.findViewById(R.id.friend_follow_child_name);
        TextView textView2 = (TextView) view.findViewById(R.id.friend_dynamic_follow_child_desc);
        String str2 = inspireFeedSender.nickname;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        textView.setText(str2);
        if (TextUtils.isEmpty(inspireFeedSender.description)) {
            InspireGeo inspireGeo = inspireFeedSender.geo;
            if (inspireGeo != null) {
                str3 = inspireGeo.toString();
            }
        } else {
            str3 = inspireFeedSender.description;
        }
        if (TextUtils.isEmpty(str3)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str3);
            textView2.setVisibility(0);
        }
        view.setOnClickListener(this);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.friend_dynamic_follow_layout, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        T t = this.mData;
        if (t == 0) {
            return;
        }
        String str = ((InspireFollowAndLikeDetail) t).user == null ? "" : ((InspireFollowAndLikeDetail) t).user.avatar;
        PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.friend_dynamic_work_avatar);
        portraitImageView.setImageUri(str, us.pinguo.ui.R.drawable.default_avatar);
        T t2 = this.mData;
        portraitImageView.setUserId(((InspireFollowAndLikeDetail) t2).user != null ? ((InspireFollowAndLikeDetail) t2).user.userId : "");
        T t3 = this.mData;
        int i2 = 0;
        portraitImageView.setUserType(((InspireFollowAndLikeDetail) t3).user == null ? 0 : ((InspireFollowAndLikeDetail) t3).user.type);
        setTitle(cVar);
        while (i2 < 4) {
            T t4 = this.mData;
            setFollow(cVar.getView(this.childId[i2]), (((InspireFollowAndLikeDetail) t4).followList == null || ((InspireFollowAndLikeDetail) t4).followList.size() <= i2) ? null : ((InspireFollowAndLikeDetail) this.mData).followList.get(i2));
            i2++;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InspireFeedSender inspireFeedSender;
        int i2 = 0;
        while (true) {
            if (i2 >= this.childId.length) {
                inspireFeedSender = null;
                break;
            }
            if (view.getId() == this.childId[i2]) {
                T t = this.mData;
                if (((InspireFollowAndLikeDetail) t).followList != null && ((InspireFollowAndLikeDetail) t).followList.size() > i2) {
                    inspireFeedSender = ((InspireFollowAndLikeDetail) this.mData).followList.get(i2);
                    break;
                }
            }
            i2++;
        }
        if (inspireFeedSender == null) {
            return;
        }
        Intent intent = new Intent();
        if (f0.b(s0.getInstance().getUserId(), inspireFeedSender.userId)) {
            intent.setClass(view.getContext(), ProfileActivity.class);
        } else {
            intent.setClass(view.getContext(), GuestProfileActivity.class);
            intent.putExtra(GuestProfileFragment.USER_ID, inspireFeedSender.userId);
        }
        view.getContext().startActivity(intent);
    }

    public void setTitle(us.pinguo.widget.common.cell.recycler.c cVar) {
        TextView textView = (TextView) cVar.getView(R.id.friend_dynamic_work_title);
        TextView textView2 = (TextView) cVar.getView(R.id.friend_dynamic_work_desc);
        T t = this.mData;
        String str = ((InspireFollowAndLikeDetail) t).user == null ? "" : ((InspireFollowAndLikeDetail) t).user.nickname;
        textView.setText(str != null ? str : "");
        String f2 = p.f(textView2.getContext(), ((InspireFollowAndLikeDetail) this.mData).timeline * 1000, System.currentTimeMillis());
        String string = textView2.getResources().getString(R.string.friend_dynamic_follow);
        textView2.setText(f2 + " / " + string);
    }
}
