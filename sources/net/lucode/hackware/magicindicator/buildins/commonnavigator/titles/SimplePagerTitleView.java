package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.TextView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b;
/* loaded from: classes3.dex */
public class SimplePagerTitleView extends TextView implements b {
    protected int a;
    protected int b;

    public SimplePagerTitleView(Context context) {
        super(context, null);
        i(context);
    }

    private void i(Context context) {
        setGravity(17);
        int a = net.lucode.hackware.magicindicator.d.b.a(context, 10.0d);
        setPadding(a, 0, a, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public void a(int i2, int i3) {
        setTextColor(this.b);
    }

    public void b(int i2, int i3, float f2, boolean z) {
    }

    public void c(int i2, int i3) {
        setTextColor(this.a);
    }

    public void d(int i2, int i3, float f2, boolean z) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int e() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int f() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int g() {
        Rect rect = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int h() {
        Rect rect = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    public void setNormalColor(int i2) {
        this.b = i2;
    }

    public void setSelectedColor(int i2) {
        this.a = i2;
    }
}
