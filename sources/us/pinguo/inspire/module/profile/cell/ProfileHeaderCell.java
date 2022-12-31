package us.pinguo.inspire.module.profile.cell;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.constant.MessageType;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.utils.f0;
import us.pinguo.foundation.utils.u;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.event.ShowProfileRecommendEvent;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.module.comment.cell.ContentInfoCell;
import us.pinguo.inspire.module.contact.entry.Recommend;
import us.pinguo.inspire.module.feeds.cell.FeedsInterestCell;
import us.pinguo.inspire.module.guide.Common;
import us.pinguo.inspire.module.master.MasterActivity;
import us.pinguo.inspire.module.masterlist.MasterListActivity;
import us.pinguo.inspire.module.message.category.activity.InspireMessageCommentActivity;
import us.pinguo.inspire.module.profile.InspireLocationManager;
import us.pinguo.inspire.module.profile.ProfileAdapter;
import us.pinguo.inspire.module.profile.cell.ProfileHeaderCell;
import us.pinguo.inspire.module.profile.view.ProfileHeaderTabView;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.user.User;
import us.pinguo.user.model.ProfileAuthorInfo;
import us.pinguo.user.s0;
import us.pinguo.user.y0;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ProfileHeaderCell extends us.pinguo.inspire.cell.recycler.d<ProfileAuthorInfo, us.pinguo.widget.common.cell.recycler.c> {
    public static final String SP_LIKE_STYLE_KEY = "like_show_style";
    public static final String SP_WORK_STYLE_KEY = "work_show_style";
    private static final String TAG = "ProfileHeaderCell";
    public static final int TYPE = 0;
    public static final int TYPE_GRID = 0;
    public static final int TYPE_LINE_VERTICAL = 1;
    public static int sGuestLikeShowType = 0;
    public static int sGuestStoryShowType = 0;
    public static int sMineLikeShowType = 0;
    public static int sMineStoryShowType = 1;
    private Activity activity;
    private FeedsInterestCell mFeedsInterestCell;
    private ProfileHeaderHolder mHeaderHolder;
    private ProfileAdapter.OnHeaderSwitchListener mOnHeaderSwitchListener;
    private ProfileHeaderTabView.OnTabViewSelectListener mOnTabViewSelectListener;
    private ProfileHeaderTabView.State mState;

    /* loaded from: classes9.dex */
    public static class ProfileHeaderHolder extends us.pinguo.widget.common.cell.recycler.c {
        public TextView authorName;
        public PortraitImageView avatar;
        public TextView btnSwitch;
        private PhotoImageView cover;
        private TextView flowerTxt;
        public ImageView genderView;
        public TextView level;
        public TextView location;
        public ProfileHeaderTabView mHeaderTabView;
        private View mRecommendView;
        public TextView master;
        public TextView motto;
        private TextView profile_user_desc;
        public AutofitTextView rankingTxt;
        public ImageView vipImg;

        public ProfileHeaderHolder(View view) {
            super(view);
            this.btnSwitch = (TextView) view.findViewById(R.id.profile_switch_bar);
            this.avatar = (PortraitImageView) view.findViewById(R.id.profile_avatar_res_0x7d0601c1);
            this.authorName = (TextView) view.findViewById(R.id.profile_user_name_md);
            this.location = (TextView) view.findViewById(R.id.profile_geo_md);
            this.motto = (TextView) view.findViewById(R.id.profile_motto_md);
            this.genderView = (ImageView) view.findViewById(R.id.profile_user_gender_md);
            this.master = (TextView) view.findViewById(R.id.profile_user_master);
            this.vipImg = (ImageView) view.findViewById(R.id.vip_img);
            this.master.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.profile.cell.ProfileHeaderCell.ProfileHeaderHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MasterActivity.launch((Activity) view2.getContext());
                }
            });
            this.mHeaderTabView = (ProfileHeaderTabView) view.findViewById(R.id.profile_head_tab_view);
            this.cover = (PhotoImageView) view.findViewById(R.id.profile_cover);
            View findViewById = view.findViewById(R.id.profile_item_recommend);
            this.mRecommendView = findViewById;
            findViewById.setBackgroundColor(view.getResources().getColor(us.pinguo.ui.R.color.color_bg_white));
            this.profile_user_desc = (TextView) view.findViewById(R.id.profile_user_desc);
            this.rankingTxt = (AutofitTextView) view.findViewById(R.id.info_ranking_txt);
            this.flowerTxt = (TextView) view.findViewById(R.id.profile_header_flower_txt);
        }
    }

    public ProfileHeaderCell(ProfileAuthorInfo profileAuthorInfo, Activity activity) {
        super(profileAuthorInfo);
        this.mState = ProfileHeaderTabView.State.STORY;
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(View view) {
        this.activity.startActivity(new Intent(this.activity, MasterListActivity.class));
    }

    private void bindInterestData(List<Recommend> list) {
        if (list == null || list.size() <= 0) {
            this.mHeaderHolder.mRecommendView.setVisibility(8);
            return;
        }
        this.mHeaderHolder.mRecommendView.setVisibility(0);
        FeedsInterestCell feedsInterestCell = this.mFeedsInterestCell;
        if (feedsInterestCell == null) {
            FeedsInterestCell feedsInterestCell2 = new FeedsInterestCell(list);
            this.mFeedsInterestCell = feedsInterestCell2;
            this.mFeedsInterestCell.bindViewHolder(feedsInterestCell2.createViewHolder(this.mHeaderHolder.mRecommendView));
        } else {
            feedsInterestCell.updateData(list);
        }
        this.mFeedsInterestCell.setOnCloseListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(View view) {
        ProfileAdapter.OnHeaderSwitchListener onHeaderSwitchListener = this.mOnHeaderSwitchListener;
        if (onHeaderSwitchListener != null) {
            onHeaderSwitchListener.onStyleSwitch(getWillShowStyle(this.mState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enterPersonalInfo */
    public void f(View view) {
        ProfileAdapter.OnHeaderSwitchListener onHeaderSwitchListener;
        T t = this.mData;
        if (t == 0 || (onHeaderSwitchListener = this.mOnHeaderSwitchListener) == null) {
            return;
        }
        onHeaderSwitchListener.onLaunchPersonalCenter(view, (ProfileAuthorInfo) t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(ProfileHeaderHolder profileHeaderHolder, View view) {
        AppGoto appGoto = AppGoto.getInstance();
        us.pinguo.foundation.interaction.c c = appGoto.c(Inspire.f11205f + "/challengeRank/index.html?time=" + System.currentTimeMillis());
        c.c("force_inner_browser", true);
        c.b(profileHeaderHolder.rankingTxt.getContext());
        us.pinguo.foundation.statistics.h.a.w("profile_rank_entrance", "click");
    }

    private int getWillShowStyle(ProfileHeaderTabView.State state) {
        Context context = this.mHeaderHolder.avatar.getContext();
        boolean z = state == ProfileHeaderTabView.State.STORY;
        if (isMyProfile()) {
            if ((z ? sMineStoryShowType : sMineLikeShowType) == 1) {
                if (z) {
                    sMineStoryShowType = 0;
                } else {
                    sMineLikeShowType = 0;
                }
                showGridIcon(context);
                return 0;
            }
            if (z) {
                sMineStoryShowType = 1;
            } else {
                sMineLikeShowType = 1;
            }
            showTimeLineIcon(context);
            return 1;
        }
        if ((z ? sGuestStoryShowType : sGuestLikeShowType) == 1) {
            if (z) {
                sGuestStoryShowType = 0;
            } else {
                sGuestLikeShowType = 0;
            }
            showGridIcon(context);
            return 0;
        }
        if (z) {
            sGuestStoryShowType = 1;
        } else {
            sGuestLikeShowType = 1;
        }
        showTimeLineIcon(context);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i(View view) {
        if (f0.b(((ProfileAuthorInfo) this.mData).userId, s0.getInstance().getUserId())) {
            Activity d2 = ActivityRecorder.getInstance().d();
            Intent intent = new Intent(d2, InspireMessageCommentActivity.class);
            intent.putExtra("KEY_MESSAGE_TYPE", MessageType.FLOWER);
            d2.startActivity(intent);
            us.pinguo.foundation.statistics.h.a.w("profile_message_flowers_entrance", "click");
        }
    }

    private void handleHeaderInfo(final ProfileHeaderHolder profileHeaderHolder) {
        profileHeaderHolder.btnSwitch.getContext();
        setWorkCountTxt();
        showDefaultStyleIcon();
        profileHeaderHolder.avatar.setImageUri(((ProfileAuthorInfo) this.mData).avatar, us.pinguo.ui.R.drawable.default_avatar);
        profileHeaderHolder.authorName.setText(((ProfileAuthorInfo) this.mData).nickname);
        if (TextUtils.isEmpty(((ProfileAuthorInfo) this.mData).desc) && isMyProfile()) {
            User d2 = User.d();
            profileHeaderHolder.motto.setText(d2.h() == null ? "" : d2.h().description);
        } else {
            profileHeaderHolder.motto.setText(((ProfileAuthorInfo) this.mData).desc);
        }
        profileHeaderHolder.cover.setSize(us.pinguo.foundation.t.b.a.j(profileHeaderHolder.cover.getContext()), us.pinguo.foundation.t.b.a.a(profileHeaderHolder.cover.getContext(), 244.0f));
        if (!TextUtils.isEmpty(((ProfileAuthorInfo) this.mData).backgroundPic) || !isMyProfile()) {
            profileHeaderHolder.cover.setImageUri(((ProfileAuthorInfo) this.mData).backgroundPic, us.pinguo.user.R.drawable.profile_header_default_bg);
        } else {
            User d3 = User.d();
            profileHeaderHolder.cover.setImageUri(d3.h() == null ? "" : d3.h().backgroundPic, us.pinguo.user.R.drawable.profile_header_default_bg);
        }
        if (((ProfileAuthorInfo) this.mData).geo != null) {
            InspireLocationManager inspireLocationManager = InspireLocationManager.getInstance();
            T t = this.mData;
            inspireLocationManager.getGeo(((ProfileAuthorInfo) t).geo.country, ((ProfileAuthorInfo) t).geo.province, ((ProfileAuthorInfo) t).geo.city, new InspireLocationManager.LocationResultListener() { // from class: us.pinguo.inspire.module.profile.cell.ProfileHeaderCell.1
                @Override // us.pinguo.inspire.module.profile.InspireLocationManager.LocationResultListener
                public void onResult(InspireGeo inspireGeo) {
                    profileHeaderHolder.location.setText(inspireGeo == null ? "" : inspireGeo.toString());
                }
            });
        } else {
            profileHeaderHolder.location.setText("");
        }
        profileHeaderHolder.mHeaderTabView.setAttentionCount(((ProfileAuthorInfo) this.mData).followCount);
        profileHeaderHolder.mHeaderTabView.setFansCount(((ProfileAuthorInfo) this.mData).fansCount);
        profileHeaderHolder.mHeaderTabView.setLikeCount(((ProfileAuthorInfo) this.mData).likeSum);
        profileHeaderHolder.mHeaderTabView.setStoryCount(((ProfileAuthorInfo) this.mData).picSum);
        profileHeaderHolder.mHeaderTabView.setFlowerCount(((ProfileAuthorInfo) this.mData).flowerWorkCount);
        profileHeaderHolder.mHeaderTabView.setSelectTabFromState(this.mState);
        T t2 = this.mData;
        if (((ProfileAuthorInfo) t2).gender == 1) {
            profileHeaderHolder.genderView.setVisibility(0);
            profileHeaderHolder.genderView.setImageResource(us.pinguo.user.R.drawable.profile_gender_mile);
        } else if (((ProfileAuthorInfo) t2).gender == 2) {
            profileHeaderHolder.genderView.setVisibility(0);
            profileHeaderHolder.genderView.setImageResource(us.pinguo.user.R.drawable.profile_gender_femile);
        } else {
            profileHeaderHolder.genderView.setVisibility(8);
        }
        y0.c r = User.d().r(false);
        if (User.d().n() && User.d().h().userId.equals(((ProfileAuthorInfo) this.mData).userId) && r != null && r.d()) {
            profileHeaderHolder.vipImg.setVisibility(0);
        } else {
            profileHeaderHolder.vipImg.setVisibility(8);
        }
        profileHeaderHolder.avatar.setUserType(((ProfileAuthorInfo) this.mData).type);
        profileHeaderHolder.avatar.setMark(((ProfileAuthorInfo) this.mData).mark);
        T t3 = this.mData;
        if (((ProfileAuthorInfo) t3).type == 0) {
            profileHeaderHolder.master.setVisibility(8);
            profileHeaderHolder.profile_user_desc.setVisibility(8);
        } else if (((ProfileAuthorInfo) t3).type == 101) {
            profileHeaderHolder.master.setVisibility(0);
            profileHeaderHolder.master.setBackgroundResource(R.drawable.offical_authority_modiy);
            profileHeaderHolder.master.setText(this.activity.getString(R.string.offical_authority_msg));
            profileHeaderHolder.profile_user_desc.setVisibility(8);
        } else {
            profileHeaderHolder.master.setVisibility(0);
            profileHeaderHolder.profile_user_desc.setVisibility(8);
            if (TextUtils.isEmpty(((ProfileAuthorInfo) this.mData).typeIntro)) {
                profileHeaderHolder.master.setText("");
                profileHeaderHolder.master.setVisibility(4);
            } else {
                profileHeaderHolder.master.setText(((ProfileAuthorInfo) this.mData).typeIntro);
            }
            profileHeaderHolder.master.setBackgroundResource(R.drawable.master_text_bg_modiy);
        }
        profileHeaderHolder.master.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.profile.cell.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileHeaderCell.this.b(view);
            }
        });
        if (((ProfileAuthorInfo) this.mData).type != 0) {
            boolean z = Inspire.c().getBoolean(Common.masterKey, true);
            boolean z2 = Inspire.c().getBoolean(Common.authorityKey, true);
            if (((ProfileAuthorInfo) this.mData).type == 101) {
                Inspire.c().edit().putBoolean(Common.authorityKey, false).commit();
                z = z2;
            } else {
                Inspire.c().edit().putBoolean(Common.masterKey, false).commit();
            }
            if (z) {
                this.activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: us.pinguo.inspire.module.profile.cell.ProfileHeaderCell.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (Build.VERSION.SDK_INT >= 16) {
                            ProfileHeaderCell.this.activity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        } else {
                            ProfileHeaderCell.this.activity.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        }
                    }
                });
            }
        }
    }

    public static void restore() {
        sMineStoryShowType = 1;
        sMineLikeShowType = 0;
        sGuestStoryShowType = 0;
        sGuestLikeShowType = 0;
    }

    private void setWorkCountTxt() {
        ProfileHeaderHolder profileHeaderHolder = this.mHeaderHolder;
        if (profileHeaderHolder == null) {
            return;
        }
        Context context = profileHeaderHolder.btnSwitch.getContext();
        ProfileHeaderTabView.State state = this.mState;
        if (state == ProfileHeaderTabView.State.STORY) {
            try {
                this.mHeaderHolder.btnSwitch.setText(String.format(context.getString(R.string.profile_work_sum), Integer.valueOf(((ProfileAuthorInfo) this.mData).picSum)));
            } catch (Exception e2) {
                this.mHeaderHolder.btnSwitch.setText("");
                e2.printStackTrace();
            }
        } else if (state == ProfileHeaderTabView.State.LIKE) {
            try {
                this.mHeaderHolder.btnSwitch.setText(String.format(context.getResources().getString(R.string.profile_like_sum), Integer.valueOf(((ProfileAuthorInfo) this.mData).likeSum)));
            } catch (Exception e3) {
                this.mHeaderHolder.btnSwitch.setText("");
                e3.printStackTrace();
            }
        } else if (state == ProfileHeaderTabView.State.FLOWER) {
            try {
                this.mHeaderHolder.btnSwitch.setText(String.format(context.getString(R.string.profile_flower_work), Integer.valueOf(((ProfileAuthorInfo) this.mData).flowerWorkCount)));
            } catch (Exception e4) {
                this.mHeaderHolder.btnSwitch.setText("");
                e4.printStackTrace();
            }
        }
    }

    private void showDefaultStyleIcon() {
        Context context = this.mHeaderHolder.avatar.getContext();
        boolean z = ProfileHeaderTabView.State.STORY == this.mState;
        if (isMyProfile()) {
            if ((z ? sMineStoryShowType : sMineLikeShowType) == 0) {
                showGridIcon(context);
                return;
            } else {
                showTimeLineIcon(context);
                return;
            }
        }
        if ((z ? sGuestStoryShowType : sGuestLikeShowType) == 0) {
            showGridIcon(context);
        } else {
            showTimeLineIcon(context);
        }
    }

    private void showGridIcon(Context context) {
        Drawable drawable = context.getResources().getDrawable(R.drawable.profile_switch_grid);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.mHeaderHolder.btnSwitch.setCompoundDrawables(null, null, drawable, null);
    }

    private void showTimeLineIcon(Context context) {
        Drawable drawable = context.getResources().getDrawable(R.drawable.profile_switch_time_line);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.mHeaderHolder.btnSwitch.setCompoundDrawables(null, null, drawable, null);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new ProfileHeaderHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_work_header, (ViewGroup) null));
    }

    public PhotoImageView getCover() {
        ProfileHeaderHolder profileHeaderHolder = this.mHeaderHolder;
        if (profileHeaderHolder != null) {
            return profileHeaderHolder.cover;
        }
        return null;
    }

    public FeedsInterestCell getFeedsInterestCell() {
        return this.mFeedsInterestCell;
    }

    @Override // us.pinguo.inspire.cell.recycler.d
    public View getHeaderView() {
        return getCover();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    public boolean isMyProfile() {
        if (TextUtils.isEmpty(((ProfileAuthorInfo) this.mData).userId)) {
            return false;
        }
        return ((ProfileAuthorInfo) this.mData).userId.equals(s0.getInstance().getUserId());
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        String valueOf;
        if (this.mData == 0) {
            return;
        }
        final ProfileHeaderHolder profileHeaderHolder = (ProfileHeaderHolder) cVar;
        this.mHeaderHolder = profileHeaderHolder;
        handleHeaderInfo(profileHeaderHolder);
        profileHeaderHolder.btnSwitch.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.profile.cell.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileHeaderCell.this.d(view);
            }
        });
        PortraitImageView portraitImageView = profileHeaderHolder.avatar;
        if (portraitImageView != null) {
            portraitImageView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.profile.cell.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileHeaderCell.this.f(view);
                }
            });
        }
        profileHeaderHolder.mHeaderTabView.setOnTabViewSelectListener(this.mOnTabViewSelectListener);
        FeedsInterestCell feedsInterestCell = this.mFeedsInterestCell;
        List<Recommend> data = feedsInterestCell == null ? null : feedsInterestCell.getData();
        this.mFeedsInterestCell = null;
        bindInterestData(data);
        ContentInfoCell.Companion.updateRanking(profileHeaderHolder.rankingTxt, ((ProfileAuthorInfo) this.mData).ranking, null);
        profileHeaderHolder.rankingTxt.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.profile.cell.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileHeaderCell.g(ProfileHeaderCell.ProfileHeaderHolder.this, view);
            }
        });
        int i2 = ((ProfileAuthorInfo) this.mData).getFlowerSum;
        if (i2 <= 0) {
            profileHeaderHolder.flowerTxt.setVisibility(8);
            return;
        }
        profileHeaderHolder.flowerTxt.setVisibility(0);
        TextView textView = profileHeaderHolder.flowerTxt;
        if (u.a()) {
            valueOf = i2 + "朵";
        } else {
            valueOf = String.valueOf(i2);
        }
        textView.setText(valueOf);
        profileHeaderHolder.flowerTxt.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.profile.cell.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileHeaderCell.this.i(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onDestroyView() {
        super.onDestroyView();
        this.mHeaderHolder = null;
        this.mOnHeaderSwitchListener = null;
        this.mOnTabViewSelectListener = null;
    }

    public void onEvent(ShowProfileRecommendEvent showProfileRecommendEvent) {
        if (this.mHeaderHolder != null) {
            if (!((ProfileAuthorInfo) this.mData).userId.equals(showProfileRecommendEvent.a)) {
                this.mHeaderHolder.mRecommendView.setVisibility(8);
                return;
            }
            us.pinguo.common.log.a.m("FK", "show Profile Recommend................" + ((ProfileAuthorInfo) this.mData).userId, new Object[0]);
            bindInterestData(showProfileRecommendEvent.b);
        }
    }

    public void onInterestClose() {
        this.mFeedsInterestCell = null;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        super.releaseResource();
    }

    public void setFeedsInterestCell(FeedsInterestCell feedsInterestCell) {
        this.mFeedsInterestCell = feedsInterestCell;
    }

    public void setOnHeaderSwitchListener(ProfileAdapter.OnHeaderSwitchListener onHeaderSwitchListener) {
        if (this.mDestroyed) {
            return;
        }
        this.mOnHeaderSwitchListener = onHeaderSwitchListener;
    }

    public void setOnTabViewSelectListener(ProfileHeaderTabView.OnTabViewSelectListener onTabViewSelectListener) {
        if (this.mDestroyed) {
            return;
        }
        this.mOnTabViewSelectListener = onTabViewSelectListener;
    }

    public void setState(ProfileHeaderTabView.State state) {
        this.mState = state;
        setWorkCountTxt();
    }

    public void updateIcon() {
        ProfileHeaderHolder profileHeaderHolder = this.mHeaderHolder;
        if (profileHeaderHolder == null || profileHeaderHolder.avatar == null) {
            return;
        }
        showDefaultStyleIcon();
    }

    public void updateVipIcon(boolean z) {
        ProfileHeaderHolder profileHeaderHolder = this.mHeaderHolder;
        if (profileHeaderHolder != null) {
            if (z) {
                profileHeaderHolder.vipImg.setVisibility(0);
            } else {
                profileHeaderHolder.vipImg.setVisibility(8);
            }
        }
    }
}
