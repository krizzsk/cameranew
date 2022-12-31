package com.pinguo.camera360.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.pinguo.camera360.request.AlbumGetBackStatusResponse;
import com.pinguo.camera360.request.ApiGetAlbumBackStatus;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.ui.b.a;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.user.User;
import vStudio.Android.Camera360.R;
/* compiled from: PGAlbumServicePauseActivity.kt */
/* loaded from: classes3.dex */
public final class PGAlbumServicePauseActivity extends BaseActivity implements View.OnClickListener {
    public Map<Integer, View> a = new LinkedHashMap();
    private final int b = 10001;
    private AlbumGetBackStatusResponse c;

    /* renamed from: d  reason: collision with root package name */
    private a.C0454a f6997d;

    /* compiled from: PGAlbumServicePauseActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends j.a.c.b.d<AlbumGetBackStatusResponse> {
        a() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(AlbumGetBackStatusResponse albumGetBackStatusResponse) {
            s.h(albumGetBackStatusResponse, "albumGetBackStatusResponse");
            PGAlbumServicePauseActivity.this.c = albumGetBackStatusResponse;
            if (PGAlbumServicePauseActivity.this.f6997d != null) {
                a.C0454a c0454a = PGAlbumServicePauseActivity.this.f6997d;
                s.e(c0454a);
                c0454a.a();
            }
        }

        @Override // j.a.c.b.d
        public void onError(Exception e2) {
            s.h(e2, "e");
            if (PGAlbumServicePauseActivity.this.f6997d != null) {
                a.C0454a c0454a = PGAlbumServicePauseActivity.this.f6997d;
                s.e(c0454a);
                c0454a.a();
            }
        }
    }

    private final void initView() {
        ((Button) _$_findCachedViewById(R.id.btnFindAlbumBack)).setOnClickListener(this);
        int i2 = R.id.title_bar_layout;
        ((TitleBarLayout) _$_findCachedViewById(i2)).setTiTleText(getResources().getString(R.string.my_center_cloud_entry));
        ((TitleBarLayout) _$_findCachedViewById(i2)).e();
        ((TitleBarLayout) _$_findCachedViewById(i2)).f();
        ((TitleBarLayout) _$_findCachedViewById(i2)).g();
        ((TitleBarLayout) _$_findCachedViewById(i2)).h();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.rightMargin = ((int) us.pinguo.foundation.t.b.a.g(this)) * 20;
        layoutParams.leftMargin = ((int) us.pinguo.foundation.t.b.a.g(this)) * 32;
        layoutParams.addRule(1, ((ImageView) ((TitleBarLayout) _$_findCachedViewById(i2)).findViewById(R.id.title_back_btn)).getId());
        ((AutofitTextView) ((TitleBarLayout) _$_findCachedViewById(i2)).findViewById(R.id.title_text_title)).setLayoutParams(layoutParams);
    }

    private final void s0() {
        User d2 = User.d();
        if (d2.h() != null) {
            a.C0454a b = us.pinguo.ui.b.a.b(this, getString(R.string.load_more));
            this.f6997d = b;
            if (b != null) {
                b.e();
            }
            new ApiGetAlbumBackStatus(this, d2.h().userId).get(new a());
        }
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
        if (i2 == this.b) {
            if (i3 == -1) {
                startActivity(new Intent(this, PGAlbumGetBackByEmailActivity.class));
            } else if (i3 == 1) {
                finish();
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (((com.pinguo.camera360.request.AlbumGetBackStatusInfo) r3.data).status == com.pinguo.camera360.request.AlbumGetBackStatusInfo.AlbumGetBackStatus.ALBUM_GET_BACK_STATUS_HANDING.status) goto L11;
     */
    @Override // android.view.View.OnClickListener
    @com.growingio.android.sdk.instrumentation.Instrumented
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r3) {
        /*
            r2 = this;
            com.growingio.android.sdk.autoburry.VdsAgent.onClick(r2, r3)
            java.lang.String r0 = "v"
            kotlin.jvm.internal.s.h(r3, r0)
            int r3 = r3.getId()
            r0 = 2131296519(0x7f090107, float:1.8210957E38)
            if (r3 != r0) goto L8b
            com.pinguo.camera360.request.AlbumGetBackStatusResponse r3 = r2.c
            if (r3 == 0) goto L7b
            kotlin.jvm.internal.s.e(r3)
            T r3 = r3.data
            if (r3 == 0) goto L6b
            com.pinguo.camera360.request.AlbumGetBackStatusResponse r3 = r2.c
            kotlin.jvm.internal.s.e(r3)
            T r3 = r3.data
            com.pinguo.camera360.request.AlbumGetBackStatusInfo r3 = (com.pinguo.camera360.request.AlbumGetBackStatusInfo) r3
            int r3 = r3.status
            com.pinguo.camera360.request.AlbumGetBackStatusInfo$AlbumGetBackStatus r0 = com.pinguo.camera360.request.AlbumGetBackStatusInfo.AlbumGetBackStatus.ALBUM_GET_BACK_STATUS_FINISHED
            int r0 = r0.status
            if (r3 == r0) goto L3e
            com.pinguo.camera360.request.AlbumGetBackStatusResponse r3 = r2.c
            kotlin.jvm.internal.s.e(r3)
            T r3 = r3.data
            com.pinguo.camera360.request.AlbumGetBackStatusInfo r3 = (com.pinguo.camera360.request.AlbumGetBackStatusInfo) r3
            int r3 = r3.status
            com.pinguo.camera360.request.AlbumGetBackStatusInfo$AlbumGetBackStatus r0 = com.pinguo.camera360.request.AlbumGetBackStatusInfo.AlbumGetBackStatus.ALBUM_GET_BACK_STATUS_HANDING
            int r0 = r0.status
            if (r3 != r0) goto L6b
        L3e:
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<com.pinguo.camera360.ui.PGAlbumGetBackStatusActivity> r0 = com.pinguo.camera360.ui.PGAlbumGetBackStatusActivity.class
            r3.<init>(r2, r0)
            com.pinguo.camera360.request.AlbumGetBackStatusResponse r0 = r2.c
            kotlin.jvm.internal.s.e(r0)
            T r0 = r0.data
            com.pinguo.camera360.request.AlbumGetBackStatusInfo r0 = (com.pinguo.camera360.request.AlbumGetBackStatusInfo) r0
            java.lang.String r0 = r0.email
            java.lang.String r1 = "email"
            r3.putExtra(r1, r0)
            com.pinguo.camera360.request.AlbumGetBackStatusResponse r0 = r2.c
            kotlin.jvm.internal.s.e(r0)
            T r0 = r0.data
            com.pinguo.camera360.request.AlbumGetBackStatusInfo r0 = (com.pinguo.camera360.request.AlbumGetBackStatusInfo) r0
            int r0 = r0.status
            java.lang.String r1 = "status"
            r3.putExtra(r1, r0)
            int r0 = r2.b
            r2.startActivityForResult(r3, r0)
            goto L8b
        L6b:
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            java.lang.Class<com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity> r0 = com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity.class
            r3.setClass(r2, r0)
            int r0 = r2.b
            r2.startActivityForResult(r3, r0)
            goto L8b
        L7b:
            android.content.Intent r3 = r2.getIntent()
            java.lang.Class<com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity> r0 = com.pinguo.camera360.ui.PGAlbumGetBackByEmailActivity.class
            r3.setClass(r2, r0)
            android.content.Intent r3 = r2.getIntent()
            r2.startActivity(r3)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.ui.PGAlbumServicePauseActivity.onClick(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pgalbum_service_pause);
        initView();
        AlbumGetBackStatusResponse albumGetBackStatusResponse = (AlbumGetBackStatusResponse) getIntent().getParcelableExtra("AlbumGetBackStatusResponse");
        this.c = albumGetBackStatusResponse;
        if (albumGetBackStatusResponse == null) {
            s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f6997d != null) {
            this.f6997d = null;
        }
    }
}
