package d.e.d.n;

import org.json.JSONObject;
/* compiled from: OnOfferWallListener.java */
/* loaded from: classes2.dex */
public interface e {
    void onGetOWCreditsFailed(String str);

    void onOWAdClosed();

    boolean onOWAdCredited(int i2, int i3, boolean z);

    void onOWShowFail(String str);

    void onOWShowSuccess(String str);

    void onOfferwallEventNotificationReceived(String str, JSONObject jSONObject);

    void onOfferwallInitFail(String str);

    void onOfferwallInitSuccess();
}
