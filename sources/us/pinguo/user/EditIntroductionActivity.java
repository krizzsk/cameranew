package us.pinguo.user;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Arrays;
import rx.functions.Action1;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.profile.UserInfoLoader;
import us.pinguo.user.ui.view.CompatibleToolbar;
/* loaded from: classes6.dex */
public class EditIntroductionActivity extends InspireBaseActivity {
    private EditText a;
    private AlertDialog b;
    private String c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f12356d = "";

    /* renamed from: e  reason: collision with root package name */
    private boolean f12357e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            String obj = EditIntroductionActivity.this.a.getText().toString();
            if (EditIntroductionActivity.this.f12357e) {
                if ("".equals(obj.trim())) {
                    us.pinguo.foundation.utils.j0.d(EditIntroductionActivity.this.getString(R.string.nick_name_message));
                    return;
                } else {
                    EditIntroductionActivity.this.H0(obj);
                    return;
                }
            }
            EditIntroductionActivity.this.G0(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0(String str, String str2) {
        s0();
        Toast makeText = Toast.makeText(this, R.string.change_success, 1);
        makeText.show();
        VdsAgent.showToast(makeText);
        Intent intent = new Intent();
        intent.putExtra("nickname", str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void E0(Throwable th) {
        us.pinguo.common.log.a.f(th);
        s0();
        us.pinguo.user.util.i.b(th);
    }

    private void initView() {
        EditText editText = (EditText) findViewById(R.id.edit_introduction);
        this.a = editText;
        editText.setSelection(editText.getText().length());
        this.f12357e = getIntent().getBooleanExtra("isNickeName", false);
        if (getIntent().hasExtra("introduction")) {
            this.c = getIntent().getStringExtra("introduction");
            this.a.setHint(R.string.input_introduction_hint);
        }
        if (getIntent().hasExtra("nickname")) {
            this.f12356d = getIntent().getStringExtra("nickname");
            this.a.setHint(R.string.edit_nickname_hint);
            InputFilter[] filters = this.a.getFilters();
            ArrayList arrayList = new ArrayList();
            if (filters != null) {
                arrayList.addAll(Arrays.asList(filters));
            }
            arrayList.add(new InputFilter.LengthFilter(20));
            this.a.setFilters((InputFilter[]) arrayList.toArray(new InputFilter[arrayList.size()]));
        }
        Toolbar b = ((CompatibleToolbar) findViewById(R.id.toolbar_common)).b();
        b.setTitleTextColor(getResources().getColor(us.pinguo.foundation.R.color.light_main_title_text));
        b.setTitleTextAppearance(this, R.style.ToolBar_TextSize);
        b.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        b.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.user.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditIntroductionActivity.this.u0(view);
            }
        });
        b.setTitle(R.string.publish_preview);
        TextView textView = (TextView) b.findViewById(R.id.tv_right_toolbar);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        textView.setTextColor(-12352018);
        textView.setTextSize(2, 15.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setText(us.pinguo.ui.R.string.complete);
        textView.setOnClickListener(new a());
        if (this.f12357e) {
            this.a.setText(this.f12356d);
            b.setTitle(R.string.edit_nickname);
        } else {
            this.a.setText(this.c);
            b.setTitle(R.string.edit_introduction);
        }
        this.a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: us.pinguo.user.o0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i2, KeyEvent keyEvent) {
                return EditIntroductionActivity.this.w0(textView2, i2, keyEvent);
            }
        });
        this.a.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void u0(View view) {
        VdsAgent.lambdaOnClick(view);
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ boolean w0(TextView textView, int i2, KeyEvent keyEvent) {
        us.pinguo.user.util.k.a(this.a, this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void y0(String str, String str2) {
        us.pinguo.common.log.a.d("zhouwei", "update desc success：" + str2, new Object[0]);
        s0();
        us.pinguo.foundation.utils.j0.c(R.string.change_success);
        Intent intent = new Intent();
        intent.putExtra(SocialConstants.PARAM_APP_DESC, str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void A0(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        s0();
        us.pinguo.user.util.i.b(th);
    }

    public void F0() {
        if (this.b == null) {
            this.b = us.pinguo.ui.b.a.c(this, getResources().getString(R.string.please_wait));
        }
        AlertDialog alertDialog = this.b;
        alertDialog.show();
        VdsAgent.showDialog(alertDialog);
    }

    public void G0(final String str) {
        F0();
        addSubscription(new UserInfoLoader().updateDescription(str).subscribe(new Action1() { // from class: us.pinguo.user.p0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditIntroductionActivity.this.y0(str, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.q0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditIntroductionActivity.this.A0((Throwable) obj);
            }
        }));
    }

    public void H0(final String str) {
        UserInfoLoader userInfoLoader = new UserInfoLoader();
        F0();
        addSubscription(userInfoLoader.updateNickName(str).subscribe(new Action1() { // from class: us.pinguo.user.l0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditIntroductionActivity.this.C0(str, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.n0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditIntroductionActivity.this.E0((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_introduction_layout);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        us.pinguo.user.util.k.a(this.a, this);
    }

    public void s0() {
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }
}
