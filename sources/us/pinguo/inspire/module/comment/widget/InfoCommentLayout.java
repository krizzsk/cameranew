package us.pinguo.inspire.module.comment.widget;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pnikosis.materialishprogress.ProgressWheel;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.h0;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.x;
import kotlin.z.j;
import us.pinguo.inspire.R;
import us.pinguo.inspire.module.comment.IInfoCommentLayout;
import us.pinguo.inspire.module.comment.InspireComment;
import us.pinguo.inspire.module.comment.cell.CommentFooterCell;
import us.pinguo.inspire.module.comment.cell.CommentItemCell;
import us.pinguo.inspire.module.comment.cell.CommentNoMoreCell;
import us.pinguo.inspire.widget.MaxHeightLayoutManager;
/* compiled from: InfoCommentLayout.kt */
/* loaded from: classes9.dex */
public final class InfoCommentLayout extends FullScreenLayout implements View.OnLayoutChangeListener, IInfoCommentLayout {
    private final int PRELOAD_SIZE;
    public Map<Integer, View> _$_findViewCache;
    private us.pinguo.user.recycler.c adapter;
    public GestureDetector detector;
    private OnInfoCommentListener onInfoCommentListener;
    private final RecyclerView.OnScrollListener onScrollListener;
    private CommentRecyclerView recyclerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoCommentLayout(Context context) {
        super(context);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.PRELOAD_SIZE = 5;
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.comment.widget.InfoCommentLayout$onScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                s.h(recyclerView, "recyclerView");
                if (i3 == 0 && i2 == 0) {
                    return;
                }
                InfoCommentLayout.this.checkLoadMore();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkLoadMore() {
        if (this.recyclerView != null) {
            us.pinguo.user.recycler.c cVar = this.adapter;
            if (cVar != null && cVar.getItemCount() == 0) {
                return;
            }
            us.pinguo.user.recycler.c cVar2 = this.adapter;
            if (cVar2 != null && cVar2.isEmpty()) {
                return;
            }
            us.pinguo.user.recycler.c cVar3 = this.adapter;
            if (cVar3 != null && cVar3.isError()) {
                return;
            }
            us.pinguo.user.recycler.c cVar4 = this.adapter;
            if (cVar4 != null && cVar4.isLoadingShowing()) {
                return;
            }
            us.pinguo.user.recycler.c cVar5 = this.adapter;
            if (cVar5 != null && cVar5.isFootShowing()) {
                return;
            }
            us.pinguo.user.recycler.c cVar6 = this.adapter;
            if (cVar6 != null && cVar6.isNoMoreShowing()) {
                return;
            }
            CommentRecyclerView commentRecyclerView = this.recyclerView;
            s.e(commentRecyclerView);
            RecyclerView.LayoutManager layoutManager = commentRecyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            us.pinguo.user.recycler.c cVar7 = this.adapter;
            s.e(cVar7);
            if (findLastVisibleItemPosition >= (cVar7.getItemCount() - 1) - this.PRELOAD_SIZE) {
                us.pinguo.user.recycler.c cVar8 = this.adapter;
                if (cVar8 != null) {
                    cVar8.showFooter();
                }
                onLoadMore();
            }
        }
    }

    private final int getCommentCount() {
        kotlin.z.d h2;
        us.pinguo.user.recycler.c commentAdapter = getCommentAdapter();
        int i2 = 0;
        if (commentAdapter == null) {
            return 0;
        }
        h2 = j.h(0, commentAdapter.getItemCount());
        if (!(h2 instanceof Collection) || !((Collection) h2).isEmpty()) {
            Iterator<Integer> it = h2.iterator();
            while (it.hasNext()) {
                if ((commentAdapter.getItem(((h0) it).nextInt()) instanceof CommentItemCell) && (i2 = i2 + 1) < 0) {
                    kotlin.collections.s.m();
                    throw null;
                }
            }
        }
        return i2;
    }

    private final void onLoadMore() {
        OnInfoCommentListener onInfoCommentListener = this.onInfoCommentListener;
        if (onInfoCommentListener == null) {
            return;
        }
        onInfoCommentListener.onLoadMoreComment();
    }

    @Override // us.pinguo.inspire.module.comment.widget.FullScreenLayout
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // us.pinguo.inspire.module.comment.widget.FullScreenLayout
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // us.pinguo.inspire.module.comment.IInfoCommentLayout
    public void addComment(InspireComment comment, CommentItemCell.OnItemClickListener onItemClickListener) {
        s.h(comment, "comment");
        s.h(onItemClickListener, "onItemClickListener");
        us.pinguo.user.recycler.c cVar = this.adapter;
        if (cVar == null) {
            return;
        }
        CommentItemCell commentItemCell = new CommentItemCell(comment);
        commentItemCell.setOnItemClickListener(onItemClickListener);
        commentItemCell.setFirst(true);
        if (cVar.getCells().size() > 1 && (cVar.getItem(1) instanceof CommentItemCell)) {
            us.pinguo.widget.common.cell.recycler.b item = cVar.getItem(1);
            Objects.requireNonNull(item, "null cannot be cast to non-null type us.pinguo.inspire.module.comment.cell.CommentItemCell");
            CommentItemCell commentItemCell2 = (CommentItemCell) item;
            commentItemCell2.setFirst(false);
            commentItemCell2.updateData(commentItemCell2.getData());
        }
        us.pinguo.widget.common.cell.recycler.b item2 = cVar.getItem(0);
        if (item2 instanceof CommentItemCell) {
            ((CommentItemCell) item2).setFirst(false);
        }
        cVar.add(0, commentItemCell);
        checkShowEmpty();
        CommentRecyclerView commentRecyclerView = this.recyclerView;
        if (commentRecyclerView == null) {
            return;
        }
        commentRecyclerView.scrollToPosition(0);
    }

    @Override // us.pinguo.inspire.module.comment.IInfoCommentLayout
    public void addCommentList(List<? extends CommentItemCell> list) {
        us.pinguo.user.recycler.c cVar;
        s.h(list, "list");
        if (this.adapter != null && !list.isEmpty()) {
            us.pinguo.user.recycler.c cVar2 = this.adapter;
            s.e(cVar2);
            int itemCount = cVar2.getItemCount();
            us.pinguo.user.recycler.c cVar3 = this.adapter;
            s.e(cVar3);
            cVar3.beginChange();
            us.pinguo.user.recycler.c cVar4 = this.adapter;
            s.e(cVar4);
            if (cVar4.isFootShowing() && (cVar = this.adapter) != null) {
                cVar.hideFooter();
            }
            us.pinguo.user.recycler.c cVar5 = this.adapter;
            s.e(cVar5);
            cVar5.addAll(list);
            us.pinguo.user.recycler.c cVar6 = this.adapter;
            s.e(cVar6);
            cVar6.endChange(false);
            us.pinguo.user.recycler.c cVar7 = this.adapter;
            s.e(cVar7);
            cVar7.notifyItemChanged(itemCount - 1);
            us.pinguo.user.recycler.c cVar8 = this.adapter;
            s.e(cVar8);
            cVar8.notifyItemRangeInserted(itemCount, list.size() - 1);
            return;
        }
        us.pinguo.user.recycler.c cVar9 = this.adapter;
        if (cVar9 != null) {
            cVar9.hideFooter();
        }
        us.pinguo.user.recycler.c cVar10 = this.adapter;
        if (cVar10 == null) {
            return;
        }
        cVar10.showNoMoreContent();
    }

    public final void checkShowEmpty() {
        us.pinguo.user.recycler.c commentAdapter = getCommentAdapter();
        if (commentAdapter == null) {
            return;
        }
        if (getCommentCount() == 0) {
            commentAdapter.showEmpty();
        } else if (commentAdapter.getItemCount() <= 1 || !commentAdapter.isEmpty()) {
        } else {
            commentAdapter.hideEmpty();
        }
    }

    public final void clearComments$Inspire_marketGoogleRelease() {
        us.pinguo.user.recycler.c cVar;
        us.pinguo.user.recycler.c cVar2 = this.adapter;
        Integer valueOf = cVar2 == null ? null : Integer.valueOf(cVar2.getItemCount());
        s.e(valueOf);
        if (valueOf.intValue() <= 0 || (cVar = this.adapter) == null) {
            return;
        }
        cVar.clear();
    }

    @Override // us.pinguo.inspire.module.comment.IInfoCommentLayout
    public void deleteComment(InspireComment comment) {
        s.h(comment, "comment");
        us.pinguo.user.recycler.c cVar = this.adapter;
        if (cVar == null) {
            return;
        }
        int i2 = 0;
        s.e(cVar);
        int itemCount = cVar.getItemCount();
        while (i2 < itemCount) {
            int i3 = i2 + 1;
            us.pinguo.user.recycler.c cVar2 = this.adapter;
            s.e(cVar2);
            us.pinguo.widget.common.cell.recycler.b item = cVar2.getItem(i2);
            s.e(item);
            if (item.getData() == comment) {
                us.pinguo.user.recycler.c cVar3 = this.adapter;
                s.e(cVar3);
                cVar3.remove(i2);
                us.pinguo.user.recycler.c cVar4 = this.adapter;
                s.e(cVar4);
                if (cVar4.getItemCount() == 0) {
                    us.pinguo.user.recycler.c cVar5 = this.adapter;
                    s.e(cVar5);
                    cVar5.showEmpty();
                    return;
                }
                return;
            }
            i2 = i3;
        }
    }

    public final us.pinguo.user.recycler.c getAdapter() {
        return this.adapter;
    }

    @Override // us.pinguo.inspire.module.comment.IInfoCommentLayout
    public us.pinguo.user.recycler.c getCommentAdapter() {
        return this.adapter;
    }

    public final GestureDetector getDetector() {
        GestureDetector gestureDetector = this.detector;
        if (gestureDetector != null) {
            return gestureDetector;
        }
        s.z("detector");
        throw null;
    }

    public final OnInfoCommentListener getOnInfoCommentListener() {
        return this.onInfoCommentListener;
    }

    public final CommentRecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void hideCommentLayout$Inspire_marketGoogleRelease() {
        int i2 = R.id.info_comment_layout;
        InfoCommentLayout infoCommentLayout = (InfoCommentLayout) _$_findCachedViewById(i2);
        boolean z = false;
        if (infoCommentLayout != null && infoCommentLayout.getVisibility() == 0) {
            z = true;
        }
        if (z) {
            ((InfoCommentLayout) _$_findCachedViewById(i2)).animate().translationY(((InfoCommentLayout) _$_findCachedViewById(i2)).getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.info_comment_trans)).setListener(new us.pinguo.ui.widget.j() { // from class: us.pinguo.inspire.module.comment.widget.InfoCommentLayout$hideCommentLayout$1
                @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    InfoCommentLayout infoCommentLayout2 = (InfoCommentLayout) InfoCommentLayout.this._$_findCachedViewById(R.id.info_comment_layout);
                    if (infoCommentLayout2 == null) {
                        return;
                    }
                    infoCommentLayout2.setVisibility(8);
                }
            }).alpha(0.0f).setDuration(InfoBottomLayout.Companion.getDURATION()).start();
        }
    }

    public final void hideCommentLoading() {
        ((ProgressWheel) _$_findCachedViewById(R.id.info_recycler_progress)).setVisibility(8);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setDetector(new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: us.pinguo.inspire.module.comment.widget.InfoCommentLayout$onFinishInflate$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                boolean canScrollVertically = ((CommentRecyclerView) InfoCommentLayout.this._$_findCachedViewById(R.id.info_recycler)).canScrollVertically(-1);
                if (f3 > 100.0f && !canScrollVertically) {
                    ((InfoBottomLayout) InfoCommentLayout.this.getRootView().findViewById(vStudio.Android.Camera360.R.id.info_bottom_layout)).onBackPressed();
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
        }));
        ((CommentRecyclerView) _$_findCachedViewById(R.id.info_recycler)).setOnTouchListener(new View.OnTouchListener() { // from class: us.pinguo.inspire.module.comment.widget.InfoCommentLayout$onFinishInflate$2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return InfoCommentLayout.this.getDetector().onTouchEvent(motionEvent);
            }
        });
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        CommentRecyclerView commentRecyclerView;
        if (!(view != null && view.getId() == vStudio.Android.Camera360.R.id.info_bottom_chat_layout) || (commentRecyclerView = this.recyclerView) == null) {
            return;
        }
        commentRecyclerView.setPadding(0, 0, 0, i5 - i3);
    }

    public final void setAdapter(us.pinguo.user.recycler.c cVar) {
        this.adapter = cVar;
    }

    public final void setComments(List<CommentItemCell> cells) {
        s.h(cells, "cells");
        us.pinguo.user.recycler.c cVar = this.adapter;
        if (cVar == null) {
            return;
        }
        cVar.beginChange();
        cVar.set(cells);
        checkShowEmpty();
        cVar.endChange(true);
    }

    public final void setDetector(GestureDetector gestureDetector) {
        s.h(gestureDetector, "<set-?>");
        this.detector = gestureDetector;
    }

    public final void setOnInfoCommentListener(OnInfoCommentListener onInfoCommentListener) {
        this.onInfoCommentListener = onInfoCommentListener;
    }

    public final void setRecyclerView(CommentRecyclerView commentRecyclerView) {
        this.recyclerView = commentRecyclerView;
    }

    public final void showComment$Inspire_marketGoogleRelease(int i2) {
        ((ProgressWheel) _$_findCachedViewById(R.id.info_recycler_progress)).setVisibility(0);
        if (this.recyclerView == null) {
            CommentRecyclerView commentRecyclerView = (CommentRecyclerView) _$_findCachedViewById(R.id.info_recycler);
            this.recyclerView = commentRecyclerView;
            s.e(commentRecyclerView);
            Context context = getContext();
            s.g(context, "context");
            commentRecyclerView.setLayoutManager(new MaxHeightLayoutManager(context));
            CommentRecyclerView commentRecyclerView2 = this.recyclerView;
            s.e(commentRecyclerView2);
            commentRecyclerView2.setItemAnimator(new DefaultItemAnimator());
            us.pinguo.user.recycler.c cVar = new us.pinguo.user.recycler.c();
            this.adapter = cVar;
            s.e(cVar);
            cVar.setFooterCell(new CommentFooterCell(null));
            us.pinguo.user.recycler.c cVar2 = this.adapter;
            s.e(cVar2);
            cVar2.setNoMoreCell(new CommentNoMoreCell(null));
            CommentRecyclerView commentRecyclerView3 = this.recyclerView;
            s.e(commentRecyclerView3);
            commentRecyclerView3.setAdapter(this.adapter);
            CommentRecyclerView commentRecyclerView4 = this.recyclerView;
            s.e(commentRecyclerView4);
            commentRecyclerView4.addOnScrollListener(this.onScrollListener);
        }
        int i3 = R.id.info_comment_layout;
        ((InfoCommentLayout) _$_findCachedViewById(i3)).setAlpha(0.0f);
        ((InfoCommentLayout) _$_findCachedViewById(i3)).setTranslationY(getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.info_comment_trans));
        ((InfoCommentLayout) _$_findCachedViewById(i3)).setVisibility(0);
        ((InfoCommentLayout) _$_findCachedViewById(i3)).animate().alpha(1.0f).translationY(0.0f).setDuration(InfoBottomLayout.Companion.getDURATION()).setListener(null).start();
        updateCommentNum(Integer.valueOf(i2));
    }

    public final void updateCommentNum(Integer num) {
        String string = getResources().getString(vStudio.Android.Camera360.R.string.msg_comment);
        x xVar = x.a;
        String format = String.format(" (%d)", Arrays.copyOf(new Object[]{num}, 1));
        s.g(format, "format(format, *args)");
        ((TextView) _$_findCachedViewById(R.id.info_comment_title)).setText(s.q(string, format));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoCommentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        this.PRELOAD_SIZE = 5;
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.comment.widget.InfoCommentLayout$onScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                s.h(recyclerView, "recyclerView");
                if (i3 == 0 && i2 == 0) {
                    return;
                }
                InfoCommentLayout.this.checkLoadMore();
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoCommentLayout(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        this.PRELOAD_SIZE = 5;
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.comment.widget.InfoCommentLayout$onScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i22, int i3) {
                s.h(recyclerView, "recyclerView");
                if (i3 == 0 && i22 == 0) {
                    return;
                }
                InfoCommentLayout.this.checkLoadMore();
            }
        };
    }
}
