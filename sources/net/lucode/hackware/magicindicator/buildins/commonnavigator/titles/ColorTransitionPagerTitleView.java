package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import net.lucode.hackware.magicindicator.d.a;
/* loaded from: classes3.dex */
public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    public ColorTransitionPagerTitleView(Context context) {
        super(context);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void a(int i2, int i3) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void b(int i2, int i3, float f2, boolean z) {
        setTextColor(a.a(f2, this.b, this.a));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void c(int i2, int i3) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void d(int i2, int i3, float f2, boolean z) {
        setTextColor(a.a(f2, this.a, this.b));
    }
}
