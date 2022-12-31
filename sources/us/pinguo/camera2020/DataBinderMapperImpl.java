package us.pinguo.camera2020;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.camera2020.f.f;
import us.pinguo.camera2020.f.h;
/* loaded from: classes.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray a;

    /* loaded from: classes.dex */
    private static class a {
        static final SparseArray<String> a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(21);
            a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adjustBeautyType");
            sparseArray.put(2, "adjustStyleMakeupType");
            sparseArray.put(3, "beautyData");
            sparseArray.put(4, "canRedo");
            sparseArray.put(5, "canUndo");
            sparseArray.put(6, "checked");
            sparseArray.put(7, "currentSelectedBeautyData");
            sparseArray.put(8, "frameItem");
            sparseArray.put(9, "isAdjustBarDark");
            sparseArray.put(10, "isBodyDark");
            sparseArray.put(11, "isClearSelected");
            sparseArray.put(12, "isDragging");
            sparseArray.put(13, "isInEdit");
            sparseArray.put(14, "isResetEnable");
            sparseArray.put(15, "isSelected");
            sparseArray.put(16, "makeupMaterial");
            sparseArray.put(17, "material");
            sparseArray.put(18, "paintMaterial");
            sparseArray.put(19, "position");
            sparseArray.put(20, "styleMakeup");
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        static final HashMap<String, Integer> a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(3);
            a = hashMap;
            hashMap.put("layout/item_makeup_0", Integer.valueOf(R.layout.item_makeup));
            hashMap.put("layout/layout_cell_frame_item_0", Integer.valueOf(R.layout.layout_cell_frame_item));
            hashMap.put("layout/panel_makeup_selector_0", Integer.valueOf(R.layout.panel_makeup_selector));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        a = sparseIntArray;
        sparseIntArray.put(R.layout.item_makeup, 1);
        sparseIntArray.put(R.layout.layout_cell_frame_item, 2);
        sparseIntArray.put(R.layout.panel_makeup_selector, 3);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new us.pinguo.commonui.DataBinderMapperImpl());
        arrayList.add(new us.pinguo.edit2020.DataBinderMapperImpl());
        arrayList.add(new us.pinguo.repository2020.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.a.get(i2);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = a.get(i2);
        if (i3 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                if (i3 == 1) {
                    if ("layout/item_makeup_0".equals(tag)) {
                        return new us.pinguo.camera2020.f.d(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_makeup is invalid. Received: " + tag);
                } else if (i3 == 2) {
                    if ("layout/layout_cell_frame_item_0".equals(tag)) {
                        return new f(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_cell_frame_item is invalid. Received: " + tag);
                } else if (i3 != 3) {
                    return null;
                } else {
                    if ("layout/panel_makeup_selector_0".equals(tag)) {
                        return new h(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for panel_makeup_selector is invalid. Received: " + tag);
                }
            }
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
