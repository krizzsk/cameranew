package us.pinguo.common.gesture;
/* loaded from: classes4.dex */
public enum GestureEventDispatchOrder {
    ZOOM_LISTENER { // from class: us.pinguo.common.gesture.GestureEventDispatchOrder.1
        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder lastListener() {
            return GestureEventDispatchOrder.SELFIE_ADJUST_LISTENER;
        }

        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder nextListener() {
            return null;
        }
    },
    SELFIE_ADJUST_LISTENER { // from class: us.pinguo.common.gesture.GestureEventDispatchOrder.2
        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder lastListener() {
            return GestureEventDispatchOrder.EFFECT_LISTENER;
        }

        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder nextListener() {
            return GestureEventDispatchOrder.ZOOM_LISTENER;
        }
    },
    EFFECT_LISTENER { // from class: us.pinguo.common.gesture.GestureEventDispatchOrder.3
        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder lastListener() {
            return GestureEventDispatchOrder.CAMERA_LISTENER;
        }

        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder nextListener() {
            return GestureEventDispatchOrder.SELFIE_ADJUST_LISTENER;
        }
    },
    CAMERA_LISTENER { // from class: us.pinguo.common.gesture.GestureEventDispatchOrder.4
        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder lastListener() {
            return GestureEventDispatchOrder.STICKER_SELECT_VIEW_LISTENER;
        }

        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder nextListener() {
            return GestureEventDispatchOrder.EFFECT_LISTENER;
        }
    },
    STICKER_SELECT_VIEW_LISTENER { // from class: us.pinguo.common.gesture.GestureEventDispatchOrder.5
        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder lastListener() {
            return GestureEventDispatchOrder.EFFECT_SELECT_VIEW_LISTENER;
        }

        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder nextListener() {
            return GestureEventDispatchOrder.CAMERA_LISTENER;
        }
    },
    EFFECT_SELECT_VIEW_LISTENER { // from class: us.pinguo.common.gesture.GestureEventDispatchOrder.6
        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder lastListener() {
            return GestureEventDispatchOrder.ADVANCE_LISTENER;
        }

        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder nextListener() {
            return GestureEventDispatchOrder.STICKER_SELECT_VIEW_LISTENER;
        }
    },
    ADVANCE_LISTENER { // from class: us.pinguo.common.gesture.GestureEventDispatchOrder.7
        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder lastListener() {
            return GestureEventDispatchOrder.PREVIEW_SETTING_LISTENER;
        }

        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder nextListener() {
            return GestureEventDispatchOrder.EFFECT_SELECT_VIEW_LISTENER;
        }
    },
    PREVIEW_SETTING_LISTENER { // from class: us.pinguo.common.gesture.GestureEventDispatchOrder.8
        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder lastListener() {
            return null;
        }

        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder nextListener() {
            return GestureEventDispatchOrder.ADVANCE_LISTENER;
        }
    },
    FRAME_SETTING_LISTENER { // from class: us.pinguo.common.gesture.GestureEventDispatchOrder.9
        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder lastListener() {
            return null;
        }

        @Override // us.pinguo.common.gesture.GestureEventDispatchOrder
        public GestureEventDispatchOrder nextListener() {
            return GestureEventDispatchOrder.PREVIEW_SETTING_LISTENER;
        }
    };
    
    protected int mListenerPriority;

    public void generateListenerPriority() {
        if (nextListener() != null) {
            this.mListenerPriority = nextListener().mListenerPriority - 1;
        } else if (lastListener() != null) {
            this.mListenerPriority = nextListener().mListenerPriority + 1;
        } else {
            this.mListenerPriority = 10;
        }
    }

    public abstract GestureEventDispatchOrder lastListener();

    public abstract GestureEventDispatchOrder nextListener();

    GestureEventDispatchOrder() {
        this.mListenerPriority = 0;
        generateListenerPriority();
    }
}
