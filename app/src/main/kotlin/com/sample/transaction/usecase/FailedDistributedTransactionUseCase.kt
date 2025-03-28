package com.sample.transaction.usecase

import com.sample.transaction.core.domain.repository.FailedDistributedTransactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FailedDistributedTransactionUseCase(
    private val repository: FailedDistributedTransactionRepository,
) {
    operator fun invoke() {
        repository.register()
    }
}
