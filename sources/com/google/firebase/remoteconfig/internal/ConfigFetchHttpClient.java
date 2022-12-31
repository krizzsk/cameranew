package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.pm.PackageInfoCompat;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.j;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes2.dex */
public class ConfigFetchHttpClient {
    private static final String API_KEY_HEADER = "X-Goog-Api-Key";
    private static final String ETAG_HEADER = "ETag";
    private static final Pattern GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private static final String IF_NONE_MATCH_HEADER = "If-None-Match";
    private static final String INSTALLATIONS_AUTH_TOKEN_HEADER = "X-Goog-Firebase-Installations-Auth";
    private static final String X_ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String X_ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String X_GOOGLE_GFE_CAN_RETRY = "X-Google-GFE-Can-Retry";
    private final String apiKey;
    private final String appId;
    private final long connectTimeoutInSeconds;
    private final Context context;
    private final String namespace;
    private final String projectNumber;
    private final long readTimeoutInSeconds;

    public ConfigFetchHttpClient(Context context, String str, String str2, String str3, long j2, long j3) {
        this.context = context;
        this.appId = str;
        this.apiKey = str2;
        this.projectNumber = extractProjectNumberFromAppId(str);
        this.namespace = str3;
        this.connectTimeoutInSeconds = j2;
        this.readTimeoutInSeconds = j3;
    }

    private boolean backendHasUpdates(JSONObject jSONObject) {
        try {
            return !jSONObject.get("state").equals("NO_CHANGE");
        } catch (JSONException unused) {
            return true;
        }
    }

    private JSONObject createFetchRequestBody(String str, String str2, Map<String, String> map) throws FirebaseRemoteConfigClientException {
        String locale;
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put(RemoteConfigConstants.RequestFieldKey.INSTANCE_ID, str);
            hashMap.put(RemoteConfigConstants.RequestFieldKey.INSTANCE_ID_TOKEN, str2);
            hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_ID, this.appId);
            Locale locale2 = this.context.getResources().getConfiguration().locale;
            hashMap.put("countryCode", locale2.getCountry());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                locale = locale2.toLanguageTag();
            } else {
                locale = locale2.toString();
            }
            hashMap.put(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, locale);
            hashMap.put(RemoteConfigConstants.RequestFieldKey.PLATFORM_VERSION, Integer.toString(i2));
            hashMap.put(RemoteConfigConstants.RequestFieldKey.TIME_ZONE, TimeZone.getDefault().getID());
            try {
                PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
                if (packageInfo != null) {
                    hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, packageInfo.versionName);
                    hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_BUILD, Long.toString(PackageInfoCompat.getLongVersionCode(packageInfo)));
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            hashMap.put("packageName", this.context.getPackageName());
            hashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "20.0.4");
            hashMap.put(RemoteConfigConstants.RequestFieldKey.ANALYTICS_USER_PROPERTIES, new JSONObject(map));
            return new JSONObject(hashMap);
        }
        throw new FirebaseRemoteConfigClientException("Fetch failed: Firebase installation id is null.");
    }

    private static ConfigContainer extractConfigs(JSONObject jSONObject, Date date) throws FirebaseRemoteConfigClientException {
        JSONObject jSONObject2;
        JSONArray jSONArray;
        try {
            ConfigContainer.Builder withFetchTime = ConfigContainer.newBuilder().withFetchTime(date);
            JSONObject jSONObject3 = null;
            try {
                jSONObject2 = jSONObject.getJSONObject(RemoteConfigConstants.ResponseFieldKey.ENTRIES);
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                withFetchTime.replaceConfigsWith(jSONObject2);
            }
            try {
                jSONArray = jSONObject.getJSONArray(RemoteConfigConstants.ResponseFieldKey.EXPERIMENT_DESCRIPTIONS);
            } catch (JSONException unused2) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                withFetchTime.withAbtExperiments(jSONArray);
            }
            try {
                jSONObject3 = jSONObject.getJSONObject(RemoteConfigConstants.ResponseFieldKey.PERSONALIZATION_METADATA);
            } catch (JSONException unused3) {
            }
            if (jSONObject3 != null) {
                withFetchTime.withPersonalizationMetadata(jSONObject3);
            }
            return withFetchTime.build();
        } catch (JSONException e2) {
            throw new FirebaseRemoteConfigClientException("Fetch failed: fetch response could not be parsed.", e2);
        }
    }

    private static String extractProjectNumberFromAppId(String str) {
        Matcher matcher = GMP_APP_ID_PATTERN.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private JSONObject getFetchResponseBody(URLConnection uRLConnection) throws IOException, JSONException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream(), "utf-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read();
            if (read != -1) {
                sb.append((char) read);
            } else {
                return new JSONObject(sb.toString());
            }
        }
    }

    private String getFetchUrl(String str, String str2) {
        return String.format(RemoteConfigConstants.FETCH_REGEX_URL, str, str2);
    }

    private String getFingerprintHashForPackage() {
        try {
            Context context = this.context;
            byte[] a = a.a(context, context.getPackageName());
            if (a == null) {
                Log.e(FirebaseRemoteConfig.TAG, "Could not get fingerprint hash for package: " + this.context.getPackageName());
                return null;
            }
            return j.b(a, false);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(FirebaseRemoteConfig.TAG, "No such package: " + this.context.getPackageName(), e2);
            return null;
        }
    }

    private void setCommonRequestHeaders(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty(API_KEY_HEADER, this.apiKey);
        httpURLConnection.setRequestProperty(X_ANDROID_PACKAGE_HEADER, this.context.getPackageName());
        httpURLConnection.setRequestProperty(X_ANDROID_CERT_HEADER, getFingerprintHashForPackage());
        httpURLConnection.setRequestProperty(X_GOOGLE_GFE_CAN_RETRY, "yes");
        httpURLConnection.setRequestProperty(INSTALLATIONS_AUTH_TOKEN_HEADER, str);
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_JSON);
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_ACCEPT, HttpRequest.CONTENT_TYPE_JSON);
    }

    private void setCustomRequestHeaders(HttpURLConnection httpURLConnection, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private void setFetchRequestBody(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    private void setUpUrlConnection(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map) {
        httpURLConnection.setDoOutput(true);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(this.connectTimeoutInSeconds));
        httpURLConnection.setReadTimeout((int) timeUnit.toMillis(this.readTimeoutInSeconds));
        httpURLConnection.setRequestProperty("If-None-Match", str);
        setCommonRequestHeaders(httpURLConnection, str2);
        setCustomRequestHeaders(httpURLConnection, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpURLConnection createHttpURLConnection() throws FirebaseRemoteConfigException {
        try {
            return (HttpURLConnection) new URL(getFetchUrl(this.projectNumber, this.namespace)).openConnection();
        } catch (IOException e2) {
            throw new FirebaseRemoteConfigException(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public ConfigFetchHandler.FetchResponse fetch(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map, String str3, Map<String, String> map2, Date date) throws FirebaseRemoteConfigException {
        setUpUrlConnection(httpURLConnection, str3, str2, map2);
        try {
            try {
                setFetchRequestBody(httpURLConnection, createFetchRequestBody(str, str2, map).toString().getBytes("utf-8"));
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    String headerField = httpURLConnection.getHeaderField("ETag");
                    JSONObject fetchResponseBody = getFetchResponseBody(httpURLConnection);
                    try {
                        httpURLConnection.getInputStream().close();
                    } catch (IOException unused) {
                    }
                    if (!backendHasUpdates(fetchResponseBody)) {
                        return ConfigFetchHandler.FetchResponse.forBackendHasNoUpdates(date);
                    }
                    return ConfigFetchHandler.FetchResponse.forBackendUpdatesFetched(extractConfigs(fetchResponseBody, date), headerField);
                }
                throw new FirebaseRemoteConfigServerException(responseCode, httpURLConnection.getResponseMessage());
            } finally {
                httpURLConnection.disconnect();
                try {
                    httpURLConnection.getInputStream().close();
                } catch (IOException unused2) {
                }
            }
        } catch (IOException | JSONException e2) {
            throw new FirebaseRemoteConfigClientException("The client had an error while calling the backend!", e2);
        }
    }

    @VisibleForTesting
    public long getConnectTimeoutInSeconds() {
        return this.connectTimeoutInSeconds;
    }

    @VisibleForTesting
    public long getReadTimeoutInSeconds() {
        return this.readTimeoutInSeconds;
    }
}
