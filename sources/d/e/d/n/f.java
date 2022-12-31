package d.e.d.n;

import org.json.JSONObject;
/* compiled from: OnRewardedVideoListener.java */
@Deprecated
/* loaded from: classes2.dex */
public interface f extends a {
    void onRVAdClicked();

    void onRVAdClosed();

    void onRVAdCredited(int i2);

    void onRVAdOpened();

    void onRVEventNotificationReceived(String str, JSONObject jSONObject);

    void onRVInitFail(String str);

    void onRVInitSuccess(com.ironsource.sdk.data.a aVar);

    void onRVNoMoreOffers();

    void onRVShowFail(String str);
}
