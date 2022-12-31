package us.pinguo.inspire.module.feeds.cell;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;
import us.pinguo.inspire.module.contact.ContactActivity;
import us.pinguo.inspire.module.contact.entry.Recommend;
import us.pinguo.inspire.module.feeds.model.FeedsFollowManager;
import us.pinguo.inspire.module.profile.cell.ProfileHeaderCell;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsInterestCell extends us.pinguo.widget.common.cell.recycler.b<List<Recommend>, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener, us.pinguo.user.recycler.a {
    private static final int SHOW_COUNT = 3;
    private us.pinguo.widget.common.cell.recycler.a mAdapter;
    private boolean mDeleteMode;
    private boolean mInProfile;
    private ProfileHeaderCell mOnCloseListener;
    private RecyclerView mParentRecyclerView;
    private List<Recommend> mShowList;
    private boolean mToLeft;
    private List<Recommend> mWaitList1;
    private List<Recommend> mWaitList2;
    private List<Recommend> mWaitList3;

    /* loaded from: classes9.dex */
    private class InterestAnimator extends SimpleItemAnimator {
        private static final int DURATION = 600;
        private Interpolator mInterpolator;
        private List<RecyclerView.ViewHolder> mRunningList;

        private InterestAnimator() {
            this.mRunningList = new LinkedList();
            this.mInterpolator = new AccelerateDecelerateInterpolator();
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public boolean animateAdd(final RecyclerView.ViewHolder viewHolder) {
            this.mRunningList.add(viewHolder);
            ViewCompat.setTranslationX(viewHolder.itemView, FeedsInterestCell.this.mToLeft ? viewHolder.itemView.getWidth() : -viewHolder.itemView.getWidth());
            ViewCompat.animate(viewHolder.itemView).setInterpolator(this.mInterpolator).translationX(0.0f).setDuration(600L).setListener(new ViewPropertyAnimatorListener() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsInterestCell.InterestAnimator.4
                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationCancel(View view) {
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view) {
                    InterestAnimator.this.dispatchAddFinished(viewHolder);
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view) {
                    InterestAnimator.this.dispatchAddStarting(viewHolder);
                }
            }).start();
            return true;
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
            return false;
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public boolean animateMove(final RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
            this.mRunningList.add(viewHolder);
            ViewCompat.setTranslationY(viewHolder.itemView, i3 - i5);
            ViewCompat.animate(viewHolder.itemView).setInterpolator(this.mInterpolator).translationY(0.0f).setDuration(600L).setListener(new ViewPropertyAnimatorListener() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsInterestCell.InterestAnimator.5
                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationCancel(View view) {
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view) {
                    InterestAnimator.this.dispatchMoveFinished(viewHolder);
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view) {
                    InterestAnimator.this.dispatchMoveStarting(viewHolder);
                }
            }).start();
            return true;
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public boolean animateRemove(final RecyclerView.ViewHolder viewHolder) {
            this.mRunningList.add(viewHolder);
            if (FeedsInterestCell.this.mDeleteMode) {
                final RecyclerView recyclerView = (RecyclerView) viewHolder.itemView.getParent();
                final int height = recyclerView.getHeight();
                final int dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(R.dimen.feeds_interest_item_height);
                ValueAnimator ofInt = ValueAnimator.ofInt(height, recyclerView.getHeight() - dimensionPixelSize);
                ofInt.setDuration(600L);
                ofInt.setInterpolator(this.mInterpolator);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsInterestCell.InterestAnimator.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        recyclerView.setLayoutParams(layoutParams);
                        float intValue = (height - ((Integer) valueAnimator.getAnimatedValue()).intValue()) / dimensionPixelSize;
                        ViewGroup.LayoutParams layoutParams2 = viewHolder.itemView.getLayoutParams();
                        layoutParams2.height = (int) (dimensionPixelSize * intValue);
                        viewHolder.itemView.setAlpha(1.0f - intValue);
                        viewHolder.itemView.setLayoutParams(layoutParams2);
                    }
                });
                ofInt.addListener(new Animator.AnimatorListener() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsInterestCell.InterestAnimator.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (recyclerView.getAdapter().getItemCount() == 0) {
                            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                            layoutParams.height = 0;
                            recyclerView.setLayoutParams(layoutParams);
                        }
                        InterestAnimator.this.dispatchRemoveFinished(viewHolder);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        InterestAnimator.this.dispatchRemoveStarting(viewHolder);
                    }
                });
                ofInt.start();
                return true;
            }
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = new ViewPropertyAnimatorListener() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsInterestCell.InterestAnimator.3
                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationCancel(View view) {
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view) {
                    InterestAnimator.this.dispatchRemoveFinished(viewHolder);
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view) {
                    InterestAnimator.this.dispatchRemoveStarting(viewHolder);
                }
            };
            ViewPropertyAnimatorCompat interpolator = ViewCompat.animate(viewHolder.itemView).setInterpolator(this.mInterpolator);
            boolean z = FeedsInterestCell.this.mToLeft;
            int width = viewHolder.itemView.getWidth();
            if (z) {
                width = -width;
            }
            interpolator.translationX(width).alpha(0.0f).setListener(viewPropertyAnimatorListener).setDuration(600L).start();
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public void endAnimations() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public boolean isRunning() {
            return this.mRunningList.size() > 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public void onAnimationFinished(RecyclerView.ViewHolder viewHolder) {
            super.onAnimationFinished(viewHolder);
            if (this.mRunningList.contains(viewHolder)) {
                this.mRunningList.remove(viewHolder);
                viewHolder.itemView.setTranslationX(0.0f);
                viewHolder.itemView.setTranslationY(0.0f);
                viewHolder.itemView.setAlpha(1.0f);
                viewHolder.itemView.setScaleY(1.0f);
                if (((RecyclerView) viewHolder.itemView.getParent()).getLayoutParams().height == 0) {
                    FeedsInterestCell.this.closeCell(viewHolder.itemView);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public void runPendingAnimations() {
        }
    }

    /* loaded from: classes9.dex */
    private class InterestItemCell extends us.pinguo.inspire.cell.recycler.e<Recommend, us.pinguo.widget.common.cell.recycler.c> implements us.pinguo.foundation.base.c, View.OnClickListener {
        public InterestItemCell(Recommend recommend) {
            super(recommend);
        }

        private Recommend getNextRecomment(int i2) {
            if (i2 != 1 || FeedsInterestCell.this.mWaitList1.size() <= 0) {
                if (i2 != 2 || FeedsInterestCell.this.mWaitList2.size() <= 0) {
                    if (i2 != 3 || FeedsInterestCell.this.mWaitList3.size() <= 0) {
                        return null;
                    }
                    return (Recommend) FeedsInterestCell.this.mWaitList3.remove(0);
                }
                return (Recommend) FeedsInterestCell.this.mWaitList2.remove(0);
            }
            return (Recommend) FeedsInterestCell.this.mWaitList1.remove(0);
        }

        @Override // us.pinguo.inspire.cell.recycler.e, us.pinguo.foundation.base.c
        public void addSubscription(Subscription subscription) {
            super.addSubscription(subscription);
        }

        @Override // us.pinguo.widget.common.cell.recycler.b
        public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
            return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feeds_interested_child_layout, viewGroup, false));
        }

        @Override // us.pinguo.widget.common.cell.recycler.b
        public int getType() {
            return 0;
        }

        @Override // us.pinguo.widget.common.cell.recycler.b
        protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
            cVar.itemView.setTag(this.mData);
            PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.feeds_interested_avatar);
            T t = this.mData;
            portraitImageView.setUserId(((Recommend) t).user == null ? "" : ((Recommend) t).user.userId);
            T t2 = this.mData;
            portraitImageView.setUserType(((Recommend) t2).user == null ? 0 : ((Recommend) t2).user.type);
            T t3 = this.mData;
            portraitImageView.setMark(((Recommend) t3).user == null ? 0 : ((Recommend) t3).user.mark);
            T t4 = this.mData;
            portraitImageView.setImageUri(((Recommend) t4).user == null ? "" : ((Recommend) t4).user.avatar, us.pinguo.ui.R.drawable.default_avatar);
            T t5 = this.mData;
            String str = ((Recommend) t5).user == null ? "" : ((Recommend) t5).user.nickname;
            if (str == null) {
                str = "";
            }
            cVar.setText(R.id.feeds_interested_name, str);
            T t6 = this.mData;
            String str2 = ((Recommend) t6).from == null ? "" : ((Recommend) t6).from;
            if (TextUtils.isEmpty(str2)) {
                cVar.setVisible(R.id.feeds_interested_desc, 8);
            } else {
                cVar.setText(R.id.feeds_interested_desc, str2);
                cVar.setVisible(R.id.feeds_interested_desc, 0);
            }
            View view = cVar.getView(R.id.feeds_interested_close);
            view.setTag(cVar);
            view.setOnClickListener(this);
            T t7 = this.mData;
            String str3 = ((Recommend) t7).user != null ? ((Recommend) t7).user.userId : "";
            AttentionButton attentionButton = (AttentionButton) cVar.getView(R.id.feeds_interested_relation);
            attentionButton.k(((Recommend) this.mData).user, false, str3, this);
            attentionButton.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            int adapterPosition;
            if (view.getId() == R.id.feeds_interested_relation) {
                AttentionButton attentionButton = (AttentionButton) view;
                attentionButton.onClick(view);
                attentionButton.setOnAnimFinishListener(new AttentionButton.j() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsInterestCell.InterestItemCell.1
                    @Override // us.pinguo.inspire.widget.AttentionButton.j
                    public void onAnimFinish() {
                        InterestItemCell.this.onClick(((View) view.getParent()).findViewById(R.id.feeds_interested_close));
                        FeedsInterestCell.this.mToLeft = false;
                    }
                });
            } else if (view.getId() != R.id.feeds_interested_close || (adapterPosition = ((us.pinguo.widget.common.cell.recycler.c) view.getTag()).getAdapterPosition()) == -1) {
            } else {
                Recommend nextRecomment = getNextRecomment(((Recommend) this.mAdapter.getItem(adapterPosition).getData()).pos);
                if (nextRecomment != null) {
                    FeedsInterestCell.this.mToLeft = true;
                    FeedsInterestCell.this.mDeleteMode = false;
                    InterestItemCell interestItemCell = new InterestItemCell(nextRecomment);
                    this.mAdapter.remove(adapterPosition);
                    this.mAdapter.add(adapterPosition, interestItemCell);
                    FeedsInterestCell.this.mShowList.remove(adapterPosition);
                    FeedsInterestCell.this.mShowList.add(adapterPosition, nextRecomment);
                    return;
                }
                FeedsInterestCell.this.mDeleteMode = true;
                this.mAdapter.remove(adapterPosition);
                FeedsInterestCell.this.mShowList.remove(adapterPosition);
            }
        }

        @Override // us.pinguo.widget.common.cell.recycler.b, us.pinguo.widget.common.cell.recycler.c.a
        public void onViewRecycled() {
            View view;
            VH vh = this.mViewHolder;
            if (vh != 0 && (view = vh.itemView) != null) {
                view.setTag(null);
            }
            super.onViewRecycled();
        }
    }

    public FeedsInterestCell(List<Recommend> list) {
        super(list == null ? new ArrayList<>() : list);
        this.mShowList = new ArrayList();
        this.mWaitList1 = new ArrayList();
        this.mWaitList2 = new ArrayList();
        this.mWaitList3 = new ArrayList();
        this.mDeleteMode = false;
        this.mToLeft = true;
        this.mAdapter = new us.pinguo.widget.common.cell.recycler.a();
        for (Recommend recommend : list) {
            if (recommend != null) {
                int i2 = recommend.pos;
                if (i2 == 1) {
                    this.mWaitList1.add(recommend);
                } else if (i2 == 2) {
                    this.mWaitList2.add(recommend);
                } else {
                    this.mWaitList3.add(recommend);
                }
            }
        }
        if (this.mWaitList1.size() > 0) {
            this.mShowList.add(this.mWaitList1.remove(0));
        }
        if (this.mWaitList2.size() > 0) {
            this.mShowList.add(this.mWaitList2.remove(0));
        }
        if (this.mWaitList3.size() > 0) {
            this.mShowList.add(this.mWaitList3.remove(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeCell(View view) {
        if (this.mInProfile) {
            VH vh = this.mViewHolder;
            if (vh != 0) {
                vh.itemView.setVisibility(8);
            }
            ProfileHeaderCell profileHeaderCell = this.mOnCloseListener;
            if (profileHeaderCell != null) {
                profileHeaderCell.onInterestClose();
                return;
            }
            return;
        }
        RecyclerView parentRecyclerView = getParentRecyclerView(view);
        if (parentRecyclerView == null || !(parentRecyclerView.getAdapter() instanceof us.pinguo.widget.common.cell.recycler.a)) {
            return;
        }
        ((us.pinguo.widget.common.cell.recycler.a) parentRecyclerView.getAdapter()).remove((us.pinguo.widget.common.cell.recycler.a) this);
        FeedsFollowManager.setRecClosed();
    }

    private RecyclerView getParentRecyclerView(View view) {
        if (this.mParentRecyclerView == null) {
            this.mParentRecyclerView = getParentRecyclerViewImpl(view);
        }
        return this.mParentRecyclerView;
    }

    private RecyclerView getParentRecyclerViewImpl(View view) {
        View view2 = (View) view.getParent();
        while (view2 != null && !(view2 instanceof RecyclerView)) {
            view2 = (View) view2.getParent();
        }
        if (view2 instanceof RecyclerView) {
            return (RecyclerView) view2;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [VH extends us.pinguo.widget.common.cell.recycler.c, us.pinguo.widget.common.cell.recycler.c] */
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(View view) {
        ((RecyclerView) view.findViewById(R.id.feeds_interested_recyclerview)).setLayoutManager(new LinearLayoutManager(view.getContext()));
        ?? cVar = new us.pinguo.widget.common.cell.recycler.c(view);
        this.mViewHolder = cVar;
        this.mInProfile = true;
        return cVar;
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        return false;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 16;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        int dimensionPixelSize = cVar.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.feeds_interest_item_height) * this.mShowList.size();
        RecyclerView recyclerView = (RecyclerView) cVar.getView(R.id.feeds_interested_recyclerview);
        recyclerView.setLayoutParams(new LinearLayout.LayoutParams(-1, dimensionPixelSize));
        recyclerView.setItemAnimator(new InterestAnimator());
        ArrayList arrayList = new ArrayList(this.mShowList.size());
        for (Recommend recommend : this.mShowList) {
            arrayList.add(new InterestItemCell(recommend));
        }
        this.mAdapter.set(arrayList);
        recyclerView.setAdapter(this.mAdapter);
        cVar.setOnClickListener(R.id.feeds_interested_close_all, this);
        cVar.setOnClickListener(R.id.feeds_interested_bottom_layout, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.feeds_interested_close_all) {
            closeCell(view);
        } else if (view.getId() == R.id.feeds_interested_bottom_layout) {
            view.getContext().startActivity(new Intent(view.getContext(), ContactActivity.class));
        }
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        return false;
    }

    public void setOnCloseListener(ProfileHeaderCell profileHeaderCell) {
        this.mOnCloseListener = profileHeaderCell;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        this.mParentRecyclerView = (RecyclerView) viewGroup;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feeds_interested_layout, viewGroup, false);
        ((RecyclerView) inflate.findViewById(R.id.feeds_interested_recyclerview)).setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
        this.mInProfile = false;
        return new us.pinguo.widget.common.cell.recycler.c(inflate);
    }
}
