package vStudio.Android.Camera360;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray a = new SparseIntArray(0);

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    private static class b {
        static final HashMap<String, Integer> a = new HashMap<>(0);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new us.pinguo.camera2020.DataBinderMapperImpl());
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
        if (a.get(i2) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
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
