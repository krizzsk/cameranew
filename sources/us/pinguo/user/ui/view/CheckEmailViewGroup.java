package us.pinguo.user.ui.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.ui.e;
import us.pinguo.user.R;
/* loaded from: classes6.dex */
public class CheckEmailViewGroup extends ViewGroup {
    private EditTextWithPrompt a;
    private ImageView b;
    private b c;

    /* renamed from: d  reason: collision with root package name */
    private Animation f12446d;

    /* renamed from: e  reason: collision with root package name */
    private int f12447e;

    /* renamed from: f  reason: collision with root package name */
    private int f12448f;

    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (CheckEmailViewGroup.this.f12447e == 4) {
                CheckEmailViewGroup.this.a.setText("");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (CheckEmailViewGroup.this.b.getVisibility() != 4) {
                        CheckEmailViewGroup.this.b.setVisibility(4);
                        return;
                    }
                    return;
                case 2:
                    if (CheckEmailViewGroup.this.b.getVisibility() != 0) {
                        CheckEmailViewGroup.this.b.setVisibility(0);
                        return;
                    }
                    return;
                case 3:
                    if (CheckEmailViewGroup.this.b.getVisibility() != 0) {
                        CheckEmailViewGroup.this.b.setVisibility(0);
                    }
                    CheckEmailViewGroup.this.b.setImageResource(R.drawable.icon_loading);
                    CheckEmailViewGroup.this.b.startAnimation(CheckEmailViewGroup.this.f12446d);
                    return;
                case 4:
                    CheckEmailViewGroup.this.b.clearAnimation();
                    CheckEmailViewGroup.this.b.setImageResource(R.drawable.person_info_wrong_ic);
                    if (CheckEmailViewGroup.this.b.getVisibility() != 0) {
                        CheckEmailViewGroup.this.b.setVisibility(0);
                        return;
                    }
                    return;
                case 5:
                    CheckEmailViewGroup.this.b.clearAnimation();
                    CheckEmailViewGroup.this.b.setImageResource(R.drawable.person_info_right_ic);
                    if (CheckEmailViewGroup.this.b.getVisibility() != 0) {
                        CheckEmailViewGroup.this.b.setVisibility(0);
                        return;
                    }
                    return;
                case 6:
                    CheckEmailViewGroup.this.b.clearAnimation();
                    if (CheckEmailViewGroup.this.b.getVisibility() != 4) {
                        CheckEmailViewGroup.this.b.setVisibility(4);
                    }
                    new e((Activity) CheckEmailViewGroup.this.getContext(), R.string.bind_email_fail_network_error, 0).d();
                    return;
                default:
                    return;
            }
        }
    }

    public CheckEmailViewGroup(Context context) {
        super(context);
        this.f12447e = 0;
        g(context);
    }

    private void g(Context context) {
        this.f12448f = (int) getResources().getDimension(R.dimen.pg_login_input_height);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_rotate_clockwise);
        this.f12446d = loadAnimation;
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.c = new b();
    }

    public void e() {
        this.c.removeMessages(1);
        this.c.removeMessages(2);
        this.c.removeMessages(3);
        this.c.removeMessages(4);
        this.c.removeMessages(5);
        this.c.removeMessages(6);
    }

    public void f(int i2) {
        this.f12447e = i2;
        this.c.sendEmptyMessage(i2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (EditTextWithPrompt) findViewById(R.id.register_email_edittext);
        ImageView imageView = (ImageView) findViewById(R.id.register_email_edittext_ic);
        this.b = imageView;
        imageView.setOnClickListener(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            this.a.layout(0, 0, i6, i7);
            this.b.layout((i6 - i7) - 20, 0, i6, i7);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        this.b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(this.f12448f, 1073741824));
        setMeasuredDimension(size, this.a.getMeasuredHeight());
    }

    public CheckEmailViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12447e = 0;
        g(context);
    }

    public CheckEmailViewGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12447e = 0;
        g(context);
    }
}
