package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public abstract class ViewPagerAdapter {
    private MobViewPager parent;

    public abstract int getCount();

    public abstract View getView(int i2, View view, ViewGroup viewGroup);

    public void invalidate() {
        MobViewPager mobViewPager = this.parent;
        if (mobViewPager != null) {
            mobViewPager.setAdapter(this);
        }
    }

    public void onScreenChange(int i2, int i3) {
    }

    public void onScreenChanging(float f2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setMobViewPager(MobViewPager mobViewPager) {
        this.parent = mobViewPager;
    }
}
