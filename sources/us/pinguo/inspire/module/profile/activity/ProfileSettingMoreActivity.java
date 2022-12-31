package us.pinguo.inspire.module.profile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import us.pinguo.foundation.base.BaseSplitActivity;
import us.pinguo.user.R;
/* loaded from: classes9.dex */
public class ProfileSettingMoreActivity extends BaseSplitActivity implements View.OnClickListener, View.OnLongClickListener {
    private void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.base_title_back);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.profile.activity.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileSettingMoreActivity.this.r0(view);
            }
        });
        ((TextView) findViewById(R.id.base_title_txt)).setText(us.pinguo.ui.R.string.more);
        findViewById(vStudio.Android.Camera360.R.id.pf_about_layout).setOnClickListener(this);
        findViewById(vStudio.Android.Camera360.R.id.pf_help_layout).setOnClickListener(this);
        findViewById(vStudio.Android.Camera360.R.id.pf_suggestion_layout).setOnClickListener(this);
        if (us.pinguo.foundation.d.f10985d) {
            findViewById(vStudio.Android.Camera360.R.id.pf_about_layout).setOnLongClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(View view) {
        onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == vStudio.Android.Camera360.R.id.pf_suggestion_layout) {
            Intent intent = new Intent();
            intent.setClassName(this, "com.pinguo.camera360.xiaoc.XiaoCActivity");
            startActivity(intent);
        } else if (id == vStudio.Android.Camera360.R.id.pf_help_layout) {
            Intent intent2 = new Intent();
            intent2.setClassName(this, "com.pinguo.camera360.xiaoc.FAQActivity");
            startActivity(intent2);
        } else if (id == vStudio.Android.Camera360.R.id.pf_about_layout) {
            Intent intent3 = new Intent();
            intent3.setClassName(this, "com.pinguo.camera360.camera.options.OptionsAbouts");
            startActivity(intent3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(vStudio.Android.Camera360.R.layout.profile_setting_more_layout);
        initView();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (us.pinguo.foundation.d.f10985d) {
            startActivity(new Intent(this, DebugSettingActivity.class));
            return true;
        }
        return false;
    }
}
