package us.pinguo.advconfigdata.DispatcherData;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.location.LocationRequestCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.e;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvFileUtils;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvMD5;
import us.pinguo.advconfigdata.Utils.AdvSystemUtils;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.advconfigdata.Utils.AdvUtils;
import us.pinguo.advconfigdata.crontab.CrontabParser;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.advconfigdata.database.AdvRepairItem;
/* loaded from: classes3.dex */
public class AdvDataKeeper {
    private String b;
    private JSONObject c;

    /* renamed from: d  reason: collision with root package name */
    private Context f9014d;

    /* renamed from: g  reason: collision with root package name */
    private int f9017g;

    /* renamed from: h  reason: collision with root package name */
    private int f9018h;
    private AtomicBoolean a = new AtomicBoolean(true);

    /* renamed from: e  reason: collision with root package name */
    private b f9015e = new b();

    /* renamed from: f  reason: collision with root package name */
    private CrontabParser f9016f = new CrontabParser();

    /* loaded from: classes3.dex */
    public static class VideoData implements Parcelable {
        public static final Parcelable.Creator<VideoData> CREATOR = new a();
        public int height;
        public int rotate;
        public String videoUrl;
        public int width;

        /* loaded from: classes3.dex */
        class a implements Parcelable.Creator<VideoData> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public VideoData createFromParcel(Parcel parcel) {
                return new VideoData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public VideoData[] newArray(int i2) {
                return new VideoData[i2];
            }
        }

        public VideoData() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.videoUrl);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            parcel.writeInt(this.rotate);
        }

        protected VideoData(Parcel parcel) {
            this.videoUrl = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
            this.rotate = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Comparator<AdvItem> {
        private b() {
        }

        private int b(AdvItem advItem, AdvItem advItem2) {
            double d2 = advItem2.priority - advItem.priority;
            if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return Double.valueOf(d2).intValue();
            }
            return Long.valueOf(advItem2.activeTime - advItem.activeTime).intValue();
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(AdvItem advItem, AdvItem advItem2) {
            if (advItem2.forceSingle) {
                if (advItem.forceSingle) {
                    return b(advItem, advItem2);
                }
                return 1;
            } else if (advItem.forceSingle) {
                return -1;
            } else {
                return b(advItem, advItem2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public List<String> a;
        public List<String> b;
        public List<String> c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f9019d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f9020e;
    }

    /* loaded from: classes3.dex */
    public static class d {
        public c a;
    }

    public AdvDataKeeper(Context context) {
        this.f9014d = context;
        this.f9017g = AdvSystemUtils.getScreenSize(this.f9014d)[0];
        this.f9018h = AdvSystemUtils.getScreenSize(this.f9014d)[1];
    }

    private AdvItem o(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (AdvUtils.isHttpUrl(str)) {
            AdvItem advItem = new AdvItem();
            advItem.guid = str2;
            advItem.imageUrl = str;
            advItem.nonWifiPicPreload = i2 == 1;
            return advItem;
        } else if (str.startsWith("callApi://")) {
            AdvItem advItem2 = new AdvItem();
            advItem2.guid = str2;
            advItem2.interactionUri = str;
            advItem2.nonWifiPicPreload = i2 == 1;
            return advItem2;
        } else {
            return null;
        }
    }

    private void s(AdvItem advItem, JSONObject jSONObject) {
        if (jSONObject.has("htmlData")) {
            try {
                advItem.htmlSource = jSONObject.getJSONObject("htmlData").optString(TJAdUnitConstants.String.HTML);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private ArrayList<ImageData> t(JSONObject jSONObject) throws JSONException {
        ArrayList<ImageData> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("iconData");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            optJSONArray = jSONObject.optJSONArray("blackIconData");
        }
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                ImageData imageData = new ImageData();
                imageData.originImageUrl = jSONObject2.getString("imageUrl");
                imageData.width = jSONObject2.optInt("width", 0);
                imageData.height = jSONObject2.optInt("height", 0);
                imageData.ratio = jSONObject2.optString("ratio", "");
                arrayList.add(imageData);
            }
        }
        return arrayList;
    }

    private ArrayList<ImageData> u(JSONObject jSONObject) throws JSONException {
        ArrayList<ImageData> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("imageData");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                ImageData imageData = new ImageData();
                imageData.originImageUrl = jSONObject2.getString("imageUrl");
                imageData.width = jSONObject2.optInt("width", 0);
                imageData.height = jSONObject2.optInt("height", 0);
                imageData.ratio = jSONObject2.optString("ratio", "");
                arrayList.add(imageData);
            }
        }
        return arrayList;
    }

    private ImageData v(String str, JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("imageData");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                ImageData imageData = new ImageData();
                imageData.originImageUrl = jSONObject2.getString("imageUrl");
                imageData.width = jSONObject2.optInt("width", 0);
                imageData.height = jSONObject2.optInt("height", 0);
                imageData.ratio = jSONObject2.optString("ratio", "");
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("zoom");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        imageData.zoomList.add(optJSONArray2.getString(i3));
                    }
                }
                JSONArray optJSONArray3 = jSONObject2.optJSONArray("quality");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        imageData.qualityList.add(optJSONArray3.getString(i4));
                    }
                }
                arrayList.add(imageData);
            }
        }
        if (arrayList.size() == 0) {
            ImageData imageData2 = new ImageData();
            imageData2.finalImageUrl = "";
            return imageData2;
        }
        ImageData imageData3 = null;
        float f2 = (this.f9018h * 1.0f) / this.f9017g;
        AdvLog.Log("suitRatio:" + f2);
        float f3 = Float.MAX_VALUE;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ImageData imageData4 = (ImageData) arrayList.get(i5);
            try {
                String[] split = imageData4.ratio.split("x");
                if (split.length == 2) {
                    float round = Math.round(Math.abs(((Integer.parseInt(split[0]) * 1.0f) / Integer.parseInt(split[1])) - f2) * 1000.0f) / 1000.0f;
                    if (round < f3) {
                        imageData3 = imageData4;
                        f3 = round;
                    } else if (round == f3) {
                        if (imageData3 != null) {
                            int abs = Math.abs(imageData3.width - this.f9017g);
                            int abs2 = Math.abs(imageData4.width - this.f9017g);
                            if (abs <= abs2) {
                                if (abs == abs2) {
                                    if (imageData4.width <= imageData3.width) {
                                    }
                                }
                            }
                            imageData3 = imageData4;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (imageData3 == null) {
            ((ImageData) arrayList.get(0)).finalImageUrl = ((ImageData) arrayList.get(0)).originImageUrl;
            return (ImageData) arrayList.get(0);
        }
        AdvLog.Log("suitImageData:" + imageData3.ratio);
        imageData3.finalImageUrl = imageData3.originImageUrl;
        return imageData3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00dc, code lost:
        if (r4 == 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0117, code lost:
        if (r22.f9016f.parse(r10).equalsCalendar(r3) == false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void w(org.json.JSONObject r23, java.lang.String r24, java.util.List<us.pinguo.advconfigdata.database.AdvItem> r25, boolean r26) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1886
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advconfigdata.DispatcherData.AdvDataKeeper.w(org.json.JSONObject, java.lang.String, java.util.List, boolean):void");
    }

    private void x(JSONObject jSONObject, String str, List<AdvItem> list, boolean z) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("areaList");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            if (jSONObject2.getString(TapjoyConstants.TJC_GUID).equals(str)) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("advList");
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                    long currentTimeMillisInLocal = AdvTimeUtils.currentTimeMillisInLocal() / 1000;
                    if (currentTimeMillisInLocal <= jSONObject3.optLong("expireTime", LocationRequestCompat.PASSIVE_INTERVAL) && (!z || currentTimeMillisInLocal <= jSONObject3.optLong("activeTime", LocationRequestCompat.PASSIVE_INTERVAL))) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("advData");
                        if ("apiLink".equals(jSONObject4.optString("clickType", "urlLink"))) {
                            String optString = jSONObject4.optString("clickUrl", null);
                            try {
                                if (!TextUtils.isEmpty(optString)) {
                                    AdvItem o = o("callApi://" + AdvConfigManager.getInstance().GetJumpKey() + "/adv?link=" + URLEncoder.encode(optString, "utf-8"), str, jSONObject4.optInt("nonWifiPicPreload", 0));
                                    if (o != null) {
                                        list.add(o);
                                    }
                                }
                            } catch (UnsupportedEncodingException unused) {
                            }
                        } else {
                            ArrayList<ImageData> u = u(jSONObject4);
                            ArrayList<ImageData> t = t(jSONObject4);
                            String str2 = v(str, jSONObject4).finalImageUrl;
                            String z2 = z(jSONObject4);
                            int optInt = jSONObject4.optInt("nonWifiPicPreload", 0);
                            if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(z2)) {
                                AdvItem advItem = new AdvItem();
                                advItem.nonWifiPicPreload = optInt == 1;
                                advItem.guid = str;
                                advItem.mImageList = u;
                                advItem.mIconList = t;
                                advItem.imageUrl = str2;
                                advItem.mVideoUrl = z2;
                                if (t != null && t.size() > 0) {
                                    advItem.iconUrl = t.get(0).originImageUrl;
                                }
                                list.add(advItem);
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<VideoData> y(JSONObject jSONObject) throws JSONException {
        ArrayList<VideoData> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("videoData");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                VideoData videoData = new VideoData();
                videoData.videoUrl = jSONObject2.optString("videoUrl");
                videoData.height = jSONObject2.optInt("height");
                videoData.width = jSONObject2.optInt("width");
                videoData.rotate = jSONObject2.optInt("rotate");
                arrayList.add(videoData);
            }
        }
        return arrayList;
    }

    private String z(JSONObject jSONObject) throws JSONException {
        int optInt;
        float round;
        JSONArray optJSONArray = jSONObject.optJSONArray("videoData");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return "";
        }
        float f2 = (this.f9018h * 1.0f) / this.f9017g;
        float f3 = Float.MAX_VALUE;
        JSONObject jSONObject2 = null;
        int i2 = 0;
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject jSONObject3 = optJSONArray.getJSONObject(i3);
            try {
                int optInt2 = jSONObject3.optInt("height");
                optInt = jSONObject3.optInt("width");
                round = Math.round(Math.abs(((optInt2 * 1.0f) / optInt) - f2) * 1000.0f) / 1000.0f;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (round < f3) {
                jSONObject2 = jSONObject3;
                f3 = round;
            } else {
                if (round == f3 && jSONObject2 != null) {
                    int abs = Math.abs(i2 - this.f9017g);
                    int abs2 = Math.abs(optInt - this.f9017g);
                    if (abs > abs2) {
                        jSONObject2 = jSONObject3;
                    } else if (abs == abs2 && optInt > i2) {
                        jSONObject2 = jSONObject3;
                    }
                }
            }
            i2 = optInt;
        }
        return jSONObject2.optString("videoUrl", "");
    }

    public synchronized void A() {
        JSONObject jSONObject;
        JSONObject k2 = k();
        if (k2 == null) {
            return;
        }
        try {
            jSONObject = k2.getJSONObject("data");
        } catch (Exception unused) {
        }
        if (jSONObject.optInt("version", 0) == 0) {
            return;
        }
        jSONObject.put("version", 0);
        AdvFileUtils.saveFile(k2.toString().getBytes("utf-8"), this.f9014d.getFilesDir().getAbsolutePath() + "/adv/adv_data.json");
        this.a.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean B(byte[] bArr) {
        try {
            AdvFileUtils.saveFile(bArr, this.f9014d.getFilesDir().getAbsolutePath() + "/adv/adv_data.json");
            this.a.set(true);
        } catch (IOException unused) {
            return false;
        }
        return true;
    }

    public String a(String str, String str2) {
        JSONObject k2 = k();
        if (k2 == null) {
            return str2;
        }
        try {
            JSONObject jSONObject = k2.getJSONObject("data");
            JSONObject jSONObject2 = jSONObject.has(TJAdUnitConstants.String.ATTACH) ? jSONObject.getJSONObject(TJAdUnitConstants.String.ATTACH) : null;
            if (jSONObject2 == null) {
                return str2;
            }
            String optString = jSONObject2.optString(str);
            return TextUtils.isEmpty(optString) ? str2 : optString;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public boolean b(String str, Boolean bool) {
        JSONObject k2 = k();
        if (k2 == null) {
            return bool.booleanValue();
        }
        try {
            JSONObject jSONObject = k2.getJSONObject("data");
            JSONObject jSONObject2 = jSONObject.has(TJAdUnitConstants.String.ATTACH) ? jSONObject.getJSONObject(TJAdUnitConstants.String.ATTACH) : null;
            if (jSONObject2 == null) {
                return bool.booleanValue();
            }
            return jSONObject2.getBoolean(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return bool.booleanValue();
        }
    }

    public String c(String str) {
        JSONObject k2 = k();
        if (k2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = k2.getJSONObject("data");
            JSONObject jSONObject2 = jSONObject.has(TJAdUnitConstants.String.ATTACH) ? jSONObject.getJSONObject(TJAdUnitConstants.String.ATTACH) : null;
            if (jSONObject2 == null) {
                return null;
            }
            return jSONObject2.optString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public int d(String str, int i2) {
        JSONObject k2 = k();
        if (k2 == null) {
            return i2;
        }
        try {
            JSONObject jSONObject = k2.getJSONObject("data");
            JSONObject jSONObject2 = jSONObject.has(TJAdUnitConstants.String.ATTACH) ? jSONObject.getJSONObject(TJAdUnitConstants.String.ATTACH) : null;
            return jSONObject2 == null ? i2 : jSONObject2.optInt(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return i2;
        }
    }

    public boolean e() {
        JSONObject jSONObject;
        JSONObject k2 = k();
        if (k2 == null) {
            return false;
        }
        try {
            jSONObject = k2.getJSONObject("data");
        } catch (Exception unused) {
        }
        if (jSONObject == null) {
            return false;
        }
        String string = jSONObject.has("grayScheme") ? jSONObject.getString("grayScheme") : null;
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return "B".equals(string);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void f() {
        try {
            new File(this.f9014d.getFilesDir().getAbsolutePath() + "/adv/adv_data.json").delete();
            this.a.set(true);
        } catch (Exception unused) {
        }
    }

    public boolean g(String str) {
        return h(str, false);
    }

    public boolean h(String str, boolean z) {
        JSONObject k2 = k();
        if (k2 == null) {
            return z;
        }
        try {
            return k2.getJSONObject("data").optBoolean(str, z);
        } catch (Exception unused) {
            return false;
        }
    }

    public int i(String str, int i2) {
        JSONObject k2 = k();
        if (k2 == null) {
            return i2;
        }
        try {
            return k2.getJSONObject("data").optInt(str, i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    synchronized String j() {
        String str;
        if (this.a.compareAndSet(true, false)) {
            String str2 = this.f9014d.getFilesDir().getAbsolutePath() + "/adv/adv_data.json";
            try {
                str = new String(AdvFileUtils.getFileData(str2));
            } catch (Exception unused) {
                str = "";
                if (new File(str2).exists()) {
                    AdvConfigManager.getInstance().getAdvConfig().getLifecycleListener().onReadAdvCacheFileError();
                }
            }
            this.b = str;
            if (str.isEmpty()) {
                this.c = null;
            } else {
                try {
                    this.c = new JSONObject(this.b);
                } catch (JSONException unused2) {
                    this.c = null;
                }
            }
        }
        return this.b;
    }

    public JSONObject k() {
        j();
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long l() {
        long defaultUpdateInterval = AdvConfigManager.getInstance().getAdvConfig().getDefaultUpdateInterval();
        JSONObject k2 = k();
        if (k2 == null) {
            return AdvTimeUtils.clamp(defaultUpdateInterval, 300L, 7200L);
        }
        try {
            defaultUpdateInterval = k2.getJSONObject("data").optLong(TJAdUnitConstants.String.INTERVAL, defaultUpdateInterval);
            return AdvTimeUtils.clamp(defaultUpdateInterval, 300L, 7200L);
        } catch (Exception unused) {
            return defaultUpdateInterval;
        }
    }

    public int m() {
        JSONObject k2 = k();
        if (k2 == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = k2.getJSONObject("data");
            String locale = Locale.getDefault().toString();
            String optString = jSONObject.optString(IjkMediaMeta.IJKM_KEY_LANGUAGE);
            if (optString == null || !optString.equalsIgnoreCase(locale)) {
                return 0;
            }
            return jSONObject.optInt("version", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public List<AdvItem> n(String str, boolean z) {
        JSONObject k2 = k();
        if (k2 == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            w(k2, str, arrayList, z);
        } catch (Exception e2) {
            new us.pinguo.advconfigdata.DispatcherData.a(e2.getMessage()).execute();
            AdvConfigManager.getInstance().getAdvConfig().getLifecycleListener().onParseAdvError();
        }
        if (arrayList.isEmpty()) {
            return new ArrayList();
        }
        Collections.sort(arrayList, this.f9015e);
        return arrayList;
    }

    public List<AdvItem> p(List<String> list, boolean z) {
        JSONObject k2 = k();
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0 && k2 != null) {
            for (String str : list) {
                try {
                    x(k2, str, arrayList, z);
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    public List<AdvRepairItem> q() {
        byte[] decrypt3Des;
        JSONObject k2 = k();
        if (k2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = k2.getJSONObject("data");
            if (jSONObject == null) {
                return null;
            }
            String string = jSONObject.getString("task");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            byte[] decode = Base64.decode(string.getBytes("UTF-8"), 0);
            byte[] PGMD5 = AdvMD5.PGMD5(AdvSystemUtils.getDeviceID(this.f9014d));
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < PGMD5.length; i2++) {
                stringBuffer.append(String.format("%02x", Byte.valueOf(PGMD5[i2])));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (TextUtils.isEmpty(stringBuffer2) || stringBuffer2.length() < 8 || (decrypt3Des = AdvUtils.decrypt3Des(decode, stringBuffer2.substring(stringBuffer2.length() - 8, stringBuffer2.length()))) == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(new String(decrypt3Des, "UTF-8"));
            e eVar = new e();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add((AdvRepairItem) eVar.j(jSONArray.getJSONObject(i3).toString(), AdvRepairItem.class));
            }
            return arrayList;
        } catch (Exception unused) {
        }
        return null;
    }

    public boolean r(List<String> list, String str) {
        boolean z;
        JSONObject k2 = k();
        if (k2 == null || str == null || str.isEmpty() || list == null) {
            return false;
        }
        if (!list.isEmpty()) {
            try {
                JSONArray jSONArray = k2.getJSONObject("data").getJSONArray("areaList");
                z = false;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (list.contains(jSONObject.getString(TapjoyConstants.TJC_GUID)) || z) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("advList");
                        int i3 = 0;
                        while (true) {
                            if (i3 >= jSONArray2.length()) {
                                break;
                            } else if (str.equals(jSONArray2.getJSONObject(i3).getString("advId"))) {
                                z = true;
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return z;
    }

    /* loaded from: classes3.dex */
    public static class ImageData implements Parcelable {
        public static final Parcelable.Creator<ImageData> CREATOR = new a();
        public String finalImageUrl;
        public int height;
        public String originImageUrl;
        public List<String> qualityList;
        public String ratio;
        public int width;
        public List<String> zoomList;

        /* loaded from: classes3.dex */
        class a implements Parcelable.Creator<ImageData> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ImageData createFromParcel(Parcel parcel) {
                return new ImageData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ImageData[] newArray(int i2) {
                return new ImageData[i2];
            }
        }

        public ImageData() {
            this.zoomList = new ArrayList();
            this.qualityList = new ArrayList();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.finalImageUrl);
            parcel.writeString(this.originImageUrl);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            parcel.writeString(this.ratio);
            parcel.writeStringList(this.zoomList);
            parcel.writeStringList(this.qualityList);
        }

        protected ImageData(Parcel parcel) {
            this.zoomList = new ArrayList();
            this.qualityList = new ArrayList();
            this.finalImageUrl = parcel.readString();
            this.originImageUrl = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
            this.ratio = parcel.readString();
            this.zoomList = parcel.createStringArrayList();
            this.qualityList = parcel.createStringArrayList();
        }
    }
}
