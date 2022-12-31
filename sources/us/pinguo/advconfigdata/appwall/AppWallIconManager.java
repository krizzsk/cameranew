package us.pinguo.advconfigdata.appwall;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.AdvLoadDataType;
import us.pinguo.advconfigdata.DispatcherData.AdvDataKeeper;
import us.pinguo.advconfigdata.Utils.AdvBitmapUtils;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.advertisement.R;
/* loaded from: classes3.dex */
public class AppWallIconManager {
    private static final int[] DRAWABLE_IDS = {R.drawable.appwall_new_iocn0, R.drawable.appwall_new_iocn1, R.drawable.appwall_new_iocn2, R.drawable.appwall_new_iocn3, R.drawable.appwall_new_iocn4, R.drawable.appwall_new_iocn5, R.drawable.appwall_new_iocn6, R.drawable.appwall_new_iocn7};
    private static final int PIC_LEN = 96;
    private String mAppWallGuId;
    private SparseArray<Bitmap> mCache;
    private Context mContext;
    private int mPicLength;
    private int mPreBitmapIndex;
    private Random mRandom;
    private SparseArray<RoundedBitmapDrawable> mRoundDrawableCache;
    private SparseArray<String> mSavedPicPathMap;

    public AppWallIconManager(Context context, String str) {
        int[] iArr = DRAWABLE_IDS;
        this.mSavedPicPathMap = new SparseArray<>(iArr.length);
        this.mCache = new SparseArray<>(iArr.length);
        this.mRoundDrawableCache = new SparseArray<>(iArr.length);
        this.mPreBitmapIndex = -1;
        this.mRandom = null;
        this.mPicLength = 8;
        this.mContext = context;
        this.mAppWallGuId = str;
        loadAppwallIcons();
        this.mRandom = new Random();
    }

    private void cacheIcons() {
        for (int i2 = 0; i2 < this.mSavedPicPathMap.size(); i2++) {
            String downFilePath = AdvConfigManager.getInstance().getDownFilePath(this.mSavedPicPathMap.get(i2));
            if (!TextUtils.isEmpty(downFilePath) && !new File(downFilePath).exists()) {
                AdvConfigManager.getInstance().getImageDownloader().download(this.mSavedPicPathMap.get(i2), downFilePath, null);
            }
        }
    }

    private Bitmap getBitmap(int i2) {
        Bitmap loadDefault;
        if (i2 < 0 || i2 >= this.mPicLength) {
            return null;
        }
        if (this.mCache.get(i2) != null) {
            return this.mCache.get(i2);
        }
        String str = this.mSavedPicPathMap.get(i2);
        if (str != null) {
            loadDefault = loadServerScalePic(str, 96, false);
            if (loadDefault == null) {
                loadDefault = loadDefault(i2);
            }
        } else {
            loadDefault = loadDefault(i2);
        }
        if (loadDefault != null) {
            this.mCache.put(i2, loadDefault);
        }
        return loadDefault;
    }

    private int getNextIndex() {
        int nextInt = this.mRandom.nextInt(this.mPicLength);
        if (nextInt == this.mPreBitmapIndex) {
            nextInt = (nextInt + 1) % this.mPicLength;
        }
        this.mPreBitmapIndex = nextInt;
        return nextInt;
    }

    private void loadAppwallIcons() {
        List<AdvItem> items = AdvConfigManager.getInstance().getItems(this.mAppWallGuId, AdvLoadDataType.NETWORK_AND_DEFAULT);
        if (items == null || items.size() == 0) {
            return;
        }
        ArrayList<AdvDataKeeper.ImageData> arrayList = items.get(0).mImageList;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            AdvDataKeeper.ImageData imageData = arrayList.get(i3);
            if (imageData != null) {
                String str = imageData.originImageUrl;
                if (!TextUtils.isEmpty(str)) {
                    this.mSavedPicPathMap.put(i2, str);
                    i2++;
                }
            }
        }
        if (this.mSavedPicPathMap.size() != 0) {
            cacheIcons();
            this.mPicLength = this.mSavedPicPathMap.size();
        }
    }

    @NonNull
    private Bitmap loadDefault(int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable drawable = this.mContext.getResources().getDrawable(DRAWABLE_IDS[i2]);
        drawable.setBounds(0, 0, 96, 96);
        drawable.draw(canvas);
        return createBitmap;
    }

    private Bitmap loadServerScalePic(String str, int i2, boolean z) {
        String downFilePath = AdvConfigManager.getInstance().getDownFilePath(str);
        if (!TextUtils.isEmpty(downFilePath) && new File(downFilePath).exists()) {
            return AdvBitmapUtils.scalePicture(downFilePath, i2, z);
        }
        return null;
    }

    public String getCurImageURl() {
        int size = this.mSavedPicPathMap.size();
        int i2 = this.mPreBitmapIndex;
        if (size > i2) {
            return this.mSavedPicPathMap.get(i2);
        }
        return "appwall_icon_" + String.valueOf(this.mPreBitmapIndex);
    }

    public Bitmap getRandomBitmap() {
        return getBitmap(getNextIndex());
    }

    public RoundedBitmapDrawable getRandomRoundDrawable(Resources resources) {
        int nextIndex = getNextIndex();
        if (this.mRoundDrawableCache.get(nextIndex) == null) {
            RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(resources, getBitmap(nextIndex));
            this.mRoundDrawableCache.put(nextIndex, create);
            return create;
        }
        return this.mRoundDrawableCache.get(nextIndex);
    }

    public int getSize() {
        return this.mPicLength;
    }
}
