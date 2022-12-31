package us.pinguo.camera360.shop.data.install;

import android.text.TextUtils;
import com.tapjoy.TapjoyAuctionFlags;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.foundation.utils.a0;
/* compiled from: BaseItemInstaller.java */
/* loaded from: classes3.dex */
public abstract class f<T> implements o<T> {
    private boolean c(File file, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONArray jSONArray;
        if (jSONObject.has("filterInner") && (jSONObject2 = jSONObject.getJSONObject("filterInner")) != null) {
            File file2 = new File(file, jSONObject2.getString("folder"));
            if (file2.exists() && (jSONArray = jSONObject2.getJSONArray("filters")) != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    File file3 = new File(file2, jSONArray.getString(i2));
                    if (!file3.exists() || !new File(file3, "index.json").exists()) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    protected abstract Class a() throws ClassNotFoundException;

    public abstract void b(List<T> list);

    @Override // us.pinguo.camera360.shop.data.install.o
    public boolean install(File file, String str, String str2, int i2, FilterType filterType, int i3) {
        try {
            Object newInstance = a().newInstance();
            a0.e(newInstance, "enableGesture", Integer.valueOf(i3));
            a0.e(newInstance, "packageId", str);
            a0.e(newInstance, "packageMd5", str2);
            a0.e(newInstance, "sortInPackage", Integer.valueOf(i2));
            String d2 = us.pinguo.util.k.d(new File(file, "display.json"));
            us.pinguo.common.log.a.m("ItemInstaller", "i18n:" + d2, new Object[0]);
            a0.e(newInstance, "namejson", new JSONObject(d2).getJSONObject("i18n").toString());
            String str3 = str2 + '/' + file.getName() + "/icon.png";
            if (!new File(new File(file, "icon.png").getAbsolutePath()).exists()) {
                str3 = str2 + '/' + file.getName() + "/icon.jpg";
                if (!new File(new File(file, "icon.jpg").getAbsolutePath()).exists()) {
                    str3 = str2 + '/' + file.getName() + "/icon.jpeg";
                    if (!new File(new File(file, "icon.jpeg").getAbsolutePath()).exists()) {
                        return false;
                    }
                }
            }
            a0.e(newInstance, "icon", str3);
            JSONObject jSONObject = new JSONObject(us.pinguo.util.k.d(new File(file, "index.json")));
            a0.e(newInstance, TapjoyAuctionFlags.AUCTION_ID, file.getName());
            String optString = jSONObject.optString("subt");
            if (TextUtils.equals(optString, FilterType.Sticker.getSubt()) && !c(file, jSONObject)) {
                us.pinguo.common.log.a.e("unity filter is not valid", new Object[0]);
                return false;
            }
            a0.e(newInstance, "type", optString);
            List<T> arrayList = new ArrayList<>();
            arrayList.add(newInstance);
            b(arrayList);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
