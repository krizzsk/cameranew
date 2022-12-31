package us.pinguo.share.core.a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.content.FileProvider;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import java.io.File;
import java.util.HashMap;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
/* compiled from: BaseShareModel.java */
/* loaded from: classes6.dex */
abstract class a implements d {

    /* compiled from: BaseShareModel.java */
    /* renamed from: us.pinguo.share.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0443a implements PlatformActionListener {
        final /* synthetic */ PGShareListener a;
        final /* synthetic */ ShareSite b;
        final /* synthetic */ boolean c;

        C0443a(a aVar, PGShareListener pGShareListener, ShareSite shareSite, boolean z) {
            this.a = pGShareListener;
            this.b = shareSite;
            this.c = z;
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onCancel(Platform platform, int i2) {
            Log.d("BaseShareModel", "doShareWithShareSDK.onCancel");
            PGShareListener pGShareListener = this.a;
            if (pGShareListener != null) {
                pGShareListener.onShareCancel(this.b);
            }
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onComplete(Platform platform, int i2, HashMap<String, Object> hashMap) {
            Log.d("BaseShareModel", "doShareWithShareSDK.onComplete");
            PGShareListener pGShareListener = this.a;
            if (pGShareListener != null) {
                pGShareListener.onShareComplete(this.b, this.c);
            }
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onError(Platform platform, int i2, Throwable th) {
            Log.d("BaseShareModel", "doShareWithShareSDK.onError");
            PGShareListener pGShareListener = this.a;
            if (pGShareListener != null) {
                pGShareListener.onShareError(this.b, th);
            }
        }
    }

    private Uri n(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".core.fileprovider", file);
        }
        return Uri.fromFile(file);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        j(context, new String[]{str}, str2, str3, str4, pGShareListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        j(context, new String[0], str, str2, str3, pGShareListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046 A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0013, B:10:0x002c, B:12:0x0046, B:14:0x0062, B:16:0x0067, B:13:0x005d, B:9:0x0021), top: B:31:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005d A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0013, B:10:0x002c, B:12:0x0046, B:14:0x0062, B:16:0x0067, B:13:0x005d, B:9:0x0021), top: B:31:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0067 A[Catch: Exception -> 0x006f, TRY_LEAVE, TryCatch #0 {Exception -> 0x006f, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0013, B:10:0x002c, B:12:0x0046, B:14:0x0062, B:16:0x0067, B:13:0x005d, B:9:0x0021), top: B:31:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void j(android.content.Context r10, java.lang.String[] r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, us.pinguo.share.core.PGShareListener r15) {
        /*
            r9 = this;
            r0 = 1
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L6f
            r1.<init>()     // Catch: java.lang.Exception -> L6f
            int r2 = r11.length     // Catch: java.lang.Exception -> L6f
            if (r2 <= 0) goto L21
            r2 = 0
            r3 = r11[r2]     // Catch: java.lang.Exception -> L6f
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L6f
            if (r3 == 0) goto L13
            goto L21
        L13:
            us.pinguo.share.core.ShareSite r3 = r9.b()     // Catch: java.lang.Exception -> L6f
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Exception -> L6f
            r2 = r11[r2]     // Catch: java.lang.Exception -> L6f
            r1.setClassName(r3, r2)     // Catch: java.lang.Exception -> L6f
            goto L2c
        L21:
            us.pinguo.share.core.ShareSite r2 = r9.b()     // Catch: java.lang.Exception -> L6f
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Exception -> L6f
            r1.setPackage(r2)     // Catch: java.lang.Exception -> L6f
        L2c:
            java.lang.String r2 = "android.intent.action.SEND"
            r1.setAction(r2)     // Catch: java.lang.Exception -> L6f
            java.lang.String r2 = "android.intent.extra.SUBJECT"
            r1.putExtra(r2, r12)     // Catch: java.lang.Exception -> L6f
            java.lang.String r2 = "android.intent.extra.TITLE"
            r1.putExtra(r2, r12)     // Catch: java.lang.Exception -> L6f
            java.lang.String r2 = "android.intent.extra.TEXT"
            r1.putExtra(r2, r13)     // Catch: java.lang.Exception -> L6f
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Exception -> L6f
            if (r2 != 0) goto L5d
            java.lang.String r2 = "image/*"
            r1.setType(r2)     // Catch: java.lang.Exception -> L6f
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> L6f
            r2.<init>(r14)     // Catch: java.lang.Exception -> L6f
            android.net.Uri r2 = r9.n(r10, r2)     // Catch: java.lang.Exception -> L6f
            r1.addFlags(r0)     // Catch: java.lang.Exception -> L6f
            java.lang.String r3 = "android.intent.extra.STREAM"
            r1.putExtra(r3, r2)     // Catch: java.lang.Exception -> L6f
            goto L62
        L5d:
            java.lang.String r2 = "text/plain"
            r1.setType(r2)     // Catch: java.lang.Exception -> L6f
        L62:
            r10.startActivity(r1)     // Catch: java.lang.Exception -> L6f
            if (r15 == 0) goto L99
            us.pinguo.share.core.ShareSite r1 = r9.b()     // Catch: java.lang.Exception -> L6f
            r15.onShareComplete(r1, r0)     // Catch: java.lang.Exception -> L6f
            goto L99
        L6f:
            r1 = move-exception
            int r2 = r11.length
            if (r2 <= r0) goto L8d
            int r1 = r11.length
            int r1 = r1 - r0
            java.lang.String[] r4 = new java.lang.String[r1]
        L77:
            int r1 = r11.length
            if (r0 >= r1) goto L83
            int r1 = r0 + (-1)
            r2 = r11[r0]
            r4[r1] = r2
            int r0 = r0 + 1
            goto L77
        L83:
            r2 = r9
            r3 = r10
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r2.j(r3, r4, r5, r6, r7, r8)
            return
        L8d:
            r1.printStackTrace()
            if (r15 == 0) goto L99
            us.pinguo.share.core.ShareSite r10 = r9.b()
            r15.onShareError(r10, r1)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.share.core.a.a.j(android.content.Context, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, us.pinguo.share.core.PGShareListener):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(Platform.ShareParams shareParams, PGShareListener pGShareListener, boolean z) {
        ShareSite b = b();
        Platform a = h.a(b);
        a.setPlatformActionListener(new C0443a(this, pGShareListener, b, z));
        a.share(shareParams);
    }

    public String l(Context context, String str) {
        File file = new File(str);
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".core.fileprovider", file);
        context.grantUriPermission("com.ss.android.ugc.aweme", uriForFile, 1);
        return uriForFile.toString();
    }

    public boolean m(Context context) {
        return us.pinguo.share.d.a.b(context, b());
    }
}
