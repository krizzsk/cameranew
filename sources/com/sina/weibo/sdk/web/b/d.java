package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.b.b;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.web.b.b;
import com.tencent.stat.DeviceInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d extends b {
    public WeiboMultiMessage aJ;
    private byte[] aK;
    String aL;
    public String aj;
    public String packageName;
    private String text;

    public d(AuthInfo authInfo) {
        super(authInfo, 1, null, null);
    }

    @Override // com.sina.weibo.sdk.web.b.b
    protected final void a(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = this.aJ;
        if (weiboMultiMessage != null) {
            weiboMultiMessage.writeToBundle(bundle);
        }
        bundle.putString("token", this.aj);
        bundle.putString("packageName", this.packageName);
    }

    @Override // com.sina.weibo.sdk.web.b.b
    protected final void b(Bundle bundle) {
        byte[] bArr;
        FileInputStream fileInputStream;
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        this.aJ = weiboMultiMessage;
        weiboMultiMessage.readFromBundle(bundle);
        this.aj = bundle.getString("token");
        this.packageName = bundle.getString("packageName");
        StringBuilder sb = new StringBuilder();
        TextObject textObject = this.aJ.textObject;
        if (textObject != null) {
            sb.append(textObject.text);
        }
        ImageObject imageObject = this.aJ.imageObject;
        if (imageObject != null) {
            String str = imageObject.imagePath;
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[(int) file.length()];
                    FileInputStream fileInputStream2 = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileInputStream.read(bArr2);
                        this.aK = e.b(bArr2);
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream2 = fileInputStream;
                        e.printStackTrace();
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        bArr = imageObject.imageData;
                        if (bArr != null) {
                            this.aK = e.b(bArr);
                        }
                        this.text = sb.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            bArr = imageObject.imageData;
            if (bArr != null && bArr.length > 0) {
                this.aK = e.b(bArr);
            }
        }
        this.text = sb.toString();
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final String getUrl() {
        Uri.Builder buildUpon = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.text);
        buildUpon.appendQueryParameter("version", "0041005000");
        String appKey = this.aH.a().getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.aj)) {
            buildUpon.appendQueryParameter("access_token", this.aj);
        }
        String f2 = e.f(this.ae, appKey);
        if (!TextUtils.isEmpty(f2)) {
            buildUpon.appendQueryParameter(DeviceInfo.TAG_ANDROID_ID, f2);
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            buildUpon.appendQueryParameter("packagename", this.packageName);
        }
        if (!TextUtils.isEmpty(this.aL)) {
            buildUpon.appendQueryParameter("picinfo", this.aL);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        buildUpon.appendQueryParameter("lfid", "OP_" + appKey);
        return buildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final boolean w() {
        byte[] bArr = this.aK;
        if (bArr == null || bArr.length <= 0) {
            return super.w();
        }
        return true;
    }

    public d(Context context) {
        this.ae = context;
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final void a(final b.a aVar) {
        com.sina.weibo.sdk.b.b bVar;
        com.sina.weibo.sdk.b.e eVar = new com.sina.weibo.sdk.b.e(this.ae, new String(this.aK), this.aH.a().getAppKey(), this.aj, new com.sina.weibo.sdk.net.c<String>() { // from class: com.sina.weibo.sdk.web.b.d.1
            @Override // com.sina.weibo.sdk.net.c
            public final /* synthetic */ void a(String str) {
                String str2 = str;
                com.sina.weibo.sdk.c.c.a("WbShareTag", "handle image result :" + str2);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        int optInt = jSONObject.optInt("code");
                        String optString = jSONObject.optString("data");
                        if (optInt == 1 && !TextUtils.isEmpty(optString)) {
                            d.this.aL = optString;
                            b.a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.onComplete();
                                return;
                            }
                            return;
                        }
                        b.a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.onError("图片内容不合适，禁止上传！");
                            return;
                        }
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        b.a aVar4 = aVar;
                        if (aVar4 != null) {
                            aVar4.onError("解析服务端返回的字符串时发生异常！");
                            return;
                        }
                        return;
                    }
                }
                b.a aVar5 = aVar;
                if (aVar5 != null) {
                    aVar5.onError("处理图片，服务端返回null!");
                }
            }

            @Override // com.sina.weibo.sdk.net.c
            public final void onError(Throwable th) {
                b.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError(th.getMessage());
                }
            }
        });
        bVar = b.a.P;
        bVar.a(eVar);
    }
}
