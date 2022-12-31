package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.fr;
import java.util.Map;
import java.util.UUID;
import org.w3c.dom.Document;
/* loaded from: classes3.dex */
public class TJCurrency {

    /* renamed from: d  reason: collision with root package name */
    private static TJGetCurrencyBalanceListener f7228d;

    /* renamed from: e  reason: collision with root package name */
    private static TJSpendCurrencyListener f7229e;

    /* renamed from: f  reason: collision with root package name */
    private static TJAwardCurrencyListener f7230f;

    /* renamed from: g  reason: collision with root package name */
    private static TJEarnedCurrencyListener f7231g;
    String a = null;
    int b = 0;
    Context c;

    public TJCurrency(Context context) {
        this.c = context;
    }

    public void awardCurrency(int i2, TJAwardCurrencyListener tJAwardCurrencyListener) {
        if (i2 < 0) {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Amount must be a positive number for the awardCurrency API"));
            return;
        }
        this.b = i2;
        f7230f = tJAwardCurrencyListener;
        String uuid = UUID.randomUUID().toString();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        final Map genericURLParams = TapjoyConnectCore.getGenericURLParams();
        TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_CURRENCY, String.valueOf(this.b), true);
        TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_GUID, uuid, true);
        TapjoyUtil.safePut(genericURLParams, "timestamp", String.valueOf(currentTimeMillis), true);
        TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_VERIFIER, TapjoyConnectCore.getAwardCurrencyVerifier(currentTimeMillis, this.b, uuid), true);
        new Thread(new Runnable() { // from class: com.tapjoy.TJCurrency.3
            @Override // java.lang.Runnable
            public final void run() {
                TapjoyURLConnection tapjoyURLConnection = new TapjoyURLConnection();
                TJCurrency.this.c(tapjoyURLConnection.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_AWARD_CURRENCY_URL_PATH, genericURLParams));
            }
        }).start();
    }

    public void getCurrencyBalance(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        f7228d = tJGetCurrencyBalanceListener;
        final Map uRLParams = TapjoyConnectCore.getURLParams();
        new Thread(new Runnable() { // from class: com.tapjoy.TJCurrency.1
            @Override // java.lang.Runnable
            public final void run() {
                TapjoyURLConnection tapjoyURLConnection = new TapjoyURLConnection();
                TJCurrency.this.a(tapjoyURLConnection.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_GET_CURRENCY_BALANCE_URL_PATH, uRLParams));
            }
        }).start();
    }

    public int getLocalCurrencyBalance() {
        return this.c.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).getInt(TapjoyConstants.PREF_LAST_CURRENCY_BALANCE, -9999);
    }

    public void saveCurrencyBalance(int i2) {
        SharedPreferences.Editor edit = this.c.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putInt(TapjoyConstants.PREF_LAST_CURRENCY_BALANCE, i2);
        edit.apply();
    }

    public void setEarnedCurrencyListener(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        f7231g = tJEarnedCurrencyListener;
    }

    public void spendCurrency(int i2, TJSpendCurrencyListener tJSpendCurrencyListener) {
        if (i2 < 0) {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Amount must be a positive number for the spendCurrency API"));
            return;
        }
        this.a = String.valueOf(i2);
        f7229e = tJSpendCurrencyListener;
        final Map uRLParams = TapjoyConnectCore.getURLParams();
        TapjoyUtil.safePut(uRLParams, TapjoyConstants.TJC_CURRENCY, this.a, true);
        new Thread(new Runnable() { // from class: com.tapjoy.TJCurrency.2
            @Override // java.lang.Runnable
            public final void run() {
                TapjoyURLConnection tapjoyURLConnection = new TapjoyURLConnection();
                TJCurrency.this.b(tapjoyURLConnection.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_SPEND_CURRENCY_URL_PATH, uRLParams));
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        String str = tapjoyHttpURLResponse.response;
        if (str != null) {
            Document buildDocument = TapjoyUtil.buildDocument(str);
            if (buildDocument != null) {
                String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
                if (nodeTrimValue != null && nodeTrimValue.equals("true")) {
                    String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("TapPoints"));
                    String nodeTrimValue3 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("CurrencyName"));
                    if (nodeTrimValue2 != null && nodeTrimValue3 != null) {
                        try {
                            int parseInt = Integer.parseInt(nodeTrimValue2);
                            int localCurrencyBalance = getLocalCurrencyBalance();
                            if (f7231g != null && localCurrencyBalance != -9999 && parseInt > localCurrencyBalance) {
                                StringBuilder sb = new StringBuilder("earned: ");
                                int i2 = parseInt - localCurrencyBalance;
                                sb.append(i2);
                                TapjoyLog.i("TJCurrency", sb.toString());
                                f7231g.onEarnedCurrency(nodeTrimValue3, i2);
                            }
                            saveCurrencyBalance(parseInt);
                            TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener = f7228d;
                            if (tJGetCurrencyBalanceListener != null) {
                                tJGetCurrencyBalanceListener.onGetCurrencyBalanceResponse(nodeTrimValue3, parseInt);
                            }
                            return;
                        } catch (Exception e2) {
                            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SERVER_ERROR;
                            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(errorType, "Error parsing XML and calling listener: " + e2.toString()));
                        }
                    } else {
                        TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is invalid -- missing tags."));
                    }
                } else {
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is invalid -- missing <Success> tag."));
                }
            }
        } else {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is NULL"));
        }
        TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener2 = f7228d;
        if (tJGetCurrencyBalanceListener2 != null) {
            tJGetCurrencyBalanceListener2.onGetCurrencyBalanceResponseFailure("Failed to get currency balance");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        String str = "Failed to spend currency";
        String str2 = tapjoyHttpURLResponse.response;
        if (str2 != null) {
            Document buildDocument = TapjoyUtil.buildDocument(str2);
            if (buildDocument != null) {
                String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
                if (nodeTrimValue != null && nodeTrimValue.equals("true")) {
                    String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("TapPoints"));
                    String nodeTrimValue3 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("CurrencyName"));
                    if (nodeTrimValue2 != null && nodeTrimValue3 != null) {
                        int parseInt = Integer.parseInt(nodeTrimValue2);
                        saveCurrencyBalance(parseInt);
                        TJSpendCurrencyListener tJSpendCurrencyListener = f7229e;
                        if (tJSpendCurrencyListener != null) {
                            tJSpendCurrencyListener.onSpendCurrencyResponse(nodeTrimValue3, parseInt);
                        }
                        return;
                    }
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "spendCurrency response is invalid -- missing tags."));
                } else if (nodeTrimValue != null && nodeTrimValue.endsWith("false")) {
                    str = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Message"));
                    TapjoyLog.i("TJCurrency", str);
                    if ("BalanceTooLowError".equals(TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("MessageCode")))) {
                        fr.a();
                    }
                } else {
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "spendCurrency response is invalid -- missing <Success> tag."));
                }
            }
        } else {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "spendCurrency response is NULL"));
        }
        TJSpendCurrencyListener tJSpendCurrencyListener2 = f7229e;
        if (tJSpendCurrencyListener2 != null) {
            tJSpendCurrencyListener2.onSpendCurrencyResponseFailure(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        String str = "Failed to award currency";
        String str2 = tapjoyHttpURLResponse.response;
        if (str2 != null) {
            Document buildDocument = TapjoyUtil.buildDocument(str2);
            if (buildDocument != null) {
                String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
                if (nodeTrimValue != null && nodeTrimValue.equals("true")) {
                    String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("TapPoints"));
                    String nodeTrimValue3 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("CurrencyName"));
                    if (nodeTrimValue2 != null && nodeTrimValue3 != null) {
                        int parseInt = Integer.parseInt(nodeTrimValue2);
                        saveCurrencyBalance(parseInt);
                        TJAwardCurrencyListener tJAwardCurrencyListener = f7230f;
                        if (tJAwardCurrencyListener != null) {
                            tJAwardCurrencyListener.onAwardCurrencyResponse(nodeTrimValue3, parseInt);
                        }
                        return;
                    }
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is invalid -- missing tags."));
                } else if (nodeTrimValue != null && nodeTrimValue.endsWith("false")) {
                    str = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Message"));
                    TapjoyLog.i("TJCurrency", str);
                } else {
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is invalid -- missing <Success> tag."));
                }
            }
        } else {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is NULL"));
        }
        TJAwardCurrencyListener tJAwardCurrencyListener2 = f7230f;
        if (tJAwardCurrencyListener2 != null) {
            tJAwardCurrencyListener2.onAwardCurrencyResponseFailure(str);
        }
    }
}
