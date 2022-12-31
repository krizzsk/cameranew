package us.pinguo.inspire.module.comment.cell;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.Nullable;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class TestActivity extends Activity {
    /* JADX INFO: Access modifiers changed from: private */
    public void showAnim(final View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(R.dimen.info_buy_layout_height);
        view.setLayoutParams(layoutParams);
        ValueAnimator ofInt = ValueAnimator.ofInt(layoutParams.width, getResources().getDimensionPixelSize(R.dimen.info_buy_layout_width));
        ofInt.setInterpolator(new OvershootInterpolator());
        ofInt.setDuration(400L);
        view.setVisibility(0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.comment.cell.TestActivity.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.setLayoutParams(layoutParams2);
            }
        });
        ofInt.start();
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.info_buy_flower_layout);
        final View findViewById = findViewById(R.id.info_buy_flower_layout);
        findViewById.setVisibility(8);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.TestActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TestActivity.this.showAnim(view);
            }
        });
        findViewById.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.comment.cell.TestActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TestActivity.this.showAnim(findViewById);
            }
        }, 3000L);
    }
}
