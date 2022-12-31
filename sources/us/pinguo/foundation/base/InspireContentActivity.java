package us.pinguo.foundation.base;

import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.foundation.R;
/* loaded from: classes4.dex */
public class InspireContentActivity extends InspireBaseActivity {
    public static final String FRAGMENT_NAME = "Fragment_Name";
    private a onKeyDownListener;

    /* loaded from: classes4.dex */
    public interface a {
        boolean onKeyDown(int i2, KeyEvent keyEvent);
    }

    protected String getFragmentClsName() {
        return getIntent().getStringExtra(FRAGMENT_NAME);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_inspire_content);
        Fragment instantiate = Fragment.instantiate(this, getFragmentClsName());
        instantiate.setArguments(getIntent().getExtras());
        if (instantiate != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            int i2 = R.id.fl_inspire_content;
            FragmentTransaction replace = beginTransaction.replace(i2, instantiate);
            VdsAgent.onFragmentTransactionReplace(beginTransaction, i2, instantiate, replace);
            replace.commitAllowingStateLoss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        a aVar = this.onKeyDownListener;
        if (aVar != null) {
            return aVar.onKeyDown(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void setOnKeyDownListener(a aVar) {
        this.onKeyDownListener = aVar;
    }
}
