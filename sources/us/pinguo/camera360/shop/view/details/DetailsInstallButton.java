package us.pinguo.camera360.shop.view.details;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.vip.VipManager;
import vStudio.Android.Camera360.R;
/* loaded from: classes4.dex */
public class DetailsInstallButton extends RelativeLayout {
    private int a;
    private e b;
    private ProgressButton c;

    /* renamed from: d  reason: collision with root package name */
    private ViewGroup f9736d;

    /* renamed from: e  reason: collision with root package name */
    private Button f9737e;

    /* renamed from: f  reason: collision with root package name */
    private Button f9738f;

    public DetailsInstallButton(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(View view) {
        VdsAgent.lambdaOnClick(view);
        e eVar = this.b;
        if (eVar != null) {
            int i2 = this.a;
            if (i2 == 1) {
                eVar.d(view);
            } else if (i2 == 4) {
                eVar.b(view);
            } else if (i2 == 2) {
                eVar.c(view);
            } else if (i2 == 8) {
                if (VipManager.a.e(true)) {
                    this.b.d(view);
                } else {
                    this.b.a(view);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(View view) {
        VdsAgent.lambdaOnClick(view);
        e eVar = this.b;
        if (eVar != null) {
            eVar.e(view);
        }
    }

    private void e(int i2) {
        this.c.setProgressDrawableColor(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (us.pinguo.util.c.f12472f && getBackground() != null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            setAlpha(0.4f);
        } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            setAlpha(0.4f);
        } else {
            setAlpha(1.0f);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void f() {
        this.b.d(this.f9737e);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.c = (ProgressButton) findViewById(R.id.progress_btn);
        this.f9736d = (ViewGroup) findViewById(R.id.layout_vip_progress);
        this.f9737e = (Button) findViewById(R.id.tv_vip_free);
        this.f9738f = (Button) findViewById(R.id.tv_unlock);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: us.pinguo.camera360.shop.view.details.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailsInstallButton.this.b(view);
            }
        };
        this.c.setOnClickListener(onClickListener);
        this.f9738f.setOnClickListener(onClickListener);
        this.f9737e.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.view.details.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailsInstallButton.this.d(view);
            }
        });
    }

    public void setOnInstallBtnClickListener(e eVar) {
        this.b = eVar;
    }

    public void setProgress(int i2) {
        this.c.setProgress(i2);
    }

    public void setState(boolean z, int i2, CharSequence charSequence) {
        if (i2 != 4) {
            if (i2 == 2) {
                this.c.setProgress(100);
            } else {
                this.c.setProgress(0);
            }
        }
        if (z) {
            VipManager vipManager = VipManager.a;
            boolean I = vipManager.I();
            boolean e2 = vipManager.e(true);
            if (i2 == 1) {
                ProgressButton progressButton = this.c;
                progressButton.setVisibility(0);
                VdsAgent.onSetViewVisibility(progressButton, 0);
                ViewGroup viewGroup = this.f9736d;
                viewGroup.setVisibility(8);
                VdsAgent.onSetViewVisibility(viewGroup, 8);
                this.c.setText(charSequence);
                e(-6463489);
            } else if (i2 == 2 || i2 == 4) {
                ProgressButton progressButton2 = this.c;
                progressButton2.setVisibility(0);
                VdsAgent.onSetViewVisibility(progressButton2, 0);
                ViewGroup viewGroup2 = this.f9736d;
                viewGroup2.setVisibility(8);
                VdsAgent.onSetViewVisibility(viewGroup2, 8);
                this.c.setText(charSequence);
            } else if (i2 == 8) {
                if (!I && !e2) {
                    ProgressButton progressButton3 = this.c;
                    progressButton3.setVisibility(8);
                    VdsAgent.onSetViewVisibility(progressButton3, 8);
                    ViewGroup viewGroup3 = this.f9736d;
                    viewGroup3.setVisibility(0);
                    VdsAgent.onSetViewVisibility(viewGroup3, 0);
                    this.f9738f.setText(charSequence);
                } else {
                    ViewGroup viewGroup4 = this.f9736d;
                    viewGroup4.setVisibility(8);
                    VdsAgent.onSetViewVisibility(viewGroup4, 8);
                    ProgressButton progressButton4 = this.c;
                    progressButton4.setVisibility(0);
                    VdsAgent.onSetViewVisibility(progressButton4, 0);
                }
                if (!I && !e2) {
                    this.c.setText(charSequence);
                } else {
                    this.c.setText(R.string.free_download);
                }
            }
            e(-6463489);
        } else {
            ProgressButton progressButton5 = this.c;
            progressButton5.setVisibility(0);
            VdsAgent.onSetViewVisibility(progressButton5, 0);
            ViewGroup viewGroup5 = this.f9736d;
            viewGroup5.setVisibility(8);
            VdsAgent.onSetViewVisibility(viewGroup5, 8);
            this.c.setText(charSequence);
            e(-670440);
        }
        this.a = i2;
        invalidate();
    }

    public void setTextSize(float f2) {
        this.c.setTextSize(f2);
    }

    public DetailsInstallButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 4;
    }

    public void setTextSize(int i2, float f2) {
        this.c.setTextSize(i2, f2);
    }
}
