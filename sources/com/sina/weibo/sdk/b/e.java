package com.sina.weibo.sdk.b;

import android.content.Context;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.e;
import com.tencent.open.SocialConstants;
import com.tencent.stat.DeviceInfo;
/* loaded from: classes3.dex */
public final class e extends c<Void, Void, String> {
    private Context ae;
    private com.sina.weibo.sdk.net.c<String> ag;
    private Throwable ah;
    private String ai;
    private String aj;
    private String appKey;

    public e(Context context, String str, String str2, String str3, com.sina.weibo.sdk.net.c<String> cVar) {
        this.ae = context;
        this.ai = str;
        this.appKey = str2;
        this.aj = str3;
        this.ag = cVar;
    }

    private String d(String str) {
        return HttpManager.a(this.ae, getAid(), this.aj, this.appKey, str);
    }

    private String getAid() {
        return com.sina.weibo.sdk.c.e.f(this.ae, this.appKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.b.c
    /* renamed from: q */
    public String o() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            e.a aVar = new e.a();
            aVar.url = "https://service.weibo.com/share/mobilesdk_uppic.php";
            return new com.sina.weibo.sdk.net.b().a(aVar.a(DeviceInfo.TAG_ANDROID_ID, getAid()).a("oauth_timestamp", valueOf).a("oauth_sign", d(valueOf)).b("appKey", this.appKey).b(DeviceInfo.TAG_ANDROID_ID, getAid()).b("oauth_timestamp", valueOf).b("oauth_sign", d(valueOf)).b(SocialConstants.PARAM_IMG_URL, this.ai).i()).j();
        } catch (Throwable th) {
            th.printStackTrace();
            this.ah = th;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.b.c
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th = this.ah;
        if (th != null) {
            com.sina.weibo.sdk.net.c<String> cVar = this.ag;
            if (cVar != null) {
                cVar.onError(th);
                return;
            }
            return;
        }
        com.sina.weibo.sdk.net.c<String> cVar2 = this.ag;
        if (cVar2 != null) {
            cVar2.a(str2);
        }
    }
}
