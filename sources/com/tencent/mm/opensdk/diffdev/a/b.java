package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Base64;
import com.coremedia.iso.boxes.UserBox;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends AsyncTask<Void, Void, a> {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f8128d;

    /* renamed from: e  reason: collision with root package name */
    private String f8129e;

    /* renamed from: f  reason: collision with root package name */
    private OAuthListener f8130f;

    /* renamed from: g  reason: collision with root package name */
    private c f8131g;

    /* loaded from: classes3.dex */
    static class a {
        public OAuthErrCode a;
        public String b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public String f8132d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f8133e;

        private a() {
        }

        public static a a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            a aVar = new a();
            if (bArr != null && bArr.length != 0) {
                try {
                } catch (Exception e2) {
                    format = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                    int i2 = jSONObject.getInt("errcode");
                    if (i2 != 0) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i2)));
                        aVar.a = OAuthErrCode.WechatAuth_Err_NormalErr;
                        jSONObject.optString("errmsg");
                        return aVar;
                    }
                    String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                    if (string != null && string.length() != 0) {
                        byte[] decode = Base64.decode(string, 0);
                        if (decode != null && decode.length != 0) {
                            aVar.a = OAuthErrCode.WechatAuth_Err_OK;
                            aVar.f8133e = decode;
                            aVar.b = jSONObject.getString(UserBox.TYPE);
                            String string2 = jSONObject.getString("appname");
                            aVar.c = string2;
                            Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.b, string2, Integer.valueOf(aVar.f8133e.length)));
                            return aVar;
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                        aVar.a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    }
                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                    aVar.a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                    return aVar;
                } catch (Exception e3) {
                    format = String.format("parse json fail, ex = %s", e3.getMessage());
                    Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.a = oAuthErrCode;
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.a = oAuthErrCode;
            return aVar;
        }
    }

    public b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.f8128d = str4;
        this.f8129e = str5;
        this.f8130f = oAuthListener;
    }

    public boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        c cVar = this.f8131g;
        return cVar == null ? cancel(true) : cVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.a, this.c, this.f8128d, this.b, this.f8129e);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a2 = com.tencent.mm.opensdk.channel.a.a.a(format, 60000);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.a(a2);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.a;
        if (oAuthErrCode == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f8133e.length);
            this.f8130f.onAuthGotQrcode(aVar2.f8132d, aVar2.f8133e);
            c cVar = new c(aVar2.b, this.f8130f);
            this.f8131g = cVar;
            if (Build.VERSION.SDK_INT >= 11) {
                cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else {
                cVar.execute(new Void[0]);
                return;
            }
        }
        Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
        this.f8130f.onAuthFinish(aVar2.a, null);
    }
}
