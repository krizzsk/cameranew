package com.pinguo.camera360.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.request.AlbumGetBackResponse;
import com.pinguo.camera360.request.AlbumGetBackStatusInfo;
import com.pinguo.camera360.request.ApiGetAlbumBackByEmail;
import com.pinguo.camera360.ui.TitleBarLayout;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.statistics.i;
import us.pinguo.foundation.ui.g;
import us.pinguo.foundation.utils.j0;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.ui.b.a;
import us.pinguo.user.User;
import us.pinguo.user.u0;
import us.pinguo.util.t;
import vStudio.Android.Camera360.R;
/* compiled from: PGAlbumGetBackByEmailActivity.kt */
/* loaded from: classes3.dex */
public final class PGAlbumGetBackByEmailActivity extends BaseActivity {

    /* renamed from: f  reason: collision with root package name */
    public static final a f6993f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private static long f6994g;
    public Map<Integer, View> a = new LinkedHashMap();
    private String b;
    private CountDownTimer c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6995d;

    /* renamed from: e  reason: collision with root package name */
    private a.C0454a f6996e;

    /* compiled from: PGAlbumGetBackByEmailActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final void a(long j2) {
            PGAlbumGetBackByEmailActivity.f6994g = j2;
        }
    }

    /* compiled from: PGAlbumGetBackByEmailActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends j.a.c.b.d<AlbumGetBackResponse> {
        final /* synthetic */ String b;

        b(String str) {
            this.b = str;
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(AlbumGetBackResponse albumGetBackResponse) {
            s.h(albumGetBackResponse, "albumGetBackResponse");
            T t = albumGetBackResponse.data;
            if (t != 0 && ((AlbumGetBackStatusInfo) t).success == 1) {
                ((TextView) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(R.id.et_check_mail_note)).setText(PGAlbumGetBackByEmailActivity.this.getResources().getString(R.string.email_check_code_note, this.b));
                PGAlbumGetBackByEmailActivity pGAlbumGetBackByEmailActivity = PGAlbumGetBackByEmailActivity.this;
                int i2 = R.id.et_check_mail;
                ((EditText) pGAlbumGetBackByEmailActivity._$_findCachedViewById(i2)).setText("");
                ((TextView) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(R.id.tv_check_mail)).setText("");
                ((EditText) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(i2)).requestFocus();
                ((EditText) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(i2)).setFocusableInTouchMode(true);
                ((EditText) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(i2)).setSelected(true);
                PGAlbumGetBackByEmailActivity pGAlbumGetBackByEmailActivity2 = PGAlbumGetBackByEmailActivity.this;
                int i3 = R.id.et_email_for_get_album_back;
                ((EditText) pGAlbumGetBackByEmailActivity2._$_findCachedViewById(i3)).clearFocus();
                ((EditText) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(i3)).setSelected(false);
                LinearLayout linearLayout = (LinearLayout) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(R.id.check_mail_layout);
                linearLayout.setVisibility(0);
                VdsAgent.onSetViewVisibility(linearLayout, 0);
                PGAlbumGetBackByEmailActivity.f6993f.a(System.currentTimeMillis() + 60000);
                PGAlbumGetBackByEmailActivity.this.x0(60);
            } else if (t != 0 && ((AlbumGetBackStatusInfo) t).success == 0) {
                j0.c(R.string.status_errorcode420);
                ((Button) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(R.id.btn_email_for_get_album_back)).setEnabled(true);
            } else {
                j0.d(PGAlbumGetBackByEmailActivity.this.getString(R.string.status_errorcode500));
                ((Button) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(R.id.btn_email_for_get_album_back)).setEnabled(true);
            }
            a.C0454a c0454a = PGAlbumGetBackByEmailActivity.this.f6996e;
            if (c0454a == null) {
                return;
            }
            c0454a.a();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            j0.d(PGAlbumGetBackByEmailActivity.this.getString(R.string.download_scene_failure));
            ((Button) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(R.id.btn_email_for_get_album_back)).setEnabled(true);
            a.C0454a c0454a = PGAlbumGetBackByEmailActivity.this.f6996e;
            if (c0454a == null) {
                return;
            }
            c0454a.a();
        }
    }

    /* compiled from: PGAlbumGetBackByEmailActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends CountDownTimer {
        c(long j2) {
            super(j2, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (PGAlbumGetBackByEmailActivity.this.f6995d) {
                return;
            }
            PGAlbumGetBackByEmailActivity pGAlbumGetBackByEmailActivity = PGAlbumGetBackByEmailActivity.this;
            int i2 = R.id.btn_email_for_get_album_back;
            ((Button) pGAlbumGetBackByEmailActivity._$_findCachedViewById(i2)).setText(R.string.text_btn_email_for_get_album_back);
            ((Button) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(i2)).setEnabled(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            if (PGAlbumGetBackByEmailActivity.this.f6995d) {
                return;
            }
            ((Button) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(R.id.btn_email_for_get_album_back)).setText(String.valueOf(j2 / 1000));
        }
    }

    /* compiled from: PGAlbumGetBackByEmailActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d extends HttpStringRequest {
        final /* synthetic */ long a;
        final /* synthetic */ PGAlbumGetBackByEmailActivity b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j2, PGAlbumGetBackByEmailActivity pGAlbumGetBackByEmailActivity, String str, String str2) {
            super(1, str2);
            this.a = j2;
            this.b = pGAlbumGetBackByEmailActivity;
            this.c = str;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() {
            HashMap hashMap = new HashMap();
            u0.e(BaseApplication.d(), hashMap);
            hashMap.put("code", this.c);
            us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.a) + "", "/api/user/validate-for-yun", "failed");
            j0.c(R.string.status_errorcode500);
            ((Button) this.b._$_findCachedViewById(R.id.btn_check_mail)).setEnabled(true);
            a.C0454a c0454a = this.b.f6996e;
            if (c0454a == null) {
                return;
            }
            c0454a.a();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
            r6.b.z0();
         */
        @Override // us.pinguo.common.network.HttpRequestBase
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onResponse(java.lang.String r7) {
            /*
                r6 = this;
                us.pinguo.foundation.statistics.i r0 = us.pinguo.foundation.statistics.h.b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                long r2 = java.lang.System.currentTimeMillis()
                long r4 = r6.a
                long r2 = r2 - r4
                r1.append(r2)
                java.lang.String r2 = ""
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "/api/user/validate-for-yun"
                java.lang.String r3 = "success"
                r0.n(r1, r2, r3)
                if (r7 == 0) goto Lca
                int r0 = r7.length()
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L2d
                r0 = 1
                goto L2e
            L2d:
                r0 = 0
            L2e:
                if (r0 == 0) goto L32
                goto Lca
            L32:
                java.lang.String r0 = "ABTestManager.getABPlan:"
                java.lang.String r0 = kotlin.jvm.internal.s.q(r0, r7)
                java.lang.Object[] r4 = new java.lang.Object[r1]
                us.pinguo.common.log.a.k(r0, r4)
                r0 = 2131822159(0x7f11064f, float:1.9277082E38)
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                r4.<init>(r7)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                java.lang.String r7 = "status"
                int r7 = r4.optInt(r7)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                r5 = 200(0xc8, float:2.8E-43)
                if (r7 != r5) goto L78
                java.lang.String r7 = "data"
                org.json.JSONObject r7 = r4.optJSONObject(r7)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                if (r7 != 0) goto L58
                goto L5f
            L58:
                int r7 = r7.optInt(r3)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                if (r7 != r2) goto L5f
                r1 = 1
            L5f:
                if (r1 == 0) goto L67
                com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity r7 = r6.b     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity.t0(r7)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                goto L7b
            L67:
                com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity r7 = r6.b     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                int r1 = vStudio.Android.Camera360.R.id.tv_check_mail     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                android.view.View r7 = r7._$_findCachedViewById(r1)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                android.widget.TextView r7 = (android.widget.TextView) r7     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                r1 = 2131820966(0x7f1101a6, float:1.9274662E38)
                r7.setText(r1)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
                goto L7b
            L78:
                us.pinguo.foundation.utils.j0.c(r0)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
            L7b:
                com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity r7 = r6.b
                int r0 = vStudio.Android.Camera360.R.id.btn_check_mail
                android.view.View r7 = r7._$_findCachedViewById(r0)
                android.widget.Button r7 = (android.widget.Button) r7
                r7.setEnabled(r2)
                com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity r7 = r6.b
                us.pinguo.ui.b.a$a r7 = com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity.s0(r7)
                if (r7 != 0) goto L91
                goto Laf
            L91:
                r7.a()
                goto Laf
            L95:
                r7 = move-exception
                goto Lb0
            L97:
                us.pinguo.foundation.utils.j0.c(r0)     // Catch: java.lang.Throwable -> L95
                com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity r7 = r6.b
                int r0 = vStudio.Android.Camera360.R.id.btn_check_mail
                android.view.View r7 = r7._$_findCachedViewById(r0)
                android.widget.Button r7 = (android.widget.Button) r7
                r7.setEnabled(r2)
                com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity r7 = r6.b
                us.pinguo.ui.b.a$a r7 = com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity.s0(r7)
                if (r7 != 0) goto L91
            Laf:
                return
            Lb0:
                com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity r0 = r6.b
                int r1 = vStudio.Android.Camera360.R.id.btn_check_mail
                android.view.View r0 = r0._$_findCachedViewById(r1)
                android.widget.Button r0 = (android.widget.Button) r0
                r0.setEnabled(r2)
                com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity r0 = r6.b
                us.pinguo.ui.b.a$a r0 = com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity.s0(r0)
                if (r0 != 0) goto Lc6
                goto Lc9
            Lc6:
                r0.a()
            Lc9:
                throw r7
            Lca:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity.d.onResponse(java.lang.String):void");
        }
    }

    /* compiled from: PGAlbumGetBackByEmailActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends g {
        e() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            PGAlbumGetBackByEmailActivity.this.A0();
        }
    }

    /* compiled from: PGAlbumGetBackByEmailActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f implements TitleBarLayout.a {
        f() {
        }

        @Override // com.pinguo.camera360.ui.TitleBarLayout.a
        public void onLeftBtnClick(View view) {
            PGAlbumGetBackByEmailActivity pGAlbumGetBackByEmailActivity = PGAlbumGetBackByEmailActivity.this;
            int i2 = R.id.check_mail_layout;
            if (((LinearLayout) pGAlbumGetBackByEmailActivity._$_findCachedViewById(i2)).getVisibility() == 0) {
                LinearLayout linearLayout = (LinearLayout) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(i2);
                linearLayout.setVisibility(4);
                VdsAgent.onSetViewVisibility(linearLayout, 4);
                PGAlbumGetBackByEmailActivity pGAlbumGetBackByEmailActivity2 = PGAlbumGetBackByEmailActivity.this;
                int i3 = R.id.et_check_mail;
                ((EditText) pGAlbumGetBackByEmailActivity2._$_findCachedViewById(i3)).clearFocus();
                ((EditText) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(i3)).setSelected(false);
                PGAlbumGetBackByEmailActivity pGAlbumGetBackByEmailActivity3 = PGAlbumGetBackByEmailActivity.this;
                int i4 = R.id.et_email_for_get_album_back;
                ((EditText) pGAlbumGetBackByEmailActivity3._$_findCachedViewById(i4)).requestFocus();
                ((EditText) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(i4)).setFocusableInTouchMode(true);
                ((EditText) PGAlbumGetBackByEmailActivity.this._$_findCachedViewById(i4)).setSelected(true);
                return;
            }
            PGAlbumGetBackByEmailActivity.this.finish();
        }

        @Override // com.pinguo.camera360.ui.TitleBarLayout.a
        public void onRightBtnClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0() {
        int i2 = R.id.tv_email_for_get_album_back;
        if (((TextView) _$_findCachedViewById(i2)) == null || ((TextView) _$_findCachedViewById(i2)).getVisibility() == 4) {
            return;
        }
        TextView textView = (TextView) _$_findCachedViewById(i2);
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
        ((TextView) _$_findCachedViewById(i2)).setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(PGAlbumGetBackByEmailActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        String obj = ((EditText) this$0._$_findCachedViewById(R.id.et_email_for_get_album_back)).getText().toString();
        if (TextUtils.isEmpty(obj)) {
            String string = this$0.getString(R.string.pg_login_email_empty);
            s.g(string, "getString(us.pinguo.user…ing.pg_login_email_empty)");
            this$0.F0(string);
        } else if (!t.a(obj)) {
            String string2 = this$0.getString(R.string.pg_login_email_format_error);
            s.g(string2, "getString(us.pinguo.user…login_email_format_error)");
            this$0.F0(string2);
        } else {
            this$0.A0();
            this$0.b = obj;
            this$0.w0(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(PGAlbumGetBackByEmailActivity this$0, View view) {
        boolean p;
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        if (this$0.b == null) {
            return;
        }
        String obj = ((EditText) this$0._$_findCachedViewById(R.id.et_check_mail)).getText().toString();
        p = kotlin.text.t.p(obj);
        if (p) {
            ((TextView) this$0._$_findCachedViewById(R.id.tv_check_mail)).setText(R.string.email_check_code_error);
            return;
        }
        ((TextView) this$0._$_findCachedViewById(R.id.tv_check_mail)).setText("");
        this$0.y0(obj);
    }

    private final void F0(String str) {
        int i2 = R.id.tv_email_for_get_album_back;
        if (((TextView) _$_findCachedViewById(i2)) != null) {
            if (((TextView) _$_findCachedViewById(i2)).getVisibility() != 0) {
                TextView textView = (TextView) _$_findCachedViewById(i2);
                textView.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView, 0);
            }
            ((TextView) _$_findCachedViewById(i2)).setText(str);
        }
    }

    private final void initView() {
        int i2 = R.id.title_bar_layout;
        ((TitleBarLayout) _$_findCachedViewById(i2)).setTiTleText(R.string.text_find_album_back);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_email_for_get_album_back);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.check_mail_layout);
        linearLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(linearLayout, 4);
        int i3 = R.id.btn_email_for_get_album_back;
        ((Button) _$_findCachedViewById(i3)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PGAlbumGetBackByEmailActivity.B0(PGAlbumGetBackByEmailActivity.this, view);
            }
        });
        ((Button) _$_findCachedViewById(i3)).addTextChangedListener(new e());
        ((Button) _$_findCachedViewById(R.id.btn_check_mail)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PGAlbumGetBackByEmailActivity.C0(PGAlbumGetBackByEmailActivity.this, view);
            }
        });
        this.f6996e = us.pinguo.ui.b.a.b(this, getString(R.string.load_more));
        ((TitleBarLayout) _$_findCachedViewById(i2)).setOnTitleBarClickListener(new f());
    }

    private final void w0(String str) {
        a.C0454a c0454a = this.f6996e;
        if (c0454a != null) {
            c0454a.e();
        }
        ((Button) _$_findCachedViewById(R.id.btn_email_for_get_album_back)).setEnabled(false);
        new ApiGetAlbumBackByEmail(this, str, User.d().h().userId).get(new b(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append('s');
        ((Button) _$_findCachedViewById(R.id.btn_email_for_get_album_back)).setText(sb.toString());
        CountDownTimer countDownTimer = this.c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.c = new c(i2 * 1000).start();
    }

    private final void y0(String str) {
        ((Button) _$_findCachedViewById(R.id.btn_check_mail)).setEnabled(false);
        a.C0454a c0454a = this.f6996e;
        if (c0454a != null) {
            c0454a.e();
        }
        h.b.n("", "/api/user/validate-for-yun", SocialConstants.TYPE_REQUEST);
        d dVar = new d(System.currentTimeMillis(), this, str, s.q(u0.c, "/api/user/validate-for-yun"));
        dVar.setRetryPolicy(u0.a());
        dVar.execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0() {
        Intent intent = new Intent(this, PGAlbumGetBackStatusActivity.class);
        intent.putExtra("status", AlbumGetBackStatusInfo.AlbumGetBackStatus.ALBUM_GET_BACK_STATUS_NONE.status);
        intent.putExtra(NotificationCompat.CATEGORY_EMAIL, this.b);
        startActivityForResult(intent, 10001);
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 10001 && i3 == 1) {
            setResult(1);
            finish();
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i2 = R.id.check_mail_layout;
        if (((LinearLayout) _$_findCachedViewById(i2)).getVisibility() == 0) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(i2);
            linearLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(linearLayout, 4);
            int i3 = R.id.et_email_for_get_album_back;
            ((EditText) _$_findCachedViewById(i3)).requestFocus();
            ((EditText) _$_findCachedViewById(i3)).setFocusableInTouchMode(true);
            ((EditText) _$_findCachedViewById(i3)).setSelected(true);
            int i4 = R.id.et_check_mail;
            ((EditText) _$_findCachedViewById(i4)).clearFocus();
            ((EditText) _$_findCachedViewById(i4)).setSelected(false);
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pgalbum_get_back_by_email);
        initView();
        this.f6995d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f6995d = true;
        CountDownTimer countDownTimer = this.c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        long currentTimeMillis = f6994g - System.currentTimeMillis();
        if (2000 <= currentTimeMillis && currentTimeMillis < 60001) {
            ((Button) _$_findCachedViewById(R.id.btn_email_for_get_album_back)).setEnabled(false);
            x0(((int) (currentTimeMillis / 1000)) + 1);
        }
    }
}
