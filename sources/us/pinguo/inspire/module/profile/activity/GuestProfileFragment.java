package us.pinguo.inspire.module.profile.activity;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import us.pinguo.foundation.utils.g0;
import us.pinguo.inspire.module.profile.cell.ProfileHeaderCell;
/* loaded from: classes9.dex */
public class GuestProfileFragment extends ProfileMyFragment {
    public static final String USER_ID = "userId";
    private String mUserId;

    public static boolean checkIsFollows(int i2) {
        return i2 == 3 || i2 == 1;
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment
    protected int getCurrentShowStyle(boolean z) {
        if (z) {
            return ProfileHeaderCell.sGuestStoryShowType;
        }
        return ProfileHeaderCell.sGuestLikeShowType;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "Community_Mine_ProfileGuest_Page";
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment
    public String getUserId() {
        return this.mUserId;
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment
    public boolean handleLogin() {
        return false;
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void loginout() {
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment, us.pinguo.librouter.module.inspire.c
    public void onAdvDataChange() {
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUserId = arguments.getString(USER_ID);
        }
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment, us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        g0.b();
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment, us.pinguo.librouter.module.inspire.c
    public void onLogin() {
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment, us.pinguo.librouter.module.inspire.c
    public void onLogout() {
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment, us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment, us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment, us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        replaceTitle(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void replaceTitle(View view) {
        super.replaceTitle(null);
    }
}
