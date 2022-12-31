package com.pinguo.camera360.member;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.List;
/* compiled from: MemberFragmentAdapter.kt */
/* loaded from: classes3.dex */
public final class z0 extends FragmentStatePagerAdapter {
    private List<? extends Fragment> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(FragmentManager fm, List<? extends Fragment> list) {
        super(fm, 1);
        kotlin.jvm.internal.s.h(fm, "fm");
        kotlin.jvm.internal.s.h(list, "list");
        this.a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.a.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        return this.a.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int i2) {
        return 1.0f;
    }
}
