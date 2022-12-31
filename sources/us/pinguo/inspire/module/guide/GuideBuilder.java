package us.pinguo.inspire.module.guide;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class GuideBuilder {
    private boolean mBuilt;
    private List<Component> mComponents = new ArrayList();
    private Configuration mConfiguration = new Configuration();
    private OnVisibilityChangedListener mOnVisibilityChangedListener;

    /* loaded from: classes9.dex */
    public interface OnVisibilityChangedListener {
        void onDismiss();

        void onShown();
    }

    public GuideBuilder addComponent(Component component) {
        if (!this.mBuilt) {
            this.mComponents.add(component);
            return this;
        }
        throw new RuntimeException("Already created, rebuild a new one.");
    }

    public Guide createGuide() {
        Guide guide = new Guide();
        guide.setComponents((Component[]) this.mComponents.toArray(new Component[this.mComponents.size()]));
        guide.setConfiguration(this.mConfiguration);
        guide.setCallback(this.mOnVisibilityChangedListener);
        this.mComponents = null;
        this.mConfiguration = null;
        this.mOnVisibilityChangedListener = null;
        this.mBuilt = true;
        return guide;
    }

    public GuideBuilder getHighTargetGraphStyle(int i2) {
        if (!this.mBuilt) {
            this.mConfiguration.mGraphStyle = i2;
            return this;
        }
        throw new RuntimeException("Already created,rebuild a new one");
    }

    public GuideBuilder setAlpha(int i2) {
        if (this.mBuilt) {
            throw new RuntimeException("Already created,rebuild a new one");
        }
        if (i2 >= 0 && i2 <= 255) {
            this.mConfiguration.mAlpha = i2;
            return this;
        }
        throw new RuntimeException("Illegal alpha value,shoule between [0-255]");
    }

    public GuideBuilder setExitAnimationId(int i2) {
        if (this.mBuilt) {
            throw new RuntimeException("Already created. rebuild a new one.");
        }
        if (i2 > 0) {
            this.mConfiguration.mExitAnimationId = i2;
            return this;
        }
        throw new RuntimeException("Illegal animation resource id.");
    }

    public GuideBuilder setFullingViewId(int i2) {
        if (this.mBuilt) {
            throw new RuntimeException("Already created,rebuild a new one");
        }
        if (i2 > 0) {
            this.mConfiguration.mFullingColorId = i2;
            return this;
        }
        throw new RuntimeException("Illegal view id");
    }

    public GuideBuilder setHighTargetCorner(int i2) {
        if (!this.mBuilt) {
            if (i2 < 0) {
                this.mConfiguration.mCorner = i2;
            }
            this.mConfiguration.mCorner = i2;
            return this;
        }
        throw new RuntimeException("Already created,rebuild a new one");
    }

    public GuideBuilder setHighTargetPadding(int i2) {
        if (!this.mBuilt) {
            if (i2 < 0) {
                this.mConfiguration.mPadding = 0;
            }
            this.mConfiguration.mPadding = i2;
            return this;
        }
        throw new RuntimeException("Already created. rebuild a new one.");
    }

    public GuideBuilder setOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        if (!this.mBuilt) {
            this.mOnVisibilityChangedListener = onVisibilityChangedListener;
            return this;
        }
        throw new RuntimeException("Already created, rebuild a new one.");
    }

    public GuideBuilder setOutsideTouchable(boolean z) {
        this.mConfiguration.mOutsideTouchable = z;
        return this;
    }

    public GuideBuilder setOverlayTarget(boolean z) {
        if (!this.mBuilt) {
            this.mConfiguration.mOverlayTarget = z;
            return this;
        }
        throw new RuntimeException("Already created, rebuild a new one.");
    }

    public GuideBuilder setTargetView(View view) {
        if (this.mBuilt) {
            throw new RuntimeException("Already created,rebuild a new one");
        }
        if (view != null) {
            this.mConfiguration.mTargetView = view;
            return this;
        }
        throw new RuntimeException("Illegal view.");
    }
}
