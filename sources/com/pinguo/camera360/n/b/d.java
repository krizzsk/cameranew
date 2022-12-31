package com.pinguo.camera360.n.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.pinguo.camera360.adv.interaction.Interaction;
import com.pinguo.camera360.k.b.a;
import com.tencent.connect.common.Constants;
import java.util.Calendar;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.k;
import us.pinguo.foundation.statistics.l;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.push.PushResult;
import us.pinguo.push.h;
import us.pinguo.user.s0;
import vStudio.Android.Camera360.R;
/* compiled from: PushSimpleControl.java */
/* loaded from: classes3.dex */
public class d extends us.pinguo.push.c {
    private static c p = new c();

    /* renamed from: l  reason: collision with root package name */
    private String f6936l;
    private com.pinguo.camera360.n.b.a m;
    private Intent n;

    /* renamed from: i  reason: collision with root package name */
    private String f6933i = null;

    /* renamed from: j  reason: collision with root package name */
    private String f6934j = null;

    /* renamed from: k  reason: collision with root package name */
    private String f6935k = null;
    private boolean o = true;

    /* compiled from: PushSimpleControl.java */
    /* loaded from: classes3.dex */
    class a extends com.facebook.imagepipeline.a.b {
        final /* synthetic */ String a;
        final /* synthetic */ Context b;
        final /* synthetic */ com.facebook.datasource.b c;

        a(String str, Context context, com.facebook.datasource.b bVar) {
            this.a = str;
            this.b = context;
            this.c = bVar;
        }

        @Override // com.facebook.datasource.a
        protected void e(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> bVar) {
            String str = this.a;
            str.hashCode();
            if (str.equals("2")) {
                us.pinguo.common.log.a.m("chenxiaokai", "----->图片下载失败" + bVar.c(), new Object[0]);
                if ("5976eefb8852d6140a235ed7".equals(d.this.b())) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(this.b.getResources(), R.drawable.ic_localpush);
                    d dVar = d.this;
                    dVar.u(this.b, decodeResource, dVar.n, d.this.o);
                } else {
                    d dVar2 = d.this;
                    dVar2.u(this.b, null, dVar2.n, d.this.o);
                }
            } else if (!str.equals("3")) {
                d dVar3 = d.this;
                dVar3.u(this.b, null, dVar3.n, d.this.o);
            } else {
                us.pinguo.common.log.a.m("chenxiaokai", "----->图片下载失败" + bVar.c(), new Object[0]);
                d dVar4 = d.this;
                dVar4.t(this.b, null, dVar4.n, d.this.o);
            }
            bVar.close();
        }

        @Override // com.facebook.imagepipeline.a.b
        protected void g(Bitmap bitmap) {
            String str = this.a;
            str.hashCode();
            if (str.equals("2")) {
                d dVar = d.this;
                dVar.u(this.b, bitmap, dVar.n, d.this.o);
            } else if (!str.equals("3")) {
                d dVar2 = d.this;
                dVar2.u(this.b, null, dVar2.n, d.this.o);
            } else {
                d dVar3 = d.this;
                dVar3.t(this.b, bitmap, dVar3.n, d.this.o);
            }
            this.c.close();
        }
    }

    private String p(String str) {
        com.pinguo.camera360.n.b.a aVar = this.m;
        return (aVar == null || aVar.a != 1) ? str : "1".equals(str) ? "7" : "2".equals(str) ? Constants.VIA_SHARE_TYPE_PUBLISHVIDEO : str;
    }

    private boolean q(String str) {
        return str.contains("app://inspire/attention") || str.contains("app://inspire/comment") || str.contains("app://inspire/at") || str.contains("app://inspire/like") || str.contains("app://inspire/vote") || str.contains("app://inspire/system") || str.contains("app://inspire/award");
    }

    private void s(int i2, String str) {
        String str2;
        if (i2 != 99) {
            switch (i2) {
                case -1:
                    str2 = "push_receive";
                    break;
                case 0:
                    str2 = "push_show_success";
                    break;
                case 1:
                    str2 = "push_error_json";
                    break;
                case 2:
                    str2 = "push_not_time";
                    break;
                case 3:
                    str2 = "push_time_out";
                    break;
                case 4:
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    str2 = "push_in_night_" + calendar.get(11);
                    break;
                case 5:
                    str2 = "push_has_pushed";
                    break;
                case 6:
                    str2 = "push_show_error";
                    break;
                default:
                    str2 = "push_default";
                    break;
            }
        } else {
            str2 = "push_other_error";
        }
        String b = b();
        if (TextUtils.isEmpty(str)) {
            str = "empty";
        } else {
            int indexOf = str.indexOf(63);
            if (indexOf > 0) {
                str = str.substring(0, indexOf);
            }
        }
        if (TextUtils.isEmpty(b)) {
            b = "empty";
        }
        String str3 = "push_id=" + b + ",push_type=" + str + ",action=" + str2 + ",is_active=error,show_type=error";
        if (us.pinguo.foundation.d.f10987f) {
            Log.e("push_error", str3);
        }
        l.i(us.pinguo.foundation.e.b(), "push_action", str3);
        us.pinguo.foundation.statistics.b.b(b, str, str2, "error", "error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(Context context, Bitmap bitmap, Intent intent, boolean z) {
        T t = this.f11775h;
        if (t != 0 && (t instanceof d)) {
            d dVar = (d) t;
            String str = dVar.f6933i;
            String str2 = dVar.f6934j;
            String str3 = bitmap == null ? "1" : "3";
            intent.putExtra("show_type", str3);
            k.j("show", b(), str, str2, p(str3), intent.getStringExtra("notify_type"));
        }
        com.pinguo.camera360.n.a.c(context, e(), bitmap, intent, z, d());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(Context context, Bitmap bitmap, Intent intent, boolean z) {
        T t = this.f11775h;
        if (t != 0 && (t instanceof d)) {
            d dVar = (d) t;
            String str = dVar.f6933i;
            String str2 = dVar.f6934j;
            String p2 = p(bitmap == null ? "1" : "2");
            intent.putExtra("show_type", p2);
            k.j("show", b(), str, str2, p2, intent.getStringExtra("notify_type"));
        }
        try {
            if (bitmap != null) {
                com.pinguo.camera360.n.a.e(context, e(), z, intent, bitmap, d(), this.m);
                return true;
            }
            com.pinguo.camera360.n.a.f(context, e(), z, intent, d(), this.m);
            return true;
        } catch (Throwable th) {
            if (us.pinguo.foundation.d.f10987f) {
                throw new RuntimeException(th);
            }
            return false;
        }
    }

    @Override // us.pinguo.push.c
    public void h(int i2, String str) {
        s(i2, this.f6933i);
    }

    @Override // us.pinguo.push.c
    public PushResult j() {
        Context d2 = BaseApplication.d();
        h d3 = d();
        d dVar = (d) this.f11775h;
        String str = dVar.f6933i;
        this.f6933i = str;
        String str2 = dVar.f6934j;
        String str3 = dVar.f6935k;
        String str4 = dVar.f6936l;
        this.n = new Intent();
        us.pinguo.common.log.a.r("newPush", "before update link:" + str, new Object[0]);
        this.o = true;
        if ("app://pinguo.android.team.cameraView".equals(str)) {
            Intent intent = new Intent("us.pinguo.camera360.EFFECT_IMAGE_CAPTURE");
            this.n = intent;
            intent.setFlags(603979776);
            this.n.putExtra("app://pinguo.android.team.cameraView", "app://pinguo.android.team.cameraView");
            if (!TextUtils.isEmpty(str4)) {
                this.n.putExtra("stickerUnityId", str4);
            }
        } else if ("app://pinguo.android.team.albumView".equals(str)) {
            Intent intent2 = new Intent("us.pinguo.camera360.GALLERY");
            this.n = intent2;
            intent2.setFlags(603979776);
            this.n.putExtra("app://pinguo.android.team.albumView", "app://pinguo.android.team.albumView");
        } else if ("app://pinguo.android.team.feedback".equals(str)) {
            Intent intent3 = new Intent("us.pinguo.camera360.FEEDBACK");
            this.n = intent3;
            intent3.setFlags(603979776);
            this.n.putExtra("app://pinguo.android.team.feedback", "app://pinguo.android.team.feedback");
        } else if ("app://pinguo.android.team.new_welcome_ad".equals(str)) {
            AdvConfigManager.getInstance().loadDownloadedImage("83e8038d279dd0745afb5c0d6c727aa7");
        } else if ("app://com.pinguo.camera360.mycenter.MsgCenterActivity".equals(str)) {
            Intent intent4 = new Intent("us.pinguo.camera360.FEEDBACK");
            this.n = intent4;
            intent4.setFlags(603979776);
            this.n.putExtra("app://com.pinguo.camera360.mycenter.MsgCenterActivity", "app://com.pinguo.camera360.mycenter.MsgCenterActivity");
        } else if (!str.startsWith("app://camera360/") && !str.startsWith("component://")) {
            if (!str.startsWith(com.growingio.android.sdk.collection.Constants.HTTP_PROTOCOL_PREFIX) && !str.startsWith(com.growingio.android.sdk.collection.Constants.HTTPS_PROTOCOL_PREFIX)) {
                if (str.contains("app://inspire/pcmessagelist")) {
                    us.pinguo.common.log.a.m("newPush", "inspire-achievement", new Object[0]);
                    Intent a2 = p.a(d2, str);
                    a2.putExtra("web_view_from", com.adjust.sdk.Constants.PUSH);
                    if (a2 != null) {
                        this.n = a2;
                    }
                } else if (q(str)) {
                    us.pinguo.common.log.a.m("newPush", "inspire-comment", new Object[0]);
                    Intent a3 = p.a(d2, str);
                    a3.putExtra("web_view_from", com.adjust.sdk.Constants.PUSH);
                    if (a3 != null) {
                        this.n = a3;
                    }
                    if (TextUtils.isEmpty(s0.getInstance().getUserId())) {
                        us.pinguo.common.log.a.r("newPush", "notify msg success but not login", new Object[0]);
                        return PushResult.SUCCESS;
                    }
                } else {
                    this.o = false;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("key_task_detail_from_push", true);
                    this.n = AppGoto.getInstance().b(Uri.parse(str)).d(bundle).a(d2);
                }
            } else {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("clickUrlInner");
                if (!TextUtils.isEmpty(queryParameter) && "1".equals(queryParameter.trim())) {
                    Intent intent5 = new Intent();
                    this.n = intent5;
                    intent5.setClassName(d2, "com.pinguo.camera360.lib.ui.WebViewActivity");
                    this.n.setFlags(603979776);
                    this.n.putExtra("web_view_url", str);
                    this.n.putExtra("web_view_from", com.adjust.sdk.Constants.PUSH);
                    a.C0243a.h(str);
                } else {
                    Intent intent6 = new Intent("android.intent.action.VIEW", parse);
                    this.n = intent6;
                    intent6.setFlags(603979776);
                }
            }
        } else {
            us.pinguo.common.log.a.r("newPush", "intentUrl: " + str, new Object[0]);
            if (Interaction.syncValidAndUpdate(str)) {
                this.n.setAction("us.pinguo.camera360.MARKET_OPERATIONS");
                this.n.putExtra("market_operations_link", str);
                this.n.putExtra("web_view_from", com.adjust.sdk.Constants.PUSH);
            } else {
                return PushResult.FAIL;
            }
        }
        if (f() != 1) {
            d3 = null;
        }
        if (d3 == null) {
            us.pinguo.common.log.a.m("newPush", "notify is null", new Object[0]);
            return PushResult.SUCCESS;
        }
        this.n.putExtra("web_view_push_id", b());
        this.n.putExtra("web_view_url", str);
        this.n.putExtra("ad_url", str2);
        this.n.putExtra("notify_type", str3);
        if (TextUtils.isEmpty(str2)) {
            com.pinguo.camera360.n.b.a aVar = this.m;
            if (aVar != null && aVar.a == 1) {
                if ("3".equals(str3)) {
                    t(d2, null, this.n, this.o);
                } else {
                    com.pinguo.camera360.n.a.f(d2, e(), this.o, this.n, d(), this.m);
                }
                us.pinguo.common.log.a.r("newPush", "has button no icon notify success", new Object[0]);
                return PushResult.SUCCESS;
            }
            us.pinguo.push.d dVar2 = new us.pinguo.push.d();
            dVar2.k(e());
            dVar2.g(R.mipmap.ic_launcher);
            dVar2.h(R.mipmap.ic_md_push);
            dVar2.l(d3.b());
            dVar2.j(d3.a());
            dVar2.i(this.n);
            if (com.pinguo.camera360.n.a.g(d2, dVar2, this.o)) {
                us.pinguo.common.log.a.r("newPush", "notify success", new Object[0]);
                k.j("show", b(), str, str2, p("1"), str3);
                return PushResult.SUCCESS;
            }
            us.pinguo.common.log.a.r("newPush", "notify fail", new Object[0]);
            return PushResult.FAIL;
        }
        ImageRequestBuilder s = ImageRequestBuilder.s(Uri.parse(str2));
        s.A(true);
        com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b = com.facebook.drawee.backends.pipeline.c.a().b(s.a(), d2);
        b.d(new a(str3, d2, b), UiThreadImmediateExecutorService.getInstance());
        us.pinguo.common.log.a.r("newPush", "notify success", new Object[0]);
        return PushResult.SUCCESS;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    @Override // us.pinguo.push.c
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.pinguo.camera360.n.b.d i(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "buttonContent"
            java.lang.String r1 = "buttonColor"
            java.lang.String r2 = "buttonType"
            java.lang.String r3 = "url"
            java.lang.String r4 = "newPush"
            java.lang.String r5 = "notifyType"
            r6 = 0
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Exception -> L27
            r7.<init>(r12)     // Catch: java.lang.Exception -> L27
            java.lang.String r12 = "link"
            java.lang.String r12 = r7.getString(r12)     // Catch: java.lang.Exception -> L25
            r11.f6933i = r12     // Catch: java.lang.Exception -> L25
            boolean r12 = r7.has(r5)     // Catch: java.lang.Exception -> L25
            if (r12 == 0) goto L2c
            java.lang.String r12 = r7.getString(r5)     // Catch: java.lang.Exception -> L25
            goto L2d
        L25:
            r12 = move-exception
            goto L29
        L27:
            r12 = move-exception
            r7 = r6
        L29:
            r12.printStackTrace()
        L2c:
            r12 = r6
        L2d:
            if (r7 == 0) goto Lbc
            r8 = 0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La4
            r9.<init>()     // Catch: java.lang.Exception -> La4
            java.lang.String r10 = "push obj:"
            r9.append(r10)     // Catch: java.lang.Exception -> La4
            java.lang.String r10 = r7.toString()     // Catch: java.lang.Exception -> La4
            r9.append(r10)     // Catch: java.lang.Exception -> La4
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> La4
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch: java.lang.Exception -> La4
            us.pinguo.common.log.a.r(r4, r9, r10)     // Catch: java.lang.Exception -> La4
            boolean r9 = r7.has(r3)     // Catch: java.lang.Exception -> La4
            if (r9 == 0) goto L56
            java.lang.String r3 = r7.getString(r3)     // Catch: java.lang.Exception -> La4
            r11.f6934j = r3     // Catch: java.lang.Exception -> La4
        L56:
            boolean r3 = r7.has(r5)     // Catch: java.lang.Exception -> La4
            if (r3 == 0) goto L62
            java.lang.String r3 = r7.getString(r5)     // Catch: java.lang.Exception -> La4
            r11.f6935k = r3     // Catch: java.lang.Exception -> La4
        L62:
            java.lang.String r3 = "stickerId"
            boolean r3 = r7.has(r3)     // Catch: java.lang.Exception -> La4
            if (r3 == 0) goto L72
            java.lang.String r3 = "stickerUnityId"
            java.lang.String r3 = r7.getString(r3)     // Catch: java.lang.Exception -> La4
            r11.f6936l = r3     // Catch: java.lang.Exception -> La4
        L72:
            com.pinguo.camera360.n.b.a r3 = new com.pinguo.camera360.n.b.a     // Catch: java.lang.Exception -> La4
            r3.<init>()     // Catch: java.lang.Exception -> La4
            r11.m = r3     // Catch: java.lang.Exception -> La4
            boolean r3 = r7.has(r2)     // Catch: java.lang.Exception -> La4
            if (r3 == 0) goto L87
            com.pinguo.camera360.n.b.a r3 = r11.m     // Catch: java.lang.Exception -> La4
            int r2 = r7.getInt(r2)     // Catch: java.lang.Exception -> La4
            r3.a = r2     // Catch: java.lang.Exception -> La4
        L87:
            boolean r2 = r7.has(r1)     // Catch: java.lang.Exception -> La4
            if (r2 == 0) goto L95
            com.pinguo.camera360.n.b.a r2 = r11.m     // Catch: java.lang.Exception -> La4
            java.lang.String r1 = r7.getString(r1)     // Catch: java.lang.Exception -> La4
            r2.b = r1     // Catch: java.lang.Exception -> La4
        L95:
            boolean r1 = r7.has(r0)     // Catch: java.lang.Exception -> La4
            if (r1 == 0) goto Lbc
            com.pinguo.camera360.n.b.a r1 = r11.m     // Catch: java.lang.Exception -> La4
            java.lang.String r0 = r7.getString(r0)     // Catch: java.lang.Exception -> La4
            r1.c = r0     // Catch: java.lang.Exception -> La4
            goto Lbc
        La4:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "push error:"
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            java.lang.Object[] r0 = new java.lang.Object[r8]
            us.pinguo.common.log.a.r(r4, r12, r0)
            return r6
        Lbc:
            android.content.Context r0 = us.pinguo.foundation.e.b()
            android.content.Context r0 = r0.getApplicationContext()
            android.app.Application r0 = (android.app.Application) r0
            com.pinguo.camera360.d.d(r0)
            java.lang.String r0 = r11.b()
            java.lang.String r1 = "5976eefb8852d6140a235ed7"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto Le8
            java.lang.String r2 = r11.b()
            java.lang.String r3 = r11.f6933i
            java.lang.String r4 = r11.f6934j
            java.lang.String r5 = r11.p(r12)
            java.lang.String r6 = r11.f6935k
            java.lang.String r1 = "receive"
            us.pinguo.foundation.statistics.k.j(r1, r2, r3, r4, r5, r6)
        Le8:
            r12 = -1
            java.lang.String r0 = r11.f6933i
            r11.s(r12, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.n.b.d.i(java.lang.String):com.pinguo.camera360.n.b.d");
    }
}
