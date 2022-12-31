package cn.sharesdk.tencent.qzone;

import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.e;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* compiled from: QZoneSSOProcessor.java */
/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: d  reason: collision with root package name */
    private String f283d;

    /* renamed from: e  reason: collision with root package name */
    private String f284e;

    public c(cn.sharesdk.framework.authorize.d dVar) {
        super(dVar);
    }

    public void a(String str, String str2) {
        this.f283d = str;
        this.f284e = str2;
    }

    @Override // cn.sharesdk.framework.authorize.e
    public void a() {
        try {
            if (this.a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0) == null) {
                this.a.finish();
                SSOListener sSOListener = this.c;
                if (sSOListener != null) {
                    sSOListener.onFailed(new TencentSSOClientNotInstalledException());
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setClassName("com.tencent.mobileqq", "com.tencent.open.agent.AgentActivity");
            if (this.a.getContext().getPackageManager().resolveActivity(intent, 0) == null) {
                this.a.finish();
                SSOListener sSOListener2 = this.c;
                if (sSOListener2 != null) {
                    sSOListener2.onFailed(new TencentSSOClientNotInstalledException());
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("scope", this.f284e);
            bundle.putString("client_id", this.f283d);
            bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
            bundle.putString("need_pay", "1");
            intent.putExtra(Constants.KEY_PARAMS, bundle);
            intent.putExtra(Constants.KEY_REQUEST_CODE, this.b);
            intent.putExtra(Constants.KEY_ACTION, "action_login");
            try {
                this.a.startActivityForResult(intent, this.b);
            } catch (Throwable th) {
                this.a.finish();
                SSOListener sSOListener3 = this.c;
                if (sSOListener3 != null) {
                    sSOListener3.onFailed(th);
                }
            }
        } catch (Throwable unused) {
            this.a.finish();
            SSOListener sSOListener4 = this.c;
            if (sSOListener4 != null) {
                sSOListener4.onFailed(new TencentSSOClientNotInstalledException());
            }
        }
    }

    @Override // cn.sharesdk.framework.authorize.e
    public void a(int i2, int i3, Intent intent) {
        this.a.finish();
        if (i3 == 0) {
            SSOListener sSOListener = this.c;
            if (sSOListener != null) {
                sSOListener.onCancel();
            }
        } else if (intent == null) {
            SSOListener sSOListener2 = this.c;
            if (sSOListener2 != null) {
                sSOListener2.onFailed(new Throwable("response is empty"));
            }
        } else {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                SSOListener sSOListener3 = this.c;
                if (sSOListener3 != null) {
                    sSOListener3.onFailed(new Throwable("response is empty"));
                }
            } else if (!extras.containsKey(Constants.KEY_RESPONSE)) {
                SSOListener sSOListener4 = this.c;
                if (sSOListener4 != null) {
                    sSOListener4.onFailed(new Throwable("response is empty"));
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
                        SSOListener sSOListener5 = this.c;
                        if (sSOListener5 != null) {
                            sSOListener5.onComplete(bundle);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        SSOListener sSOListener6 = this.c;
                        if (sSOListener6 != null) {
                            sSOListener6.onFailed(th);
                            return;
                        }
                        return;
                    }
                }
                SSOListener sSOListener7 = this.c;
                if (sSOListener7 != null) {
                    sSOListener7.onFailed(new Throwable("response is empty"));
                }
            }
        }
    }
}
