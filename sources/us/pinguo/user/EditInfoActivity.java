package us.pinguo.user;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.util.ArrayList;
import rx.functions.Action1;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.network.Fault;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.module.profile.GeoCode;
import us.pinguo.inspire.module.profile.GeoResp;
import us.pinguo.inspire.module.profile.InspireLocationManager;
import us.pinguo.inspire.module.profile.UserInfoLoader;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.ui.uilview.CircleImageView;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.ui.widget.CheckableTextView;
import us.pinguo.user.User;
import us.pinguo.user.model.ProfileAuthorInfo;
/* loaded from: classes6.dex */
public class EditInfoActivity extends BaseLoginCheckActivity implements View.OnClickListener {
    private String a;
    private PhotoImageView b;
    private CircleImageView c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f12347d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f12348e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f12349f;

    /* renamed from: g  reason: collision with root package name */
    private UserInfoLoader f12350g;

    /* renamed from: h  reason: collision with root package name */
    private AlertDialog f12351h;

    /* renamed from: i  reason: collision with root package name */
    private GalleryState f12352i;

    /* renamed from: j  reason: collision with root package name */
    private CheckableTextView f12353j;

    /* renamed from: k  reason: collision with root package name */
    private CheckableTextView f12354k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12355l;
    private int m = -1;

    /* loaded from: classes6.dex */
    public enum GalleryState {
        AVATAR,
        COVER
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements InspireLocationManager.LocationResultListener {
        a() {
        }

        @Override // us.pinguo.inspire.module.profile.InspireLocationManager.LocationResultListener
        public void onResult(InspireGeo inspireGeo) {
            EditInfoActivity.this.f12348e.setText(inspireGeo.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Action1<String> {
        b() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a */
        public void call(String str) {
            us.pinguo.foundation.r.d.a().b(new us.pinguo.user.event.a());
            Toast makeText = Toast.makeText(EditInfoActivity.this, R.string.change_success, 1);
            makeText.show();
            VdsAgent.showToast(makeText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void E0(us.pinguo.user.event.b bVar) {
        GeoResp geoResp = bVar.a;
        InspireGeo inspireGeo = geoResp.info;
        GeoCode geoCode = geoResp.codes;
        this.f12348e.setText(inspireGeo == null ? "" : inspireGeo.toString());
        if (geoCode == null) {
            return;
        }
        o1(geoCode.country, geoCode.province, geoCode.city);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void F0(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0 */
    public /* synthetic */ void H0(String str, String str2) {
        User.Info h2 = User.d().h();
        h2.avatar = str;
        User.v(h2);
        us.pinguo.foundation.r.d.a().b(new us.pinguo.user.event.a());
        u0(str2);
        this.c.setImageUri(str2);
        L0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void I0(DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0() {
        L0();
        us.pinguo.foundation.utils.w.k(this, R.string.upload_risky_image, us.pinguo.ui.R.string.ok, -999, false, g0.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(final String str, final String str2) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        us.pinguo.user.util.n.a.o(u0.m, arrayList, new Runnable() { // from class: us.pinguo.user.y
            @Override // java.lang.Runnable
            public final void run() {
                EditInfoActivity.this.H0(str2, str);
            }
        }, new Runnable() { // from class: us.pinguo.user.j0
            @Override // java.lang.Runnable
            public final void run() {
                EditInfoActivity.this.K0();
            }
        }, new Runnable() { // from class: us.pinguo.user.c0
            @Override // java.lang.Runnable
            public final void run() {
                EditInfoActivity.this.M0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        j1(th);
        L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0 */
    public /* synthetic */ void S0() {
        L0();
        us.pinguo.foundation.utils.w.k(this, R.string.upload_risky_image, R.string.ok, -999, false, k0.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0 */
    public /* synthetic */ void U0(final String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        us.pinguo.user.util.n.a.o(u0.m, arrayList, new Runnable() { // from class: us.pinguo.user.e0
            @Override // java.lang.Runnable
            public final void run() {
                EditInfoActivity.this.Y0(str);
            }
        }, new Runnable() { // from class: us.pinguo.user.t
            @Override // java.lang.Runnable
            public final void run() {
                EditInfoActivity.this.S0();
            }
        }, new Runnable() { // from class: us.pinguo.user.s
            @Override // java.lang.Runnable
            public final void run() {
                EditInfoActivity.this.L0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V0 */
    public /* synthetic */ void W0(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        j1(th);
        L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0 */
    public /* synthetic */ void Y0(String str) {
        User.Info h2 = User.d().h();
        h2.backgroundPic = str;
        User.v(h2);
        this.b.setImageUri(str);
        us.pinguo.foundation.r.d.a().b(new us.pinguo.user.event.a());
        L0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Z0(DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public /* synthetic */ void b1(int i2, String str) {
        L0();
        us.pinguo.user.event.a aVar = new us.pinguo.user.event.a();
        aVar.a = i2;
        us.pinguo.foundation.r.d.a().b(aVar);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1 */
    public /* synthetic */ void d1(Throwable th) {
        us.pinguo.common.log.a.f(th);
        Inspire.f(th);
        j1(th);
        L0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e1(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    private void i1() {
        ProfileAuthorInfo profileAuthorInfo = (ProfileAuthorInfo) getIntent().getParcelableExtra("author_info");
        if (profileAuthorInfo == null) {
            profileAuthorInfo = ProfileAuthorInfo.userToProfileAuthorInfo(User.d().h());
        }
        this.c.setImageUri(profileAuthorInfo.avatar, us.pinguo.ui.R.drawable.default_avatar);
        if (profileAuthorInfo != null && !TextUtils.isEmpty(profileAuthorInfo.nickname)) {
            this.f12347d.setText(profileAuthorInfo.nickname);
        }
        TextView textView = this.f12348e;
        InspireGeo inspireGeo = profileAuthorInfo.geo;
        textView.setText(inspireGeo == null ? "" : inspireGeo.toString());
        int i2 = profileAuthorInfo.gender;
        if (i2 == 1) {
            this.f12353j.setChecked(true);
            this.m = 1;
        } else if (i2 == 2) {
            this.f12354k.setChecked(true);
            this.m = 2;
        }
        if (TextUtils.isEmpty(profileAuthorInfo.desc)) {
            User.Info h2 = User.d().h();
            this.f12349f.setText(h2 == null ? "" : h2.description);
        } else {
            this.f12349f.setText(profileAuthorInfo.desc);
        }
        PhotoImageView photoImageView = this.b;
        photoImageView.setSize(us.pinguo.foundation.t.b.a.j(photoImageView.getContext()), us.pinguo.foundation.t.b.a.a(this.b.getContext(), 244.0f));
        if (TextUtils.isEmpty(profileAuthorInfo.backgroundPic)) {
            User d2 = User.d();
            this.b.setImageUri(d2.h() != null ? d2.h().backgroundPic : "", R.drawable.profile_header_default_bg);
        } else {
            this.b.setImageUri(profileAuthorInfo.backgroundPic, R.drawable.profile_header_default_bg);
        }
        InspireLocationManager inspireLocationManager = InspireLocationManager.getInstance();
        InspireGeo inspireGeo2 = profileAuthorInfo.geo;
        inspireLocationManager.getGeo(inspireGeo2.country, inspireGeo2.province, inspireGeo2.city, new a());
    }

    private void initView() {
        this.f12353j = (CheckableTextView) findViewById(R.id.ctv_male);
        this.f12354k = (CheckableTextView) findViewById(R.id.ctv_female);
        this.f12353j.setOnClickListener(this);
        this.f12354k.setOnClickListener(this);
        if (this.f12355l) {
            this.f12353j.setChecked(false);
            this.f12354k.setChecked(false);
        }
        TextView textView = (TextView) findViewById(R.id.tv_complete);
        textView.setOnClickListener(this);
        textView.getPaint().setFakeBoldText(true);
        this.b = (PhotoImageView) findViewById(R.id.edt_header_bg);
        this.c = (CircleImageView) findViewById(R.id.edt_avatar);
        TextView textView2 = (TextView) findViewById(R.id.edt_info_nickname);
        this.f12347d = textView2;
        textView2.setOnClickListener(this);
        this.f12348e = (TextView) findViewById(R.id.edt_info_location);
        this.f12349f = (TextView) findViewById(R.id.edt_info_introduce);
        this.c.setOnClickListener(this);
        findViewById(R.id.edt_info_introduce_layout).setOnClickListener(this);
        findViewById(R.id.edt_cover_layout).setOnClickListener(this);
        findViewById(R.id.edt_info_location_layout).setOnClickListener(this);
        findViewById(R.id.edt_nickname_layout).setOnClickListener(this);
        this.f12347d.clearFocus();
        this.f12347d.setCursorVisible(false);
    }

    private void j1(Throwable th) {
        if (th instanceof Fault) {
            Fault fault = (Fault) th;
            if (fault == null) {
                us.pinguo.foundation.utils.j0.c(us.pinguo.c360.i18n.R.string.network_error);
            } else {
                us.pinguo.foundation.utils.j0.d(us.pinguo.user.api.f0.a(this, fault.getStatus()));
            }
        }
    }

    private void k1() {
        AlertDialog alertDialog = this.f12351h;
        if (alertDialog != null) {
            alertDialog.show();
            VdsAgent.showDialog(alertDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public void C0(String str) {
        String w0 = w0(str);
        if (w0 == null) {
            return;
        }
        m1(w0.replaceAll("\n", ""));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String w0(java.lang.String r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.File r1 = new java.io.File
            r1.<init>(r4)
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2f java.io.FileNotFoundException -> L3f
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2f java.io.FileNotFoundException -> L3f
            long r1 = r1.length()     // Catch: java.io.IOException -> L26 java.io.FileNotFoundException -> L28 java.lang.Throwable -> L4f
            int r2 = (int) r1     // Catch: java.io.IOException -> L26 java.io.FileNotFoundException -> L28 java.lang.Throwable -> L4f
            byte[] r1 = new byte[r2]     // Catch: java.io.IOException -> L26 java.io.FileNotFoundException -> L28 java.lang.Throwable -> L4f
            r4.read(r1)     // Catch: java.io.IOException -> L26 java.io.FileNotFoundException -> L28 java.lang.Throwable -> L4f
            r2 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r1, r2)     // Catch: java.io.IOException -> L26 java.io.FileNotFoundException -> L28 java.lang.Throwable -> L4f
            r4.close()     // Catch: java.io.IOException -> L21
            goto L25
        L21:
            r4 = move-exception
            r4.printStackTrace()
        L25:
            return r0
        L26:
            r1 = move-exception
            goto L31
        L28:
            r1 = move-exception
            goto L41
        L2a:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L50
        L2f:
            r1 = move-exception
            r4 = r0
        L31:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4f
            if (r4 == 0) goto L3e
            r4.close()     // Catch: java.io.IOException -> L3a
            goto L3e
        L3a:
            r4 = move-exception
            r4.printStackTrace()
        L3e:
            return r0
        L3f:
            r1 = move-exception
            r4 = r0
        L41:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4f
            if (r4 == 0) goto L4e
            r4.close()     // Catch: java.io.IOException -> L4a
            goto L4e
        L4a:
            r4 = move-exception
            r4.printStackTrace()
        L4e:
            return r0
        L4f:
            r0 = move-exception
        L50:
            if (r4 == 0) goto L5a
            r4.close()     // Catch: java.io.IOException -> L56
            goto L5a
        L56:
            r4 = move-exception
            r4.printStackTrace()
        L5a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.user.EditInfoActivity.w0(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public void M0() {
        AlertDialog alertDialog = this.f12351h;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void f1(Activity activity, String str, int i2) {
        Intent intent = new Intent(activity, CropActivity.class);
        intent.putExtra(PGEditResultActivity2.PATH, str);
        intent.putExtra("crop_key", i2);
        activity.startActivityForResult(intent, 2);
    }

    public void g1() {
        Intent intent = new Intent();
        intent.setClassName(this, "com.pinguo.camera360.gallery.photopick.PhotoPickActivity");
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_MODE_VALUE, 6);
        startActivityForResult(intent, 1);
    }

    @Override // us.pinguo.foundation.base.BaseActivity
    protected String getPageId() {
        return "Community_Mine_Profile_Edit_Page";
    }

    public void h1() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.user.event.b.class).subscribe(new Action1() { // from class: us.pinguo.user.w
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditInfoActivity.this.E0((us.pinguo.user.event.b) obj);
            }
        }, z.a));
    }

    /* renamed from: l1 */
    public void A0(final String str, String str2) {
        k1();
        addSubscription(this.f12350g.updateAvatar(str2).subscribe(new Action1() { // from class: us.pinguo.user.a0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditInfoActivity.this.O0(str, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.b0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditInfoActivity.this.Q0((Throwable) obj);
            }
        }));
    }

    public void m1(String str) {
        k1();
        addSubscription(this.f12350g.updateCover(str).subscribe(new Action1() { // from class: us.pinguo.user.h0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditInfoActivity.this.U0((String) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.v
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditInfoActivity.this.W0((Throwable) obj);
            }
        }));
    }

    public void n1(final int i2) {
        k1();
        addSubscription(this.f12350g.updateGender(i2).subscribe(new Action1() { // from class: us.pinguo.user.x
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditInfoActivity.this.b1(i2, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.f0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditInfoActivity.this.d1((Throwable) obj);
            }
        }));
    }

    public void o1(String str, String str2, String str3) {
        addSubscription(new UserInfoLoader().updateLocation(str, str2, str3).subscribe(new b(), d0.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            if (i3 != -1 || intent == null || (stringExtra = intent.getStringExtra("photo_path")) == null) {
                return;
            }
            this.a = stringExtra;
            us.pinguo.common.log.a.m("zhowuei", "photo path:" + this.a, new Object[0]);
            if (this.f12352i == GalleryState.AVATAR) {
                f1(this, this.a, 1);
            } else {
                f1(this, this.a, 0);
            }
        } else if (i2 != 2) {
            if (i2 == 3) {
                if (i3 != -1 || intent == null) {
                    return;
                }
                this.f12349f.setText(intent.getStringExtra(SocialConstants.PARAM_APP_DESC));
                us.pinguo.foundation.r.d.a().b(new us.pinguo.user.event.a());
            } else if (i2 == 4 && i3 == -1 && intent != null) {
                this.f12347d.setText(intent.getStringExtra("nickname"));
                us.pinguo.foundation.r.d.a().b(new us.pinguo.user.event.a());
            }
        } else if (i3 != -1 || intent == null) {
        } else {
            final String stringExtra2 = intent.getStringExtra(PGEditResultActivity2.PATH);
            if (this.f12352i == GalleryState.AVATAR) {
                if (stringExtra2 == null || !new File(stringExtra2).exists()) {
                    return;
                }
                final String str = InspirePublishFragment.FILE_HEADER + stringExtra2;
                final String w0 = w0(stringExtra2);
                if (w0 == null) {
                    return;
                }
                us.pinguo.user.util.n.a.d(this, new Runnable() { // from class: us.pinguo.user.i0
                    @Override // java.lang.Runnable
                    public final void run() {
                        EditInfoActivity.this.A0(str, w0);
                    }
                });
                us.pinguo.common.log.a.m("zhouwei", "filePath:" + stringExtra2, new Object[0]);
                return;
            }
            us.pinguo.user.util.n.a.d(this, new Runnable() { // from class: us.pinguo.user.u
                @Override // java.lang.Runnable
                public final void run() {
                    EditInfoActivity.this.C0(stringExtra2);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view.getId() == R.id.edt_avatar) {
            this.f12352i = GalleryState.AVATAR;
            g1();
        } else if (view.getId() != R.id.edt_info_introduce_layout && view.getId() != R.id.edt_info_introduce) {
            if (view.getId() != R.id.edt_nickname_layout && view.getId() != R.id.edt_info_nickname) {
                if (view.getId() == R.id.edt_cover_layout) {
                    this.f12352i = GalleryState.COVER;
                    g1();
                    return;
                } else if (view.getId() == R.id.edt_info_location_layout) {
                    Intent intent = new Intent(this, InspireContentActivity.class);
                    intent.putExtra(InspireContentActivity.FRAGMENT_NAME, EditCountryFragment.class.getName());
                    startActivity(intent);
                    return;
                } else if (view.getId() == R.id.tv_complete) {
                    if ("".equals(this.f12347d.getText().toString())) {
                        us.pinguo.foundation.utils.j0.d(getString(R.string.nick_name_message));
                        return;
                    } else if (!this.f12354k.a() && !this.f12353j.a()) {
                        us.pinguo.foundation.utils.j0.d(getString(R.string.profele_choose_sex));
                        return;
                    } else {
                        n1(this.m);
                        return;
                    }
                } else if (view.getId() == R.id.ctv_male) {
                    if (!this.f12353j.a()) {
                        this.m = 1;
                    }
                    this.f12353j.setChecked(true);
                    this.f12354k.setChecked(false);
                    return;
                } else if (view.getId() == R.id.ctv_female) {
                    if (!this.f12354k.a()) {
                        this.m = 2;
                    }
                    this.f12354k.setChecked(true);
                    this.f12353j.setChecked(false);
                    return;
                } else {
                    return;
                }
            }
            Intent intent2 = new Intent(this, EditIntroductionActivity.class);
            intent2.putExtra("nickname", this.f12347d.getText().toString());
            intent2.putExtra("isNickeName", true);
            startActivityForResult(intent2, 4);
        } else {
            Intent intent3 = new Intent(this, EditIntroductionActivity.class);
            intent3.putExtra("introduction", this.f12349f.getText().toString());
            intent3.putExtra("isNickeName", false);
            startActivityForResult(intent3, 3);
        }
    }

    @Override // us.pinguo.user.BaseLoginCheckActivity
    protected void onLoginCreate(Bundle bundle) {
        setContentView(R.layout.edit_info_activity_layout);
        this.f12355l = getIntent().getBooleanExtra("firstLogin", false);
        us.pinguo.foundation.statistics.l.h(Inspire.a(), "Profile_guest_page");
        this.f12350g = new UserInfoLoader();
        getResources().getString(R.string.male);
        getResources().getString(R.string.female);
        this.f12351h = us.pinguo.ui.b.a.c(this, getResources().getString(R.string.please_wait));
        initView();
        i1();
        h1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void u0(String str) {
        ImageLoader.getInstance().m().remove(str);
        ImageLoader.getInstance().o().remove(str);
    }
}
