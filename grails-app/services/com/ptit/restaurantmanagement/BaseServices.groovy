package com.ptit.restaurantmanagement


/**
 * Created by pham on 23-Sep-2016.
 */
class BaseServices {
    def copyProperties(source, target) {
        def (sProps, tProps) = [source, target]*.properties*.keySet()
        def commonProps = sProps.intersect(tProps) - ['class', 'metaClass','id']
        commonProps.each { target[it] = source[it] }
    }

}
