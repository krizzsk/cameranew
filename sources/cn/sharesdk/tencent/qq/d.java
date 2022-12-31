package cn.sharesdk.tencent.qq;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.authorize.SSOListener;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* compiled from: QQSSOProcessor.java */
/* loaded from: classes.dex */
public class d extends cn.sharesdk.framework.authorize.e {

    /* renamed from: d  reason: collision with root package name */
    private String f264d;

    /* renamed from: e  reason: collision with root package name */
    private String f265e;

    /* renamed from: f  reason: collision with root package name */
    private String f266f;

    public d(cn.sharesdk.framework.authorize.d dVar) {
        super(dVar);
    }

    private void b() {
        a aVar = new a();
        aVar.a(this.c);
        aVar.show(this.a.getContext(), null);
    }

    public void a(String str, String str2, String str3) {
        this.f264d = str;
        this.f265e = str2;
        this.f266f = str3;
    }

    @Override // cn.sharesdk.framework.authorize.e
    public void a() {
        if (!TextUtils.isEmpty(this.f266f) && !this.f266f.equals(Constants.PACKAGE_QQ_SPEED)) {
            Intent intent = new Intent();
            intent.setClassName(this.f266f, "com.tencent.open.agent.AgentActivity");
            if (this.a.getContext().getPackageManager().resolveActivity(intent, 0) == null) {
                this.a.finish();
                if (this.c != null) {
                    b();
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("scope", this.f265e);
            bundle.putString("client_id", this.f264d);
            bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
            bundle.putString("need_pay", "1");
            intent.putExtra(Constants.KEY_PARAMS, bundle);
            intent.putExtra(Constants.KEY_REQUEST_CODE, this.b);
            intent.putExtra(Constants.KEY_ACTION, "action_login");
            try {
                this.a.startActivityForResult(intent, this.b);
                return;
            } catch (Throwable th) {
                this.a.finish();
                SSOListener sSOListener = this.c;
                if (sSOListener != null) {
                    sSOListener.onFailed(th);
                    return;
                }
                return;
            }
        }
        b();
        this.a.finish();
    }

    @Override // cn.sharesdk.framework.authorize.e
    public void a(int i2, int i3, Intent intent) {
        SSOListener sSOListener;
        this.a.finish();
        if (i3 == 0) {
            SSOListener sSOListener2 = this.c;
            if (sSOListener2 != null) {
                sSOListener2.onCancel();
            }
        } else if (intent == null) {
            SSOListener sSOListener3 = this.c;
            if (sSOListener3 != null) {
                sSOListener3.onFailed(new Throwable("response is empty"));
            }
        } else {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                SSOListener sSOListener4 = this.c;
                if (sSOListener4 != null) {
                    sSOListener4.onFailed(new Throwable("response is empty"));
                }
            } else if (!extras.containsKey(Constants.KEY_RESPONSE)) {
                SSOListener sSOListener5 = this.c;
                if (sSOListener5 != null) {
                    sSOListener5.onFailed(new Throwable("response is empty"));
                }
            } else {
                String string = extras.getString(Constants.KEY_RESPONSE);
                if (string != null && string.length() > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        Bundle bundle = new Bundle();
                        bundle.putInt("ret", jSONObject.optInt("ret"));
                        bundle.putString("pay_token", jSONObject.optString("pay_token"));
                        bundle.putString(Constants.PARAM_PLATFORM_ID, jSONObject.optString(Constants.PARAM_PLATFORM_ID));
                        bundle.putString("open_id", jSONObject.optString("openid"));
                        bundle.putString("expires_in", jSONObject.optString("expires_in"));
                        bundle.putString("pfkey", jSONObject.optString("pfkey"));
                        bundle.putString("msg", jSONObject.optString("msg"));
                        bundle.putString("access_token", jSONObject.optString("access_token"));
                        String optString = jSONObject.optString("msg");
                        if (!TextUtils.isEmpty(optString) && (sSOListener = this.c) != null) {
                            sSOListener.onFailed(new Throwable(optString));
                            return;
                        }
                        SSOListener sSOListener6 = this.c;
                        if (sSOListener6 != null) {
                            sSOListener6.onComplete(bundle);
                            this.c = null;
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        SSOListener sSOListener7 = this.c;
                        if (sSOListener7 != null) {
                            sSOListener7.onFailed(th);
                            return;
                        }
                        return;
                    }
                }
                SSOListener sSOListener8 = this.c;
                if (sSOListener8 != null) {
                    sSOListener8.onFailed(new Throwable("response is empty"));
                }
            }
        }
    }
}
