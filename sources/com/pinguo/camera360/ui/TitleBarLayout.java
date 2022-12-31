package com.pinguo.camera360.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class TitleBarLayout extends ViewGroup {
    private View a;
    private View b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f7023d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f7024e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f7025f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f7026g;

    /* renamed from: h  reason: collision with root package name */
    private a f7027h;

    /* loaded from: classes3.dex */
    public interface a {
        void onLeftBtnClick(View view);

        void onRightBtnClick(View view);
    }

    public TitleBarLayout(Context context) {
        super(context);
        i();
    }

    private void i() {
        this.c = 0;
    }

    private void j() {
        this.f7025f = (TextView) findViewById(R.id.title_text_title_res_0x7f090789);
        this.f7024e = (ImageView) findViewById(R.id.title_back_btn_res_0x7f090780);
        this.f7026g = (TextView) findViewById(R.id.title_right_btn_res_0x7f090785);
        this.f7023d = (ImageView) findViewById(R.id.title_right_img_btn);
        this.f7024e.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitleBarLayout.this.l(view);
            }
        });
        this.f7026g.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitleBarLayout.this.n(view);
            }
        });
        this.f7023d.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.ui.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitleBarLayout.this.p(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(View view) {
        VdsAgent.lambdaOnClick(view);
        a aVar = this.f7027h;
        if (aVar != null) {
            aVar.onLeftBtnClick(view);
        } else if (getContext() instanceof Activity) {
            ((Activity) getContext()).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(View view) {
        VdsAgent.lambdaOnClick(view);
        a aVar = this.f7027h;
        if (aVar != null) {
            aVar.onRightBtnClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(View view) {
        VdsAgent.lambdaOnClick(view);
        a aVar = this.f7027h;
        if (aVar != null) {
            aVar.onRightBtnClick(view);
        }
    }

    protected int c() {
        return R.layout.layout_title_view_md_shadow;
    }

    public ImageView d() {
        return this.f7023d;
    }

    public void e() {
        TextView textView = this.f7026g;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
    }

    public void f() {
        this.f7023d.setVisibility(8);
    }

    public void g() {
        this.f7023d.setVisibility(8);
    }

    public void h() {
        TextView textView = this.f7026g;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            return;
        }
        ((Activity) getContext()).getLayoutInflater().inflate(c(), (ViewGroup) this, true);
        this.a = findViewById(R.id.title_view_main_res_0x7f09078a);
        if (getChildCount() == 2) {
            j();
            this.b = getChildAt(0);
            return;
        }
        throw new IllegalArgumentException("the child counts of this layout must be 2!!!!!");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (isInEditMode()) {
            return;
        }
        View view = this.a;
        view.layout(i2, i3, i4, view.getMeasuredHeight() + i3);
        int measuredHeight = (i3 + this.a.getMeasuredHeight()) - this.c;
        this.b.layout(i2, measuredHeight, this.b.getMeasuredWidth() + i2, this.b.getMeasuredHeight() + measuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (isInEditMode()) {
            return;
        }
        this.a.measure(ViewGroup.getChildMeasureSpec(i2, 0, this.a.getLayoutParams().width), ViewGroup.getChildMeasureSpec(i3, 0, this.a.getLayoutParams().height + this.c));
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec((size - this.a.getMeasuredHeight()) + this.c, mode);
        }
        this.b.measure(ViewGroup.getChildMeasureSpec(i2, 0, this.b.getLayoutParams().width), ViewGroup.getChildMeasureSpec(i3, 0, this.b.getLayoutParams().height));
    }

    public void q() {
        TextView textView = this.f7026g;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        this.f7023d.setVisibility(0);
    }

    public void setLeftImageBtnRes(int i2) {
        this.f7024e.setImageResource(i2);
    }

    public void setOnTitleBarClickListener(a aVar) {
        this.f7027h = aVar;
    }

    public void setRightBtnEnable(boolean z) {
        this.f7026g.setEnabled(z);
    }

    public void setRightBtnText(int i2) {
        this.f7026g.setText(i2);
        TextView textView = this.f7026g;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
    }

    public void setRightBtnTextColor(int i2) {
        this.f7026g.setTextColor(getResources().getColor(i2));
    }

    public void setRightImageBtnEnable(boolean z) {
        this.f7023d.setEnabled(z);
    }

    public void setRightImageBtnRes(int i2) {
        this.f7023d.setImageResource(i2);
    }

    public void setTiTleText(int i2) {
        this.f7025f.setText(i2);
    }

    public void setTitleTextColor(int i2) {
        this.f7025f.setTextColor(i2);
    }

    public void setTitleTextSize(float f2) {
        this.f7025f.setTextSize(0, f2);
    }

    public void setTiTleText(CharSequence charSequence) {
        this.f7025f.setText(charSequence);
    }

    public TitleBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i();
    }

    public TitleBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        i();
    }
}
