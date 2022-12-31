package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.pinguo.lib.ToastHelper;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import vStudio.Android.Camera360.R;
/* compiled from: DestinationWechatMiniProgram.java */
/* loaded from: classes4.dex */
public class g0 extends us.pinguo.foundation.interaction.b {
    private String a;
    private String b;
    private StringBuilder c;

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        this.c = new StringBuilder();
        for (String str : uri.getQueryParameterNames()) {
            if ("originId".equals(str)) {
                this.a = uri.getQueryParameter("originId");
            } else if (PGEditResultActivity2.PATH.equals(str)) {
                this.b = uri.getQueryParameter(PGEditResultActivity2.PATH);
            } else {
                if (!TextUtils.isEmpty(this.c)) {
                    this.c.append("&");
                }
                StringBuilder sb = this.c;
                sb.append(str);
                sb.append("=");
                sb.append(uri.getQueryParameter(str));
            }
        }
        return new Intent();
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), us.pinguo.foundation.s.a.a);
        if (createWXAPI.isWXAppInstalled()) {
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = this.a;
            req.path = this.b + "?" + ((Object) this.c);
            req.miniprogramType = 0;
            createWXAPI.sendReq(req);
            return;
        }
        ToastHelper.show((int) R.string.share_wechat_not_installed);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith("app://camera360/miniProgram");
    }
}
