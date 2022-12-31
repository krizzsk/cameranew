package com.pinguo.camera360.lib.camera.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.foundation.e;
import us.pinguo.foundation.utils.n0;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.ui.widget.AutofitTextView;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class FreshGuideView extends ViewGroup {
    private int a;
    private int b;
    private GuideType c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f6823d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f6824e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f6825f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f6826g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6827h;

    /* loaded from: classes3.dex */
    public enum GuideType {
        CLICK_PREVIEW,
        COLLECT_EFFECT,
        ADVANCE_PARAM,
        FUNNY_EXCHANGE,
        PORTRAIT_SOFTEN_STRENGTH,
        FUNNY_EDIT,
        STORE_FILTER_MANAGER;
        
        public static final int FUNNY_EXCHANGE_EFFECT = 0;
        public static final int FUNNY_EXCHANGE_TEMPLATE = 1;
        private int mSubType = 0;

        GuideType() {
        }

        public int getSubType() {
            return this.mSubType;
        }

        public void setSubType(int i2) {
            this.mSubType = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FreshGuideView.this.f6827h) {
                return true;
            }
            if (motionEvent.getAction() == 0) {
                FreshGuideView freshGuideView = FreshGuideView.this;
                freshGuideView.setVisibility(8);
                VdsAgent.onSetViewVisibility(freshGuideView, 8);
                return false;
            }
            return false;
        }
    }

    public FreshGuideView(Context context) {
        super(context);
        this.a = 0;
        this.b = 0;
        this.c = null;
        this.f6823d = null;
        this.f6824e = null;
        this.f6825f = null;
        this.f6826g = null;
        this.f6827h = false;
        b();
    }

    private void b() {
        this.f6823d = new ImageView(getContext());
        this.f6823d.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(this.f6823d);
        this.f6824e = new ImageView(getContext());
        this.f6824e.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(this.f6824e);
        AutofitTextView autofitTextView = new AutofitTextView(getContext());
        this.f6825f = autofitTextView;
        autofitTextView.setSizeToFit();
        this.f6825f.setTextColor(getResources().getColor(R.color.white));
        this.f6825f.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f6825f.setTextSize(15.0f);
        this.f6825f.setGravity(17);
        addView(this.f6825f);
        AutofitTextView autofitTextView2 = new AutofitTextView(getContext());
        this.f6826g = autofitTextView2;
        autofitTextView2.setSizeToFit();
        this.f6826g.setTextColor(getResources().getColor(R.color.white));
        this.f6826g.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f6826g.setTextSize(16.0f);
        this.f6826g.setGravity(8388627);
        this.f6826g.setMaxLines(1);
        this.f6826g.setPadding(0, us.pinguo.foundation.t.b.a.a(getContext(), 6.0f), 0, 0);
        addView(this.f6826g);
        c();
    }

    private void c() {
        setOnTouchListener(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.c == null) {
            return;
        }
        int measuredWidth = this.f6824e.getMeasuredWidth();
        int measuredHeight = this.f6824e.getMeasuredHeight();
        int measuredWidth2 = this.f6823d.getMeasuredWidth();
        int measuredHeight2 = this.f6823d.getMeasuredHeight();
        GuideType guideType = this.c;
        if (guideType == GuideType.CLICK_PREVIEW) {
            int i6 = this.a - (measuredWidth / 2);
            int i7 = this.b - (measuredHeight / 2);
            this.f6824e.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            int max = Math.max(this.a - (measuredWidth2 / 2), 0);
            int a2 = (i7 - measuredHeight2) + us.pinguo.foundation.t.b.a.a(getContext(), 13.0f);
            this.f6823d.layout(max, a2, measuredWidth2 + max, measuredHeight2 + a2);
        } else if (guideType == GuideType.COLLECT_EFFECT) {
            int d2 = (this.a - (measuredWidth / 2)) - n0.d(10.0f);
            int d3 = (this.b - (measuredHeight / 2)) - n0.d(10.0f);
            int i8 = measuredWidth + d2;
            int i9 = measuredHeight + d3;
            this.f6824e.layout(d2, d3, i8, i9);
            int a3 = i8 - us.pinguo.foundation.t.b.a.a(getContext(), 10.0f);
            int i10 = a3 >= 0 ? a3 : 0;
            int a4 = (i9 - measuredHeight2) + us.pinguo.foundation.t.b.a.a(getContext(), 12.0f);
            this.f6823d.layout(i10, a4, measuredWidth2 + i10, measuredHeight2 + a4);
        } else if (guideType == GuideType.FUNNY_EXCHANGE) {
            int i11 = this.a - (measuredWidth / 2);
            int i12 = this.b - (measuredHeight / 2);
            this.f6824e.layout(i11, i12, measuredWidth + i11, measuredHeight + i12);
            int c = (i11 - measuredWidth2) + n0.c(25);
            int i13 = this.b - (measuredHeight2 / 2);
            this.f6823d.layout(c, i13, measuredWidth2 + c, measuredHeight2 + i13);
        } else if (guideType == GuideType.PORTRAIT_SOFTEN_STRENGTH) {
            int i14 = this.a - measuredWidth;
            int i15 = this.b - measuredHeight;
            int i16 = measuredHeight + i15;
            this.f6824e.layout(i14, i15, measuredWidth + i14, i16);
            int a5 = (this.a - (measuredWidth2 / 2)) - us.pinguo.foundation.t.b.a.a(getContext(), 10.0f);
            int a6 = i16 + us.pinguo.foundation.t.b.a.a(getContext(), 10.0f);
            this.f6823d.layout(a5, a6, measuredWidth2 + a5, measuredHeight2 + a6);
        } else if (guideType == GuideType.STORE_FILTER_MANAGER) {
            int i17 = this.a - measuredWidth;
            int i18 = this.b;
            Context b = e.b();
            if (us.pinguo.foundation.t.b.a.m(b)) {
                i17 = us.pinguo.foundation.t.b.a.j(b) - i17;
            }
            int i19 = measuredHeight + i18;
            this.f6824e.layout(i17, i18, i17 + measuredWidth, i19);
            int a7 = this.a + us.pinguo.foundation.t.b.a.a(b, 7.0f);
            int j2 = us.pinguo.foundation.t.b.a.j(b) - us.pinguo.foundation.t.b.a.a(b, 20.0f);
            if (us.pinguo.foundation.t.b.a.m(b)) {
                j2 -= measuredWidth;
                this.f6826g.setGravity(5);
            }
            this.f6826g.layout(a7, i18, j2, i19);
        } else if (guideType == GuideType.FUNNY_EDIT) {
            int a8 = us.pinguo.foundation.t.b.a.a(BaseApplication.d(), 100.0f);
            int a9 = us.pinguo.foundation.t.b.a.a(BaseApplication.d(), 30.0f);
            int measuredWidth3 = getMeasuredWidth();
            int i20 = (measuredWidth3 - measuredWidth) / 2;
            int measuredHeight3 = ((getMeasuredHeight() - measuredHeight) / 2) - a8;
            int i21 = measuredHeight + measuredHeight3;
            this.f6824e.layout(i20, measuredHeight3, measuredWidth + i20, i21);
            int i22 = (measuredWidth3 - measuredWidth2) / 2;
            int i23 = i21 + a9;
            this.f6823d.layout(i22, i23, measuredWidth2 + i22, measuredHeight2 + i23);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        Drawable background = this.f6824e.getBackground();
        if (background == null) {
            background = this.f6824e.getDrawable();
        }
        if (background != null) {
            this.f6824e.measure(View.MeasureSpec.makeMeasureSpec(background.getIntrinsicWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(background.getIntrinsicHeight(), 1073741824));
        }
        Drawable background2 = this.f6823d.getBackground();
        if (background2 == null) {
            background2 = this.f6823d.getDrawable();
        }
        if (background2 != null) {
            this.f6823d.measure(View.MeasureSpec.makeMeasureSpec(background2.getIntrinsicWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(background2.getIntrinsicHeight(), 1073741824));
        }
        this.f6825f.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
    }

    public FreshGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 0;
        this.c = null;
        this.f6823d = null;
        this.f6824e = null;
        this.f6825f = null;
        this.f6826g = null;
        this.f6827h = false;
        b();
    }

    public FreshGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 0;
        this.b = 0;
        this.c = null;
        this.f6823d = null;
        this.f6824e = null;
        this.f6825f = null;
        this.f6826g = null;
        this.f6827h = false;
        b();
    }
}
