package us.pinguo.advconfigdata.Utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.e;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.SslDomain;
/* loaded from: classes3.dex */
public class SSLManager {
    private static SSLManager mSSLManager;
    private GetDominCallback mCallback;
    private List<SslDomain> mDomainList;
    private String mHost;
    private final String KEY_DOMAIN_LIST = "domainList";
    private final String GET_DOMAIN = "/certificate/domain/list";
    private final String UPLOAD_DOMAIN = "/certificate/domain/reportModify";
    private final String HOST_RELEASE = "https://exchange.360in.com";
    private final String HOST_TEST = "https://exchange-dev.360in.com";
    private Runnable getDomainRunable = new b();
    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private e mGson = new e();

    /* loaded from: classes3.dex */
    public interface GetDominCallback {
        void onFailed();

        void onLoaded();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("domain", this.a);
                AdvConfigManager advConfigManager = AdvConfigManager.getInstance();
                advConfigManager.requestUrl(SSLManager.this.mHost + "/certificate/domain/reportModify", hashMap);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements Runnable {

        /* loaded from: classes3.dex */
        class a extends com.google.gson.t.a<ArrayList<SslDomain>> {
            a(b bVar) {
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdvConfigManager advConfigManager = AdvConfigManager.getInstance();
                String requestUrl = advConfigManager.requestUrl(SSLManager.this.mHost + "/certificate/domain/list");
                if (TextUtils.isEmpty(requestUrl)) {
                    if (SSLManager.this.mCallback != null) {
                        SSLManager.this.mCallback.onFailed();
                        return;
                    }
                    return;
                }
                JSONObject jSONObject = new JSONObject(requestUrl);
                int i2 = jSONObject.getInt("status");
                if (i2 != 200) {
                    if (SSLManager.this.mCallback != null) {
                        SSLManager.this.mCallback.onFailed();
                    }
                    throw new IllegalStateException("request not succees!  statuscode=" + i2);
                }
                String string = new JSONObject(new String(AdvUtils.decrypt3Des(Base64.decode(jSONObject.getJSONObject("data").getString(TJAdUnitConstants.String.VIDEO_INFO).getBytes("UTF-8"), 0), SSLManager.this.getSecret()), "UTF-8")).getString("identifiedList");
                ArrayList arrayList = (ArrayList) SSLManager.this.mGson.k(string, new a(this).getType());
                if (arrayList != null && arrayList.size() != 0) {
                    AdvPrefUtil.getInstance().putString("domainList", string);
                    if (SSLManager.this.mDomainList != null) {
                        SSLManager.this.mDomainList.clear();
                    } else {
                        SSLManager.this.mDomainList = new ArrayList();
                    }
                    SSLManager.this.mDomainList.addAll(arrayList);
                }
                if (SSLManager.this.mCallback != null) {
                    SSLManager.this.mCallback.onLoaded();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (SSLManager.this.mCallback != null) {
                    SSLManager.this.mCallback.onFailed();
                }
            }
        }
    }

    private SSLManager() {
        if (AdvConfigManager.getInstance().getAdvConfig().getRequestMode() == AdvConstants.MODE_OFFICE) {
            this.mHost = "https://exchange.360in.com";
        } else {
            this.mHost = "https://exchange-dev.360in.com";
        }
    }

    public static synchronized SSLManager getInstance() {
        SSLManager sSLManager;
        synchronized (SSLManager.class) {
            if (mSSLManager == null) {
                mSSLManager = new SSLManager();
            }
            sSLManager = mSSLManager;
        }
        return sSLManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSecret() {
        String deviceID = AdvSystemUtils.getDeviceID(AdvConfigManager.getInstance().getContext());
        return (TextUtils.isEmpty(deviceID) || deviceID.length() < 8) ? "" : deviceID.substring(deviceID.length() - 8, deviceID.length());
    }

    private void uploadDomain(String str) {
        this.mExecutorService.execute(new a(str));
    }

    public void getDomainList(GetDominCallback getDominCallback) {
        if (AdvConfigManager.getInstance().getAdvConfig().getTSLEnable().booleanValue()) {
            this.mCallback = getDominCallback;
            this.mExecutorService.execute(this.getDomainRunable);
        }
    }

    public Boolean verifyCertification(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return Boolean.TRUE;
        }
        String host = Uri.parse(str2).getHost();
        if (TextUtils.isEmpty(host)) {
            return Boolean.TRUE;
        }
        List<SslDomain> list = this.mDomainList;
        if (list != null && list.size() != 0) {
            for (SslDomain sslDomain : this.mDomainList) {
                if (!TextUtils.isEmpty(sslDomain.getDomain()) && sslDomain.getDomain().equals(host)) {
                    String commonMd5 = AdvMD5.getCommonMd5(str.replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").replaceAll(" ", ""));
                    if (!TextUtils.isEmpty(sslDomain.getFingerprint()) && sslDomain.getFingerprint().equals(commonMd5)) {
                        return Boolean.TRUE;
                    }
                    uploadDomain(host);
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
        return Boolean.TRUE;
    }

    public Boolean verifyDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return Boolean.FALSE;
        }
        List<SslDomain> list = this.mDomainList;
        if (list != null && list.size() != 0) {
            for (SslDomain sslDomain : this.mDomainList) {
                if (!TextUtils.isEmpty(sslDomain.getDomain()) && sslDomain.getDomain().equals(host)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }
}
