package com.pinguo.camera360.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.CookieSyncManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.NotificationCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.options.OptionsWebviewActivity;
import com.pinguo.camera360.cloud.cropImage.CropImage;
import com.pinguo.camera360.homepage.HomePageActivity;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.request.GetUserInfo;
import com.tapjoy.TapjoyConstants;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.ByteArrayOutputStream;
import org.slf4j.Marker;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.r0;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.user.EditInfoActivity;
import us.pinguo.user.User;
import us.pinguo.user.api.f0;
import us.pinguo.user.s0;
import us.pinguo.user.ui.PGLoginBaseActivity;
import us.pinguo.user.util.BaseInfoResult;
import us.pinguo.user.util.g;
import us.pinguo.user.util.n;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class PersonalInformation extends PGLoginBaseActivity implements View.OnClickListener, g {

    /* renamed from: l  reason: collision with root package name */
    private static int f7014l = 100;

    /* renamed from: d  reason: collision with root package name */
    private float f7015d;

    /* renamed from: e  reason: collision with root package name */
    private j.a.c.b.b<Void> f7016e;

    /* renamed from: f  reason: collision with root package name */
    private j.a.c.b.b<Void> f7017f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7018g = false;

    /* renamed from: h  reason: collision with root package name */
    private TitleBarLayout f7019h;

    /* renamed from: i  reason: collision with root package name */
    private AppCompatButton f7020i;

    /* renamed from: j  reason: collision with root package name */
    private AppCompatButton f7021j;

    /* renamed from: k  reason: collision with root package name */
    private AppCompatButton f7022k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends j.a.c.b.d<Void> {
        a() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r1) {
            PersonalInformation.this.q0();
            PersonalInformation.this.G0();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            String str;
            PersonalInformation.this.q0();
            if (exc instanceof Fault) {
                Fault fault = (Fault) exc;
                if (fault.getStatus() == 420) {
                    PersonalInformation.this.A0();
                    return;
                }
                str = f0.a(PersonalInformation.this, fault.getStatus());
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = PersonalInformation.this.getString(R.string.modify_avatar_fail);
            }
            PersonalInformation.this.v0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends j.a.c.b.d<Void> {
        b() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r1) {
            PersonalInformation.this.G0();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        User.w(User.d());
        User.s();
        setResult(1001);
        s0.getInstance().onLogout();
        us.pinguo.foundation.r.d.a().b(new us.pinguo.foundation.r.a());
        finish();
    }

    private void B0(String str) {
        User d2 = User.d();
        j.a.c.b.b<Void> bVar = this.f7016e;
        if (bVar != null) {
            bVar.cancel(true);
        }
        this.f7016e = d2.b(str);
        t0();
        this.f7016e.get(new a());
    }

    private void C0(int i2, String str) {
        ((TextView) findViewById(R.id.id_personal_information_current_account_text)).setText(str);
    }

    private void D0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        View findViewById = findViewById(R.id.id_personal_information_link_email_hint_text);
        findViewById.setVisibility(8);
        VdsAgent.onSetViewVisibility(findViewById, 8);
        TextView textView = (TextView) findViewById(R.id.id_personal_information_bind_email_text);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        textView.setText(str);
        findViewById(R.id.id_personal_information_link_email_parent).setClickable(false);
    }

    private void E0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = (TextView) findViewById(R.id.id_personal_information_bind_phone_text);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        textView.setText(str);
        View findViewById = findViewById(R.id.id_personal_information_phone_hint_text);
        findViewById.setVisibility(8);
        VdsAgent.onSetViewVisibility(findViewById, 8);
        findViewById(R.id.id_personal_information_link_phone_click_parent).setClickable(false);
    }

    private void F0(User.Info info) {
        User.Info.ThirdSites.QQSite qQSite;
        User.Info.ThirdSites.SinaSite sinaSite;
        User.Info.ThirdSites.FacebookSite facebookSite;
        User.Info.ThirdSites.TwitterSite twitterSite;
        User.Info.ThirdSites.HuaweiSite huaweiSite;
        if (info != null) {
            String str = info.loginmode;
            User.Info.ThirdSites thirdSites = info.third;
            User.Info.ThirdSites.WechatSite wechatSite = null;
            if (thirdSites != null) {
                User.Info.ThirdSites.QQSite qQSite2 = thirdSites.qzone;
                sinaSite = thirdSites.sina;
                facebookSite = thirdSites.facebook;
                twitterSite = thirdSites.twitter;
                User.Info.ThirdSites.WechatSite wechatSite2 = thirdSites.wechat;
                huaweiSite = thirdSites.huawei;
                qQSite = qQSite2;
                wechatSite = wechatSite2;
            } else {
                qQSite = null;
                sinaSite = null;
                facebookSite = null;
                twitterSite = null;
                huaweiSite = null;
            }
            if (str.equals(NotificationCompat.CATEGORY_EMAIL)) {
                C0(R.drawable.person_info_email_ic, info.nickname);
            } else if (str.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
                if (wechatSite != null) {
                    C0(R.drawable.pg_third_wechat_normal, wechatSite.nickname);
                }
            } else if (str.equals(Constants.SOURCE_QZONE)) {
                if (qQSite != null) {
                    C0(R.drawable.pg_third_qq_normal, qQSite.nickname);
                }
            } else if (str.equals("sina")) {
                if (sinaSite != null) {
                    C0(R.drawable.pg_third_sina_normal, sinaSite.nickname);
                }
            } else if (str.equals("facebook")) {
                if (facebookSite != null) {
                    C0(R.drawable.pg_third_facebook_normal, facebookSite.nickname);
                }
            } else if (str.equals(FindFriendHeaderCell.TWITTER)) {
                if (twitterSite != null) {
                    C0(R.drawable.pg_third_twitter_normal, twitterSite.nickname);
                }
            } else if (str.equals(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE)) {
                C0(R.drawable.person_info_phone_ic, info.nickname);
            } else if (!str.equals(com.adjust.sdk.Constants.REFERRER_API_HUAWEI) || huaweiSite == null) {
            } else {
                C0(R.drawable.pg_third_huawei_normal, huaweiSite.nickname);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        User d2 = User.d();
        if (d2.q()) {
            User.Info h2 = d2.h();
            String str = h2.email;
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.split("@")[0];
                String str3 = str.split("@")[1];
                int length = str2.length();
                if (length > 2) {
                    int round = length - Math.round(length / 2.0f);
                    StringBuilder sb = new StringBuilder();
                    sb.append("(?<=[\\w]{");
                    float f2 = round / 2.0f;
                    sb.append(Math.round(f2));
                    sb.append("})[\\w](?=[\\w]{");
                    sb.append(Math.round(f2));
                    sb.append("})");
                    str = str2.replaceAll(sb.toString(), Marker.ANY_MARKER) + "@" + str3;
                } else if (length == 2) {
                    str = str2.replaceAll("(?<=[\\w]{1})[\\w](?=[\\w]{0})", Marker.ANY_MARKER) + "@" + str3;
                }
            }
            String str4 = h2.mobile;
            if (!TextUtils.isEmpty(str4)) {
                if (str4.length() == 11) {
                    str4 = str4.replaceAll("(\\w{3})\\w{4}(\\w{4})", "$1****$2");
                } else {
                    str4 = str4.replaceAll("(?<=[\\w]{" + (str4.length() / 3) + "})[\\w](?=[\\w]{" + (str4.length() / 3) + "})", Marker.ANY_MARKER);
                }
            }
            TextView textView = (TextView) findViewById(R.id.id_personal_information_link_email_title_text);
            TextView textView2 = (TextView) findViewById(R.id.id_personal_information_link_email_hint_text);
            if (this.f7018g) {
                textView.setText(R.string.email);
                if (TextUtils.isEmpty(str)) {
                    findViewById(R.id.id_personal_information_link_email_parent).setClickable(true);
                    textView2.setText(R.string.unbind);
                    View findViewById = findViewById(R.id.id_personal_information_bind_email_text);
                    findViewById.setVisibility(8);
                    VdsAgent.onSetViewVisibility(findViewById, 8);
                } else {
                    D0(str);
                }
            } else {
                textView.setText(R.string.login_personal_information_email);
                if (TextUtils.isEmpty(str)) {
                    textView2.setText(R.string.login_personal_information_email_tip);
                    findViewById(R.id.id_personal_information_link_email_parent).setClickable(true);
                } else {
                    D0(str);
                }
            }
            View findViewById2 = findViewById(R.id.id_personal_information_link_phone_click_parent);
            if (this.f7018g) {
                if (findViewById2.getVisibility() != 0) {
                    findViewById2.setVisibility(0);
                    VdsAgent.onSetViewVisibility(findViewById2, 0);
                }
                if (TextUtils.isEmpty(str4)) {
                    View findViewById3 = findViewById(R.id.id_personal_information_bind_phone_text);
                    findViewById3.setVisibility(8);
                    VdsAgent.onSetViewVisibility(findViewById3, 8);
                    findViewById(R.id.id_personal_information_link_phone_click_parent).setClickable(true);
                } else {
                    E0(str4);
                }
            } else if (findViewById2.getVisibility() != 8) {
                findViewById2.setVisibility(8);
                VdsAgent.onSetViewVisibility(findViewById2, 8);
            }
            TextView textView3 = (TextView) findViewById(R.id.id_personal_prompt_user_bind);
            if (this.f7018g) {
                textView3.setText(R.string.person_information_link_email_phone_introduce);
            } else {
                textView3.setText(R.string.person_information_link_email_introduce);
            }
            F0(h2);
        }
    }

    private void z0() {
        j.a.c.b.b<Void> bVar = this.f7017f;
        if (bVar != null) {
            bVar.cancel(true);
        }
        GetUserInfo getUserInfo = new GetUserInfo(this);
        this.f7017f = getUserInfo;
        getUserInfo.get(new b());
    }

    public void initView() {
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.title_bar_layout_res_0x7f090781);
        this.f7019h = titleBarLayout;
        titleBarLayout.setTiTleText(R.string.settings_account_sets_title);
        findViewById(R.id.id_personal_information_link_email_parent).setOnClickListener(this);
        findViewById(R.id.id_personal_information_link_phone_click_parent).setOnClickListener(this);
        findViewById(R.id.id_personal_information_logoutBtn).setOnClickListener(this);
        this.f7020i = (AppCompatButton) findViewById(R.id.id_personal_information_unregister);
        this.f7021j = (AppCompatButton) findViewById(R.id.id_personal_information_change_phone);
        this.f7022k = (AppCompatButton) findViewById(R.id.id_change_personal_information);
        this.f7020i.setOnClickListener(this);
        this.f7021j.setOnClickListener(this);
        this.f7022k.setOnClickListener(this);
        AppCompatButton appCompatButton = this.f7022k;
        appCompatButton.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatButton, 0);
        if (this.f7018g) {
            AppCompatButton appCompatButton2 = this.f7020i;
            appCompatButton2.setVisibility(0);
            VdsAgent.onSetViewVisibility(appCompatButton2, 0);
            AppCompatButton appCompatButton3 = this.f7021j;
            appCompatButton3.setVisibility(0);
            VdsAgent.onSetViewVisibility(appCompatButton3, 0);
            return;
        }
        AppCompatButton appCompatButton4 = this.f7020i;
        appCompatButton4.setVisibility(8);
        VdsAgent.onSetViewVisibility(appCompatButton4, 8);
        AppCompatButton appCompatButton5 = this.f7021j;
        appCompatButton5.setVisibility(8);
        VdsAgent.onSetViewVisibility(appCompatButton5, 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle extras;
        byte[] a2;
        Uri data;
        if (i2 == 1) {
            if (i3 == 0 || intent == null || (data = intent.getData()) == null) {
                return;
            }
            Intent intent2 = new Intent(this, CropImage.class);
            intent2.setData(data);
            intent2.putExtra("return-data", true);
            intent2.putExtra("aspectX", 1);
            intent2.putExtra("aspectY", 1);
            intent2.putExtra("outputX", f7014l);
            intent2.putExtra("outputY", f7014l);
            startActivityForResult(intent2, 2);
            return;
        }
        if (i2 == 2) {
            if (i3 == 0) {
                return;
            }
            if (intent != null && (extras = intent.getExtras()) != null) {
                Bitmap bitmap = null;
                for (String str : extras.keySet()) {
                    us.pinguo.common.log.a.m("PersonalInformation", "key=" + str, new Object[0]);
                    if (str.equals("cropped-rect")) {
                        Rect rect = (Rect) extras.getParcelable(str);
                        us.pinguo.common.log.a.m("PersonalInformation", "l=" + rect.left + ",t=" + rect.top + ",r=" + rect.right + ",b=" + rect.bottom, new Object[0]);
                    } else if (str.equals("data")) {
                        bitmap = (Bitmap) extras.getParcelable(str);
                    }
                }
                if (bitmap != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (byteArray == null || byteArray.length == 0 || (a2 = us.pinguo.common.utils.c.a(byteArray)) == null || a2.length == 0) {
                        return;
                    }
                    B0(new String(a2));
                }
            }
        } else if (i2 == 1000) {
            if (i3 == 1001 && intent != null) {
                int intExtra = intent.getIntExtra("destroy_account", 200);
                us.pinguo.common.log.a.m("PersonalInformation", "status=" + intExtra, new Object[0]);
                if (intExtra == 420) {
                    A0();
                    return;
                }
            }
        } else if (i2 == 1001 && i3 == -1) {
            Intent intent3 = new Intent();
            intent3.setClass(this, HomePageActivity.class);
            intent3.setFlags(67108864);
            startActivity(intent3);
            A0();
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        int id = view.getId();
        view.setClickable(false);
        r0.d(view, true, 500);
        switch (id) {
            case R.id.id_change_personal_information /* 2131297069 */:
                Intent intent = new Intent();
                intent.setClass(this, EditInfoActivity.class);
                startActivity(intent);
                return;
            case R.id.id_personal_information_change_phone /* 2131297115 */:
                Intent intent2 = new Intent();
                intent2.setClassName(this, "us.pinguo.inspire.ChangePhoneNumActivity");
                startActivity(intent2);
                return;
            case R.id.id_personal_information_link_email_parent /* 2131297118 */:
                if (TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE.equals(User.d().h().loginmode)) {
                    startActivity(new Intent(this, PGPhoneBindEmailActivity.class));
                    return;
                } else {
                    startActivity(new Intent(this, PGSnsBindEmailActivity.class));
                    return;
                }
            case R.id.id_personal_information_link_phone_click_parent /* 2131297120 */:
                Intent intent3 = new Intent();
                intent3.setClassName(this, "us.pinguo.inspire.PhoneBindActivity");
                startActivity(intent3);
                return;
            case R.id.id_personal_information_logoutBtn /* 2131297121 */:
                a.f.a(R.id.id_personal_information_logoutBtn);
                a.h.b();
                A0();
                return;
            case R.id.id_personal_information_unregister /* 2131297123 */:
                Intent intent4 = new Intent();
                intent4.putExtra("towhere", "unregister");
                intent4.setClass(this, OptionsWebviewActivity.class);
                startActivityForResult(intent4, 1001);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.ui.PGLoginBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pg_personal_information);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f2 = displayMetrics.density;
        this.f7015d = f2;
        f7014l = Math.round(Math.max(141.0f, f2 * 94.0f));
        initView();
        z0();
        n nVar = n.a;
        nVar.h(this);
        BaseInfoResult g2 = nVar.g();
        if (g2 != null) {
            this.f7018g = g2.isChina();
        } else {
            this.f7018g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        j.a.c.b.b<Void> bVar = this.f7017f;
        if (bVar != null) {
            bVar.cancel(true);
        }
        j.a.c.b.b<Void> bVar2 = this.f7016e;
        if (bVar2 != null) {
            bVar2.cancel(true);
        }
        n.a.n(this);
        super.onDestroy();
    }

    @Override // us.pinguo.user.util.g
    public void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
        BaseInfoResult g2 = n.a.g();
        if (g2 != null) {
            this.f7018g = g2.isChina();
        } else {
            this.f7018g = false;
        }
        if (this.f7018g) {
            AppCompatButton appCompatButton = this.f7020i;
            appCompatButton.setVisibility(0);
            VdsAgent.onSetViewVisibility(appCompatButton, 0);
            AppCompatButton appCompatButton2 = this.f7021j;
            appCompatButton2.setVisibility(0);
            VdsAgent.onSetViewVisibility(appCompatButton2, 0);
        } else {
            AppCompatButton appCompatButton3 = this.f7020i;
            appCompatButton3.setVisibility(8);
            VdsAgent.onSetViewVisibility(appCompatButton3, 8);
            AppCompatButton appCompatButton4 = this.f7021j;
            appCompatButton4.setVisibility(8);
            VdsAgent.onSetViewVisibility(appCompatButton4, 8);
        }
        if (baseInfoResult == null || !baseInfoResult.isChina() || this.pgDistroy) {
            return;
        }
        AppCompatButton appCompatButton5 = this.f7020i;
        appCompatButton5.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatButton5, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        us.pinguo.common.log.a.m("PersonalInformation", "onPause,onPause", new Object[0]);
        CookieSyncManager.getInstance().stopSync();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        G0();
        CookieSyncManager.getInstance().startSync();
    }
}
