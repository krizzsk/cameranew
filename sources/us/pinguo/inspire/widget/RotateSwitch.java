package us.pinguo.inspire.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
/* loaded from: classes9.dex */
public class RotateSwitch extends ImageView implements View.OnClickListener {
    private boolean a;
    private ValueAnimator b;
    private View.OnClickListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RotateSwitch.this.setRotation(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public RotateSwitch(Context context) {
        super(context);
        this.a = false;
        a();
    }

    private void a() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, BaseBlurEffect.ROTATION_180);
        this.b = ofInt;
        ofInt.addUpdateListener(new a());
        this.b.setDuration(300L);
        super.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.isStarted()) {
            this.b.end();
        }
        if (this.a) {
            this.a = false;
        } else {
            this.a = true;
        }
        View.OnClickListener onClickListener = this.c;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public RotateSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        a();
    }

    public RotateSwitch(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = false;
        a();
    }
}
