package us.pinguo.librouter.module.inspire;

import androidx.fragment.app.Fragment;
/* compiled from: IPortalPager.java */
/* loaded from: classes5.dex */
public interface c {
    void clearNewStatus();

    Fragment getFragment();

    void onAdvDataChange();

    boolean onBackPressed();

    void onLogin();

    void onLogout();

    void onSelected();

    void onTabClickWhenSelected();

    void onUnSelected();

    void releaseResource();

    void reloadResource();
}
