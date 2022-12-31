package com.growingio.android.sdk.utils;

import android.view.View;
import android.widget.ImageView;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.ActionStruct;
import com.growingio.android.sdk.models.ViewNode;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class ClickEventAsyncExecutor {
    public static final String TAG = "GIO.ClickEventAsyncExecutor";
    private static ClickEventAsyncExecutor clickEventAsyncExecutor;
    private final Executor threadPool = Executors.newSingleThreadExecutor();

    private ClickEventAsyncExecutor() {
    }

    public static ClickEventAsyncExecutor getInstance() {
        if (clickEventAsyncExecutor == null) {
            clickEventAsyncExecutor = new ClickEventAsyncExecutor();
        }
        return clickEventAsyncExecutor;
    }

    private boolean isEqual(ActionStruct actionStruct, ViewNode viewNode) {
        LinkedString linkedString;
        return actionStruct != null && (linkedString = actionStruct.xpath) != null && linkedString.equals(viewNode.mParentXPath) && ObjectUtils.equals(actionStruct.obj, viewNode.mInheritableGrowingInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postSingleEvent(WeakReference<View> weakReference, ViewNode viewNode, ActionEvent actionEvent) {
        ImageView imageView;
        int size;
        try {
            imageView = weakReference.get() instanceof ImageView ? (ImageView) weakReference.get() : null;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                ViewHelper.persistClickEvent(actionEvent, viewNode);
                if (DHashcode.cacheHash.size() <= 100) {
                    return;
                }
            } finally {
                ViewHelper.persistClickEvent(actionEvent, viewNode);
                if (DHashcode.cacheHash.size() > 100) {
                    DHashcode.cacheHash.clear();
                }
            }
        }
        if (imageView == null) {
            if (size > r1) {
                return;
            }
            return;
        }
        if (DHashcode.cacheHash.containsKey(Integer.valueOf(imageView.hashCode()))) {
            viewNode.mImageViewDHashCode = DHashcode.cacheHash.get(Integer.valueOf(imageView.hashCode()));
        } else {
            String dHash = DHashcode.getDHash(imageView);
            viewNode.mImageViewDHashCode = dHash;
            DHashcode.cacheHash.put(Integer.valueOf(imageView.hashCode()), dHash);
        }
        LogUtil.i(TAG, "Dhashcode: " + viewNode.mImageViewDHashCode);
        if (actionEvent == null) {
            ViewHelper.persistClickEvent(actionEvent, viewNode);
            if (DHashcode.cacheHash.size() > 100) {
                DHashcode.cacheHash.clear();
                return;
            }
            return;
        }
        for (ActionStruct actionStruct : actionEvent.elems) {
            if (isEqual(actionStruct, viewNode)) {
                actionStruct.imgHashcode = viewNode.mImageViewDHashCode;
            }
        }
        ViewHelper.persistClickEvent(actionEvent, viewNode);
        if (DHashcode.cacheHash.size() <= 100) {
            return;
        }
        DHashcode.cacheHash.clear();
    }

    public void execute(final WeakReference<View> weakReference, final ViewNode viewNode, final ActionEvent actionEvent) {
        if (weakReference.get() == null) {
            return;
        }
        this.threadPool.execute(new Runnable() { // from class: com.growingio.android.sdk.utils.ClickEventAsyncExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                ClickEventAsyncExecutor.this.postSingleEvent(weakReference, viewNode, actionEvent);
            }
        });
    }
}
