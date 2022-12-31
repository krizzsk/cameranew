package com.pinguo.camera360.n.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.foundation.statistics.k;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.push.PushResult;
import us.pinguo.push.h;
import vStudio.Android.Camera360.R;
/* compiled from: PushDialogControl.java */
/* loaded from: classes3.dex */
public class b extends us.pinguo.push.c {
    private static C0246b[] n;

    /* renamed from: i  reason: collision with root package name */
    private String f6927i = null;

    /* renamed from: j  reason: collision with root package name */
    private String f6928j = null;

    /* renamed from: k  reason: collision with root package name */
    private String f6929k = null;

    /* renamed from: l  reason: collision with root package name */
    private String f6930l = null;
    private com.pinguo.camera360.n.b.a m;

    /* compiled from: PushDialogControl.java */
    /* loaded from: classes3.dex */
    class a extends com.facebook.imagepipeline.a.b {
        final /* synthetic */ b a;
        final /* synthetic */ Context b;
        final /* synthetic */ Intent c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.facebook.datasource.b f6931d;

        a(b bVar, Context context, Intent intent, com.facebook.datasource.b bVar2) {
            this.a = bVar;
            this.b = context;
            this.c = intent;
            this.f6931d = bVar2;
        }

        @Override // com.facebook.datasource.a
        protected void e(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> bVar) {
            String str = this.a.f6930l;
            str.hashCode();
            if (!str.equals("3")) {
                b.this.p(this.b, null, this.c);
            } else {
                b.this.o(this.b, null, this.c);
            }
            bVar.close();
        }

        @Override // com.facebook.imagepipeline.a.b
        protected void g(Bitmap bitmap) {
            String str = this.a.f6930l;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    b.this.p(this.b, bitmap, this.c);
                    break;
                case 2:
                    b.this.o(this.b, bitmap, this.c);
                    break;
                default:
                    b.this.p(this.b, null, this.c);
                    break;
            }
            this.f6931d.close();
        }
    }

    /* compiled from: PushDialogControl.java */
    /* renamed from: com.pinguo.camera360.n.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0246b {
        private String a = null;
        private String b = null;

        public String c() {
            return this.b;
        }

        public String d() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(Context context, Bitmap bitmap, Intent intent) {
        com.pinguo.camera360.n.a.c(context, e(), bitmap, intent, true, d());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(Context context, Bitmap bitmap, Intent intent) {
        if (bitmap != null) {
            com.pinguo.camera360.n.a.e(context, e(), true, intent, bitmap, d(), this.m);
            return true;
        }
        com.pinguo.camera360.n.a.f(context, e(), true, intent, d(), this.m);
        return true;
    }

    @Override // us.pinguo.push.c
    public PushResult j() {
        String str;
        String str2 = "";
        Context d2 = BaseApplication.d();
        h d3 = d();
        b bVar = (b) this.f11775h;
        String str3 = bVar.f6927i;
        String str4 = bVar.f6928j;
        C0246b[] c0246bArr = n;
        try {
            str = c0246bArr[0].c();
        } catch (Exception e2) {
            e = e2;
            str = "";
        }
        try {
            str2 = c0246bArr[0].d();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            String d4 = c0246bArr[1].d();
            String c = c0246bArr[1].c();
            Intent intent = new Intent();
            intent.setClassName(d2, "com.pinguo.camera360.push.utils.PushDialogActivity");
            intent.putExtra("type", 3);
            intent.putExtra("dialog_title", str3);
            intent.putExtra("dialog_msg", str4);
            intent.putExtra("btn_txt_1", str2);
            intent.putExtra("btn_link_1", str);
            intent.putExtra("btn_txt_2", d4);
            intent.putExtra("btn_link_2", c);
            if (d3 == null) {
            }
            return PushResult.UNDO;
        }
        String d42 = c0246bArr[1].d();
        String c2 = c0246bArr[1].c();
        Intent intent2 = new Intent();
        intent2.setClassName(d2, "com.pinguo.camera360.push.utils.PushDialogActivity");
        intent2.putExtra("type", 3);
        intent2.putExtra("dialog_title", str3);
        intent2.putExtra("dialog_msg", str4);
        intent2.putExtra("btn_txt_1", str2);
        intent2.putExtra("btn_link_1", str);
        intent2.putExtra("btn_txt_2", d42);
        intent2.putExtra("btn_link_2", c2);
        if (d3 == null && f() == 1) {
            intent2.putExtra("web_view_push_id", b());
            k.e(3, b());
            k.h(b());
            us.pinguo.common.log.a.r("newPush", "pushDialog", new Object[0]);
            String str5 = bVar.f6929k;
            if (str5 == null) {
                us.pinguo.push.d dVar = new us.pinguo.push.d();
                dVar.k(e());
                dVar.g(R.mipmap.ic_launcher);
                dVar.h(R.mipmap.ic_md_push);
                dVar.l(d3.b());
                dVar.j(d3.a());
                dVar.i(intent2);
                if (us.pinguo.push.g.a(dVar, true)) {
                    us.pinguo.common.log.a.r("newPush", "notify success", new Object[0]);
                    return PushResult.SUCCESS;
                }
                return PushResult.FAIL;
            }
            ImageRequestBuilder s = ImageRequestBuilder.s(Uri.parse(str5));
            s.A(true);
            com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b = com.facebook.drawee.backends.pipeline.c.a().b(s.a(), d2);
            b.d(new a(bVar, d2, intent2, b), UiThreadImmediateExecutorService.getInstance());
            us.pinguo.common.log.a.r("newPush", "notify success", new Object[0]);
            return PushResult.SUCCESS;
        }
        return PushResult.UNDO;
    }

    @Override // us.pinguo.push.c
    /* renamed from: n */
    public b i(String str) {
        try {
            us.pinguo.common.log.a.m("newPush", "dialog push： " + str, new Object[0]);
            JSONObject jSONObject = new JSONObject(str);
            b bVar = new b();
            bVar.f6927i = jSONObject.getString("title");
            bVar.f6928j = jSONObject.getString("msg");
            if (jSONObject.has("url")) {
                bVar.f6929k = jSONObject.getString("url");
            }
            if (jSONObject.has("notifyType")) {
                bVar.f6930l = jSONObject.getString("notifyType");
            }
            JSONArray jSONArray = jSONObject.getJSONArray(TJAdUnitConstants.String.BUTTONS);
            int length = jSONArray.length();
            n = new C0246b[length];
            us.pinguo.common.log.a.m("newPush", "jsonArray： " + length + jSONArray, new Object[0]);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                us.pinguo.common.log.a.m("newPush", "jsonArray:" + jSONArray.getJSONObject(i2).getString("text"), new Object[0]);
                C0246b[] c0246bArr = n;
                c0246bArr[i2] = new C0246b();
                c0246bArr[i2].a = jSONArray.getJSONObject(i2).getString("text");
                n[i2].b = jSONArray.getJSONObject(i2).getString("link");
            }
            this.m = new com.pinguo.camera360.n.b.a();
            if (jSONObject.has("buttonType")) {
                this.m.a = jSONObject.getInt("buttonType");
            }
            if (jSONObject.has("buttonColor")) {
                this.m.b = jSONObject.getString("buttonColor");
            }
            if (jSONObject.has("buttonContent")) {
                this.m.c = jSONObject.getString("buttonContent");
            }
            return bVar;
        } catch (Exception e2) {
            us.pinguo.common.log.a.m("newPush", "push error:" + e2, new Object[0]);
            e2.printStackTrace();
            return null;
        }
    }
}
