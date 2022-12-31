package com.rockerhieu.emoji.expression;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ExpressionPagerTabAdapter.java */
/* loaded from: classes9.dex */
public class c extends PagerAdapter {
    private List<View> a;

    public c(List<View> list) {
        this.a = new ArrayList();
        this.a = list;
    }

    public View a(int i2) {
        return this.a.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView(this.a.get(i2));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        View view = this.a.get(i2);
        if (view.getParent() == null) {
            viewGroup.addView(view);
        }
        return this.a.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
