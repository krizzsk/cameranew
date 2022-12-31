package com.rockerhieu.emoji.expression;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.rockerhieu.emoji.R;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ExpressionTabLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private static int f7108d;
    private Context a;
    private ViewPager b;
    private List<View> c;

    public ExpressionTabLayout(Context context) {
        super(context);
        this.c = new ArrayList();
        this.a = context;
    }

    private void b(int i2) {
        if (i2 < 0 || i2 >= this.c.size()) {
            return;
        }
        View view = this.c.get(i2);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) getParent();
        if (view == null || horizontalScrollView == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int b = a.b(getContext());
        int i3 = iArr[0];
        int width = iArr[0] + view.getWidth();
        if (i3 < 0) {
            horizontalScrollView.smoothScrollBy(i3, 0);
        } else if (width > b) {
            horizontalScrollView.smoothScrollBy(width - b, 0);
        }
    }

    public void a(String str, String str2) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2 = null;
        try {
            bitmapDrawable = new BitmapDrawable(getResources(), str);
            try {
                bitmapDrawable2 = new BitmapDrawable(getResources(), str2);
            } catch (OutOfMemoryError unused) {
            }
        } catch (OutOfMemoryError unused2) {
            bitmapDrawable = null;
        }
        int a = a.a(getContext(), 24.0f);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, bitmapDrawable2);
        stateListDrawable.addState(new int[]{16842919}, bitmapDrawable2);
        stateListDrawable.addState(new int[]{16842910}, bitmapDrawable);
        ImageView imageView = new ImageView(this.a);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageDrawable(stateListDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a, a);
        layoutParams.addRule(13);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        relativeLayout.setBackgroundColor(0);
        relativeLayout.addView(imageView, layoutParams);
        addView(relativeLayout, a.a(this.a, 64.0f), -1);
        int a2 = a.a(getContext(), 1.0f);
        ImageView imageView2 = new ImageView(this.a);
        imageView2.setTag("line");
        imageView2.setImageDrawable(new ColorDrawable(getResources().getColor(R.color.divider_color)));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a2, -1);
        int a3 = a.a(getContext(), 6.0f);
        imageView2.setPadding(0, a3, 0, a3);
        layoutParams2.addRule(11);
        relativeLayout.addView(imageView2, layoutParams2);
        this.c.add(relativeLayout);
        relativeLayout.setOnClickListener(this);
        if (this.c.size() == 1) {
            d(0);
        }
        int i2 = 0;
        while (i2 < getChildCount()) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                childAt.findViewWithTag("line").setVisibility(i2 == getChildCount() - 1 ? 4 : 0);
            }
            i2++;
        }
    }

    public int c() {
        return this.c.size();
    }

    public void d(int i2) {
        if (f7108d == 0) {
            f7108d = getResources().getColor(R.color.expression_bg);
        }
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            ViewGroup viewGroup = (ViewGroup) this.c.get(i3);
            ImageView imageView = (ImageView) viewGroup.getChildAt(0);
            if (i3 == i2) {
                imageView.setSelected(true);
                viewGroup.setBackgroundColor(f7108d);
            } else {
                imageView.setSelected(false);
                viewGroup.setBackgroundColor(0);
            }
        }
        b(i2);
    }

    public void e(ViewPager viewPager) {
        this.b = viewPager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            try {
                e eVar = (e) ((c) this.b.getAdapter()).a(i2).getTag();
                if (this.c.get(i3) == view) {
                    this.b.setCurrentItem(i2);
                    d(eVar.a);
                    return;
                }
                i2 += eVar.c;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    public ExpressionTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList();
        this.a = context;
    }

    public ExpressionTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = new ArrayList();
        this.a = context;
    }
}
