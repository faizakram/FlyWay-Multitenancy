package com.flyway.configuration.datasource;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataSourceConfiguration {

    private final DataSourceProperties dataSourceProperties;

    public DataSourceConfiguration(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource dataSource() {
        TenantRoutingDataSource customDataSource = new TenantRoutingDataSource();
        customDataSource.setTargetDataSources(dataSourceProperties.getDatasources());
        return customDataSource;
    }

    @PostConstruct
    public void migrate() {
        dataSourceProperties
                .getDatasources()
                .values()
                .stream()
                .map(dataSource -> (DataSource) dataSource)
                .forEach(this::migrate);
    }

    private void migrate(DataSource dataSource) {
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
    }
}
