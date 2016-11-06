package restaurant_managent

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        "/menu"(controller: 'menu'){
            action = [PUT:'createMenu',GET:'getAllMenu']
        }

        "/menu/$id"(controller: 'menu'){
            action = [GET:'getMenuById',DELETE:'deleteMenu',POST:'editMenuById']
        }

        "/table/"(controller: 'table'){
            action = [GET:'getAllTable',PUT: 'addTable',DELETE: 'deleteTable']
        }

        "/table/booking/$id"(controller: 'table'){
            action = [POST: 'bookTable']
        }

        "/table/serving/$id"(controller: 'table'){
            action = [POST: 'servingTable']
        }

        "/table/manage/$id"(controller: 'table'){
            action = [POST: 'setTableStatus']
        }
    }
}
