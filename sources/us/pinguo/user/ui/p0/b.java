package us.pinguo.user.ui.p0;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import us.pinguo.foundation.e;
import us.pinguo.user.R;
import us.pinguo.user.ui.PGLoginFragment;
import us.pinguo.user.ui.PGRegisterFragment;
/* compiled from: PGLoginPagerAdapter.java */
/* loaded from: classes6.dex */
public class b extends FragmentPagerAdapter {
    public static final int[] a = {0, 1};

    public b(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return a.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return null;
            }
            return new PGRegisterFragment();
        }
        return new PGLoginFragment();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        if (i2 != 0) {
            return i2 != 1 ? "" : e.b().getResources().getString(R.string.login_main_register);
        }
        return e.b().getResources().getString(R.string.pg_login_home_login);
    }
}
