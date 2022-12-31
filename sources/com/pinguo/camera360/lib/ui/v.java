package com.pinguo.camera360.lib.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import java.io.File;
import java.util.List;
import us.pinguo.camera360.shop.data.install.FilterOperateManager;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowScene;
import us.pinguo.camera360.shop.data.show.UnlockType;
import us.pinguo.inspire.api.Payload;
import us.pinguo.webview.PGJsWebView;
import vStudio.Android.Camera360.R;
/* compiled from: WebUriParser.java */
/* loaded from: classes3.dex */
public class v implements us.pinguo.camera360.shop.data.install.p {
    private Activity a;
    private com.pinguo.camera360.lib.ui.js.b b;
    private PGJsWebView c;

    /* renamed from: d  reason: collision with root package name */
    private b f6848d;

    /* renamed from: e  reason: collision with root package name */
    private AlertDialog f6849e;

    /* renamed from: f  reason: collision with root package name */
    private String f6850f;

    /* renamed from: g  reason: collision with root package name */
    private String f6851g;

    /* renamed from: h  reason: collision with root package name */
    private String f6852h;

    /* renamed from: i  reason: collision with root package name */
    private int f6853i = 3;

    /* renamed from: j  reason: collision with root package name */
    private int f6854j = 3;

    /* renamed from: k  reason: collision with root package name */
    private int f6855k = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebUriParser.java */
    /* loaded from: classes3.dex */
    public class a implements us.pinguo.camera360.shop.data.show.s {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void a() {
            if (v.this.f6849e != null) {
                v.this.f6849e.dismiss();
            }
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void b(List<ShowScene> list) {
            ShowPkg h2 = us.pinguo.camera360.shop.data.show.u.b().h(this.a);
            if (h2 == null) {
                if (v.this.f6849e != null) {
                    v.this.f6849e.dismiss();
                    return;
                }
                return;
            }
            v.this.h(h2);
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void c(Exception exc) {
            if (v.this.f6849e != null) {
                v.this.f6849e.dismiss();
            }
        }
    }

    /* compiled from: WebUriParser.java */
    /* loaded from: classes3.dex */
    public interface b {
        void x(String str);
    }

    public v(Activity activity, com.pinguo.camera360.lib.ui.js.b bVar, PGJsWebView pGJsWebView, b bVar2) {
        this.a = activity;
        this.b = bVar;
        this.c = pGJsWebView;
        this.f6848d = bVar2;
    }

    private void g(final String str) {
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: com.pinguo.camera360.lib.ui.b
            @Override // java.lang.Runnable
            public final void run() {
                v.this.m(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ShowPkg showPkg) {
        if (showPkg == null) {
            AlertDialog alertDialog = this.f6849e;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        } else if (showPkg.getType() != UnlockType.FREE) {
            p(showPkg.getId(), null, null);
            AlertDialog alertDialog2 = this.f6849e;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
                this.f6849e = null;
            }
        } else {
            FilterOperateManager.h().q(showPkg.getId(), this);
            FilterOperateManager.h().m(showPkg);
        }
    }

    private void i(Uri uri) {
        try {
            String queryParameter = uri.getQueryParameter("cameraType");
            if (!TextUtils.isEmpty(queryParameter)) {
                this.f6853i = Integer.valueOf(queryParameter).intValue();
            }
            String queryParameter2 = uri.getQueryParameter("camera");
            if (!TextUtils.isEmpty(queryParameter2)) {
                this.f6854j = Integer.valueOf(queryParameter2).intValue();
            }
            String queryParameter3 = uri.getQueryParameter("stickerType");
            if (TextUtils.isEmpty(queryParameter3)) {
                return;
            }
            this.f6855k = Integer.valueOf(queryParameter3).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean j(String str) {
        return FilterOperateManager.h().k(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(final String str) {
        AlertDialog r = us.pinguo.foundation.utils.w.r(this.a, R.string.downloading, R.string.downloading);
        this.f6849e = r;
        r.setCanceledOnTouchOutside(false);
        this.f6849e.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.pinguo.camera360.lib.ui.c
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                FilterOperateManager.h().f(str);
            }
        });
        ShowPkg h2 = us.pinguo.camera360.shop.data.show.u.b().h(str);
        if (h2 == null) {
            us.pinguo.camera360.shop.data.show.u.b().r(new a(str), true);
        } else {
            h(h2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(us.pinguo.camera360.shop.data.install.q qVar) {
        AlertDialog alertDialog = this.f6849e;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (qVar.d()) {
            p(qVar.c(), this.f6852h, this.f6850f);
        }
    }

    private void p(String str, String str2, String str3) {
        String b2 = t.b();
        if (b2 == null) {
            this.b.d(this.c, new com.pinguo.camera360.lib.ui.js.g(Payload.SERVER_ERROR_CODE_10501, "error"));
            this.b = null;
            return;
        }
        Uri fromFile = Uri.fromFile(new File(b2));
        b bVar = this.f6848d;
        if (bVar != null) {
            bVar.x(b2);
        }
        Intent intent = new Intent();
        intent.setAction("com.camera360.inspire_IMAGE_CAPTURE");
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("bundle_key_is_sticker", str3);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("bundle_key_package", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("bundle_key_filter", str2);
        }
        intent.putExtra("camera_type", this.f6853i);
        intent.putExtra("key_cam", this.f6854j);
        intent.putExtra("bundle_key_sticker_goto_type", this.f6855k);
        intent.putExtra("output", fromFile);
        this.a.startActivityForResult(intent, 1003);
    }

    @Override // us.pinguo.camera360.shop.data.install.p
    public void a(final us.pinguo.camera360.shop.data.install.q qVar) {
        FilterOperateManager.h().u(qVar.c());
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: com.pinguo.camera360.lib.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                v.this.o(qVar);
            }
        });
    }

    @Override // us.pinguo.camera360.shop.data.install.p
    public void b(String str) {
    }

    @Override // us.pinguo.camera360.shop.data.install.p
    public void c(String str, int i2) {
    }

    public void f() {
        AlertDialog alertDialog = this.f6849e;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f6849e = null;
        }
    }

    public boolean q(Uri uri) {
        if ("camera".equals(uri.getLastPathSegment())) {
            this.f6850f = uri.getQueryParameter("isSticker");
            this.f6851g = uri.getQueryParameter("pkgId");
            this.f6852h = uri.getQueryParameter("filterId");
            i(uri);
            if (!TextUtils.isEmpty(this.f6850f) && "true".equals(this.f6850f)) {
                p(this.f6851g, this.f6852h, this.f6850f);
                return true;
            } else if (TextUtils.isEmpty(this.f6851g)) {
                p(null, null, "false");
                return true;
            } else {
                if (j(this.f6851g)) {
                    p(this.f6851g, this.f6852h, this.f6850f);
                } else {
                    g(this.f6851g);
                }
                return true;
            }
        }
        return false;
    }
}
