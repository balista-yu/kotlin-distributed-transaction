package com.sample.transaction.infrastructure.db

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("spring.datasource")
data class DataSourceProperties(
    val first: DbConfig,
    val second: DbConfig,
) {
    data class DbConfig(
        val jdbcUrl: String,
        val username: String,
        val password: String,
    )
}
