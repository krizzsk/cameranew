package us.pinguo.inspire.module.attention;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.user.ui.view.CompatibleToolbar;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class AttentionActivity extends InspireBaseActivity implements View.OnClickListener {
    public static final String FROM_ATTENTION = "from_attention";
    public static final String FROM_FANS = "from_fans";
    public static final String FROM_KEY = "form_key";
    private ImageView mBtnBack;
    private String mFrom;
    private TextView mTitle;

    private void addFragment() {
        InsprieAttentionFragment insprieAttentionFragment = new InsprieAttentionFragment();
        insprieAttentionFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.attention_container, insprieAttentionFragment).commit();
    }

    private void initView() {
        this.mFrom = getIntent().getStringExtra(FROM_KEY);
        CompatibleToolbar compatibleToolbar = (CompatibleToolbar) findViewById(R.id.attention_toolbar);
        compatibleToolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        compatibleToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.attention.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AttentionActivity.this.r0(view);
            }
        });
        compatibleToolbar.setTitleTextAppearance(this, us.pinguo.user.R.style.ToolBar_TextSize);
        if (TextUtils.isEmpty(this.mFrom)) {
            return;
        }
        if (this.mFrom.equals(FROM_ATTENTION)) {
            compatibleToolbar.setTitle(R.string.un_attention);
            addFragment();
            return;
        }
        compatibleToolbar.setTitle(R.string.fans);
        addFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(View view) {
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBtnBack) {
            onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.attention_layout);
        initView();
    }
}
