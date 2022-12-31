package us.pinguo.inspire.module.comment;

import android.view.View;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class CommentViewCache {
    private static final List<View> mCachedHeaders = new LinkedList();
    private static final List<View> mCachedFragments = new LinkedList();

    public static void cacheFragment(View view) {
    }

    public static void cacheHeader(View view) {
        if (view != null) {
            mCachedHeaders.add(view);
        }
    }

    public static void clear() {
        mCachedHeaders.clear();
        mCachedFragments.clear();
    }

    public static View getFragment() {
        return null;
    }

    public static View getHeader() {
        List<View> list = mCachedHeaders;
        View remove = list.size() > 0 ? list.remove(0) : null;
        if (remove == null || remove.getParent() == null) {
            return remove;
        }
        us.pinguo.common.log.a.e("缓存的header有parent，返回null", new Object[0]);
        return null;
    }
}
