package us.pinguo.inspire.module.profile.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.internal.view.SupportMenu;
import us.pinguo.foundation.base.BaseSplitActivity;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DebugSettingActivity extends BaseSplitActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private boolean mDestroyed = true;
    private boolean mInited;
    private Switch mQASwitch;

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton == this.mQASwitch && this.mInited) {
            getSharedPreferences("debug", 0).edit().putBoolean("isQA", z).commit();
            final TextView textView = new TextView(this);
            textView.setTextSize(2, 30.0f);
            int a = us.pinguo.foundation.t.b.a.a(this, 30.0f);
            textView.setPadding(a, a, a, a);
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setText("3");
            textView.setGravity(17);
            new AlertDialog.Builder(this).setView(textView).setCancelable(false).show();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(4.0f, 0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.profile.activity.DebugSettingActivity.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue > 0) {
                        TextView textView2 = textView;
                        textView2.setText(floatValue + "");
                        return;
                    }
                    textView.setText("beng!!!");
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: us.pinguo.inspire.module.profile.activity.DebugSettingActivity.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!DebugSettingActivity.this.mDestroyed) {
                        throw new RuntimeException("手动切换QA环境");
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            ofFloat.setDuration(2000L);
            ofFloat.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.debug_qa) {
            this.mQASwitch.toggle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mDestroyed = false;
        setContentView(R.layout.debug_setting_layout);
        findViewById(R.id.debug_qa).setOnClickListener(this);
        Switch r2 = (Switch) findViewById(R.id.debug_qa_switch);
        this.mQASwitch = r2;
        r2.setOnCheckedChangeListener(this);
        this.mQASwitch.setChecked(us.pinguo.foundation.d.b);
        runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.profile.activity.DebugSettingActivity.1
            @Override // java.lang.Runnable
            public void run() {
                DebugSettingActivity.this.mInited = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.SubscriptionActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mDestroyed = true;
    }
}
