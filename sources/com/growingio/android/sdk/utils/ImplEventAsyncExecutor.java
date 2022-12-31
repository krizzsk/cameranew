package com.growingio.android.sdk.utils;

import android.view.View;
import android.widget.ImageView;
import com.growingio.android.sdk.collection.ActionCalculator;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.eventcenter.bus.EventBus;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class ImplEventAsyncExecutor {
    public static final String TAG = "GIO.ImplEventAsyncExecutor";
    private static ImplEventAsyncExecutor implEventAsyncExecutor;
    private final Executor threadPool = Executors.newFixedThreadPool(8);

    private ImplEventAsyncExecutor() {
    }

    public static ImplEventAsyncExecutor getInstance() {
        if (implEventAsyncExecutor == null) {
            implEventAsyncExecutor = new ImplEventAsyncExecutor();
        }
        return implEventAsyncExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postSingleEvent(ActionEvent actionEvent, List<ViewNode> list) {
        try {
            LinkedList linkedList = new LinkedList();
            for (ViewNode viewNode : list) {
                View view = viewNode.mView;
                ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
                if (imageView != null) {
                    if (DHashcode.cacheHash.containsKey(Integer.valueOf(imageView.hashCode()))) {
                        viewNode.mImageViewDHashCode = DHashcode.cacheHash.get(Integer.valueOf(imageView.hashCode()));
                    } else {
                        String dHash = DHashcode.getDHash(imageView);
                        viewNode.mImageViewDHashCode = dHash;
                        DHashcode.cacheHash.put(Integer.valueOf(imageView.hashCode()), dHash);
                    }
                    LogUtil.i(TAG, "Dhashcode: " + viewNode.mImageViewDHashCode);
                    linkedList.add(ActionCalculator.genActionStruct(viewNode));
                }
            }
            if (linkedList.size() > 0) {
                actionEvent.elems.addAll(linkedList);
            }
            EventBus.getDefault().post(actionEvent);
            if (DHashcode.cacheHash.size() <= 100) {
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                EventBus.getDefault().post(actionEvent);
                if (DHashcode.cacheHash.size() > 100) {
                    DHashcode.cacheHash.clear();
                }
            }
        }
    }

    public void execute(final ActionEvent actionEvent, final List<ViewNode> list) {
        this.threadPool.execute(new Runnable() { // from class: com.growingio.android.sdk.utils.ImplEventAsyncExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                ImplEventAsyncExecutor.this.postSingleEvent(actionEvent, list);
            }
        });
    }
}
