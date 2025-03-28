package com.sample.transaction.usecase

import com.sample.transaction.core.domain.repository.FailedNotDistributedTransactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FailedNotDistributedTransactionUseCase(
    private val repository: FailedNotDistributedTransactionRepository,
) {
    operator fun invoke() {
        repository.register()
    }
}
