package com.pinguo.camera360.n.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.pinguo.camera360.k.b.a;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
import us.pinguo.foundation.statistics.k;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.push.PushResult;
import us.pinguo.push.h;
import vStudio.Android.Camera360.R;
/* compiled from: PushWebControl.java */
/* loaded from: classes3.dex */
public class g extends us.pinguo.push.c {

    /* renamed from: i  reason: collision with root package name */
    private String f6945i = null;

    /* renamed from: j  reason: collision with root package name */
    private String f6946j = null;

    /* renamed from: k  reason: collision with root package name */
    private String f6947k = null;

    /* renamed from: l  reason: collision with root package name */
    private String f6948l = null;
    private String m = null;
    private com.pinguo.camera360.n.b.a n;

    /* compiled from: PushWebControl.java */
    /* loaded from: classes3.dex */
    class a extends com.facebook.imagepipeline.a.b {
        final /* synthetic */ Context a;
        final /* synthetic */ Intent b;
        final /* synthetic */ com.facebook.datasource.b c;

        a(Context context, Intent intent, com.facebook.datasource.b bVar) {
            this.a = context;
            this.b = intent;
            this.c = bVar;
        }

        @Override // com.facebook.datasource.a
        protected void e(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> bVar) {
            String str = g.this.m;
            str.hashCode();
            if (str.equals("2")) {
                us.pinguo.common.log.a.m("chenxiaokai", "----->图片下载失败" + bVar.c(), new Object[0]);
                g.this.q(this.a, null, this.b);
            } else if (!str.equals("3")) {
                g.this.q(this.a, null, this.b);
            } else {
                us.pinguo.common.log.a.m("chenxiaokai", "----->图片下载失败" + bVar.c(), new Object[0]);
                g.this.p(this.a, null, this.b);
            }
            bVar.close();
        }

        @Override // com.facebook.imagepipeline.a.b
        protected void g(Bitmap bitmap) {
            String str = g.this.m;
            str.hashCode();
            if (str.equals("2")) {
                g.this.q(this.a, bitmap, this.b);
            } else if (!str.equals("3")) {
                g.this.q(this.a, null, this.b);
            } else {
                g.this.p(this.a, bitmap, this.b);
            }
            this.c.close();
        }
    }

    private String n(String str) {
        com.pinguo.camera360.n.b.a aVar = this.n;
        return (aVar == null || aVar.a != 1) ? str : "1".equals(str) ? "7" : "2".equals(str) ? Constants.VIA_SHARE_TYPE_PUBLISHVIDEO : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(Context context, Bitmap bitmap, Intent intent) {
        T t = this.f11775h;
        if (t != 0 && (t instanceof g)) {
            g gVar = (g) t;
            String str = gVar.f6946j;
            String str2 = gVar.f6948l;
            String str3 = bitmap == null ? "1" : "3";
            intent.putExtra("show_type", str3);
            k.j("show", b(), str, str2, str3, gVar.m);
        }
        com.pinguo.camera360.n.a.c(context, e(), bitmap, intent, false, d());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(Context context, Bitmap bitmap, Intent intent) {
        T t = this.f11775h;
        if (t != 0 && (t instanceof g)) {
            g gVar = (g) t;
            String str = gVar.f6946j;
            String str2 = gVar.f6948l;
            String n = n(bitmap == null ? "1" : "2");
            intent.putExtra("show_type", n);
            k.j("show", b(), str, str2, n, gVar.m);
        }
        if (bitmap != null) {
            com.pinguo.camera360.n.a.e(context, e(), false, intent, bitmap, d(), this.n);
            return true;
        }
        com.pinguo.camera360.n.a.f(context, e(), false, intent, d(), this.n);
        return true;
    }

    @Override // us.pinguo.push.c
    public PushResult j() {
        Intent intent;
        g gVar = (g) this.f11775h;
        h d2 = d();
        String str = gVar.f6945i;
        String str2 = gVar.f6946j;
        String str3 = gVar.f6947k;
        us.pinguo.common.log.a.c("pushWebControl,link:" + str2, new Object[0]);
        String queryParameter = Uri.parse(str2).getQueryParameter("clickUrlInner");
        if (!TextUtils.isEmpty(queryParameter) && "1".equals(queryParameter.trim())) {
            intent = new Intent();
            intent.setClassName(BaseApplication.d(), "com.pinguo.camera360.lib.ui.WebViewActivity");
            intent.setFlags(603979776);
            intent.putExtra("web_view_url", str2);
            intent.putExtra("web_view_from", com.adjust.sdk.Constants.PUSH);
            a.C0243a.h(str2);
        } else {
            us.pinguo.common.log.a.m("newPush", "link: " + str2, new Object[0]);
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str2));
            intent2.setFlags(603979776);
            intent2.putExtra("title", str);
            intent2.putExtra("return", str3);
            intent = intent2;
        }
        if (f() == 1 && d2 != null) {
            intent.putExtra("web_view_push_id", b());
            intent.putExtra("web_view_url", str2);
            intent.putExtra("ad_url", this.f6948l);
            intent.putExtra("notify_type", this.m);
            Context d3 = BaseApplication.d();
            if (TextUtils.isEmpty(gVar.f6948l)) {
                us.pinguo.push.d dVar = new us.pinguo.push.d();
                dVar.k(e());
                dVar.g(R.mipmap.ic_launcher);
                dVar.h(R.mipmap.ic_md_push);
                dVar.l(d2.b());
                dVar.j(d2.a());
                dVar.i(intent);
                if (com.pinguo.camera360.n.a.g(d3, dVar, true)) {
                    k.j("show", b(), str2, this.f6948l, n("1"), gVar.m);
                    return PushResult.SUCCESS;
                }
                return PushResult.FAIL;
            }
            ImageRequestBuilder s = ImageRequestBuilder.s(Uri.parse(this.f6948l));
            s.A(true);
            com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b = com.facebook.drawee.backends.pipeline.c.a().b(s.a(), d3);
            b.d(new a(d3, intent, b), UiThreadImmediateExecutorService.getInstance());
            us.pinguo.common.log.a.r("newPush", "notify success", new Object[0]);
            return PushResult.SUCCESS;
        }
        return PushResult.UNDO;
    }

    @Override // us.pinguo.push.c
    /* renamed from: o */
    public g i(String str) {
        try {
            us.pinguo.common.log.a.c("pushWebControl,json:" + str, new Object[0]);
            JSONObject jSONObject = new JSONObject(str);
            g gVar = new g();
            gVar.f6945i = jSONObject.getString("title");
            gVar.f6946j = jSONObject.getString("link");
            gVar.f6947k = jSONObject.getString("return");
            if (jSONObject.has("url")) {
                gVar.f6948l = jSONObject.getString("url");
            }
            if (jSONObject.has("notifyType")) {
                gVar.m = jSONObject.getString("notifyType");
            }
            this.n = new com.pinguo.camera360.n.b.a();
            if (jSONObject.has("buttonType")) {
                this.n.a = jSONObject.getInt("buttonType");
            }
            if (jSONObject.has("buttonColor")) {
                this.n.b = jSONObject.getString("buttonColor");
            }
            if (jSONObject.has("buttonContent")) {
                this.n.c = jSONObject.getString("buttonContent");
            }
            k.j("receive", b(), gVar.f6946j, gVar.f6948l, n(gVar.m), gVar.m);
            return gVar;
        } catch (Exception e2) {
            us.pinguo.common.log.a.m("newPush", "push error:" + e2, new Object[0]);
            e2.printStackTrace();
            return null;
        }
    }
}
