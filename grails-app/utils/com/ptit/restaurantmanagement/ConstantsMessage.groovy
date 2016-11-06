package com.ptit.restaurantmanagement
/**
 * Created by pham on 20-Sep-2016.
 */
class ConstantsMessage {
    static final int ERROR = 1
    static final int SUCCESS = 2
    interface AccountError {
        static final int USERNAME_EXISTED = 101
        static final int WRONG_PASSWORD = 102
        static final int ACCOUNT_NOT_EXISTED = 103
    }

    interface MenuError {
    }


}
