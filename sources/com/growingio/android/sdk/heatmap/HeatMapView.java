package com.growingio.android.sdk.heatmap;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.models.HeatMapData;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.view.FloatViewContainer;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class HeatMapView extends FloatViewContainer {
    private final int CLICK_OFFSET_AREA;
    private final int DRAW_DURATION;
    private final int GRADIENT_BITMAP_CENTER;
    private final int GRADIENT_BITMAP_RADIUS;
    private final int GRADIENT_BITMAP_SIZE;
    private final int HEAT_MAP_NODE_IMAGE_MAX_ALPHA;
    private final int PALETTE_PIXEL_LENGTH;
    private Context context;
    private Runnable createBitmapRunnable;
    private ArrayList<HeatMapNode> drawHeatMapNodeList;
    private ArrayList<View> drawHeatMapNodeViewList;
    private Bitmap gradientBitmap;
    private HeatMapData[] heatMapDataArray;
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Bitmap> heatMapNodeImageMap;
    private ArrayList<HeatMapNode> heatMapNodeList;
    private int maxClickCount;
    private int[] paletteIntegerArray;
    private Runnable refreshHeatMapNodeRunnable;

    @TargetApi(11)
    public HeatMapView(Context context) {
        super(context);
        this.CLICK_OFFSET_AREA = 100;
        this.GRADIENT_BITMAP_SIZE = 150;
        this.GRADIENT_BITMAP_CENTER = 75;
        this.GRADIENT_BITMAP_RADIUS = 75;
        this.PALETTE_PIXEL_LENGTH = 256;
        this.HEAT_MAP_NODE_IMAGE_MAX_ALPHA = 200;
        this.DRAW_DURATION = 15;
        this.heatMapNodeList = new ArrayList<>();
        this.drawHeatMapNodeList = new ArrayList<>();
        this.heatMapNodeImageMap = new HashMap<>();
        this.drawHeatMapNodeViewList = new ArrayList<>();
        this.createBitmapRunnable = new Runnable() { // from class: com.growingio.android.sdk.heatmap.HeatMapView.1
            @Override // java.lang.Runnable
            public void run() {
                HeatMapView.this.createPalette();
                HeatMapView.this.createGradientBitmap();
                for (int i2 = 0; i2 <= 100; i2++) {
                    HeatMapView.this.generateHeatMapNodeImage(i2);
                }
            }
        };
        this.refreshHeatMapNodeRunnable = new Runnable() { // from class: com.growingio.android.sdk.heatmap.HeatMapView.2
            @Override // java.lang.Runnable
            public void run() {
                HeatMapView.this.refreshHeatMap();
                ThreadUtils.postOnUiThreadDelayed(HeatMapView.this.refreshHeatMapNodeRunnable, 15L);
            }
        };
        init(context);
    }

    private void addHeatMapNodeView(View view) {
        this.drawHeatMapNodeViewList.add(view);
        addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createGradientBitmap() {
        RadialGradient radialGradient = new RadialGradient(75.0f, 75.0f, 75.0f, new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0}, new float[]{0.0f, 0.15f, 1.0f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(radialGradient);
        RectF rectF = new RectF(0.0f, 0.0f, 150.0f, 150.0f);
        this.gradientBitmap = Bitmap.createBitmap(150, 150, Bitmap.Config.ARGB_8888);
        new Canvas(this.gradientBitmap).drawOval(rectF, paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createPalette() {
        Bitmap createBitmap = Bitmap.createBitmap(256, 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, 0.0f, 256.0f, 1.0f, new int[]{-16776961, -16711936, InputDeviceCompat.SOURCE_ANY, SupportMenu.CATEGORY_MASK}, new float[]{0.25f, 0.55f, 0.85f, 1.0f}, Shader.TileMode.CLAMP));
        canvas.drawLine(0.0f, 0.0f, 256.0f, 1.0f, paint);
        int[] iArr = new int[256];
        this.paletteIntegerArray = iArr;
        createBitmap.getPixels(iArr, 0, 256, 0, 0, 256, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateHeatMapNodeImage(int i2) {
        float f2 = ((i2 / 100.0f) * 0.6f) + 0.4f;
        if (this.heatMapNodeImageMap.containsKey(Integer.valueOf(i2))) {
            return;
        }
        this.heatMapNodeImageMap.put(Integer.valueOf(i2), palette(Bitmap.createBitmap(this.gradientBitmap), f2));
    }

    private int getClickOffset(int i2) {
        int i3 = this.maxClickCount;
        if (i3 == 0) {
            return 50;
        }
        return (i2 * 100) / i3;
    }

    private Bitmap getHeatNodeBitmap(HeatMapNode heatMapNode) {
        return this.heatMapNodeImageMap.get(Integer.valueOf(getClickOffset(heatMapNode.clickCount)));
    }

    private void init(Context context) {
        this.context = context;
        setBackgroundColor(855638016);
        new Thread(this.createBitmapRunnable).start();
        ThreadUtils.postOnUiThreadDelayed(this.refreshHeatMapNodeRunnable, 15L);
    }

    private Bitmap palette(Bitmap bitmap, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (int) (((iArr[i3] >> 24) & 255) * f2);
            int i5 = 200;
            if (i4 <= 200) {
                i5 = i4;
            }
            iArr[i3] = (this.paletteIntegerArray[i4] & ViewCompat.MEASURED_SIZE_MASK) | (i5 << 24);
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshHeatMap() {
        Bitmap heatNodeBitmap;
        this.drawHeatMapNodeList.clear();
        this.drawHeatMapNodeList.addAll(this.heatMapNodeList);
        int size = this.drawHeatMapNodeList.size();
        Object obj = new Object();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            HeatMapNode heatMapNode = this.drawHeatMapNodeList.get(i3);
            if (heatMapNode.heatMapNodeView == null && (heatNodeBitmap = getHeatNodeBitmap(heatMapNode)) != null) {
                heatMapNode.initHeatMapNodeView(this.context, heatNodeBitmap);
                addHeatMapNodeView(heatMapNode.heatMapNodeView);
            }
            if (heatMapNode.heatMapNodeView.getParent() == null) {
                addHeatMapNodeView(heatMapNode.heatMapNodeView);
            }
            if (heatMapNode.heatMapNodeView != null && heatMapNode.canDraw()) {
                heatMapNode.updatePosition(iArr);
                heatMapNode.heatMapNodeView.setTag(AbstractGrowingIO.GROWING_HEAT_MAP_KEY, obj);
            }
        }
        int size2 = this.drawHeatMapNodeViewList.size();
        while (i2 < size2) {
            View view = this.drawHeatMapNodeViewList.get(i2);
            if (view.getTag(AbstractGrowingIO.GROWING_HEAT_MAP_KEY) != obj) {
                removeHeatMapNodeView(view);
                i2--;
                size2--;
            }
            i2++;
        }
    }

    private void removeHeatMapNodeView(View view) {
        this.drawHeatMapNodeViewList.remove(view);
        removeView(view);
    }

    private void updateClickData() {
        this.maxClickCount = 0;
        int length = this.heatMapDataArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            for (HeatMapData.ItemBean itemBean : this.heatMapDataArray[i2].getItems()) {
                int cnt = itemBean.getCnt();
                if (cnt > this.maxClickCount) {
                    this.maxClickCount = cnt;
                }
            }
        }
    }

    public void clearData() {
        this.heatMapDataArray = new HeatMapData[0];
        this.heatMapNodeList.clear();
    }

    public void hide() {
        setVisibility(8);
    }

    public void show() {
        setVisibility(0);
    }

    public void updateData(HeatMapData[] heatMapDataArr) {
        this.heatMapDataArray = heatMapDataArr;
        updateClickData();
        if (heatMapDataArr.length == 0) {
            Toast.makeText(CoreInitialize.coreAppState().getForegroundActivity(), "当前页面尚无热图数据", 0).show();
        }
    }

    public void updateHeatMapNode(ArrayList<HeatMapNode> arrayList) {
        this.heatMapNodeList.clear();
        this.heatMapNodeList.addAll(arrayList);
    }
}
