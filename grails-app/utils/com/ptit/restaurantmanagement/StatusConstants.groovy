package com.ptit.restaurantmanagement

/**
 * Created by pham on 25-Sep-2016.
 */
class StatusConstants {
    interface Menu {
        static final boolean READY = true
        static final boolean NOT_READY = false
    }

    interface Table {
        static final int READY = 1
        static final int NOT_READY = 0
        static final int BOOKING = 2
        static final int SERVING = 3
        static final int AWAIT_PAYMENT = 4

    }

    interface OrderMenu {
        static final boolean PROCESSING = false;
        static final boolean COMPLETED = true;
    }

    interface Bill {
        static final boolean NOT_PAYMENT = false;
        static final boolean COMPLETED = true;
    }
}
