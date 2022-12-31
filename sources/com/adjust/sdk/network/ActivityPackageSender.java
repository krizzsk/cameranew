package com.adjust.sdk.network;

import android.net.Uri;
import com.adjust.sdk.ActivityKind;
import com.adjust.sdk.ActivityPackage;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.ResponseData;
import com.adjust.sdk.TrackingState;
import com.adjust.sdk.Util;
import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.network.UtilNetworking;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.tapjoy.TapjoyConstants;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes.dex */
public class ActivityPackageSender implements IActivityPackageSender {
    private String basePath;
    private String clientSdk;
    private String gdprPath;
    private String subscriptionPath;
    private UrlStrategy urlStrategy;
    private ILogger logger = AdjustFactory.getLogger();
    private ThreadExecutor executor = new SingleThreadCachedScheduler("ActivityPackageSender");
    private UtilNetworking.IHttpsURLConnectionProvider httpsURLConnectionProvider = AdjustFactory.getHttpsURLConnectionProvider();
    private UtilNetworking.IConnectionOptions connectionOptions = AdjustFactory.getConnectionOptions();

    public ActivityPackageSender(String str, String str2, String str3, String str4, String str5) {
        this.basePath = str2;
        this.gdprPath = str3;
        this.subscriptionPath = str4;
        this.clientSdk = str5;
        this.urlStrategy = new UrlStrategy(AdjustFactory.getBaseUrl(), AdjustFactory.getGdprUrl(), AdjustFactory.getSubscriptionUrl(), str);
    }

    private String buildAuthorizationHeader(ActivityPackage activityPackage) {
        Map<String, String> parameters = activityPackage.getParameters();
        String activityKind = activityPackage.getActivityKind().toString();
        String extractSecretId = extractSecretId(parameters);
        String buildAuthorizationHeaderV2 = buildAuthorizationHeaderV2(extractSignature(parameters), extractSecretId, extractHeadersId(parameters), extractAlgorithm(parameters), extractNativeVersion(parameters));
        return buildAuthorizationHeaderV2 != null ? buildAuthorizationHeaderV2 : buildAuthorizationHeaderV1(parameters, extractAppSecret(parameters), extractSecretId, activityKind);
    }

    private String buildAuthorizationHeaderV1(Map<String, String> map, String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Map<String, String> signature = getSignature(map, str3, str);
        String formatString = Util.formatString("Signature %s,%s,%s,%s", Util.formatString("secret_id=\"%s\"", str2), Util.formatString("signature=\"%s\"", Util.sha256(signature.get("clear_signature"))), Util.formatString("algorithm=\"%s\"", "sha256"), Util.formatString("headers=\"%s\"", signature.get("fields")));
        this.logger.verbose("authorizationHeader: %s", formatString);
        return formatString;
    }

    private String buildAuthorizationHeaderV2(String str, String str2, String str3, String str4, String str5) {
        if (str2 == null || str == null || str3 == null) {
            return null;
        }
        String formatString = Util.formatString("signature=\"%s\"", str);
        String formatString2 = Util.formatString("secret_id=\"%s\"", str2);
        String formatString3 = Util.formatString("headers_id=\"%s\"", str3);
        Object[] objArr = new Object[1];
        if (str4 == null) {
            str4 = "adj1";
        }
        objArr[0] = str4;
        String formatString4 = Util.formatString("algorithm=\"%s\"", objArr);
        Object[] objArr2 = new Object[1];
        if (str5 == null) {
            str5 = "";
        }
        objArr2[0] = str5;
        String formatString5 = Util.formatString("Signature %s,%s,%s,%s,%s", formatString, formatString2, formatString4, formatString3, Util.formatString("native_version=\"%s\"", objArr2));
        this.logger.verbose("authorizationHeader: %s", formatString5);
        return formatString5;
    }

    private DataOutputStream configConnectionForGET(HttpsURLConnection httpsURLConnection) throws ProtocolException {
        httpsURLConnection.setRequestMethod("GET");
        return null;
    }

    private DataOutputStream configConnectionForPOST(HttpsURLConnection httpsURLConnection, ActivityPackage activityPackage, Map<String, String> map) throws ProtocolException, UnsupportedEncodingException, IOException {
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        String generatePOSTBodyString = generatePOSTBodyString(activityPackage.getParameters(), map);
        if (generatePOSTBodyString == null) {
            return null;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(generatePOSTBodyString);
        return dataOutputStream;
    }

    private String errorMessage(Throwable th, String str, ActivityPackage activityPackage) {
        return Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th));
    }

    private static String extractAlgorithm(Map<String, String> map) {
        return map.remove("algorithm");
    }

    private static String extractAppSecret(Map<String, String> map) {
        return map.remove("app_secret");
    }

    private static void extractEventCallbackId(Map<String, String> map) {
        map.remove("event_callback_id");
    }

    private static String extractHeadersId(Map<String, String> map) {
        return map.remove("headers_id");
    }

    private static String extractNativeVersion(Map<String, String> map) {
        return map.remove("native_version");
    }

    private static String extractSecretId(Map<String, String> map) {
        return map.remove("secret_id");
    }

    private static String extractSignature(Map<String, String> map) {
        return map.remove("signature");
    }

    private String generatePOSTBodyString(Map<String, String> map, Map<String, String> map2) throws UnsupportedEncodingException {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        injectParametersToPOSTStringBuilder(map, sb);
        injectParametersToPOSTStringBuilder(map2, sb);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '&') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private String generateUrlStringForGET(ActivityPackage activityPackage, Map<String, String> map) throws MalformedURLException {
        URL url = new URL(urlWithExtraPathByActivityKind(activityPackage.getActivityKind(), this.urlStrategy.targetUrlByActivityKind(activityPackage.getActivityKind())));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(url.getProtocol());
        builder.encodedAuthority(url.getAuthority());
        builder.path(url.getPath());
        builder.appendPath(activityPackage.getPath());
        this.logger.debug("Making request to url: %s", builder.toString());
        for (Map.Entry<String, String> entry : activityPackage.getParameters().entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        if (map != null) {
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                builder.appendQueryParameter(entry2.getKey(), entry2.getValue());
            }
        }
        return builder.build().toString();
    }

    private String generateUrlStringForPOST(ActivityPackage activityPackage) {
        String formatString = Util.formatString("%s%s", urlWithExtraPathByActivityKind(activityPackage.getActivityKind(), this.urlStrategy.targetUrlByActivityKind(activityPackage.getActivityKind())), activityPackage.getPath());
        this.logger.debug("Making request to url : %s", formatString);
        return formatString;
    }

    private Map<String, String> getSignature(Map<String, String> map, String str, String str2) {
        String validIdentifier = getValidIdentifier(map);
        String str3 = map.get("source");
        String str4 = map.get("payload");
        HashMap hashMap = new HashMap();
        hashMap.put("app_secret", str2);
        hashMap.put("created_at", map.get("created_at"));
        hashMap.put("activity_kind", str);
        hashMap.put(validIdentifier, map.get(validIdentifier));
        if (str3 != null) {
            hashMap.put("source", str3);
        }
        if (str4 != null) {
            hashMap.put("payload", str4);
        }
        String str5 = "";
        String str6 = "";
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                str5 = str5 + ((String) entry.getKey()) + " ";
                str6 = str6 + ((String) entry.getValue());
            }
        }
        String substring = str5.substring(0, str5.length() - 1);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("clear_signature", str6);
        hashMap2.put("fields", substring);
        return hashMap2;
    }

    private String getValidIdentifier(Map<String, String> map) {
        if (map.get("gps_adid") != null) {
            return "gps_adid";
        }
        if (map.get("fire_adid") != null) {
            return "fire_adid";
        }
        if (map.get(TapjoyConstants.TJC_ANDROID_ID) != null) {
            return TapjoyConstants.TJC_ANDROID_ID;
        }
        if (map.get("mac_sha1") != null) {
            return "mac_sha1";
        }
        if (map.get("mac_md5") != null) {
            return "mac_md5";
        }
        if (map.get("android_uuid") != null) {
            return "android_uuid";
        }
        return null;
    }

    private void injectParametersToPOSTStringBuilder(Map<String, String> map, StringBuilder sb) throws UnsupportedEncodingException {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String encode = URLEncoder.encode(entry.getKey(), "UTF-8");
            String value = entry.getValue();
            String encode2 = value != null ? URLEncoder.encode(value, "UTF-8") : "";
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
            sb.append("&");
        }
    }

    private void localError(Throwable th, String str, ResponseData responseData) {
        String errorMessage = errorMessage(th, str, responseData.activityPackage);
        this.logger.error(errorMessage, new Object[0]);
        responseData.message = errorMessage;
        responseData.willRetry = false;
    }

    private void parseResponse(ResponseData responseData, String str) {
        if (str.length() == 0) {
            this.logger.error("Empty response string", new Object[0]);
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            this.logger.error(errorMessage(e2, "Failed to parse JSON response", responseData.activityPackage), new Object[0]);
        }
        if (jSONObject == null) {
            return;
        }
        responseData.jsonResponse = jSONObject;
        responseData.message = UtilNetworking.extractJsonString(jSONObject, "message");
        responseData.adid = UtilNetworking.extractJsonString(jSONObject, "adid");
        responseData.timestamp = UtilNetworking.extractJsonString(jSONObject, "timestamp");
        String extractJsonString = UtilNetworking.extractJsonString(jSONObject, "tracking_state");
        if (extractJsonString != null && extractJsonString.equals("opted_out")) {
            responseData.trackingState = TrackingState.OPTED_OUT;
        }
        responseData.askIn = UtilNetworking.extractJsonLong(jSONObject, "ask_in");
        responseData.retryIn = UtilNetworking.extractJsonLong(jSONObject, "retry_in");
        responseData.continueIn = UtilNetworking.extractJsonLong(jSONObject, "continue_in");
        responseData.attribution = AdjustAttribution.fromJson(jSONObject.optJSONObject("attribution"), responseData.adid, Util.getSdkPrefixPlatform(this.clientSdk));
    }

    private void remoteError(Throwable th, String str, ResponseData responseData) {
        String str2 = errorMessage(th, str, responseData.activityPackage) + " Will retry later";
        this.logger.error(str2, new Object[0]);
        responseData.message = str2;
        responseData.willRetry = true;
    }

    private boolean shouldRetryToSend(ResponseData responseData) {
        if (!responseData.willRetry) {
            this.logger.debug("Will not retry with current url strategy", new Object[0]);
            this.urlStrategy.resetAfterSuccess();
            return false;
        } else if (this.urlStrategy.shouldRetryAfterFailure()) {
            this.logger.error("Failed with current url strategy, but it will retry with new", new Object[0]);
            return true;
        } else {
            this.logger.error("Failed with current url strategy and it will not retry", new Object[0]);
            return false;
        }
    }

    private void tryToGetResponse(ResponseData responseData) {
        String generateUrlStringForPOST;
        DataOutputStream dataOutputStream = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                ActivityPackage activityPackage = responseData.activityPackage;
                                Map<String, String> map = responseData.sendingParameters;
                                boolean z = true;
                                boolean z2 = activityPackage.getActivityKind() == ActivityKind.ATTRIBUTION;
                                if (z2) {
                                    extractEventCallbackId(activityPackage.getParameters());
                                    generateUrlStringForPOST = generateUrlStringForGET(activityPackage, map);
                                } else {
                                    generateUrlStringForPOST = generateUrlStringForPOST(activityPackage);
                                }
                                HttpsURLConnection generateHttpsURLConnection = this.httpsURLConnectionProvider.generateHttpsURLConnection(new URL(generateUrlStringForPOST));
                                this.connectionOptions.applyConnectionOptions(generateHttpsURLConnection, activityPackage.getClientSdk());
                                String buildAuthorizationHeader = buildAuthorizationHeader(activityPackage);
                                if (buildAuthorizationHeader != null) {
                                    generateHttpsURLConnection.setRequestProperty(HttpRequest.HEADER_AUTHORIZATION, buildAuthorizationHeader);
                                }
                                if (z2) {
                                    dataOutputStream = configConnectionForGET(generateHttpsURLConnection);
                                } else {
                                    extractEventCallbackId(activityPackage.getParameters());
                                    dataOutputStream = configConnectionForPOST(generateHttpsURLConnection, activityPackage, map);
                                }
                                Integer readConnectionResponse = readConnectionResponse(generateHttpsURLConnection, responseData);
                                responseData.success = responseData.jsonResponse != null && responseData.retryIn == null && readConnectionResponse != null && readConnectionResponse.intValue() == 200;
                                if (responseData.jsonResponse != null && responseData.retryIn == null) {
                                    z = false;
                                }
                                responseData.willRetry = z;
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.flush();
                                        dataOutputStream.close();
                                    } catch (IOException e2) {
                                        this.logger.error(errorMessage(e2, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                                    }
                                }
                            }
                        } catch (MalformedURLException e3) {
                            localError(e3, "Malformed URL", responseData);
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.flush();
                                    dataOutputStream.close();
                                } catch (IOException e4) {
                                    this.logger.error(errorMessage(e4, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                                }
                            }
                        }
                    } catch (ProtocolException e5) {
                        localError(e5, "Protocol Error", responseData);
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (IOException e6) {
                                this.logger.error(errorMessage(e6, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                            }
                        }
                    }
                } catch (SSLHandshakeException e7) {
                    remoteError(e7, "Certificate failed", responseData);
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        } catch (IOException e8) {
                            this.logger.error(errorMessage(e8, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                        }
                    }
                }
            } catch (SocketTimeoutException e9) {
                remoteError(e9, "Request timed out", responseData);
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    } catch (IOException e10) {
                        this.logger.error(errorMessage(e10, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                    }
                }
            }
        } catch (UnsupportedEncodingException e11) {
            localError(e11, "Failed to encode parameters", responseData);
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (IOException e12) {
                    this.logger.error(errorMessage(e12, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (IOException e13) {
            remoteError(e13, "Request failed", responseData);
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (IOException e14) {
                    this.logger.error(errorMessage(e14, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        }
    }

    private String urlWithExtraPathByActivityKind(ActivityKind activityKind, String str) {
        if (activityKind == ActivityKind.GDPR) {
            if (this.gdprPath != null) {
                return str + this.gdprPath;
            }
            return str;
        } else if (activityKind == ActivityKind.SUBSCRIPTION) {
            if (this.subscriptionPath != null) {
                return str + this.subscriptionPath;
            }
            return str;
        } else if (this.basePath != null) {
            return str + this.basePath;
        } else {
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r7 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r0.length() != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
        r6.logger.error("Empty response string buffer", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (r2.intValue() != 429) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        r6.logger.error("Too frequent requests to the endpoint (429)", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
        r7 = r0.toString();
        r6.logger.debug("Response string: %s", r7);
        parseResponse(r8, r7);
        r7 = r8.message;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0089, code lost:
        if (r7 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008e, code lost:
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
        if (r2.intValue() != 200) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
        r6.logger.info("Response message: %s", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:
        r6.logger.error("Response message: %s", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ab, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.Integer readConnectionResponse(javax.net.ssl.HttpsURLConnection r7, com.adjust.sdk.ResponseData r8) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = 0
            r7.connect()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            int r3 = r7.getResponseCode()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            int r3 = r2.intValue()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r4 = 400(0x190, float:5.6E-43)
            if (r3 < r4) goto L1f
            java.io.InputStream r3 = r7.getErrorStream()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            goto L23
        L1f:
            java.io.InputStream r3 = r7.getInputStream()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
        L23:
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
        L2d:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            if (r4 == 0) goto L37
            r0.append(r4)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            goto L2d
        L37:
            if (r7 == 0) goto L52
        L39:
            r7.disconnect()
            goto L52
        L3d:
            r8 = move-exception
            goto Lac
        L3f:
            r3 = move-exception
            java.lang.String r4 = "Connecting and reading response"
            com.adjust.sdk.ActivityPackage r5 = r8.activityPackage     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = r6.errorMessage(r3, r4, r5)     // Catch: java.lang.Throwable -> L3d
            com.adjust.sdk.ILogger r4 = r6.logger     // Catch: java.lang.Throwable -> L3d
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L3d
            r4.error(r3, r5)     // Catch: java.lang.Throwable -> L3d
            if (r7 == 0) goto L52
            goto L39
        L52:
            int r7 = r0.length()
            if (r7 != 0) goto L62
            com.adjust.sdk.ILogger r7 = r6.logger
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r0 = "Empty response string buffer"
            r7.error(r0, r8)
            return r2
        L62:
            int r7 = r2.intValue()
            r3 = 429(0x1ad, float:6.01E-43)
            if (r7 != r3) goto L74
            com.adjust.sdk.ILogger r7 = r6.logger
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r0 = "Too frequent requests to the endpoint (429)"
            r7.error(r0, r8)
            return r2
        L74:
            java.lang.String r7 = r0.toString()
            com.adjust.sdk.ILogger r0 = r6.logger
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r1] = r7
            java.lang.String r5 = "Response string: %s"
            r0.debug(r5, r4)
            r6.parseResponse(r8, r7)
            java.lang.String r7 = r8.message
            if (r7 != 0) goto L8c
            return r2
        L8c:
            java.lang.String r8 = "Response message: %s"
            if (r2 == 0) goto La2
            int r0 = r2.intValue()
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 != r4) goto La2
            com.adjust.sdk.ILogger r0 = r6.logger
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r1] = r7
            r0.info(r8, r3)
            goto Lab
        La2:
            com.adjust.sdk.ILogger r0 = r6.logger
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r1] = r7
            r0.error(r8, r3)
        Lab:
            return r2
        Lac:
            if (r7 == 0) goto Lb1
            r7.disconnect()
        Lb1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.network.ActivityPackageSender.readConnectionResponse(javax.net.ssl.HttpsURLConnection, com.adjust.sdk.ResponseData):java.lang.Integer");
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender
    public void sendActivityPackage(final ActivityPackage activityPackage, final Map<String, String> map, final IActivityPackageSender.ResponseDataCallbackSubscriber responseDataCallbackSubscriber) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.network.ActivityPackageSender.1
            @Override // java.lang.Runnable
            public void run() {
                responseDataCallbackSubscriber.onResponseDataCallback(ActivityPackageSender.this.sendActivityPackageSync(activityPackage, map));
            }
        });
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender
    public ResponseData sendActivityPackageSync(ActivityPackage activityPackage, Map<String, String> map) {
        ResponseData buildResponseData;
        do {
            buildResponseData = ResponseData.buildResponseData(activityPackage, map);
            tryToGetResponse(buildResponseData);
        } while (shouldRetryToSend(buildResponseData));
        return buildResponseData;
    }
}
