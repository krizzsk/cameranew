package com.growingio.android.sdk.heatmap;

import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.base.event.HeatMapEvent;
import com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
/* loaded from: classes2.dex */
public class HeatMapSubscriber implements Subscriber {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.growingio.android.sdk.heatmap.HeatMapSubscriber$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE;
        static final /* synthetic */ int[] $SwitchMap$com$growingio$android$sdk$base$event$HeatMapEvent$EVENT_TYPE;
        static final /* synthetic */ int[] $SwitchMap$com$growingio$android$sdk$base$event$ViewTreeStatusChangeEvent$StatusType;

        static {
            int[] iArr = new int[HeatMapEvent.EVENT_TYPE.values().length];
            $SwitchMap$com$growingio$android$sdk$base$event$HeatMapEvent$EVENT_TYPE = iArr;
            try {
                iArr[HeatMapEvent.EVENT_TYPE.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$HeatMapEvent$EVENT_TYPE[HeatMapEvent.EVENT_TYPE.STATE_ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$HeatMapEvent$EVENT_TYPE[HeatMapEvent.EVENT_TYPE.STATE_OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$HeatMapEvent$EVENT_TYPE[HeatMapEvent.EVENT_TYPE.HIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$HeatMapEvent$EVENT_TYPE[HeatMapEvent.EVENT_TYPE.SHOW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$HeatMapEvent$EVENT_TYPE[HeatMapEvent.EVENT_TYPE.UPDATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[ActivityLifecycleEvent.EVENT_TYPE.values().length];
            $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE = iArr2;
            try {
                iArr2[ActivityLifecycleEvent.EVENT_TYPE.ON_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_NEW_INTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr3 = new int[ViewTreeStatusChangeEvent.StatusType.values().length];
            $SwitchMap$com$growingio$android$sdk$base$event$ViewTreeStatusChangeEvent$StatusType = iArr3;
            try {
                iArr3[ViewTreeStatusChangeEvent.StatusType.FocusChanged.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ViewTreeStatusChangeEvent$StatusType[ViewTreeStatusChangeEvent.StatusType.LayoutChanged.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ViewTreeStatusChangeEvent$StatusType[ViewTreeStatusChangeEvent.StatusType.ScrollChanged.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onActivityLifeCycleChange(com.growingio.android.sdk.base.event.ActivityLifecycleEvent")) {
            onActivityLifeCycleChange((ActivityLifecycleEvent) obj);
        } else if (str.equals("#onViewTreeChange(com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent")) {
            onViewTreeChange((ViewTreeStatusChangeEvent) obj);
        } else if (str.equals("#onHeatMapEvent(com.growingio.android.sdk.base.event.HeatMapEvent")) {
            onHeatMapEvent((HeatMapEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.POSTING;
        return new SubscriberMethod[]{new SubscriberMethod("onActivityLifeCycleChange", ActivityLifecycleEvent.class, "#onActivityLifeCycleChange(com.growingio.android.sdk.base.event.ActivityLifecycleEvent", threadMode, 0, false), new SubscriberMethod("onViewTreeChange", ViewTreeStatusChangeEvent.class, "#onViewTreeChange(com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent", threadMode, 0, false), new SubscriberMethod("onHeatMapEvent", HeatMapEvent.class, "#onHeatMapEvent(com.growingio.android.sdk.base.event.HeatMapEvent", threadMode, 0, false)};
    }

    @Subscribe
    public void onActivityLifeCycleChange(ActivityLifecycleEvent activityLifecycleEvent) {
        int i2 = AnonymousClass1.$SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[activityLifecycleEvent.event_type.ordinal()];
    }

    @Subscribe
    public void onHeatMapEvent(HeatMapEvent heatMapEvent) {
        switch (AnonymousClass1.$SwitchMap$com$growingio$android$sdk$base$event$HeatMapEvent$EVENT_TYPE[heatMapEvent.type.ordinal()]) {
            case 1:
                HeatMapManager.getInstance().initHeatMapView();
                return;
            case 2:
                HeatMapManager.getInstance().setHeatMapState(true);
                return;
            case 3:
                HeatMapManager.getInstance().setHeatMapState(false);
                return;
            case 4:
                if (HeatMapManager.getInstance().isHeatMapOn()) {
                    HeatMapManager.getInstance().hideHeatMapView();
                    return;
                }
                return;
            case 5:
                if (HeatMapManager.getInstance().isHeatMapOn()) {
                    HeatMapManager.getInstance().showHeatMapView();
                    return;
                }
                return;
            case 6:
                HeatMapManager heatMapManager = HeatMapManager.getInstance();
                if (heatMapManager == null || !heatMapManager.isHeatMapOn()) {
                    return;
                }
                heatMapManager.getHeatMapData();
                heatMapManager.showHeatMapView();
                return;
            default:
                return;
        }
    }

    @Subscribe
    public void onViewTreeChange(ViewTreeStatusChangeEvent viewTreeStatusChangeEvent) {
        int i2 = AnonymousClass1.$SwitchMap$com$growingio$android$sdk$base$event$ViewTreeStatusChangeEvent$StatusType[viewTreeStatusChangeEvent.getStatusType().ordinal()];
        if (i2 == 2) {
            HeatMapManager.getInstance().traverseNodeImmediately();
        } else if (i2 != 3) {
        } else {
            HeatMapManager.getInstance().traverseNodeImmediately();
        }
    }
}
