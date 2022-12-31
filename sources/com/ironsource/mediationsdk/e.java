package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* compiled from: AuctionHandler.java */
/* loaded from: classes2.dex */
public class e {
    private String a;
    private String b = IronSourceUtils.L();
    private com.ironsource.mediationsdk.utils.b c;

    /* renamed from: d  reason: collision with root package name */
    private d f5541d;

    /* renamed from: e  reason: collision with root package name */
    private r f5542e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuctionHandler.java */
    /* loaded from: classes2.dex */
    public static class a extends AsyncTask<Object, Void, Boolean> {
        private WeakReference<d> a;
        private JSONObject b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private String f5543d;

        /* renamed from: e  reason: collision with root package name */
        private String f5544e;

        /* renamed from: f  reason: collision with root package name */
        private List<f> f5545f;

        /* renamed from: g  reason: collision with root package name */
        private f f5546g;

        /* renamed from: h  reason: collision with root package name */
        private JSONObject f5547h;

        /* renamed from: i  reason: collision with root package name */
        private long f5548i;

        /* renamed from: j  reason: collision with root package name */
        private int f5549j;

        /* renamed from: k  reason: collision with root package name */
        private String f5550k = us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;

        a(d dVar) {
            this.a = new WeakReference<>(dVar);
        }

        private JSONObject b(String str) throws JSONException {
            String b = com.ironsource.mediationsdk.utils.g.b("C38FB23A402222A0C17D34A92F971D1F", str);
            if (!TextUtils.isEmpty(b)) {
                return new JSONObject(b);
            }
            throw new JSONException("decryption error");
        }

        private JSONObject c(String str) throws JSONException {
            IronLog.INTERNAL.info("decrypting and decompressing auction response");
            String d2 = com.ironsource.mediationsdk.utils.g.d(str);
            if (d2 != null) {
                return new JSONObject(d2);
            }
            throw new JSONException("decompression error");
        }

        private void d(String str, boolean z, boolean z2) throws JSONException {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (z) {
                    String string = jSONObject.getString("response");
                    if (z2) {
                        jSONObject = c(string);
                    } else {
                        jSONObject = b(string);
                    }
                }
                AuctionDataUtils.a f2 = AuctionDataUtils.getInstance().f(jSONObject);
                this.f5544e = f2.h();
                this.f5545f = f2.m();
                this.f5546g = f2.k();
                this.f5547h = f2.l();
                this.c = f2.i();
                this.f5543d = f2.j();
                return;
            }
            throw new JSONException("empty response");
        }

        private HttpURLConnection f(URL url, long j2) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "application/json; charset=utf-8");
            httpURLConnection.setReadTimeout((int) j2);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            return httpURLConnection;
        }

        private String g(HttpURLConnection httpURLConnection) throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
            }
        }

        private void h(HttpURLConnection httpURLConnection, JSONObject jSONObject, boolean z) throws Exception {
            String format;
            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            String jSONObject2 = jSONObject.toString();
            if (z) {
                IronLog.INTERNAL.info("compressing and encrypting auction request");
                format = String.format("{\"request\" : \"%1$s\"}", com.ironsource.mediationsdk.utils.g.a(jSONObject2));
            } else {
                format = String.format("{\"request\" : \"%1$s\"}", com.ironsource.mediationsdk.utils.g.e("C38FB23A402222A0C17D34A92F971D1F", jSONObject2));
            }
            bufferedWriter.write(format);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
        }

        private void i(long j2, long j3) {
            long time = j2 - (new Date().getTime() - j3);
            if (time > 0) {
                SystemClock.sleep(time);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Object... objArr) {
            long time;
            int responseCode;
            this.f5548i = new Date().getTime();
            try {
                URL url = new URL((String) objArr[0]);
                int i2 = 1;
                this.b = (JSONObject) objArr[1];
                boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                int intValue = ((Integer) objArr[3]).intValue();
                long longValue = ((Long) objArr[4]).longValue();
                boolean booleanValue2 = ((Boolean) objArr[5]).booleanValue();
                boolean booleanValue3 = ((Boolean) objArr[6]).booleanValue();
                this.f5549j = 0;
                HttpURLConnection httpURLConnection = null;
                while (this.f5549j < intValue) {
                    try {
                        time = new Date().getTime();
                        String str = "Auction Handler: auction trial " + (this.f5549j + i2) + " out of " + intValue + " max trials";
                        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, str, 0);
                        IronSourceUtils.j0(str);
                        httpURLConnection = f(url, longValue);
                        h(httpURLConnection, this.b, booleanValue2);
                        responseCode = httpURLConnection.getResponseCode();
                    } catch (SocketTimeoutException unused) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.c = 1006;
                        this.f5543d = "Connection timed out";
                    } catch (Exception e2) {
                        IronLog.INTERNAL.error("getting exception " + e2);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.c = 1000;
                        this.f5543d = e2.getMessage();
                        this.f5550k = us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
                        return Boolean.FALSE;
                    }
                    if (responseCode != 200) {
                        this.c = 1001;
                        String str2 = "Auction status not 200 error, error code response from server - " + responseCode;
                        this.f5543d = str2;
                        IronLog.INTERNAL.error(str2);
                        httpURLConnection.disconnect();
                        if (this.f5549j < intValue - 1) {
                            i(longValue, time);
                        }
                        i2 = 1;
                        this.f5549j++;
                    } else {
                        try {
                            d(g(httpURLConnection), booleanValue, booleanValue3);
                            httpURLConnection.disconnect();
                            return Boolean.TRUE;
                        } catch (JSONException e3) {
                            if (e3.getMessage() != null && e3.getMessage().equalsIgnoreCase("decryption error")) {
                                this.c = 1003;
                                this.f5543d = "Auction decryption error";
                            }
                            if (e3.getMessage() != null && e3.getMessage().equalsIgnoreCase("decompression error")) {
                                this.c = 1008;
                                this.f5543d = "Auction decompression error";
                            } else {
                                this.c = 1002;
                                this.f5543d = "Auction parsing error";
                            }
                            this.f5550k = "parsing";
                            httpURLConnection.disconnect();
                            return Boolean.FALSE;
                        }
                    }
                }
                this.f5549j = intValue - i2;
                this.f5550k = "trials_fail";
                return Boolean.FALSE;
            } catch (Exception e4) {
                this.c = 1007;
                this.f5543d = e4.getMessage();
                this.f5549j = 0;
                this.f5550k = us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: e */
        public void onPostExecute(Boolean bool) {
            d dVar = this.a.get();
            if (dVar == null) {
                return;
            }
            long time = new Date().getTime() - this.f5548i;
            if (bool.booleanValue()) {
                dVar.I(this.f5545f, this.f5544e, this.f5546g, this.f5547h, this.f5549j + 1, time);
            } else {
                dVar.f(this.c, this.f5543d, this.f5549j + 1, this.f5550k, time);
            }
        }
    }

    public e(String str, com.ironsource.mediationsdk.utils.b bVar, d dVar) {
        this.a = str;
        this.c = bVar;
        this.f5541d = dVar;
    }

    private JSONObject c(Context context, Map<String, Object> map, List<String> list, AuctionHistory auctionHistory, int i2, boolean z) throws JSONException {
        new JSONObject();
        JSONObject d2 = AuctionDataUtils.getInstance().d(context, map, list, auctionHistory, i2, this.b, this.c, this.f5542e);
        d2.put("adUnit", this.a);
        d2.put("doNotEncryptResponse", z ? "false" : "true");
        return d2;
    }

    public void a(Context context, Map<String, Object> map, List<String> list, AuctionHistory auctionHistory, int i2) {
        try {
            boolean z = IronSourceUtils.K() == 1;
            new a(this.f5541d).execute(this.c.p(), c(context, map, list, auctionHistory, i2, z), Boolean.valueOf(z), Integer.valueOf(this.c.i()), Long.valueOf(this.c.o()), Boolean.valueOf(this.c.q()), Boolean.valueOf(this.c.r()));
        } catch (Exception e2) {
            this.f5541d.f(1000, e2.getMessage(), 0, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, 0L);
        }
    }

    public void b(Context context, Map<String, Object> map, List<String> list, AuctionHistory auctionHistory, int i2, r rVar) {
        this.f5542e = rVar;
        a(context, map, list, auctionHistory, i2);
    }

    public void d(ArrayList<String> arrayList, ConcurrentHashMap<String, f> concurrentHashMap, int i2, f fVar, f fVar2) {
        Iterator<String> it = arrayList.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            String next = it.next();
            if (next.equals(fVar2.c())) {
                z2 = i2 == 2;
                z = true;
            } else {
                f fVar3 = concurrentHashMap.get(next);
                String f2 = fVar3.f();
                String str = z ? z2 ? "102" : "103" : "1";
                for (String str2 : fVar3.d()) {
                    AuctionDataUtils.getInstance().m("reportAuctionLose", fVar3.c(), AuctionDataUtils.getInstance().b(str2, i2, fVar2, f2, str, ""));
                }
            }
        }
        if (fVar != null) {
            for (String str3 : fVar.d()) {
                AuctionDataUtils.getInstance().m("reportAuctionLose", "GenericNotifications", AuctionDataUtils.getInstance().b(str3, i2, fVar2, "", "102", ""));
            }
        }
    }

    public void e(CopyOnWriteArrayList<c0> copyOnWriteArrayList, ConcurrentHashMap<String, f> concurrentHashMap, int i2, f fVar, f fVar2) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<c0> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().x());
        }
        d(arrayList, concurrentHashMap, i2, fVar, fVar2);
    }

    public void f(f fVar, int i2, f fVar2, String str) {
        for (String str2 : fVar.a()) {
            AuctionDataUtils.getInstance().m("reportImpression", fVar.c(), AuctionDataUtils.getInstance().b(str2, i2, fVar, "", "", str));
        }
        if (fVar2 != null) {
            for (String str3 : fVar2.a()) {
                AuctionDataUtils.getInstance().m("reportImpression", "GenericNotifications", AuctionDataUtils.getInstance().b(str3, i2, fVar, "", "102", str));
            }
        }
    }

    public void g(f fVar, int i2, f fVar2) {
        for (String str : fVar.e()) {
            AuctionDataUtils.getInstance().m("reportLoadSuccess", fVar.c(), AuctionDataUtils.getInstance().b(str, i2, fVar, "", "", ""));
        }
        if (fVar2 != null) {
            for (String str2 : fVar2.e()) {
                AuctionDataUtils.getInstance().m("reportLoadSuccess", "GenericNotifications", AuctionDataUtils.getInstance().b(str2, i2, fVar, "", "102", ""));
            }
        }
    }
}
