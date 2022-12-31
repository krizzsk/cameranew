package us.pinguo.camera360.shop.data.install.table;

import android.text.TextUtils;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.install.o;
import us.pinguo.foundation.d;
import us.pinguo.foundation.utils.a0;
import us.pinguo.util.k;
/* loaded from: classes3.dex */
public abstract class BaseEffectInstaller<T> implements o<T> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean b(File file) {
        return file.isDirectory() && isEffectVersionDir(file.getName());
    }

    private int getVersionByDirName(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Matcher matcher = Pattern.compile("[1-9][0-9]*").matcher(str);
        if (matcher.find()) {
            return Integer.valueOf(matcher.group()).intValue();
        }
        return -1;
    }

    private boolean isEffectVersionDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("\\bv[0-9]+\\b").matcher(str).matches();
    }

    private String modifyPremulti(String str) {
        return str.replaceAll("isPremultiplied=1", "isPremultiplied=0");
    }

    public T getEffectTableByIndexJson(int i2, String str, String str2, File file, String str3) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        JSONObject jSONObject;
        if (file.exists()) {
            T t = (T) getGenericClass().newInstance();
            a0.e(t, "packageId", str3);
            try {
                a0.e(t, "versionDir", str);
                a0.e(t, "version", Integer.valueOf(i2));
                JSONObject jSONObject2 = new JSONObject(k.d(file));
                a0.e(t, TapjoyAuctionFlags.AUCTION_ID, str2);
                if (jSONObject2.has("key")) {
                    a0.e(t, "key", jSONObject2.getString("key"));
                } else {
                    a0.e(t, "key", str2);
                }
                if (jSONObject2.has("isSupportRealRender")) {
                    try {
                        a0.e(t, "supportPreview", Integer.valueOf(jSONObject2.getInt("isSupportRealRender")));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (jSONObject2.has("skinParam")) {
                    a0.e(t, "skinParam", jSONObject2.getString("skinParam"));
                }
                a0.e(t, SharePluginInfo.ISSUE_SUB_TYPE, Effect.Type.Filter.name());
                if (jSONObject2.has("onlineParam")) {
                    a0.e(t, "onlineParam", jSONObject2.getString("onlineParam"));
                } else {
                    if (jSONObject2.has("params")) {
                        a0.e(t, "paramStr", jSONObject2.getJSONObject("params").toString());
                    }
                    if (jSONObject2.has("android_cmds")) {
                        jSONObject = jSONObject2.getJSONObject("android_cmds");
                    } else {
                        jSONObject = jSONObject2.has("cmds") ? jSONObject2.getJSONObject("cmds") : null;
                    }
                    if (jSONObject != null) {
                        a0.e(t, "gpuCmd", modifyPremulti(jSONObject.getJSONArray("makeCmd").getJSONObject(0).getString("cmd")));
                    }
                    if (jSONObject != null && jSONObject.has("preCmd")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("preCmd");
                        if (jSONArray.length() > 0) {
                            String string = jSONArray.getJSONObject(0).getString("cmd");
                            if (!TextUtils.isEmpty(string)) {
                                a0.e(t, "preCmd", modifyPremulti(string));
                            }
                        }
                    }
                    if (jSONObject2.has("textures")) {
                        a0.e(t, "textureStr", jSONObject2.getJSONObject("textures").toString());
                    }
                }
                return t;
            } catch (Exception e3) {
                if (!d.f10987f) {
                    e3.printStackTrace();
                    return null;
                }
                throw new RuntimeException(e3);
            }
        }
        return null;
    }

    protected abstract Class getGenericClass() throws ClassNotFoundException;

    protected abstract void insert(List<T> list);

    @Override // us.pinguo.camera360.shop.data.install.o
    public boolean install(File file, String str, String str2, int i2, FilterType filterType, int i3) {
        try {
            List<T> arrayList = new ArrayList<>(2);
            String name = file.getName();
            T effectTableByIndexJson = getEffectTableByIndexJson(0, "", name, new File(file, "index.json"), str);
            if (effectTableByIndexJson != null) {
                arrayList.add(effectTableByIndexJson);
            }
            File[] listFiles = file.listFiles(new FileFilter() { // from class: us.pinguo.camera360.shop.data.install.table.a
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return BaseEffectInstaller.this.b(file2);
                }
            });
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    T effectTableByIndexJson2 = getEffectTableByIndexJson(getVersionByDirName(file2.getName()), file2.getName(), name, new File(file2, "index.json"), str);
                    if (effectTableByIndexJson2 != null) {
                        arrayList.add(effectTableByIndexJson2);
                    }
                }
            }
            if (d.f10987f && arrayList.isEmpty()) {
                return false;
            }
            insert(arrayList);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean update(File file, String str, String str2, int i2) {
        return false;
    }
}
