package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class TitleView extends RelativeLayout {
    public ImageView a;
    private View b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f7060d;

    /* renamed from: e  reason: collision with root package name */
    private d f7061e;

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (TitleView.this.f7061e != null) {
                TitleView.this.f7061e.f();
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (TitleView.this.f7061e != null) {
                TitleView.this.f7061e.W();
            }
        }
    }

    /* loaded from: classes3.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (TitleView.this.f7061e != null) {
                TitleView.this.f7061e.W();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void W();

        void f();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.c = (TextView) findViewById(R.id.title_text_title_res_0x7f090789);
        this.b = findViewById(R.id.title_back_btn_res_0x7f090780);
        this.f7060d = (TextView) findViewById(R.id.title_right_btn_res_0x7f090785);
        this.a = (ImageView) findViewById(R.id.title_right_img_btn);
        if (isInEditMode()) {
            return;
        }
        this.b.setOnClickListener(new a());
        this.f7060d.setOnClickListener(new b());
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setOnClickListener(new c());
        }
    }

    public void setOnTitleViewClickListener(d dVar) {
        this.f7061e = dVar;
    }

    public void setRightBtnEnable(boolean z) {
        this.f7060d.setEnabled(z);
    }

    public void setRightBtnText(int i2) {
        this.f7060d.setText(i2);
    }

    public void setRightImageBtnRes(int i2) {
        this.a.setImageResource(i2);
    }

    public void setTiTleText(int i2) {
        this.c.setText(i2);
    }

    public void setTitleTextColor(int i2) {
        this.c.setTextColor(i2);
    }

    public void setTitleTextSize(float f2) {
        this.c.setTextSize(0, f2);
    }

    public TitleView(Context context) {
        this(context, null);
    }

    public void setTiTleText(CharSequence charSequence) {
        this.c.setText(charSequence);
    }
}
