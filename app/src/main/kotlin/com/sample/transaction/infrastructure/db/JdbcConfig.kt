package com.sample.transaction.infrastructure.db

import com.atomikos.jdbc.AtomikosDataSourceBean
import org.postgresql.xa.PGXADataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@EnableConfigurationProperties(DataSourceProperties::class)
class JdbcConfig(private val dataSourceProperties: DataSourceProperties) {
    @Bean("firstDataSource1")
    @ConfigurationProperties("spring.datasource.first")
    fun createFirstDataSource1(): DataSource = DataSourceBuilder.create().build()

    @Bean("secondDataSource1")
    @ConfigurationProperties("spring.datasource.second")
    fun createSecondDataSource1(): DataSource = DataSourceBuilder.create().build()

    @Bean("firstDataSource2")
    fun createFirstDataSource2(): DataSource {
        return createXADataSource(
            "firstDataSource",
            dataSourceProperties.first.jdbcUrl,
            dataSourceProperties.first.username,
            dataSourceProperties.first.password,
        )
    }

    @Bean("secondDataSource2")
    fun createSecondDataSource2(): DataSource {
        return createXADataSource(
            "secondDataSource",
            dataSourceProperties.second.jdbcUrl,
            dataSourceProperties.second.username,
            dataSourceProperties.second.password,
        )
    }

    private fun createXADataSource(resourceName: String, url: String, user: String, password: String): DataSource {
        val pgxaDataSource = PGXADataSource().apply {
            setUrl(url)
            this.user = user
            this.password = password
        }

        return AtomikosDataSourceBean().apply {
            uniqueResourceName = resourceName
            xaDataSource = pgxaDataSource
        }
    }
}
