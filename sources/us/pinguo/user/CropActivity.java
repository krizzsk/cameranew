package us.pinguo.user;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.foundation.base.BaseSplitActivity;
import us.pinguo.user.ui.view.CompatibleToolbar;
import us.pinguo.user.ui.view.CropImageView;
/* loaded from: classes6.dex */
public class CropActivity extends BaseSplitActivity {
    private CropImageView a;
    private AlertDialog b;
    private boolean c;

    private void q0() {
        this.a.h();
        if (this.a.k()) {
            return;
        }
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.show();
            VdsAgent.showDialog(alertDialog);
        }
        new Thread(new Runnable() { // from class: us.pinguo.user.j
            @Override // java.lang.Runnable
            public final void run() {
                CropActivity.this.u0();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void s0(String str) {
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        Intent intent = new Intent();
        intent.putExtra(PGEditResultActivity2.PATH, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void u0() {
        final String d2 = this.a.d();
        runOnUiThread(new Runnable() { // from class: us.pinguo.user.g
            @Override // java.lang.Runnable
            public final void run() {
                CropActivity.this.s0(d2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void w0(View view) {
        VdsAgent.lambdaOnClick(view);
        q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void y0(View view) {
        VdsAgent.lambdaOnClick(view);
        setResult(0, getIntent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.crop_activity);
        this.c = getIntent().getIntExtra("crop_key", 1) == 1;
        this.b = us.pinguo.ui.b.a.c(this, getResources().getString(R.string.please_wait));
        CropImageView cropImageView = (CropImageView) findViewById(R.id.crop_imageview);
        this.a = cropImageView;
        cropImageView.setCircle(this.c);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PGEditResultActivity2.PATH);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.a.setImageFile(stringExtra);
            }
        }
        CompatibleToolbar compatibleToolbar = (CompatibleToolbar) findViewById(R.id.crop_title_bar);
        if (this.c) {
            compatibleToolbar.setTitle(R.string.change_avatar);
        } else {
            compatibleToolbar.setTitle(R.string.change_cover);
        }
        TextView textView = (TextView) compatibleToolbar.b().findViewById(R.id.tv_right_toolbar);
        textView.setText(us.pinguo.ui.R.string.ok);
        textView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.user.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CropActivity.this.w0(view);
            }
        });
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        textView.setTextColor(-12806145);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        compatibleToolbar.setTitleTextAppearance(this, R.style.ToolBar_TextSize);
        compatibleToolbar.setTitleTextColor(getResources().getColor(us.pinguo.ui.R.color.white));
        compatibleToolbar.b().setBackgroundColor(getResources().getColor(R.color.black_toolbar_color));
        compatibleToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.naivagation_back_white));
        compatibleToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.user.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CropActivity.this.y0(view);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
