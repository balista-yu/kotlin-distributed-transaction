package com.sample.transaction.infrastructure.repository

import com.sample.transaction.core.domain.repository.NotDistributedTransactionRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import javax.sql.DataSource
import ulid.ULID

@Repository
class NotDistributedTransactionRepositoryImpl(
    @Qualifier("firstDataSource1")
    private val firstDataSource: DataSource,
    @Qualifier("secondDataSource1")
    private val secondDataSource: DataSource,
) : NotDistributedTransactionRepository {
    override fun register() {
        val ulid = ULID.randomULID()

        val firstDBJdbc = NamedParameterJdbcTemplate(firstDataSource)
        val firstDBSql = StringBuilder(
            "INSERT INTO first_table(id) VALUES (:id)",
        )
        val firstDBParams = mutableMapOf<String, Any>()
        firstDBParams["id"] = ulid

        firstDBJdbc.update(firstDBSql.toString(), firstDBParams)

        val secondDBJdbc = NamedParameterJdbcTemplate(secondDataSource)
        val secondDBSql = StringBuilder(
            "INSERT INTO second_table(id) VALUES (:id)",
        )
        val secondDBParams = mutableMapOf<String, Any>()
        secondDBParams["id"] = ulid

        secondDBJdbc.update(secondDBSql.toString(), secondDBParams)
    }
}
