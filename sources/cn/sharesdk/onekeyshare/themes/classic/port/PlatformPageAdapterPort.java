package cn.sharesdk.onekeyshare.themes.classic.port;

import android.content.Context;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PlatformPageAdapterPort extends PlatformPageAdapter {
    private static final int DESIGN_LOGO_HEIGHT = 76;
    private static final int DESIGN_PADDING_TOP = 20;
    private static final int DESIGN_SCREEN_WIDTH_P = 720;
    private static final int DESIGN_SEP_LINE_WIDTH = 1;
    private static final int LINE_SIZE_P = 4;
    private static final int PAGE_SIZE_P = 12;

    public PlatformPageAdapterPort(PlatformPage platformPage, ArrayList<Object> arrayList) {
        super(platformPage, arrayList);
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    protected void calculateSize(Context context, ArrayList<Object> arrayList) {
        int screenWidth = ResHelper.getScreenWidth(context);
        this.lineSize = 4;
        float f2 = screenWidth / 720.0f;
        int i2 = (int) (1.0f * f2);
        this.sepLineWidth = i2;
        if (i2 < 1) {
            i2 = 1;
        }
        this.sepLineWidth = i2;
        this.logoHeight = (int) (76.0f * f2);
        this.paddingTop = (int) (20.0f * f2);
        this.bottomHeight = (int) (f2 * 52.0f);
        this.cellHeight = (screenWidth - (i2 * 3)) / 4;
        if (arrayList.size() <= this.lineSize) {
            this.panelHeight = this.cellHeight + this.sepLineWidth;
        } else if (arrayList.size() <= 12 - this.lineSize) {
            this.panelHeight = (this.cellHeight + this.sepLineWidth) * 2;
        } else {
            this.panelHeight = (this.cellHeight + this.sepLineWidth) * 3;
        }
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    protected void collectCells(ArrayList<Object> arrayList) {
        int size = arrayList.size();
        if (size < 12) {
            int i2 = this.lineSize;
            int i3 = size / i2;
            if (size % i2 != 0) {
                i3++;
            }
            this.cells = (Object[][]) Array.newInstance(Object.class, 1, i3 * i2);
        } else {
            int i4 = size / 12;
            if (size % 12 != 0) {
                i4++;
            }
            this.cells = (Object[][]) Array.newInstance(Object.class, i4, 12);
        }
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = i5 / 12;
            this.cells[i6][i5 - (i6 * 12)] = arrayList.get(i5);
        }
    }
}
