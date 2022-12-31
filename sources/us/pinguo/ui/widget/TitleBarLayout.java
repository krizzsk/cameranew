package us.pinguo.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class TitleBarLayout extends ViewGroup {
    private View a;
    private View b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f12243d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f12244e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f12245f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f12246g;

    /* renamed from: h  reason: collision with root package name */
    private a f12247h;

    /* loaded from: classes6.dex */
    public interface a {
        void onLeftBtnClick(View view);

        void onRightBtnClick(View view);
    }

    public TitleBarLayout(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.c = 0;
    }

    private void c() {
        this.f12245f = (TextView) findViewById(R.id.title_text_title);
        this.f12244e = (ImageView) findViewById(R.id.title_back_btn);
        this.f12246g = (TextView) findViewById(R.id.title_right_btn);
        this.f12243d = (ImageView) findViewById(R.id.title_right_img_btn);
        this.f12244e.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.ui.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitleBarLayout.this.e(view);
            }
        });
        this.f12246g.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.ui.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitleBarLayout.this.g(view);
            }
        });
        this.f12243d.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.ui.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitleBarLayout.this.i(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(View view) {
        VdsAgent.lambdaOnClick(view);
        a aVar = this.f12247h;
        if (aVar != null) {
            aVar.onLeftBtnClick(view);
        } else if (getContext() instanceof Activity) {
            ((Activity) getContext()).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void g(View view) {
        VdsAgent.lambdaOnClick(view);
        a aVar = this.f12247h;
        if (aVar != null) {
            aVar.onRightBtnClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i(View view) {
        VdsAgent.lambdaOnClick(view);
        a aVar = this.f12247h;
        if (aVar != null) {
            aVar.onRightBtnClick(view);
        }
    }

    protected int a() {
        return R.layout.layout_title_view_md_shadow;
    }

    public void j() {
        TextView textView = this.f12246g;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        this.f12243d.setVisibility(0);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            return;
        }
        ((Activity) getContext()).getLayoutInflater().inflate(a(), (ViewGroup) this, true);
        this.a = findViewById(R.id.title_view_main);
        if (getChildCount() == 2) {
            c();
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

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
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

    public void setLeftImageBtnRes(int i2) {
        this.f12244e.setImageResource(i2);
    }

    public void setOnTitleBarClickListener(a aVar) {
        this.f12247h = aVar;
    }

    public void setRightBtnEnable(boolean z) {
        this.f12246g.setEnabled(z);
    }

    public void setRightBtnText(int i2) {
        this.f12246g.setText(i2);
        TextView textView = this.f12246g;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
    }

    public void setRightBtnTextColor(int i2) {
        this.f12246g.setTextColor(getResources().getColor(i2));
    }

    public void setRightImageBtnEnable(boolean z) {
        this.f12243d.setEnabled(z);
    }

    public void setRightImageBtnRes(int i2) {
        this.f12243d.setImageResource(i2);
    }

    public void setTiTleText(int i2) {
        this.f12245f.setText(i2);
    }

    public void setTitleTextColor(int i2) {
        this.f12245f.setTextColor(i2);
    }

    public void setTitleTextSize(float f2) {
        this.f12245f.setTextSize(0, f2);
    }

    public void setTiTleText(CharSequence charSequence) {
        this.f12245f.setText(charSequence);
    }

    public TitleBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public TitleBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
