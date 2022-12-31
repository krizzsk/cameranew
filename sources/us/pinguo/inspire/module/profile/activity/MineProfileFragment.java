package us.pinguo.inspire.module.profile.activity;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import us.pinguo.inspire.module.profile.cell.ProfileHeaderCell;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class MineProfileFragment extends ProfileMyFragment {
    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment
    protected int getCurrentShowStyle(boolean z) {
        if (z) {
            return ProfileHeaderCell.sMineStoryShowType;
        }
        return ProfileHeaderCell.sMineLikeShowType;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "Community_Mine_ProfileOwner_Page";
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment
    public String getUserId() {
        return s0.getInstance().getUserId();
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment
    public boolean handleLogin() {
        return true;
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void loginout() {
        getActivity().finish();
    }

    @Override // us.pinguo.inspire.module.profile.activity.ProfileMyFragment, us.pinguo.librouter.module.inspire.c
    public void onAdvDataChange() {
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
