package com.sample.transaction.infrastructure.db

import com.atomikos.jdbc.AtomikosDataSourceBean
import org.postgresql.xa.PGXADataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class JdbcConfig {
    @Bean("firstDataSource1")
    @ConfigurationProperties("spring.datasource.first")
    fun createFirstDataSource1(): DataSource = DataSourceBuilder.create().build()

    @Bean("secondDataSource1")
    @ConfigurationProperties("spring.datasource.second")
    fun createSecondDataSource1(): DataSource = DataSourceBuilder.create().build()

    @Bean("firstDataSource2")
    @ConfigurationProperties("spring.datasource.first")
    fun createFirstDataSource2(): DataSource {
        val xaDataSource = PGXADataSource()
        xaDataSource.setUrl("jdbc:postgresql://db:5432/first_db")
        xaDataSource.user = "test"
        xaDataSource.password = "test"

        val dataSource = AtomikosDataSourceBean()
        dataSource.uniqueResourceName = "firstDataSource"
        dataSource.xaDataSource = xaDataSource
        return dataSource
    }

    @Bean("secondDataSource2")
    @ConfigurationProperties("spring.datasource.second")
    fun createSecondDataSource2(): DataSource {
        val xaDataSource = PGXADataSource()
        xaDataSource.setUrl("jdbc:postgresql://db:5432/second_db")
        xaDataSource.user = "test"
        xaDataSource.password = "test"

        val dataSource = AtomikosDataSourceBean()
        dataSource.uniqueResourceName = "secondDataSource"
        dataSource.xaDataSource = xaDataSource
        return dataSource
    }
}
