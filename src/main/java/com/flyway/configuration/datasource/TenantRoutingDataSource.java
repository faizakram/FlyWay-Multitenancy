package com.flyway.configuration.datasource;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.flyway.configuration.web.ThreadTenantStorage;


public class TenantRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ThreadTenantStorage.getTenantId();
    }
}
