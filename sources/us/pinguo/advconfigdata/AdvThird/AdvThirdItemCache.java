package us.pinguo.advconfigdata.AdvThird;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvUtils;
/* loaded from: classes3.dex */
public class AdvThirdItemCache {
    private HashMap<String, AdvThirdItem> mAdvThirdCacheMap = new HashMap<>();
    private Context mContext;

    public AdvThirdItemCache(Context context) {
        this.mContext = context;
    }

    private String getThirdAdvCachePath(String str) {
        String advDataCacheDir = AdvUtils.getAdvDataCacheDir(this.mContext);
        if (advDataCacheDir == null) {
            return null;
        }
        return advDataCacheDir + ("third_" + str);
    }

    public AdvThirdItem get(String str) {
        AdvThirdItem advThirdItem = this.mAdvThirdCacheMap.get(str);
        if (advThirdItem == null && AdvConfigManager.getInstance().getAdvConfig().getThirdAdvFileCachedDuration(str) > 0 && (advThirdItem = readThirdAdvCache(str)) != null) {
            this.mAdvThirdCacheMap.put(str, advThirdItem);
        }
        return advThirdItem;
    }

    public void put(String str, AdvThirdItem advThirdItem) {
        AdvThirdItem advThirdItem2 = this.mAdvThirdCacheMap.get(str);
        if (advThirdItem2 == null || !advThirdItem2.equals(advThirdItem)) {
            this.mAdvThirdCacheMap.put(str, advThirdItem);
            AdvLog.Log("guid:" + str + ",duration:" + AdvConfigManager.getInstance().getAdvConfig().getThirdAdvFileCachedDuration(str));
            if (AdvConfigManager.getInstance().getAdvConfig().getThirdAdvFileCachedDuration(str) > 0) {
                writeThirdAdvCache(str, advThirdItem);
                String downFilePath = AdvConfigManager.getInstance().getDownFilePath(advThirdItem.icon);
                if (TextUtils.isEmpty(downFilePath)) {
                    return;
                }
                AdvConfigManager.getInstance().getImageDownloader().download(advThirdItem.icon, downFilePath, null);
            }
        }
    }

    AdvThirdItem readThirdAdvCache(String str) {
        String thirdAdvCachePath;
        Throwable th;
        ObjectInputStream objectInputStream;
        if (str == null || (thirdAdvCachePath = getThirdAdvCachePath(str)) == null) {
            return null;
        }
        File file = new File(thirdAdvCachePath);
        if (!file.exists()) {
            return null;
        }
        if (System.currentTimeMillis() - file.lastModified() >= AdvConfigManager.getInstance().getAdvConfig().getThirdAdvFileCachedDuration(str) * 1000) {
            return null;
        }
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            try {
                try {
                    AdvThirdItem advThirdItem = (AdvThirdItem) objectInputStream.readObject();
                    AdvUtils.closeSilently(objectInputStream);
                    return advThirdItem;
                } catch (Exception e2) {
                    e = e2;
                    AdvLog.Log(e.getMessage());
                    AdvUtils.closeSilently(objectInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                AdvUtils.closeSilently(objectInputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            objectInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
            AdvUtils.closeSilently(objectInputStream);
            throw th;
        }
    }

    void writeThirdAdvCache(String str, AdvThirdItem advThirdItem) {
        if (str == null || advThirdItem == null) {
            return;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                String thirdAdvCachePath = getThirdAdvCachePath(str);
                if (thirdAdvCachePath == null) {
                    AdvUtils.closeSilently(null);
                    return;
                }
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(thirdAdvCachePath));
                try {
                    objectOutputStream2.writeObject(advThirdItem);
                    objectOutputStream2.flush();
                    AdvUtils.closeSilently(objectOutputStream2);
                } catch (Exception e2) {
                    e = e2;
                    objectOutputStream = objectOutputStream2;
                    AdvLog.Log(e.getMessage());
                    AdvUtils.closeSilently(objectOutputStream);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    AdvUtils.closeSilently(objectOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
