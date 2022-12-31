package us.pinguo.advconfigdata.AdvAddition;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.DispatcherData.b;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvUtils;
/* compiled from: AdvAdditionTask.java */
/* loaded from: classes3.dex */
class a extends b {
    private AdvAdditionData a;

    private void b(String str, int i2, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        long j2 = i2 < 0 ? 0L : i2 * 1000;
        if (j2 > 0) {
            try {
                Thread.sleep(j2);
            } catch (InterruptedException e2) {
                AdvLog.Log(e2.getMessage());
            }
        }
        try {
            AdvUtils.getLikeWebView(str);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Map<String, String> commonHttpParams = AdvConfigManager.getInstance().getCommonHttpParams();
            HashMap hashMap = new HashMap(commonHttpParams);
            Uri parse = Uri.parse(str2);
            for (String str3 : c(parse)) {
                hashMap.put(str3, parse.getQueryParameter(str3));
            }
            String sigByParamMap = AdvUtils.getSigByParamMap(hashMap, AdvConfigManager.getInstance().getAdvConfig().getHttpRequestMD5Secret());
            String url = AdvUtils.getUrl(str2, commonHttpParams);
            AdvUtils.get(url + "&sig=" + sigByParamMap);
        } catch (Exception e3) {
            AdvLog.Log(e3.getMessage());
        }
    }

    private Set<String> c(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            String encodedQuery = uri.getEncodedQuery();
            if (encodedQuery == null) {
                return Collections.emptySet();
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i2 = 0;
            do {
                int indexOf = encodedQuery.indexOf(38, i2);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i2);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i2, indexOf2)));
                i2 = indexOf + 1;
            } while (i2 < encodedQuery.length());
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.EMPTY_SET;
    }

    public void a(AdvAdditionData advAdditionData) {
        this.a = advAdditionData;
        super.execute();
    }

    @Override // us.pinguo.advconfigdata.DispatcherData.b
    protected void doInBackground() {
        AdvAdditionData advAdditionData = this.a;
        if (advAdditionData == null) {
            return;
        }
        b(advAdditionData.clkUrl1, advAdditionData.clkInterval1, advAdditionData.clkUrl1CallBack);
        AdvAdditionData advAdditionData2 = this.a;
        b(advAdditionData2.clkUrl2, advAdditionData2.clkInterval2, advAdditionData2.clkUrl2CallBack);
    }
}
