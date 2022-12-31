package cn.sharesdk.onekeyshare.themes.classic.land;

import android.content.Context;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PlatformPageAdapterLand extends PlatformPageAdapter {
    private static final int DESIGN_CELL_WIDTH_L = 160;
    private static final int DESIGN_LOGO_HEIGHT = 76;
    private static final int DESIGN_PADDING_TOP = 20;
    private static final int DESIGN_SCREEN_WIDTH_L = 1280;
    private static final int DESIGN_SEP_LINE_WIDTH = 1;

    public PlatformPageAdapterLand(PlatformPage platformPage, ArrayList<Object> arrayList) {
        super(platformPage, arrayList);
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    protected void calculateSize(Context context, ArrayList<Object> arrayList) {
        int screenWidth = ResHelper.getScreenWidth(context);
        float f2 = screenWidth / 1280.0f;
        int i2 = screenWidth / ((int) (160.0f * f2));
        this.lineSize = i2;
        int i3 = (int) (1.0f * f2);
        this.sepLineWidth = i3;
        if (i3 < 1) {
            i3 = 1;
        }
        this.sepLineWidth = i3;
        this.logoHeight = (int) (76.0f * f2);
        this.paddingTop = (int) (20.0f * f2);
        this.bottomHeight = (int) (f2 * 52.0f);
        int i4 = (screenWidth - (i3 * 3)) / (i2 - 1);
        this.cellHeight = i4;
        this.panelHeight = i4 + i3;
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    protected void collectCells(ArrayList<Object> arrayList) {
        int size = arrayList.size();
        int i2 = this.lineSize;
        if (size < i2) {
            int i3 = size / i2;
            if (size % i2 != 0) {
                i3++;
            }
            this.cells = (Object[][]) Array.newInstance(Object.class, 1, i3 * i2);
        } else {
            int i4 = size / i2;
            if (size % i2 != 0) {
                i4++;
            }
            this.cells = (Object[][]) Array.newInstance(Object.class, i4, i2);
        }
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = this.lineSize;
            int i7 = i5 / i6;
            this.cells[i7][i5 - (i6 * i7)] = arrayList.get(i5);
        }
    }
}
