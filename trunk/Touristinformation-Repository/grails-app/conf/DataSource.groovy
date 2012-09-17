dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
//MySql settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/dbrep?useUnicode=yes&characterEncoding=UTF-8"
            username = "root"
            password = ""
        }
        hibernate {
            show_sql = true
        }
    }
    test {
        dataSource {
            dbCreate = "create" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/dbrep?useUnicode=yes&characterEncoding=UTF-8"
            username = "user"
            password = "pass"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost/dbrep?useUnicode=yes&characterEncoding=UTF-8"
            username = "user"
            password = "pass"
        }
    }
}

