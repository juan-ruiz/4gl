dataSource {
    pooled = true
    driverClassName = "org.apache.derby.jdbc.ClientDriver"
    username = "root"
    password = "root"
    dbCreate = "update"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    
    bees {
  dataSource {
   dbCreate = "create"
   username = "juanseruiz"
   password = "juanseruiz"
   url = "jdbc:cloudbees://PF4GL"
   pooled = true
   properties {
      maxActive = -1
      minEvictableIdleTimeMillis=1800000
      timeBetweenEvictionRunsMillis=1800000
      numTestsPerEvictionRun=3
      testOnBorrow=true
      testWhileIdle=true
      testOnReturn=true
      validationQuery="SELECT 1"
   }
  }
 }
    
    
    
    development {
        dataSource {
            dbCreate = "create" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:derby://localhost:1527/PF_4GL"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
